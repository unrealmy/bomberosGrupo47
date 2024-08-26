/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberosgrupo47.Vistas;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JDesktopPane;

/**
 *
 * @author hecto
 */
public class escritorioP extends JDesktopPane {
    private BufferedImage img;

    public escritorioP( ) {
        try{
        img=ImageIO.read(getClass().getResourceAsStream("/bomberosGrupo47/imag/fondobom.jpg"));
        }catch (Exception ex){
        ex.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        // muestra la imagen
        //g.drawImage(img, 50, 50,268,92,null);
        g.drawImage(img, 0, 0,null);
    }

    
    
}
