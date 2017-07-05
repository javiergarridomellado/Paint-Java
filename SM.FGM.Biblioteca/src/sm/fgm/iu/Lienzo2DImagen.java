/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.fgm.iu;

import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.awt.image.BufferedImage;

/**
 *No se usa en practica final
 * @author javi
 */
public class Lienzo2DImagen extends Lienzo2D {
       
    BufferedImage img;
    private boolean ponerRecuadro = true;

    public boolean isPonerRecuadro() {
        return ponerRecuadro;
    }

    public void setPonerRecuadro(boolean ponerRecuadro) {
        this.ponerRecuadro = ponerRecuadro;
    }

    public BufferedImage getImage() {
        return img;
    }

    public void setImage(BufferedImage img) {
        this.img = img;
        if(img!=null) {
           setPreferredSize(new Dimension(img.getWidth(),img.getHeight()));//el scroll hay que ponerlo posicion centro           
          Rectangle r = new Rectangle(0, 0, img.getWidth(), img.getHeight());
          setClip(r);
}
    }

    
    public BufferedImage getImage(boolean drawVector){ 
        if (drawVector) {
             BufferedImage imgSal = new BufferedImage(this.img.getWidth(), this.img.getHeight(), this.img.getType());//se indica ancho alto y tipo
             
             paint(imgSal.createGraphics());
             
             return imgSal;
        }
        else{        return this.getImage();}
      
    }
    
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);//llama al paint de lienzo2D el padre
        if(img!=null) g.drawImage(img,0,0,this);//leer pie de pagina se pone asi para que lo que se dibuje se vea sino se supondria si se sobrecargase paint
//el for de shape y se va pintando es lo siguiente que iria, se podria meter todo lo que va despues de la llamada a super.paint(g)
// en un metodo pintavectordeshape() y llamarse desde aqui , en vez de hacer for se llama pintavector justo despues del g.drawimage
        if ((this.clip != null) && (this.ponerRecuadro)) {
                ponerRecuadro(g);
         }
    }
    
    private void ponerRecuadro(Graphics g)
  {
    Graphics2D g2d = (Graphics2D)g;
    Stroke sk = g2d.getStroke();
    float[] patronDiscontinuidad = { 5.0F, 5.0F };
    Stroke linea = new BasicStroke(1.0F, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER, 1.0F, patronDiscontinuidad, 0.0F);
    g2d.setStroke(linea);
    g2d.draw(this.clip);
    g2d.setStroke(sk);
  }
    /**
     * Creates new form Lienzo2DImagen
     */
    public Lienzo2DImagen() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));
        setOpaque(false);

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
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}