/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import Espacial.Histograma;
import gui.JFramePrincipal;
import gui.JInternalFrameGrises;
import gui.JInternalFrameHistograma;
import gui.JInternalFrameImagen;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

/**
 *
 * @author Abelardo
 */
public class GraficarHistogramaListener implements ActionListener {
    private JFramePrincipal framePrincipal;
    
    public GraficarHistogramaListener(JFramePrincipal framePrincipal) {
        this.framePrincipal = framePrincipal;
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        JMenuItem item = (JMenuItem)ae.getSource();
        if(item.getText().equals("Histograma")){
            JInternalFrameImagen internal = (JInternalFrameImagen) this.framePrincipal.getjDesktopPanePrincipal().getSelectedFrame();
            JInternalFrameHistograma internalNuevo = new JInternalFrameHistograma(internal);
            internalNuevo.setVisible(true);
            this.framePrincipal.getjDesktopPanePrincipal().add(internalNuevo);
        }
    }
    
}
