/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.fgm.graficos;


import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
 *No se usa en practica Final
 * @author javi
 */
public class Linea extends Line2D.Float{
    
    
    /*aqui*/
     public Linea(Point2D p1, Point2D p2){
        super(p1,p2);
    }
    
    
    public boolean isNear(Point2D p){
       if((this.x1!=this.x2)||(this.y1!=this.y2)){
        return this.ptLineDist(p) <=2.0; /*The distance measured is the distance between the specified point and the closest point on the infinitely-extended line defined by this Line2D. If the specified point intersects the line, this method returns 0.0*/
        }
           
      return (Math.abs(this.x1 - p.getX()))<=5.0;
      
        }
    
    @Override
    public boolean contains(Point2D p) {
        return isNear(p);
    }

    public void setLocation(Point2D pos){
      double dx=pos.getX()-this.getX1();
      double dy=pos.getY()-this.getY1();
      Point2D newp2 = new Point2D.Double(this.getX2()+dx,this.getY2()+dy);
      this.setLine(pos,newp2);
      
}


    
    
    
}
    
