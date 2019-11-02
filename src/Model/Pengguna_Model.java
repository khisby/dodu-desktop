/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import data.Pengguna;
import App.Koneksi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Khisby
 */
public class Pengguna_Model {
    ArrayList<Pengguna> arr = new ArrayList<>();
    private String table = "pengguna";
    Koneksi kon = new Koneksi();
    
    public Pengguna_Model(){
        this.refreshData();
    }
    
    public ArrayList<Pengguna> getAllPengguna(){
        this.refreshData();
        return arr;
    }

    private void refreshData() {
        String query = "SELECT * FROM " + this.getTable();
        ResultSet rs= kon.GetData(query);
        arr.clear();
        try {
            while(rs.next()){
                Pengguna p = new Pengguna();
                p.setId(rs.getInt("ID_PENGGUNA"));
                p.setNama_pengguna(rs.getString("NAMA_PENGGUNA"));
                p.setSurel_pengguna(rs.getString("SUREL_PENGGUNA"));
                p.setSandi_pengguna(rs.getString("SANDI_PENGGUNA"));
                arr.add(p);
            }
        } catch (SQLException ex) {
            System.out.println("Gagal fetch data dari database");
        }
    }
    
    public boolean insertPengguna(Pengguna pengguna){
        String query = "INSERT INTO " + this.getTable() + " VALUES(null, '"+pengguna.getNama_pengguna()+"', '"+pengguna.getSurel_pengguna()+"', '"+pengguna.getSandi_pengguna()+"')";
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
