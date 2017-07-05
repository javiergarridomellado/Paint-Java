/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.fgm.iu;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;
import java.util.ArrayList;
import java.util.List;
import sm.fgm.graficos.Figura;
import sm.fgm.graficos.Linea;
import sm.fgm.graficos.MiCurva;
import sm.fgm.graficos.MiElipse;
import sm.fgm.graficos.MiLinea;
import sm.fgm.graficos.MiRectangulo;
import sm.fgm.graficos.MiRectanguloRedondeado;


/**
 *Clase utilizada para el dibujo (gestiona) de las diferentes formas geometricas. Los atributos de esta clase son temporales, no son los de
 * la forma geometrica.
 * @author javi
 */
public class Lienzo2Dfinal extends javax.swing.JPanel{
    public static final int FORMA_PUNTO=0,FORMA_LINEA=1,FORMA_RECTANGULO=2,FORMA_OVALO=3,FORMA_RECTANGULOREDONDEADO=4,FORMA_CURVA=5;
    Color color = Color.BLACK;
    Color colorRelleno = Color.BLACK;
    protected boolean discontinuidad=false;

    boolean puntoControlfalta=false;
    //float patronDiscontinuidad[] = {15.0f, 15.0f};
    //Stroke trazo = new BasicStroke(10.0f,BasicStroke.CAP_ROUND,BasicStroke.JOIN_MITER, 1.0f,patronDiscontinuidad, 0.0f);
    Stroke stroke = new BasicStroke(1.0F); 
    protected Point2D p,p2,p3,p4;
    protected List<Shape> vShape = new ArrayList();
    protected Shape sh_creado;
    protected boolean relleno=false;
    protected boolean degradadovertical=false;
    protected boolean degradadohorizontal=false;
    //protected boolean transparencia = false;  
    protected int grado_transparencia=0;

    protected boolean alisado = false;
    protected boolean editar = false;
    protected int modo=0;
    Composite comp=AlphaComposite.getInstance(AlphaComposite.SRC_OVER,1.0f);
//    BoundingBox bb;

   // Composite comp2=AlphaComposite.getInstance(AlphaComposite.SRC);
   // RenderingHints render= new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
   // RenderingHints render2= new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_OFF);
    protected Shape clip = null;
    //protected int brillo=0;
/**
 * Devuelve si degradado vertical esta activo
 * @return boolean
 * 
 */
   public boolean isDegradadovertical() {
        return degradadovertical;
    }
/**
 * Devuelve indice del grado de transparencia ( util para gestion combobox)
 * @return int 
 */
    public int getGrado_transparencia() {
        return grado_transparencia;
    }
/**
 * Establece grado transparencia, util para combobox
 * @param grado_transparencia int 
 */
    public void setGrado_transparencia(int grado_transparencia) {
        this.grado_transparencia = grado_transparencia;
    }
    
    /**
     * Establece si degradado vertical esta activo
     * @param degradadovertical boolean
     * 
     */
    public void setDegradadovertical(boolean degradadovertical) {
        this.degradadovertical = degradadovertical;
    }
/**
 * Devuelve si degradado horizontal esta activo
 * @return boolean
 * 
 */
    public boolean isDegradadohorizontal() {
        return degradadohorizontal;
    }
 /**
     * Establece si degradado horizontal esta activo
     * @param degradadohorizontal boolean 
     * 
     */
    public void setDegradadohorizontal(boolean degradadohorizontal) {
        this.degradadohorizontal = degradadohorizontal;
    }
/**
 * Devuelve el Shape usado para el clip
 * @return Shaoe 
 */
    
    public Shape getClip() {
        return clip;
    }
/**
 * Establece el Shape para el clip
 * @param clip Shape 
 */
    public void setClip(Shape clip) {
        this.clip = clip;
    }
     
        
    /**
     * Constructor
     * Creates new form Lienzo2D
     */
    public Lienzo2Dfinal() {
        initComponents();
                
    }

