/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uninove.webquiz.model;

import java.util.ArrayList;

/**
 *
 * @author thiagograzianitraue
 */
public class Questao {
    private int idQuestao;
    private String questao;
    private ArrayList<Resposta> resposta;

    /**
     * @return the idQuestao
     */
    public int getIdQuestao() {
        return idQuestao;
    }

    /**
     * @param idQuestao the idQuestao to set
     */
    public void setIdQuestao(int idQuestao) {
        this.idQuestao = idQuestao;
    }

    /**
     * @return the questao
     */
    public String getQuestao() {
        return questao;
    }

    /**
     * @param questao the questao to set
     */
    public void setQuestao(String questao) {
        this.questao = questao;
    }

    /**
     * @return the resposta
     */
    public ArrayList<Resposta> getResposta() {
        return resposta;
    }

    /**
     * @param resposta the resposta to set
     */
    public void setResposta(ArrayList<Resposta> resposta) {
        this.resposta = resposta;
    }
}
