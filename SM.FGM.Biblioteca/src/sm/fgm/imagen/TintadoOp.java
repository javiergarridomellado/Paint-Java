/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.fgm.imagen;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import sm.image.BufferedImageOpAdapter;
import sm.image.BufferedImageSampleIterator;

/**
 *Clase TintadoOp ,el constructor recibe el color que tinta y su grado
 * @author javi
 */
public class TintadoOp extends BufferedImageOpAdapter{
  
    
    private Color mixColor;
/**
 * Devuelve color con el que tinta
 * @return Color
 */
    public Color getMixColor() {
        return mixColor;
    }
/**
 * Establece color de tintado
 * @param mixColor Color
 */
    public void setMixColor(Color mixColor) {
        this.mixColor = mixColor;
    }
/**
 * Devuelve grado de tintado
 * @return float
 */
    public float getMixValue() {
        return mixValue;
    }
/**
 * Establece grado de tintado
 * @param mixValue float
 */
    public void setMixValue(float mixValue) {
        this.mixValue = mixValue;
    }
    private float mixValue;
   
    /**Constructor de la clase
     * 
     * @param mixColor Color
     * @param mixValue float
     */
    public TintadoOp(Color mixColor, float mixValue) {
        this.mixColor=mixColor;
        if(mixValue<0){
          this.mixValue=0;  
        }else if(mixValue>1){
            this.mixValue=1;
        }else{
        this.mixValue=mixValue;
        }
        
}
    /**
     * Metodo filter heredado y que se implementa obligatoriamente, devuelve imagen a la que se le ha aplicado el tintado
     * @param src imagen fuente
     * @param dest imagen destino
     * @return imagen destino
     */
    public BufferedImage filter(BufferedImage src, BufferedImage dest){
            if (dest == null) {
                dest = createCompatibleDestImage(src, null);
            }
            if (src == null) {
                throw new NullPointerException("Imagen fuente a null");
            }
        WritableRaster destRaster = dest.getRaster();
        float mixColorComp[] = mixColor.getColorComponents(null);

         for (BufferedImageSampleIterator it = new BufferedImageSampleIterator(src); it.hasNext();) {
            BufferedImageSampleIterator.SampleData sample = it.next();
            float colorBand= 255 * mixColorComp[sample.band];
            sample.value = ((int) (sample.value * (1.0f - mixValue) + colorBand * mixValue));
            destRaster.setSample(sample.col, sample.row, sample.band, sample.value);
            
        }


        return dest;
    }
}
  

