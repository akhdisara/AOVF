<%-- 
    Document   : resultatTrajet
    Created on : 19 mars 2016, 15:07:33
    Author     : Sara
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>AO</title>

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
        <!-- Header -->
        <header class="header" role="banner">
            <div class="wrap">
                <!-- Logo -->
                <div class="logo">
                    <a href="index.html" title="Transfers"><img src="images/transfers.jpg" alt="Transfers" /></a>
                </div>
                <!-- //Logo -->

                <!-- Main Nav -->
                <nav role="navigation" class="main-nav">
                     <ul>
                        <li class="active"><a href="index.html" title="">accueil</a></li>
                        <li><a href="destinations.html" title="Destinations">STR</a>
                            <ul>
                                <li><a href="destination-single.html" title="Single destination">Lignes</a></li>
                                <li><a href="destination-micro.html" title="Micro destination">Abonnements</a></li>
                            </ul>
                        </li>
                        <li><a href="blog.html" title="Blog">STF</a>
                            <ul>
                                <li><a href="blog.html" title="Post">Lignes</a></li>
                                <li><a href="blog2.html" title="Post">Abonnements</a></li>
                            </ul>
                        </li>
                        <li><a href="contact.html" title="Contact">Questionnaires</a></li>
                        <li><a href="contact.html" title="Contact">Connexion</a></li>
                       </ul>
                </nav>
                <!-- //Main Nav -->
            </div>
        </header>
        <!-- //Header -->

        <!-- Main -->
        <main class="main" role="main">
            <!-- Search -->
            <div class="advanced-search color" id="booking">
                <div class="wrap">
                    <form role="form" action="Servlet" method="post">
                        <!-- Row -->
                        <div class="f-row">
                            <div class="form-group select one-third">
                                <label for="depart">Départ</label>
                                <input type="text" name="depart" id="depart" value="<%=(String) request.getAttribute("depart")%>"/>
                            </div>
                            <div class="form-group select one-third">
                                <label for="arrivee">Arrivée</label>
                                <input type="text" name="arrivee" id="arrivee" value="<%=(String) request.getAttribute("arrivee")%>"/>
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

            <div class="wrap">
                <div class="row">
                    <!--- Content -->
                    <div class="full-width content">
                        <h2>Résultat de votre recherche :</h2>
                        <h3>
                            <%
                                String attribut = (String) request.getAttribute("message");
                                out.println(attribut);
                            %>
                        </h3>
                        <div class="results">
                            <!-- Item -->
                            <%   
                            String l1 = (String) request.getAttribute("ligne1");
                            if (!l1.equals("")){%>
                            
                            <article class="result">
                                <div class="one-fourth heightfix">

                                    <div class="price"><%=(String) request.getAttribute("ligne1")%><small><%=(String) request.getAttribute("reseau1")%></small></div>

                                </div>
                                <div class="one-half heightfix">
                                    <h3><center> Ligne <%=(String) request.getAttribute("ligne1")%>&nbsp;<small><%=(String) request.getAttribute("ligne1Depart")%><<<<>>>> <%=(String) request.getAttribute("ligne1Arrivee")%></small></center></h3>
                                    <h3> Départ de <%=(String) request.getAttribute("depart1")%></h3>
                                    <h3> Descendre à <%=(String) request.getAttribute("arrivee1")%></h3>
                                </div>
                                <div class="one-fourth heightfix">

                                    <div class="price"><%=(String) request.getAttribute("tarif1")%><small>€</small></div>

                                </div>

                            </article>
                            <%}%>
                            <%   
                            String l2 = (String) request.getAttribute("ligne2");
                            if (!l2.equals("")){%>
                            <article class="result">
                                <div class="one-fourth heightfix">
                                     <div class="price"><%=(String) request.getAttribute("ligne2")%><small><%=(String) request.getAttribute("reseau2")%></small></div>
                                </div>
                                <div class="one-half heightfix">
                                    <h3><center> Ligne <%=(String) request.getAttribute("ligne2")%>&nbsp;<small><%=(String) request.getAttribute("ligne2Depart")%><<<<>>>> <%=(String) request.getAttribute("ligne2Arrivee")%></small></center></h3>
                                    <h3> Départ de <%=(String) request.getAttribute("depart2")%></h3>
                                    <h3> Descendre à <%=(String) request.getAttribute("arrivee2")%></h3>
                                </div>
                                <div class="one-fourth heightfix">
                                    <div class="price"><%=(String) request.getAttribute("tarif2")%><small>€</small></div>
                                </div>
                            </article>
                            <%}%>
                        </div>
                    </div>
                        
                    <a href="Servlet?action=AvoirTitreTransport&l1=<%=l1%>&l2=<%=l2%>&D=<%=(String) request.getAttribute("depart1")%>&C=<%=(String) request.getAttribute("arrivee1")%>&A=<%=(String) request.getAttribute("arrivee2")%>&t1=<%=(String) request.getAttribute("tarif1")%>&t2=<%=(String) request.getAttribute("tarif2")%>" class="btn medium color right">Titre de transport</a>													           
                    <!--- //Content -->
                </div>
            </div>
        </main>
        <!-- //Main -->

        <!-- Footer -->
        <footer class="footer black" role="contentinfo">
            <div class="wrap">
                <div class="row">
                    <!-- Column -->
                    <article class="one-half">
                        <h6>About us</h6>
                        <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy.</p>
                    </article>
                    <!-- //Column -->

                    <!-- Column -->
                    <article class="one-fourth">
                        <h6>Need help?</h6>
                        <p>Contact us via phone or email:</p>
                        <p class="contact-data"><span class="ico phone"></span> +1 555 555 555</p>
                        <p class="contact-data"><span class="ico email"></span> <a href="mailto:help@transfers.com">help@transfers.com</a></p>
                    </article>
                    <!-- //Column -->

                    <!-- Column -->
                    <article class="one-fourth">
                        <h6>Follow us</h6>
                        <ul class="social">
                            <li class="facebook"><a href="#" title="facebook">facebook</a></li>
                            <li class="twitter"><a href="#" title="twitter">twitter</a></li>
                            <li class="gplus"><a href="#" title="gplus">google plus</a></li>
                            <li class="linkedin"><a href="#" title="linkedin">linkedin</a></li>
                            <li class="vimeo"><a href="#" title="vimeo">vimeo</a></li>
                            <li class="pinterest"><a href="#" title="pinterest">pinterest</a></li>
                        </ul>
                    </article>
                    <!-- //Column -->
                </div>

                <div class="copy">
                    <p>Copyright 2014, Themeenergy. All rights reserved. </p>

                    <nav role="navigation" class="foot-nav">
                        <ul>
                            <li><a href="#" title="Home">Home</a></li>
                            <li><a href="#" title="Blog">Blog</a></li>
                            <li><a href="#" title="About us">About us</a></li>
                            <li><a href="#" title="Contact us">Contact us</a></li>
                            <li><a href="#" title="Terms of use">Terms of use</a></li>
                            <li><a href="#" title="Help">Help</a></li>
                            <li><a href="#" title="For partners">For partners</a></li>
                        </ul>
                    </nav>
                </div>
            </div>
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