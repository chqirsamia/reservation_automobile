package com.ride.voiture;


import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Entity;


@Entity 
@Table(name="voitures")
public class Voiture {
	@Id
	@SequenceGenerator(
			name="voiture_sequence",
			sequenceName="voiture_sequence",
			allocationSize=1)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Long id;
	@Column(nullable=false,length=50)
	private String matricule;
	@Column(nullable=false,length=30)
	private String marque;
	
	@Column(nullable=false)
	private int nombre_places;
	@Column(nullable=false)
	private float prix;
	@Column(nullable=false,length=50)
	private String genre;
	@Column(nullable=true,length=50)
	private String pic;
	
	/*public Voiture(int id,String matricule,int nombre_places,float prix,String genre,String pic)
	{
		this.id = id;
		this.matricule = matricule;
		this.nombre_places = nombre_places;
		this.prix=prix;
		this.genre =genre;
		this.pic=pic;
		
	}*/
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
}
