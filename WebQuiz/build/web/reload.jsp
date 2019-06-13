<%-- 
    Document   : reload
    Created on : 28/05/2019, 21:09:05
    Author     : iurysilva
--%>

<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%

          
            String descricao = request.getParameter("descricao");

            String urlBD = "jdbc:derby://localhost:1527/WebQuizz";
            Connection conn = DriverManager.getConnection(urlBD, "uninove", "Senha123");
            String ins = "insert into TB_PROVA (DESCPROVA) values(?)";
            PreparedStatement stm = conn.prepareStatement(ins);
            stm.setString(1, descricao);
            stm.executeUpdate();
            stm.close();
            conn.close();

            response.sendRedirect("painel.jsp");

        %>
    </body>
</html>