    /**
     * Dibuja todas las formas geometricas almacenadas en el vector sobre el lienzo, la imagen si la hubiera se
     * dibuja en el fondo mediante  la llamada  a paintComponent desarrollado en la clase heredera que es la que usa para la
     * ventanainterna( hereda todo de esta) 
     * @param g Graphics
     */
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;
        /*g2d.setPaint(color);
        g2d.setStroke(stroke);
        if(transparencia){g2d.setComposite(comp);}
        if(alisado){g2d.setRenderingHints(render);}*/
        if (this.clip != null) {
             g2d.clip(this.clip);
         }
        for(Shape s:vShape) {
            ((Figura)s).pintar(g2d);
            
            /*g2d.setPaint(((Figura)s).getColor());
            g2d.setStroke(((Figura)s).getTrazo());
            if(((Figura)s).getTransparencia()){
            //if(transparencia){
                //System.out.println(((Figura)s).getTransparencia());
                g2d.setComposite(comp);
            }
            if(((Figura)s).getAlisado()){g2d.setRenderingHints(render);}
            
            
            
            if(((Figura)s).getRelleno()) g2d.fill(s);
                g2d.draw(s);
            g2d.setRenderingHints(render2); 
            g2d.setComposite(comp2);*/
            
        }
}
  
    /**
     * Crea una nueva forma geometrica inicial segun modo seleccionado y el punto pasado, ademas se 
     * establecen atributos de la forma geometrica
     * @param p_a Point2D
     * @return Shape
     */
    
    private Shape createShape(Point2D p_a){
     
        if(p_a==null){
            return null;
        }
      
        if(modo==0){
             
             //sh_creado=(Shape) new Point2D.Double(p_a.getX(),p_a.getY());
             sh_creado= new MiLinea(p_a,p_a); //punto con las mismas coordenadas, asi crea punto en vez linea
            /*((Figura)sh_creado).setColor(color);
             ((Figura)sh_creado).setTrazo(stroke);
             ((Figura)sh_creado).setTransparencia(transparencia);
             ((Figura)sh_creado).setAlisado(alisado);*/
            
             
             
         }else if(modo==1){
             
             sh_creado= new MiLinea(p_a,p_a); // linea
            /* ((Figura)sh_creado).setColor(color);
             ((Figura)sh_creado).setTrazo(stroke);
              ((Figura)sh_creado).setTransparencia(transparencia);
              ((Figura)sh_creado).setAlisado(alisado);*/
             
         }else if(modo==2){  
             //sh_creado= new Rectangle2D.Double(p_a.getX(),p_a.getY(),0,0); // rectangulo
            sh_creado= new MiRectangulo(p_a.getX(),p_a.getY());
         }else if(modo==3){ 
             sh_creado= new MiElipse(p_a.getX(),p_a.getY());
            // return sh_creado;
         }else if(modo==4){  
             //sh_creado= new Rectangle2D.Double(p_a.getX(),p_a.getY(),0,0); // rectangulo
            sh_creado= new MiRectanguloRedondeado(p_a.getX(),p_a.getY());   
         }else if(modo==5){  
             //sh_creado= new Rectangle2D.Double(p_a.getX(),p_a.getY(),0,0); // rectangulo
            sh_creado= new MiCurva(p_a.getX(),p_a.getY(),p_a.getX(),p_a.getY(),p_a.getX(),p_a.getY());  
            p3=p_a;
            /* sh_temporal= new MiCurva(p_a.getX(),p_a.getY(),p_a.getX(),p_a.getY(),p_a.getX(),p_a.getY());
             return sh_temporal;*/
         }else{
       
             sh_creado=null;
         }
        
        if(sh_creado!=null){
            ((Figura)sh_creado).setColor(this.color);
            ((Figura)sh_creado).setTrazo(this.stroke);
            //((Figura)sh_creado).setTransparencia(this.transparencia);
            ((Figura)sh_creado).setAlisado(this.alisado);
            ((Figura)sh_creado).setRelleno(this.relleno);
            ((Figura)sh_creado).setColorRelleno(this.colorRelleno);
            ((Figura)sh_creado).setDegradadohorizontal(this.degradadohorizontal);
            ((Figura)sh_creado).setDegradadovertical(this.degradadovertical);
            ((Figura)sh_creado).setTransp(this.comp);
            ((Figura)sh_creado).setEditar(this.editar);
        }
        return sh_creado;
    }
   
   /**
    * Usado para actualizar las formas geometricas en el evento dragged
    * @param p_a Point2D Punto inicial de la figura 
    * @param p_b Point2D Punto final de la figura
    */ 
    
   private void updateShape(Point2D p_a, Point2D p_b){
        if (sh_creado instanceof MiLinea) {        
            //((MiLinea)sh_creado).setLine(p_a, p_b);
            ((MiLinea)sh_creado).update(p_a, p_b);
         }else if(sh_creado instanceof MiRectangulo) {
             ((MiRectangulo)sh_creado).update(p_a, p_b);
         }else if(sh_creado instanceof MiElipse) {
             ((MiElipse)sh_creado).update(p_a, p_b);
         }else if(sh_creado instanceof MiRectanguloRedondeado) {
             ((MiRectanguloRedondeado)sh_creado).update(p_a, p_b);  
         }else if(sh_creado instanceof MiCurva) {
             ((MiCurva)sh_creado).update(p_a,p_b, p2);  //segundo param cambiar, calcular punto control    
         }/*else if(sh_creado instanceof RectangularShape) {
             ((RectangularShape)sh_creado).setFrameFromDiagonal(p_a, p_b);
      }*/
 
    }
    
   /**
    * Devuelve color elegido en ventana principal
    * @return Color
    */
    public Color getColor() {
        return color;
    }
