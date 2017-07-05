/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//http://www.lcc.uma.es/~galvez/ftp/libros/Java2D.pdf
package sm.fgm.graficos;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Composite;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.QuadCurve2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import java.util.List;

import javafx.geometry.BoundingBox;
/**
 *Clase abstracta Figura que hereda de Shape, contiene los atributos que definen a cada forma geometrica y los metodos imprescindibles
 * para dibujar  cada una de ellas.
 * @author javi
 * @version 1.0
 */
public  abstract class  Figura implements Shape{
   
    Composite comp=AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.5f);
    //Composite comp3=AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.1f);
    Composite comp2=AlphaComposite.getInstance(AlphaComposite.SRC);
    RenderingHints render= new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
    RenderingHints render2= new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_OFF);
    protected Composite transp;
    protected Color color,colorRelleno ;
    protected Stroke trazo ;
    protected boolean relleno;
    protected boolean degradadovertical;
    protected boolean degradadohorizontal;
    protected boolean alisado ;
   // protected boolean transparencia ;
    protected boolean editar;
    float patronDiscontinuidad[] = {15.0f, 15.0f};
    Stroke trazoseleccion = new BasicStroke(1.0f,BasicStroke.CAP_ROUND,BasicStroke.JOIN_MITER, 1.0f,patronDiscontinuidad, 0.0f);

    //protected boolean transparencia_extra ;
    protected Shape sh_creado;
    protected Point2D p;
   // public static final int FORMA_PUNTO=0,FORMA_LINEA=1,FORMA_RECTANGULO=2,FORMA_OVALO=3,FORMA_RECTANGULOREDONDEADO=4,FORMA_CURVA=5;
   // protected int modo;
   
    /**
     * Metodo que devuelve el color de la Forma geometrica
     * @return Color
     */
     public Color getColor() {
        return color;
    }
/**
     * Metodo que establece el color de la Forma geometrica
     * @param color Color que se le atribuye a la Forma  geometrica   
     */
    public void setColor(Color color) {
        this.color = color;
    }
    /**
     * Devuelve color de la Forma geometrica
     * @return Color 
     */
    public Color getColorRelleno() {
        return colorRelleno;
    }
/**
 * Establece color de relleno de la Forma geometrica
 * @param colorRelleno Color
 */
    public void setColorRelleno(Color colorRelleno) {
        this.colorRelleno = colorRelleno;
    }
    /**
     * Nos dice si la Forma geometrica esta en modo editar
     * @return boolean 
     */
    public boolean isEditar() {
        return editar;
    }
/**
 * Establece si la forma geometrica esta en modo editar
 * @param editar boolean
 */
    public void setEditar(boolean editar) {
        this.editar = editar;
    }
    /*public boolean isTransparencia_extra() {
        return transparencia_extra;
    }

    public void setTransparencia_extra(boolean transparencia_extra) {
        this.transparencia_extra = transparencia_extra;
    }*/
    
  /**
   * Constructor de la clase abstracta, es llamado en las formas que heredan, no es necesario su implementacion pero
   * lo uso para poner atributos por defecto en constructor de las formas geometricas
   */  
    
    public Figura(){
        editar=false;
        colorRelleno = Color.BLACK;
        color = Color.BLACK;
        trazo = new BasicStroke(1.0F); 
        relleno=false;
        alisado=false ;
        degradadovertical=false;
        degradadohorizontal=false;
//        transparencia=false ;
        transp=AlphaComposite.getInstance(AlphaComposite.SRC_OVER,1.0f);
        //transparencia_extra=false;
    }

    /**
     * Devuelve si el modo de relleno es degradado vertical
     * @return boolean 
     */
    public boolean isDegradadovertical() {
        return degradadovertical;
    }
/**
 * Establece modo de relleno de degradado vertical
 * @param degradadovertical boolean
 */
    public void setDegradadovertical(boolean degradadovertical) {
        this.degradadovertical = degradadovertical;
    }
/**
 * Devuelve si el modo de relleno de degradado vertical esta activo
 * @return boolean
 */
    public boolean isDegradadohorizontal() {
        return degradadohorizontal;
    }
