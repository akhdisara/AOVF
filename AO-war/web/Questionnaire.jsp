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
        <%@ include file="Navigation.jsp" %>
        <jsp:useBean id="listequestions" scope="request" class="java.util.List"></jsp:useBean>

        </head>

        <body>
         
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
                                <%for (QuestionProposition p : q.getLesPropositions()) {
                                if (q.getId() == 503){%>
                                <tr id="trContenu">
                                    <td Width=5%><INPUT TYPE=text NAME="<%=q.getId()%>" </input>
                                    </td>
                                </tr><%} else {%>
                                <tr id="trContenu">
                                    <td Width=5%><INPUT TYPE=RADIO NAME="<%=q.getId()%>" VALUE="<%=p.getId()%>"><%=p.getProposition()%></td>
                                </tr>
                                <%}%>
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