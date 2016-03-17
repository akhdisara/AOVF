<%-- 
    Document   : Questionnaire
    Created on : 16 mars 2016, 21:59:18
    Author     : vanna
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="listequestions" scope="request" class="java.util.List"></jsp:useBean>
        <jsp:useBean id="listepropositions" scope="request" class="java.util.List"></jsp:useBean>
        <%@ include file="Navigation.jsp" %>
        <title>Questionnaire</title>
    </head>
    <body>
        <h1>Enquête de satisfaction</h1>
        <div class ="text">
        <%
            String attribut=(String)request.getAttribute("message");
            out.println(attribut);
        %>
        </div>
        
        <br><br>
        <TABLE id="allTable">
            <%
                List<Question> lesQuestions=listequestions;
                for(Question q: lesQuestions){%>
                <tr><%=q.getQuestion%><tr>
            <%}%>
            <%
                List<QuestionProposition> lesPropositions=listepropositions;
                for(QuestionProposition p: lesPropositions){%>
                <tr><INPUT TYPE=RADIO NAME="choix"><%=p.getProposition%></input></tr>
            <%}%>
                
        </TABLE>
        <div class ="btn_gauche">
            <a href="Servlet?action=CreationClient"><button>Nouveau client</button></a>
        </div>
    </body>
</html>
