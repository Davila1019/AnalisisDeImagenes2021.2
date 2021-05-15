/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisisimagenes;

import Espacial.Convolucion;
import Espacial.Espacial;
import Espacial.Histograma;
import gui.JFramePrincipal;
import gui.JInternalFrameImagen;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author working
 */
public class AnalisisImagenes20212 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        visualización de la imagen dentro de la GUI
//        Espacial e = new Espacial();
//        Image imagen = herramientas.HerramientasImagen.abrirImagen();
//         para cuantización de la imagen vamos a un ocupar BufferedImage
//        BufferedImage bImagen = herramientas.HerramientasImagen.toBufferedImage(imagen);
//        Histograma h =new Histograma(imagen);
//        h.calcularHistograma();
//        h.graficar();
//        int r = e.otsu(h.getGr());
//        e.Binarizacion(bImagen, r);
//        imagen = herramientas.HerramientasImagen.toImage(bImagen);
//        ImagenFrame i = new ImagenFrame(imagen);
//        Convolucion c = new Convolucion(imagen);
//        double kernel[][] = {{0,0,0,0,0},{0,0,-1,0,0},{0,-1,5,-1,0},{0,0,-1,0,0},{0,0,0,0,0}};
//        
//        
//        Image imagenNueva = c.aplicar(kernel, 1);
//        ImagenFrame i = new ImagenFrame(imagenNueva);
//        System.out.println(r);
          JFramePrincipal s = new JFramePrincipal();
          
          s.setVisible(true);
          
    }
    
}
