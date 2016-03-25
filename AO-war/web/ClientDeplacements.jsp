<%-- 
    Document   : ClientDeplacements
    Created on : 20 mars 2016, 18:28:35
    Author     : Brias
--%>

<%@page import="packageEntites.Paiement"%>
<%@page import="packageEntites.SousTrajet"%>
<%@page import="packageEntites.Trajet"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="packageEntites.Client"%>
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
        <jsp:useBean id="client" scope="session" class="Client"></jsp:useBean>
        </head>

        <body>

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
            
            <div class="wrap">	
                <div class="row">
                    <center>
                        <h3>
                            Carte: <%=client.getLaCarteAPuce().getId()%>
                        <br>
                        <%=client.getNom()%> <%=client.getPrenom()%>
                        <br>
                    </h3>
                </center>
                <!--- Content -->
                <div class="content offset">

                    <table class="hover">
                        <tr id="allTr">
                            <th>Date</th>
                            <th>Depart</th>
                            <th>Arrivée</th>
                            <th>Tarif STR</th>
                            <th>Tarif STF</th>
                        </tr>
                        <%
                            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                            List<Trajet> lesTrajets = client.getLaCarteAPuce().getLesTrajets();
                            for (Trajet t : lesTrajets) {%>
                        <tr>
                            <td Width=5%><%=format.format(t.getDateTrajet())%></td>
                            <td Width=5%><%=t.getArretDepart()%></td>
                            <td Width=10%><%=t.getArretArrivee()%></td>
                            <td Width=10%><%=t.getTarifTotalSTR()%></td>
                            <td Width=10%><%=t.getTarifTotalSTF()%></td>
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