/** Establece Color
 * 
 * @param color Color 
 */
    public void setColor(Color color) {
        if(this.isRelleno()){
            this.colorRelleno = color;
        }else{    
             this.color = color;
        }
    }
/**
 * Devuelve stroke 
 * @return Stroke
 */
    public Stroke getStroke() {
        return stroke;
    }
/**
 * Establece stroke
 * @param stroke Stroke
 */
    public void setStroke(Stroke stroke) {
        this.stroke = stroke;
    }
    /**
     * Devuelve Composite (transparencia)
     * @return Composite
     */
    public Composite getComp() {
        return comp;
    }
/**
 * Establece transparencia
 * @param comp Composite
 */
    public void setComp(Composite comp) {
        this.comp = comp;
    }
    /**
     * Devuelve si la opcion relleno esta activada
     * @return boolean
     * 
     */
    public boolean isRelleno() {
        return relleno;
    }
/**
 * Establece modo relleno
 * @param relleno boolean
 *  
 */
    public void setRelleno(boolean relleno) {
        this.relleno = relleno;
    }

/*    public boolean isTransparencia() {
        return transparencia;
    }

    public void setTransparencia(boolean transparencia) {
        this.transparencia = transparencia;
        //System.out.println(this.transparencia);
        
    }*/
/**
 * Devuelve si modo alisado activo
 * @return boolean
 */
    public boolean isAlisado() {
        return alisado;
    }
/**
 * Establece modo alisado
 * @param alisado boolean
 */
    public void setAlisado(boolean alisado) {
        this.alisado = alisado;
    }
/**
 * Devuelve si opcion editar activa
 * @return boolean
 */
    public boolean isEditar() {
        return editar;
    }
/**
 * Activa modo editar y cambia el cursor
 * @param editar boolean
 */
    public void setEditar(boolean editar) {
        this.editar = editar;
        if (this.editar) { 
            setCursor(Cursor.getDefaultCursor());
        } else {
            Cursor c= new Cursor(1);
            setCursor(c);
         }
        
    }
    /**
     * Devuelve si discontinuidad activada
     * @return boolean
     */
    public boolean isDiscontinuidad() {
        return discontinuidad;
    }
/**
 * Establece si continuidad activa
 * @param discontinuidad boolean
 */
    public void setDiscontinuidad(boolean discontinuidad) {
        this.discontinuidad = discontinuidad;
    }
    
   /* public boolean isTransparencia_extra() {
        return transparencia_extra;
    }

    public void setTransparencia_extra(boolean transparencia_extra) {
        this.transparencia_extra = transparencia_extra;
    }*/
    /**
     * Devuelve el modo de figura geometrica seleccionado
     * @return int
     */
    public int getModo() {
        return modo;
    }
