/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ips.pa.model.tads.Model.jogoSolitario;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;

/**
 *
 * @author AnTRaX
 */
public class GameDataFiles implements Observer, Serializable{
    
 private int nLogs;
    private String nick;
    private Move move;

    public GameDataFiles(Jogador jogador){
        nLogs = 0;
        nick = jogador.getNome();
    }

    public GameDataFiles(){
        
    }
    
    public void novoJogador(){
        File ficheiroJogador = new File("DataFile.dat");
    }
    
    /**
     * Método para adicionar jogadores a um ficheiro
     * @param jogador jogador que inicia o jogo
     * @throws ClassNotFoundException
     * @throws FileNotFoundException
     * @throws IOException 
     */
   public void adicionaJogadores(Jogador jogador) throws ClassNotFoundException, FileNotFoundException, IOException{
        ObjectOutputStream objectOutputStream = new ObjectOutputStream( new FileOutputStream("DataFile.dat"));
        objectOutputStream.writeObject(jogador);
        objectOutputStream.flush();
        objectOutputStream.close();        
    }
    
   /**
    * Método para ler jogadores de um ficheiro
    * @param truePlayer nome do jogador que pretende ler os seus dados caso já exista
    * @return
    * @throws FileNotFoundException
    * @throws IOException
    * @throws ClassNotFoundException 
    */
    public boolean lerJogadores(Jogador truePlayer) throws FileNotFoundException, IOException, ClassNotFoundException{
        try {
            try (ObjectInputStream ios = new ObjectInputStream(new FileInputStream("DataFile.dat"))) {
            while(true){
                Jogador player = (Jogador) ios.readObject();
                if(player.getNome().equals(truePlayer.getNome())){
                    return true;
                }
            }    
            }
        }
        catch (IOException e){
        System.out.println(e.getMessage());
        }    return false; 
    }
    
    /**
     * Método para criar um ficheiro com logs de jogadores.
     * 
     * @param play jogadas efectuadas pelo jogador
     * @throws IOException 
     */
    public void criaFicheiro(Move play) throws IOException {
        File ficheiroJogo = new File("Game" + "_" + nLogs + "_" + nick + ".dat");
        nLogs++;

        try {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ficheiroJogo))) {
                oos.writeObject(play);
                oos.flush();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * Método para ler um ficheiro com logs de jogadores.
     * 
     * @param log indica qual a jogada que pretende recuperar
     * @throws ClassNotFoundException 
     */
    public void lerFicheiro(int log) throws ClassNotFoundException {
        File readingFile = new File("Game" + "_" + log + "_" + nick + ".dat");
        try {
            try (ObjectInputStream ios = new ObjectInputStream(new FileInputStream(readingFile))) {
                Move play = (Move) ios.readObject();
                play.toString();
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
   
    /**
     * Método que analisa a existencia do jogador na lista de jogadores
     * @param player
     * @return
     * @throws ClassNotFoundException 
     */
    public boolean playerList(Jogador player) throws ClassNotFoundException{
        try{
            try (ObjectInputStream ios = new ObjectInputStream(new FileInputStream("Jogadores.dat"))){
                Jogador readGame = (Jogador) ios.readObject();
                if (readGame == player){
                    return true;
                }
            }
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    /**
     * Método que envia informação sobre jogadas para a criação de ficheiro
     * @param o
     * @param arg 
     */
    @Override
    public void update(Observable o, Object arg) {
        SolitaireCareTaker run = (SolitaireCareTaker) o;
        try {
            criaFicheiro(move);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(GameDataFiles.class.getName()).log(Level.SEVERE, null, ex);
        }
            }
   
    
}
