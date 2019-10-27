/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author Khisby
 */
public class Pengguna {
    int id;
    String nama_pengguna;
    String surel_pengguna;
    String sandi_pengguna;

    public Pengguna() {
    }

    public Pengguna(int id, String nama_pengguna, String surel_pengguna, String sandi_pengguna) {
        this.id = id;
        this.nama_pengguna = nama_pengguna;
        this.surel_pengguna = surel_pengguna;
        this.sandi_pengguna = sandi_pengguna;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama_pengguna() {
        return nama_pengguna;
    }

    public void setNama_pengguna(String nama_pengguna) {
        this.nama_pengguna = nama_pengguna;
    }

    public String getSurel_pengguna() {
        return surel_pengguna;
    }

    public void setSurel_pengguna(String surel_pengguna) {
        this.surel_pengguna = surel_pengguna;
    }

    public String getSandi_pengguna() {
        return sandi_pengguna;
    }

    public void setSandi_pengguna(String sandi_pengguna) {
        this.sandi_pengguna = sandi_pengguna;
    }
    
        
    
}
