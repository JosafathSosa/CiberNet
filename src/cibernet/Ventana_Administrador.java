package cibernet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.*;

public class Ventana_Administrador extends javax.swing.JFrame implements Runnable {

    //Mando a llamar conexion de base de datos
    ConexionDB bd = new ConexionDB();
    Connection con = bd.getConnection();

    //Variables del reloj local
    String hora, minuto, segundos, ampm;
    Calendar calendario;
    Thread h1;

    double cobrar = 15;

    //Variable que guarda el total de cada maquina
    double totpagar;
    double totpagar2;
    double totpagar3;
    double totpagar4;
    double i = 1;

    double totSemana = 0;
    double totalCopias = 0;

    //Variables para guardar la hora de entrada en distintas computadoras
    String hora_entrada;
    String hora_entrada2;
    String hora_entrada3;
    String hora_entrada4;

    //Variable que guarda el tiempo que el usuario elige para su servicio
    String tiempo;
    String tiempo2;
    String tiempo3;
    String tiempo4;

    //Mando a llamar ventanas emergentes
    Login lg = new Login();
    VentantaUsuario US = new VentantaUsuario();
    VentanaUsuario2 US2 = new VentanaUsuario2();
    VentanaUsuario3 US3 = new VentanaUsuario3();
    VentanaUsuario4 US4 = new VentanaUsuario4();
    Ganancias gan = new Ganancias();

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

        bg = new javax.swing.JPanel();
        BarraNavegacion = new javax.swing.JPanel();
        lblReloj = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        Ganancias = new javax.swing.JButton();
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
        jLabel5 = new javax.swing.JLabel();
        boxTiempo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bg.setBackground(new java.awt.Color(51, 51, 255));

        BarraNavegacion.setBackground(new java.awt.Color(51, 51, 255));

        lblReloj.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N

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

