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
public class RespostaDAO {

    private static String urlBD = "jdbc:derby://localhost:1527/WebQuizz";
    private static Connection conn = null;
    private static Statement stm = null;

    public ArrayList<Resposta> getListaRespostas(int idQuestao) throws SQLException {
        ArrayList<Resposta> respostas = new ArrayList<Resposta>();
        conn = DriverManager.getConnection(urlBD, "uninove", "Senha123");
        stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        String select = "select resp.\"idResposta\", resp.\"resposta\", resp.\"valor\", resp.\"correta\" from \n"
                + "    \"tb_resposta\" as resp,\n"
                + "    \"tb_rel_questao_resp\" as rel\n"
                + "where\n"
                + "    resp.\"idResposta\" = rel.IDRESPOSTA\n"
                + "and rel.IDQUESTAO = " + idQuestao;

        ResultSet resultados = stm.executeQuery(select);

        while (resultados.next()) {
            Resposta r = new Resposta();
            r.setIdResposta(resultados.getInt("idresposta"));
            r.setResposta(resultados.getString("resposta"));
            r.setValor(resultados.getFloat("valor"));
            r.setCorreta(resultados.getBoolean("correta"));
            respostas.add(r);
        }
        conn.close();

        return respostas;
    }
}
