package Content.PanelesGerente;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class DisponibilidadMesas extends javax.swing.JPanel {

    String barra = File.separator;
    String ubicacion = System.getProperty("user.dir") + barra + "ReservasMesas" + barra;

    File contenedor = new File(ubicacion);
    File[] registros = contenedor.listFiles();

    String ubicacion_contador = System.getProperty("user.dir") + barra + "ContadorMesas" + barra;
    File contenedor_contador = new File(ubicacion_contador);
    

    String[] titulo = {"ID", "Nombre", "Hora De Llegada", "Mesas A Ocupar", "Sillas Adicionales", "Cantidad De Personas"};
    DefaultTableModel dtm = new DefaultTableModel(null, titulo);

    public DisponibilidadMesas() {
        initComponents();
        RegTabla();
        registros = contenedor.listFiles();
    }

    public void ActualizarTabla() {
        registros = contenedor.listFiles();
        dtm.setRowCount(0); // Limpia el modelo de la tabla antes de actualizar
        RegTabla();
    }

    private void RegTabla() {
        for (File registro : registros) {
            try (FileInputStream fis = new FileInputStream(registro)) {
                Properties mostrar = new Properties();
                mostrar.load(fis);

                String[] fila = {
                    registro.getName(),
                    mostrar.getProperty("Nombre"),
                    mostrar.getProperty("HoradDeLlegada"),
                    mostrar.getProperty("MesasAOcupar"),
                    mostrar.getProperty("SillasAdiccionales"),
                    mostrar.getProperty("CantidadDePersonas")
                };
                dtm.addRow(fila);

            } catch (IOException e) {
            }
        }
        jTable1.setModel(dtm);
    }

    private void Eliminar() {
        int filaSeleccionada = jTable1.getSelectedRow();
        if (filaSeleccionada != -1) {
            String nombreArchivo = (String) dtm.getValueAt(filaSeleccionada, 0);
            File archivoAEliminar = new File(ubicacion + nombreArchivo);

            String mesasAEliminarStr = (String) dtm.getValueAt(filaSeleccionada, 3);
            int mesasAEliminar;
            try {
                mesasAEliminar = Integer.parseInt(mesasAEliminarStr);
                leerArchivosContador(mesasAEliminar);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error al obtener el número de mesas a eliminar.");
                return;
            }

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
    }

    private void leerArchivosContador(int mesasAEliminar) {
        File directorioContador = new File(ubicacion_contador);
        File[] archivosEnDirectorio = directorioContador.listFiles();
        if (archivosEnDirectorio == null || archivosEnDirectorio.length == 0) {
            JOptionPane.showMessageDialog(null, "No se encontraron archivos en el directorio para eliminar.");
            return;
        }

        int archivosEliminados = 0;
        for (File archivo : archivosEnDirectorio) {
            if (archivosEliminados < mesasAEliminar) {
                if (archivo.delete()) {
                    archivosEliminados++;
                } else {
                    JOptionPane.showMessageDialog(null, "Error al eliminar el archivo: " + archivo.getName());
                }
            } else {
                break;
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

        setMaximumSize(new java.awt.Dimension(930, 610));
        setPreferredSize(new java.awt.Dimension(930, 610));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Disponibilidad Mesas");

        jTable1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jButton1.setText("Eliminar");
        jButton1.setMaximumSize(new java.awt.Dimension(200, 40));
        jButton1.setPreferredSize(new java.awt.Dimension(200, 40));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jButton2.setText("Actualizar");
        jButton2.setMaximumSize(new java.awt.Dimension(200, 40));
        jButton2.setPreferredSize(new java.awt.Dimension(200, 40));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(158, 158, 158))
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 860, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Eliminar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        registros = contenedor.listFiles();
        ActualizarTabla();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
