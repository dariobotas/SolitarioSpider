/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ips.pa.model.tads.Model.jogoSolitario;

import pt.ips.pa.model.tads.Model.TADS.StackDinamica;
import pt.ips.pa.model.tads.Model.TADS.DNode;
import pt.ips.pa.model.tads.Model.excecoes.EmptyStackException;
import pt.ips.pa.model.tads.Model.excecoes.OutOfBoundsException;

/**
 *
 * @author AnTRaX
 * @param <C>
 */
public class MonteDeCartas {

    
    private StackDinamica<CartaSolitaireFX> adaptee;
    private int size;
    
     /**
     * Construtor da classe.
     */
    public MonteDeCartas(){
        adaptee = new StackDinamica<>();
    }
    
     /**
     *
     * @return ao tamanho do Baralho.
     */
    
    public int size() {
        return adaptee.size();
    }
     
     /**
     *
     * @return 0 caso o Baralho tenha tamanho 0.
     */
    
    public boolean isEmpty() {
        return size() == 0;
    }
    /**
     * Neste método insere-se uma carta enviada por parametro, onde será inserida no fim da fila.
     * @param elem - Carta que será inserida. 
     */
    
    public void adicionarCarta(CartaSolitaireFX elem) {
        adaptee.push(elem);
    }
    
    /**
     * Neste método irá ser removido uma carta, como é uma stack, é a ultima do monte.
     * @return - devolve a carta retirada.
     * @throws EmptyStackException - lança a excepção caso o monte esteja vazio.
     */
    
    public CartaSolitaireFX retirarUltimaCarta() throws EmptyStackException {
        return adaptee.pop();
    }
    /**
     * Este método vai devolver a ultima carta do monte.
     * @return - ultima carta do monte.
     * @throws EmptyStackException - lança a excepção caso o monte esteja vazio.
     */
    
    public CartaSolitaireFX verUltimaCarta() throws EmptyStackException {
        return adaptee.peek();
    }
 
    /**
     * Este método vai devolver a carta na posição que é enviada por parametro.
     * @param r - posição de onde a cara vai ser devolvida.
     * @return - devolve a carta.
     * @throws OutOfBoundsException - lança a excepção caso o monte esteja vazio. 
     */
    public CartaSolitaireFX getCarta(int r) throws OutOfBoundsException {
        if (r < 0 || r >= size()) {
            throw new OutOfBoundsException();
        }

        DNode<CartaSolitaireFX> aux = adaptee.nodeAtRank(r);
        return aux.getElemento();
    }
    
    /**
     * Método que retorna o objeto iterador.
     *
     * @return
     */
    public Iterator getIterator() {
        return new Iterator();
    }
    
    private class Iterator<E> implements Interface.Iterator<E>{
        private DNode<CartaSolitaireFX> pos;

        public Iterator() {
            this.pos = adaptee.getTop();
        }
        
        @Override
        public boolean hasNext() {
            return pos.getNext()!= pos && pos.getNext()!= null;
        }

        @Override
        public E next() {
            CartaSolitaireFX elemento = pos.getElemento();
            pos = pos.getNext();
            return (E) elemento;
        }
    }
}
