/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ips.pa.model.tads.Model.jogoSolitario;

/**
 *
 * @author dario
 * 
 */
public class MonteDeCartasSaiTres  extends MonteDeCartas {
   
   
   private MonteDeCartas auxiliar;
    
    /**
     * Construtor da classe
     * Chama o super(MonteDeCartas) e cria um novo auxliar MonteDeLixo.
     */
    public MonteDeCartasSaiTres(){
        super();
        auxiliar = new MonteDeCartas();
    }
    
    /**
     * Este método serve para que seja retirado 3 cartas de cada vez.
     * No primeiro if verificamos se o tamanho é menos que 3 e maior que 0, isto para se
     * houver 1 ou 2 cartas disponiveis, consigamos retira-las.
     * No segundo if, vamos ver se o baralho está vazio, caso esteja, vamos voltar a 
     * meter todas as cartas que estao no nosso auxiliar(MonteDeLixo) para o Baralho, e removemos todas
     * do MonteDeLixo.
     * No terceiro if, caso o tamanho do baralho é maior que 3, vamos removendo de 3 em 3.
     */
    public MonteDeCartas getCartas(){
        
        if(super.size()<3 && super.size()>0){
            
            for(int i=0;i<super.size();i++){
                auxiliar.adicionarCarta(super.retirarUltimaCarta());  
            }
                    for(int i=0;i<auxiliar.size();i++){
            System.out.println(auxiliar.getCarta(i));
        }
            return auxiliar;
        
        }
        
        if(super.isEmpty()) {
            int tamanho = auxiliar.size();
            for(int i=0;i<tamanho;i++){
                super.adicionarCarta(auxiliar.retirarUltimaCarta());
            }
            return auxiliar;
        } else {
            
            for(int i=0;i<3;i++){
                auxiliar.adicionarCarta(super.retirarUltimaCarta()); 
            }
            return auxiliar;
        
        }
    }   
    
}
