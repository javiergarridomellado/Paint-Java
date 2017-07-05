/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.fgm.graficos;

import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 *Clase MiLinea que hereda de Figura, usa en el constructor dos puntos
 * @author javi
 */
public class MiLinea extends Figura{
    /**
     * Constructor
     * @param p1 Point2D
     * @param p2 Point2D
     */
    public MiLinea(Point2D p1, Point2D p2){
        super();
        sh_creado= new Line2D.Float(p1,p2);
       // modo=FORMA_LINEA;
        
    }
    /**
     * Actualiza la linea
     * @param p1 Point2D
     * @param p2 Point2D
     */
    public void update(Point2D p1,Point2D p2){
        ((Line2D)sh_creado).setLine(p1, p2);
    }
    /**
     * Modifica la linea con dos nuevos puntos
     * @param p1 Point2D
     * @param p2 Point2D
     */
    public void setLine(Point2D p1,Point2D p2){
        ((Line2D)sh_creado).setLine(p1, p2);
    }
    
    /**
     * Devuelve si la linea esta cerca del punto pasado
     * @param p Point2D
     * @return boolean
     */
     public boolean isNear(Point2D p){
       if((((Line2D)sh_creado).getX1()!=((Line2D)sh_creado).getX2())||(((Line2D)sh_creado).getY1()!=((Line2D)sh_creado).getY2())){
        return ((Line2D)sh_creado).ptLineDist(p) <=2.0; /*The distance measured is the distance between the specified point and the closest point on the infinitely-extended line defined by this Line2D. If the specified point intersects the line, this method returns 0.0*/
        }
           
      return (Math.abs(((Line2D)sh_creado).getX1() - p.getX()))<=3.0;
      
        }
   /**
    * Devuelve si contiene el punto que se le pasa
    * @param p Point2D
    * @return boolean
    */
      @Override
    public boolean contains(Point2D p) {
        return isNear(p);
    }
    /**
     * Modifica la linea recalculando los dos puntos
     * @param pos Point2D
     */
     public void setLocation(Point2D pos){
      double dx=pos.getX()-((Line2D)sh_creado).getX1();
      double dy=pos.getY()-((Line2D)sh_creado).getY1();
      Point2D newp2 = new Point2D.Double(((Line2D)sh_creado).getX2()+dx,((Line2D)sh_creado).getY2()+dy);
      ((Line2D)sh_creado).setLine(pos,newp2);
}
     
    @Override
    public Rectangle getBounds() {
        return ((Line2D)sh_creado).getBounds(); 
    }

    @Override
    public Rectangle2D getBounds2D() {
        return ((Line2D)sh_creado).getBounds2D(); 
    }

    @Override
    public boolean contains(double d, double d1) {
       return ((Line2D)sh_creado).contains(d, d1); 
    }

   

    @Override
    public boolean intersects(double d, double d1, double d2, double d3) {
        return ((Line2D)sh_creado).intersects(d, d1, d2, d3); 
    }

    @Override
    public boolean intersects(Rectangle2D rd) {
        return ((Line2D)sh_creado).intersects(rd);
    }

    @Override
    public boolean contains(double d, double d1, double d2, double d3) {
        return ((Line2D)sh_creado).contains(d, d1, d2, d3); 
    }

    @Override
    public boolean contains(Rectangle2D rd) {
        return ((Line2D)sh_creado).contains(rd); 
    }

    @Override
    public PathIterator getPathIterator(AffineTransform at) {
         return ((Line2D)sh_creado).getPathIterator(at);
    }

    @Override
    public PathIterator getPathIterator(AffineTransform at, double d) {
        return ((Line2D)sh_creado).getPathIterator(at,d); 
        
    }
    /**
     * Devuelve coordenada X del primer punto
     * @return double
     */
   public double getX1(){ 
    return ((Line2D)sh_creado).getX1();
   }
    /**
     * Devuelve coordenada Y del primer punto
     * @return double
     */
   public double getY1(){ 
    return ((Line2D)sh_creado).getY1();
   }
}
