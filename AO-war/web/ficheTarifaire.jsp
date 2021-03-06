<%-- 
    Document   : detailLigne
    Created on : 9 mars 2016, 01:08:32
    Author     : Sara
--%>

<%@page import="webservice.PositionArretLigne"%>
<%@page import="webservice.LigneSTR"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Collection"%>
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
            <%
                LigneSTR ligne = (LigneSTR) request.getAttribute("ligne");
            %>                
            <header class="site-title color">
                <div class="wrap">
                    <div class="container">
                        <h1>Fiche Tarifaires &nbsp;<%=ligne.getIdentifiant()%></h1>
                    </div>
                </div>
            </header>
            <!-- //Page info -->

            <div class="wrap">	

                <h1>Tarif de Base</h1>
                <table border="1">
                    <tr>
                        <td>Départ</td>
                        <td>Arrivée - Tarif</td>
                    </tr>
                    <%
                        int i = 0;
                        List<PositionArretLigne> listePos = (List) request.getAttribute("PositionsArretLigne");
                        for (i = 0; i < listePos.size() - 1; i++) {%>
                    <tr>
                        <td><%= listePos.get(i).getArret().getNom()%></td>
                        <td>
                            <%
                                for (int j = i + 1; j < listePos.size(); j++) {
                                    String val = (String) request.getAttribute("tarif_" + listePos.get(i).getArret().getNom() + "_" + listePos.get(j).getArret().getNom());
                                    if (val == null) {
                                        val = "";
                                    }
                            %>

                            <label size="10"> <%= listePos.get(j).getArret().getNom()%></label>
                            <input readonly type="text" value="<%=val%>" size="10" />
                            <br/>
                            <%}%>

                        </td>

                    </tr>
                    <%}%>

                </table>

                <h1>Tarif Mensuel</h1>
                <table border="1">
                    <tr>
                        <td>Départ</td>
                        <td>Arrivée - Tarif</td>
                    </tr>
                    <%
                        List<PositionArretLigne> listePosM = (List) request.getAttribute("PositionsArretLigne");;
                        for (int k = 0; k < listePosM.size() - 1; k++) {%>
                    <tr>
                        <td><%= listePosM.get(k).getArret().getNom()%></td>
                        <td>
                            <%
                                for (int j = k + 1; j < listePosM.size(); j++) {
                                    String val = (String) request.getAttribute("tarifM_" + listePos.get(k).getArret().getNom() + "_" + listePos.get(j).getArret().getNom());
                                    if (val == null) {
                                        val = "";
                                    }
                            %>
                            <label size="10"> <%= listePosM.get(j).getArret().getNom()%></label>
                            <input type="text" readonly  value="<%=val%>" size="10" />
                            <br/>
                            <%}%>

                        </td>

                    </tr>
                    <%}%>

                </table>

                <h1>Tarif Hebdomadaire</h1>
                <table border="1">
                    <tr>
                        <td>Départ</td>
                        <td>Arrivée - Tarif</td>
                    </tr>
                    <%
                        List<PositionArretLigne> listePosH = (List) request.getAttribute("PositionsArretLigne");;
                        for (int k = 0; k < listePosH.size() - 1; k++) {%>
                    <tr>
                        <td><%= listePosH.get(k).getArret().getNom()%></td>
                        <td>
                            <%
                                for (int j = k + 1; j < listePosH.size(); j++) {
                                    String val = (String) request.getAttribute("tarifM_" + listePos.get(k).getArret().getNom() + "_" + listePos.get(j).getArret().getNom());
                                    if (val == null) {
                                        val = "";
                                    }
                            %>
                            <label size="10"> <%= listePosH.get(j).getArret().getNom()%></label>
                            <input type="text" readonly value="<%=val%>"  size="10" />
                            <br/>
                            <%}%>

                        </td>

                    </tr>
                    <%}%>

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