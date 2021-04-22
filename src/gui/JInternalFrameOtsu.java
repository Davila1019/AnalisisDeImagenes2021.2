/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Espacial.Espacial;
import Espacial.Histograma;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author Abelardo
 */
public class JInternalFrameOtsu extends javax.swing.JInternalFrame {
 private JInternalFrameImagen internal;
    private Image imagenOriginal;
    private Espacial e;
    /**
     * Creates new form JInternalFrameOtsu
     */
    public JInternalFrameOtsu(JInternalFrameImagen internal) {
        initComponents();
        this.internal = internal;
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

        setClosable(true);
        setIconifiable(true);

        jButton1.setText("Umbralización Otzu");
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
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jButton1)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        Histograma h = new Histograma(internal.getImagenOriginal());
        h.calcularHistograma();
        BufferedImage bi = herramientas.HerramientasImagen.toBufferedImage(imagenOriginal);
        int u = e.otsu(h.getGr());
        System.out.println("Umbral="+u);
        Color color, colorFondo, Cobjeto;
        colorFondo = new Color(0,0,0);
        for(int x=0; x<bi.getWidth();x++)
            for(int y=0; y<bi.getHeight();y++){
            color = new Color(bi.getRGB(x, y));
            int prom = (color.getRed()+ color.getGreen()+color.getBlue())/3;
            if ( prom < u){
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
