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
        <%@ include file="Navigation.jsp" %>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
        <meta name="keywords" content="THEMELOCK.COM - Private Transport and Car Hire HTML Template" />
        <meta name="description" content="THEMELOCK.COM - Private Transport and Car Hire HTML Template">
        <meta name="author" content="themeenergy.com">

        <link rel="stylesheet" href="css/theme-pink.css" />
        <link rel="stylesheet" href="css/style.css" />
        <link rel="stylesheet" href="css/animate.css" />
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Raleway:400,500,600,700|Montserrat:400,700">
        <link rel="shortcut icon" href="images/favicon.ico">
        <title> Client</title>
        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>

    <body>

        <!-- Main -->
        <main class="main" role="main">
            <!-- Page info -->
            <header class="site-title color">
                <div class="wrap">
                    <div class="container">
                        <h1>Nouveau client</h1>
                    </div>
                </div>
            </header>
            <!-- //Page info -->
            <h3><%=(String) request.getAttribute("message")%></h3>
            <div class="wrap">
                <div class="row">
                    <!--- Content -->
                    <div class="content one-half modal">
                        <!--Login-->
                        <div class="box">
                            <form method="POST" action="Servlet">
                                <div class="f-row">
                                    <div class="full-width">
                                        <label for="carte">N° Carte</label>
                                        <input type="text" id="carte" name="num" />
                                    </div>
                                    <div class="full-width">
                                        <label for="carte">Nom</label>
                                        <input type="text" id="carte" name="nom" />
                                    </div>
                                    <div class="full-width">
                                        <label for="carte">Prénom</label>
                                        <input type="text" id="carte" name="prenom" />
                                    </div>
                                    <div class="full-width">
                                        <label for="carte">Mot de passe</label>
                                        <input type="password" id="carte" name="mdp" />
                                    </div>
                                </div>
                                
                                <div class="f-row">
                                    <div class="full-width">
                                        <input type="hidden" name="action" value="ClientAjouter">
                                        <input type="submit" value="Ajouter" class="btn color medium full" />
                                    </div>
                                </div>

                            </form>
                        </div>
                        <!--//Login-->
                    </div>
                    <!--- //Content -->
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
        <script src="js/scripts.js"></script>

    </body>
</html>