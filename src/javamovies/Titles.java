/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamovies;

import javax.swing.ImageIcon;

/**
 *
 * @author Yuri.Ramos
 */
public class Titles {
    private int id;
    private String title_name;
    private String genre;
    private int release_year;
    private String duration;
    private int cast; // foreinkey para tabela CAST
    private String director; // foreinkey para a tabela PERSON
    private String writer; // foreinkey para a tabela PERSON
    private double imdb_score;
    private String image_cover; // url para a capa do filme
    private ImageIcon img_cover; // imagem originada da url
    private String urlTrailer;
    
    // SET/GET TITLE_NAME
    public void setTitleName(String name){
        this.title_name = name;
    }
    public String getTitleName(){
        return this.title_name;
    }
    
    // SET/GET GENRE
    public void setGenre(String name){
        this.genre = name;
    }
    public String getGenre(){
        return this.genre;
    }
    
    // SET/GET RELEASE_YEAR
    public void setReleaseYear(int year){
        this.release_year = year;
    }
    public int getReleaseYear(){
        return this.release_year;
    }
    
    // SET/GET IMDB_SCORE
    public void setImdbScore(double score){
        this.imdb_score = score;
    }
    public double getImdbScore(){
        return this.imdb_score;
    }
    
    // SET/GET IMAGE_COVER
    public void setImageCover(String url){
        this.image_cover = url;
    }
    public String getImageCover(){
        return this.image_cover;
    }
    
    // SET/GET DIRECTOR
    public void setDirector(String name){
        this.director = name;
    }
    public String getDirector(){
        return this.director;
    }
    
    // SET/GET WRITER
    public void setWriter(String name){
        this.writer = name;
    }
    public String getWriter(){
        return this.writer;
    }
    
    // SET/GET IMG
    public void setImage(ImageIcon img) {
        this.img_cover = img;
    }
    public ImageIcon getImage() {
        return this.img_cover;
    }
    
    // SET/GET URL TRAILER 
    public void setUrlTrailer(String url) {
        this.urlTrailer = url;
    }
    public String getUrlTrailer() {
        return this.urlTrailer;
    }  
}