        Ganancias.setBackground(new java.awt.Color(51, 51, 255));
        Ganancias.setText("Mostrar ganancias");
        Ganancias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GananciasMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout BarraNavegacionLayout = new javax.swing.GroupLayout(BarraNavegacion);
        BarraNavegacion.setLayout(BarraNavegacionLayout);
        BarraNavegacionLayout.setHorizontalGroup(
            BarraNavegacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BarraNavegacionLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(BarraNavegacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Ganancias))
                .addGap(166, 166, 166)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
                .addComponent(lblReloj, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        BarraNavegacionLayout.setVerticalGroup(
            BarraNavegacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BarraNavegacionLayout.createSequentialGroup()
                .addGroup(BarraNavegacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BarraNavegacionLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Ganancias)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                    .addGroup(BarraNavegacionLayout.createSequentialGroup()
                        .addContainerGap(50, Short.MAX_VALUE)
                        .addComponent(lblReloj, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BarraNavegacionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelPrincipal.setBackground(new java.awt.Color(153, 153, 255));
        PanelPrincipal.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PanelPrincipal.setMaximumSize(new java.awt.Dimension(773, 408));
        PanelPrincipal.setMinimumSize(new java.awt.Dimension(773, 408));
        PanelPrincipal.setSize(new java.awt.Dimension(773, 408));

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

        txtMaquina.setEditable(false);
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
        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });

        boxMaquinas.setBackground(new java.awt.Color(204, 204, 255));
        boxMaquinas.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        boxMaquinas.setForeground(new java.awt.Color(0, 0, 0));
        boxMaquinas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4" }));

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Tiempo:");

        boxTiempo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10 minutos", "20 minutos", "30 minutos", "1 hora", "Tiempo libre" }));

        javax.swing.GroupLayout PanelPrincipalLayout = new javax.swing.GroupLayout(PanelPrincipal);
        PanelPrincipal.setLayout(PanelPrincipalLayout);
        PanelPrincipalLayout.setHorizontalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                .addComponent(Datos, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPrincipalLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPrincipalLayout.createSequentialGroup()
                                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnIniciarCronometro)
                                    .addGroup(PanelPrincipalLayout.createSequentialGroup()
                                        .addGap(31, 31, 31)
                                        .addComponent(boxMaquinas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtMaquina, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnCobrar, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPrincipalLayout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(43, 43, 43))))
                            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(PanelPrincipalLayout.createSequentialGroup()
                                        .addGap(27, 27, 27)
                                        .addComponent(txtCopias, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22))
                            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addContainerGap())))
                    .addGroup(PanelPrincipalLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(boxTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        PanelPrincipalLayout.setVerticalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Datos, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxMaquinas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaquina, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPrincipalLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCopias, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boxTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnCobrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnIniciarCronometro, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)))
                    .addGroup(PanelPrincipalLayout.createSequentialGroup()
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(PanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(BarraNavegacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                .addGap(0, 122, Short.MAX_VALUE)
                .addComponent(PanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(bgLayout.createSequentialGroup()
                    .addComponent(BarraNavegacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 422, Short.MAX_VALUE)))
        );

        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 530));

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
            JOptionPane.showMessageDialog(null, "La máquina 1 actualmente esta en uso");

        } else if (boxMaquinas.getSelectedItem().toString().equals("1") && boxTiempo.getSelectedItem().toString().equals("Tiempo libre")) {
            try {

                //Coloca el id y la hora de entrada
                PreparedStatement pps = con.prepareStatement("INSERT INTO CiberNet (ID_Maquina, Hora_entrada) VALUES (?,?);");
                pps.setString(1, boxMaquinas.getSelectedItem().toString());//Coloca la maquina del box seleccionado
                pps.setString(2, lblReloj.getText());//Coloca la hora del lbl del reloj

                hora_entrada = lblReloj.getText(); //guardo hora de entrada

                pps.executeUpdate();//Ejecuta el statement y muestra la tabla
                MostrarTabla("");

            } catch (SQLException ex) {
                Logger.getLogger(Ventana_Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }

            US.setVisible(true);//Se abre la ventana y empieza a correr el tiempo
            US.tiempo.start();

        } else if (US2.tiempo.isRunning() && boxMaquinas.getSelectedItem().toString().equals("2")) {
            JOptionPane.showMessageDialog(null, "La máquina 2 actualmente esta en uso");

        } else if (boxMaquinas.getSelectedItem().toString().equals("2") && boxTiempo.getSelectedItem().toString().equals("Tiempo libre")) {
            try {

                PreparedStatement pps = con.prepareStatement("INSERT INTO CiberNet (ID_Maquina, Hora_entrada) VALUES (?,?);");
                pps.setString(1, boxMaquinas.getSelectedItem().toString());
                pps.setString(2, lblReloj.getText());

                hora_entrada2 = lblReloj.getText();

                pps.executeUpdate();
                MostrarTabla("");

            } catch (SQLException ex) {
                Logger.getLogger(Ventana_Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }

            US2.setVisible(true);
            US2.tiempo.start();
        } else if (US3.tiempo.isRunning() && boxMaquinas.getSelectedItem().toString().equals("3")) {
            JOptionPane.showMessageDialog(null, "La máquina 3 actualmente esta en uso");

        } else if (boxMaquinas.getSelectedItem().toString().equals("3") && boxTiempo.getSelectedItem().toString().equals("Tiempo libre")) {
            try {

                PreparedStatement pps = con.prepareStatement("INSERT INTO CiberNet (ID_Maquina, Hora_entrada) VALUES (?,?);");
                pps.setString(1, boxMaquinas.getSelectedItem().toString());
                pps.setString(2, lblReloj.getText());

                hora_entrada3 = lblReloj.getText();

                pps.executeUpdate();
                MostrarTabla("");

            } catch (SQLException ex) {
                Logger.getLogger(Ventana_Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }

            US3.setVisible(true);
            US3.tiempo.start();
        } else if (US4.tiempo.isRunning() && boxMaquinas.getSelectedItem().toString().equals("4")) {
            JOptionPane.showMessageDialog(null, "La áaquina 4 actualmente esta en uso");

        } else if (boxMaquinas.getSelectedItem().toString().equals("4") && boxTiempo.getSelectedItem().toString().equals("Tiempo libre")) {
            try {

                PreparedStatement pps = con.prepareStatement("INSERT INTO CiberNet (ID_Maquina, Hora_entrada) VALUES (?,?);");
                pps.setString(1, boxMaquinas.getSelectedItem().toString());
                pps.setString(2, lblReloj.getText());

                hora_entrada4 = lblReloj.getText();

                pps.executeUpdate();
                MostrarTabla("");

            } catch (SQLException ex) {
                Logger.getLogger(Ventana_Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }

            US4.setVisible(true);
            US4.tiempo.start();
        } else {
            cobrarTiempo();
        }


    }//GEN-LAST:event_btnIniciarCronometroMouseClicked

    //Metodo incluido en el boton de arriba de iniciar
    private void cobrarTiempo() {
        if (boxMaquinas.getSelectedItem().toString().equals("1") && boxTiempo.getSelectedItem().toString().equals("10 minutos")) {
            try {

                //Coloca el id y la hora de entrada
                PreparedStatement pps = con.prepareStatement("INSERT INTO CiberNet (ID_Maquina, Hora_entrada) VALUES (?,?);");
                pps.setString(1, boxMaquinas.getSelectedItem().toString());//Coloca la maquina del box seleccionado
                pps.setString(2, lblReloj.getText());//Coloca la hora del lbl del reloj

                hora_entrada = lblReloj.getText(); //guardo hora de entrada
                tiempo = boxTiempo.getSelectedItem().toString();

                pps.executeUpdate();//Ejecuta el statement y muestra la tabla
                MostrarTabla("");

            } catch (SQLException ex) {
                Logger.getLogger(Ventana_Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }
            //Guardo el valor de texto en una nueva clase en un metodo set
            textoTiempo txt = new textoTiempo();
            txt.setTexto(tiempo);
            

            US.setVisible(true);//Se abre la ventana y empieza a correr el tiempo
            US.tiempo.start();
            
        } else if (boxMaquinas.getSelectedItem().toString().equals("1") && boxTiempo.getSelectedItem().toString().equals("20 minutos")) {
            try {

                //Coloca el id y la hora de entrada
                PreparedStatement pps = con.prepareStatement("INSERT INTO CiberNet (ID_Maquina, Hora_entrada) VALUES (?,?);");
                pps.setString(1, boxMaquinas.getSelectedItem().toString());//Coloca la maquina del box seleccionado
                pps.setString(2, lblReloj.getText());//Coloca la hora del lbl del reloj

                hora_entrada = lblReloj.getText(); //guardo hora de entrada
                tiempo = boxTiempo.getSelectedItem().toString();

                pps.executeUpdate();//Ejecuta el statement y muestra la tabla
                MostrarTabla("");

            } catch (SQLException ex) {
                Logger.getLogger(Ventana_Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }
                        //Guardo el valor de texto en una nueva clase en un metodo set
            textoTiempo txt = new textoTiempo();
            txt.setTexto(tiempo);

            US.setVisible(true);//Se abre la ventana y empieza a correr el tiempo
            US.tiempo.start();
        } else if (boxMaquinas.getSelectedItem().toString().equals("1") && boxTiempo.getSelectedItem().toString().equals("30 minutos")) {
            try {

                //Coloca el id y la hora de entrada
                PreparedStatement pps = con.prepareStatement("INSERT INTO CiberNet (ID_Maquina, Hora_entrada) VALUES (?,?);");
                pps.setString(1, boxMaquinas.getSelectedItem().toString());//Coloca la maquina del box seleccionado
                pps.setString(2, lblReloj.getText());//Coloca la hora del lbl del reloj

                hora_entrada = lblReloj.getText(); //guardo hora de entrada
                tiempo = boxTiempo.getSelectedItem().toString();

                pps.executeUpdate();//Ejecuta el statement y muestra la tabla
                MostrarTabla("");

            } catch (SQLException ex) {
                Logger.getLogger(Ventana_Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }
                        //Guardo el valor de texto en una nueva clase en un metodo set
            textoTiempo txt = new textoTiempo();
            txt.setTexto(tiempo);

            US.setVisible(true);//Se abre la ventana y empieza a correr el tiempo
            US.tiempo.start();
        } else if (boxMaquinas.getSelectedItem().toString().equals("1") && boxTiempo.getSelectedItem().toString().equals("1 hora")) {
            try {

                //Coloca el id y la hora de entrada
                PreparedStatement pps = con.prepareStatement("INSERT INTO CiberNet (ID_Maquina, Hora_entrada) VALUES (?,?);");
                pps.setString(1, boxMaquinas.getSelectedItem().toString());//Coloca la maquina del box seleccionado
                pps.setString(2, lblReloj.getText());//Coloca la hora del lbl del reloj

                hora_entrada = lblReloj.getText(); //guardo hora de entrada
                tiempo = boxTiempo.getSelectedItem().toString();

                pps.executeUpdate();//Ejecuta el statement y muestra la tabla
                MostrarTabla("");

            } catch (SQLException ex) {
                Logger.getLogger(Ventana_Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }
                        //Guardo el valor de texto en una nueva clase en un metodo set
            textoTiempo txt = new textoTiempo();
            txt.setTexto(tiempo);

            US.setVisible(true);//Se abre la ventana y empieza a correr el tiempo
            US.tiempo.start();
        } else if (boxMaquinas.getSelectedItem().toString().equals("2") && boxTiempo.getSelectedItem().toString().equals("10 minutos")) {
            try {

                //Coloca el id y la hora de entrada
                PreparedStatement pps = con.prepareStatement("INSERT INTO CiberNet (ID_Maquina, Hora_entrada) VALUES (?,?);");
                pps.setString(1, boxMaquinas.getSelectedItem().toString());//Coloca la maquina del box seleccionado
                pps.setString(2, lblReloj.getText());//Coloca la hora del lbl del reloj

                hora_entrada2 = lblReloj.getText(); //guardo hora de entrada
                tiempo2 = boxTiempo.getSelectedItem().toString();

                pps.executeUpdate();//Ejecuta el statement y muestra la tabla
                MostrarTabla("");

            } catch (SQLException ex) {
                Logger.getLogger(Ventana_Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }
                        //Guardo el valor de texto en una nueva clase en un metodo set
            textoTiempo txt = new textoTiempo();
            txt.setTexto(tiempo2);

            US2.setVisible(true);//Se abre la ventana y empieza a correr el tiempo
            US2.tiempo.start();
        } else if (boxMaquinas.getSelectedItem().toString().equals("2") && boxTiempo.getSelectedItem().toString().equals("20 minutos")) {
            try {

                //Coloca el id y la hora de entrada
                PreparedStatement pps = con.prepareStatement("INSERT INTO CiberNet (ID_Maquina, Hora_entrada) VALUES (?,?);");
                pps.setString(1, boxMaquinas.getSelectedItem().toString());//Coloca la maquina del box seleccionado
                pps.setString(2, lblReloj.getText());//Coloca la hora del lbl del reloj

                hora_entrada2 = lblReloj.getText(); //guardo hora de entrada
                tiempo2 = boxTiempo.getSelectedItem().toString();

                pps.executeUpdate();//Ejecuta el statement y muestra la tabla
                MostrarTabla("");

            } catch (SQLException ex) {
                Logger.getLogger(Ventana_Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }
                        //Guardo el valor de texto en una nueva clase en un metodo set
            textoTiempo txt = new textoTiempo();
            txt.setTexto(tiempo2);

            US2.setVisible(true);//Se abre la ventana y empieza a correr el tiempo
            US2.tiempo.start();
        } else if (boxMaquinas.getSelectedItem().toString().equals("2") && boxTiempo.getSelectedItem().toString().equals("30 minutos")) {
            try {

                //Coloca el id y la hora de entrada
                PreparedStatement pps = con.prepareStatement("INSERT INTO CiberNet (ID_Maquina, Hora_entrada) VALUES (?,?);");
                pps.setString(1, boxMaquinas.getSelectedItem().toString());//Coloca la maquina del box seleccionado
                pps.setString(2, lblReloj.getText());//Coloca la hora del lbl del reloj

                hora_entrada2 = lblReloj.getText(); //guardo hora de entrada
                tiempo2 = boxTiempo.getSelectedItem().toString();

                pps.executeUpdate();//Ejecuta el statement y muestra la tabla
                MostrarTabla("");

            } catch (SQLException ex) {
                Logger.getLogger(Ventana_Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }
                        //Guardo el valor de texto en una nueva clase en un metodo set
            textoTiempo txt = new textoTiempo();
            txt.setTexto(tiempo2);

            US2.setVisible(true);//Se abre la ventana y empieza a correr el tiempo
            US2.tiempo.start();
        } else if (boxMaquinas.getSelectedItem().toString().equals("2") && boxTiempo.getSelectedItem().toString().equals("1 hora")) {
            try {

                //Coloca el id y la hora de entrada
                PreparedStatement pps = con.prepareStatement("INSERT INTO CiberNet (ID_Maquina, Hora_entrada) VALUES (?,?);");
                pps.setString(1, boxMaquinas.getSelectedItem().toString());//Coloca la maquina del box seleccionado
                pps.setString(2, lblReloj.getText());//Coloca la hora del lbl del reloj

                hora_entrada2 = lblReloj.getText(); //guardo hora de entrada
                tiempo2 = boxTiempo.getSelectedItem().toString();

                pps.executeUpdate();//Ejecuta el statement y muestra la tabla
                MostrarTabla("");

            } catch (SQLException ex) {
                Logger.getLogger(Ventana_Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }
                        //Guardo el valor de texto en una nueva clase en un metodo set
            textoTiempo txt = new textoTiempo();
            txt.setTexto(tiempo2);

            US2.setVisible(true);//Se abre la ventana y empieza a correr el tiempo
            US2.tiempo.start();
        } else if (boxMaquinas.getSelectedItem().toString().equals("3") && boxTiempo.getSelectedItem().toString().equals("10 minutos")) {
            try {

                //Coloca el id y la hora de entrada
                PreparedStatement pps = con.prepareStatement("INSERT INTO CiberNet (ID_Maquina, Hora_entrada) VALUES (?,?);");
                pps.setString(1, boxMaquinas.getSelectedItem().toString());//Coloca la maquina del box seleccionado
                pps.setString(2, lblReloj.getText());//Coloca la hora del lbl del reloj

                hora_entrada3 = lblReloj.getText(); //guardo hora de entrada
                tiempo3 = boxTiempo.getSelectedItem().toString();

                pps.executeUpdate();//Ejecuta el statement y muestra la tabla
                MostrarTabla("");

            } catch (SQLException ex) {
                Logger.getLogger(Ventana_Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }
                        //Guardo el valor de texto en una nueva clase en un metodo set
            textoTiempo txt = new textoTiempo();
            txt.setTexto(tiempo3);

            US3.setVisible(true);//Se abre la ventana y empieza a correr el tiempo
            US3.tiempo.start();
        } else if (boxMaquinas.getSelectedItem().toString().equals("3") && boxTiempo.getSelectedItem().toString().equals("20 minutos")) {
            try {

                //Coloca el id y la hora de entrada
                PreparedStatement pps = con.prepareStatement("INSERT INTO CiberNet (ID_Maquina, Hora_entrada) VALUES (?,?);");
                pps.setString(1, boxMaquinas.getSelectedItem().toString());//Coloca la maquina del box seleccionado
                pps.setString(2, lblReloj.getText());//Coloca la hora del lbl del reloj

                hora_entrada3 = lblReloj.getText(); //guardo hora de entrada
                tiempo3 = boxTiempo.getSelectedItem().toString();

                pps.executeUpdate();//Ejecuta el statement y muestra la tabla
                MostrarTabla("");

            } catch (SQLException ex) {
                Logger.getLogger(Ventana_Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }
                        //Guardo el valor de texto en una nueva clase en un metodo set
            textoTiempo txt = new textoTiempo();
            txt.setTexto(tiempo3);

            US3.setVisible(true);//Se abre la ventana y empieza a correr el tiempo
            US3.tiempo.start();
        } else if (boxMaquinas.getSelectedItem().toString().equals("3") && boxTiempo.getSelectedItem().toString().equals("30 minutos")) {
            try {

                //Coloca el id y la hora de entrada
                PreparedStatement pps = con.prepareStatement("INSERT INTO CiberNet (ID_Maquina, Hora_entrada) VALUES (?,?);");
                pps.setString(1, boxMaquinas.getSelectedItem().toString());//Coloca la maquina del box seleccionado
                pps.setString(2, lblReloj.getText());//Coloca la hora del lbl del reloj

                hora_entrada3 = lblReloj.getText(); //guardo hora de entrada
                tiempo3 = boxTiempo.getSelectedItem().toString();

                pps.executeUpdate();//Ejecuta el statement y muestra la tabla
                MostrarTabla("");

            } catch (SQLException ex) {
                Logger.getLogger(Ventana_Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }
                        //Guardo el valor de texto en una nueva clase en un metodo set
            textoTiempo txt = new textoTiempo();
            txt.setTexto(tiempo3);

            US3.setVisible(true);//Se abre la ventana y empieza a correr el tiempo
            US3.tiempo.start();
        } else if (boxMaquinas.getSelectedItem().toString().equals("3") && boxTiempo.getSelectedItem().toString().equals("1 hora")) {
            try {

                //Coloca el id y la hora de entrada
                PreparedStatement pps = con.prepareStatement("INSERT INTO CiberNet (ID_Maquina, Hora_entrada) VALUES (?,?);");
                pps.setString(1, boxMaquinas.getSelectedItem().toString());//Coloca la maquina del box seleccionado
                pps.setString(2, lblReloj.getText());//Coloca la hora del lbl del reloj

                hora_entrada3 = lblReloj.getText(); //guardo hora de entrada
                tiempo3 = boxTiempo.getSelectedItem().toString();

                pps.executeUpdate();//Ejecuta el statement y muestra la tabla
                MostrarTabla("");

            } catch (SQLException ex) {
                Logger.getLogger(Ventana_Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }
                        //Guardo el valor de texto en una nueva clase en un metodo set
            textoTiempo txt = new textoTiempo();
            txt.setTexto(tiempo3);

            US3.setVisible(true);//Se abre la ventana y empieza a correr el tiempo
            US3.tiempo.start();
        } else if (boxMaquinas.getSelectedItem().toString().equals("4") && boxTiempo.getSelectedItem().toString().equals("10 minutos")) {
            try {

                //Coloca el id y la hora de entrada
                PreparedStatement pps = con.prepareStatement("INSERT INTO CiberNet (ID_Maquina, Hora_entrada) VALUES (?,?);");
                pps.setString(1, boxMaquinas.getSelectedItem().toString());//Coloca la maquina del box seleccionado
                pps.setString(2, lblReloj.getText());//Coloca la hora del lbl del reloj

                hora_entrada4 = lblReloj.getText(); //guardo hora de entrada
                tiempo4 = boxTiempo.getSelectedItem().toString();

                pps.executeUpdate();//Ejecuta el statement y muestra la tabla
                MostrarTabla("");

            } catch (SQLException ex) {
                Logger.getLogger(Ventana_Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }
                        //Guardo el valor de texto en una nueva clase en un metodo set
            textoTiempo txt = new textoTiempo();
            txt.setTexto(tiempo4);

            US4.setVisible(true);//Se abre la ventana y empieza a correr el tiempo
            US4.tiempo.start();
        } else if (boxMaquinas.getSelectedItem().toString().equals("4") && boxTiempo.getSelectedItem().toString().equals("20 minutos")) {
            try {

                //Coloca el id y la hora de entrada
                PreparedStatement pps = con.prepareStatement("INSERT INTO CiberNet (ID_Maquina, Hora_entrada) VALUES (?,?);");
                pps.setString(1, boxMaquinas.getSelectedItem().toString());//Coloca la maquina del box seleccionado
                pps.setString(2, lblReloj.getText());//Coloca la hora del lbl del reloj

                hora_entrada4 = lblReloj.getText(); //guardo hora de entrada
                tiempo4 = boxTiempo.getSelectedItem().toString();

                pps.executeUpdate();//Ejecuta el statement y muestra la tabla
                MostrarTabla("");

            } catch (SQLException ex) {
                Logger.getLogger(Ventana_Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }
                        //Guardo el valor de texto en una nueva clase en un metodo set
            textoTiempo txt = new textoTiempo();
            txt.setTexto(tiempo4);

            US4.setVisible(true);//Se abre la ventana y empieza a correr el tiempo
            US4.tiempo.start();
        } else if (boxMaquinas.getSelectedItem().toString().equals("4") && boxTiempo.getSelectedItem().toString().equals("30 minutos")) {
            try {

                //Coloca el id y la hora de entrada
                PreparedStatement pps = con.prepareStatement("INSERT INTO CiberNet (ID_Maquina, Hora_entrada) VALUES (?,?);");
                pps.setString(1, boxMaquinas.getSelectedItem().toString());//Coloca la maquina del box seleccionado
                pps.setString(2, lblReloj.getText());//Coloca la hora del lbl del reloj

                hora_entrada4 = lblReloj.getText(); //guardo hora de entrada
                tiempo4 = boxTiempo.getSelectedItem().toString();

                pps.executeUpdate();//Ejecuta el statement y muestra la tabla
                MostrarTabla("");

            } catch (SQLException ex) {
                Logger.getLogger(Ventana_Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }
                        //Guardo el valor de texto en una nueva clase en un metodo set
            textoTiempo txt = new textoTiempo();
            txt.setTexto(tiempo4);

            US4.setVisible(true);//Se abre la ventana y empieza a correr el tiempo
            US4.tiempo.start();
        } else if (boxMaquinas.getSelectedItem().toString().equals("4") && boxTiempo.getSelectedItem().toString().equals("1 hora")) {
            try {

                //Coloca el id y la hora de entrada
                PreparedStatement pps = con.prepareStatement("INSERT INTO CiberNet (ID_Maquina, Hora_entrada) VALUES (?,?);");
                pps.setString(1, boxMaquinas.getSelectedItem().toString());//Coloca la maquina del box seleccionado
                pps.setString(2, lblReloj.getText());//Coloca la hora del lbl del reloj

                hora_entrada4 = lblReloj.getText(); //guardo hora de entrada
                tiempo4 = boxTiempo.getSelectedItem().toString();

                pps.executeUpdate();//Ejecuta el statement y muestra la tabla
                MostrarTabla("");

            } catch (SQLException ex) {
                Logger.getLogger(Ventana_Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }
                        //Guardo el valor de texto en una nueva clase en un metodo set
            textoTiempo txt = new textoTiempo();
            txt.setTexto(tiempo4);

            US4.setVisible(true);//Se abre la ventana y empieza a correr el tiempo
            US4.tiempo.start();
        }
    }

    private void btnIniciarCronometroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarCronometroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnIniciarCronometroActionPerformed

    //METODOS PARA COBRAR LA MAQUINA
    public void CobrarMaquina1() {
        double copias = Integer.parseInt(txtCopias.getText()) * .50;

        if (US.minutos <= 30 && US.minutos >= 1) {
            totpagar = totpagar + 5 + copias;
        } else if (US.minutos > 30 && US.minutos <= 60) {
            totpagar += 10 + copias;
        } else if (US.horas >= 1 && US.horas <= 2) {
            totpagar += 20 + copias;
        }
    }

    public void CobrarMaquina2() {
        double copias2 = Integer.parseInt(txtCopias.getText()) * .50;

        if (US2.minutos <= 30 && US2.minutos >= 1) {
            totpagar2 = totpagar2 + 5 + copias2;
        } else if (US2.minutos > 30 && US2.minutos <= 60) {
            totpagar2 += 10 + copias2;
        } else if (US2.horas >= 1 && US2.horas <= 2) {
            totpagar2 += 20 + copias2;
        }
    }

    public void CobrarMaquina3() {
        double copias3 = Integer.parseInt(txtCopias.getText()) * .50;

        if (US3.minutos <= 30 && US3.minutos >= 1) {
            totpagar3 = totpagar3 + 5 + copias3;
        } else if (US3.minutos > 30 && US3.minutos <= 60) {
            totpagar3 += 10 + copias3;
        } else if (US3.horas >= 1 && US3.horas <= 2) {
            totpagar3 += 20 + copias3;
        }
    }

    public void CobrarMaquina4() {
        double copias4 = Integer.parseInt(txtCopias.getText()) * .50;

        if (US4.minutos <= 30 && US4.minutos >= 1) {
            totpagar4 = totpagar4 + 5 + copias4;
        } else if (US4.minutos > 30 && US4.minutos <= 60) {
            totpagar4 += 10 + copias4;
        } else if (US4.horas >= 1 && US4.horas <= 2) {
            totpagar4 += 20 + copias4;
        }
    }

    private void CobrarDiezMinutos() {
        if (US.minutos == 10 && tiempo.equals("10 minutos")) {

            CobrarMaquina1();

            try {

                PreparedStatement pps = con.prepareStatement("UPDATE CiberNet SET Hora_salida= '" + lblReloj.getText() + "', Copias= '" + txtCopias.getText() + " Copias" + "', Total='" + "$" + totpagar + " Pesos" + "' WHERE Hora_entrada= '" + hora_entrada + "'");
                pps.executeUpdate();

                MostrarTabla("");

            } catch (SQLException ex) {
                Logger.getLogger(Ventana_Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }

            txtTotal.setText("$" + totpagar + " pesos ");
            totSemana += totpagar;
            System.out.println(totpagar);

            //Manda y guarda el contenido de la variable totalsemana
            temporal tm = new temporal();
            tm.setTotSemana("" + totSemana);

            US.tiempo.stop();
            US.dispose();

            US.centecimas_seg = 0;
            US.segundo = 0;
            US.minutos = 0;
            US.horas = 0;
            totpagar = 0;

            tiempo = "";
            hora_entrada = "";
        } else if (US2.minutos == 10 && tiempo2.equals("10 minutos")) {
            CobrarMaquina2();
            try {

                PreparedStatement pps = con.prepareStatement("UPDATE CiberNet SET Hora_salida= '" + lblReloj.getText() + "', Copias= '" + txtCopias.getText() + " Copias" + "', Total='" + "$" + totpagar2 + " Pesos" + "' WHERE Hora_entrada= '" + hora_entrada2 + "'");
                pps.executeUpdate();

                MostrarTabla("");

            } catch (SQLException ex) {
                Logger.getLogger(Ventana_Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }

            txtTotal.setText("$" + totpagar2 + " pesos ");
            totSemana += totpagar2;

            //Manda y guarda el contenido de la variable totalsemana
            temporal tm = new temporal();
            tm.setTotSemana("" + totSemana);

            US2.tiempo.stop();
            US2.dispose();

            US2.centecimas_seg = 0;
            US2.segundo = 0;
            US2.minutos = 0;
            US2.horas = 0;
            totpagar2 = 0;

            tiempo2 = "";
            hora_entrada2 = "";
        } else if (US3.minutos == 10 && tiempo3.equals("10 minutos")) {
            CobrarMaquina3();
            try {

                PreparedStatement pps = con.prepareStatement("UPDATE CiberNet SET Hora_salida= '" + lblReloj.getText() + "', Copias= '" + txtCopias.getText() + " Copias" + "', Total='" + "$" + totpagar3 + " Pesos" + "' WHERE Hora_entrada= '" + hora_entrada3 + "'");
                pps.executeUpdate();

                MostrarTabla("");

            } catch (SQLException ex) {
                Logger.getLogger(Ventana_Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }

            txtTotal.setText(totpagar3 + " pesos ");
            totSemana += totpagar3;

            //Manda y guarda el contenido de la variable totalsemana
            temporal tm = new temporal();
            tm.setTotSemana("" + totSemana);

            US3.tiempo.stop();
            US3.dispose();

            US3.centecimas_seg = 0;
            US3.segundo = 0;
            US3.minutos = 0;
            US3.horas = 0;
            totpagar3 = 0;

            tiempo = "";
            hora_entrada3 = "";

        } else if (US4.minutos == 10 && tiempo4.equals("10 minutos")) {
            CobrarMaquina4();
            try {

                PreparedStatement pps = con.prepareStatement("UPDATE CiberNet SET Hora_salida= '" + lblReloj.getText() + "', Copias= '" + txtCopias.getText() + " Copias" + "', Total='" + "$" + totpagar4 + " Pesos" + "' WHERE Hora_entrada= '" + hora_entrada4 + "'");
                pps.executeUpdate();

                MostrarTabla("");

            } catch (SQLException ex) {
                Logger.getLogger(Ventana_Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }

            txtTotal.setText("$" + totpagar4 + " pesos ");
            totSemana += totpagar4;

            //Manda y guarda el contenido de la variable totalsemana
            temporal tm = new temporal();
            tm.setTotSemana("" + totSemana);

            US4.tiempo.stop();
            US4.dispose();

            US4.centecimas_seg = 0;
            US4.segundo = 0;
            US4.minutos = 0;
            US4.horas = 0;
            totpagar4 = 0;

            tiempo4 = "";
            hora_entrada4 = "";
        }
    }

    private void CobrarVeinteMinutos() {
        if (US.minutos == 20 && tiempo.equals("20 minutos")) {
            CobrarMaquina1();
            try {

                PreparedStatement pps = con.prepareStatement("UPDATE CiberNet SET Hora_salida= '" + lblReloj.getText() + "', Copias= '" + txtCopias.getText() + " Copias" + "', Total='" + "$" + totpagar + " Pesos" + "' WHERE Hora_entrada= '" + hora_entrada + "'");
                pps.executeUpdate();

                MostrarTabla("");

            } catch (SQLException ex) {
                Logger.getLogger(Ventana_Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }

            txtTotal.setText("$" + totpagar + " pesos ");
            totSemana += totpagar;

            //Manda y guarda el contenido de la variable totalsemana
            temporal tm = new temporal();
            tm.setTotSemana("" + totSemana);

            US.tiempo.stop();
            US.dispose();

            US.centecimas_seg = 0;
            US.segundo = 0;
            US.minutos = 0;
            US.horas = 0;
            totpagar = 0;

            tiempo = "";
            hora_entrada = "";
        } else if (US2.minutos == 20 && tiempo2.equals("20 minutos")) {
            CobrarMaquina2();
            try {

                PreparedStatement pps = con.prepareStatement("UPDATE CiberNet SET Hora_salida= '" + lblReloj.getText() + "', Copias= '" + txtCopias.getText() + " Copias" + "', Total='" + "$" + totpagar2 + " Pesos" + "' WHERE Hora_entrada= '" + hora_entrada2 + "'");
                pps.executeUpdate();

                MostrarTabla("");

            } catch (SQLException ex) {
                Logger.getLogger(Ventana_Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }

            txtTotal.setText("$" + totpagar2 + " pesos ");
            totSemana += totpagar2;

            //Manda y guarda el contenido de la variable totalsemana
            temporal tm = new temporal();
            tm.setTotSemana("" + totSemana);

            US2.tiempo.stop();
            US2.dispose();

            US2.centecimas_seg = 0;
            US2.segundo = 0;
            US2.minutos = 0;
            US2.horas = 0;
            totpagar2 = 0;

            tiempo2 = "";
            hora_entrada2 = "";
        } else if (US3.minutos == 20 && tiempo3.equals("20 minutos")) {
            CobrarMaquina3();
            try {

                PreparedStatement pps = con.prepareStatement("UPDATE CiberNet SET Hora_salida= '" + lblReloj.getText() + "', Copias= '" + txtCopias.getText() + " Copias" + "', Total='" + "$" + totpagar3 + " Pesos" + "' WHERE Hora_entrada= '" + hora_entrada3 + "'");
                pps.executeUpdate();

                MostrarTabla("");

            } catch (SQLException ex) {
                Logger.getLogger(Ventana_Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }

            txtTotal.setText("$" + totpagar3 + " pesos ");
            totSemana += totpagar3;

            //Manda y guarda el contenido de la variable totalsemana
            temporal tm = new temporal();
            tm.setTotSemana("" + totSemana);

            US3.tiempo.stop();
            US3.dispose();

            US3.centecimas_seg = 0;
            US3.segundo = 0;
            US3.minutos = 0;
            US3.horas = 0;
            totpagar3 = 0;

            tiempo3 = "";
            hora_entrada3 = "";
        } else if (US4.minutos == 20 && tiempo4.equals("20 minutos")) {
            CobrarMaquina4();
            try {

                PreparedStatement pps = con.prepareStatement("UPDATE CiberNet SET Hora_salida= '" + lblReloj.getText() + "', Copias= '" + txtCopias.getText() + " Copias" + "', Total='" + "$" + totpagar4 + " Pesos" + "' WHERE Hora_entrada= '" + hora_entrada4 + "'");
                pps.executeUpdate();

                MostrarTabla("");

            } catch (SQLException ex) {
                Logger.getLogger(Ventana_Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }

            txtTotal.setText("$" + totpagar4 + " pesos ");
            totSemana += totpagar4;

            //Manda y guarda el contenido de la variable totalsemana
            temporal tm = new temporal();
            tm.setTotSemana("" + totSemana);

            US4.tiempo.stop();
            US4.dispose();

            US4.centecimas_seg = 0;
            US4.segundo = 0;
            US4.minutos = 0;
            US4.horas = 0;
            totpagar4 = 0;

            tiempo4 = "";
            hora_entrada4 = "";
        }
    }

    private void CobrarTreintaMinutos() {
        if (US.minutos == 30 && tiempo.equals("30 minutos")) {
            CobrarMaquina1();
            try {

                PreparedStatement pps = con.prepareStatement("UPDATE CiberNet SET Hora_salida= '" + lblReloj.getText() + "', Copias= '" + txtCopias.getText() + " Copias" + "', Total='" + "$" + totpagar + " Pesos" + "' WHERE Hora_entrada= '" + hora_entrada + "'");
                pps.executeUpdate();

                MostrarTabla("");

            } catch (SQLException ex) {
                Logger.getLogger(Ventana_Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }

            txtTotal.setText("$" + totpagar + " pesos ");
            totSemana += totpagar;

            //Manda y guarda el contenido de la variable totalsemana
            temporal tm = new temporal();
            tm.setTotSemana("" + totSemana);

            US.tiempo.stop();
            US.dispose();

            US.centecimas_seg = 0;
            US.segundo = 0;
            US.minutos = 0;
            US.horas = 0;
            totpagar = 0;

            tiempo = "";
            hora_entrada = "";
        } else if (US2.minutos == 30 && tiempo2.equals("30 minutos")) {
            CobrarMaquina2();
            try {

                PreparedStatement pps = con.prepareStatement("UPDATE CiberNet SET Hora_salida= '" + lblReloj.getText() + "', Copias= '" + txtCopias.getText() + " Copias" + "', Total='" + "$" + totpagar2 + " Pesos" + "' WHERE Hora_entrada= '" + hora_entrada2 + "'");
                pps.executeUpdate();

                MostrarTabla("");

            } catch (SQLException ex) {
                Logger.getLogger(Ventana_Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }

            txtTotal.setText("$" + totpagar2 + " pesos ");
            totSemana += totpagar2;

            //Manda y guarda el contenido de la variable totalsemana
            temporal tm = new temporal();
            tm.setTotSemana("" + totSemana);

            US2.tiempo.stop();
            US2.dispose();

            US2.centecimas_seg = 0;
            US2.segundo = 0;
            US2.minutos = 0;
            US2.horas = 0;
            totpagar2 = 0;

            tiempo2 = "";
            hora_entrada2 = "";
        } else if (US3.minutos == 30 && tiempo3.equals("30 minutos")) {
            CobrarMaquina3();
            try {

                PreparedStatement pps = con.prepareStatement("UPDATE CiberNet SET Hora_salida= '" + lblReloj.getText() + "', Copias= '" + txtCopias.getText() + " Copias" + "', Total='" + "$" + totpagar3 + " Pesos" + "' WHERE Hora_entrada= '" + hora_entrada3 + "'");
                pps.executeUpdate();

                MostrarTabla("");

            } catch (SQLException ex) {
                Logger.getLogger(Ventana_Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }

            txtTotal.setText("$" + totpagar3 + " pesos ");
            totSemana += totpagar3;

            //Manda y guarda el contenido de la variable totalsemana
            temporal tm = new temporal();
            tm.setTotSemana("" + totSemana);

            US3.tiempo.stop();
            US3.dispose();

            US3.centecimas_seg = 0;
            US3.segundo = 0;
            US3.minutos = 0;
            US3.horas = 0;
            totpagar3 = 0;

            tiempo3 = "";
            hora_entrada3 = "";
        } else if (US4.minutos == 30 && tiempo4.equals("30 minutos")) {
            CobrarMaquina4();
            try {

                PreparedStatement pps = con.prepareStatement("UPDATE CiberNet SET Hora_salida= '" + lblReloj.getText() + "', Copias= '" + txtCopias.getText() + " Copias" + "', Total='" + "$" + totpagar4 + " Pesos" + "' WHERE Hora_entrada= '" + hora_entrada4 + "'");
                pps.executeUpdate();

                MostrarTabla("");

            } catch (SQLException ex) {
                Logger.getLogger(Ventana_Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }

            txtTotal.setText("$" + totpagar4 + " pesos ");
            totSemana += totpagar4;

            //Manda y guarda el contenido de la variable totalsemana
            temporal tm = new temporal();
            tm.setTotSemana("" + totSemana);

            US4.tiempo.stop();
            US4.dispose();

            US4.centecimas_seg = 0;
            US4.segundo = 0;
            US4.minutos = 0;
            US4.horas = 0;
            totpagar4 = 0;

            tiempo4 = "";
            hora_entrada4 = "";
        }
    }

    private void CobrarHora() {
        if (US.horas == 1 && tiempo.equals("1 hora")) {
            CobrarMaquina1();
            try {

                PreparedStatement pps = con.prepareStatement("UPDATE CiberNet SET Hora_salida= '" + lblReloj.getText() + "', Copias= '" + txtCopias.getText() + " Copias" + "', Total='" + "$" + totpagar + " Pesos" + "' WHERE Hora_entrada= '" + hora_entrada + "'");
                pps.executeUpdate();

                MostrarTabla("");

            } catch (SQLException ex) {
                Logger.getLogger(Ventana_Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }

            txtTotal.setText("$" + totpagar + " pesos ");
            totSemana += totpagar;

            //Manda y guarda el contenido de la variable totalsemana
            temporal tm = new temporal();
            tm.setTotSemana("" + totSemana);

            US.tiempo.stop();
            US.dispose();

            US.centecimas_seg = 0;
            US.segundo = 0;
            US.minutos = 0;
            US.horas = 0;
            totpagar = 0;

            hora_entrada = "";
        } else if (US2.horas == 1 && tiempo2.equals("1 hora")) {
            CobrarMaquina2();
            try {

                PreparedStatement pps = con.prepareStatement("UPDATE CiberNet SET Hora_salida= '" + lblReloj.getText() + "', Copias= '" + txtCopias.getText() + " Copias" + "', Total='" + "$" + totpagar2 + " Pesos" + "' WHERE Hora_entrada= '" + hora_entrada2 + "'");
                pps.executeUpdate();

                MostrarTabla("");

            } catch (SQLException ex) {
                Logger.getLogger(Ventana_Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }

            txtTotal.setText("$" + totpagar2 + " pesos ");
            totSemana += totpagar2;

            //Manda y guarda el contenido de la variable totalsemana
            temporal tm = new temporal();
            tm.setTotSemana("" + totSemana);

            US2.tiempo.stop();
            US2.dispose();

            US2.centecimas_seg = 0;
            US2.segundo = 0;
            US2.minutos = 0;
            US2.horas = 0;
            totpagar2 = 0;

            hora_entrada2 = "";
        } else if (US3.horas == 1 && tiempo3.equals("1 hora")) {
            CobrarMaquina3();
            try {

                PreparedStatement pps = con.prepareStatement("UPDATE CiberNet SET Hora_salida= '" + lblReloj.getText() + "', Copias= '" + txtCopias.getText() + " Copias" + "', Total='" + "$" + totpagar3 + " Pesos" + "' WHERE Hora_entrada= '" + hora_entrada3 + "'");
                pps.executeUpdate();

                MostrarTabla("");

            } catch (SQLException ex) {
                Logger.getLogger(Ventana_Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }

            txtTotal.setText("$" + totpagar3 + " pesos ");
            totSemana += totpagar3;

            //Manda y guarda el contenido de la variable totalsemana
            temporal tm = new temporal();
            tm.setTotSemana("" + totSemana);

            US3.tiempo.stop();
            US3.dispose();

            US3.centecimas_seg = 0;
            US3.segundo = 0;
            US3.minutos = 0;
            US3.horas = 0;
            totpagar3 = 0;

            hora_entrada3 = "";
        } else if (US4.horas == 1 && tiempo4.equals("1 hora")) {
            CobrarMaquina4();
            try {

                PreparedStatement pps = con.prepareStatement("UPDATE CiberNet SET Hora_salida= '" + lblReloj.getText() + "', Copias= '" + txtCopias.getText() + " Copias" + "', Total='" + "$" + totpagar4 + " Pesos" + "' WHERE Hora_entrada= '" + hora_entrada4 + "'");
                pps.executeUpdate();

                MostrarTabla("");

            } catch (SQLException ex) {
                Logger.getLogger(Ventana_Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }

            txtTotal.setText("$" + totpagar4 + " pesos ");
            totSemana += totpagar4;

            //Manda y guarda el contenido de la variable totalsemana
            temporal tm = new temporal();
            tm.setTotSemana("" + totSemana);

            US4.tiempo.stop();
            US4.dispose();

            US4.centecimas_seg = 0;
            US4.segundo = 0;
            US4.minutos = 0;
            US4.horas = 0;
            totpagar4 = 0;

            hora_entrada4 = "";
        }
    }

    //USO DE ESTE BOTON SOBRE TODO PARA COPIAS Y CUANDO EL TIEMPO ES LIBRE
    private void btnCobrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCobrarMouseClicked

        PreparedStatement pps;

        //Condiciones para ver cual maquina cobrar, cerrar y guardar datos
        if (US.tiempo.isRunning() && boxMaquinas.getSelectedItem().toString().equals("1")) {

            CobrarMaquina1();
            try {

                pps = con.prepareStatement("UPDATE CiberNet SET Hora_salida= '" + lblReloj.getText() + "', Copias= '" + txtCopias.getText() + " Copias" + "', Total='" + "$" + totpagar + " Pesos" + "' WHERE Hora_entrada= '" + hora_entrada + "'");
                pps.executeUpdate();

                MostrarTabla("");

            } catch (SQLException ex) {
                Logger.getLogger(Ventana_Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }

            txtTotal.setText("$" + totpagar + " pesos ");
            totSemana += totpagar;

            //Manda y guarda el contenido de la variable totalsemana
            temporal tm = new temporal();
            tm.setTotSemana("" + totSemana);

            US.tiempo.stop();
            US.dispose();

            US.centecimas_seg = 0;
            US.segundo = 0;
            US.minutos = 0;
            US.horas = 0;
            totpagar = 0;

            hora_entrada = "";

        } else if (US2.tiempo.isRunning() && boxMaquinas.getSelectedItem().toString().equals("2")) {
            CobrarMaquina2();
            try {

                pps = con.prepareStatement("UPDATE CiberNet SET Hora_salida= '" + lblReloj.getText() + "', Copias= '" + txtCopias.getText() + " Copias" + "', Total='" + "$" + totpagar2 + " Pesos" + "' WHERE Hora_entrada= '" + hora_entrada2 + "'");
                pps.executeUpdate();

                MostrarTabla("");

            } catch (SQLException ex) {
                Logger.getLogger(Ventana_Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }

            txtTotal.setText(totpagar2 + " pesos ");
            totSemana += totpagar2;

            //Manda y guarda el contenido de la variable totalsemana
            temporal tm = new temporal();
            tm.setTotSemana("" + totSemana);

            US2.tiempo.stop();
            US2.dispose();

            US2.centecimas_seg = 0;
            US2.segundo = 0;
            US2.minutos = 0;
            US2.horas = 0;
            totpagar2 = 0;
            hora_entrada2 = "";

        } else if (US3.tiempo.isRunning() && boxMaquinas.getSelectedItem().toString().equals("3")) {
            CobrarMaquina3();
            try {

                pps = con.prepareStatement("UPDATE CiberNet SET Hora_salida= '" + lblReloj.getText() + "', Copias= '" + txtCopias.getText() + " Copias" + "', Total='" + "$" + totpagar3 + " Pesos" + "' WHERE Hora_entrada= '" + hora_entrada3 + "'");
                pps.executeUpdate();

                MostrarTabla("");

            } catch (SQLException ex) {
                Logger.getLogger(Ventana_Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }

            txtTotal.setText(totpagar3 + " pesos ");
            totSemana += totpagar3;

            //Manda y guarda el contenido de la variable totalsemana
            temporal tm = new temporal();
            tm.setTotSemana("" + totSemana);

            US3.tiempo.stop();
            US3.dispose();

            US3.centecimas_seg = 0;
            US3.segundo = 0;
            US3.minutos = 0;
            US3.horas = 0;
            totpagar3 = 0;
            hora_entrada3 = "";

        } else if (US4.tiempo.isRunning() && boxMaquinas.getSelectedItem().toString().equals("4")) {
            CobrarMaquina4();
            try {

                pps = con.prepareStatement("UPDATE CiberNet SET Hora_salida= '" + lblReloj.getText() + "', Copias= '" + txtCopias.getText() + " Copias" + "', Total='" + "$" + totpagar4 + " Pesos" + "' WHERE Hora_entrada= '" + hora_entrada4 + "'");
                pps.executeUpdate();

                MostrarTabla("");

            } catch (SQLException ex) {
                Logger.getLogger(Ventana_Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }

            txtTotal.setText(totpagar4 + " pesos ");
            totSemana += totpagar4;

            //Manda y guarda el contenido de la variable totalsemana
            temporal tm = new temporal();
            tm.setTotSemana("" + totSemana);

            US4.tiempo.stop();
            US4.dispose();

            US4.centecimas_seg = 0;
            US4.segundo = 0;
            US4.minutos = 0;
            US4.horas = 0;
            totpagar4 = 0;
            hora_entrada4 = "";

        } else if (!US.tiempo.isRunning() && !US2.tiempo.isRunning() && !US3.tiempo.isRunning() && !US4.tiempo.isRunning() && Integer.parseInt(txtCopias.getText()) > 0) {
            int copias = Integer.parseInt(txtCopias.getText());
            totalCopias = copias * .5;

            try {

                pps = con.prepareStatement("INSERT INTO CiberNet (ID_Maquina, Copias, Total) VALUES (?,?,?);");
                pps.setString(1, boxMaquinas.getSelectedItem().toString());
                pps.setString(2, "" + copias + " Copias");
                pps.setString(3, "$" + totalCopias + " Pesos");

                pps.executeUpdate();
                MostrarTabla("");

            } catch (SQLException ex) {
                Logger.getLogger(Ventana_Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Selecciona la máquina y/o copias a cobrar correctamente");
        }


    }//GEN-LAST:event_btnCobrarMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        this.dispose();
        lg.setVisible(true);
    }//GEN-LAST:event_jButton1MouseClicked

    private void GananciasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GananciasMouseClicked
        Ganancias gan = new Ganancias();

        gan.setVisible(true);

    }//GEN-LAST:event_GananciasMouseClicked

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed

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

    //thread o hilos es un metodo de java que actua en vivo, aqui se maneja la hora local en tiempo real, y ademas se maneja...
    //el cobro por tiempo
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
            CobrarDiezMinutos();
            CobrarVeinteMinutos();
            CobrarTreintaMinutos();
            CobrarHora();
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BarraNavegacion;
    private javax.swing.JScrollPane Datos;
    private javax.swing.JButton Ganancias;
    private javax.swing.JPanel PanelPrincipal;
    private javax.swing.JPanel bg;
    private javax.swing.JComboBox<String> boxMaquinas;
    private javax.swing.JComboBox<String> boxTiempo;
    private javax.swing.JButton btnCobrar;
    private javax.swing.JButton btnIniciarCronometro;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
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
