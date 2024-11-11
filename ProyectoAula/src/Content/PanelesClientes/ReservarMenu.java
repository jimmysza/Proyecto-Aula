package Content.PanelesClientes;

import Content.PanelesGerente.DisponibilidadMesas;
import interfaces.CrudInterfaces;
import java.io.File;
import javax.swing.JOptionPane;
import java.util.Random;
import java.awt.HeadlessException;
import java.io.FileNotFoundException;
import java.util.Formatter;
import javax.swing.JPanel;
import model.ReservacionesModel;

public class ReservarMenu extends JPanel implements CrudInterfaces {

    private ReservacionesModel modeloReservacion = ReservacionesModel.getInstance();

    private final String barra = File.separator;
    private final String ubicacion = System.getProperty("user.dir") + barra + "ReservasMesas" + barra;
    private final String ubicacion_contador = System.getProperty("user.dir") + barra + "ContadorMesas" + barra;
    private final File contenedor;
    Random random = new Random();

    private final int NumeroTotalMesas = 10;
    private final int MesasOcupadas;
    private int MesasDisponibles;

    public ReservarMenu() {
        initComponents();

        // Inicializar el contenedor y crear el directorio si no existe
        contenedor = new File(ubicacion_contador);
        if (!contenedor.exists()) {
            contenedor.mkdirs();
        }

        // Inicializar las variables después de asegurar que el directorio existe
        this.MesasOcupadas = contarArchivosEnContenedor();
        this.MesasDisponibles = NumeroTotalMesas;
        this.MesasDisponibles = MesasDisponibles - MesasOcupadas;
    }

    private int contarArchivosEnContenedor() {
        if (!contenedor.exists() || !contenedor.isDirectory()) {
            System.out.println("La ubicación no existe o no es un directorio.");
            return 0;
        }

        File[] registros = contenedor.listFiles();
        if (registros == null) {
            System.out.println("Error al listar archivos del directorio");
            return 0;
        }

        
        return registros.length;
    }

    private void CreandoFicheroContadorMesas(int CantidadDeMesas) {
        File crear_ubicacion = new File(ubicacion_contador);

        // Crear el directorio si no existe
        if (!crear_ubicacion.exists()) {
            crear_ubicacion.mkdirs();
        }
        int numeroMesaRandom = random.nextInt(100) + 1;

        // Crear archivos numerados del 1 hasta CantidadDeMesas
        for (int i = 1; i <= CantidadDeMesas; i++) {
            String archivo_contador = "mesas_" + i + "." + i * numeroMesaRandom + ".registro";
            File crear_archivo = new File(ubicacion_contador + barra + archivo_contador);

            try (Formatter crea = new Formatter(crear_archivo)) {
                crea.format("%s\r\n", "MESA = " + i);
            } catch (HeadlessException | FileNotFoundException e) {
                System.out.println("Error al crear el archivo " + archivo_contador + ": " + e.getMessage());
            }
        }
    }

    public void validarHoraDeLlegada() {
        try {
            int horaLlegada = Integer.parseInt(jTextField2.getText());

            if (horaLlegada >= 5 && horaLlegada < 12) {
                validarCantidadPersonas();
            } else {
                JOptionPane.showMessageDialog(null, "El restaurante no se encuentra abierto\n");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, ingresa una hora válida.\n");
        }
    }

    public void validarCantidadPersonas() {

        try {
            int numeroPersonasReservar = Integer.parseInt(jTextField3.getText());

            if (numeroPersonasReservar <= 0) {
                JOptionPane.showMessageDialog(null, "Ingresaste una opción incorrecta\n");
            } else if (numeroPersonasReservar > 40) {
                JOptionPane.showMessageDialog(null, "El número de personas excede el aforo del restaurante\n");
            } else if (numeroPersonasReservar == 1) {
                JOptionPane.showMessageDialog(null, "No es necesario realizar una reservación\n");
            } else if (numeroPersonasReservar > 1 && numeroPersonasReservar <= 4) {
                if (MesasDisponibles == 0) {
                    MesasNoDisponibles();
                } else {
                    reservacion(numeroPersonasReservar, 1);
                    crear(1, 0);
                    CreandoFicheroContadorMesas(1);
                    actualizarMesas(1);
                }
            } else if (numeroPersonasReservar > 4) {

                int MesaAOcupar = numeroPersonasReservar / 4;

                int resto = (numeroPersonasReservar % 4);

                if (MesasDisponibles == 0) {
                    MesasNoDisponibles();
                } else if (MesaAOcupar <= MesasDisponibles) {

                    crear(MesaAOcupar, resto);
                    CreandoFicheroContadorMesas(MesaAOcupar);
                    reservacion(numeroPersonasReservar, MesaAOcupar);
                    actualizarMesas(MesaAOcupar);
                } else {
                    MesasNoDisponibles();
                }
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, ingresa un número válido de personas.\n");
        }
    }
    
    public void crear(int MesasAOcupar, int sillasAAdicional) {

        String nombre = modeloReservacion.getLastUsuario();
        int id = Integer.parseInt(jTextField1.getText());

        String archivo = id + ".reservas";
        File crear_ubicacion = new File(ubicacion);
        File crear_archivo = new File(ubicacion + archivo);

        try {
            if (!crear_ubicacion.exists()) {
                crear_ubicacion.mkdirs();
            } else {
                try (Formatter crea = new Formatter(crear_archivo)) {
                    // Escribir en el archivo
                    crea.format("%s%n%s%n%s%n%s%n%s%n%s",
                            "id=" + id,
                            "Nombre=" + nombre,
                            "HoradDeLlegada=" + jTextField2.getText(),
                            "MesasAOcupar=" + MesasAOcupar,
                            "SillasAdiccionales=" + sillasAAdicional,
                            "CantidadDePersonas=" + jTextField3.getText());
                }

                JOptionPane.showMessageDialog(null, "Reservacion Digitada");
                jTextField1.setText("");
                jTextField2.setText("");
                jTextField3.setText("");

            }
        } catch (HeadlessException | FileNotFoundException e) { // Mostrar traza del error
            JOptionPane.showMessageDialog(null, "Archivo no se pudo crear: " + e.getMessage());
        }
    }

    public static void reservacion(int numeroPersonasReservar, int MesaAOcupar) {
        JOptionPane.showMessageDialog(null, "Se ha realizado su reservación para " + numeroPersonasReservar + " persona(s), en " + MesaAOcupar + " mesa(s).\n");
    }

    public void MesasNoDisponibles() {
        JOptionPane.showMessageDialog(null, "No hay mesas disponibles.\n");
    }

    protected void actualizarMesas(int MesaAOcupar) {
        MesasDisponibles = MesasDisponibles - MesaAOcupar;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        jLabel5.setText("jLabel5");

        setBackground(new java.awt.Color(120, 10, 0));
        setMaximumSize(new java.awt.Dimension(1000, 630));
        setPreferredSize(new java.awt.Dimension(1000, 630));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Reserva tu Mesa");

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Identificacion:");

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Hora de llegada:");

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Cantidad de Personas:");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jButton1.setText("Enviar Reserva");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(398, 398, 398))
            .addGroup(layout.createSequentialGroup()
                .addGap(213, 213, 213)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                            .addComponent(jTextField3)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(262, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(122, 122, 122)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(82, 82, 82)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(119, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed

    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        validarHoraDeLlegada();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables

    @Override
    public void crear() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void actualizar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void query() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
