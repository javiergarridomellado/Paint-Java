/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica7;

import java.io.File;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
//import sm.sound.SMRecorder;
import sm.sound.SMSoundRecorder;



/**
 *Clase VentanaInternaGrabador  la cual permite grabar audio, se añade manejador de eventos
 * @author javi
 */
public class VentanaInternaGrabador extends javax.swing.JInternalFrame {

    /**
     * Creates new form VentanaInternaGrabador
     */
  SMSoundRecorder grabacion;
    /**
     * Constructor al que se le pasa un fichero
     * @param f File
     */
    public VentanaInternaGrabador(File f) {
        initComponents();
        
        grabacion = new SMSoundRecorder(f) {};
        grabacion.setLineListener(new VentanaInternaGrabador.ManejadorAudio());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        botonGrabar = new javax.swing.JToggleButton();
        botonStop = new javax.swing.JToggleButton();

        FormListener formListener = new FormListener();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        addInternalFrameListener(formListener);
        getContentPane().setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 2, 1));

        buttonGroup1.add(botonGrabar);
        botonGrabar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconosPractica10/RecordPressed_48x48.png"))); // NOI18N
        botonGrabar.setToolTipText("Record");
        botonGrabar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/iconosPractica10/RecordPressed_48x48.png"))); // NOI18N
        botonGrabar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/iconosPractica10/RecordDisabled_48x48.png"))); // NOI18N
        botonGrabar.addActionListener(formListener);
        getContentPane().add(botonGrabar);

        buttonGroup1.add(botonStop);
        botonStop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconosPractica10/StopNormalRed_48x48.png"))); // NOI18N
        botonStop.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/iconosPractica10/StopNormalRed_48x48.png"))); // NOI18N
        botonStop.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/iconosPractica10/StopDisabled_48x48.png"))); // NOI18N
        botonStop.addActionListener(formListener);
        getContentPane().add(botonStop);

        pack();
    }

    // Code for dispatching events from components to event handlers.

    private class FormListener implements java.awt.event.ActionListener, javax.swing.event.InternalFrameListener {
        FormListener() {}
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            if (evt.getSource() == botonGrabar) {
                VentanaInternaGrabador.this.botonGrabarActionPerformed(evt);
            }
            else if (evt.getSource() == botonStop) {
                VentanaInternaGrabador.this.botonStopActionPerformed(evt);
            }
        }

        public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
        }

        public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
        }

        public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            if (evt.getSource() == VentanaInternaGrabador.this) {
                VentanaInternaGrabador.this.formInternalFrameClosing(evt);
            }
        }

        public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
        }

        public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
        }

        public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
        }

        public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
        }
    }// </editor-fold>//GEN-END:initComponents
/**
 * Recoge evento para iniciar grabacion
 * @param evt ActionEvent
 */
    private void botonGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGrabarActionPerformed
        if(grabacion!=null) grabacion.record();
        
    }//GEN-LAST:event_botonGrabarActionPerformed
/**
 * Recoge evento para parar la grabacion
 * @param evt ActionEvent
 */
    private void botonStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonStopActionPerformed
       if(grabacion!=null) grabacion.stop();
    }//GEN-LAST:event_botonStopActionPerformed
/**
 * Para la grabacion si se cierra la ventana
 * @param evt InternalFrameEvent
 */
    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
       if(grabacion!=null) this.grabacion.stop();
    }//GEN-LAST:event_formInternalFrameClosing
/**
 * Clase manejadora de eventos, usada para cambiar iconos segun el caso
 * 
 */
class ManejadorAudio implements LineListener {
@Override

public void update(LineEvent event) {
    if (event.getType() == LineEvent.Type.START) {
       // VentanaInternaGrabador.this.botonGrabar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconosPractica10/RecordDisabled_48x48")));
       // VentanaInternaGrabador.this.botonStop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconosPractica10/StopNormalRed_48x48")));
       /* botonGrabar.setEnabled(false);
        botonStop.setEnabled(true);
        if(grabacion!=null) grabacion.record();*/
    }
    if (event.getType() == LineEvent.Type.STOP) {
       
        //VentanaInternaGrabador.this.botonGrabar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconosPractica10/RecordPressed_48x48")));
       // VentanaInternaGrabador.this.botonStop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconosPractica10/StopDisabled_48x48")));
       // botonGrabar.setEnabled(true);
        //botonStop.setEnabled(false); 
        //if(grabacion!=null) grabacion.stop();
        VentanaInternaGrabador.this.botonStop.setSelected(true);
     }
    if (event.getType() == LineEvent.Type.CLOSE) {
       if(grabacion!=null) grabacion.stop();
    }
    if(event.getType() == LineEvent.Type.OPEN){
        //botonGrabar.setEnabled(true);
        //botonStop.setEnabled(false); 
        //botonGrabar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconosPractica10/RecordPressed_48x48")));
       // botonStop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconosPractica10/StopDisabled_48x48")));
    }
}

        
    }

    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton botonGrabar;
    private javax.swing.JToggleButton botonStop;
    private javax.swing.ButtonGroup buttonGroup1;
    // End of variables declaration//GEN-END:variables
}
