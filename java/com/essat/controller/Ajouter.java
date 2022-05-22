package com.essat.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.essat.dao.GestionImp;
import com.essat.dao.IGestion;
import com.essat.model.Categorie;
import com.essat.model.Enseignant;
import com.essat.model.Etudiant;
import com.essat.model.Pfe;

/**
 * Servlet implementation class Ajouter
 */
public class Ajouter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ajouter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		IGestion guest = new GestionImp();
		int i = guest.getCount();
		String titre=request.getParameter("titrePfe");
		int idEt= Integer.parseInt(request.getParameter("etudiant"));
		Etudiant etudiant= guest.getEtudiantById(idEt);
		int idEn= Integer.parseInt(request.getParameter("enseignant"));
		Enseignant enseignant= guest.getEnseignantById(idEn);
		int idcat= Integer.parseInt(request.getParameter("categorie"));		
		Categorie categorie = guest.getCategorieById(idcat);
		
		Pfe p = new Pfe();
		p.setTitrePfe(titre);
		p.setEnseignant(enseignant);
		p.setEtudiant(etudiant);
		p.setCategorie(categorie);
		guest.addPfe(p);
		request.getRequestDispatcher("PfeServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
