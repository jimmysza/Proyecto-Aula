
package Content.PanelesPersonal;

import java.awt.HeadlessException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import javax.swing.JOptionPane;
import model.ReservacionesModel;



public class DiagnosticosCajeros extends javax.swing.JPanel {
    
    private final ReservacionesModel modeloReservacion = ReservacionesModel.getInstance();
    String barra = File.separator;
    String ubicacion = System.getProperty("user.dir") + barra + "Diagnostico" + barra + "DiagnosticoCajeros" + barra;
    
    
    public void crear() {
        
        String nombre = modeloReservacion.getLastUsuario();
        String archivo = nombre + ".cajero"; 
        File crear_ubicacion = new File(ubicacion);
        File crear_archivo = new File(ubicacion + archivo); 
        
        
        

        try {
            // Verificar si el archivo ya existe
            if (crear_archivo.exists()) {
                JOptionPane.showMessageDialog(null, "El archivo ya existe");
            } else {
                crear_ubicacion.mkdirs(); 
                
                try (Formatter crea = new Formatter(crear_archivo)) {
                
                    crea.format("%s\r\n%s",
                            "Nombre=" + nombre,
                            "Comentario=" + jTextArea1.getText());
                }
                JOptionPane.showMessageDialog(null, "Diagnostico Correctamente ");
                jTextArea1.setText("");
            }
        } catch (HeadlessException | FileNotFoundException e) { // Mostrar traza del error
            JOptionPane.showMessageDialog(null, "Archivo no se pudo crear: " + e.getMessage());
        }
    }
    
    
    public DiagnosticosCajeros() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(970, 600));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel1.setText("Diagnostico - Cajero");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("¿Cómo se hace para abrir la caja registradora?");

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton1.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jButton1.setText("Enviar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 850, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(61, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(400, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(400, 400, 400))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(jLabel1)
                .addGap(79, 79, 79)
                .addComponent(jLabel2)
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        crear();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
