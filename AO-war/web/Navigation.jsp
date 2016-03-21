<%-- 
    Document   : Navigation
    Created on : 15 mars 2016, 09:12:10
    Author     : 3092790
--%>
<%@page import="packageEntites.Employe"%>
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

        <title>AO</title>

        <link rel="stylesheet" href="css/theme-red.css" />
        <link rel="stylesheet" href="css/style.css" />
        <link rel="stylesheet" href="css/animate.css" />
        <link href='http://fonts.googleapis.com/css?family=Raleway:400,500,600,700|Montserrat:400,700' rel='stylesheet' type='text/css'>
        <link rel="shortcut icon" href="images/favicon.ico" />
   
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
                        <% Client cl = (Client) session.getAttribute("client");%>
                        <% Employe e = (Employe) session.getAttribute("employe");%>
                <!-- Main Nav -->
                <nav role="navigation" class="main-nav">
                    <ul>
                        <li class="active"><a href="index.jsp" title="">accueil</a></li>
                        <li><a href="" title="Destinations">STR</a>
                            <ul>
                                <li><a href="Servlet?action=lignesSTR" title="Lignes STR">Lignes</a></li>
                                <li><a href="Servlet?action=listReductionsSTR" title="Abonnements STR">Abonnements</a></li>
                            </ul>
                        </li>
                        <li><a href="" title="Blog">STF</a>
                            <ul>
                                <li><a href="Servlet?action=AfficherLignesSTF" title="Post">Lignes</a></li>
                                <li><a href="Servlet?action=listAbonnementsSTF" title="Post">Abonnements</a></li>
                            </ul>
                        </li>
                        <li><a href="Servlet?action=AfficherQuestionnaire" title="Questionnaires">Questionnaires</a></li>
                        
                        <% if (cl == null && e == null){%>
                            <li><a href="login.jsp" title="Contact">Connexion</a></li>
                        <%}
                        else if (cl != null){%> 
                            <li><a href="Servlet?action=ReleveDeplacement" title="Mes déplacements">Mes déplacements</a></li>
                            <li><a href="Servlet?action=Deconnexion" title="Déconnexion">Déconnexion</a></li>
                            <li><%= cl.getPrenom()%> <%= cl.getNom()%></li>
                        <%}
                        else if (e != null){%> 
                            <li><a href="Servlet?action=AfficherClients" title="Gestion Client">Gestion Client</a></li>
                            <li><a href="Servlet?action=Deconnexion" title="Déconnexion">Déconnexion</a></li>
                            <li><%= e.getPrenom()%> <%= e.getNom()%></li>
                        <%}%>
                        
                       </ul>
                </nav>
                <!-- //Main Nav -->
            </div>
        </header>
        <!-- //Header -->
        
    </body>
</html>
