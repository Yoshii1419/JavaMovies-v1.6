/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamovies;

/**
 *
 * @author Yuri.Ramos
 */
public class TitlesJson {
    
    private String Title;
    private int Year;
    private String Genre;
    private String Director;
    private String Writer;
    private String Actors;
    private String Plot;
    private String Poster;
    private Double imdbRating;
    
    void setTitle(String n){
        this.Title = n;
    }
    String getTitle() {
        return this.Title;
    }
    
    void setYear(int y){
        this.Year = y;
    }
    int getYear() {
        return this.Year;
    }
    
    void setGenre(String genre){
        this.Genre = genre;
    }
    String getGenre() {
        return this.Genre;
    }
    
    void setDirector(String director){
        this.Director = director;
    }
    String getDirector() {
        return this.Director;
    }
    
    void setWriter(String writer){
        this.Writer = writer;
    }
    String getWriter(){
        return this.Writer;
    }
    
    void setActors(String actors){
        this.Actors = actors;
    }
    String getActors(){
        return this.Actors;
    }
    
    void setPlot(String plot){
        this.Plot = plot;
    }
    String getPlot(){
        return this.Plot;
    }
    
    void setPoster(String poster){
        this.Poster = poster;
    }
    String getPoster(){
        return this.Poster;
    }
    
    void setImdbRating(Double rating){
        this.imdbRating = rating;
    }
    Double getImdbRating(){
        return this.imdbRating;
    }
}
