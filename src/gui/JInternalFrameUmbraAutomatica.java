/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Espacial.Histograma;
import Espacial.UmbralizacionAutomatica;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author Abelardo
 */
public class JInternalFrameUmbraAutomatica extends javax.swing.JInternalFrame {
    private JInternalFrameImagen internal;
    private Image imagenOriginal;
    private Histograma h;
    private UmbralizacionAutomatica u;
    /**
     * Creates new form JInternalFrameUmbraAutomatica
     */
    public JInternalFrameUmbraAutomatica(JInternalFrameImagen internal) {
        this.internal = internal;
        initComponents();
        this.imagenOriginal = herramientas.HerramientasImagen.copiarImagen(internal.getImagenOriginal());
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();

        setTitle("Umbralización Automática");

        jButton1.setText("Umbralizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jButton1)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        BufferedImage bi = herramientas.HerramientasImagen.toBufferedImage(imagenOriginal);
        h = new Histograma(imagenOriginal);
        h.calcularHistograma();
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
        Image nueva = herramientas.HerramientasImagen.toImage(bi);
        internal.setImagen(nueva); 
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
