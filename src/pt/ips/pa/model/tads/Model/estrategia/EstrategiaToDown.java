/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ips.pa.model.tads.Model.estrategia;

import pt.ips.pa.model.tads.Model.excecoes.CartaInvalidaException;
import pt.ips.pa.model.tads.Model.jogoSolitario.CartaSolitaireFX;
import pt.ips.pa.model.tads.Model.jogoSolitario.MonteDeCartasSequencial;

/**
 *
 * @author dario
 */
public class EstrategiaToDown implements Interface.InterfaceEstrategiaOrdenarCartas {

    /**
     * Método recebe 2 montes de cartas, faz as seguintes verificações:
     * 1- Verifica se o campo está vazio e caso a primeira carta do monte C é um Rei insere no monte
     * 2- Verifica se o campo está vazio e caso não é a primeira carta nao é um Rei lança erro
     * 3- Verifica se o monte s não está vazio e caso a primeira carta é de naipe oposto e se o valor da primeira c é igual a ultima do monte s +1, insere a carta
     * 4- Verifica se o monte s não está vazio e caso não seja do mesmo naipe ou a a carta do monte c é diferente do valor da ultima do monte s+1
     * @param destino
     * @param monteAInserir
     * @param s - monte de cartas que o monte c vai para
     * @param c - monte de cartas que vai ser mudado
     * @return 
     * @throws CartaInvalidaException 
     */
    @Override
    public void adicionaCarta(MonteDeCartasSequencial destino, MonteDeCartasSequencial monteAInserir) throws CartaInvalidaException {
        if (isJogadaVálida(destino, monteAInserir)) {
            int tamanho = monteAInserir.size();
            for (int i = 0; i < tamanho; i++) {
                destino.adicionarCarta(monteAInserir.retirarUltimaCarta());
            }
        } else {
            throw new CartaInvalidaException();
        }

    }
    

    public  static boolean isJogadaVálida(MonteDeCartasSequencial destino, MonteDeCartasSequencial monteAInserir){
        if (destino.isEmpty() && monteAInserir.verUltimaCarta().getDesignacao().getValor() == 13) {
            return true;
        } else if (destino.isEmpty() && monteAInserir.verUltimaCarta().getDesignacao().getValor() != 13) {
            return false;
        } else if (!destino.isEmpty() && CartaSolitaireFX.comparaNaipes(monteAInserir.verUltimaCarta(), destino.verUltimaCarta()) && destino.verUltimaCarta().getDesignacao().getValor() == (monteAInserir.verUltimaCarta().getDesignacao().getValor() + 1)) {
            return true;
        } else if (!destino.isEmpty() && (!CartaSolitaireFX.comparaNaipes(monteAInserir.verUltimaCarta(), destino.verUltimaCarta()) || destino.verUltimaCarta().getDesignacao().getValor() != (monteAInserir.verUltimaCarta().getDesignacao().getValor() + 1))) {
            return false;
        }
        return false;
    }
}
