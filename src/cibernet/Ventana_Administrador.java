/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cibernet;

import javax.swing.Timer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.*;

public class Ventana_Administrador extends javax.swing.JFrame implements Runnable {

    String hora, minuto, segundos, ampm;
    Calendar calendario;
    Thread h1;
    int cobrar = 15;
    int totpagar = 0;
    int i = 1;
    
    VentantaUsuario US = new VentantaUsuario();
    ConexionDB bd = new ConexionDB();
    Connection con = bd.getConnection();

    String atributo = "ID_Maquina";

    public Ventana_Administrador() {
        initComponents();
        h1 = new Thread(this);
        h1.start();

        setLocationRelativeTo(null);
        setTitle("CiberNET");

        MostrarTabla("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelPrincipal = new javax.swing.JPanel();
        Datos = new javax.swing.JScrollPane();
        tablaha = new javax.swing.JTable();
        btnIniciarCronometro = new javax.swing.JButton();
        btnCobrar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtMaquina = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCopias = new javax.swing.JTextField();
        BarraNavegacion = new javax.swing.JPanel();
        lblReloj = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanelPrincipal.setBackground(new java.awt.Color(153, 153, 255));

        Datos.setBackground(new java.awt.Color(255, 153, 153));
        Datos.setViewportBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tablaha.setBackground(new java.awt.Color(102, 102, 255));
        tablaha.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        Datos.setViewportView(tablaha);

        btnIniciarCronometro.setBackground(new java.awt.Color(51, 51, 255));
        btnIniciarCronometro.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        btnIniciarCronometro.setText("Iniciar");
        btnIniciarCronometro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnIniciarCronometroMouseClicked(evt);
            }
        });
        btnIniciarCronometro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarCronometroActionPerformed(evt);
            }
        });

        btnCobrar.setBackground(new java.awt.Color(51, 51, 255));
        btnCobrar.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        btnCobrar.setText("Cobrar");
        btnCobrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCobrarMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Número de copias:");

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Número de maquina:");

        javax.swing.GroupLayout PanelPrincipalLayout = new javax.swing.GroupLayout(PanelPrincipal);
        PanelPrincipal.setLayout(PanelPrincipalLayout);
        PanelPrincipalLayout.setHorizontalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                .addComponent(Datos, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPrincipalLayout.createSequentialGroup()
                        .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(0, 233, Short.MAX_VALUE))
                    .addGroup(PanelPrincipalLayout.createSequentialGroup()
                        .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtCopias, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnIniciarCronometro)
                                .addGroup(PanelPrincipalLayout.createSequentialGroup()
                                    .addGap(33, 33, 33)
                                    .addComponent(txtMaquina))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCobrar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        PanelPrincipalLayout.setVerticalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Datos, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMaquina, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCopias, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCobrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnIniciarCronometro, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE))
                .addContainerGap())
        );

        BarraNavegacion.setBackground(new java.awt.Color(51, 51, 255));

        lblReloj.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CIBERNET");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout BarraNavegacionLayout = new javax.swing.GroupLayout(BarraNavegacion);
        BarraNavegacion.setLayout(BarraNavegacionLayout);
        BarraNavegacionLayout.setHorizontalGroup(
            BarraNavegacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BarraNavegacionLayout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblReloj, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        BarraNavegacionLayout.setVerticalGroup(
            BarraNavegacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BarraNavegacionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(BarraNavegacionLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(lblReloj, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(BarraNavegacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(BarraNavegacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarCronometroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIniciarCronometroMouseClicked

        try {

            PreparedStatement pps = con.prepareStatement("INSERT INTO CiberNet (Hora_entrada) VALUES (?);");
            pps.setString(1, lblReloj.getText());

            pps.executeUpdate();
            MostrarTabla("");

        } catch (SQLException ex) {
            Logger.getLogger(Ventana_Administrador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        US.setVisible(true);
        US.tiempo.start();
        

    }//GEN-LAST:event_btnIniciarCronometroMouseClicked

    private void btnIniciarCronometroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarCronometroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnIniciarCronometroActionPerformed

    private void btnCobrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCobrarMouseClicked

        PreparedStatement pps;
        int copias = Integer.parseInt(txtCopias.getText());
        
        if(US.minutos >= 15){
            totpagar = totpagar + cobrar;
        }else if(US.minutos >= 30){
            totpagar = totpagar + cobrar * 2;
        }
         
        try {
            
            pps = con.prepareStatement("UPDATE CiberNet SET Hora_salida= '" + lblReloj.getText() + "', Copias= '" + txtCopias.getText() + "', Total='"+ totpagar +"' WHERE ID_Maquina= '" + txtMaquina.getText() + "'");
            pps.executeUpdate();

            MostrarTabla("");

        } catch (SQLException ex) {
            Logger.getLogger(Ventana_Administrador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(US.tiempo.isRunning()){
            US.tiempo.stop();
        }
        US.centecimas_seg = 0;
        US.segundo = 0;
        US.minutos = 0;
        US.horas = 0;
        US.dispose();
        

    }//GEN-LAST:event_btnCobrarMouseClicked

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventana_Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana_Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana_Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana_Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana_Administrador().setVisible(true);
            }
        });
    }

    @Override
    public void run() {
        Thread ct = Thread.currentThread();
        while (ct == h1) {
            calcula();
            lblReloj.setText(hora + ":" + minuto + ":" + segundos + ":" + ampm);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }

        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BarraNavegacion;
    private javax.swing.JScrollPane Datos;
    private javax.swing.JPanel PanelPrincipal;
    private javax.swing.JButton btnCobrar;
    private javax.swing.JButton btnIniciarCronometro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblReloj;
    private javax.swing.JTable tablaha;
    private javax.swing.JTextField txtCopias;
    private javax.swing.JTextField txtMaquina;
    // End of variables declaration//GEN-END:variables

    private void calcula() {
        Calendar calendario = new GregorianCalendar();
        Date fechaHoraActual = new Date();

        calendario.setTime(fechaHoraActual);
        ampm = calendario.get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM";

        if (ampm.equals("PM")) {
            int h = calendario.get(Calendar.HOUR_OF_DAY) - 12;
            hora = h > 9 ? "" + h : "0" + h;
        } else {
            hora = calendario.get(Calendar.HOUR_OF_DAY) > 9 ? "" + calendario.get(Calendar.HOUR_OF_DAY) : "0" + calendario.get(Calendar.HOUR_OF_DAY);
        }
        minuto = calendario.get(Calendar.MINUTE) > 9 ? "" + calendario.get(Calendar.MINUTE) : "0" + calendario.get(Calendar.MINUTE);
        segundos = calendario.get(Calendar.SECOND) > 9 ? "" + calendario.get(Calendar.SECOND) : "0" + calendario.get(Calendar.SECOND);
    }

    private void MostrarTabla(String valor) {
        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("ID_Maquina");
        modelo.addColumn("Hora_entrada");
        modelo.addColumn("Hora_salida");
        modelo.addColumn("Copias");
        modelo.addColumn("Total");
        tablaha.setModel(modelo);

        String sql = "";

        if (valor.equals("")) {
            sql = "SELECT * FROM CiberNet";
        } else {
            sql = "SELECT * FROM CibeNet WHERE " + atributo + "='" + valor + "'";
        }

        String datos[] = new String[10];//En un vector guarda los datos para mostrarlos
        Statement st;
        try {
            st = con.createStatement();//Crea el statements que obtiene el query
            ResultSet rs = st.executeQuery(sql);//El resultado del query lo guarada en una variable

            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);

                modelo.addRow(datos);

            }
            tablaha.setModel(modelo);

        } catch (SQLException ex) {
            Logger.getLogger(Ventana_Administrador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
