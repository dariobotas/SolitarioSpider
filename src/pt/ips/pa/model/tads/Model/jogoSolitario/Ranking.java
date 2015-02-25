/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ips.pa.model.tads.Model.jogoSolitario;

import pt.ips.pa.model.tads.Model.TADS.DNode;
import pt.ips.pa.model.tads.Model.estrategia.Versao;
import pt.ips.pa.model.tads.Model.excecoes.OutOfBoundsException;



/**
 * 
 * @author AnTRaX
 */
public class Ranking{

    private int size;
    private Lista<Jogador> adaptee;
    private Lista<Jogador> auxiliarJogador;
    private Lista<Pontuacao> auxiliarPontuacao;

    /**
     * Construtor da classe.
     *
     */
    public Ranking() {
        adaptee = new Lista<>();
        auxiliarJogador = new Lista<>();
        auxiliarPontuacao = new Lista<>();
    }
    
    /**
     * Método que retorna o tamanho da lista.
     *
     * @return
     */
    public int size() {
        return adaptee.size();
    }
    
    /**
     * Método que retorna um valor lógico confirmando se a lista se encontra vazia.
     * 
     * @return
     */
    public boolean isEmpty() {
        return size() == 0;
    }
   
    /**
     *Adiciona uma pontuação ao Ranking.
     * @param jogador
     * @throws OutOfBoundsException - caso tenha sido introduzido uma posição fora da autorizada, lança excepção.
     */
    public void addJogadorRanking(Jogador jogador) throws OutOfBoundsException {
        adaptee.add(size, jogador);
    }
    
     /**
     * Removemos uma pontuação da posição que foi enviada por parametro. 
     * @param r - posição da pontuação removida.
     * @return - a pontuação que foi removida.
     * @throws OutOfBoundsException - caso tenha sido introduzido uma posição fora da autorizada, lança excepção.
     */

    public Jogador removeJogadorRanking(int r) throws OutOfBoundsException {
        return adaptee.remove(r);
    }
    
    public Lista<Pontuacao> returnListaOrdenadaPontuacao(){
        return auxiliarPontuacao;
    }
    
    public Lista<Jogador> returnListaOrdenadaJogador(){
        return auxiliarJogador;
    }
    
    private Lista<Pontuacao> getNovaLista(Versao versao){
        Lista<Pontuacao> auxiliar = new Lista<>();
        int i,j,rank=0;
        for(i=0;i<adaptee.size();i++){//percorrer tamanho todo do adaptee
            for(j=0;j<adaptee.get(i).getPontuacao().size();j++){
                if(adaptee.get(i).getPontuacao().get(j).getVersao()==versao){//caso a pontuacao a ser vista é de maoTres
                    auxiliar.add(rank, adaptee.get(i).getPontuacao().get(j));
                    rank++;
                }
            }
        }
        return auxiliar;
    }
    
    public void getRanking(Versao versao){
        Lista<Pontuacao> auxiliar = getNovaLista(versao);
        int i;
        for(i=0;i<auxiliar.size();i++){
            if((i+1)!=auxiliar.size()){
                if(auxiliar.get(i).getValor()<auxiliar.get(i+1).getValor()){
                    auxiliar.set(i, auxiliar.get(i+1));
                }
            }
        }
        System.out.println(auxiliar.size());
        imprimirRanking(auxiliar);
    }

    private void imprimirRanking(Lista<Pontuacao> aux) {
        int x=0;
        for (int i = 0; i < 10; i++) {
            if(i>=aux.size()){
                System.out.println((i + 1) + " - *****"); 
            }else {
                for(int j=0;j<adaptee.size();j++){
                    for(int k=0;k<adaptee.get(j).getPontuacao().size();k++){
                        if(adaptee.get(j).getPontuacao().get(k).equals(aux.get(i))){
                            auxiliarJogador.add(x,adaptee.get(j));
                            auxiliarPontuacao.add(x,aux.get(i));
                            x++;
                            System.out.println((i + 1) + " - "+ adaptee.get(j).getNome()+ " - " + aux.get(i).getValor()); 
                        }   
                    }
                }
            }
        }
    }
    /**
     * Método que devolve um objecto iterador.
     *
     * @return
     */
    public Iterator getIterator() {
        return new Iterator();
    }
    
    private class Iterator<E> implements Interface.Iterator<E>{
        private DNode<Jogador> pos;

        public Iterator() {
            this.pos = adaptee.getHeader();
        }
        
        @Override
        public boolean hasNext() {
            return pos.getNext()!= pos && pos.getNext()!= null;
        }

        @Override
        public E next() {
            Jogador elemento = pos.getElemento();
            pos = pos.getNext();
            return (E) elemento;
        }
    }
}
