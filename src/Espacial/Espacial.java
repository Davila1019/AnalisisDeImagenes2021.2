/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Espacial;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author Abelardo
 */
public class Espacial {
    
    public BufferedImage Binarizacion(BufferedImage bi, int u){
        Color color;
                for(int j = 0 ; j< bi.getWidth();j++){
                    for(int m = 0 ; m < bi.getHeight();m++){
                        color = new Color(bi.getRGB(j, m));
                        double v = (color.getRed()+color.getGreen()+color.getBlue())/3;
                        if(v<u){
                            
                            bi.setRGB(j, m,Color.WHITE.getRGB());
                        }
                    }
                }
        return bi;
    }
    
    public BufferedImage Negativo(BufferedImage bi){
        Color color ;
        int i,j,r,g,b;
        for(j = 0; j< bi.getHeight(); j++){
            for(i = 0; i < bi.getWidth(); i++){
                color = new Color(bi.getRGB(i,j));
                r=255-color.getRed();
                g=255-color.getGreen();
                b=255-color.getBlue();
                color = new Color(r,g,b);
                bi.setRGB(i, j, color.getRGB());
            }
        }
        return bi;
    }
    
    public BufferedImage Umbralizacion(BufferedImage bi, int u1, int u2){
        Color color, colorFondo, Cobjeto;
        colorFondo = new Color(0,0,0);
        Cobjeto= new Color(255,255,255);
        for(int x=0; x<bi.getWidth();x++)
            for(int y=0; y<bi.getHeight();y++){
            color = new Color(bi.getRGB(x, y));
            int prom = (color.getRed()+ color.getGreen()+color.getBlue())/3;
            if ( prom > u1 && prom < u2){
                bi.setRGB(x,y,Cobjeto.getRGB());
                
            }else if (!(prom < u2 && prom > u1)){
                bi.setRGB(x,y,colorFondo.getRGB());
            }
            
        }
        return bi;
    }
    
    public BufferedImage EscalaGrises(BufferedImage bi){
        Color color ;
        int i,j,aux;
        for(j = 0; j< bi.getHeight(); j++){
            for(i = 0; i < bi.getWidth(); i++){
             color = new Color(bi.getRGB(i,j));
             aux = (color.getRed()+color.getBlue()+color.getGreen())/3;
             color = new Color(aux,aux,aux);
             bi.setRGB(i, j, color.getRGB());
            }
        }
        return bi;
    }
    
    public BufferedImage UmbralizacionAuto(Image i){
        Histograma h = new Histograma(i);
        h.calcularHistograma();
        BufferedImage bi = herramientas.HerramientasImagen.toBufferedImage(i);
        int u = UmbralizacionAutomatica.metodoIterativo(h.getGr());
        Color color, colorFondo, Cobjeto;
        colorFondo = new Color(0,0,0);
        Cobjeto= new Color(255,255,255);
        for(int x=0; x<bi.getWidth();x++)
            for(int y=0; y<bi.getHeight();y++){
            color = new Color(bi.getRGB(x, y));
            int prom = (color.getRed()+ color.getGreen()+color.getBlue())/3;
            if ( prom > u){
                bi.setRGB(x,y,Cobjeto.getRGB());
                
            }else {
                bi.setRGB(x,y,colorFondo.getRGB());
            }

        }
        return bi;
    }
}
