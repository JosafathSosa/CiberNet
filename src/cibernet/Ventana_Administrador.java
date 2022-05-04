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

    //Mando a llamar ventanas emergentes
    Login lg = new Login();
    VentantaUsuario US = new VentantaUsuario();
    VentanaUsuario2 US2 = new VentanaUsuario2();
    VentanaUsuario3 US3 = new VentanaUsuario3();
    VentanaUsuario4 US4 = new VentanaUsuario4();

    //Mando a llamar conexion de base de datos
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
        jLabel4 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        boxMaquinas = new javax.swing.JComboBox<>();
        BarraNavegacion = new javax.swing.JPanel();
        lblReloj = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

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

        btnIniciarCronometro.setBackground(new java.awt.Color(153, 153, 255));
        btnIniciarCronometro.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        btnIniciarCronometro.setText("Iniciar");
        btnIniciarCronometro.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
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

        btnCobrar.setBackground(new java.awt.Color(153, 153, 255));
        btnCobrar.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        btnCobrar.setText("Cobrar");
        btnCobrar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnCobrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCobrarMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Número de copias:");

        txtMaquina.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Número de maquina:");

        txtCopias.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCopias.setText("0");

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Total:");

        txtTotal.setEditable(false);

        boxMaquinas.setBackground(new java.awt.Color(204, 204, 255));
        boxMaquinas.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        boxMaquinas.setForeground(new java.awt.Color(0, 0, 0));
        boxMaquinas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4" }));

        javax.swing.GroupLayout PanelPrincipalLayout = new javax.swing.GroupLayout(PanelPrincipal);
        PanelPrincipal.setLayout(PanelPrincipalLayout);
        PanelPrincipalLayout.setHorizontalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                .addComponent(Datos, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPrincipalLayout.createSequentialGroup()
                        .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                                .addComponent(btnIniciarCronometro)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCobrar))
                            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(boxMaquinas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtMaquina, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(PanelPrincipalLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(txtCopias, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        PanelPrincipalLayout.setVerticalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Datos, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(boxMaquinas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtMaquina, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
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
        jLabel1.setIcon(new javax.swing.ImageIcon("/Users/josafathsosajimenez/Pictures/Netbeans/Ciber.png")); // NOI18N
        jLabel1.setText("CIBERNET");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jButton1.setBackground(new java.awt.Color(51, 51, 255));
        jButton1.setFont(new java.awt.Font("Arial Rounded MT Bold", 3, 11)); // NOI18N
        jButton1.setText("Cerrar Sesion");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout BarraNavegacionLayout = new javax.swing.GroupLayout(BarraNavegacion);
        BarraNavegacion.setLayout(BarraNavegacionLayout);
        BarraNavegacionLayout.setHorizontalGroup(
            BarraNavegacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BarraNavegacionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 382, Short.MAX_VALUE)
                .addComponent(lblReloj, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        BarraNavegacionLayout.setVerticalGroup(
            BarraNavegacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BarraNavegacionLayout.createSequentialGroup()
                .addGroup(BarraNavegacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(BarraNavegacionLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, BarraNavegacionLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, BarraNavegacionLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(lblReloj, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
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

        txtTotal.setText("");
        txtMaquina.setText("");
        txtCopias.setText("0");

        String num;
        num = boxMaquinas.getSelectedItem().toString();
        txtMaquina.setText(num);

        //Validacion de si una maquina ya esta en uso
        if (US.tiempo.isRunning() && boxMaquinas.getSelectedItem().toString().equals("1")) {
            JOptionPane.showMessageDialog(null, "La maquina 1 actualmente esta en uso");

        } else if (boxMaquinas.getSelectedItem().toString().equals("1")) {
            try {
                
                //Coloca el id y la hora de entrada
                PreparedStatement pps = con.prepareStatement("INSERT INTO CiberNet (ID_Maquina, Hora_entrada) VALUES (?,?);");
                pps.setString(1, boxMaquinas.getSelectedItem().toString());//Coloca la maquina del box seleccionado
                pps.setString(2, lblReloj.getText());//Coloca la hora del lbl del reloj

                pps.executeUpdate();//Ejecuta el statement y muestra la tabla
                MostrarTabla("");

            } catch (SQLException ex) {
                Logger.getLogger(Ventana_Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }

            US.setVisible(true);//Se abre la ventana y empieza a correr el tiempo
            US.tiempo.start();

        } else if (US2.tiempo.isRunning() && boxMaquinas.getSelectedItem().toString().equals("2")) {
            JOptionPane.showMessageDialog(null, "La maquina 2 actualmente esta en uso");

        } else if (boxMaquinas.getSelectedItem().toString().equals("2")) {
            try {

                PreparedStatement pps = con.prepareStatement("INSERT INTO CiberNet (ID_Maquina, Hora_entrada) VALUES (?,?);");
                pps.setString(1, boxMaquinas.getSelectedItem().toString());
                pps.setString(2, lblReloj.getText());

                pps.executeUpdate();
                MostrarTabla("");

            } catch (SQLException ex) {
                Logger.getLogger(Ventana_Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }

            US2.setVisible(true);
            US2.tiempo.start();
        } else if (US3.tiempo.isRunning() && boxMaquinas.getSelectedItem().toString().equals("3")) {
            JOptionPane.showMessageDialog(null, "La maquina 3 actualmente esta en uso");

        } else if (boxMaquinas.getSelectedItem().toString().equals("3")) {
            try {

                PreparedStatement pps = con.prepareStatement("INSERT INTO CiberNet (ID_Maquina, Hora_entrada) VALUES (?,?);");
                pps.setString(1, boxMaquinas.getSelectedItem().toString());
                pps.setString(2, lblReloj.getText());

                pps.executeUpdate();
                MostrarTabla("");

            } catch (SQLException ex) {
                Logger.getLogger(Ventana_Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }

            US3.setVisible(true);
            US3.tiempo.start();
        } else if (US4.tiempo.isRunning() && boxMaquinas.getSelectedItem().toString().equals("4")) {
            JOptionPane.showMessageDialog(null, "La maquina 4 actualmente esta en uso");

        } else if (boxMaquinas.getSelectedItem().toString().equals("4")) {
            try {

                PreparedStatement pps = con.prepareStatement("INSERT INTO CiberNet (ID_Maquina, Hora_entrada) VALUES (?,?);");
                pps.setString(1, boxMaquinas.getSelectedItem().toString());
                pps.setString(2, lblReloj.getText());

                pps.executeUpdate();
                MostrarTabla("");

            } catch (SQLException ex) {
                Logger.getLogger(Ventana_Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }

            US4.setVisible(true);
            US4.tiempo.start();
        }


    }//GEN-LAST:event_btnIniciarCronometroMouseClicked

    private void btnIniciarCronometroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarCronometroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnIniciarCronometroActionPerformed

    private void btnCobrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCobrarMouseClicked

        int fila = tablaha.getSelectedRow();

        //     txtMaquina.setText(tablaha.getValueAt(fila, 0).toString());
        PreparedStatement pps;

        //Condiciones para cobrar
        int copias = Integer.parseInt(txtCopias.getText());

        if (US.minutos <= 10 && US.segundo >= 1) {
            totpagar = totpagar + 5 + copias;
        } else if (US.minutos > 10 && US.minutos <= 30) {
            totpagar += 15 + copias;
        }

        //Condiciones para ver cual maquina cobrar, cerrar y guardar datos
        if (US.tiempo.isRunning() && boxMaquinas.getSelectedItem().toString().equals("1")) {
            try {

                pps = con.prepareStatement("UPDATE CiberNet SET ID_Maquina= '" + boxMaquinas.getSelectedItem().toString() + "', Hora_salida= '" + lblReloj.getText() + "', Copias= '" + txtCopias.getText() + " Copias" + "', Total='" + "$" + totpagar + " Pesos" + "' WHERE ID_Maquina= '" + boxMaquinas.getSelectedItem().toString() + "'");
                pps.executeUpdate();

                MostrarTabla("");

            } catch (SQLException ex) {
                Logger.getLogger(Ventana_Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }

            txtTotal.setText("" + totpagar);

            US.tiempo.stop();
            US.dispose();

            US.centecimas_seg = 0;
            US.segundo = 0;
            US.minutos = 0;
            US.horas = 0;
            totpagar = 0;
        } else if (US2.tiempo.isRunning() && boxMaquinas.getSelectedItem().toString().equals("2")) {
            try {

                pps = con.prepareStatement("UPDATE CiberNet SET ID_Maquina= '" + boxMaquinas.getSelectedItem().toString() + "', Hora_salida= '" + lblReloj.getText() + "', Copias= '" + txtCopias.getText() + " Copias" + "', Total='" + "$" + totpagar + " Pesos" + "' WHERE ID_Maquina= '" + boxMaquinas.getSelectedItem().toString() + "'");
                pps.executeUpdate();

                MostrarTabla("");

            } catch (SQLException ex) {
                Logger.getLogger(Ventana_Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }

            txtTotal.setText("" + totpagar);

            US2.tiempo.stop();
            US2.dispose();

            US2.centecimas_seg = 0;
            US2.segundo = 0;
            US2.minutos = 0;
            US2.horas = 0;
            totpagar = 0;
        } else if (US3.tiempo.isRunning() && boxMaquinas.getSelectedItem().toString().equals("3")) {
            try {

                pps = con.prepareStatement("UPDATE CiberNet SET ID_Maquina= '" + boxMaquinas.getSelectedItem().toString() + "', Hora_salida= '" + lblReloj.getText() + "', Copias= '" + txtCopias.getText() + " Copias" + "', Total='" + "$" + totpagar + " Pesos" + "' WHERE ID_Maquina= '" + boxMaquinas.getSelectedItem().toString() + "'");
                pps.executeUpdate();

                MostrarTabla("");

            } catch (SQLException ex) {
                Logger.getLogger(Ventana_Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }

            txtTotal.setText("" + totpagar);

            US3.tiempo.stop();
            US3.dispose();

            US3.centecimas_seg = 0;
            US3.segundo = 0;
            US3.minutos = 0;
            US3.horas = 0;
            totpagar = 0;
        } else if (US4.tiempo.isRunning() && boxMaquinas.getSelectedItem().toString().equals("4")) {
            try {

                pps = con.prepareStatement("UPDATE CiberNet SET ID_Maquina= '" + boxMaquinas.getSelectedItem().toString() + "', Hora_salida= '" + lblReloj.getText() + "', Copias= '" + txtCopias.getText() + " Copias" + "', Total='" + "$" + totpagar + " Pesos" + "' WHERE ID_Maquina= '" + boxMaquinas.getSelectedItem().toString() + "'");
                pps.executeUpdate();

                MostrarTabla("");

            } catch (SQLException ex) {
                Logger.getLogger(Ventana_Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }

            txtTotal.setText("" + totpagar);

            US4.tiempo.stop();
            US4.dispose();

            US4.centecimas_seg = 0;
            US4.segundo = 0;
            US4.minutos = 0;
            US4.horas = 0;
            totpagar = 0;
        } else {
            JOptionPane.showMessageDialog(null, "Selecciona la maquina a cobrar correctamente");
        }


    }//GEN-LAST:event_btnCobrarMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        this.dispose();
        lg.setVisible(true);
    }//GEN-LAST:event_jButton1MouseClicked

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
    private javax.swing.JComboBox<String> boxMaquinas;
    private javax.swing.JButton btnCobrar;
    private javax.swing.JButton btnIniciarCronometro;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblReloj;
    private javax.swing.JTable tablaha;
    private javax.swing.JTextField txtCopias;
    private javax.swing.JTextField txtMaquina;
    private javax.swing.JTextField txtTotal;
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
