<%-- 
    Document   : AbonnementGerer
    Created on : 15 mars 2016, 16:29:30
    Author     : 3092790
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="webservice.LigneSTR"%>
<%@page import="webservice.Arret"%>
<%@page import="packageEntites.Abonnement"%>
<%@page import="java.util.List"%>
<%@page import="packageEntites.Client"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="client" scope="request" class="Client"></jsp:useBean>
        <jsp:useBean id="listearrets" scope="request" class="java.util.List"></jsp:useBean>
        <jsp:useBean id="listelignesSTR" scope="request" class="java.util.List"></jsp:useBean>
        <title>Gestion abonnement STR</title>
    </head>
    <body>
        <%@ include file="Navigation.jsp" %>
        
        <h1 id="h1">Gestion des abonnements STR</h1>
        <br><br>
        <div class ="text">
        <%
            String attribut=(String)request.getAttribute("message");
            out.println(attribut);
        %>
        </div>
        
        <br><br>
        <% List<Abonnement> listeAboSTR = new ArrayList();
        if(!client.getLaCarteAPuce().getLesAbonnements().isEmpty()){
            List<Abonnement> listAbo = client.getLaCarteAPuce().getLesAbonnements();
            for (Abonnement abo : listAbo){
                if (abo.getType().startsWith("STR")){
                    listeAboSTR.add(abo);
                }
            }
        }
        if (listeAboSTR.isEmpty()){%>Aucun abonnement enregistré pour ce client<%}
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
            </tr>
            <%
                for(Abonnement abo: listeAboSTR){%>
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
            
                <legend> Ajouter un nouvel abonnement STR : </legend>
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
                            List<LigneSTR> lesLignes = listelignesSTR;
                            for (LigneSTR l : lesLignes) {%>
                                <option value='<%=l.getId()%>'><%=l.getIdentifiant()%></option> 
                                <%}%></select></td>
                        </tr>
                        <tr>
                            <td Width=100px><label for="depart">Départ<span class="requis">*</span></label></td>
                            <td Width=200px><select name="arretdepart">
                        <%
                            List<Arret> lesArretsDepart = listearrets;
                            for (Arret a : lesArretsDepart) {%>
                                <option value='<%=a.getNom()%>'><%=a.getNom()%></option> 
                                <%}%></select></td>
                        </tr>
                        <tr>
                            <td Width=100px><label for="arrivee">Arrivée<span class="requis">*</span></label></td>
                            <td Width=200px><select name="arretarrivee">
                        <%
                            List<Arret> lesArretsArrivee = listearrets;
                            for (Arret a : lesArretsArrivee) {%>
                                <option value='<%=a.getNom()%>'><%=a.getNom()%></option> 
                                <%}%></select></td>
                        </tr>
                    </TABLE>
                <br/>

                <input type="hidden" name="action" value="AbonnementSTRAjouter">
                <input type="hidden" name="client" value="<%=client.getId()%>">

                <input type="submit" value="Valider"/>
                <input type="reset" value="Remettre à zéro"/>
                <br/>
        </form>
    </body>
</html>
