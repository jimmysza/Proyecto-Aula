package Content.PanelesGerente.panelVisualizarResenas;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MostrarEvaluaciones extends javax.swing.JPanel {

    String barra = File.separator;
    String ubicacion = System.getProperty("user.dir") + barra + "Evaluaciones" + barra;

    File contenedor = new File(ubicacion);
    File[] registros = contenedor.listFiles();

    private DefaultTableModel dtm;

    public MostrarEvaluaciones() {
        initComponents();
        inicializarModeloTabla();
        RegTabla();
    }

    private void inicializarModeloTabla() {
        
        dtm = new DefaultTableModel(new Object[]{"Nombre", "Cargo", "Puntuacion", "Comentario","FileName"}, 0);
        jTable1.setModel(dtm); // Asocia el modelo con jTable1

        // Configura los anchos de las columnas
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(20);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(20);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(15);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(315);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(15);

        // Configura el JScrollPane para contener jTable1
        jScrollPane1.setViewportView(jTable1);
    }

    public void ActualizarTabla() {
        registros = contenedor.listFiles();
        dtm.setRowCount(0);
        RegTabla(); 
    }

    private void RegTabla() {
        registros = contenedor.listFiles();
        for (File registro : registros) {
            if (registro.isFile()) {
                try (FileInputStream fis = new FileInputStream(registro)) {
                    Properties mostrar = new Properties();
                    mostrar.load(fis);
                    dtm.addRow(new Object[]{
                        mostrar.getProperty("Nombre"),
                        mostrar.getProperty("Cargo"),
                        mostrar.getProperty("Puntuacion"),
                        mostrar.getProperty("Comentario"),
                        registro.getName()
                    });
                } catch (IOException e) {
                }
            }
        }
    }
    
    private void Eliminar() {
        int filaSeleccionada = jTable1.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(null, "Por favor, seleccione un registro para eliminar.");
            return;
        }
        
        String nombreArchivo = (String) dtm.getValueAt(filaSeleccionada, 4); 
        File archivoAEliminar = new File(ubicacion + nombreArchivo);

        String[] opciones = {"Eliminar", "Cancelar"};
        int confirmacion = JOptionPane.showOptionDialog(
                null,
                "¿Estás seguro de que deseas eliminar el registro " + nombreArchivo + "?",
                "Confirmación de eliminación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[1]);

        if (confirmacion == JOptionPane.YES_OPTION) {
            if (archivoAEliminar.delete()) {
                JOptionPane.showMessageDialog(null, "Registro eliminado correctamente.");
                ActualizarTabla();
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar el registro.");
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();

        setPreferredSize(new java.awt.Dimension(650, 530));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Evaluaciones Sastifaccion");

        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(20);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(20);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(25);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(300);
        }

        jToggleButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jToggleButton1.setText("Actualizar");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jToggleButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jToggleButton2.setText("Eliminar");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 638, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jToggleButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton1)
                    .addComponent(jToggleButton2))
                .addContainerGap(60, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        registros = contenedor.listFiles();
        ActualizarTabla();
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
       Eliminar();
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    // End of variables declaration//GEN-END:variables
}