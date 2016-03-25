<%-- 
    Document   : AbonnementSTFGerer
    Created on : 18 mars 2016, 09:52:13
    Author     : 3092790
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="webservice.Gare"%>
<%@page import="webservice.Ligne"%>
<%@page import="packageEntites.Abonnement"%>
<%@page import="java.util.List"%>
<%@page import="packageEntites.Client"%>
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

        <jsp:useBean id="client" scope="request" class="Client"></jsp:useBean>
        <jsp:useBean id="listegares" scope="request" class="java.util.List"></jsp:useBean>
        <jsp:useBean id="listelignes" scope="request" class="java.util.List"></jsp:useBean>
        <title>Gerer abonnement STF</title>
    </head>
    <body>
        <%@ include file="Navigation.jsp" %>
        
        <h1 id="h1">Gestion des abonnements STF</h1>
        <br><br>
        <div class ="text">
        <%
            String attribut=(String)request.getAttribute("message");
            out.println(attribut);
        %>
        </div>
        
        <br><br>
        <%List<Abonnement> listeAbo = (List<Abonnement>)request.getAttribute("listeabos");
        List<Abonnement> listeAboSTF = new ArrayList();
        if(listeAbo.isEmpty()){%>Aucun abonnement enregistré pour ce client<%}
        else {
            for (Abonnement abo : listeAbo){
                if (abo.getType().startsWith("STF")){
                    listeAboSTF.add(abo);
                }
            }
        }
        if (listeAboSTF.isEmpty()){%>Aucun abonnement enregistré pour ce client<%}
        else { 
        %>
            <TABLE id="allTable">
            <tr id="allTr">
                <th>Id</th>
                <th>N°abonnement</th>
                <th>Type abonnement</th>
                <th>Ligne empruntée</th>
                <th>Départ</th>
                <th>Arrivée</th>
                <th>Tarif</th>
                <th></th>
                <th></th>
            </tr>
            <%
                for(Abonnement abo: listeAboSTF){%>
                <tr>
                    <td Width=5%><%=abo.getId()%></td>
                    <td Width=5%><%=abo.getNumAbonnement()%></td>
                    <td Width=15%><%=abo.getType()%></td>
                    <td Width=15%><%=abo.getLeSousTrajet().getLigne()%></td>
                    <td Width=15%><%=abo.getLeSousTrajet().getArretDepart()%></td>
                    <td Width=15%><%=abo.getLeSousTrajet().getArretArrivee()%></td>
                    <td Width=15%><%=abo.getMontant()%>€</td>
                    <td id="ligneTDModifier" Width=10%>
                        <a href="Servlet?abo=<%=abo.getId()%>&action=ModificationAbonnement&client=<%=client.getId()%>"><button>Modifier</button></a>
                    </td>
                    <td id="ligneTDModifier" Width=10%>
                        <a href="Servlet?abo=<%=abo.getId()%>&action=SupprimerAbonnement"><button>Supprimer</button></a>
                    </td>
                </tr><%}%>
        </TABLE>
            <%}%>

                    </div>
                </div>			
            </div>
             <div class="full-width">
                    <form method="get" action="Servlet">
            
                <legend> Ajouter un nouvel abonnement STF : </legend>
                <br>
                    <TABLE>
                        <tr>
                            <td Width=100px><label for="num">Numéro abonnement<span class="requis">*</span></label></td>
                            <td Width=200px><input type="text" name="num" value="" size="50" maxlength="20" /></td>
                        </tr>
                        <tr>
                            <td Width=100px><label for="type">Type d'abonnement<span class="requis">*</span></label></td>
                            <td Width=200px><select name="type">
                                <option value="scolaire">Scolaire</option>
                                <option value="mensuel">Mensuel</option>
                                <option value="hebdomadaire">Hebdomadaire</option></select></td>
                        </tr>
                        <tr>
                            <td Width=100px><label for="ligne">Ligne<span class="requis">*</span></label></td>
                            <td Width=200px><select name="ligne">
                        <%
                            List<Ligne> lesLignes = listelignes;
                            for (Ligne l : lesLignes) {%>
                                <option value='<%=l.getId()%>'><%=l.getNumLigne()%></option> 
                                <%}%></select></td>
                        </tr>
                        <tr>
                            <td Width=100px><label for="depart">Départ<span class="requis">*</span></label></td>
                            <td Width=200px><select name="garedepart">
                        <%
                            List<Gare> lesGaresArrivee = listegares;
                            for (Gare g : lesGaresArrivee) {%>
                                <option value='<%=g.getNomGare()%>'><%=g.getNomGare()%></option> 
                                <%}%></select></td>
                        </tr>
                        <tr>
                            <td Width=100px><label for="arrivee">Arrivée<span class="requis">*</span></label></td>
                            <td Width=200px><select name="garearrivee">
                        <%
                            List<Gare> lesGaresDepart = listegares;
                            for (Gare g : lesGaresDepart) {%>
                                <option value='<%=g.getNomGare()%>'><%=g.getNomGare()%></option> 
                                <%}%></select></td>
                        </tr>
                    </TABLE>
                <br/>

                <input type="hidden" name="action" value="AbonnementSTFAjouter">
                <input type="hidden" name="client" value="<%=client.getId()%>">

                <input type="submit" value="Valider" class="btn color medium"/>
                <input type="reset" value="Remettre à zéro" class="btn medium color"/>
                <br/>
        </form>
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
