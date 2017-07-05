/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.fgm.imagen;

import java.awt.image.ByteLookupTable;
import java.awt.image.LookupTable;

/**
 *Clase PotenciaNesima, crea filtro potencia segun parametro pasado al constructor
 * @author javi
 */
public class PotenciaNesima {
    /**
     * Constructor
     * @param n double
     * @return LookupTable
     */
     public static LookupTable PotenciaNesima(double n)
  {
   // if(n==15){
      return potencia(n);
  //  }
    //return null;
  }
   /**
    * Crea filtro potencia segun parametro pasado
    * @param n double
    * @return LookupTable
    */  
      public static LookupTable potencia(double n)
  {
    double K = 255.0/(Math.pow(255,n));
    byte[] lt = new byte[256];
    
    for (int i = 0; i <= 255; i++) {
      lt[i] = ((byte)(int)(K*Math.pow(i,n)));
    }
    ByteLookupTable lookdevuelto = new ByteLookupTable(0, lt);
    
    return lookdevuelto;
    
  }
}
