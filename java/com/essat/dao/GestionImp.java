package com.essat.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import com.essat.model.Categorie;
import com.essat.model.Enseignant;
import com.essat.model.Etudiant;
import com.essat.model.Pfe;

public class GestionImp implements IGestion {
	
	Session session;
	
	public GestionImp() {
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata metadata =  new MetadataSources(serviceRegistry).getMetadataBuilder().build();
		SessionFactory sessionFactory=metadata.getSessionFactoryBuilder().build();	
		this.session=sessionFactory.openSession();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pfe> getAllPfe() {
		return  this.session.createQuery("from Pfe").list();
		}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pfe> getAllPfeByCategorie(final Categorie cat) {
		return  this.session.createQuery("from Pfe p where p.cat_id = :cat.id").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Etudiant> getAllEtudiants() {
		return  this.session.createQuery("from Etudiant").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Enseignant> getAllEnseignant() {
		return  this.session.createQuery("from Enseignant").list();
	}

	@Override
	public void addPfe(Pfe p) {
		this.session.getTransaction().begin();
		this.session.persist(p);
		this.session.getTransaction().commit();
		
	}

	@Override
	public void deletePfe(int id) {
		Pfe p= (Pfe) this.session.load(Pfe.class, id);
		this.session.getTransaction().begin();
		this.session.delete(p);
		this.session.getTransaction().commit();
		
	}
	@SuppressWarnings("unchecked")
	@Override
	 public List<Categorie> getAllCategorie(){
		return  this.session.createQuery("from Categorie").list();
		}
	@Override
     public Etudiant getEtudiantById(int id) {
		return (Etudiant) this.session.
				  createQuery("from Etudiant where id = :id").
				  setParameter("id", id).
				  uniqueResult();
		}	
	@Override
    public Enseignant getEnseignantById(int id) {
		return (Enseignant) this.session.
				  createQuery("from Enseignant where id = :id").
				  setParameter("id", id).
				  uniqueResult();
		}
	
	@Override
    public Categorie getCategorieById(int id) {
		return (Categorie) this.session.
				  createQuery("from Categorie where id = :id").
				  setParameter("id", id).
				  uniqueResult();
		}
		
	
	@Override
	public int getCount() {
		Query query = this.session.createQuery("select COUNT(titrePfe) from Pfe p");
		int i=query.executeUpdate();
		return i;
	}
}
