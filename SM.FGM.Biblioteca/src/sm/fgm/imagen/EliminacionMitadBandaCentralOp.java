/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.fgm.imagen;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import sm.image.BufferedImageOpAdapter;
import sm.image.BufferedImagePixelIterator;

/**
 *Clase EliminacionMitadBandaCentralOp, recorre todos los RGB de la imagen multiplicando por 0.5 su banda G
 * @author javi
 */
public class EliminacionMitadBandaCentralOp extends BufferedImageOpAdapter{
    public EliminacionMitadBandaCentralOp(){
      
    };
/**
 * Heredado de BufferedImageOpAdapter, crea filtro que elimina mitad de la banda central
 * @param src BufferedImage  Imagen fuente
 * @param dest BufferedImage Imagen destino
 * @return BufferedImage  Imagen destino
 */
    @Override
    public BufferedImage filter(BufferedImage src, BufferedImage dest) {
        if (src == null) {
                throw new NullPointerException("Imagen fuente a null");
            }
    
        if (dest == null) {
            dest = createCompatibleDestImage(src, null);
        }

         double[] color={255.0,255.0,255.0};
         
        WritableRaster srcRaster = src.getRaster();
        WritableRaster destRaster = dest.getRaster();
        
        for (BufferedImagePixelIterator it = new BufferedImagePixelIterator(src); it.hasNext();) {
            BufferedImagePixelIterator.PixelData pixel = it.next();
            color[0]=(int) (pixel.sample[0]);
            color[2]=(int) (pixel.sample[2]);
            color[1]=(int) (0.5*pixel.sample[1]);
            destRaster.setPixel(pixel.col, pixel.row, color);
            
        }
        
    return dest;
  } 
}
    
    


