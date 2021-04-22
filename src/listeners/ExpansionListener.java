/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import gui.JFramePrincipal;
import gui.JInternalFrameExpansion;
import gui.JInternalFrameImagen;
import gui.JInternalFrameOtsu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

/**
 *
 * @author Abelardo
 */
public class ExpansionListener implements ActionListener{
    private JFramePrincipal framePrincipal;
    
    public ExpansionListener(JFramePrincipal framePrincipal) {
    this.framePrincipal = framePrincipal;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem item = (JMenuItem)e.getSource();
        if(item.getText().equals("Expansión")){
           JInternalFrameImagen internal = (JInternalFrameImagen) this.framePrincipal.getjDesktopPanePrincipal().getSelectedFrame();
            JInternalFrameExpansion internalNuevo = new JInternalFrameExpansion(internal);
            internalNuevo.setVisible(true);
            this.framePrincipal.getjDesktopPanePrincipal().add(internalNuevo);
            }
        }
}
