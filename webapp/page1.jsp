<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PFE ESSAT</title>
</head>
<body>
<h1>Liste de PFE</h1>
<a href="ajouter.jsp">Ajouter PFE</a>
<Br><Br>
<table border="1">
<tr><th>Titre</th><th>Enseignant</th><th>Etudiant</th><th>Type</th><th></th></tr>


	<c:forEach items="${Pfes}" var ="pf">
		<tr>
		 <td>${pf.titrePfe}</td>
		 <td>${pf.enseignant.nom}</td>
		 <td>${pf.etudiant.nom}</td>
		 <td>${pf.categorie.name}</td>
		</tr>

	</c:forEach>
</table>
</body>
</html>