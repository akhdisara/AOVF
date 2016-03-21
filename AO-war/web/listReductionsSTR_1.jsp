<%-- 
    Document   : gestionReduction
    Created on : 11 mars 2016, 03:54:28
    Author     : Sara
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="webservice.Reduction"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Collection"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Réduction</title>
    </head>
    <body>
        <h1 id="h1">Abonnements STR</h1>

        <TABLE id="tableModif">
            <tr id="trTitre">
                    <th>Type</th>
                    <th>Taux</th>
                    <th>Sélectionner</th>
                </tr>
                <%
                                    Collection<Reduction> coll = (Collection) request.getAttribute("lesReductions");
                                    for (Reduction r : coll) {%>
                <tr id="trContenu">
                    <td> <%= r.getTypeReduction()%></td>
                    <td> <%= r.getTauxReduction()%></td>
                </tr>
                <%
                    }
                %>
                
        </table>        
    </body>
</html>
