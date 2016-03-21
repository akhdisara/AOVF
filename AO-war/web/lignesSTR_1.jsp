<%-- 
    Document   : gestionLignes
    Created on : 9 mars 2016, 13:19:18
    Author     : 5152683
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="webservice.LigneSTR"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Collection"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Gestion des lignes</h1>
        <a href="Servlet?action=lignesSTR">All</a>
        <form method="POST" action="Servlet">
            Identifiant :<input type="text" name="identifiant"/><br>
            <input type="hidden" name="action" value="chercherLigneSTR" />
            <input type="submit" value="Chercher">
            <input type="reset" value="Vider">
        </form>
        <br>
        <% String message = (String) request.getAttribute("message"); %>
        <%=message%>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>Identifiant</th>
                    <th>Départ</th>
                    <th>Arrivée</th>
                    <th>Détail</th>
                </tr>
            </thead>
            <tbody>
                <%
                                    Collection<LigneSTR> coll = (Collection) request.getAttribute("collectionLignes");
                                    for (LigneSTR L : coll) {%>
                <tr>
                    <td> <%= L.getIdentifiant()%></td>
                    <td> <%= L.getDebut().getNom()%></td>
                    <td> <%= L.getFin().getNom()%></td>
                    <td> <a href="Servlet?action=ficheTarifaire&id=<%=L.getId()%>">Fiche tarifaire</a></td>                               
                    <td> <a href="Servlet?action=ficheHoraire&id=<%=L.getId()%>">Fiche horaire</a></td>                               
                </tr>
                <%
                    }
                %>
                </tr>
            </tbody>
        </table>  
    </body>
</html>
