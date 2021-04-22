/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Espacial.Espacial;
import Espacial.Histograma;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author Abelardo
 */
public class JInternalFrameExpansion extends javax.swing.JInternalFrame {
    private JInternalFrameImagen internal;
    private Image imagenOriginal , nueva;
   
    /**
     * Creates new form JInternalFrameExpansion
     */
    public JInternalFrameExpansion(JInternalFrameImagen internal) {
        this.internal = internal;
        this.imagenOriginal = herramientas.HerramientasImagen.copiarImagen(internal.getImagenOriginal());
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_Lineal = new javax.swing.JButton();
        jSlider_expansion_logaritmica = new javax.swing.JSlider();
        jSlider_expansion_exponencial = new javax.swing.JSlider();
        btn_ecualizador = new javax.swing.JButton();
        btn_log = new javax.swing.JButton();
        btn_exponencial = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("Expansión");

        btn_Lineal.setText("Expansión Lineal");
        btn_Lineal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LinealActionPerformed(evt);
            }
        });

        jSlider_expansion_logaritmica.setMajorTickSpacing(25);
        jSlider_expansion_logaritmica.setMaximum(255);
        jSlider_expansion_logaritmica.setPaintLabels(true);
        jSlider_expansion_logaritmica.setPaintTicks(true);
        jSlider_expansion_logaritmica.setValue(0);

        jSlider_expansion_exponencial.setMajorTickSpacing(1);
        jSlider_expansion_exponencial.setMaximum(1);
        jSlider_expansion_exponencial.setPaintLabels(true);
        jSlider_expansion_exponencial.setPaintTicks(true);
        jSlider_expansion_exponencial.setValue(0);

        btn_ecualizador.setText("Ecualizador");
        btn_ecualizador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ecualizadorActionPerformed(evt);
            }
        });

        btn_log.setText("Expansión Logaritmica");
        btn_log.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logActionPerformed(evt);
            }
        });

        btn_exponencial.setText("Expansión Exponencial");
        btn_exponencial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exponencialActionPerformed(evt);
            }
        });

        jLabel1.setText("Min:");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Max:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSlider_expansion_exponencial, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
                    .addComponent(jSlider_expansion_logaritmica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btn_exponencial)
                        .addGap(124, 124, 124))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btn_ecualizador)
                        .addGap(147, 147, 147))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btn_log)
                        .addGap(126, 126, 126))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(btn_Lineal))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 107, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(btn_Lineal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSlider_expansion_logaritmica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_log)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSlider_expansion_exponencial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_exponencial)
                .addGap(26, 26, 26)
                .addComponent(btn_ecualizador)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_LinealActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LinealActionPerformed
        // TODO add your handling code here:
        int max = Integer.parseInt(jTextField2.getText());
        int min = Integer.parseInt(jTextField1.getText());
        Histograma h = new Histograma(imagenOriginal);
        h.calcularHistograma();
        nueva = herramientas.HerramientasImagen.toImage(Espacial.expansionLineal(max,min, imagenOriginal));
        internal.setImagen(nueva);
    }//GEN-LAST:event_btn_LinealActionPerformed

    private void btn_logActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logActionPerformed
        // TODO add your handling code here:
        int u = jSlider_expansion_logaritmica.getValue();
        nueva = herramientas.HerramientasImagen.toImage(Espacial.expansionLogartmica(imagenOriginal));
        internal.setImagen(nueva);
    }//GEN-LAST:event_btn_logActionPerformed

    private void btn_exponencialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exponencialActionPerformed
        // TODO add your handling code here:
        int u = jSlider_expansion_exponencial.getValue();
        nueva = herramientas.HerramientasImagen.toImage(Espacial.expansionExponencial(imagenOriginal, u));
        internal.setImagen(nueva);
    }//GEN-LAST:event_btn_exponencialActionPerformed

    private void btn_ecualizadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ecualizadorActionPerformed
        // TODO add your handling code here:
        nueva = herramientas.HerramientasImagen.toImage(Espacial.ecualizacion(imagenOriginal));
        internal.setImagen(nueva);
    }//GEN-LAST:event_btn_ecualizadorActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Lineal;
    private javax.swing.JButton btn_ecualizador;
    private javax.swing.JButton btn_exponencial;
    private javax.swing.JButton btn_log;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSlider jSlider_expansion_exponencial;
    private javax.swing.JSlider jSlider_expansion_logaritmica;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
