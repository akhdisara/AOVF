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
            <h3><%=(String) request.getAttribute("message")%></h3>
            <!-- Main -->
            <main class="main" role="main">

                <header class="site-title color">
                    <div class="wrap">
                        <div class="container">
                            <h1>Enquête de satisfaction</h1>
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
                                        <% if (q.getId() == 503 || q.getId() == 504){%>
                                        <tr id="trContenu">
                                            <td Width=5%><INPUT TYPE=text NAME="<%=q.getId()%>" </input>
                                                
                                            </td>
                                        </tr>
                                        <%} else if (q.getId() == 505) {%>
                                        <tr id="trContenu">
                                            <td Width=5%><input type="time" name="<%=q.getId()%>" placeholder="hh:mm"/>
                                            </td>
                                        </tr>
                                        <%} else {
                                         for (QuestionProposition p : q.getLesPropositions()) {%>
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