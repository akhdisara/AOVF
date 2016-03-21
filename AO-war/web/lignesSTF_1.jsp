<%-- 
    Document   : Lignes
    Created on : 7 mars 2016, 15:51:24
    Author     : 3099709
--%>

<%@page import="java.util.List"%>
<%@page import="webservice.Ligne"%>
<%@page import="webservice.Gare"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="listelignes" scope="request" class="java.util.List"></jsp:useBean>
        <title>Lignes</title>
    </head>
    <body>
        <!-- Inclusion du menu par la jsp Navigation -->
        <h1 id="h1">Lignes</h1>
        
        <!-- Méthode de la recherche d'une ligne -->
        <div class ="text">
            
            <form method="get" action="Servlet"> 
                <input type="text" name="NumLigne" placeholder="Rechercher une ligne" /> 
                <input type="hidden" name="action" value="RechercherLigneSTF">
                <input type="submit" value="Rechercher"/>

                    <a href="Servlet?action=AfficherLignesSTF"> <img id='boutonRafraichir' src='image/LogoRafraichir.png' alt='Rafraichir le tableau'></a>

                    <%
                        String attribut = (String) request.getAttribute("message");
                        out.println(attribut);
                    %>
            </form>
        </div>
        
        <br>
        <!-- Affichage de la liste de toutes les lignes -->
        <TABLE id="tableAffich">
            <tr id="trTitre">
                <th>Numéro de ligne</th>
                <th>Départ</th>
                <th>Arrivée</th>
                <th>Fiche horaire</th>
                <th>Fiche tarifaire</th>
            </tr>
            <%
                List<Ligne> lesLig=listelignes;
                for(Ligne a:lesLig){
               
            %>
                <tr id="trContenu">
                    <td Width=5%><%=a.getNumLigne()%></td>
                    <td Width=15%><%=a.getGareDepart().getNomGare()%></td>
                    <td Width=10%><%=a.getGareArrivee().getNomGare()%></td>                 
                    <td Width=10%><a class="aFiche" href="Servlet?IdLigne=<%=a.getId()%>&action=ficheHoraireSTF">Fiche horaire</a></td>
                    <td Width=10%><a class="aFiche" href="Servlet?IdLigne=<%=a.getId()%>&action=ficheTarifaireSTF">Fiche tarifaire</a></td>
                </tr><%}%>
        </TABLE>
        
      
    </body>
</html>
