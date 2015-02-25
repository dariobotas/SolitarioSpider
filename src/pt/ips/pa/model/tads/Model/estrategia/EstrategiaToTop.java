/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ips.pa.model.tads.Model.estrategia;

import pt.ips.pa.model.tads.Model.excecoes.MovimentoInvalidoException;
import pt.ips.pa.model.tads.Model.ModeloCarta.FiguraCarta;
import pt.ips.pa.model.tads.Model.excecoes.CartaInvalidaException;
import pt.ips.pa.model.tads.Model.jogoSolitario.MonteDeCartasSequencial;

/**
 *
 * @author dario
 */
public class EstrategiaToTop implements Interface.InterfaceEstrategiaOrdenarCartas{

    /**
     * Método recebe 2 montes de cartas, faz as seguintes verificações:
     * 1- Verifica se o campo está vazio e caso a primeira carta do monte C é Ás Rei insere no monte
     * 2- Verifica se o campo está vazio e caso não é a primeira carta nao é um Ás lança erro
     * 3- Verifica se o monte s não está vazio e caso a primeira carta é de naipe oposto e se o valor da primeira c é igual a ultima do monte s -1, insere a carta
     * 4- Verifica se o monte s não está vazio e caso não seja do mesmo naipe ou a a carta do monte c é diferente do valor da ultima do monte s-1
     * @param s - monte de cartas que o monte c vai para
     * @param c - monte de cartas que vai ser mudado
     * @throws CartaInvalidaException 
     */
    @Override
    public void adicionaCarta(MonteDeCartasSequencial s, MonteDeCartasSequencial c) throws CartaInvalidaException{
      
        if(s.isEmpty() && c.getCarta(0).getDesignacao().getValor()!=1){
            throw new CartaInvalidaException();
        } else if(s.isEmpty() && c.getCarta(0).getDesignacao().getValor()==1){
                for(int i=0;i<c.size();i++){
                    s.adicionarCarta(c.getCarta(i));
                }
        } else if(!s.isEmpty() && s.verUltimaCarta().getDesignacao().getValor()==(c.getCarta(0).getDesignacao().getValor()-1) && c.getCarta(0).getNaipe()==s.verUltimaCarta().getNaipe()){
                
            for(int i=0;i<c.size();i++){
                    s.adicionarCarta(c.getCarta(i));
                }
        } else if(!s.isEmpty() && (s.verUltimaCarta().getDesignacao().getValor()!=(c.getCarta(0).getDesignacao().getValor()-1)) || s.verUltimaCarta().getNaipe()!=c.getCarta(0).getNaipe()){
            throw new CartaInvalidaException();
        }
    }
    
        public static boolean isJogadaVálida(MonteDeCartasSequencial destino, MonteDeCartasSequencial monteAInserir){
        if (destino.isEmpty() && monteAInserir.getCarta(monteAInserir.size()-1).getDesignacao().getValor() == 1) {
            return true;
        } else if (destino.isEmpty() && monteAInserir.getCarta(monteAInserir.size()-1).getDesignacao().getValor() != 1) {
            return false;
        } else if (!destino.isEmpty() && destino.verUltimaCarta().getNaipe() == monteAInserir.verUltimaCarta().getNaipe() && destino.verUltimaCarta().getDesignacao().getValor() == (monteAInserir.getCarta(monteAInserir.size()-1).getDesignacao().getValor() - 1)) {
            return true;
        } else if (!destino.isEmpty() && destino.verUltimaCarta().getNaipe() != monteAInserir.verUltimaCarta().getNaipe() || destino.verUltimaCarta().getDesignacao().getValor() != (monteAInserir.getCarta(monteAInserir.size()-1).getDesignacao().getValor() - 1)) {
            return false;
        }
        return false;
    }
}
