/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ips.pa.model.tads.Model.jogoSolitario;

import Interface.InterfaceEstrategiaOrdenarCartas;
import pt.ips.pa.model.tads.Model.excecoes.CartaInvalidaException;

/**
 *
 * @author AnTRaX
 * @param <C>
 */
public class MonteDeCartasSequencial extends MonteDeCartas{

  
      private final InterfaceEstrategiaOrdenarCartas estrategia;

    /**
     * Construtor da classe Cria um monte de cartas sequencial com o tipo de
     * estrategia(Crescente ou Decrescente)
     *
     * @param estrategia - tipo de estratégia que vai ser implementado no monte.
     */
    public MonteDeCartasSequencial(InterfaceEstrategiaOrdenarCartas estrategia) {
        super();
        this.estrategia = estrategia;
    }
    
    public InterfaceEstrategiaOrdenarCartas getEstrategia(){
        return estrategia;
    }

    /**
     * Método que insere um monte de cartas à própria instância.
     *
     * @param m
     * @throws CartaInvalidaException
     */
    public void adicionarMonteDeCartas(MonteDeCartasSequencial m) throws CartaInvalidaException {
        estrategia.adicionaCarta(this, m);
    }

}
