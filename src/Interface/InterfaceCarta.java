/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import pt.ips.pa.model.tads.Model.ModeloCarta.CorCarta;
import pt.ips.pa.model.tads.Model.ModeloCarta.FiguraCarta;
import pt.ips.pa.model.tads.Model.ModeloCarta.NaipeCarta;

/**
 *
 * @author AnTRaX
 */
public interface InterfaceCarta {
    
   /**
    * 
    * @return 
    */
   public FiguraCarta getFigura();
   
   /**
    * 
    * @param figura 
    */
   public void setFigura(FiguraCarta figura);
   
   /**
    * 
    * @return 
    */
   public CorCarta getCor();
   
   /**
    * 
    * @param naipe
     * @return 
    */
   public CorCarta setCor(NaipeCarta naipe);
    
}
