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
    int id_kategori;
    int id_pengguna;
    int jenis_transaksi;
    int nominal_transaksi;
    String keterangan_transaksi;
    Date waktu_transaksi;

    public Transaksi(int id, int id_kategori, int id_pengguna, int jenis_transaksi, int nominal_transaksi, String keterangan_transaksi, Date waktu_transaksi) {
        this.id = id;
        this.id_kategori = id_kategori;
        this.id_pengguna = id_pengguna;
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

    public int getId_kategori() {
        return id_kategori;
    }

    public void setId_kategori(int id_kategori) {
        this.id_kategori = id_kategori;
    }

    public int getId_pengguna() {
        return id_pengguna;
    }

    public void setId_pengguna(int id_pengguna) {
        this.id_pengguna = id_pengguna;
    }

    public int getJenis_transaksi() {
        return jenis_transaksi;
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