/**
 * Establece modo de relleno de degradado horizontal
 * @param degradadohorizontal boolean
 */
    public void setDegradadohorizontal(boolean degradadohorizontal) {
        this.degradadohorizontal = degradadohorizontal;
    }
/**
 * Devuelve objeto Stroke de la Forma geometrica
 * @return Stroke
 */
   public Stroke getTrazo() {
        return trazo;
    }
/**
 * Establece trazo de la figura geometrca
 * @param trazo Es un Stroke para establecer el trazo de la figura
 */
    public void setTrazo(Stroke trazo) {
        this.trazo = trazo;
    }
    /**
     * Devuelve la transparencia de la Forma geometrica
     * @return Composite 
     */
    public Composite getTransp() {
        return transp;
    }
/**
 * Establece el grado de transparencia de la forma geometrica
 * @param transp Es un Composite para establecer el grado de transparencia
 */
    public void setTransp(Composite transp) {
        this.transp = transp;
    }
    /**
     * Nos dice si la figura geometrica esta en modo rellenar
     * @return boolean
     */
    public boolean getRelleno() {
        return relleno;
    }
/**
 * Establece la figura geometrica en modo relleno
 * @param relleno Es un booleano
 */
    public void setRelleno(boolean relleno) {
        this.relleno = relleno;
    }
/**
 * Nos dice si la figura geometrica esta en modo alisar
 * @return boolean
 */
    public boolean getAlisado() {
        return alisado;
    }
/**
 * Establece la figura geometrica en modo alisado
 * @param alisado boolean
 */
    public void setAlisado(boolean alisado) {
        this.alisado = alisado;
    }
/** Nos dice si la figura geometrica esta en modo transparencia
 * 
 * @return boolean
 */
   /* public boolean getTransparencia() {
        return transparencia;
    }
/**
 * Establece si la figura geometrica esta en modo transparencia
 * @param transparencia 
 */
    /*
    public void setTransparencia(boolean transparencia) {
        this.transparencia = transparencia;
    }
   */ 
/*
    public int getModo() {
        return modo;
    }

    public void setModo(int modo) {
        this.modo = modo;
    }
   */
    
    /**
     * Metodo pintar que no es mas que el metodo paint de Graphics pero orientado a objeto, ahora es un metodo de la figura
     * geometrica donde se le pasa un objeto Graphics a diferencia de lo que se hace en la clase Graphics.
     * @param g2d Objeto Graphics2D
     */
    public void pintar(Graphics2D g2d){
        
        
        if(editar){
           // System.out.println("entra");
            marcarFigura(g2d);
            
        }
            //g2d.setPaint(this.getColor());
            g2d.setStroke(this.getTrazo());
          //  if(this.getTransparencia()){
            //if(transparencia){
                //System.out.println(((Figura)s).getTransparencia());
               // g2d.setComposite(comp);
              g2d.setComposite(transp);
         //   }
            if(this.getAlisado()){g2d.setRenderingHints(render);}
            
            
            
            if(this.getRelleno()){
                 g2d.setPaint(this.getColorRelleno());
                 
                 if(degradadohorizontal){
                     pintarDegradadoHorizontal(g2d); 
                     
                 }
                 if(degradadovertical){
                     //System.out.println("entra");
                     pintarDegradadoVertical(g2d);                    
                 }
                 
                 g2d.fill(this);
            }
                g2d.setPaint(this.getColor());
                g2d.draw(this);
            g2d.setRenderingHints(render2); 
            g2d.setComposite(comp2);
        //editar=false;
    }
    /**
     * Metodo para pintar Degradado Horizontal
     * @param g2d Objeto Graphics2D
     */
