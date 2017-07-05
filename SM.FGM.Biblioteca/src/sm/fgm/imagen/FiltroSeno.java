/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.fgm.imagen;
import java.awt.image.ByteLookupTable;
import java.awt.image.LookupTable;
import sm.image.LookupTableProducer;
/**
 *Clase FiltroSeno , su constructor por defecto tiene valor fijo para seno, puede pasarse tambien valor del seno
 * @author javi
 */
public class FiltroSeno {
    /**
     * Constructor
     * @return LookupTable
     */
    public static LookupTable filtroSeno()
  {

      return seno(180.0/255.0);

  }
 /**
  * Calcula filtro seno segun valor parametro
  * @param w double
  * @return LookupTable
  */
     public static LookupTable seno(double w)
  {
    double K = 255.0;
    byte[] lt = new byte[256];
    
    for (int i = 0; i <= 255; i++) {
      lt[i] = ((byte)(int)(K * Math.abs(Math.sin(Math.toRadians(i * w)))));
    }
    ByteLookupTable lookdevuelto = new ByteLookupTable(0, lt);
    
    return lookdevuelto;
    
  }
/**
 * Constructor
 * @param i double
 * @return LookupTable
 */
    public LookupTable FiltroSeno(double i) {
        return seno(i); //To change body of generated methods, choose Tools | Templates.
    }
    
}
