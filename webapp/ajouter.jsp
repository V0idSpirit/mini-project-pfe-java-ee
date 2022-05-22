<%@page import="tn.essat.model.Etudiant"%>
<%@page import="tn.essat.model.Enseignant"%>
<%@page import="tn.essat.model.Categorie"%>

<%@page import="java.util.List"%>
<%@page import="tn.essat.dao.GestionImp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<% GestionImp  etudiant = new GestionImp (); 
List<Etudiant> etudiants = etudiant.getAllEtudiants();
%>
<% GestionImp  enseignant = new GestionImp (); 
List<Enseignant> enseignants = enseignant.getAllEnseignant();
%>

<% GestionImp  categorie = new GestionImp (); 
List<Categorie> categories = categorie.getAllCategorie();
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Ajouter un PFE</h1>
<a href="PfeServlet">Retour</a>
<Br><Br>
<form method='get' action='Principale'>
<p>Titre:<input type="text" name="titlrePfe"></p>
<p>Etudiant:<select name="etudiant" id="etud">
<% for (Etudiant e : etudiants){ %>
<option value = <%= e.getId() %>><%=e.getNom()%></option>
<%} %></select>
<p>Enseignant:<select name="enseignant" id="ense">
<% for (Enseignant en : enseignants){ %>
<option value = <%= en.getId() %>><%=en.getNom()%></option>
<%} %></select>
<p>Categorie:<select name="categorie" id="categ">
<% for (Categorie ca : categories){ %>
<option value = <%= ca.getId() %>><%=ca.getName() %></option>
<%} %></select>
<br><br>
<input type="submit" value="enregistrer">
</form>
</body>
</html>