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
    
    
}
