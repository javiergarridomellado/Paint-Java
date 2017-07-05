/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.fgm.graficos;

import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 *Clase  MiElipse que hereda de Figura y usa en su constructor dos parametros para la creacion de una nueva elipse
 * @author javi
 */
public class MiElipse extends Figura{
    /**
     * Constructor de la clase
     * @param d1 Inicializa la elipse con la coordenada X especificada
     * @param d2 Inicializa la elipse con la coordenada Y especificada
     */
    public MiElipse(Double d1, Double d2){
        super();
        sh_creado= new Ellipse2D.Double(d1,d2,0,0);
        //modo=FORMA_OVALO;
    }

    @Override
    public Rectangle getBounds() {
        return ((Ellipse2D)sh_creado).getBounds(); 
    }

    @Override
    public Rectangle2D getBounds2D() {
        return ((Ellipse2D)sh_creado).getBounds2D();
    }

    @Override
    public boolean contains(double d, double d1) {
        return ((Ellipse2D)sh_creado).contains(d, d1); 
    }

    @Override
    public boolean contains(Point2D pd) {
        return ((Ellipse2D)sh_creado).contains(pd); 
    }

    @Override
    public boolean intersects(double d, double d1, double d2, double d3) {
        return ((Ellipse2D)sh_creado).intersects(d, d1, d2, d3) ;
    }

    @Override
    public boolean intersects(Rectangle2D rd) {
        return ((Ellipse2D)sh_creado).intersects(rd); 
    }

    @Override
    public boolean contains(double d, double d1, double d2, double d3) {
        return ((Ellipse2D)sh_creado).contains(d, d1, d2, d3);
    }

    @Override
    public boolean contains(Rectangle2D rd) {
        return ((Ellipse2D)sh_creado).contains(rd); 
    }

    @Override
    public PathIterator getPathIterator(AffineTransform at) {
        return ((Ellipse2D)sh_creado).getPathIterator(at); 
    }

    @Override
    public PathIterator getPathIterator(AffineTransform at, double d) {
        return ((Ellipse2D)sh_creado).getPathIterator(at, d);
    }
    /**
     * Actualiza la elipse con los puntos de la diagonal  pasados
     * @param p1 Punto de la diagonal
     * @param p2 El otro punto de la diagonal
     */
     public void update(Point2D p1, Point2D p2) {
        //((Rectangle2D)sh_creado).setFrameFromDiagonal(p1, p2);
        ((Ellipse2D)sh_creado).setFrameFromDiagonal(p1, p2);
        //setFrameFromDiagonal(p1, p2);
    }
    
     /**
     * Modifica la elipse con los parametros especificados
     * @param d1 Coordenada X del rectangulo
     * @param d2 Coordenada Y del rectangulo
     * @param d3 Ancho del rectangulo
     * @param d4 Altura del rectangulo
     */
      public void setLocation(double d1,double d2,double d3,double d4){
        ((Ellipse2D)sh_creado).setFrame(d1, d2, d3, d4);
    }
     
     public void setFrame(double d1,double d2,double d3,double d4){
        ((Ellipse2D)sh_creado).setFrame(d1, d2, d3, d4);
    }
     /**
     * Devuelve altura de la elipse
     * @return double
     */
    public double getHeight(){
        return ((Ellipse2D)sh_creado).getHeight();
    }
    /**
     * Devuelve anchura del rectangulo
     * @return double
     */
    public double getWidth(){
        return ((Ellipse2D)sh_creado).getWidth();
    } 
     /**
     * Devuelve coordenada X del primer punto
     * @return double
     */
   public double getX(){ 
    return ((Ellipse2D)sh_creado).getX();
   }
    /**
     * Devuelve coordenada Y del primer punto
     * @return double
     */
   public double getY(){ 
    return ((Ellipse2D)sh_creado).getY();
   }
    
}
