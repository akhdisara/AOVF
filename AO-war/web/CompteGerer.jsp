<%-- 
    Document   : CompteGerer
    Created on : 15 mars 2016, 13:59:11
    Author     : 3092790
--%>

<%@page import="java.util.List"%>
<%@page import="packageEntites.CompteBancaire"%>
<%@page import="packageEntites.Client"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="Navigation.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="client" scope="request" class="Client"></jsp:useBean>
        <title>Gestion compte</title>
    </head>
    <body>
        
        <!-- Main -->
        <main class="main" role="main">
            <!-- Page info -->
            <header class="site-title color">
                <div class="wrap">
                    <div class="container">
                        <h1>Gestion des informations bancaires</h1>
                    </div>
                </div>
            </header>
        
        <br><br>
        <div class ="text">
        <%
            String attribut=(String)request.getAttribute("message");
            out.println(attribut);
        %>
        </div>
        
        <br><br>
        <%if(client.getLesComptesBancaires().isEmpty()){%>Aucun compte enregistré pour ce client<%}
        else {%>
            <!-- //Page info -->

            <div class="wrap">	
                <div class="row">
                    <!--- Content -->
                    <div class="content offset">

                        <table class="hover">
                            <tr>
                                <th>Id</th>
                                <th>Num compte</th>
                                <th>Titulaire</th>
                                <th>Banque</th>
                                <th>N°guichet</th>
                            </tr>
            <%
                List<CompteBancaire> lesCpt=client.getLesComptesBancaires();
                for(CompteBancaire cpt: lesCpt){%>
                <tr>
                    <td Width=5%><%=cpt.getId()%></td>
                    <td Width=5%><%=cpt.getNumCompte()%></td>
                    <td Width=15%><%=cpt.getTitulaire()%></td>
                    <td Width=15%><%=cpt.getNomBanque()%></td>
                    <td Width=15%><%=cpt.getCodeGuichet()%></td>
                    <td id="ligneTDModifier" Width=10%>
                        <a href="Servlet?compte=<%=cpt.getId()%>&action=ModificationCompte&client=<%=client.getId()%>"><button>Modifier</button></a>
                    </td>
                    <td id="ligneTDModifier" Width=10%>
                        <a href="Servlet?compte=<%=cpt.getId()%>&action=SupprimerCompte"><button>Supprimer</button></a>
                    </td>
                </tr><%}%>
        </TABLE>
            <%}%> <!--Fin du if(le client a un compte)-->
            <br><br><br>
            
        <form method="get" action="Servlet">
            
                <legend> Lier un nouveau compte : </legend>
                <br>
                    <TABLE>
                        <tr>
                            <td Width=100px><label for="num">Numéro du compte<span class="requis">*</span></label></td>
                            <td Width=200px><input type="text" name="num" value="" size="50" maxlength="20" /></td>
                        </tr>
                        <tr>
                            <td Width=100px><label for="titulaire">Nom titulaire<span class="requis">*</span></label></td>
                            <td Width=200px><input type="text" name="titulaire" value="" size="50" maxlength="20" /></td>
                        </tr>
                        <tr>
                            <td Width=100px><label for="bq">Nom banque <span class="requis">*</span></label></td>
                            <td Width=200px><input type="text" name="banque" value="" size="50" maxlength="20" /></td>
                        </tr>
                        <tr>
                            <td Width=100px><label for="gui">N°Guichet <span class="requis">*</span></label></td>
                            <td Width=200px><input type="text" name="guichet" value="" size="50" maxlength="20" /></td>
                        </tr>
                    </TABLE>
                <br/>

                <input type="hidden" name="action" value="CompteAjouter">
                <input type="hidden" name="client" value="<%=client.getId()%>">

                <input type="submit" value="Valider"/>
                <input type="reset" value="Remettre à zéro"/>
                <br/>
        </form>
                </div>
                </div>
            </div>
        </main>
        <!-- //Main -->
    </body>
</html>
