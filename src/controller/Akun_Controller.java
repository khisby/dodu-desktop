/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Model.Pengguna_Model;
import data.Pengguna;
import java.util.ArrayList;

/**
 *
 * @author Khisby
 */
public class Akun_Controller {
    Pengguna_Model pm;

    public Akun_Controller() {
        this.pm = new Pengguna_Model();
    }
    
    public Pengguna login(String surel, String sandi){
        ArrayList<Pengguna> pengguna = pm.getAllPengguna();
        Pengguna peng = null;
        for(Pengguna p : pengguna){
            if(p.getSurel_pengguna().equals(surel) && p.getSandi_pengguna().equals(sandi)){
                peng = p;
                break;
            }
        }
        return peng;
    }
    
    public boolean register(String nama, String surel, String sandi){
        Pengguna pengguna = new Pengguna();
        pengguna.setNama_pengguna(nama);
        pengguna.setSurel_pengguna(surel);
        pengguna.setSandi_pengguna(sandi);
        
        return pm.insertPengguna(pengguna);
    }
}
