/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.fgm.imagen;

import java.awt.image.ByteLookupTable;
import java.awt.image.LookupTable;

/**
 *Clase RaizNesima, crea filtro raiznesima con parametro pasado al constructor
 * @author javi
 */
public class RaizNesima {
    /**
     * Constructor
     * @param n double
     * @return LookupTable
     */
     public static LookupTable RaizNesima(double n)
  {
   // if(n==15){
      return raiz(n);
  //  }
    //return null;
  }
    /**
     * Crea el filtro raiz segun el parametro pasado
     * @param n double
     * @return LookupTable
     */ 
      public static LookupTable raiz(double n)
  {
    double K = 255.0/(Math.pow(255,n));
    byte[] lt = new byte[256];
    
    for (int i = 0; i <= 255; i++) {
      lt[i] = ((byte)(int)(Math.pow((i/K),(1/n))));
    }
    ByteLookupTable lookdevuelto = new ByteLookupTable(0, lt);
    
    return lookdevuelto;
    
  }
     
}
