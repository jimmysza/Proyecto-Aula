package DashBoard;

import Content.ClientePanel;
import Content.GerentePanel;
import Content.MainPanel;
import Content.PersonalPanel;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Properties;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.ReservacionesModel;

public class DashBoard extends javax.swing.JFrame {

    private final ReservacionesModel modeloReservacion = ReservacionesModel.getInstance();

    ClientePanel panelCliente = new ClientePanel();
    PersonalPanel panelPersonal = new PersonalPanel();
    GerentePanel panelGerente = new GerentePanel();
    MainPanel panelMain = new MainPanel();

    
    private final String barra = File.separator;
    //ubicacion de la carpeta
    private final String ubicacion = System.getProperty("user.dir") + barra + "ListaUsuarios" + barra;
    
    File contenedor = new File(ubicacion);
    
    File[] registros = contenedor.listFiles();

    // importar los paneles, crear objecto, agregar al main, set main.add(panelGerente); panelMain.setVisible(false);
    public DashBoard() {
        initComponents();

        
        panelMain.setPreferredSize(new Dimension(500, 400));
       
        
        main.add(panelMain);
        main.add(panelCliente);
        main.add(panelPersonal);
        main.add(panelGerente);
        
        
        panelMain.setVisible(true);
        panelCliente.setVisible(false);
        panelGerente.setVisible(false);
        panelPersonal.setVisible(false);

        pack();
        setResizable(false);

        this.setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximiza la ventana
        setLocationRelativeTo(null); // Centra la ventana

        //this.setSize(1440, 750);
        ingreso();
    }

    public static int imprimirMenu() {
        String menu = """
                ===Menu Principal===
                1. Registrarse
                2. Iniciar Sesión
                3. Salir
                """;
        // Solicitar opción al usuario y manejar posibles errores
        int opcion = Integer.parseInt(JOptionPane.showInputDialog(null, menu, "Menu", JOptionPane.INFORMATION_MESSAGE));
        return opcion;
    }

