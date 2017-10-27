/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamovies;
import Jframes.Mainwindow;
import javax.swing.JFrame;

/**
 *
 * @author Yuri.Ramos
 */
public class JavaMovies {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    
        Mainwindow mainwindow = new Mainwindow();
        mainwindow.setResizable(false);
        mainwindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainwindow.setLocationRelativeTo(null); // posiciona a tela no centro do monitor
        mainwindow.setVisible(true);
    }
    
}
