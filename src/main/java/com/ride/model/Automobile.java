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
@Table(name="automobiles")
public class Automobile {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(nullable=false,length=50)
	private String nom;
	@Column(nullable=false,length=50)
	private String nbr_chaise;
	@Column(nullable=true,length=10)
	private String type;
	
//	@OneToMany(targetEntity = Demande.class, mappedBy="automobile")
//	private List<Demande> demandes;

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

	public String getNbr_chaise() {
		return nbr_chaise;
	}

	public void setNbr_chaise(String nbr_chaise) {
		this.nbr_chaise = nbr_chaise;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

//	public List<Demande> getDemandes() {
//		return demandes;
//	}
//
//	public void setDemandes(List<Demande> demandes) {
//		this.demandes = demandes;
//	}
	
	
	
}
