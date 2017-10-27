/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamovies;

import Jframes.Mainwindow;
import Jframes.MoviesPanel;
import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Yuri.Ramos
 */
public class DataBaseManager {
    
    private Connection conn;
    
    public DataBaseManager() {
        this.conn = null;
    }
    
    public void OpenConnectionDataBase() {
        
        // estabelecendo conexão com o banco de dados //
        try {
            String url = "jdbc:mysql://localhost:3306/movies_database";
            String user = "root";
            String password = "";

            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection(url, user, password);
            if (this.conn != null) {
                System.out.println("Connected to the database");
            }

        } catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Mainwindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public boolean VerifyIfExistTitle(String title, String director){
        // verifica se registro a ser inserido já existe na base //
        // A verificação é feita a partir do Titulo e Diretor //
        
        String query = "select * from TITLES where TITLE_NAME like '%" + title + "%' and DIRECTOR like '%" + director + "%';";
        
        int cont = 0;
        // executando querys de inserção //
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            // preenchendo valores com os atributos do objeto Title //
            ResultSet rst;
            rst = stmt.executeQuery();
            
            while(rst.next()){
                cont++;
            } 
            
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(Mainwindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // se existir um mesmo registro, retorna false //
        if(cont == 0) {
            return false;
        }
        else {
            return true;
        }
        
    }
    
    public void ExecuteQueryInsert(Titles title) {

        // executando querys de inserção //
        String query = "INSERT INTO TITLES (TITLE_NAME,DIRECTOR,WRITER,GENRE,IMDB_SCORE,IMAGE_COVER, YEAR) VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(query);
            // preenchendo valores com os atributos do objeto Title //
            stmt.setString(1, title.getTitleName());
            stmt.setString(2, title.getDirector());
            stmt.setString(3, title.getWriter());
            stmt.setString(4, title.getGenre());
            stmt.setDouble(5, title.getImdbScore());
            stmt.setString(6, title.getImageCover());
            stmt.setInt(7, title.getReleaseYear());

            stmt.execute();
            stmt.close();
            System.out.println("Registro inserido!");
            
        } catch (SQLException ex) {
            Logger.getLogger(Mainwindow.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public ArrayList<Titles> ExecuteQuerySelectTitles(String search, String filter) {
    
        // Construindo Query de Busca //
        String query = null;
        // se campo estiver vazio, trazer todos os registros //
        if(search.compareTo("") == 0){
            query = "select * from TITLES;";
        }
        else{
            switch(filter){
                case "Title":
                    query = "select * from TITLES where TITLE_NAME like '%" + search + "%';";
                    break;
                case "Year":
                    query = "select * from TITLES where YEAR = " + search + ";";
                    break;
                default:
                    query = "select * from TITLES where " + filter + " like '%" + search + "%';";
                    break;
            }  
        }
    
        ArrayList<Titles> titlesList = new ArrayList<Titles>();
        
         // executando querys de seleção //
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // preenchendo valores com os atributos do objeto Title //
            ResultSet rst;
            rst = stmt.executeQuery();
            
            while(rst.next()){
                Titles titles = new Titles();
                titles.setDirector(rst.getString("DIRECTOR"));
                titles.setGenre(rst.getString("GENRE"));
                
                if(rst.getString("IMAGE_COVER") != ""){
                    titles.setImageCover(rst.getString("IMAGE_COVER"));
                    titles.setImage(getImageFromUrl(rst.getString("IMAGE_COVER")));
                }
                else{
                    titles.setImageCover("https://upload.wikimedia.org/wikipedia/commons/thumb/b/be/Saint_Andrew%27s_cross_%28red%29.svg/600px-Saint_Andrew%27s_cross_%28red%29.svg.png");
                }
                titles.setImdbScore(rst.getDouble("IMDB_SCORE"));
                titles.setReleaseYear(rst.getInt("YEAR"));
                titles.setTitleName(rst.getString("TITLE_NAME"));
                titles.setWriter(rst.getString("WRITER"));
                
                titlesList.add(titles);
            } 
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(Mainwindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return titlesList;
    }
    
    public ImageIcon getImageFromUrl(String url_input){
        
        Image image = null;
        URL url = null;
        try {
            url = new URL(url_input);
            image = ImageIO.read(url);
        } catch (MalformedURLException ex) {
            System.out.println("Malformed URL");
        } catch (IOException iox) {
            System.out.println("Can not load file");
        }

        ImageIcon imgIcon = new ImageIcon(image);
        // instrução abaixo realiza o ajuste da imagem para o alinhamento da JLabel
        //Image img = imgIcon.getImage().getScaledInstance(102, 157, Image.SCALE_SMOOTH);
        //this.ImageCoverLabel.setIcon(new ImageIcon(img));
        return imgIcon;
    }
    
    public void CloseConnection() {
        try {
               this.conn.close();
               System.out.println("Database was closed!");
        } catch (SQLException ex) {
                Logger.getLogger(MoviesPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
