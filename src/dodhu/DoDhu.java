/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dodhu;

import App.Config;
import controller.Akun_Controller;
import App.Koneksi;
import controller.Home_Controller;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import view.Login;

/**
 *
 * @author Khisby
 */
public class DoDhu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        new Login().setVisible(true);
        
//        Akun_Controller a = new Akun_Controller();
//        if(a.login("khisby@gmail.com","khisby1") != null){
//            Config.pengguna = a.login("khisby@gmail.com", "khisby");
//            System.out.println("Berhasil login");
//        }else{
//            System.out.println("Gagal login");
//        }

//        Kategori_Controller c = new Kategori_Controller();
////        c.view(Config.pengguna);
//        c.insert(Config.pengguna, "kategorique");
//        a.register("a", "a", "a");
//        System.out.println("Hallo disini Khisby, Hudi, Fernando");
    }

}
