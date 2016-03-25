<%-- 
    Document   : Tarifaire
    Created on : 10 mars 2016, 12:16:23
    Author     : 3099709
--%>

<%@page import="java.util.Arrays"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Collections"%>
<%@page import="webservice.DistanceGare"%>
<%@page import="webservice.Gare"%>
<%@page import="webservice.Ligne"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>AO</title>
        <%@ include file="Navigation.jsp" %>
        <link rel="stylesheet" href="css/theme-pink.css" />
        <link rel="stylesheet" href="css/style.css" />
        <link rel="stylesheet" href="css/animate.css" />
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Raleway:400,500,600,700|Montserrat:400,700">
        <link rel="shortcut icon" href="images/favicon.ico">
        <style type="text/css"> 
            th, td {
                border-bottom: 1px solid #ddd;
                padding: 15px;
                text-align: left;
            }
        </style>
        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view tde page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>
        

        <!-- Main -->
        <main class="main" role="main">
            <!-- Page info -->
            <% Ligne ligne = (Ligne) request.getAttribute("ligne");%>
            <header class="site-title color">
                <div class="wrap">
                    <div class="container">
                        <h1>Fiche Tarifaires &nbsp; <%=ligne.getNumLigne()%> </h1>
                    </div>
                </div>
            </header>
            <!-- //Page info -->
            <%
                Double prixKM = (Double) request.getAttribute("prixKM");
            %>  
            <div class="wrap">	
                <table>
                    <tr id="trTitre">
                        <th><%=ligne.getGareDepart().getNomGare()%></th>
                        <th>Distance</th>
                        <th>Tarif</th>
                    </tr>
                    <%
                        List<DistanceGare> lesDistances = (List) request.getAttribute("lesDistances");
                        for (DistanceGare g : lesDistances) {
                    %>
                    <tr>
                        <% if (!g.getLaGare().getNomGare().equals(ligne.getGareDepart().getNomGare())) {%>
                        <td width="10%"><%=g.getLaGare().getNomGare()%></td>
                        <td width="10%"><%=g.getDistanceGare()%> km</td>
                        <td width="10%"><%=g.getDistanceGare() * prixKM%> €</td>
                        <%}%>
                    </tr><%}%>
                </table>             			
            </div>
        </main>
        <!-- //Main -->


        <!-- Footer -->
        <footer class="footer black" role="contentinfo">
           
        </footer>
        <!-- //Footer -->

        <!-- Preloader -->
        <div class="preloader">
            <div id="followingBallsG">
                <div id="followingBallsG_1" class="followingBallsG"></div>
                <div id="followingBallsG_2" class="followingBallsG"></div>
                <div id="followingBallsG_3" class="followingBallsG"></div>
                <div id="followingBallsG_4" class="followingBallsG"></div>
            </div>
        </div>
        <!-- //Preloader -->

        <!-- jQuery -->
        <script src="js/jquery.min.js"></script>
        <script src="js/jquery.uniform.min.js"></script>
        <script src="js/jquery.datetimepicker.js"></script>
        <script src="js/jquery.slicknav.min.js"></script>
        <script src="js/wow.min.js"></script>
        <script src="js/search.js"></script>
        <script src="js/scripts.js"></script>

    </body>
</html>