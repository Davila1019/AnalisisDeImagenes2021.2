/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herramientas;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 *
 * @author Abelardo
 */
public class GuardarImagen {
    File archivo;
    byte[] imagen;
    FileInputStream entrada;
    FileOutputStream salida;
    
    
    public String guardarImagen(File archivo, byte[] imagen ){
        String mensaje = null;
        try{
            salida = new FileOutputStream(archivo);
            salida.write(imagen);
            mensaje = "Imagen Guardada";
        }catch(Exception e){
        }
        return mensaje;
    }
}
