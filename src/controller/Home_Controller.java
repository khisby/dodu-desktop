/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import App.Config;
import Model.Kategori_Model;
import Model.Pengguna_Model;
import Model.Transaksi_Model;
import data.Kategori;
import data.KategoriHitung;
import data.Pengguna;
import data.Transaksi;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Khisby
 */
public class Home_Controller {
    private Kategori_Model km;
    private Transaksi_Model tm;
    private ArrayList<Kategori> kategori = new ArrayList<Kategori>();
    private ArrayList<Transaksi> transaksi = new ArrayList<Transaksi>();

    public Home_Controller() {
        try{
            if(Config.pengguna == null){
                System.out.println("Anda belum login");
            }else{
                km = new Kategori_Model();
                tm = new Transaksi_Model();
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void viewKategori(JComboBox input) {
        DefaultComboBoxModel modelCbTransaksiKategori = (DefaultComboBoxModel) input.getModel();
        modelCbTransaksiKategori.removeAllElements();
        for(Kategori kat : km.getAllKategori()){
            kategori.add(kat);
            modelCbTransaksiKategori.addElement(kat.getNama_kateogri());
        }
    }
    
    public void viewKategoriByUser(JComboBox input) {
        DefaultComboBoxModel modelCbTransaksiKategori = (DefaultComboBoxModel) input.getModel();
        modelCbTransaksiKategori.removeAllElements();
        for(Kategori kat : km.getAllKategoriByUser(Config.pengguna)){
            kategori.add(kat);
            modelCbTransaksiKategori.addElement(kat.getNama_kateogri());
        }
    }

    public void viewTransaksi(JTable output_tableTransaksi) {
        String kolom[] = {"ID Transaksi", "Kategori", "Jenis Transkasi", "Nominal", "Keterangan", "Waktu"};
        DefaultTableModel modelTableTransaksi = new DefaultTableModel(kolom, 0);
        output_tableTransaksi.setModel(modelTableTransaksi);
        
        for(Transaksi trans : tm.getAllTranskasiByUser(Config.pengguna)){
            this.transaksi.add(trans);
            modelTableTransaksi.addRow(new Object[]{trans.getId(),trans.getKategori().getNama_kateogri(),trans.getJenis_transaksi_toString(),trans.getNominal_transaksi(),trans.getKeterangan_transaksi(),trans.getWaktu_transaksi()});
        }
    }

    public void laporan() {
        ArrayList<KategoriHitung> katHitung = new ArrayList<>();
        
        for(Transaksi trans : tm.getAllTranskasiByUserThisMonth(Config.pengguna)){
            boolean sudahAda = false;
            for (int i = 0; i < katHitung.size(); i++) {
                if(katHitung.get(i).getNama().equals(trans.getKategori().getNama_kateogri())){
                    katHitung.get(i).setJumlah(katHitung.get(i).getJumlah() + trans.getNominal_transaksi());
                    sudahAda = true;
                }
            }
            
            if(sudahAda == false){
                KategoriHitung kat = new KategoriHitung();
                kat.setNama(trans.getKategori().getNama_kateogri());
                kat.setJumlah(trans.getNominal_transaksi());
                katHitung.add(kat);
            }
        }
        
        DefaultPieDataset data = new DefaultPieDataset();
        
        for(KategoriHitung kathit : katHitung){
            data.setValue(kathit.getNama(), kathit.getJumlah());
        }
        
        
        JFreeChart chart = ChartFactory.createPieChart("Laporan Bulan Ini", data);
        PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator(
        "{0} : {1} ({2})", new DecimalFormat("0"), new DecimalFormat("0%"));
        ((PiePlot) chart.getPlot()).setLabelGenerator(labelGenerator);
        ChartFrame frame = new ChartFrame("Laporan", chart);
        frame.setSize(500,500);
        frame.setVisible(true);
    }

    public void viewKategoriTableByUser(JTable output_tableKategori) {
        String kolom[] = {"ID Kategori", "Nama Kategori"};
        DefaultTableModel modelTableKategori = new DefaultTableModel(kolom, 0);
        output_tableKategori.setModel(modelTableKategori);
        
        for(Kategori kat : km.getAllKategoriByUser(Config.pengguna)){
            modelTableKategori.addRow(new Object[]{kat.getId(),kat.getNama_kateogri()});
        }
    }

    public boolean insertKategori(String nama) {
        return km.insert(Config.pengguna, nama);
    }
    
    public boolean insertTransaksi(int kategori, int jenisTransaksi, int nominal, String keterangan){
        return tm.insert(this.kategori.get(kategori).getId(),Config.pengguna.getId(), jenisTransaksi, nominal , keterangan, new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
    }
    
    public boolean deleteTransaksi(int index){
        return tm.delete(this.transaksi.get(index));
    }
    
}
