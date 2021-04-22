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

    public Espacial() {
        
    }
    
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
         
            }else {
                bi.setRGB(x,y,colorFondo.getRGB());
            }

        }
        return bi;
    }

    public static int otsu(double[] histograma){
        //La suma de los valores del histograma
        int total = 0;
        for(int i = 0;i<histograma.length;i++)total+=histograma[i];
        //Valor maximo
        int top = 256;
        int sumaBB = 0;
        int wB = 0;
        //La maxima inferencia entre clases
        double maximo = 0.0;
        int wF;
        int mF;
        double valor;
        int umbral = 0;
        int suma1 = 0;
        int[] range = new int[top];
        for(int i = 0;i<top;i++)range[i]=i;
        //Calculamos el producto punto de los valores del histograma lo cual no 
        //da la probabilidad total de las clases
        for(int i = 0;i<histograma.length;i++)suma1+=range[i]*histograma[i];
        for(int i = 1;i<top;i++){
            //Se calcula la probabilidad de que sea ForeGround, ya que son contrarias se 
            //calcula con la resta del total menos la otra probabilidad
            wF = total - wB;
            //si las dos probabilidades son mayores a 0
            if(wB > 0 && wF > 0){
                //Se calcula la media
                mF = (suma1 - sumaBB) / wF;
                //Se calcula la varianza intra-clase
                valor = wB*wF*((sumaBB/wB)-mF)*((sumaBB/wB)-mF);
                //nuevo maximo y del umbral maximo
                if (valor >= maximo){
                    umbral = i;
                    maximo = valor;
                }
                    
            }
            //Si la probabilidas igual a 0 se cambia al siguiente umbral a verificar
            //Hciendo los calculos correspondientes
            wB = wB + (int)histograma[i];
            sumaBB = sumaBB + (i-1) *(int) histograma[i];
        }
        return umbral;
    }
    
    public static BufferedImage UmbralizacionOtzu(Image i){
        Histograma h = new Histograma(i);
        h.calcularHistograma();
        BufferedImage bi = herramientas.HerramientasImagen.toBufferedImage(i);
        int u = otsu(h.getGr());
        System.out.println("Umbral="+u);
        Color color, colorFondo, Cobjeto;
        colorFondo = new Color(0,0,0);
        Cobjeto= new Color(255,255,255);
        for(int x=0; x<bi.getWidth();x++)
            for(int y=0; y<bi.getHeight();y++){
            color = new Color(bi.getRGB(x, y));
            int prom = (color.getRed()+ color.getGreen()+color.getBlue())/3;
            if ( prom > u){
         
            }else {
                bi.setRGB(x,y,colorFondo.getRGB());
            }

        }
        return bi;
    }
    
    public static BufferedImage iluminarImagen(Image imagen, int alpha){

        BufferedImage bi = herramientas.HerramientasImagen.toBufferedImage(imagen);
        Color color;
        for(int x=0; x<bi.getWidth();x++)
            for(int y=0; y<bi.getHeight();y++){
            color = new Color(bi.getRGB(x, y));
            int r = color.getRed() + alpha;
            int g = color.getGreen() + alpha;
            int b = color.getBlue() + alpha;
            color = new Color(validarLimites(r),
            validarLimites(g),
            validarLimites(b));
            bi.setRGB(x,y,color.getRGB());
        }
        return bi;
    }
    
    public static BufferedImage expansionLineal(Histograma h, Image imagen){

        BufferedImage bi = herramientas.HerramientasImagen.toBufferedImage(imagen);
        Color color;
        for(int x=0; x<bi.getWidth();x++)
            for(int y=0; y<bi.getHeight();y++){
            color = new Color(bi.getRGB(x, y));
            int r = (color.getRed()-h.getMinR())*(255/h.getMaxR()-h.getMinR());
            int g = (color.getGreen()-h.getMinG())*(255/h.getMaxG()-h.getMinG());
            int b = (color.getBlue()-h.getMinB())*(255/h.getMaxB()-h.getMinB());
            color = new Color(validarLimites(r),
            validarLimites(g),
            validarLimites(b));
            bi.setRGB(x,y,color.getRGB());
        }
        return bi;
    }
 
    public static BufferedImage expansionLogartmica( Image imagen, int n){

        BufferedImage bi = herramientas.HerramientasImagen.toBufferedImage(imagen);
        Color color;
        for(int x=0; x<bi.getWidth();x++)
            for(int y=0; y<bi.getHeight();y++){
            color = new Color(bi.getRGB(x, y));
            int r = (int)((n*Math.log(1+color.getRed()))/Math.log(n));
            int g = (int)((n*Math.log(1+color.getGreen()))/Math.log(n));
            int b = (int)((n*Math.log(1+color.getBlue()))/Math.log(n));
             color = new Color(validarLimites(r),
             validarLimites(g),
             validarLimites(b));
             bi.setRGB(x,y,color.getRGB());
        }
        return bi;
    }
 
    public static BufferedImage expansionExponencial(Image imagen, double z){
        
        BufferedImage bi = herramientas.HerramientasImagen.toBufferedImage(imagen);
        Color color;
        if(z>0){
        for(int x=0; x<bi.getWidth();x++)
            for(int y=0; y<bi.getHeight();y++){
            color = new Color(bi.getRGB(x, y));
            int r = (int)((Math.pow((1+z), color.getRed()))/z);
            int g = (int)((Math.pow((1+z), color.getGreen()))/z);
            int b = (int)((Math.pow((1+z), color.getBlue()))/z);
             color = new Color(validarLimites(r),
             validarLimites(g),
             validarLimites(b));
             bi.setRGB(x,y,color.getRGB());
        }
        return bi;
        }else
        {
        return bi;
        }
    }
    
    public static BufferedImage ecualizacion( Image imagen){

        BufferedImage bi = herramientas.HerramientasImagen.toBufferedImage(imagen);
        Color color;
        for(int x=0; x<bi.getWidth();x++)
            for(int y=0; y<bi.getHeight();y++){
            color = new Color(bi.getRGB(x, y));
            int r = (int)((Math.pow(color.getRed(), 2)));
            int g = (int)((Math.pow(color.getGreen(), 2)));
            int b = (int)((Math.pow(color.getBlue(), 2)));
             color = new Color(validarLimites(r),
             validarLimites(g),
             validarLimites(b));
             bi.setRGB(x,y,color.getRGB());
        }
        return bi;
    }
    
    
    public static int obtenerMin(double[] h){

        for(int x=0; x<h.length;x++){
            if(h[x]!=0) return x;
        }
     return -1;
    }

    public static int obtenerMax(double[] h){

        for(int x=h.length-1; x>=0;x--){
            if(h[x]!=0) return x;
        }
     return -1;
    }
    
    public static int validarLimites (int aux){

        if (aux<0)return 0;
        if (aux>255)return 255;
        return aux;

    }
    
    
}
