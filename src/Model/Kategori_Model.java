/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import App.Koneksi;
import data.Kategori;
import data.Pengguna;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Khisby
 */
public class Kategori_Model {
    ArrayList<Kategori> arr = new ArrayList<>();
    private String table = "kategori";
    Koneksi kon = new Koneksi();
    
    public ArrayList<Kategori> getAllKategori(){
        this.refreshData();
        return arr;
    }
    
    public ArrayList<Kategori> getAllKategoriByUser(Pengguna pengguna){
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
                Kategori p = new Kategori();
                p.setId(rs.getInt("ID_KATEGORI"));
                p.setId_pengguna(rs.getInt("ID_PENGGUNA"));
                p.setNama_kateogri(rs.getString("NAMA_KATEGORI"));
                arr.add(p);
            }
        } catch (SQLException ex) {
            System.out.println("Gagal fetch data dari database");
        }
    }
    
    private void refreshData(String query) {
        ResultSet rs= kon.GetData(query);
        arr.clear();
        try {
            while(rs.next()){
                Kategori p = new Kategori();
                p.setId(rs.getInt("ID_KATEGORI"));
                p.setId_pengguna(rs.getInt("ID_PENGGUNA"));
                p.setNama_kateogri(rs.getString("NAMA_KATEGORI"));
                arr.add(p);
            }
        } catch (SQLException ex) {
            System.out.println("Gagal fetch data dari database");
        }
    }
    
    public boolean insert(Pengguna peng, String nama){
        String query = "INSERT INTO " + this.getTable() + " VALUES(null, '"+peng.getId()+"', '"+nama+"')";
        int run = kon.ManipulasiData(query);
        
        if(run > 0){
            return true;
        }
        
        return false;
    }
    
    private String getTable() {
        return this.table;
    }
    
}
