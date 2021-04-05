/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import gui.JFramePrincipal;
import gui.JInternalFrameBinarizacion;
import gui.JInternalFrameGrises;
import gui.JInternalFrameImagen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

/**
 *
 * @author Abelardo
 */
public class BinarizacionListener implements ActionListener{
    private JFramePrincipal framePrincipal;
    
    public BinarizacionListener(JFramePrincipal framePrincipal) {
    this.framePrincipal = framePrincipal;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem item = (JMenuItem)e.getSource();
        if(item.getText().equals("Binarizacion")){
           JInternalFrameImagen internal = (JInternalFrameImagen) this.framePrincipal.getjDesktopPanePrincipal().getSelectedFrame();
            JInternalFrameBinarizacion internalNuevo = new JInternalFrameBinarizacion(internal);
            internalNuevo.setVisible(true);
            this.framePrincipal.getjDesktopPanePrincipal().add(internalNuevo);
        }
    }
}
