<%-- 
    Document   : Abonnements
    Created on : 7 mars 2016, 15:51:44
    Author     : 3099709
--%>

<%@page import="webservice.Abonnement"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="listeabonnements" scope="request" class="java.util.List"></jsp:useBean>
        <title>Abonnements STF</title>
    </head>
    <body>
       
        <h1 id="h1">Abonnements STF</h1>
        <br><br>
        
        <!-- Affichage de la liste de toutes les lignes -->
        <TABLE id="tableAffich">
            <tr id="trTitre">
                <th>Nom</th>
                <th>Remise</th>
            </tr>
            <%
                List<Abonnement> abo=listeabonnements;
                for(Abonnement a:abo){
            %>
            <tr id="trContenu">
                <td width="10%"><%=a.getType()%></td>
                <td width="10%"><%=a.getTauxReduction()%></td>
            </tr><%}%>
        </TABLE>
    </body>
</html>
