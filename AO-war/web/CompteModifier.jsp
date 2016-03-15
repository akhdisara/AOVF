<%-- 
    Document   : CompteModifier
    Created on : 15 mars 2016, 15:24:35
    Author     : 3092790
--%>

<%@page import="packageEntites.Client"%>
<%@page import="packageEntites.CompteBancaire"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="compte" scope="request" class="CompteBancaire"></jsp:useBean>
        <jsp:useBean id="client" scope="request" class="Client"></jsp:useBean>
        <title>Modifier infos compte</title>
    </head>
    <body>
        <%@ include file="Navigation.jsp" %>
        
        <h1 id="h1">Modifier informations du compte</h1>
        
        <form method="get" action="Servlet">
            <TABLE id="TableModif">
                <tr id="allTr">
                    <th></th><th>Données actuelles</th><th>Nouvelles données</th>
                </tr>
                <tr>
                    <td>N°compte</td><td><%=compte.getNumCompte()%></td><td><input type="text" name="num" placeholder='nouveau num'/></td>
                </tr>
                <tr>
                    <td>Titulaire</td><td><%=compte.getTitulaire()%></td><td><input type="text" name="titulaire" placeholder='nouveau titulaire'/></td>
                </tr>
                <tr>
                    <td>Banque</td><td><%=compte.getNomBanque()%></td><td><input type="text" name="banque" placeholder='nouvelle banque'/></td>
                </tr>
                <tr>
                    <td>Code guichet</td><td><%=compte.getCodeGuichet()%></td><td><input type="text" name="guichet" placeholder='nouveau num guichet'/></td>
                </tr>
            </TABLE>
            <br><br>
            
            <div class ="btn_gauche">
                <input type="hidden" name="compte" value="<%=compte.getId()%>"/>
                <input type="hidden" name="client" value="<%=client.getId()%>"/>
                <input type="hidden" name="action" value="ModifierCompte"/>
                <input type="submit" value="Enregistrer"/>
            </div>
        </form>
    </body>
</html>
