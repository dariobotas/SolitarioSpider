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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;


/**
 *
 * @author AnTRaX
 */
public class Logger implements Observer,Serializable{
    
    private int numeroLoggers;
    private File ficheiro;
    private String nomeJogador;
    
    /**
     * Construtor da classe.
     *
     * @param jogador
     */
    public Logger(Jogador jogador){
        numeroLoggers = 0;
        nomeJogador = jogador.getNome();
        criarJogadorPersonalLogger();
    }
    
    public Logger(){
        criarFileJogadores();
    }

    /**
     * Método que cria o ficheiro de logger.
     *
     */
    private void criarJogadorPersonalLogger(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm");
        Date date = new Date();
        dateFormat.format(date);
        ficheiro = new File("game_"+dateFormat.format(date)+nomeJogador+".dat");
        if(ficheiro.exists())
            numeroLoggers++;            
    }
    
    /**
     * Método que cria um ficheiro de jogadores.
     *
     */
    public void criarFileJogadores(){
        ficheiro = new File("playersGame.dat");
        if(ficheiro.exists())
            System.out.println("Ficheiro ja Existe!");
    }
    
    /**
     * Método que regista um jogador no ficheiro
     *
     * @param jogador
     */
    public void registarJogadores(Jogador jogador) throws ClassNotFoundException, FileNotFoundException, IOException{
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream( new FileOutputStream(ficheiro,true))) {
            objectOutputStream.writeObject(jogador);
            objectOutputStream.flush();
        }
    }
    
    public boolean lerJogador(Jogador jogador) throws FileNotFoundException, IOException, ClassNotFoundException{
        try {
            try (ObjectInputStream ios = new ObjectInputStream(new FileInputStream(ficheiro))) {
            while(true){
                Jogador jogador1 = (Jogador) ios.readObject();
                if(jogador1.getNome().equals(jogador.getNome())){
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
     * Método que regista uma jogada no ficheiro
     *
     * @param jogada
     */
    public void escreverLogger(Jogada jogada){
        try {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ficheiro,true))) {
                oos.writeObject(jogada);
                oos.flush();
            }
        }
        catch (IOException e){
        System.out.println(e.getMessage());
        }
    }
    
    /**
     * Método que "abre" o ficheiro.
     *
     * @param id
     * @throws ClassNotFoundException
     */
    public void abrirLogger(int id) throws ClassNotFoundException{        
        File file = new File("jogo"+id+nomeJogador+".dat");
        ficheiro = file;
        try {
            try (ObjectInputStream ios = new ObjectInputStream(new FileInputStream(ficheiro))) {
                Jogada jogada = (Jogada) ios.readObject();
            }
        }
        catch (IOException e){
        System.out.println(e.getMessage());
        }
    }

    /**
     *
     * @param o
     * @param o1
     */
    @Override
    public void update(Observable o, Object o1) {
        GameStart jog = (GameStart) o;
        escreverLogger(jog.getDadosJogo().getJogada());
    }
}
