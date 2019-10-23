/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dodhu;

import database.Koneksi;
import java.sql.SQLException;

/**
 *
 * @author Khisby
 */
public class DoDhu {

    /**
     * @param args the command line arguments
     */
    static private Koneksi db;
    public static void main(String[] args) throws SQLException {
        db = new Koneksi();
        db.getKoneksi();
        System.out.println("Hallo disini Khisby, Hudi, Fernando");
    }
    
}
