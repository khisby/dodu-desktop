/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Whoami
 */
public class Koneksi {

    private static Connection connect;
    private Statement db;
    private static String driverName = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/dodu?zeroDateTimeBehavior=convertToNull";
    private static String username = "root";
    private static String password = "";

    public static Connection getKoneksi() throws SQLException {
        if (connect == null) {
            try {
                Class.forName(driverName);
                try {
                    connect = DriverManager.getConnection(url, username, password);
                    System.out.println("Koneksi Database Sukses");
                } catch (SQLException se) {
                    System.out.println("Koneksi Database Gagal : " + se);
                    System.exit(0);
                }
            } catch (ClassNotFoundException cnfe) {
                System.out.println("Class Driver Tidak Ditemukan, Terjadi Kesalahan Pada : " + cnfe);
                System.exit(0);
            }
        }
        return connect;
    }
    public ResultSet GetData(String sql){
        try{
            db = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            return db.executeQuery(sql);
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    
    public int ManipulasiData(String sql){
        try{
            db = connect.createStatement();
            return db.executeUpdate(sql);
        }catch(SQLException e){
            e.printStackTrace();
            return 0;
        }
    }
}
