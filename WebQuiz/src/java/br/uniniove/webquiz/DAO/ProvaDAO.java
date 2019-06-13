/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uniniove.webquiz.DAO;

import br.uninove.webquiz.model.Prova;
import br.uninove.webquiz.model.Questao;
import br.uninove.webquiz.model.Resposta;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author thiagograzianitraue
 */
public class ProvaDAO {

    private static String urlBD = "jdbc:derby://localhost:1527/WebQuizz";
    private static Connection conn = null;
    private static Statement stm = null;

    public ArrayList<Prova> getProvas() throws SQLException {
        ArrayList<Prova> provas = new ArrayList<Prova>();
        conn = DriverManager.getConnection(urlBD, "uninove", "Senha123");
        stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        String select = "SELECT * FROM UNINOVE.\"tb_prova\"";

        ResultSet resultados = stm.executeQuery(select);

        while (resultados.next()) {
            Prova p = new Prova();
            p.setDescricaoProva(resultados.getString("descprova"));
            p.setIdProva(resultados.getInt("idprova"));

            provas.add(p);
        }
        conn.close();

        return provas;
    }

    public int getTotalQuestoes(int idProva) throws SQLException {
        //select count(idProva) from "tb_rel_prova_questao" where IDPROVA = 1
        conn = DriverManager.getConnection(urlBD, "uninove", "Senha123");
        stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        String select = "select count(idProva) as contagem from \"tb_rel_prova_questao\" where IDPROVA = " + idProva;
        ResultSet resultados = stm.executeQuery(select);
        int contagem = 0;
        while (resultados.next()) {
            contagem = resultados.getInt("contagem");
        }
        conn.close();
        return contagem;
    }

    public float getValorProva(int idProva) throws SQLException {
        QuestaoDAO qDAO = new QuestaoDAO();
        ArrayList<Resposta> respostas = new ArrayList<Resposta>();
        ArrayList<Questao> questoes = new ArrayList<Questao>();
        questoes = qDAO.getListaQuestoes(idProva);
        float valor = 0;
        for (Questao q : questoes) {
            respostas = q.getResposta();
            for (Resposta r : respostas) {
                valor += r.getValor();
            }
        }
        return valor;
    }

}
