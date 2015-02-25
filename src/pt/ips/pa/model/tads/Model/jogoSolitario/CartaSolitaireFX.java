/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ips.pa.model.tads.Model.jogoSolitario;

import pt.ips.pa.model.tads.Model.ModeloCarta.NaipeCarta;
import javafx.scene.effect.ImageInput;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

/**
 *
 * @author AnTRaX
 */
public final class CartaSolitaireFX  {

    private int valor = 0;
    private String figura;
    private NaipeCarta naipe;
    public static String DAMA = "Dama";
    public static String VALETE = "Valete";
    public static String REI = "Rei";
    public static String AS = "As";
    private boolean viradaParaBaixo;
    private Pane imagem;


    /**
     * Construtor da classe
     *
     * @param designacao
     * @param naipe
     */
    public CartaSolitaireFX(int valor, String figura, NaipeCarta naipe) {
        this.valor = valor;
        this.figura = figura;
        this.naipe = naipe;
        this.imagem = new Pane();
        setViradaParaBaixo(true);
    }
    
    /**
     * Método que retorna um valor lógico que confirma se a carta está oculta.
     *
     * @return
     */
    public boolean isViradaParaBaixo(){
        return viradaParaBaixo;
    }
    
    /**
     * Método que oculta ou desvenda a carta.
     *
     * @param oculta
     */
    
    public void setViradaParaBaixo(boolean oculta){
        this.viradaParaBaixo = oculta;
        if(oculta==false){
           this.imagem.setEffect(new ImageInput(new Image("Imagens/cartas/"+toString()+".png")));
        } else {
           this.imagem.setEffect(new ImageInput(new Image("Imagens/cartas/cartaOculta.png"))); 
        }      
    }

    private int getValorBlindado(int valor, int max, int min){
            if(valor > max)
                return max;
            else if (valor < min)
                return min;
            else return valor;
        }
        
    public int getValor ()	{
	return getValorBlindado(valor, 13, 1);
    }

    public void setValor(int valor) {
        this.valor = getValorBlindado(valor,13,1);
    }
    
    /**
     * Método seletor da designação.
     *
     * @return
     */
    public String getFigura() {
        if (getValor() == 1) {
               return figura = AS;
            } else if (getValor() == 11) {
               return figura =  VALETE;
            } else if (getValor() == 12) {
               return figura = DAMA;
            } else if (getValor() == 13) {
               return figura = REI;
            } else {
               return figura = "" + getValor();
            }
    }

    /**
     * Método seletor do naipe.
     * 
     * @return
     */
    public NaipeCarta getNaipe() {
        return naipe;
    }

    /**Método modificador do naipe.
     * 
     *
     * @param naipe
     */
    public void setNaipe(NaipeCarta naipe) {
        this.naipe = naipe;
    }

    public Pane getMyImagem() {
        return imagem;
    }

    public void setMyImagem(Pane imagem) {
        this.imagem = imagem;
    }

        
    /**
     * Este método vai ser utilizado para comprar os Naipes, tanto para a estrategia Crescente como Decrescente, isto
     * para que não seja possivel inserir-mos cartas nos sitios errados( por exemplo um 4 ouros em cima de um 5 de copas)
     * @param c1 - primeira carta a ser enviada.
     * @param c2 - segunda carta a ser enviada.
     * @return - retorna true caso seja possivel por a carta pretendida por cima da outra, e false se não for possivel.
     */
    public static boolean comparaNaipes(CartaSolitaireFX c1, CartaSolitaireFX c2){//c1 carta do monte destino, c2 carta do monte origem
        if(((c1.getNaipe()==NaipeCarta.COPAS)||(c1.getNaipe()==NaipeCarta.OUROS)) && ((c2.getNaipe()==NaipeCarta.PAUS)||(c2.getNaipe()==NaipeCarta.ESPADAS))){
            return true;
        } else if(((c1.getNaipe()==NaipeCarta.ESPADAS)||(c1.getNaipe()==NaipeCarta.PAUS)) && ((c2.getNaipe()==NaipeCarta.COPAS)||(c2.getNaipe()==NaipeCarta.OUROS))){
            return true;
        }
        return false; //PADRÃO false
    }

   /**
     * Método que imprime os atributos da carta
     *
     * @return
     */
    @Override
    public String toString() {
        return getFigura()+ " " +getNaipe();
    }
    
}