/** 
 * Establece modo de figura geometrica seleccionado
 * @param modo int
 */
    public void setModo(int modo) {
        this.modo = modo;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>                        
/**
 * Evento pulsar del raton, diferencia si esta en modo editar para seleccionar una figura ( en caso de contenerla ) o crear una nueva,
 * diferenciando el caso de la curva donde una variable nos dice si es de nueva creacion o solo falta asignar el punto de control
 **
 * @param evt  MouseEvent
 */
    private void formMousePressed(java.awt.event.MouseEvent evt) {                                  
        p4=new Point2D.Double();
        p = evt.getPoint();
      
        
        if(editar){
            this.sh_creado =  getSelectedShape(p);
            
            if(sh_creado!=null){
                double x=0,y=0;
                if (sh_creado instanceof MiLinea){
                    x=((MiLinea)sh_creado).getX1();
                    y=((MiLinea)sh_creado).getY1();
                 
                }else
                    if (sh_creado instanceof MiRectangulo){
                    x=((MiRectangulo)sh_creado).getX();
                    y=((MiRectangulo)sh_creado).getY();
                  
                }else if (sh_creado instanceof MiElipse){
                    x=((MiElipse)sh_creado).getX();
                    y=((MiElipse)sh_creado).getY();
                 
                }else if (sh_creado instanceof MiRectanguloRedondeado){
                    x=((MiRectanguloRedondeado)sh_creado).getX(); 
                    y=((MiRectanguloRedondeado)sh_creado).getY();  
                 
                }else if (sh_creado instanceof MiCurva){
                     x= ((MiCurva)sh_creado).getX1();
                     y= ((MiCurva)sh_creado).getY1();
                 }
               
                p4.setLocation( p.getX()-x ,  p.getY()-y); 
               }
            
           if(sh_creado!=null){
             ((Figura)sh_creado).setColor(this.color);
             ((Figura)sh_creado).setTrazo(this.stroke);
             //((Figura)sh_creado).setTransparencia(this.transparencia);
             ((Figura)sh_creado).setAlisado(this.alisado);
             ((Figura)sh_creado).setRelleno(this.relleno);
             ((Figura)sh_creado).setColorRelleno(this.colorRelleno);
             ((Figura)sh_creado).setDegradadohorizontal(this.degradadohorizontal);
             ((Figura)sh_creado).setDegradadovertical(this.degradadovertical);
             ((Figura)sh_creado).setTransp(this.comp);
             ((Figura)sh_creado).setEditar(this.editar);
             }
        } else{
            if((modo==FORMA_CURVA)&&(puntoControlfalta)){
                if((Figura)vShape.get(vShape.size()-1) instanceof MiCurva){
                
                     ((MiCurva)vShape.get(vShape.size()-1)).update(p3, evt.getPoint(), p2);
               }
            }else{
             Shape nuevo_s= createShape(p);
             vShape.add(nuevo_s);
            }
        } // paso  punto en create hago if-else
    }                                 
/**
 * Evento de soltar la tecla pulsada del raton , se diferencia si editar activo o no, si lo esta se pone a false
 * el atributo editar de la figura para que elimine boundingbox( en mi caso rectangulo ya que no me deja importar libreria javafx.geometry.BoundingBox)
 * en caso de no editar llama a dragged o termina de actualizar la curva donde faltaba el punto de control
 * @param evt Evento de Raton
 */
    private void formMouseReleased(java.awt.event.MouseEvent evt) {                                   
        
        if (editar) {//anadido
             setCursor(Cursor.getDefaultCursor());
             if(sh_creado!=null){
             ((Figura)sh_creado).setEditar(false);
                     }         
      }else{
          if((modo==FORMA_CURVA)&&(puntoControlfalta)){
              ((MiCurva)sh_creado).update(p3, evt.getPoint(), p2);
              puntoControlfalta=false;
              repaint();
          }else{  
            puntoControlfalta=true;
          this. formMouseDragged(evt);  
          }
        }
    }                                  
/**
 * Evento de raton donde mientras se pulsa hay movimiento, se va recogiendo el punto y si esta modo editar mueve la figura a
 * una nueva localizacion, en otro caso actualiza la figura geometrica, nuevamente acaba por definir la curva o la actualiza si esta
 * en el primer paso de definicion de la curva
 * @param evt Evento de raton
 */
    
    private void formMouseDragged(java.awt.event.MouseEvent evt) {                                  
        Point2D punto = evt.getPoint();
            
                if(editar){
                       //Point2D pnt=new Point2D.Double(punto.getX(),punto.getY());
                       /*if (sh_creado instanceof Linea){
                            ((Linea)sh_creado).setLocation(punto);
                         } else{ */    
                    if(sh_creado!=null){
                       //setLocation(sh_creado,punto);
                        setLocation(sh_creado,new Point2D.Double(evt.getX()-p4.getX(),evt.getY()-p4.getY())); 
                    }
                } else if (modo != 0) {//el punto no se actualiza{
                    if((modo==FORMA_CURVA)&&(puntoControlfalta)&&(sh_creado instanceof MiCurva)){
                        //((MiCurva)vShape.get(vShape.size()-1)).update(p, punto, p2);
                        ((MiCurva)sh_creado).update(p3,punto, p2);
                    }else if((modo==FORMA_CURVA)&&!(puntoControlfalta)){
                        p2=evt.getPoint();
                        updateShape(p, punto);
                    }else{
                     puntoControlfalta = false;
                     updateShape(p, punto);
                    }
                }
    
             
        repaint();
    }                                 

    /**
     * Si modo editar activado, en el pressed se llama a este metodo para detectar si una figura contiene el punto seleccionado
     * @param p Point2D
     * @return Shape
     */
    
    private Shape getSelectedShape(Point2D p){
        for(Shape s:vShape)
            if(s.contains(p)) return s;
                return null;
}
    
/**
 * Si esta activo modo editar este metodo es llamado para mover la figura geometrica a una nueva localizacion, dentro se usa los setlocation de cada clase
 * @param s Shape
 * @param pos Point2D
 */    
private void setLocation(Shape s, Point2D pos){
         if (s instanceof MiLinea){
            ((MiLinea)s).setLocation(pos);
        }else if (s instanceof MiRectangulo){
            //((MiRectangulo)s).setFrame(pos.getX(), pos.getY(), ((MiRectangulo)s).getWidth(),((MiRectangulo)s).getHeight());
            ((MiRectangulo)s).setLocation(pos.getX(), pos.getY(), ((MiRectangulo)s).getWidth(),((MiRectangulo)s).getHeight());
        }else if (s instanceof MiElipse){
            //((MiElipse)s).setFrame(pos.getX(), pos.getY(), ((MiElipse)s).getWidth(),((MiElipse)s).getHeight());
            ((MiElipse)s).setLocation(pos.getX(), pos.getY(), ((MiElipse)s).getWidth(),((MiElipse)s).getHeight());
        }else if (s instanceof MiRectanguloRedondeado){
            //((MiRectanguloRedondeado)s).setFrame(pos.getX(), pos.getY(), ((MiRectanguloRedondeado)s).getWidth(),((MiRectanguloRedondeado)s).getHeight());  
            ((MiRectanguloRedondeado)s).setLocation(pos.getX(), pos.getY(), ((MiRectanguloRedondeado)s).getWidth(),((MiRectanguloRedondeado)s).getHeight()); 
        }else if (s instanceof MiCurva){
            //((MiRectanguloRedondeado)s).setFrame(pos.getX(), pos.getY(), ((MiRectanguloRedondeado)s).getWidth(),((MiRectanguloRedondeado)s).getHeight());  
            ((MiCurva)s).setLocation(pos);
            //((MiRectanguloRedondeado)s).setLocation(pos.getX(), pos.getY(), ((MiRectanguloRedondeado)s).getWidth(),((MiRectanguloRedondeado)s).getHeight()); 
        }/*else if(s instanceof RectangularShape){
            ((RectangularShape)s).setFrame(pos.getX(), pos.getY(), ((RectangularShape)s).getWidth(),((RectangularShape)s).getHeight());
       
        }*/
}

   
    // Variables declaration - do not modify                     
    // End of variables declaration  
    
}
