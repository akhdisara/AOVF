<%-- 
    Document   : ClientCreer
    Created on : 15 mars 2016, 09:32:50
    Author     : 3092790
--%>

<%@page import="packageEntites.CompteBancaire"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nouveau client</title>
    </head>
    <body>
        <%@ include file="Navigation.jsp" %>
        <h1>Nouveau Client</h1>
        <%
            String attribut=(String)request.getAttribute("message");
            out.println(attribut);
        %>
        <form method="get" action="Servlet">
            
                <legend> Création d'un client </legend>
                    <TABLE>
                        <tr>
                            <td Width=100px><label for="num">Numéro client<span class="requis">*</span></label></td>
                            <td Width=200px><input type="text" name="num" value="" size="50" maxlength="20" /></td>
                        </tr>
                        <tr>
                            <td Width=100px><label for="nom">Nom <span class="requis">*</span></label></td>
                            <td Width=200px><input type="text" name="nom" value="" size="50" maxlength="20" /></td>
                        </tr>
                        <tr>
                            <td Width=100px><label for="prenom">Prenom <span class="requis">*</span></label></td>
                            <td Width=200px><input type="text" name="prenom" value="" size="50" maxlength="20" /></td>
                        </tr>
                        <tr>
                            <td Width=100px><label for="mdp">Mot de passe <span class="requis">*</span></label></td>
                            <td Width=200px><input type="text" name="mdp" value="" size="50" maxlength="20" /></td>
                        </tr>
                    </TABLE>
                <br/>

                <input type="hidden" name="action" value="ClientAjouter">

                <input type="submit" value="Valider"/>
                <input type="reset" value="Remettre à zéro"/>
                <br/>
        </form>
    </body>
</html>
