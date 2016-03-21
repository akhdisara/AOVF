<%-- 
    Document   : menuClient
    Created on : 21 mars 2016, 12:26:39
    Author     : 3099709
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ include file="navigationClient.jsp" %>
        <title>JSP Page</title>
    </head>
    <body>
        <!-- Search -->
            <div class="advanced-search color" id="booking">
                <div class="wrap">
                    <form role="form" action="Servlet" method="post">
                        <!-- Row -->
                        <div class="f-row">
                            <div class="form-group select one-third">
                                <label for="depart">Départ</label>
                                <input type="text" name="depart" id="depart" />
                            </div>
                            <div class="form-group select one-third">
                                <label for="arrivee">Arrivée</label>
                                <input type="text" name="arrivee" id="arrivee" />
                            </div>
                            <div class="one-third">
                                <label>&nbsp;</label>
                                <input type="hidden" name="action" value="rechercherTrajet">
                                <input class="btn large black" type="submit" value="Rechercher"/>
                            </div>
                            
                        </div>					
                    </form>
                </div>
            </div>
            <!-- //Search -->
    </body>
</html>
