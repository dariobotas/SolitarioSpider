/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ips.pa.model.tads.Model.jogoSolitario;

import java.util.Random;
import pt.ips.pa.model.tads.Model.ModeloCarta.Designacao;
import pt.ips.pa.model.tads.Model.ModeloCarta.NaipeCarta;
import pt.ips.pa.model.tads.Model.TADS.DNode;
import pt.ips.pa.model.tads.Model.excecoes.OutOfBoundsException;

/**
 *
 * @author AnTRaX
 */
public class BaralhoSolitaireFX{

    private Lista<CartaSolitaireFX> adaptee;
    private static final NaipeCarta[] naipe = new NaipeCarta[8];
    private static final String[] figura = new String[13];

    /**
     * Construtor da classe.
     * 
     * 
     */
    public BaralhoSolitaireFX(int nivel) {
        adaptee = new Lista<>();
        nivelParaCriarBaralho(nivel);
    }
    
    private void nivelParaCriarBaralho(int nivel){
        for (int i=1;i<=naipe.length;i++){
        for(int j=1;j<=figura.length;j++){
        if (nivel==1){
            naipe[i] = NaipeCarta.ESPADAS;
        }else if (nivel==2){
            if(i%2==0){
                naipe[i] = NaipeCarta.COPAS;
            }else naipe[i] = NaipeCarta.ESPADAS;
        }else if(nivel==3){
            if(i==1 && i==5) naipe[i]=NaipeCarta.ESPADAS;
            else if (i==2 && i==6) naipe[i]=NaipeCarta.COPAS;
            else if (i==3 && i==7) naipe[i]=NaipeCarta.PAUS;
            else if (i==4 && i==8) naipe[i]=NaipeCarta.OUROS;
        }else naipe[i]=NaipeCarta.ESPADAS;
            //CartaSolitario carta = new CartaSolitario(j, getCarta(j).getFigura()/*CartaSolitario.class.toString()*/, naipe[i]);
            this.adicionarCarta(this.size(), new CartaSolitaireFX(j, getCarta(j).getFigura(), naipe[i]));
        }   
    }   
    }
    
    /**
     * Método que retorna o tamanho da lista de cartas
     * 
     * @return
     */
    public int size() {
        return adaptee.size();
    }
    
    public int setSizeBaralho(){
    
    return adaptee.size() + 1;
    }

    /**
     * Método que retorna um valor lógico que indica se a lista está vazia.
     *
     * @return
     */
    public boolean isEmpty() {
        return size() == 0;
    }
    
    /**
     * Método que retorna a carta que está em determinada posição da lista.
     *
     * @param r
     * @return
     * @throws OutOfBoundsException
     */
    public CartaSolitaireFX getCarta(int r) throws OutOfBoundsException {
        return adaptee.get(r);
    }

     /**
     * Método que define a carta em determinada posição da lista.
     *
     * @param r
     * @param o
     * @return
     * @throws OutOfBoundsException
     */
    public CartaSolitaireFX setCarta(int r, CartaSolitaireFX o) throws OutOfBoundsException {
        return adaptee.set(r, o);
    }
    /**
     * Método que adiciona uma carta em determinada posição da lista.
     *
     * @param r
     * @param o
     * @throws OutOfBoundsException
     */
    public void adicionarCarta(int r, CartaSolitaireFX o) throws OutOfBoundsException {
        adaptee.add(r, o);
    }
    
    /**
     * Método que elimina uma carta de determinada posição da lista.
     *
     * @param r
     * @return
     * @throws OutOfBoundsException
     */
    public CartaSolitaireFX removeCarta(int r) throws OutOfBoundsException {
        return adaptee.remove(r);
    }

    /**
     * Este metodo vai baralhar o nosso Baralho de jogo, para tal criamos uma variavel
     * Random e um Baralho auxiliar onde o definimos a null, isto porque o baralho quando é
     * criado começa com 52 cartas.
     * No while, vamos escolher posições aleatórias com o Random e adiciona-mos no Baralho auxiliar.
     * Após todas as cartas estarem introduzidas no Baralho auxiliar, vamos introduzir novamente no 
     * Baralho original.
     */
    public void baralhar() {
        Random rd = new Random();
        Lista<CartaSolitaireFX> aux = new Lista<>();

        while(!isEmpty()){
            int pos = rd.nextInt(size());
            aux.add(0, this.getCarta(pos));
            this.removeCarta(pos);
        }
            
        for(int i =0;i<aux.size();i++){
            this.adicionarCarta(size(), aux.get(i));
        }
        System.out.println(this.size());
    }
   
    /**
     * Método que retorna o objeto iterador que percorre sequencialmente a lista
     * de cartas. 
     *
     * @return
     */
    public Iterator<CartaSolitaireFX> getIterator() {
        return new Iterator();
    }
    
    /**
     * 
     * @param <E> 
     */
    private class Iterator<E> implements Interface.Iterator<E>{
        private DNode<CartaSolitaireFX> pos;

        public Iterator() {
            this.pos = adaptee.getHeader();
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