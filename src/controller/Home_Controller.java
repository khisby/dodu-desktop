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
import data.Pengguna;
import data.Transaksi;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import view.Laporan;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Khisby
 */
public class Home_Controller {
    private Kategori_Model km;
    private Transaksi_Model tm;
    private ArrayList<Kategori> kategori = new ArrayList<Kategori>();

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

    public void insert(Pengguna peng, String nama) {
        if(km.insert(peng, nama)){
            System.out.println("Berhasil ditambahkan");
        }else{
            System.out.println("Gagal ditambahkan");
        }
    }

    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
//            System.out.println(trans.getId());
            modelTableTransaksi.addRow(new Object[]{trans.getId(),trans.getKategori().getNama_kateogri(),trans.getJenis_transaksi_toString(),trans.getNominal_transaksi(),trans.getKeterangan_transaksi(),trans.getWaktu_transaksi()});
        }
    }
    
    
    
}
