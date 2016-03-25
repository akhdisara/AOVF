<%-- 
    Document   : Abonnements
    Created on : 7 mars 2016, 15:51:44
    Author     : 3099709
--%>

<%@page import="webservice.Abonnement"%>
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

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->

        <jsp:useBean id="listeabonnements" scope="request" class="java.util.List"></jsp:useBean>

        </head>

        <body>

            <!-- Main -->
            <main class="main" role="main">
                <!-- Page info -->
                <header class="site-title color">
                    <div class="wrap">
                        <div class="container">
                            <h1>Abonnements STF</h1>
                        </div>
                    </div>
                </header>
                <!-- //Page info -->

                <div class="wrap">	
                    <div class="row">
                        <!--- Content -->
                        <div class="content offset">
                            <table class="hover">
                                <tr id="trTitre">
                                    <th>Nom</th>
                                    <th>Remise</th>
                                </tr>
                            <%
                                List<Abonnement> abo = listeabonnements;
                                for (Abonnement a : abo) {
                            %>
                            <tr id="trContenu">
                                <td width="10%"><%=a.getType()%></td>
                                <td width="10%"><%=a.getTauxReduction()%></td>
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