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
 *Clase ConversionGrisOp que pasa imagen de color a tonalidades de grises usando factores de conversion
 * @author javi
 */
public class ConversionGrisOp extends BufferedImageOpAdapter{
   /**
    * Constructor
    * 
    */
    public ConversionGrisOp(){
        
    };
    /**
     * Heredado, crea filtro que devuelve imagen en escala de grises aplicandole factores
     * @param src BufferedImage Imagen fuente
     * @param dest BufferedImage Imagen destino
     * @return BufferedImage Imagen destino
     */
   public BufferedImage filter(BufferedImage src, BufferedImage dest){
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
            //a las 3 bandas le asigno mismo valor
            color[0]=color[1]=color[2]=(int) ((0.299*pixel.sample[0])+(0.587*pixel.sample[1])+(0.114*pixel.sample[2]));
            destRaster.setPixel(pixel.col, pixel.row, color);
           
        }
        
    return dest;
} 
}