public void pintarDegradadoHorizontal(Graphics2D g2d){
     if(sh_creado instanceof Rectangle2D){
                         //System.out.println("entra");
        Point2D punto1 = new Point2D.Double(((Rectangle2D)sh_creado).getX(), 0);
        Point2D punto2 = new Point2D.Double(((Rectangle2D)sh_creado).getX()+((Rectangle2D)sh_creado).getWidth() , 0);
                     
        GradientPaint gradiente = new GradientPaint(punto1,this.getColor(),punto2,this.getColorRelleno());
        g2d.setPaint(gradiente);
       }
     if(sh_creado instanceof RoundRectangle2D){
                         //System.out.println("entra");
        Point2D punto1 = new Point2D.Double(((RoundRectangle2D)sh_creado).getX(), 0);
        Point2D punto2 = new Point2D.Double(((RoundRectangle2D)sh_creado).getX()+((RoundRectangle2D)sh_creado).getWidth() , 0);
                     
        GradientPaint gradiente = new GradientPaint(punto1,this.getColor(),punto2,this.getColorRelleno());
        g2d.setPaint(gradiente);
        }
     if(sh_creado instanceof Ellipse2D){
        //System.out.println("entra");
        Point2D punto1 = new Point2D.Double(((Ellipse2D)sh_creado).getX(), 0);
        Point2D punto2 = new Point2D.Double(((Ellipse2D)sh_creado).getX()+((Ellipse2D)sh_creado).getWidth() , 0);
                     
        GradientPaint gradiente = new GradientPaint(punto1,this.getColor(),punto2,this.getColorRelleno());
        g2d.setPaint(gradiente);
        }
     if(sh_creado instanceof QuadCurve2D){
                         //System.out.println("entra");
        Point2D punto1 = new Point2D.Double(((QuadCurve2D)sh_creado).getX1(), 0);
        Point2D punto2 = new Point2D.Double(((QuadCurve2D)sh_creado).getX2(), 0);
                     
        GradientPaint gradiente = new GradientPaint(punto1,this.getColor(),punto2,this.getColorRelleno());
        g2d.setPaint(gradiente);
        }
}    
/**
     * Metodo para pintar Degradado Vertical
     * @param g2d Objeto Graphics2D
     */
public void pintarDegradadoVertical(Graphics2D g2d){
     if(sh_creado instanceof Rectangle2D){
                        // System.out.println("entra");
        Point2D punto1 = new Point2D.Double(0, ((Rectangle2D)sh_creado).getY());
        Point2D punto2 = new Point2D.Double(0 , ((Rectangle2D)sh_creado).getY()+((Rectangle2D)sh_creado).getHeight());
                     
        GradientPaint gradiente = new GradientPaint(punto1,this.getColor(),punto2,this.getColorRelleno());
        g2d.setPaint(gradiente);
       }
     if(sh_creado instanceof RoundRectangle2D){
                         //System.out.println("entra");
        Point2D punto1 = new Point2D.Double(0,((RoundRectangle2D)sh_creado).getY());
        Point2D punto2 = new Point2D.Double(0,((RoundRectangle2D)sh_creado).getY()+((RoundRectangle2D)sh_creado).getHeight() );
                     
        GradientPaint gradiente = new GradientPaint(punto1,this.getColor(),punto2,this.getColorRelleno());
        g2d.setPaint(gradiente);
        }
     if(sh_creado instanceof Ellipse2D){
        //System.out.println("entra");
        Point2D punto1 = new Point2D.Double(0,((Ellipse2D)sh_creado).getY());
        Point2D punto2 = new Point2D.Double(0,((Ellipse2D)sh_creado).getY()+((Ellipse2D)sh_creado).getHeight() );
                     
        GradientPaint gradiente = new GradientPaint(punto1,this.getColor(),punto2,this.getColorRelleno());
        g2d.setPaint(gradiente);
        }
     if(sh_creado instanceof QuadCurve2D){
                         //System.out.println("entra");
        Point2D punto1 = new Point2D.Double(0,((QuadCurve2D)sh_creado).getY1());
        Point2D punto2 = new Point2D.Double(0,((QuadCurve2D)sh_creado).getY2());
                     
        GradientPaint gradiente = new GradientPaint(punto1,this.getColor(),punto2,this.getColorRelleno());
        g2d.setPaint(gradiente);
        }
}   

/**
 * Establece un marco en la figura a editar
 * @param g2d Objeto Graphics2D
 */
