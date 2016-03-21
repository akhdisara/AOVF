<%-- 
    Document   : ClientAfficher
    Created on : 15 mars 2016, 09:26:10
    Author     : 3092790
--%>

<%@page import="packageEntites.PorteMonnaieElec"%>
<%@page import="packageEntites.Abonnement"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="packageEntites.CompteBancaire"%>
<%@page import="packageEntites.Client"%>
<%@page import="java.util.List"%>
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

                </nav>
                <!-- //Main Nav -->
            </div>
        <jsp:useBean id="listeclients" scope="request" class="java.util.List"></jsp:useBean>
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
            <%
                String attribut = (String) request.getAttribute("message");
                out.println(attribut);
            %>
            <!-- //Page info -->

            <div class="wrap">	
                <div class="row">
                    <!--- Content -->
                    <div class="content offset">

                        <table class="hover">
                            <tr>
                                <th>Num client</th>
                                <th>Nom</th>
                                <th>Carte</th>
                                <th>Solde du porte monnaie</th>
                                <th>Comptes bancaire</th>
                                <th></th>
                                <th>Abonnements</th>
                                <th></th>
                                <th></th>
                            </tr>
                            <%
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                List<Client> lesClients= listeclients;
                for(Client c: lesClients){%>
                <tr>
                    <td Width=5%><%=c.getNumClient()%></td>
                    <td Width=10%><%=c.getNom()%>&nbsp;<%=c.getPrenom()%></td>
                    
                    <td Width=10%>Expire le <%=format.format(c.getLaCarteAPuce().getDateFinValidite())%></td>
                    <% PorteMonnaieElec t = c.getLaCarteAPuce().getLePorteMonnaie() ;%>
                    <td Width=10%><%=t.getSolde()%>&euro;</td>
                    <td Width=10%><%if(!c.getLesComptesBancaires().isEmpty()){ 
                        for (CompteBancaire cpt: c.getLesComptesBancaires()){%><%=cpt.getNumCompte()%><%
                        }
                    }
                        else {%>Pas de compte<%}%>
                    </td>
                    <td id="ligneTDModifier" Width=10%>
                        <a href="Servlet?client=<%=c.getId()%>&action=GererCompte"><button>Gérer comptes</button></a>
                    </td>
                    <td Width=10%><%if(!c.getLaCarteAPuce().getLesAbonnements().isEmpty()){ 
                        for (Abonnement a: c.getLaCarteAPuce().getLesAbonnements()){%><%=a.getNumAbonnement()%><%
                        }
                    }
                        else {%>Pas d'abonnement<%}%>
                    </td>
                    <td id="ligneTDModifier" Width=10%>
                        <a href="Servlet?client=<%=c.getId()%>&action=GererAbonnementSTF"><button>Gérer abonnements STF</button></a>
                        &nbsp;<a href="Servlet?client=<%=c.getId()%>&action=GererAbonnementSTR"><button>Gérer abonnements STR</button></a>
                    </td>
                    <td id="ligneTDModifier" Width=10%>
                        <a href="Servlet?modif=<%=c.getId()%>&action=ModificationClient"><button>Modifier client</button></a>
                    </td> 
                </tr><%}%>
                        </table>

                    </div>
                </div>			
            </div>
        <div class ="btn_gauche">
            <a href="Servlet?action=CreationClient" class="btn medium color">Nouveau client</a>
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