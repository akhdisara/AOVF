<%-- 
    Document   : ClientAfficher
    Created on : 15 mars 2016, 09:26:10
    Author     : 3092790
--%>

<%@page import="packageEntites.Abonnement"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="packageEntites.CompteBancaire"%>
<%@page import="packageEntites.Client"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="listeclients" scope="request" class="java.util.List"></jsp:useBean>
        <title>Clients</title>
    </head>
    <body>
        <%@ include file="Navigation.jsp" %>
        
        <h1 id="h1">Clients</h1>
        <br><br>
        <div class ="text">
        <%
            String attribut=(String)request.getAttribute("message");
            out.println(attribut);
        %>
        </div>
        
        <br><br>
        
        <TABLE id="allTable">
            <tr id="allTr">
                <th>Id</th>
                <th>Num client</th>
                <th>Nom</th>
                <th>Prenom</th>
                <th>Carte</th>
                <th>Solde du porte monnaie</th>
                <th></th>
                <th>Comptes bancaire</th>
                <th></th>
                <th>Abonnements</th>
                <th></th>
                
            </tr>
            <%
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                List<Client> lesClients=listeclients;
                for(Client c: lesClients){%>
                <tr>
                    <td Width=5%><%=c.getId()%></td>
                    <td Width=5%><%=c.getNumClient()%></td>
                    <td Width=15%><%=c.getNom()%></td>
                    <td Width=15%><%=c.getPrenom()%></td>
                    <td Width=15%>Expire le <%=format.format(c.getLaCarteAPuce().getDateFinValidite())%></td>
                    <td Width=15%><%=c.getLaCarteAPuce().getLePorteMonnaie().getSolde()%>€</td>
                    <td id="ligneTDModifier" Width=10%>
                        <a href="Servlet?client=<%=c.getId()%>&action=Crediter"><button>Crediter</button></a>
                    </td>
                    <td Width=15%><%if(!c.getLesComptesBancaires().isEmpty()){ 
                        for (CompteBancaire cpt: c.getLesComptesBancaires()){%><%=cpt.getNumCompte()%><%
                        }
                    }
                        else {%>Pas de compte<%}%>
                    </td>
                    <td id="ligneTDModifier" Width=10%>
                        <a href="Servlet?client=<%=c.getId()%>&action=GererCompte"><button>Gérer comptes</button></a>
                    </td>
                    <td Width=15%><%if(!c.getLaCarteAPuce().getLesAbonnements().isEmpty()){ 
                        for (Abonnement a: c.getLaCarteAPuce().getLesAbonnements()){%><%=a.getNumAbonnement()%><%
                        }
                    }
                        else {%>Pas d'abonnement<%}%>
                    </td>
                    <td id="ligneTDModifier" Width=10%>
                        <a href="Servlet?client=<%=c.getId()%>&action=GererAbonnement"><button>Gérer abonnements</button></a>
                    </td>
                    <td id="ligneTDModifier" Width=10%>
                        <a href="Servlet?modif=<%=c.getId()%>&action=ModificationClient"><button>Modifier client</button></a>
                    </td>
                </tr><%}%>
        </TABLE>
        <div class ="btn_gauche">
            <a href="Servlet?action=CreationClient"><button>Nouveau client</button></a>
        </div>
    </body>
</html>
