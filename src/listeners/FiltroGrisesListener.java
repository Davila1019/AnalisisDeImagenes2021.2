/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import gui.JFramePrincipal;
import gui.JInternalFrameGrises;
import gui.JInternalFrameImagen;
import gui.JInternalFrameModificar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
/**
 *
 * @author Abelardo
 */
public class FiltroGrisesListener implements ActionListener{
    
    private JFramePrincipal framePrincipal;
    
    public FiltroGrisesListener(JFramePrincipal framePrincipal) {
    this.framePrincipal = framePrincipal;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem item = (JMenuItem)e.getSource();
        if(item.getText().equals("Filtros grises")){
            JInternalFrameImagen internal = (JInternalFrameImagen) this.framePrincipal.getjDesktopPanePrincipal().getSelectedFrame();
            JInternalFrameGrises internalNuevo = new JInternalFrameGrises(internal);
            internalNuevo.setVisible(true);
            this.framePrincipal.getjDesktopPanePrincipal().add(internalNuevo);
        }
    }
    
}
