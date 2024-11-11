package Content.PanelesGerente.panelVisualizarResenas;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MostrarPeticion extends javax.swing.JPanel {

    String barra = File.separator;
    String ubicacion = System.getProperty("user.dir") + barra + "PQR" + barra + "Peticiones" + barra;

    File contenedor = new File(ubicacion);
    File[] registros = contenedor.listFiles();

    private DefaultTableModel dtm;

    private void inicializarModeloTabla() {
        dtm = new DefaultTableModel(new Object[]{"Nombre", "file", "Peticion"}, 0);
        jTable1.setModel(dtm); 

        jTable1.getColumnModel().getColumn(0).setPreferredWidth(15);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(5);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(430);

        jScrollPane1.setViewportView(jTable1);
    }

    public void ActualizarTabla() {
        registros = contenedor.listFiles();
        dtm.setRowCount(0); // Borra las filas actuales
        RegTabla(); // Rellena la tabla de nuevo
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
                        registro.getName(),
                        mostrar.getProperty("Comentario")
                    });
                } catch (IOException e) {
                    e.printStackTrace(); // Imprime el stack trace en caso de error
                }
            }
        }
    }

    public MostrarPeticion() {
        initComponents();
        inicializarModeloTabla();
        RegTabla();
    }

    private void Eliminar() {
        int filaSeleccionada = jTable1.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(null, "Por favor, seleccione un registro para eliminar.");
            return;
        }

        String nombreArchivo = (String) dtm.getValueAt(filaSeleccionada, 1);
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(650, 530));
        setPreferredSize(new java.awt.Dimension(650, 530));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Peticiones");

        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Actualizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Eliminar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 638, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(39, 39, 39)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(52, 52, 52))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        registros = contenedor.listFiles();
        ActualizarTabla();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Eliminar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
