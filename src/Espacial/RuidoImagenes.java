/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Espacial;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 *
 * @author Abelardo
 */
public class RuidoImagenes {
    
    public static BufferedImage agregarSal(BufferedImage bi, int porcentaje){
        int tp=bi.getHeight()*bi.getWidth();
        int pix=(tp*porcentaje)/100;
        Random r= new Random();
        Color c= new Color(255,255,255);
        for(int x=1;x<pix;x++){
            bi.setRGB(r.nextInt(bi.getWidth()),r.nextInt(bi.getHeight()) , c.getRGB());
        }
        
        return bi;
    }
    
    public static BufferedImage agregarPimienta(BufferedImage bi, int porcentaje){
        int tp=bi.getHeight()*bi.getWidth();
        int pix=(tp*porcentaje)/100;
        Random r= new Random();
        Color c= new Color(0,0,0);
        for(int x=1;x<pix;x++){
            bi.setRGB(r.nextInt(bi.getWidth()),r.nextInt(bi.getHeight()) , c.getRGB());
        }
        
        return bi;
    }
            
}
