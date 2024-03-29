/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import App.Config;
import App.Koneksi;
import data.Kategori;
import data.Pengguna;
import data.Transaksi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Khisby
 */
public class Transaksi_Model {
    ArrayList<Transaksi> arr = new ArrayList<>();
    private String table = "transaksi";
    Koneksi kon = new Koneksi();
    
    private Kategori_Model km = new Kategori_Model();
    private Pengguna_Model pm = new Pengguna_Model();

    public ArrayList<Transaksi> getAllKategori(){
        this.refreshData();
        return arr;
    }
    
    public ArrayList<Transaksi> getAllTranskasiByUser(Pengguna pengguna){
        String query = "SELECT * FROM " + this.getTable() + " WHERE ID_PENGGUNA = " + pengguna.getId();
        this.refreshData(query);
        return arr;
    }
    
    public ArrayList<Transaksi> getAllTranskasiByUserThisMonth(Pengguna pengguna){
        String query = "SELECT * FROM " + this.getTable() + " WHERE ID_PENGGUNA = " + pengguna.getId() + " AND month(WAKTU_TRANSAKSI) = " + this.thisMonth();
        this.refreshData(query);
        return arr;
    }
    
    private void refreshData() {
        String query = "SELECT * FROM " + this.getTable();
        ResultSet rs= kon.GetData(query);
        arr.clear();
        try {
            while(rs.next()){
                Transaksi p = new Transaksi();
                p.setId(rs.getInt("ID_TRANSAKSI"));
                p.setJenis_transaksi(rs.getInt("JENIS_TRANSAKSI"));
                p.setKeterangan_transaksi(rs.getString("KETERANGAN_TRANSAKSI"));
                p.setNominal_transaksi(rs.getInt("NOMINAL_TRANSAKSI"));
                p.setWaktu_transaksi(rs.getDate("WAKTU_TRANSAKSI"));
                
                for(Kategori kat : km.getAllKategori()){
                    if(kat.getId() == rs.getInt("ID_KATEGORI")){
                        p.setKategori(kat);
                    }
                }
                
                for(Pengguna peng : pm.getAllPengguna()){
                    if(peng.getId() == rs.getInt("ID_PENGGUNA")){
                        p.setPengguna(peng);
                    }
                }
                
                arr.add(p);
                
            }
        } catch (SQLException ex) {
            System.out.println("Gagal fetch data dari database" + ex);
        }
    }
    
    private void refreshData(String query) {
        ResultSet rs= kon.GetData(query);
        arr.clear();
        try {
            while(rs.next()){
                Transaksi p = new Transaksi();
                p.setId(rs.getInt("ID_TRANSAKSI"));
                p.setJenis_transaksi(rs.getInt("JENIS_TRANSAKSI"));
                p.setKeterangan_transaksi(rs.getString("KETERANGAN_TRANSAKSI"));
                p.setNominal_transaksi(rs.getInt("NOMINAL_TRANSAKSI"));
                p.setWaktu_transaksi(rs.getDate("WAKTU_TRANSAKSI"));
                
                for(Kategori kat : km.getAllKategori()){
                    if(kat.getId() == rs.getInt("ID_KATEGORI")){
                        p.setKategori(kat);
                    }
                }
                
                for(Pengguna peng : pm.getAllPengguna()){
                    if(peng.getId() == rs.getInt("ID_PENGGUNA")){
                        p.setPengguna(peng);
                    }
                }
                
                arr.add(p);
            }
        } catch (SQLException ex) {
            System.out.println("Gagal fetch data dari database" + ex);
        }
    } 
    
    private String getTable() {
        return this.table;
    }
    
    private int thisMonth(){
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int month = cal.get(Calendar.MONTH);
        return month+1;
    }
    
     public boolean insert(int kategori, int pengguna, int jenisTransaksi, int nominalTransaksi, String keterangan, String tanggal){
        String query = "INSERT INTO " + this.getTable() + " VALUES(null, "+kategori+", "+pengguna+" , "+jenisTransaksi+" , '"+nominalTransaksi+"' , '"+keterangan+"' , '"+tanggal+"')";
        int run = kon.ManipulasiData(query);
        
        if(run > 0){
            return true;
        }
        
        return false;
    }
     
     public boolean delete(Transaksi trans){
         
        String query = "DELETE from " + this.getTable() + " where id_transaksi = "+trans.getId();
        int run = kon.ManipulasiData(query);
        
        if(run > 0){
            return true;
        }

        return false;
    }
    
}
