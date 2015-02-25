/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ips.pa.model.tads.Model.TADS;

import pt.ips.pa.model.tads.Model.excecoes.OutOfBoundsException;
import Interface.InterfaceList;
import Interface.Iterator;

/**
 *
 * @author dario
 * @param <E>
 */
public class ListaDinamica<E> implements InterfaceList<E>{

    private int size;
    private final DNode<E> first;
    private DNode<E> last;
    private E[] lista;
    
    /**
     * 
     */
    public ListaDinamica() {
        this.size=0;
        first=null;
        
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * 
     * @return 
     */
    @Override
    public boolean isEmpty() {
        return size==0;
    }

    /**
     * 
     * @param idx
     * @param elemento
     * @throws OutOfBoundsException 
     */
    @Override
    public void add(int idx, E elemento) throws OutOfBoundsException {
        if (idx < 0 || idx > size){
            throw new OutOfBoundsException();
        }
        DNode<E> novoNo = new DNode<>(elemento, null, null);
        
        if(isEmpty()){
            novoNo.setNext(novoNo);
            novoNo.setPrev(novoNo);
            last=novoNo;
        }else{
            DNode<E> aux;
            if(idx==size()){
                aux=last;
            }else{
                aux=nodeAtRank(idx);
            }
            
        novoNo.setNext(aux);
        novoNo.setPrev(aux.getPrev());
        
        aux.getPrev().setNext(novoNo);
        aux.setPrev(novoNo);
        
        if (idx == 0)
            last = novoNo;
        
        }size++;
        
    }
    
    public void add(E elemento){
        DNode<E> novoNo = new DNode<>(elemento, null, null);
        
        if(isEmpty()){
            novoNo.setNext(novoNo);
            novoNo.setPrev(novoNo);
            last=novoNo;
        }else{
            DNode<E> aux;
                aux=last;
            
        novoNo.setNext(aux);
        novoNo.setPrev(aux.getPrev());
        
        aux.getPrev().setNext(novoNo);
        aux.setPrev(novoNo);
        }size++;
        
    }

    /**
     * 
     * @param idx
     * @return
     * @throws OutOfBoundsException 
     */
    @Override
    public E remove(int idx) throws OutOfBoundsException {
        if(idx < 0 || idx >= size()){
      throw new OutOfBoundsException();
      }else if(isEmpty()){
            last=null;
        }
    
    DNode<E> node = nodeAtRank(idx);
    DNode<E> prevNode = node.getPrev();
    DNode<E> nextNode = node.getNext();
    prevNode.setNext(nextNode);
    nextNode.setPrev(prevNode);
    size--;
    return node.getElemento();
    }
    
    public boolean remove(Object o) {
        if (o == null) {
            for (int index = 0; index < size; index++)
                if (lista[index] == null) {
                    size--;
                    return true;
                }
        } else {
            for (int index = 0; index < size; index++)
                if (o.equals(lista[index])) {
                    size--;
                    return true;
                }
        }
        return false;
    }

    /**
     * 
     * @param idx
     * @return
     * @throws OutOfBoundsException 
     */
    @Override
    public E get(int idx) throws OutOfBoundsException {
        if(idx < 0 || idx > size()){
      throw new OutOfBoundsException();
      }
     
     return nodeAtRank(idx).getElemento();
    }

    /**
     * 
     * @param idx
     * @param elemento
     * @return
     * @throws OutOfBoundsException 
     */
    @Override
    public E set(int idx, E elemento) throws OutOfBoundsException {
        if(idx < 0 || idx >= size()){
      throw new OutOfBoundsException();
      }
      
      DNode<E> aux = nodeAtRank(idx);
      E elementoAux = aux.getElemento();
      aux.setElemento(elemento);
      
      return elementoAux;
    }
    
    /**
     * 
     * @param idx
     * @return 
     */
    private DNode<E> nodeAtRank(int idx){
        DNode<E> aux = last;
        for (int i = 0; i < idx; i++) {
            aux = aux.getNext();
        }
        return aux;
    }
    
    public int lastIndexOf(Object o) {
        if (o == null) {
            for (int i = size-1; i >= 0; i--)
                if (lista[i]==null)
                    return i;
        } else {
            for (int i = size-1; i >= 0; i--)
                if (o.equals(lista[i]))
                    return i;
        }
        return -1;
    }
    
    /**
     * 
     * @return 
     */
    public Iterator getIterator(){
    return new IterarListaDinamica();
    }
    
    /**
     * 
     */
    public class IterarListaDinamica implements Iterator<E>{
    
        private int position;
        
        public IterarListaDinamica(){
        position = 0;
        }

        @Override
        public E next() {
            return lista[position++];
        }

        @Override
        public boolean hasNext() {
            return position <= size - 1;
        }
        
        
    }
    
}
