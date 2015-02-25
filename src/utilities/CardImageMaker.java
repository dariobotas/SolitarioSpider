/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * 
 * @author AnTRaX
 */
public class CardImageMaker extends JPanel {

    private BufferedImage cartaBuffer;
    private int x;
    private int y;

    /**
     * 
     * @param cardsImage
     * @param x
     * @param y
     * @throws IOException 
     */
    public CardImageMaker(String cardsImage, int x, int y)
            throws IOException {
        this.x = x;
        this.y = y;
        this.cartaBuffer = ImageIO.read(getClass().getResourceAsStream("images/" + cardsImage));
    }

    /**
     * 
     * @return 
     */
    public BufferedImage getCardBack() {
        return this.cartaBuffer.getSubimage(2 * this.x, 4 * this.y, this.x, this.y);
    }

    /**
     * 
     * @param type
     * @param number
     * @return 
     */
    public BufferedImage desenhaCarta(String type, int number) {
        BufferedImage ret = new BufferedImage(this.x, this.y, 2);

        if (type.equals("paus")) {
            ret = this.cartaBuffer.getSubimage(number * this.x, 0, this.x, this.y);
        }
        if (type.equals("ouros")) {
            ret = this.cartaBuffer.getSubimage(number * this.x, this.y, this.x, this.y);
        }
        if (type.equals("copas")) {
            ret = this.cartaBuffer.getSubimage(number * this.x, 2 * this.y, this.x, this.y);
        }
        if (type.equals("espadas")) {
            ret = this.cartaBuffer.getSubimage(number * this.x, 3 * this.y, this.x, this.y);
        }
        if (type.equals("back")) {
            ret = this.cartaBuffer.getSubimage(number * this.x, 4 * this.y, this.x, this.y);
        }
        return ret;
    }
}
