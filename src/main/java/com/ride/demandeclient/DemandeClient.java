package com.ride.demandeclient;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "demandes")
public class DemandeClient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(nullable=false)
	private String date_creation;
	
	@Column(nullable=false)
	private String etat;
	@Column(nullable=false)
	private String lieu_dep;

	@Column(nullable=false)
	private String lieu_dest;
	@Column(nullable=false, name="id_client")
	private Long idClient;
	@Column(nullable=false, name="id_voiture")
	private Long idVoiture;

	@Column(nullable=true)
	private Integer wifi;
	@Column(nullable=true)
	private Integer chaise;
	@Column(nullable=false)
	private float prix;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDate_creation() {
		return date_creation;
	}
	public void setDate_creation(String date_creation) {
		this.date_creation = date_creation;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public Long getId_client() {
		return idClient;
	}
	public void setId_client(Long id_client) {
		this.idClient = id_client;
	}
	
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	

	public String getLieu_dep() {
		return lieu_dep;
	}
	public void setLieu_dep(String lieu_dep) {
		this.lieu_dep = lieu_dep;
	}
	public String getLieu_dest() {
		return lieu_dest;
	}
	public void setLieu_dest(String lieu_dest) {
		this.lieu_dest = lieu_dest;
	}
	public Long getIdClient() {
		return idClient;
	}
	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}
	public Integer getWifi() {
		return wifi;
	}
	public void setWifi(Integer wifi) {
		this.wifi = wifi;
	}
	public Integer getChaise() {
		return chaise;
	}
	public void setChaise(Integer chaise) {
		this.chaise = chaise;
	}
	
	public Long getIdVoiture() {
		return idVoiture;
	}
	public void setIdVoiture(Long idVoiture) {
		this.idVoiture = idVoiture;
	}
	
}
