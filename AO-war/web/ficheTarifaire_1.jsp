<%-- 
    Document   : detailLigne
    Created on : 9 mars 2016, 01:08:32
    Author     : Sara
--%>

<%@page import="webservice.PositionArretLigne"%>
<%@page import="webservice.LigneSTR"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Collection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css" />
        <title>Fiche tarifaire</title>
    </head>
    <%
        LigneSTR ligne = (LigneSTR) request.getAttribute("ligne");
    %>
    <body>
        <h1>Détail</h1> 
            Identifiant : <%=ligne.getIdentifiant()%> <br>

            <h1>Tarif de Base</h1>
            <table border="1">
                <tr>
                    <th>Départ</th>
                    <th>Arrivée - Tarif</th>
                </tr>
                <%
                    int i = 0;
                    List<PositionArretLigne> listePos = (List) request.getAttribute("PositionsArretLigne");
                    for (i = 0; i < listePos.size() - 1; i++) {%>
                <tr>
                    <th><%= listePos.get(i).getArret().getNom()%></th>
                    <th>
                        <%
                            for (int j = i + 1; j < listePos.size(); j++) {
                                String val = (String) request.getAttribute("tarif_" + listePos.get(i).getArret().getNom() + "_" + listePos.get(j).getArret().getNom());
                                if(val == null)
                                    val = "";                             
                        %>

                        <label size="10"> <%= listePos.get(j).getArret().getNom()%></label>
                        <input type="text" name="tarif_<%= listePos.get(i).getArret().getNom()%>_<%= listePos.get(j).getArret().getNom()%>" 
                               value="<%=val%>" size="10" />
                        <br/>
                        <%}%>

                    </th>

                </tr>
                <%}%>

            </table>

            <h1>Tarif Mensuel</h1>
            <table border="1">
                <tr>
                    <th>Départ</th>
                    <th>Arrivée - Tarif</th>
                </tr>
                <%
                    List<PositionArretLigne> listePosM = (List) request.getAttribute("PositionsArretLigne");;
                    for (int k = 0; k < listePosM.size() - 1; k++) {%>
                <tr>
                    <th><%= listePosM.get(k).getArret().getNom()%></th>
                    <th>
                        <%
                            for (int j = k + 1; j < listePosM.size(); j++) {
                                String val = (String) request.getAttribute("tarifM_" + listePos.get(k).getArret().getNom() + "_" + listePos.get(j).getArret().getNom());
                                if(val == null)
                                    val = "";
                        %>
                        <label size="10"> <%= listePosM.get(j).getArret().getNom()%></label>
                        <input type="text" name="tarifM_<%= listePosM.get(k).getArret().getNom()%>_<%= listePosM.get(j).getArret().getNom()%>" value="<%=val%>" size="10" />
                        <br/>
                        <%}%>

                    </th>

                </tr>
                <%}%>

            </table>

            <h1>Tarif Hebdomadaire</h1>
            <table border="1">
                <tr>
                    <th>Départ</th>
                    <th>Arrivée - Tarif</th>
                </tr>
                <%
                    List<PositionArretLigne> listePosH = (List) request.getAttribute("PositionsArretLigne");;
                    for (int k = 0; k < listePosH.size() - 1; k++) {%>
                <tr>
                    <th><%= listePosH.get(k).getArret().getNom()%></th>
                    <th>
                        <%
                            for (int j = k + 1; j < listePosH.size(); j++) {
                                String val = (String) request.getAttribute("tarifM_" + listePos.get(k).getArret().getNom() + "_" + listePos.get(j).getArret().getNom());
                                if(val == null)
                                    val = "";
                        %>
                        <label size="10"> <%= listePosH.get(j).getArret().getNom()%></label>
                        <input type="text" name="tarifH_<%= listePosH.get(k).getArret().getNom()%>_<%= listePosH.get(j).getArret().getNom()%>" value="<%=val%>"  size="10" />
                        <br/>
                        <%}%>

                    </th>

                </tr>
                <%}%>

            </table>
    </body>
</html>
