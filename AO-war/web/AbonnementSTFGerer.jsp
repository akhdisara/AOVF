<%-- 
    Document   : AbonnementSTFGerer
    Created on : 18 mars 2016, 09:52:13
    Author     : 3092790
--%>

<%@page import="webservice.Gare"%>
<%@page import="webservice.Ligne"%>
<%@page import="packageEntites.Abonnement"%>
<%@page import="java.util.List"%>
<%@page import="packageEntites.Client"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
        <%if(client.getLaCarteAPuce().getLesAbonnements().isEmpty()){%>Aucun abonnement enregistré pour ce client<%}
        else {%>
            <TABLE id="allTable">
            <tr id="allTr">
                <th>Id</th>
                <th>N°abonnement</th>
                <th>Type abonnement</th>
                <th>Ligne empruntée</th>
                <th>Départ</th>
                <th>Arrivée</th>
                <th>Tarif</th>
            </tr>
            <%
                List<Abonnement> lesAbo=client.getLaCarteAPuce().getLesAbonnements();
                for(Abonnement abo: lesAbo){%>
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
            <%}%> <!--Fin du if(le client a un abonnement)-->
            <br><br><br>
            
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
                                <option value="hebdo">Hebdomadaire</option></select></td>
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
                                <option value='<%=g.getId()%>'><%=g.getNomGare()%></option> 
                                <%}%></select></td>
                        </tr>
                        <tr>
                            <td Width=100px><label for="arrivee">Arrivée<span class="requis">*</span></label></td>
                            <td Width=200px><select name="garearrivee">
                        <%
                            List<Gare> lesGaresDepart = listegares;
                            for (Gare g : lesGaresDepart) {%>
                                <option value='<%=g.getId()%>'><%=g.getNomGare()%></option> 
                                <%}%></select></td>
                        </tr>
                    </TABLE>
                <br/>

                <input type="hidden" name="action" value="AbonnementSTFAjouter">
                <input type="hidden" name="client" value="<%=client.getId()%>">

                <input type="submit" value="Valider"/>
                <input type="reset" value="Remettre à zéro"/>
                <br/>
        </form>
    </body>
</html>
