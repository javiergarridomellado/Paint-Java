/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.fgm.imagen;

import java.awt.image.BufferedImage;
import sm.image.BinaryOp;
/**
 *Clase RestaOp para restar dos imagenes
 * @author javi
 */
public class RestaOp extends BinaryOp{
   // private float alpha;
   // private static final float valor_alfa=0.5F;
    /**
     * Constructor 
     * @param img BufferedImage
     */
    public RestaOp(BufferedImage img) {
        super(img);
       // this.setAlpha(alpha);
}
   /* public SumaOp(BufferedImage img) {
        
        this(img,valor_alfa);
}*/
    /**
     * Realiza la resta
     * @param v1 int
     * @param v2 int
     * @return int
     */
    public int binaryOp(int v1, int v2){
        int rdo = v1-v2;
        if(rdo<=0) rdo=0;
        else if(rdo>=255) rdo=255;
        return rdo;
}
   /* public final void setAlpha(float alpha) {
            if (alpha < 0.0f) alpha = 0.0f;
              else if (alpha > 1.0f) alpha = 1.0f;
            this.alpha = alpha;
}
public float getAlpha() {
        return alpha;
}*/
}
