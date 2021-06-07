package com.ride.voiture;

import javax.persistence.Column;

public class Result {
     
   
   	private String matricule;
   
   	private int nombre_places;
  
   	private float prix;
   
   	private String genre;
  
   	private String pic;
    public Result(String matricule,int nombre_places,float prix,String genre,String pic){
    	
		this.matricule = matricule;
		this.nombre_places = nombre_places;
		this.prix=prix;
		this.genre =genre;
		this.pic=pic;
   	
    }
    
	public String  getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	
	public void setNombre_places(int nombre_places) {
		this.nombre_places = nombre_places;
	}
	public int getNombre_places() {
		return nombre_places;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix=prix;
	}
	public String  getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre =genre;
	}
	public String  getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	
}
