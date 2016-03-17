<%-- 
    Document   : ficheHoraire
    Created on : 11 mars 2016, 16:13:14
    Author     : 5150796
--%>
<%@page import="webservice.PlageHoraire"%>
<%@page import="webservice.FicheHoraire"%>
<%@page import="webservice.LigneSTR"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Fiche Horaire </title>
        <style type="text/css"> 
            th, td {
                border-bottom: 1px solid #ddd;
                padding: 15px;
                text-align: left;
            }
        </style>
    </head>
    <body>

        <% Collection<FicheHoraire> coll = (Collection) request.getAttribute("collectionFichesHorairesBlanche");
            LigneSTR ligne = (LigneSTR) request.getAttribute("ligne");
            DateFormat outputFormat = new SimpleDateFormat("HH:mm");
            DateFormat inputFormat = new SimpleDateFormat("YYYY-MM-DD'T'hh:mm:ss");
            int i = 1;%>
        <h1>Fiche Horaire &nbsp;<%=ligne.getIdentifiant()%></h1>

        <% if (!coll.isEmpty()) { %>       
        <table>
            <h2><font color="red">Pédiode Blanche</font></h2>
                <% FicheHoraire f = (FicheHoraire) coll.toArray()[0];%>
            <tr>            
                <th></th>
                    <% Collection<PlageHoraire> PlagesHorairesB = (Collection) request.getAttribute("PlageHoraireFichB" + f.getId());
                        for (PlageHoraire plage : PlagesHorairesB) {%>
                <th><label><%=plage.getArret().getNom()%></label></th>
                        <%}%>
            </tr>


            <% for (FicheHoraire fiche : coll) {%>
            <tr>  

                <th><font color="red"><%=i%></font></th>
                    <% Collection<PlageHoraire> PlagesHorairesB2 = (Collection) request.getAttribute("PlageHoraireFichB" + fiche.getId());
                        for (PlageHoraire plage : PlagesHorairesB2) {
                            Date date = inputFormat.parse(plage.getHoraire().toString());
                    %>
                <th><label><%=outputFormat.format(date)%></label></th>
                        <%}%>
            </tr>
            <% i++;%>
            <%}%>
            <%}%>
        </table>
        <% Collection<FicheHoraire> collJ = (Collection) request.getAttribute("collectionFichesHorairesJaune");
            int j = 1;%>
        <% if (!collJ.isEmpty()) { %> 
        <h2><font color="red">Pédiode Jaune</font></h2>
        <table>
            <% FicheHoraire f = (FicheHoraire) collJ.toArray()[0];%>
            <tr>            
                <th></th>
                    <% Collection<PlageHoraire> PlagesHorairesJ = (Collection) request.getAttribute("PlageHoraireFichJ" + f.getId());
                        for (PlageHoraire plage : PlagesHorairesJ) {%>
                <th><label><%=plage.getArret().getNom()%></label></th>
                        <%}%>
            </tr>


            <% for (FicheHoraire fiche : collJ) {%>
            <tr>            
                <th><font color="red"><%=j%></font></th>
                    <% Collection<PlageHoraire> PlagesHorairesB2 = (Collection) request.getAttribute("PlageHoraireFichJ" + fiche.getId());
                        for (PlageHoraire plage : PlagesHorairesB2) {
                            Date date = inputFormat.parse(plage.getHoraire().toString());
                    %>
                <th><label><%=outputFormat.format(date)%></label></th>
                        <%}%>
            </tr>
            <% j++;%>
            <%}%>
            <%}%>
        </table>
    </body>
</html>
