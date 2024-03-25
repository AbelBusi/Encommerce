package com.Encommerce.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author cesar
 */
@Service
public class subirImagen {
    
    private String folder="imagenes//";
    
    public String guardarImagenProducto(MultipartFile file) throws IOException{
    
        if(!file.isEmpty()){
            
            byte [] bytes = file.getBytes();
            Path patch = Paths.get(folder+file.getOriginalFilename());
            Files.write(patch, bytes);
            return file.getOriginalFilename();
        }
        return "default.jpg";
    }
    
    public void eliminarImagenProducto(String nommbreImagen){
        
        String rutaImagen = "imagenes//";
        File file = new File(rutaImagen+nommbreImagen);
        file.delete();
                
        
    }
    
    
}
