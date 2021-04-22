/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import listeners.BinarizacionListener;
import listeners.ExpansionListener;
import listeners.FiltroGrisesListener;
import listeners.GraficarHistogramaListener;
import listeners.InternalFrameListener;
import listeners.ModificarImagenListener;
import listeners.OtzuListener;
import listeners.UmbraAutomaticaListener;
import listeners.UmbralizacionListener;

/**
 *
 * @author working
 */
public class JFramePrincipal extends javax.swing.JFrame {

    /**
     * Creates new form JFramePrincipa
     */
    public JFramePrincipal() {
        initComponents();
        this.jMenuItem1.addActionListener(new InternalFrameListener(this));
        this.jMenuItem2.addActionListener(new ModificarImagenListener(this));
        this.jMenuItem3.addActionListener(new GraficarHistogramaListener(this));
        this.jMenuItem4.addActionListener(new FiltroGrisesListener(this));
        this.jMenuItem5.addActionListener(new BinarizacionListener(this) );
        this.jMenuItem6.addActionListener(new UmbralizacionListener(this));
        this.jMenuItem7.addActionListener(new UmbraAutomaticaListener(this));
        this.jMenuItem9.addActionListener(new OtzuListener(this));
        this.jMenuItem10.addActionListener(new ExpansionListener(this));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPanePrincipal = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jDesktopPanePrincipalLayout = new javax.swing.GroupLayout(jDesktopPanePrincipal);
        jDesktopPanePrincipal.setLayout(jDesktopPanePrincipalLayout);
        jDesktopPanePrincipalLayout.setHorizontalGroup(
            jDesktopPanePrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1268, Short.MAX_VALUE)
        );
        jDesktopPanePrincipalLayout.setVerticalGroup(
            jDesktopPanePrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 728, Short.MAX_VALUE)
        );

        jMenu1.setText("Imagen");

        jMenuItem1.setText("AbrirImagen");
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Espacial");

        jMenuItem2.setText("Modificar Pixeles");
        jMenu2.add(jMenuItem2);

        jMenuItem3.setText("Histograma");
        jMenu2.add(jMenuItem3);

        jMenuItem4.setText("Filtros grises");
        jMenu2.add(jMenuItem4);

        jMenuItem5.setText("Binarizacion");
        jMenu2.add(jMenuItem5);

        jMenuItem8.setText("Brillo");
        jMenu2.add(jMenuItem8);

        jMenuItem6.setText("Umbralizacion");
        jMenu2.add(jMenuItem6);

        jMenuItem7.setText("Umbralizacion Automatica");
        jMenu2.add(jMenuItem7);

        jMenuItem9.setText("Otzu");
        jMenu2.add(jMenuItem9);

        jMenuItem10.setText("Expansión");
        jMenu2.add(jMenuItem10);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPanePrincipal)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPanePrincipal)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFramePrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPanePrincipal;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the jDesktopPanePrincipal
     */
    public javax.swing.JDesktopPane getjDesktopPanePrincipal() {
        return jDesktopPanePrincipal;
    }

    /**
     * @param jDesktopPanePrincipal the jDesktopPanePrincipal to set
     */
    public void setjDesktopPanePrincipal(javax.swing.JDesktopPane jDesktopPanePrincipal) {
        this.jDesktopPanePrincipal = jDesktopPanePrincipal;
    }
}
