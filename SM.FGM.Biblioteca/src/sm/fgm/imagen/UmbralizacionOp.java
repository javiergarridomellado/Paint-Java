/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.fgm.imagen;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.util.Arrays;
import sm.image.BufferedImageOpAdapter;
import sm.image.BufferedImagePixelIterator;
import sm.image.BufferedImageSampleIterator;

/**
 *Clase UmbralizacionOp para umbralizar en blanco negro, constructor se le pasa parametro umbral
 * @author javi
 */
public class UmbralizacionOp extends BufferedImageOpAdapter{
   private int umbral;
   private Color c;
   /**
    * Devuelve umbral
    * @return int
    */
    public int getUmbral() {
        return umbral;
    }
/**
 * Establece umbral
 * @param umbral int
 */
    public void setUmbral(int umbral) {
        this.umbral = umbral;
    }
    /**
     * Constructor para umbral en tonalidad grises
     * @param umbral int 
     */
        public UmbralizacionOp(int umbral) {
        this.umbral = umbral;
        this.c=null;
       }
        /**
         * Constructor para umbralizar en color
         * @param umbral int
         * @param c Color
         */
       public UmbralizacionOp(int umbral,Color c) {
        this.umbral = umbral;
        this.c=c;
} 
       
       /** 
        * Metodo a implementar por haber heredado de BufferedImageOpAdapter, define el filtro
        * @param src imagen fuente
        * @param dest imagen destino
        * @return BufferedImage  devuelve imagen destino 
        */
public BufferedImage filter(BufferedImage src, BufferedImage dest){
        if (src == null) {
                throw new NullPointerException("Imagen fuente a null");
            }
    
        if (dest == null) {
            dest = createCompatibleDestImage(src, null);
        }

        if(this.c==null){
            dest = filterBN(src,dest);
        }else if(this.c!=null){
            dest = filterColor(src,dest);
        }
        /*WritableRaster srcRaster = src.getRaster();
        WritableRaster destRaster = dest.getRaster();
        
        for (BufferedImagePixelIterator it = new BufferedImagePixelIterator(src); it.hasNext();) {
            BufferedImagePixelIterator.PixelData pixel = it.next();
           // double[] blanco={255.0,255.0,255.0};
            //double[] negro={0.0,0.0,0.0};
            int[] blanco=new int[pixel.numSamples];
            Arrays.fill(blanco,255);
            
            int[] negro=new int[pixel.numSamples]; //creo array con esa dimension
            Arrays.fill(negro,0);//rellena el array de valor 0
            
            int suma=0;
            for (int i = 0;i<pixel.numSamples;i++){
                suma+= pixel.sample[i];
             }
            suma/=pixel.numSamples;
            
           if(suma>=umbral){
               destRaster.setPixel(pixel.col, pixel.row, blanco);
               
           }else{
              destRaster.setPixel(pixel.col, pixel.row, negro);
           }   
           //estRaster.setPixel(pixel.col, pixel.row, pixel.sample);
        }*/
        
    return dest;
}
/**
 * Filtro umbralizacion sobre niveles de gris
 * @param src imagen fuente
 * @param dest imagen destino
 * @return BufferedImage imagen destino
 */
public BufferedImage filterBN(BufferedImage src, BufferedImage dest){
      /*  if (src == null) {
                throw new NullPointerException("Imagen fuente a null");
            }
    
        if (dest == null) {
            dest = createCompatibleDestImage(src, null);
        }*/

        WritableRaster srcRaster = src.getRaster();
        WritableRaster destRaster = dest.getRaster();
        
        for (BufferedImagePixelIterator it = new BufferedImagePixelIterator(src); it.hasNext();) {
            BufferedImagePixelIterator.PixelData pixel = it.next();
           // double[] blanco={255.0,255.0,255.0};
            //double[] negro={0.0,0.0,0.0};
            int[] blanco=new int[pixel.numSamples];
            Arrays.fill(blanco,255);
            
            int[] negro=new int[pixel.numSamples]; //creo array con esa dimension
            Arrays.fill(negro,0);//rellena el array de valor 0
            
            int suma=0;
            for (int i = 0;i<pixel.numSamples;i++){
                suma+= pixel.sample[i];
             }
            suma/=pixel.numSamples;
            
           if(suma>=umbral){
               destRaster.setPixel(pixel.col, pixel.row, blanco);
               
           }else{
              destRaster.setPixel(pixel.col, pixel.row, negro);
           }   
           //estRaster.setPixel(pixel.col, pixel.row, pixel.sample);
        }
        
    return dest;
}
    /**
 * Filtro umbralizacion sobre color
 * @param src imagen fuente
 * @param dest imagen destino
 * @return BufferedImage imagen destino
 * @since  No acabado
 */
public BufferedImage filterColor(BufferedImage src, BufferedImage dest){
      

        WritableRaster srcRaster = src.getRaster();
        WritableRaster destRaster = dest.getRaster();
        
        for (BufferedImagePixelIterator it = new BufferedImagePixelIterator(src); it.hasNext();) {
            BufferedImagePixelIterator.PixelData pixel = it.next();
           // double[] blanco={255.0,255.0,255.0};
            //double[] negro={0.0,0.0,0.0};
            int[] blanco=new int[pixel.numSamples];
            Arrays.fill(blanco,255);
            
            int[] negro=new int[pixel.numSamples]; //creo array con esa dimension
            Arrays.fill(negro,0);//rellena el array de valor 0
            
            int suma=0;
            for (int i = 0;i<pixel.numSamples;i++){
                suma+= pixel.sample[i];
             }
            suma/=pixel.numSamples;
            
           if(suma>=umbral){
               destRaster.setPixel(pixel.col, pixel.row, blanco);
           //falta condicion
           }else{
              destRaster.setPixel(pixel.col, pixel.row, negro);
           }   
           //estRaster.setPixel(pixel.col, pixel.row, pixel.sample);
        }
        
    return dest;
}


}