public void marcarFigura(Graphics2D g2d){
      Rectangle2D seleccionado= new Rectangle2D.Double();
    //BoundingBox seleccionado= new BoundingBox(0,0,0,0); //
    
    
     
     if(sh_creado instanceof QuadCurve2D){
            seleccionado= sh_creado.getBounds2D();
            g2d.setPaint(Color.MAGENTA);
            g2d.setStroke(trazoseleccion);
             //BoundingBox seleccionado2= new BoundingBox(seleccionado.getMinX(),seleccionado.getMinY(),seleccionado.getWidth(),seleccionado.getHeight());
            
             g2d.draw(seleccionado);
     }   
    if(sh_creado instanceof Rectangle2D){
        seleccionado=sh_creado.getBounds2D();
                        // System.out.println("entra");
        //seleccionado.setFrame(((Rectangle2D)sh_creado).getMinX()-10,((Rectangle2D)sh_creado).getMinY()-10 ,((Rectangle2D)sh_creado).getWidth()+((Rectangle2D)sh_creado).getMinX() , ((Rectangle2D)sh_creado).getHeight()+((Rectangle2D)sh_creado).getMinY());
        seleccionado.setFrameFromDiagonal(seleccionado.getMinX()-10,seleccionado.getMinY()-10 ,seleccionado.getWidth()+seleccionado.getMinX()+10 , seleccionado.getHeight()+seleccionado.getMinY()+10);
       // seleccionado.setFrameFromDiagonal(((Rectangle2D)sh_creado).getMinX()-10,((Rectangle2D)sh_creado).getMinY()-10 ,((Rectangle2D)sh_creado).getWidth()+((Rectangle2D)sh_creado).getMinX()+10 , ((Rectangle2D)sh_creado).getHeight()+((Rectangle2D)sh_creado).getMinY()+10);
       //seleccionado=sh_creado.getBounds2D();
        g2d.setPaint(Color.MAGENTA);
        g2d.setStroke(trazoseleccion);
        g2d.draw(seleccionado);  
    }
     if(sh_creado instanceof RoundRectangle2D){
                         //System.out.println("entra");
         seleccionado=sh_creado.getBounds2D();
         seleccionado.setFrameFromDiagonal(seleccionado.getMinX()-10,seleccionado.getMinY()-10 ,seleccionado.getWidth()+seleccionado.getMinX()+10 , seleccionado.getHeight()+seleccionado.getMinY()+10);
        //seleccionado.setFrameFromDiagonal(((RoundRectangle2D)sh_creado).getMinX()-10,((RoundRectangle2D)sh_creado).getMinY()-10 ,((RoundRectangle2D)sh_creado).getWidth()+((RoundRectangle2D)sh_creado).getMinX()+10 , ((RoundRectangle2D)sh_creado).getHeight()+((RoundRectangle2D)sh_creado).getMinY()+10);
       
        g2d.setPaint(Color.MAGENTA);
        g2d.setStroke(trazoseleccion);
        g2d.draw(seleccionado);
        
        }
     if(sh_creado instanceof Ellipse2D){
         seleccionado=sh_creado.getBounds2D();
         seleccionado.setFrameFromDiagonal(seleccionado.getMinX()-10,seleccionado.getMinY()-10 ,seleccionado.getWidth()+seleccionado.getMinX()+10 , seleccionado.getHeight()+seleccionado.getMinY()+10);
       
        //seleccionado.setFrameFromDiagonal(((Ellipse2D)sh_creado).getMinX()-10,((Ellipse2D)sh_creado).getMinY()-10 ,((Ellipse2D)sh_creado).getWidth()+((Ellipse2D)sh_creado).getMinX()+10 , ((Ellipse2D)sh_creado).getHeight()+((Ellipse2D)sh_creado).getMinY()+10);
       
        g2d.setPaint(Color.MAGENTA);
        g2d.setStroke(trazoseleccion);
        g2d.draw(seleccionado);
        
        }
     if(sh_creado instanceof Line2D){
            seleccionado= sh_creado.getBounds2D();
            g2d.setPaint(Color.MAGENTA);
            g2d.setStroke(trazoseleccion);
            g2d.draw(seleccionado);
     }  
    
}


}
