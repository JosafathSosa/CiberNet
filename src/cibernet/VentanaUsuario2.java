/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cibernet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author josafathsosajimenez
 */
public class VentanaUsuario2 extends javax.swing.JFrame {
    
    textoTiempo txt = new textoTiempo();

    Timer tiempo;
    int centecimas_seg = 0;
    int segundo = 0;
    int minutos = 0;
    int horas = 0;

    
    public VentanaUsuario2() {
        initComponents();
        tiempo = new Timer(10, acciones);
        setLocationRelativeTo(null);
    }

      private ActionListener acciones = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            sacarTexto();
            centecimas_seg ++;
                if(centecimas_seg == 100){
                    segundo ++;
                    centecimas_seg = 0;
            }
                if(segundo == 60){
                    minutos ++;
                    segundo = 0;
            }
                if(minutos == 60){
                    horas++;
                    minutos = 0;
                    
                }
                actualizarTiempo();
            }
            };

    private void actualizarTiempo() {
        String texto = (horas < 9 ? "0" : "") + horas + ":" + (minutos <= 9 ? "0" : "") + minutos + ":" + (segundo <= 9 ? "0" : "") + segundo + ":" + (centecimas_seg <= 9 ? "0" : "") + centecimas_seg;//Actualiza el tiempo cuando es menor a 9
        cronometro.setText(texto);
    }
    
      private void sacarTexto() {

        lblTiempo.setText(txt.getTexto());
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cronometro = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        noMaquina = new javax.swing.JLabel();
        lblTiempo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setForeground(new java.awt.Color(204, 204, 255));

        cronometro.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        cronometro.setForeground(new java.awt.Color(0, 0, 0));
        cronometro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cronometro.setText("00:00:00:00");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Tiempo transcurrido:");

        noMaquina.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        noMaquina.setForeground(new java.awt.Color(0, 0, 0));
        noMaquina.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        noMaquina.setText("2");

        lblTiempo.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblTiempo.setForeground(new java.awt.Color(0, 0, 0));
        lblTiempo.setText("Tiempo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(cronometro, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                .addGap(70, 70, 70))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(noMaquina, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(noMaquina)
                    .addComponent(lblTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(cronometro)
                .addGap(72, 72, 72))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cronometro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblTiempo;
    private javax.swing.JLabel noMaquina;
    // End of variables declaration//GEN-END:variables
}
