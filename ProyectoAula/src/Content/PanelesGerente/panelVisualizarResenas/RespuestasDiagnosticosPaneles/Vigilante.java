
package Content.PanelesGerente.panelVisualizarResenas.RespuestasDiagnosticosPaneles;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Vigilante extends javax.swing.JPanel {

    String barra = File.separator;
    String ubicacion = System.getProperty("user.dir") + barra + "Diagnostico" + barra + "DiagnosticoVigilante" + barra;
    

    File contenedor = new File(ubicacion);
    File[] registros = contenedor.listFiles();

    private DefaultTableModel dtm;
    
    private void inicializarModeloTabla() {
        // Inicializa el DefaultTableModel con los nombres de las columnas
        dtm = new DefaultTableModel(new Object[]{"Nombre","Nombre Archivo", "Respuesta Vigilante"}, 0);
        jTable1.setModel(dtm); // Asocia el modelo con jTable1

        jTable1.getColumnModel().getColumn(0).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(30);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(300);

        // Configura el JScrollPane para contener jTable1
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
    
    public Vigilante() {
        initComponents();
        inicializarModeloTabla();
        RegTabla();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jToggleButton1 = new javax.swing.JToggleButton();
        jButton2 = new javax.swing.JButton();

        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jToggleButton1.setText("Actualizar");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
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
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jToggleButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(31, 31, 31)
                .addComponent(jToggleButton1)
                .addGap(230, 230, 230))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        registros = contenedor.listFiles();
        ActualizarTabla();
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Eliminar();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
