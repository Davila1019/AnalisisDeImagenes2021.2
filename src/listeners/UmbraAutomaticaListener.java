/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import gui.InternalFrameUmbralizacion;
import gui.JFramePrincipal;
import gui.JInternalFrameImagen;
import gui.JInternalFrameUmbraAutomatica;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

/**
 *
 * @author Abelardo
 */
public class UmbraAutomaticaListener implements ActionListener{
private JFramePrincipal framePrincipal;

    public UmbraAutomaticaListener(JFramePrincipal framePrincipal) {
     this.framePrincipal = framePrincipal;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem item = (JMenuItem)e.getSource();
        if(item.getText().equals("Umbralizacion Automatica")){
           JInternalFrameImagen internal = (JInternalFrameImagen) this.framePrincipal.getjDesktopPanePrincipal().getSelectedFrame();
            JInternalFrameUmbraAutomatica internalNuevo = new JInternalFrameUmbraAutomatica(internal);
            internalNuevo.setVisible(true);
            this.framePrincipal.getjDesktopPanePrincipal().add(internalNuevo);
            }
        }
}
