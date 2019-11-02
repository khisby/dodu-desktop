/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import App.Config;
import Model.Kategori_Model;
import Model.Pengguna_Model;
import data.Kategori;
import data.Pengguna;

/**
 *
 * @author Khisby
 */
public class Kategori_Controller {
    Kategori_Model km;

    public Kategori_Controller() {
        try{
            if(Config.pengguna == null){
                System.out.println("Anda belum login");
            }else{
                km = new Kategori_Model();
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

    public void view() {
        for(Kategori kat : km.getAllKategori()){
            System.out.println(kat.getId());
            System.out.println(kat.getId_pengguna());
            System.out.println(kat.getNama_kateogri());
            System.out.println("=======================");
        }
    }
    
    public void view(Pengguna peng) {
        for(Kategori kat : km.getAllKategoriByUser(peng)){
            System.out.println(kat.getId());
            System.out.println(kat.getId_pengguna());
            System.out.println(kat.getNama_kateogri());
            System.out.println("=======================");
        }
    }
    
    
    
}
