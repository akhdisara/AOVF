<%-- 
    Document   : ficheHoraireSTF
    Created on : 17 mars 2016, 10:55:41
    Author     : 5150796
--%>

<%@page import="java.util.Collections"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="webservice.Horaire"%>
<%@page import="java.util.List"%>
<%@page import="webservice.Gare"%>
<%@page import="webservice.Ligne"%>
<%@page import="webservice.DistanceGare"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Horaires</title>
        </head>
        <body>
            <h1 id="h1">Horaires</h1>
            <p>
            <div class ="text">
            <%
                String attribut = (String) request.getAttribute("message");
                out.println(attribut);
                List<DistanceGare> lesDistances = (List) request.getAttribute("lesDistances");
                DateFormat outputFormat = new SimpleDateFormat("HH:mm");
                DateFormat inputFormat = new SimpleDateFormat("YYYY-MM-DD'T'hh:mm:ss");
                List<Gare> lesGares = (List) request.getAttribute("listeGares");
                List<Horaire> listeHoraires = (List) request.getAttribute("listeHoraires");
                Ligne ligne = (Ligne) request.getAttribute("ligne"); 
            %>
        </div>
    </p>
    <TABLE id="tableAffich">
        <tr id="trTitre">
            <th>Gare</th>
            <th>horaires</th>
            <th>Sélectionner</th>
        </tr>
        <% for (DistanceGare g : lesDistances){%>
        <tr id="trContenu">
            <td Width=15%><%=g.getLaGare().getNomGare()%></td>
            <td Width=75%>
                <%for (Horaire h : listeHoraires) {
                    if (h.getLaGare().getNomGare().equals(g.getLaGare().getNomGare())) {%>
                        <%=outputFormat.format(inputFormat.parse(h.getDateHoraire().toString()))%> / 
                    <%}%>
                <%}%>
            </td>
            <td>
        </tr><%}%>
    </TABLE>
</body>
</body>
</html>

