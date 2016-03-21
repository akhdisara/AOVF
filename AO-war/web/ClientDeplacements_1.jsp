<%-- 
    Document   : ClientDeplacements
    Created on : 20 mars 2016, 18:28:35
    Author     : Brias
--%>

<%@page import="packageEntites.Paiement"%>
<%@page import="packageEntites.SousTrajet"%>
<%@page import="packageEntites.Trajet"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="packageEntites.Client"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="client" scope="session" class="Client"></jsp:useBean>
            <title>Relevé de déplacements</title>
        </head>
        <body>
        <%@ include file="Navigation.jsp" %>

        <h1 id="h1">Relevé de vos déplacements</h1>
        <header class="site-title color">
            <div class="wrap">
                <div class="container">
                    <h1>Lignes STR</h1>
                </div>
            </div>
        </header>
        Carte: <%=client.getLaCarteAPuce().getId()%>
        <br>
        <%=client.getNom()%> <%=client.getPrenom()%>
        <br>

        <TABLE id="allTable">
            <tr id="allTr">
                <th>Date</th>
                <th>Depart</th>
                <th>Arrivée</th>
                <th>Tarif STR</th>
                <th>Tarif STF</th>
            </tr>
            <%
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                List<Trajet> lesTrajets = client.getLaCarteAPuce().getLesTrajets();
                for (Trajet t : lesTrajets) {%>
            <tr>
                <td Width=5%><%=format.format(t.getDateTrajet())%></td>
                <td Width=5%><%=t.getArretDepart()%></td>
                <td Width=10%><%=t.getArretArrivee()%></td>
                <td Width=10%><%=t.getTarifTotalSTR()%></td>
                <td Width=10%><%=t.getTarifTotalSTF()%></td>
            </tr><%}%>
        </TABLE>
    </body>
</html>
