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
public class Convolucion {
    private int dim;
    private Image imagenOriginal;
    private double kernel[][];
    private static double[][] kirsch1 = {{-3, -3, 5}, {-3, 0, 5}, {-3, -3, 5}};
    private static double[][] kirsch2 = {{-3, 5, 5}, {-3, 0, 5}, {-3, -3, -3}};
    private static double[][] kirsch3 = {{5, 5, 5}, {-3, 0, -3}, {-3, -3, -3}};
    private static double[][] kirsch4 = {{5, 5, -3}, {5, 0, -3}, {-3, -3, -3}};
    private static double[][] kirsch5 = {{5, -3, -3}, {5, 0, -3}, {5, -3, -3}};
    private static double[][] kirsch6 = {{-3, -3, -3}, {5, 0, -3}, {5, 5, -3}};
    private static double[][] kirsch7 = {{-3, -3, -3}, {-3, 0, -3}, {5, 5, 5}};
    private static double[][] kirsch8 = {{-3, -3, -3}, {-3, 0, 5}, {-3, 5, 5}};
    public static double[][][] arregloMascaras = {kirsch1, kirsch2, kirsch3,
        kirsch4, kirsch5, kirsch6,
        kirsch7, kirsch8};
    public Convolucion(Image imagenOriginal) {
        this.dim = 0;
        this.imagenOriginal = imagenOriginal;
        this.kernel = null;
    }
    
    public Image aplicar(double kernel[][], int divisor, int offset){
       dim = kernel[0].length;
       this.kernel = kernel;
       BufferedImage nueva = new BufferedImage(this.imagenOriginal.getWidth(null),this.imagenOriginal.getHeight(null),BufferedImage.TYPE_INT_RGB);
       BufferedImage bi = herramientas.HerramientasImagen.toBufferedImage(imagenOriginal);
    
       for(int x=0; x<this.imagenOriginal.getWidth(null);x++){
           for(int y=0; y<this.imagenOriginal.getHeight(null);y++){
           double muestra[][] = extraerMuestra(x,y,bi);
            if(muestra!=null){
            Color colorRes = convolucionar(kernel,muestra,divisor,offset);
            nueva.setRGB(x, y, colorRes.getRGB());
            
            }else{
            nueva.setRGB(x, y, new Color(255,255,255).getRGB());
            
            }
                 
           }
       }
       
       return herramientas.HerramientasImagen.toImage(nueva);
    }

    private double[][] extraerMuestra(int x, int y, BufferedImage bi) {
        double matriz[][] = new double[this.kernel[0].length][this.kernel[0].length];
        int xx=0;
        int yy=0;
        try {
         // recorremos la imagen 
         for(int i=x-(this.kernel[0].length-1)/2;i<=x+(this.kernel[0].length-1)/2;i++){
            for(int j=y-(this.kernel[0].length-1)/2;j<=y+(this.kernel[0].length-1)/2;j++){
            matriz[xx][yy] = bi.getRGB(i,j);
            yy++;
            }
            yy=0;
            xx++;
         }
          return matriz;
        } catch (Exception e) {
           // System.out.println("Indice no valido");
            return null;
        }
       
    }

    public static Color convolucionar(double[][] kernel, double[][] muestra, int divisor, int offset) {
        int acumuladorR = 0;
        int acumuladorG = 0;
        int acumuladorB = 0;
        Color aux;
        // recorremos el kernel y la muestra 
        for(int x=0; x<kernel[0].length;x++)
            for(int y=0; y<kernel[0].length;y++){
         aux = new Color((int)muestra[x][y]);
         acumuladorR+=(kernel[x][y]*aux.getRed());
         acumuladorG+=(kernel[x][y]*aux.getGreen());
         acumuladorB+=(kernel[x][y]*aux.getBlue());
        
         }
        acumuladorR/=divisor;
        acumuladorG/=divisor;
        acumuladorB/=divisor;
        
        acumuladorR+=offset;
        acumuladorG+=offset;
        acumuladorB+=offset;
        return new Color((int)Espacial.validarLimites(acumuladorR),(int)Espacial.validarLimites(acumuladorG),(int)Espacial.validarLimites(acumuladorB));
        
    }
    
    private Color convolucionarKirsch(double[][] muestra, int divisor) {
        // recorremos las mascaras 
        int mayorR = -1;
        int mayorG = -1;
        int mayorB = -1;
        int r,g,b;
        for(int i=0; i<8;i++){
           Color color = convolucionar(arregloMascaras[i], muestra, divisor,1);
           r = color.getRed();
           g = color.getGreen();
           b = color.getBlue();
           if(r>mayorR)mayorR=r;
           if(g>mayorG)mayorG=g;
           if(b>mayorB)mayorB=b;
        
        }
        return new Color(Espacial.validarLimites(mayorR),Espacial.validarLimites(mayorG), Espacial.validarLimites(mayorB));
        
    }
    
     public Image aplicarKirsch(int divisor){
       this.kernel = new double[5][5];
       BufferedImage nueva = new BufferedImage(this.imagenOriginal.getWidth(null),this.imagenOriginal.getHeight(null),BufferedImage.TYPE_INT_RGB);
       BufferedImage bi = herramientas.HerramientasImagen.toBufferedImage(imagenOriginal);
        
       //System.out.println("W:"+nueva.getWidth()+"H:"+nueva.getHeight());
       //proceso iterativo para generar un imagen nueva
       for(int x=0; x<this.imagenOriginal.getWidth(null);x++){
           for(int y=0; y<this.imagenOriginal.getHeight(null);y++){
           double muestra[][] =extraerMuestra(x,y,bi);
            //System.out.println(x+","+y);
            // validar que la muestra se generó 
            if(muestra!=null){
             // proceso evolutivo para Kirsch
            // recorremos las mascaras     
                 
           // Color colorRes = convulacionar(kernel,muestra,divisor);
            Color colorRes = convolucionarKirsch(muestra,divisor);
            
            nueva.setRGB(x, y, colorRes.getRGB());
            
            }else{
            nueva.setRGB(x, y, new Color(255,255,255).getRGB());
            
            }
                 
           }
       }
       
       return herramientas.HerramientasImagen.toImage(nueva);
    }
}
