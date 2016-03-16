<%-- 
    Document   : TrajetRechercher
    Created on : 16 mars 2016, 11:26:50
    Author     : 3092790
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tajet</title>
    </head>
    <body>
        <%@ include file="Navigation.jsp" %>
        
        <h1 id="h1">Trouver un trajet</h1>
        <br><br>
        <div class ="text">
        <%
            String attribut=(String)request.getAttribute("message");
            out.println(attribut);
        %>

        <form method="get" action="Servlet">
            
                <legend> Mon trajet : </legend>
                <br>
                    <TABLE>
                        <tr>
                            <td Width=100px><label for="dep">Départ<span class="requis">*</span></label></td>
                            <td Width=200px><input type="text" name="depart" value="" size="50" maxlength="20" /></td>
                        </tr>
                        <tr>
                            <td Width=100px><label for="arr">Arrivée<span class="requis">*</span></label></td>
                            <td Width=200px><input type="text" name="arrivee" value="" size="50" maxlength="20" /></td>
                        </tr>
                    </TABLE>
                <br/>

                <input type="hidden" name="action" value="ChercherTrajet">

                <input type="submit" value="Rechercher"/>
                <input type="reset" value="Remettre à zéro"/>
                <br/>
        </form>
    </body>
</html>
