<%-- 
    Document   : Questionnaire
    Created on : 16 mars 2016, 21:59:18
    Author     : vanna
--%>

<%@page import="packageEntites.QuestionProposition"%>
<%@page import="packageEntites.Question"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="listequestions" scope="request" class="java.util.List"></jsp:useBean>
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
        <form method="get" action="Servlet">
        <br><br>
            <%
                List<Question> lesQuestions=listequestions;
                for(Question q: lesQuestions){%>
                <%=q.getNumquestion()%> . <%=q.getQuestion()%><br>
                
                <%for(QuestionProposition p: q.getLesPropositions()){%>
                <INPUT TYPE=RADIO NAME="<%=q.getId()%>" VALUE="<%=p.getId()%>"><%=p.getProposition()%></input><br>
                <%}%>
            <%}%>
       
                
        </TABLE
        
        <input type="hidden" name="action" value="AjouterReponse">

                <input type="submit" value="Valider"/>
                <input type="reset" value="Remettre à zéro"/>
        </form>    
    </body>
</html>
