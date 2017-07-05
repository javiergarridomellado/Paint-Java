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
import java.awt.geom.QuadCurve2D;
import java.awt.geom.Rectangle2D;

/**
 *Clase MiCurva que hereda de Figura y usa en el constructor 6 parametros, los correspondientes al punto inicial (x,y), al punto final(x,y) y al punto de control(x,y)
 * @author javi
 */
public class MiCurva extends Figura{

    public MiCurva(double x1, double y1, double ctrlx, double ctrly, double x2, double y2){
        super();
        sh_creado =  new QuadCurve2D.Double(x1,y1,ctrlx,ctrly,x2,y2);
        //modo=FORMA_CURVA;
    }
    
    @Override
    public Rectangle getBounds() {
        return ((QuadCurve2D)sh_creado).getBounds(); 
    }

    @Override
    public Rectangle2D getBounds2D() {
        return ((QuadCurve2D)sh_creado).getBounds2D(); 
    }

    @Override
    public boolean contains(double d, double d1) {
        return ((QuadCurve2D)sh_creado).contains(d, d1); 
    }

    @Override
    public boolean contains(Point2D pd) {
        return ((QuadCurve2D)sh_creado).contains(pd); 
    }

    @Override
    public boolean intersects(double d, double d1, double d2, double d3) {
        return ((QuadCurve2D)sh_creado).intersects(d, d1, d2, d3); 
    }

    @Override
    public boolean intersects(Rectangle2D rd) {
        return ((QuadCurve2D)sh_creado).intersects(rd); 
    }

    @Override
    public boolean contains(double d, double d1, double d2, double d3) {
        return ((QuadCurve2D)sh_creado).contains(d, d1,d2,d3); 
    }

    @Override
    public boolean contains(Rectangle2D rd) {
        return ((QuadCurve2D)sh_creado).contains(rd); 
    }

    @Override
    public PathIterator getPathIterator(AffineTransform at) {
        return ((QuadCurve2D)sh_creado).getPathIterator(at); 
    }

    @Override
    public PathIterator getPathIterator(AffineTransform at, double d) {
        return ((QuadCurve2D)sh_creado).getPathIterator(at, d); 
    }
    /**
     * Devuelve punto de control
     * @return Point2D
     */
    public Point2D getCtrlPt(){
        return ((QuadCurve2D)sh_creado).getCtrlPt();
    }
    /**
     * Devuelve coordenada X del punto de control 
     *  @return double  
     */
     public double getCtrlX(){
        return ((QuadCurve2D)sh_creado).getCtrlX();
    }
     /**
      * Devuelve coordenada Y del punto de control
      * @return double
      */
     public double getCtrlY(){
        return ((QuadCurve2D)sh_creado).getCtrlY();
    } 
     /**
      * Devuelve el primer punto de la curva
      * @return Point2D
      */
    public Point2D getP1(){
        return ((QuadCurve2D)sh_creado).getP1();
    }
    /**
     * Devuelve el segundo punto de la curva
     * @return Point2D
     */
    public Point2D getP2(){
        return ((QuadCurve2D)sh_creado).getP2();
    }
     /**
      * Devuelve coordenada X del primer punto 
      * @return double
      */
     public double getX1(){
        return ((QuadCurve2D)sh_creado).getX1();
    }
     /**
      * Devuelve coordenada X del segundo punto 
      * @return double
      */
     public double getX2(){
        return ((QuadCurve2D)sh_creado).getX2();
    }
    /**
      * Devuelve coordenada Y del primer punto 
      * @return double
      */ 
     public double getY1(){
        return ((QuadCurve2D)sh_creado).getY1();
    } 
    /**
      * Devuelve coordenada Y del segundo punto 
      * @return double
      */  
     public double getY2(){
        return ((QuadCurve2D)sh_creado).getY2();
    } 
    /**
     * Actualiza la forma de la curva
     * @param p1 Point2D
     * @param p2 Point2D
     * @param p3 Point2D
     */ 
    public void setCurve(Point2D p1,Point2D p2,Point2D p3){
        //((QuadCurve2D)sh_creado).setCurve(x1, y1, ctrlx, ctrly, x2, y2);
        ((QuadCurve2D)sh_creado).setCurve(p1, p2, p3);
    }
    /**
     * Actualiza la forma de la curva
     * @param p1 Point2D
     * @param p2 Point2D
     * @param p3 Point2D
     */
    public void update(Point2D p1,Point2D p2,Point2D p3){
        //((QuadCurve2D)sh_creado).setCurve(x1, y1, ctrlx, ctrly, x2, y2);
        ((QuadCurve2D)sh_creado).setCurve(p1, p2, p3);
    }
    
   /* public void setLocation(double x1, double y1, double ctrlx, double ctrly, double x2, double y2){
        ((QuadCurve2D)sh_creado).setCurve(x1, y1, ctrlx, ctrly, x2, y2);
    }*/
    /**
     * Modifica la curva con los parametros especificados, para ello se recalcula donde se situa ahora el punto de control y el segundo punto
     * @param pos Point2D
     */
    public void setLocation(Point2D pos){
        Point2D p_aux=null;
        Point2D p_aux_control=null;
        double dist_x,dist_y;
        
         dist_x = pos.getX() - ((QuadCurve2D)sh_creado).getX1();
         dist_y = pos.getY() - ((QuadCurve2D)sh_creado).getY1();
         p_aux = new Point2D.Double( ((QuadCurve2D)sh_creado).getX2()+dist_x, ((QuadCurve2D)sh_creado).getY2()+dist_y);
         p_aux_control = new Point2D.Double(((QuadCurve2D)sh_creado).getCtrlX()+dist_x, ((QuadCurve2D)sh_creado).getCtrlY()+dist_y);
      
         setCurve(pos,p_aux_control, p_aux);
                   
    }
    
}
