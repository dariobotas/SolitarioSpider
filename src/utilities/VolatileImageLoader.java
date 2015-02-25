/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.awt.image.VolatileImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

/**
 * 
 * @author AnTRaX
 */
public class VolatileImageLoader {

    /**
     * 
     * @param width
     * @param height
     * @param transparency
     * @return 
     */
    public static VolatileImage createVolatileImage(int width, int height, int transparency) {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsConfiguration gc = ge.getDefaultScreenDevice().getDefaultConfiguration();
        VolatileImage image = null;
        Graphics2D g = null;
        image = gc.createCompatibleVolatileImage(width, height, transparency);
        int valid = image.validate(gc);

        if (valid == 2) {
            image = gc.createCompatibleVolatileImage(width, height, transparency);
            return image;
        }

        return image;
    }

    /**
     * 
     * @param picStream
     * @param transparency
     * @return
     * @throws IOException 
     */
    public static VolatileImage loadFromFile(InputStream picStream, int transparency)
            throws IOException {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsConfiguration gc = ge.getDefaultScreenDevice().getDefaultConfiguration();
        BufferedImage bimage = ImageIO.read(picStream);
        VolatileImage vimage = createVolatileImage(bimage.getWidth(), bimage.getHeight(), transparency);
        Graphics2D g = null;
        try {
            g = vimage.createGraphics();
            g.drawImage(bimage, null, 0, 0);
        } finally {
            g.dispose();
        }
        return vimage;
    }

    /**
     * 
     * @param image
     * @param transparency
     * @return
     * @throws IOException 
     */
    public static VolatileImage loadFromBufferedImage(BufferedImage image, int transparency)
            throws IOException {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsConfiguration gc = ge.getDefaultScreenDevice().getDefaultConfiguration();
        BufferedImage bimage = image;
        VolatileImage vimage = createVolatileImage(bimage.getWidth(), bimage.getHeight(), transparency);
        Graphics2D g = null;
        try {
            g = vimage.createGraphics();
            g.setComposite(AlphaComposite.Src);
            g.drawImage(bimage, null, 0, 0);
        } finally {
            g.dispose();
        }
        return vimage;
    }
}
