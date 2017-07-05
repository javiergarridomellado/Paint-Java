/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.fgm.imagen;

import java.awt.image.ByteLookupTable;
import java.awt.image.LookupTable;

/**
 *Clase TransformacionLogaritmica
 * @author javi
 */
public class TransformacionLogaritmica {
    /**
     * Constructor
     * @return LookupTable
     */
    public static LookupTable TransformacionLogaritmica()
  {
   //return null;
      return logaritmo();
  }
  
     public static LookupTable logaritmo()
  {
    double c = (255.0/Math.log(256));
    byte[] lt = new byte[256];
    
    for (int i = 0; i <= 255; i++) {
      lt[i] = ((byte)(int)(c * Math.log(i+1)));
    }
    ByteLookupTable lookdevuelto = new ByteLookupTable(0, lt);
    
    return lookdevuelto;
    
  }
    
 /*double c= (255/Math.log(256));
                    System.out.println(c*Math.log(255+1));*/
}
