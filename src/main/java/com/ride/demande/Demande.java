package com.ride.demande;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity 
@Table(name="demande")
public class Demande {
		@Id
		@SequenceGenerator(
				name="demande_sequence",
				sequenceName="demande_sequence",
				allocationSize=1)
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		
		private Long id;
		@Column(nullable=false,length=50)
		private Date date_creation;
		@Column(nullable=false)
		private String etat;
		@Column(nullable=false)
		private Long id_client;
		@Column(nullable=false)
		private int wifi;
		@Column(nullable=false)
		private int chaise;
		
		@Column(nullable=false)
		private float prix;
		@Column(nullable=false)
		private String nom;
		@Column(nullable=false)
		private String prenom;
		@Column(nullable=false)
		private String email;
		@Column(nullable=false)
		private String tel;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public Long getId_client() {
			return id_client;
		}
		public void setId_client(Long id_client) {
			this.id_client = id_client;
		}
		public String  getEtat() {
			return etat;
		}
		public void setEtat(String etat) {
			this.etat = etat;
		}
		
		
		public Date getDate_creation() {
			return date_creation;
		}
		public void setPrix(float prix) {
			this.prix=prix;
		}
		public float getPrix() {
			return prix;
		}
		public void setWifi(int wifi) {
			this.wifi=wifi;
		}
		public int getWifi() {
			return wifi;
		}
		public void setChaise(int chaise) {
			this.chaise=chaise;
		}
		public int getChaise() {
			return chaise;
		}
		public String getNom() {
			return nom;
		}
		public void setNom(String nom) {
			this.nom = nom;
		}
		public String getPrenom() {
			return prenom;
		}
		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		
		public String getTel() {
			return tel;
		}
		public void setTel(String tel) {
			this.tel = tel;
		}
		
}
