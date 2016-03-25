<%-- 
    Document   : ClientModifier
    Created on : 15 mars 2016, 14:46:43
    Author     : 3092790
--%>

<%@page import="packageEntites.Client"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="client" scope="request" class="Client"></jsp:useBean>
        <title>Gestion client</title>
        <%@ include file="Navigation.jsp" %>
    </head>
    <body>
        
        
        <h1 id="h1">Modifier Client</h1>
        
        <form method="get" action="Servlet">
            <TABLE id="TableModif">
                <tr id="allTr">
                    <th></th><th>Données actuelles</th><th>Nouvelles données</th>
                </tr>
                <tr>
                    <td>N°client</td><td><%=client.getNumClient()%></td><td><input type="text" name="num" placeholder='nouveau num'/></td>
                </tr>
                <tr>
                    <td>Nom</td><td><%=client.getNom()%></td><td><input type="text" name="nom" placeholder='nouveau nom'/></td>
                </tr>
                <tr>
                    <td>Prenom</td><td><%=client.getPrenom()%></td><td><input type="text" name="prenom" placeholder='nouveau prenom'/></td>
                </tr>
            </TABLE>
            <br><br>
            
            <div class ="btn_gauche">
                <input type="hidden" name="client" value="<%=client.getId()%>"/>
                <input type="hidden" name="action" value="ModifierClient"/>
                <input type="submit" value="Enregistrer"/>
            </div>
        </form>
    </body>
</html>
