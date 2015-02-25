/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ips.pa.model.tads.Model.jogoSolitario;

import pt.ips.pa.model.tads.Model.TADS.DNode;
import pt.ips.pa.model.tads.Model.excecoes.JogadorInvalidoException;
import pt.ips.pa.model.tads.Model.excecoes.OutOfBoundsException;

/**
 *
 * @author AnTRaX
 * @param <J>
 */
public class Historico {

  private int size;
    private Lista<RegistoDoHistorico> adaptee;
    private final Jogador jogador;

     /**
     * Construtor da class.
     * 
     * @param jogador
     */
    public Historico(Jogador jogador) {
        adaptee = new Lista<>();
        this.jogador = jogador;
    }
   
    /**
     * Método que retorna o tamanho da lista de cartas.
     *
     * @return
     */
    public int size() {
        return adaptee.size();
    }

    /**
     * Método que retorna um valor lógico referente ao facto de a lista estar vazia.
     *
     * @return 0 caso o Baralho tenha tamanho 0.
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Método que retorna o registo que se encontra em determinado posição da lista.
     * 
     * @param r
     * @return
     * @throws OutOfBoundsException 
     */
    public RegistoDoHistorico getHistorico(int r) throws OutOfBoundsException {
        return adaptee.get(r);
    }

    /**
     * Método que define o registo em determinada posição da lista.
     *
     * @param r
     * @param o
     * @return
     * @throws OutOfBoundsException
     */
    public RegistoDoHistorico setHistorico(int r, RegistoDoHistorico o) throws OutOfBoundsException {
        return adaptee.set(r, o);
    }
    
    /**
     * Método que adiciona um registo em determinada posição da lista.
     *
     * @param r
     * @param o
     * @throws OutOfBoundsException
     * @throws JogadorInvalidoException
     */
    public void addHistorico(int r, RegistoDoHistorico o) throws OutOfBoundsException, JogadorInvalidoException {
        adaptee.add(r, o);
    }
    
    /**
     * método que remove um registo de determinada posição da lista.
     *
     * @param r
     * @return
     * @throws OutOfBoundsException
     */
    public RegistoDoHistorico removeHistorico(int r) throws OutOfBoundsException {
        return adaptee.remove(r);
    }

    /**
     * Método que retorna um boolean confirmando se um jogador passado por parâmetro é o mesmo associado a este historico. 
     *
     * @param jogador
     * @return
     */
    public boolean isJogadorIgual(Jogador jogador){
        return (jogador.getNome().equals(this.jogador.getNome()));
    }
    
    /**
     * Método que retorna o objeto iterador que percorre a lista sequencialmente.
     *
     * @return
     */
    public Iterator getIterator() {
        return new Iterator();
    }
    
    private class Iterator<E> implements Interface.Iterator<E>{
        private DNode<RegistoDoHistorico> pos;

        public Iterator() {
            this.pos = adaptee.getHeader();
        }
        
        @Override
        public boolean hasNext() {
            return pos.getNext()!= pos && pos.getNext()!= null;
        }

        @Override
        public E next() {
            RegistoDoHistorico elemento = pos.getElemento();
            pos = pos.getNext();
            return (E) elemento;
        }
    }
}