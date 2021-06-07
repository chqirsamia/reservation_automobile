package com.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="demande")
public class Demande {

	
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long id;
		@Column(nullable=false)
		private Date date_creation;
		@Column(nullable=false,length=50)
		private String etat;
		@Column(nullable=false)
		private Long id_client;
		
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public Date getDate_creation() {
			return date_creation;
		}
		public void setDate_creation(Date date_creation) {
			this.date_creation = date_creation;
		}
		public String getEtat() {
			return etat;
		}
		public void setEtat(String etat) {
			this.etat = etat;
		}
		public Long getId_client() {
			return id_client;
		}
		public void setId_client(Long id_client) {
			this.id_client = id_client;
		}
		
	}

