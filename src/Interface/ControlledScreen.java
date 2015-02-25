/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import pt.ips.pa.controller.ScreensController;

/**
 *
 * @author AnTRaX
 */
public interface ControlledScreen {
    
    /**
     * Método que permite inserir parents ScreenPane
     * @param screenPage 
     */
    public void setScreenParent(ScreensController screenPage);
    
}
