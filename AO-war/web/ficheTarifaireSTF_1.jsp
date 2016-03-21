<%-- 
    Document   : Tarifaire
    Created on : 10 mars 2016, 12:16:23
    Author     : 3099709
--%>

<%@page import="java.util.Arrays"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Collections"%>
<%@page import="webservice.DistanceGare"%>
<%@page import="webservice.Gare"%>
<%@page import="webservice.Ligne"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">       
        <title>Fiche tarifaire</title>
    </head>
    <body>
        <h1 id="h1">Fiche tarifaire</h1>
        <br><br>    
        <!-- Méthode de la recherche d'une ligne -->
        <div class ="text">
            <%
                String attribut = (String) request.getAttribute("message"); 
                Double prixKM = (Double) request.getAttribute("prixKM"); 
                Ligne ligne = (Ligne) request.getAttribute("ligne"); 
                out.println(attribut);
            %>
        </div>       
        <br><br>       
        <!-- Affichage de la liste de toutes les lignes -->
        <TABLE id="tableAffich">
            <tr id="trTitre">
                <th><%=ligne.getGareDepart().getNomGare()%></th>
                <th>Distance</th>
                <th>Tarif</th>
            </tr>
            <%
                List<DistanceGare> lesDistances = (List) request.getAttribute("lesDistances");
                for (DistanceGare g : lesDistances) {                  
            %>
            <tr>
                <% if(!g.getLaGare().getNomGare().equals(ligne.getGareDepart().getNomGare())) {%>
                <td width="10%"><%=g.getLaGare().getNomGare() %></td>
                <td width="10%"><%=g.getDistanceGare()%> km</td>
                <td width="10%"><%=g.getDistanceGare() * prixKM %> €</td>
                <%}%>
            </tr><%}%>
        </TABLE>       
    </body>
</html>
