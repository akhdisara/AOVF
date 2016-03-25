<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <%@ include file="Navigation.jsp" %>
        <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
        <meta name="keywords" content="THEMELOCK.COM - Private Transport and Car Hire HTML Template" />
        <meta name="description" content="THEMELOCK.COM - Private Transport and Car Hire HTML Template">
        <meta name="author" content="themeenergy.com">

        <title>AO</title>

        <link rel="stylesheet" href="css/theme-red.css" />
        <link rel="stylesheet" href="css/style.css" />
        <link rel="stylesheet" href="css/animate.css" />
        <link href='http://fonts.googleapis.com/css?family=Raleway:400,500,600,700|Montserrat:400,700' rel='stylesheet' type='text/css'>
        <link rel="shortcut icon" href="images/favicon.ico" />

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>

    <body class="home">

        <!-- Main -->
        <main class="main" role="main">
            <!-- Intro -->
            <div class="intro">
                <div class="wrap">
                    <div class="textwidget">
                        <h1 class="wow fadeInDown">Tour de france</h1>
                        
                        <div class="actions">
                            <a href="#services" title="STR" class="btn large white wow fadeInLeft anchor">STR</a>
                            <a href="#booking" title="STF" class="btn large color wow fadeInRight anchor">STF</a>
                        </div>
                    </div>
                </div>
            </div>
            <!-- //Intro -->

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