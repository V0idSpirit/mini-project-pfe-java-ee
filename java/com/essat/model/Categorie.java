package com.essat.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Categorie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   private String name;
   
   @OneToOne (mappedBy = "categorie")
	private Pfe pfe;
	
	
	public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


public int getId() {
	return id;
}


	public Categorie(String name) {
		this.name = name;
	}
}
