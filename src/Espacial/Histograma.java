/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Espacial;

import herramientas.Grafica;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import org.jfree.chart.plot.XYPlot;

/**
 *
 * @author Abelardo
 */
public class Histograma {
    private double [] r;
    private double [] g;
    private double [] b;
    private double [] gr;
    private Integer minR,maxR;
    private Integer minG,maxG;
    private Integer minB,maxB;
    private Image ImagenOriginal;
    
    public Histograma(Image imagen){
        this.ImagenOriginal = imagen;
        this.r = new double[256];
        this.g = new double[256];
        this.b = new double[256];
        this.gr = new double[256];
    }
    
    public void calcularHistograma(){
        BufferedImage bi = herramientas.HerramientasImagen.toBufferedImage(ImagenOriginal);
        Color color;
        
        for(int x=0; x<bi.getWidth();x++){
            for(int y=0; y<bi.getHeight();y++){
                color = new Color(bi.getRGB(x, y));
                int r = color.getRed();
                int g = color.getGreen();
                int b = color.getBlue();
                int prom = (color.getRed()+color.getGreen()+color.getBlue())/3;
                this.getGr()[prom]++;
                this.r[r]++;
                this.g[g]++;
                this.b[b]++;
            }
        }
        calcularMinimosYMaximos();
    }
    
    public void graficar(){
        Grafica  G=new Grafica("Tono", "Intencidad","Frecuencia");
        G.agregarSerie(this.getR(), "Rojo");
        G.agregarSerie(this.getB(), "Azul");
        G.agregarSerie(this.getG(), "Verde");
        G.crearGrafica();

        XYPlot plot = G.getGrafica().getXYPlot();
        plot.getRenderer().setSeriesPaint(0, new Color(Color.RED.getRGB()));
        plot.getRenderer().setSeriesPaint(1, new Color(Color.BLUE.getRGB()));
        plot.getRenderer().setSeriesPaint(2, new Color(Color.GREEN.getRGB()));
        G.muestraGrafica();
    }
    public void graficarHistogramaRojo(){
        Grafica  G=new Grafica("Tono", "Intencidad","Frecuencia");
        G.agregarSerie(this.getR(), "Rojo");
        G.crearGrafica();
        XYPlot plot = G.getGrafica().getXYPlot();
        plot.getRenderer().setSeriesPaint(0, new Color(Color.RED.getRGB()));
        G.muestraGrafica();
       
    }
    public void graficarHistogramaAzul(){
        Grafica  G=new Grafica("Tono", "Intencidad","Frecuencia");
        G.agregarSerie(this.getB(), "Azul");
        G.crearGrafica();
         XYPlot plot = G.getGrafica().getXYPlot();
        plot.getRenderer().setSeriesPaint(0, new Color(Color.BLUE.getRGB()));
        G.muestraGrafica();
    }
    public void graficarHistogramaVerde(){
        Grafica  G=new Grafica("Tono", "Intencidad","Frecuencia");
        G.agregarSerie(this.getG(), "Verde");
         G.crearGrafica();
         XYPlot plot = G.getGrafica().getXYPlot();
        plot.getRenderer().setSeriesPaint(0, new Color(Color.GREEN.getRGB()));
        G.muestraGrafica();
    }
    public void graficarHistogramaGris(){
        Grafica  G=new Grafica("Tono", "Intencidad","Frecuencia");
        G.agregarSerie(this.getGr(), "Gris");
        G.crearGrafica();
        XYPlot plot = G.getGrafica().getXYPlot();
        plot.getRenderer().setSeriesPaint(0, new Color(Color.GRAY.getRGB()));
        G.muestraGrafica();
    }

    /**
     * @return the r
     */
    public double[] getR() {
        return r;
    }

    /**
     * @return the g
     */
    public double[] getG() {
        return g;
    }

    /**
     * @return the b
     */
    public double[] getB() {
        return b;
    }

    /**
     * @return the gr
     */
    public double[] getGr() {
        return gr;
    }

    public Integer getMinR() {
        return minR;
    }

    public void setMinR(Integer minR) {
        this.minR = minR;
    }

    public Integer getMaxR() {
        return maxR;
    }

    public void setMaxR(Integer maxR) {
        this.maxR = maxR;
    }

    public Integer getMinG() {
        return minG;
    }

    public void setMinG(Integer minG) {
        this.minG = minG;
    }

    public Integer getMaxG() {
        return maxG;
    }

    public void setMaxG(Integer maxG) {
        this.maxG = maxG;
    }

    public Integer getMinB() {
        return minB;
    }

    public void setMinB(Integer minB) {
        this.minB = minB;
    }

    public Integer getMaxB() {
        return maxB;
    }

    public void setMaxB(Integer maxB) {
        this.maxB = maxB;
    }

    
    
    private void calcularMinimosYMaximos(){
    this.minR = -1;
    this.minG = -1;
    this.minB = -1;
    this.maxR = 256;
    this.maxG = 256;
    this.maxB = 256;

    for(int t1 = 0, t2= r.length-1; minR==-1 || maxR==256 ;t1++,t2--){
        if(r[t1]!=0 && minR ==-1){
            minR = t1;
        }
        if(r[t2]!=0 && maxR==256){
            maxR = t2;
        }
       
    }

    for(int t1 = 0, t2= g.length-1; minG==-1 || maxG==256 ;t1++,t2--){
        if(g[t1]!=0 && minG ==-1){
            minG = t1;
        }
        if(g[t2]!=0 && maxG==256){
            maxG = t2;
        }
       
    }

    for(int t1 = 0, t2= b.length-1; minB==-1 || maxB==256 ;t1++,t2--){
        if(b[t1]!=0 && minB ==-1){
            minB = t1;
        }
        if(b[t2]!=0 && maxB==256){
            maxB = t2;
        }
       
    }
    
   System.out.println();

 }
    
}
