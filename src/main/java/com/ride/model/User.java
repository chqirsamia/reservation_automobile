package com.ride.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false,length=50)
	private String nom;
	@Column(nullable=false,length=50)
	private String prenom;
	@Column(nullable=false,unique=true,length=100)
	private String email;
	@Column(nullable=false,length=10)
	private String sexe;
	@Column(nullable=false,length=10)
	private String tel;
	@Column(nullable=false,length=100)
	private String password;
	@Column(nullable=false,length=2)
	private String role;
	
//	@OneToMany
//	private List<Demande> demandes;
	
	
//	public List<Demande> getDemandes() {
//		return demandes;
//	}
//	public void setDemandes(List<Demande> demandes) {
//		this.demandes = demandes;
//	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	

}
