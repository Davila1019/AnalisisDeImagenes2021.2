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

    
    
}
