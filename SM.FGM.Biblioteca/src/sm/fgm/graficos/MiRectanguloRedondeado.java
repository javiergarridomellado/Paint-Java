/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.fgm.graficos;

import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

/**
 *Clase MiRectanguloRedondeado que hereda de Figura y usa dos doubles en su constructor
 * @author javi
 */
public class MiRectanguloRedondeado extends Figura{
    /**
     * Constructor 
     * @param d1 Double
     * @param d2 Double
     */
    public MiRectanguloRedondeado(Double d1, Double d2){
        super();
        sh_creado= new RoundRectangle2D.Double(d1,d2,0,0,10,10);
        //modo=FORMA_RECTANGULOREDONDEADO;
    }

    @Override
    public Rectangle getBounds() {
        return ((RoundRectangle2D)sh_creado).getBounds(); 
    }

    @Override
    public Rectangle2D getBounds2D() {
        return ((RoundRectangle2D)sh_creado).getBounds2D();  
    }

    @Override
    public boolean contains(double d, double d1) {
        return ((RoundRectangle2D)sh_creado).contains(d, d1); 
    }

    @Override
    public boolean contains(Point2D pd) {
        return ((RoundRectangle2D)sh_creado).contains(pd); 
    }

    @Override
    public boolean intersects(double d, double d1, double d2, double d3) {
        return ((RoundRectangle2D)sh_creado).intersects(d, d1, d2, d3); 
    }

    @Override
    public boolean intersects(Rectangle2D rd) {
        return ((RoundRectangle2D)sh_creado).intersects(rd);
    }

    @Override
    public boolean contains(double d, double d1, double d2, double d3) {
        return ((RoundRectangle2D)sh_creado).contains(d, d1,d2,d3); 
    }

    @Override
    public boolean contains(Rectangle2D rd) {
        return ((RoundRectangle2D)sh_creado).contains(rd); 
    }

    @Override
    public PathIterator getPathIterator(AffineTransform at) {
        return ((RoundRectangle2D)sh_creado).getPathIterator(at); 
    }

    @Override
    public PathIterator getPathIterator(AffineTransform at, double d) {
        return ((RoundRectangle2D)sh_creado).getPathIterator(at, d);
    }
   /**
    * Actualiza el rectangulo 
    * @param p1 Point2D
    * @param p2 Point2D
    */
    public void update(Point2D p1, Point2D p2) {
        ((RoundRectangle2D)sh_creado).setFrameFromDiagonal(p1, p2);
  
        //setFrameFromDiagonal(p1, p2);
    }
    /**
     * Modifica el Rectangulo redondeado con los parametros pasados
     * @param d1 Double
     * @param d2 Double
     * @param d3 Double
     * @param d4 Double
     */
    public void setLocation(double d1,double d2,double d3,double d4){
        ((RoundRectangle2D)sh_creado).setFrame(d1, d2, d3, d4);
    }
    public void setFrame(double d1,double d2,double d3,double d4){
        ((RoundRectangle2D)sh_creado).setFrame(d1, d2, d3, d4);
    }
    public double getHeight(){
        return ((RoundRectangle2D)sh_creado).getHeight();
    }
    public double getWidth(){
        return ((RoundRectangle2D)sh_creado).getWidth();
    }
     /**
     * Devuelve coordenada X del primer punto
     * @return double
     */
   public double getX(){ 
   return ((RoundRectangle2D)sh_creado).getX();
   }
    /**
     * Devuelve coordenada Y del primer punto
     * @return double
     */
   public double getY(){ 
    return ((RoundRectangle2D)sh_creado).getY();
   }
}
