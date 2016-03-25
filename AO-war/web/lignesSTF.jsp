<%-- 
    Document   : gestionLignes
    Created on : 9 mars 2016, 13:19:18
    Author     : 5152683
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="webservice.Ligne"%>
<%@page import="webservice.Gare"%>
<html>
    <head>
        <title>AO</title>
        <%@ include file="Navigation.jsp" %>
        <link rel="stylesheet" href="css/theme-pink.css" />
        <link rel="stylesheet" href="css/style.css" />
        <link rel="stylesheet" href="css/animate.css" />
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Raleway:400,500,600,700|Montserrat:400,700">
        <link rel="shortcut icon" href="images/favicon.ico">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>

    <body>
            <jsp:useBean id="listelignes" scope="request" class="java.util.List"></jsp:useBean>
        </header>
        <!-- //Header -->

        <!-- Main -->
        <main class="main" role="main">
            <!-- Page info -->
            <header class="site-title color">
                <div class="wrap">
                    <div class="container">
                        <h1>Lignes STR</h1>
                    </div>
                </div>
            </header>
            <!-- //Page info -->
            <div class="full-width">
                <form method="POST" action="Servlet">
                    <div class="f-row">
                        <div class="one-half">
                            <label for="NumLigne">N° Ligne</label>
                            <input type="text" id="NumLigne" name="NumLigne"/><br/>
                            <input type="hidden" name="action" value="RechercherLigneSTF" />
                            <input type="submit" class="btn medium back" value="Chercher Ligne">								
                            <a href="Servlet?action=AfficherLignesSTF" class="btn medium color right">Toutes les lignes</a>													
                        </div>												
                    </div>
                </form>
            </div>
            <div class="wrap">	
                <div class="row">
                    <h3>
                        <%
                            String attribut = (String) request.getAttribute("message");
                            out.println(attribut);
                        %>
                    </h3>
                    <!--- Content -->
                    <div class="content offset">

                        <table class="hover">
                            <tr id="trTitre">
                                <th>Numéro de ligne</th>
                                <th>Départ</th>
                                <th>Arrivée</th>
                                <th>Fiche horaire</th>
                                <th>Fiche tarifaire</th>
                            </tr>
                            <%
                                List<Ligne> lesLig = listelignes;
                                for (Ligne a : lesLig) {

                            %>
                            <tr id="trContenu">
                                <td Width=5%><%=a.getNumLigne()%></td>
                                <td Width=15%><%=a.getGareDepart().getNomGare()%></td>
                                <td Width=10%><%=a.getGareArrivee().getNomGare()%></td>                 
                                <td Width=10%><a class="aFiche" href="Servlet?IdLigne=<%=a.getId()%>&action=ficheHoraireSTF">Fiche horaire</a></td>
                                <td Width=10%><a class="aFiche" href="Servlet?IdLigne=<%=a.getId()%>&action=ficheTarifaireSTF">Fiche tarifaire</a></td>
                            </tr><%}%>
                        </table>

                    </div>
                </div>			
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