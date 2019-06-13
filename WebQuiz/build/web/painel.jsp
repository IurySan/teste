<%-- 
    Document   : painel
    Created on : 28/05/2019, 16:32:00
    Author     : thiagograzianitraue
--%>

<%@page import="br.uniniove.webquiz.DAO.ProvaDAO"%>
<%@page import="br.uninove.webquiz.model.Prova"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            table, th, td{
                border: 1px solid black;
                text-align: center; 
                padding: 10px;
            }
        </style>
    </head>
    <body>
        <br/><br/><br/>
        <p>Lista de Provas disponíveis:</p>
        <br/>
        <%
            ArrayList<Prova> provas = new ArrayList<Prova>();
            ProvaDAO pDAO = new ProvaDAO();
            provas = pDAO.getProvas();

            if (provas.isEmpty()) {
                out.print("Sem provas cadastradas!");
            } else {
                out.print("<table>");
                out.print("<tr>");
                out.print("<th>Prova</th>");
                out.print("<th>Qtd. de questões</th>");
                out.print("<th>Valor da prova</th>");
                out.print("<th>Realizar prova</th>");
                out.print("<th>Editar</th>");
                out.print("<th>Excluir</th>");
                out.print("</tr>");
                for (Prova p : provas) {
                    out.print("<tr>");
                    out.print("<td>" + p.getDescricaoProva() + "</td>");
                    out.print("<td>" + pDAO.getTotalQuestoes(p.getIdProva()) + "</td>");
                    out.print("<td>" + pDAO.getValorProva(p.getIdProva()) + "</td>");
                    out.print("<td><a href=\'realizarProva.jsp?idProva=" + p.getIdProva() + "\'>Fazer</a></td>");
                    out.print("<td><a href=\'editarProva.jsp?idProva=" + p.getIdProva() + "\'>Editar</a></td>");
                    out.print("<td><a href=\'excluirProva.jsp?idProva=" + p.getIdProva() + "\'>Excluir</a></td>");
                    out.print("</tr>");
                }
                out.print("</table>");
            }
        %>
        <br/><br/>
        <a href="cadastrarProva">Cadastrar uma prova nova...</a>
        
    </body>
</html>