    public void ingreso() {
        while (true) {
            try {

                int opcion = imprimirMenu();

                switch (opcion) {
                    case 1 ->
                        registro();
                    case 2 -> {
                        if (iniciarSesion()) {
                            // Si el inicio de sesión es exitoso, el programa sale del bucle y muestra el DashBoard
                            this.setVisible(true); // Muestra el Dashboard actual
                            return;
                        }
                    }
                    case 3 -> {
                        JOptionPane.showMessageDialog(null, "Muchas Gracias por ingresar");
                        System.exit(0);
                        return;
                    }
                    default ->
                        JOptionPane.showMessageDialog(null, "INGRESE UNA OPCIÓN VÁLIDA", "MENSAJE DEL SISTEMA", JOptionPane.ERROR_MESSAGE);
                }
                // Captura de error al introducir un valor no numérico
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Por favor, ingrese un número entero válido.", "Error de entrada", JOptionPane.WARNING_MESSAGE);
                // Captura de cualquier otro error inesperado
            } catch (HeadlessException e) {
                JOptionPane.showMessageDialog(null, "Ocurrió un error inesperado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void registro() {
        String usuario = JOptionPane.showInputDialog(null, "Cree un Usuario: ");
        String contraseña = JOptionPane.showInputDialog(null, "Cree una Contraseña: ");

        crearUsuario(usuario, contraseña);
    }

    private void crearUsuario(String Usuario, String Contraseña) {

        String archivo = Usuario + ".usuario";
        File crear_ubicacion = new File(ubicacion);
        File crear_archivo = new File(ubicacion + archivo);

        // Verificar si el campo ID está vacío
        if (Usuario.equals("")) {
            JOptionPane.showMessageDialog(null, "No hay Usuario");
        } else {
            try {

                if (crear_archivo.exists()) {
                    JOptionPane.showMessageDialog(null, "El Nombre de Usuario ya existe");
                } else {
                    crear_ubicacion.mkdirs(); // Crear la carpeta si no existe
                    // Poner la info dentro del fichero
                    try (Formatter crea = new Formatter(crear_archivo)) { // Usar crear_archivo
                        // Escribir en el archivo
                        crea.format("%s\r\n%s",
                                "Usuario=" + Usuario,
                                "Contrasena=" + Contraseña);
                    }
                    JOptionPane.showMessageDialog(rootPane, "Registro Exitoso");
                }
            } catch (HeadlessException | FileNotFoundException e) { // Mostrar traza del error
                JOptionPane.showMessageDialog(rootPane, "Archivo no se pudo crear");
            }
        }
    }

    public boolean iniciarSesion() {
        
        String usuario = JOptionPane.showInputDialog(null, "Ingrese su Usuario: ");
        String contraseña = JOptionPane.showInputDialog(null, "Ingrese su Contraseña: ");

        modeloReservacion.setLastUsuario(usuario);
                
        File directorioUsuarios = new File(ubicacion);

        // Asegúrate de que la carpeta existe y contiene archivos
        if (!directorioUsuarios.exists() || !directorioUsuarios.isDirectory()) {
            JOptionPane.showMessageDialog(null, "No se encontraron archivos de usuarios.");
            return false;
        }

        // Lista todos los archivos dentro del directorio de usuarios
        File[] registros = directorioUsuarios.listFiles();
        if (registros == null || registros.length == 0) {
            JOptionPane.showMessageDialog(null, "No se encontraron archivos de usuarios.");
            return false;
        }

        // Recorrer los archivos para verificar las credenciales
        for (File archivo : registros) {
            try (FileInputStream fis = new FileInputStream(archivo)) {
                Properties mostrar = new Properties();
                mostrar.load(fis);

                // Verificar si el usuario y la contraseña coinciden
                if (usuario.equals(mostrar.getProperty("Usuario")) && contraseña.equals(mostrar.getProperty("Contrasena"))) {
                    JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso");
                    return true;
                }
            } catch (Exception e) {
            }
        }

        JOptionPane.showMessageDialog(null, "Usuario o Contraseña Incorrectas\n");
        return false; // Retorna false si no coinciden
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashBoard();
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        BotonInicio = new javax.swing.JButton();
        BotonClientes = new javax.swing.JButton();
        BotonPersonal = new javax.swing.JButton();
        BotonGerente = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        BotonSalir = new javax.swing.JButton();
        BotonCambiodeUsuario = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        main = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setMaximumSize(new java.awt.Dimension(150, 768));
        jPanel1.setPreferredSize(new java.awt.Dimension(150, 760));

        BotonInicio.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BotonInicio.setText("Inicio");
        BotonInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonInicioActionPerformed(evt);
            }
        });

        BotonClientes.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BotonClientes.setText("Clientes");
        BotonClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonClientesActionPerformed(evt);
            }
        });

        BotonPersonal.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BotonPersonal.setText("Personal");
        BotonPersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonPersonalActionPerformed(evt);
            }
        });

        BotonGerente.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BotonGerente.setText("Gerente");
        BotonGerente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonGerenteActionPerformed(evt);
            }
        });

        jLabel1.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/img/alex fit.png"))); // NOI18N

        BotonSalir.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BotonSalir.setText("Salir");
        BotonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonSalirActionPerformed(evt);
            }
        });

        BotonCambiodeUsuario.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BotonCambiodeUsuario.setText("Cambiar Usuario");
        BotonCambiodeUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCambiodeUsuarioActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Alex Fit");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BotonInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BotonClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BotonPersonal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BotonGerente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BotonSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BotonCambiodeUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))
                .addGap(13, 13, 13))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addGap(71, 71, 71)
                .addComponent(jLabel3)
                .addGap(45, 45, 45)
                .addComponent(BotonInicio)
                .addGap(18, 18, 18)
                .addComponent(BotonClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BotonPersonal)
                .addGap(18, 18, 18)
                .addComponent(BotonGerente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 346, Short.MAX_VALUE)
                .addComponent(BotonCambiodeUsuario)
                .addGap(18, 18, 18)
                .addComponent(BotonSalir)
                .addGap(27, 27, 27))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.LINE_START);

        main.setMaximumSize(new java.awt.Dimension(1216, 760));
        main.setMinimumSize(new java.awt.Dimension(850, 500));
        main.setPreferredSize(new java.awt.Dimension(1216, 760));
        main.setLayout(new java.awt.CardLayout());
        getContentPane().add(main, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BotonGerenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonGerenteActionPerformed
        
        
        
        if (modeloReservacion.getLastUsuario().equals("jaime")) {
            panelGerente.setVisible(true);
            panelCliente.setVisible(false);
            panelPersonal.setVisible(false);
            panelMain.setVisible(false);
        } else {
            String contraseña = JOptionPane.showInputDialog(null, "Ingrese Contraseña para acceder al Menu del Gerente");
            
            if ("gerenteonly".equals(contraseña)) {
            panelGerente.setVisible(true);
            panelCliente.setVisible(false);
            panelPersonal.setVisible(false);
            panelMain.setVisible(false);
            JOptionPane.showMessageDialog(null, "Bienvenido al Menu Gerente");
        } else {
            JOptionPane.showMessageDialog(null, "Contraseña Incorrecta\n");
        }
            
        }

    }//GEN-LAST:event_BotonGerenteActionPerformed

    private void BotonPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonPersonalActionPerformed
        String contraseña = JOptionPane.showInputDialog(null, "Ingrese Contraseña para acceder al Menu del Personal");

        // Valida la contraseña ingresada
        if ("personalonly".equals(contraseña)) {
            panelPersonal.setVisible(true);
            panelCliente.setVisible(false);
            panelMain.setVisible(false);
            panelGerente.setVisible(false);
            JOptionPane.showMessageDialog(null, "Bienvenido al Menu Personal");
        } else {
            JOptionPane.showMessageDialog(null, "Contraseña Incorrecta\n");
        }


    }//GEN-LAST:event_BotonPersonalActionPerformed

    private void BotonClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonClientesActionPerformed
        panelCliente.setVisible(true);
        panelGerente.setVisible(false);
        panelPersonal.setVisible(false);
        panelMain.setVisible(false);
    }//GEN-LAST:event_BotonClientesActionPerformed

    private void BotonInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonInicioActionPerformed
        panelMain.setVisible(true);
        panelCliente.setVisible(false);
        panelGerente.setVisible(false);
        panelPersonal.setVisible(false);
    }//GEN-LAST:event_BotonInicioActionPerformed

    private void BotonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_BotonSalirActionPerformed

    private void BotonCambiodeUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCambiodeUsuarioActionPerformed
        ingreso();
    }//GEN-LAST:event_BotonCambiodeUsuarioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonCambiodeUsuario;
    private javax.swing.JButton BotonClientes;
    private javax.swing.JButton BotonGerente;
    private javax.swing.JButton BotonInicio;
    private javax.swing.JButton BotonPersonal;
    private javax.swing.JButton BotonSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLayeredPane main;
    // End of variables declaration//GEN-END:variables
}
