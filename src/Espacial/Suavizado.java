/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Espacial;

import static Espacial.Convolucion.convolucionar;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author Abelardo
 */
public class Suavizado {
    
    public static Image suavizar(Image io,int[][] mascara){

        BufferedImage bi = herramientas.HerramientasImagen.toBufferedImage(io);
       
        Color color;
    // recorres el buffer
        for(int y=0; y < bi.getHeight();y++){
            for(int x=0; x < bi.getWidth();x++){
            color = new Color(calcularNuevoTono(x,y,bi,mascara));
            
            bi.setRGB(x, y, color.getRGB());
            }
        }
        return herramientas.HerramientasImagen.toImage(bi);
    }

    private static int calcularNuevoTono(int x, int y, BufferedImage bi, int[][] mascara) {
        
       
        int auxR = 0, auxG = 0, auxB = 0;
        Color color = null;
        int k = 0;
        for(int i = 0 , r = x -1; i<mascara.length;i++, r++){
            for(int j = 0, c = y -1; j < mascara[0].length;j++, c++){
                if(mascara[i][j]!=0){
                    try{
                        color = new Color(bi.getRGB(r, c));
                        k++;
                        auxR+= color.getRed();
                        auxG+= color.getGreen();
                        auxB+= color.getBlue();
                    }catch(Exception e){
                        
                    }
                }
            }
        }
        if(k!=0){
        auxR/=k;
        auxG/=k;
        auxB/=k;}
        color = new Color(auxR,auxG,auxB);
        return color.getRGB();
    }
}
