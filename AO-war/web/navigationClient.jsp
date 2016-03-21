<%-- 
    Document   : navigationClient
    Created on : 21 mars 2016, 12:20:03
    Author     : 3099709
--%>

<%@page import="packageEntites.Client"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
        <meta name="keywords" content="THEMELOCK.COM - Private Transport and Car Hire HTML Template" />
        <meta name="description" content="THEMELOCK.COM - Private Transport and Car Hire HTML Template">
        <meta name="author" content="themeenergy.com">

        <title>THEMELOCK.COM - Home</title>

        <link rel="stylesheet" href="css/theme-red.css" />
        <link rel="stylesheet" href="css/style.css" />
        <link rel="stylesheet" href="css/animate.css" />
        <link href='http://fonts.googleapis.com/css?family=Raleway:400,500,600,700|Montserrat:400,700' rel='stylesheet' type='text/css'>
        <link rel="shortcut icon" href="images/favicon.ico" />
        <jsp:useBean id="client" scope="session" class="Client" ></jsp:useBean>
        <title>Menu Client</title>
    </head>
    <body class="home">
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
                                <li><a href="Servlet?action=lignesSTR" title="Lignes STR">Lignes</a></li>
                                <li><a href="Servlet?action=listReductionsSTR" title="Abonnements STR">Abonnements</a></li>
                            </ul>
                        </li>
                        <li><a href="blog.html" title="Blog">STF</a>
                            <ul>
                                <li><a href="Servlet?action=AfficherLignesSTF" title="Post">Lignes</a></li>
                                <li><a href="Servlet?action=listAbonnementsSTF" title="Post">Abonnements</a></li>
                            </ul>
                        </li>
                        <li><a href="Servlet?action=AfficherQuestionnaire" title="Questionnaires">Questionnaires</a></li>
                        <li><%=client.getPrenom()%> <%=client.getNom()%></li>
                    </ul>
                </nav>
                <!-- //Main Nav -->
            </div>
        </header>
        <!-- //Header -->
        
    </body>
</html>
