/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.Date;

/**
 *
 * @author Khisby
 */
public class Transaksi {
    int id;
    Kategori kategori;
    Pengguna pengguna;
    int jenis_transaksi;
    int nominal_transaksi;
    String keterangan_transaksi;
    Date waktu_transaksi;

    public Transaksi() {
    }
    
    public Transaksi(int id, Kategori kategori, Pengguna pengguna, int jenis_transaksi, int nominal_transaksi, String keterangan_transaksi, Date waktu_transaksi) {
        this.id = id;
        this.kategori = kategori;
        this.pengguna = pengguna;
        this.jenis_transaksi = jenis_transaksi;
        this.nominal_transaksi = nominal_transaksi;
        this.keterangan_transaksi = keterangan_transaksi;
        this.waktu_transaksi = waktu_transaksi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Kategori getKategori() {
        return kategori;
    }

    public void setKategori(Kategori kategori) {
        this.kategori = kategori;
    }

    public Pengguna getPengguna() {
        return pengguna;
    }

    public void setPengguna(Pengguna pengguna) {
        this.pengguna = pengguna;
    }

    public int getJenis_transaksi() {
        return jenis_transaksi;
    }
    
    public String getJenis_transaksi_toString() {
        if(this.jenis_transaksi == 1){
            return "Masuk";
        }else{
            return "Keluar";
        }
    }

    public void setJenis_transaksi(int jenis_transaksi) {
        this.jenis_transaksi = jenis_transaksi;
    }

    public int getNominal_transaksi() {
        return nominal_transaksi;
    }

    public void setNominal_transaksi(int nominal_transaksi) {
        this.nominal_transaksi = nominal_transaksi;
    }

    public String getKeterangan_transaksi() {
        return keterangan_transaksi;
    }

    public void setKeterangan_transaksi(String keterangan_transaksi) {
        this.keterangan_transaksi = keterangan_transaksi;
    }

    public Date getWaktu_transaksi() {
        return waktu_transaksi;
    }

    public void setWaktu_transaksi(Date waktu_transaksi) {
        this.waktu_transaksi = waktu_transaksi;
    }
    
    
}
