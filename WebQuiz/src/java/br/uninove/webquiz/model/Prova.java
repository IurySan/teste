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
public class Prova {
    private int idProva;
    private String descricaoProva;
    private ArrayList<Questao> questoes;

    public int getIdProva() {
        return idProva;
    }

    public void setIdProva(int idProva) {
        this.idProva = idProva;
    }

    public String getDescricaoProva() {
        return descricaoProva;
    }

    public void setDescricaoProva(String descricaoProva) {
        this.descricaoProva = descricaoProva;
    }

    public ArrayList<Questao> getQuestoes() {
        return questoes;
    }

    public void setQuestoes(ArrayList<Questao> questoes) {
        this.questoes = questoes;
    }
}
