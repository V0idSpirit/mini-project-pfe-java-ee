package com.essat.dao;

import java.util.List;

import com.essat.model.Categorie;
import com.essat.model.Enseignant;
import com.essat.model.Etudiant;
import com.essat.model.Pfe;

public interface IGestion {
 public List<Pfe> getAllPfe();
 public List<Pfe> getAllPfeByCategorie(Categorie cat);
 public List<Etudiant> getAllEtudiants();
 public List<Enseignant> getAllEnseignant();
 public void addPfe(Pfe p);
 public void deletePfe(int id);
 public List<Categorie> getAllCategorie();
 public Etudiant getEtudiantById(int id);
 public Enseignant getEnseignantById(int id);
 public Categorie getCategorieById(int id);
 public int getCount();

}
