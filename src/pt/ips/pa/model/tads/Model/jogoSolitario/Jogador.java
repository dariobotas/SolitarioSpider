/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ips.pa.model.tads.Model.jogoSolitario;

import java.io.Serializable;
import java.util.*;
import pt.ips.pa.model.tads.Model.estrategia.EstrategiaPontos;

/**
 *
 * @author dario
 */
public class Jogador implements Serializable{
    
    private String nome;
    private String password;
    private ArrayList<Pontuacao> pontuacao;
    private Logger logger;
    
    /**
     *
     * @param nome
     * @param password
     */
    public Jogador(String nome, String password){
        this.nome = nome;
        this.password = password;
        this.pontuacao = new ArrayList<>();
        logger = new Logger(this);
    }

    /**
     *
     * @return
     */
    public Logger getLogger() {
        return logger;
    }

    /**
     *
     * @return
     */
    public String getNome() {
        return nome;
    }

    /**
     *
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @return
     */
    public ArrayList<Pontuacao> getPontuacao() {
        return pontuacao;
    }

    /**
     *
     * @param pontuacao
     */
    public void setPontuacao(ArrayList<Pontuacao> pontuacao) {
        this.pontuacao = pontuacao;
    }
    
}
