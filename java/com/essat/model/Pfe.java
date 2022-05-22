package com.essat.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity 
public class Pfe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String titrePfe;
	@OneToOne
	@JoinColumn(name = "fk_etudiant") 
	private Etudiant etudiant;
	@OneToOne
	@JoinColumn(name = "fk_enseignant")
	private Enseignant enseignant;
	@OneToOne
	@JoinColumn(name = "fk_categorie")
	private Categorie categorie;
	
	public Pfe(String titrePfe) {
		super();
		this.titrePfe = titrePfe;
	}

	
	public Pfe() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdPfe() {
		return id;
	}
	public Etudiant getEtudiant() {
		return etudiant;
	}


	public void setEtudiant(Etudiant etd) {
		this.etudiant = etd;
	}


	public Enseignant getEnseignant() {
		return enseignant;
	}


	public void setEnseignant(Enseignant ens) {
		this.enseignant = ens;
	}


	public Categorie getCategorie() {
		return categorie;
	}


	public void setCategorie(Categorie cat) {
		this.categorie = cat;
	}


	public String getTitrePfe() {
		return titrePfe;
	}
	public void setTitrePfe(String titrePfe) {
		this.titrePfe = titrePfe;
	}
}
