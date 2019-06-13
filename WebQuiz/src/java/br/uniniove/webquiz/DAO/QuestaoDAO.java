/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uniniove.webquiz.DAO;

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
public class QuestaoDAO {

    private static String urlBD = "jdbc:derby://localhost:1527/WebQuizz";
    private static Connection conn = null;
    private static Statement stm = null;

    public ArrayList<Questao> getListaQuestoes(int idProva) throws SQLException {
        ArrayList<Questao> questoes = new ArrayList<Questao>();
        conn = DriverManager.getConnection(urlBD, "uninove", "Senha123");
        stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        String select = "select quest.IDQUESTAO, quest.QUESTAO from \n"
                + "    \"tb_questao\" as quest,\n"
                + "    \"tb_rel_prova_questao\" as rel\n"
                + "where\n"
                + "    quest.IDQUESTAO = rel.IDQUESTAO\n"
                + "and rel.IDPROVA = " + idProva;

        ResultSet resultados = stm.executeQuery(select);

        while (resultados.next()) {
            Questao q = new Questao();
            q.setIdQuestao(resultados.getInt("IDQUESTAO"));
            q.setQuestao(resultados.getString("QUESTAO"));
            
            ArrayList<Resposta> respostas = new ArrayList<Resposta>();
            RespostaDAO rDAO = new RespostaDAO();
            respostas = rDAO.getListaRespostas(q.getIdQuestao());
            q.setResposta(respostas);
           
            questoes.add(q);
        }
        conn.close();

        return questoes;
    }

}
