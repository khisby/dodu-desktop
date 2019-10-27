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
public class Kateogri {
    int id;
    int id_pengguna;
    String nama_kateogri;

    public Kateogri(int id, int id_pengguna, String nama_kateogri) {
        this.id = id;
        this.id_pengguna = id_pengguna;
        this.nama_kateogri = nama_kateogri;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_pengguna() {
        return id_pengguna;
    }

    public void setId_pengguna(int id_pengguna) {
        this.id_pengguna = id_pengguna;
    }

    public String getNama_kateogri() {
        return nama_kateogri;
    }

    public void setNama_kateogri(String nama_kateogri) {
        this.nama_kateogri = nama_kateogri;
    }
    
}
