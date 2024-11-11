package Content.PanelesClientes;

import java.awt.HeadlessException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import javax.swing.JOptionPane;
import model.ReservacionesModel;
import java.util.Random;

public class pqr extends javax.swing.JPanel {

    private ReservacionesModel modeloReservacion = ReservacionesModel.getInstance();
    Random random = new Random();
    int numrandom = random.nextInt(100) + 1;

    String barra = File.separator;
    // Se pone la barra al final para poner despues el fichero
    String ubicacion_peticion = System.getProperty("user.dir") + barra + "PQR" + barra + "Peticiones" + barra;
    String ubicacion_quejas = System.getProperty("user.dir") + barra + "PQR" + barra + "Quejas" + barra;
    String ubicacion_reclamos = System.getProperty("user.dir") + barra + "PQR" + barra + "Reclamos" + barra;

    public void crear(String respuesta, String Tipo_Formato, String ubicacion) {
        String nombre = modeloReservacion.getLastUsuario();
        String archivo = nombre + numrandom + Tipo_Formato + ".pqr"; 
        File crear_ubicacion = new File(ubicacion);
        File crear_archivo = new File(ubicacion + archivo);

        try {

            crear_ubicacion.mkdirs();

            try (Formatter crea = new Formatter(crear_archivo)) {
                // Escribir en el archivo
                crea.format("%s\r\n%s",
                        "Nombre=" + nombre,
                        "Comentario=" + respuesta);
            }

        } catch (HeadlessException | FileNotFoundException e) { // Mostrar traza del error
            JOptionPane.showMessageDialog(null, "Archivo no se pudo crear: " + e.getMessage());
        }
    }

    public pqr() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        setBackground(new java.awt.Color(120, 10, 0));
        setMaximumSize(new java.awt.Dimension(1000, 630));
        setPreferredSize(new java.awt.Dimension(1000, 630));

        jButton1.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jButton1.setText("Enviar Peticion");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jButton2.setText("Enviar Quejas");
        jButton2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jButton3.setText("Enviar Reclamos");
        jButton3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI Historic", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/MdiEmailNewsletter.png"))); // NOI18N
        jLabel4.setText("icON");

        jLabel5.setFont(new java.awt.Font("Segoe UI Historic", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/MdiEmailNewsletter.png"))); // NOI18N
        jLabel5.setText("icON");

        jLabel6.setFont(new java.awt.Font("Segoe UI Historic", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/MdiEmailNewsletter.png"))); // NOI18N
        jLabel6.setText("icON");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(125, 125, 125)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(198, 198, 198)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)))
                .addGap(75, 75, 75))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(173, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addGap(81, 81, 81)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(148, 148, 148))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String peticion = JOptionPane.showInputDialog(null, "Ingrese su Petición:");
        if (peticion != null && !peticion.trim().isEmpty()) {
            crear(peticion, ".peticion", ubicacion_peticion);
            JOptionPane.showMessageDialog(null, "Petición registrada con éxito.");
        } else {
            JOptionPane.showMessageDialog(null, "No se ingresó ninguna petición.");
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        String quejas = JOptionPane.showInputDialog(null, "Ingrese sus Quejas:");
        if (quejas != null && !quejas.trim().isEmpty()) {
            crear(quejas, ".quejas", ubicacion_quejas);
            JOptionPane.showMessageDialog(null, "Queja registrada con éxito.");
        } else {
            JOptionPane.showMessageDialog(null, "No se ingresó ninguna queja.");
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        String reclamos = JOptionPane.showInputDialog(null, "Ingrese su Reclamo:");
        if (reclamos != null && !reclamos.trim().isEmpty()) {
            crear(reclamos, ".reclamos", ubicacion_reclamos);
            JOptionPane.showMessageDialog(null, "Reclamo registrado con éxito.");
        } else {
            JOptionPane.showMessageDialog(null, "No se ingresó ningún reclamo.");
        }

    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}
