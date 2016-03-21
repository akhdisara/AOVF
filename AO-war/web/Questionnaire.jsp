<%-- 
    Document   : Questionnaire
    Created on : 16 mars 2016, 21:59:18
    Author     : vanna
--%>

<%@page import="packageEntites.QuestionProposition"%>
<%@page import="packageEntites.Question"%>
<%@page import="java.util.List"%>
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

        <jsp:useBean id="listequestions" scope="request" class="java.util.List"></jsp:useBean>

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
                            <li><a href="index.html" title="">Home</a></li>
                            <li class="active"><a href="destinations.html" title="Destinations">Destinations</a>
                                <ul>
                                    <li><a href="destination-single.html" title="Single destination">Single destination</a></li>
                                    <li><a href="destination-micro.html" title="Micro destination">Micro destination</a></li>
                                </ul>
                            </li>
                            <li><a href="tailor-made.html" title="Tailor made">Tailor made</a></li>
                            <li><a href="blog.html" title="Blog">Blog</a>
                                <ul>
                                    <li><a href="blog.html" title="Post">Blog list</a></li>
                                    <li><a href="blog2.html" title="Post">Blog grid</a></li>
                                    <li><a href="blog-single.html" title="Post">Post</a></li>
                                </ul>
                            </li>
                            <li><a href="contact.html" title="Contact">Contact</a></li>
                            <li><a href="#" title="Pages">Pages</a>
                                <div>
                                    <div class="one-fourth">
                                        <h2>Common</h2>
                                        <ul>
                                            <li><a href="left-sidebar-page.html" title="Left sidebar page">Left sidebar page</a></li>
                                            <li><a href="right-sidebar-page.html" title="Right sidebar page">Right sidebar page</a></li>
                                            <li><a href="both-sidebar-page.html" title="Both sidebars page">Both sidebars page</a></li>
                                            <li><a href="full-width-page.html" title="Full width page">Full width page</a></li>
                                        </ul>
                                    </div>
                                    <div class="one-fourth">
                                        <h2>Booking</h2>
                                        <ul>
                                            <li><a href="search-results.html" title="Search results page">Search results page</a></li>
                                            <li><a href="booking-step1.html" title="Booking step 1">Booking step 1</a></li>
                                            <li><a href="booking-step2.html" title="Booking step 2">Booking step 2</a></li>
                                            <li><a href="booking-step3.html" title="Booking step 3">Booking step 3</a></li>
                                        </ul>
                                    </div>
                                    <div class="one-fourth">
                                        <h2>Corporate</h2>
                                        <ul>
                                            <li><a href="about.html" title="About u">About us</a></li>
                                            <li><a href="services.html" title="Services">Services</a></li>
                                            <li><a href="faq.html" title="Faq">Faq</a></li>
                                            <li><a href="contact.html" title="Contact">Contact</a></li>
                                        </ul>
                                    </div>
                                    <div class="one-fourth">
                                        <h2>Special</h2>
                                        <ul>
                                            <li><a href="login.html" title="Login">Login</a></li>
                                            <li><a href="register.html" title="Register">Register</a></li>
                                            <li><a href="error.html" title="404 error">404 error</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </li>
                            <li><a href="http://themeforest.net/user/themeenergy/portfolio" title="Purchase">Purchase</a></li>
                        </ul>
                    </nav>
                    <!-- //Main Nav -->
                </div>
            </header>
            <!-- //Header -->

            <!-- Main -->
            <!-- Main -->
            <main class="main" role="main">

                <header class="site-title color">
                    <div class="wrap">
                        <div class="container">
                            <h1>Questionnaires</h1>
                        </div>
                    </div>
                </header>

                <div class="wrap">	
                    <div class="row">

                        <div class="content offset">
                            <form method="get" action="Servlet">

                                <table class="hover">
                                <% List<Question> lesQuestions = listequestions;
                                for (Question q : lesQuestions) {%>
                                <tr id="trTitre">
                                    <th><%=q.getNumquestion()%> . <%=q.getQuestion()%></th>
                                </tr>
                                <%for (QuestionProposition p : q.getLesPropositions()) {%>
                                <tr id="trContenu">
                                    <td Width=5%><INPUT TYPE=RADIO NAME="<%=q.getId()%>" VALUE="<%=p.getId()%>"><%=p.getProposition()%></td>
                                </tr>
                                <%}%>
                                <%}%>
                            </table>
                            <input type="hidden" name="action" value="AjouterReponse">

                            <input type="submit" class="btn medium back" value="Valider"/>
                            <input type="reset" class="btn medium back" value="Remettre à zéro"/>
                        </form> 
                        <br/>
                        <br/>
                    </div>
                </div>			
            </div>
        </main>
        <!-- //Main -->

        <!-- Micro Locations -->
        <div class="white microlocations">
            <div class="wrap">
                <h3 class="wow fadeIn">Select your departure location</h3>
                <div class="row">
                    <div class="one-fourth wow fadeInUp">
                        <p><a href="destination-micro.html">Berlin Central Train Station</a></p>
                        <p><a href="destination-micro.html">Berlin Schonefeld Airport</a></p>
                        <p><a href="destination-micro.html">Berlin Tegel Airport</a></p>
                        <p><a href="destination-micro.html">Bremen Airport</a></p>
                        <p><a href="destination-micro.html">Cologne Bonn Airport</a></p>
                    </div>

                    <div class="one-fourth wow fadeInUp" data-wow-delay=".2s">
                        <p><a href="destination-micro.html">Dortmund Airport</a></p>
                        <p><a href="destination-micro.html">Dresden Airport</a></p>
                        <p><a href="destination-micro.html">Dusseldorf Airport</a></p>
                        <p><a href="destination-micro.html">Frankfurt Hahn Airport</a></p>
                        <p><a href="destination-micro.html">Frankfurt International Airport</a></p>
                    </div>

                    <div class="one-fourth wow fadeInUp" data-wow-delay=".4s">
                        <p><a href="destination-micro.html">Friedrichshafen Airport</a></p>
                        <p><a href="destination-micro.html">Hamburg Finkenwerder Airport</a></p>
                        <p><a href="destination-micro.html">Hamburg Port</a></p>
                        <p><a href="destination-micro.html">Hamburg-Fuhlsbuttel Airport</a></p>
                        <p><a href="destination-micro.html">Hanover Lengenhagen Airport</a></p>
                    </div>

                    <div class="one-fourth wow fadeInUp" data-wow-delay=".6s">
                        <p><a href="destination-micro.html">Kiel Port</a></p>
                        <p><a href="destination-micro.html">Leipzig Halle Airport</a></p>
                        <p><a href="destination-micro.html">Munich Airport</a></p>
                        <p><a href="destination-micro.html">Nuremberg Airport</a></p>
                        <p><a href="destination-micro.html">Stuttgart Airport</a></p>
                    </div>
                </div>
            </div>
        </div>
        <!-- Micro Locations -->

        <!-- Call to action -->
        <div class="color cta">
            <div class="wrap">
                <p class="wow fadeInLeft">Like what you see? Are you ready to stand out? You know what to do.</p>
                <a href="#" class="btn huge black right wow fadeInRight">Purchase theme</a>
            </div>
        </div>
        <!-- //Call to action -->

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