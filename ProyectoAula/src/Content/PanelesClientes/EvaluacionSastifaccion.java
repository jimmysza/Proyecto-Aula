
package Content.PanelesClientes;


import java.awt.HeadlessException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Random;
import interfaces.CrudInterfaces;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.ReservacionesModel;



public class EvaluacionSastifaccion extends JPanel implements CrudInterfaces {
    
    String barra = File.separator;
    // Se pone la barra al final para poner despues el fichero
    String ubicacion = System.getProperty("user.dir") + barra + "Evaluaciones" + barra;
    Random random = new Random();
    
private ReservacionesModel modeloReservacion = ReservacionesModel.getInstance();    
    
    @Override
    public void crear(){
        String nombre = modeloReservacion.getLastUsuario();
        
        int numeroMesaRandom = random.nextInt(100) + 1;
        String archivo = nombre + numeroMesaRandom + ".evaluaciones"; // Nombre del archivo con extensión
        
        File crear_ubicacion = new File(ubicacion);
        File crear_archivo = new File(ubicacion + archivo);
        
        
        try {
                // Verificar si el archivo ya existe
                if (crear_archivo.exists()) {
                    JOptionPane.showMessageDialog(null, "El archivo ya existe");
                } else {
                    crear_ubicacion.mkdirs(); // Crear la carpeta si no existe
                    // Poner la info dentro del fichero
                    try (Formatter crea = new Formatter(crear_archivo)) { // Usar crear_archivo
                        // Escribir en el archivo
                        crea.format("%s\r\n%s\r\n%s\r\n%s",
                                "Nombre=" + nombre,
                                "Cargo=" + jComboBoxCargo.getSelectedItem(),
                                "Puntuacion=" + jComboBoxPuntuacion.getSelectedItem(),
                                "Comentario=" + jTextArea1.getText());
                    }
                    jTextArea1.setText("");
                    JOptionPane.showMessageDialog(null, "Evaluacion enviada");                    
                }
            } catch (HeadlessException | FileNotFoundException e) { 
                JOptionPane.showMessageDialog(null, "no se pudo hacer la Evaluacion");
            }
        
       
    }
    
    
    
    public EvaluacionSastifaccion() {
        initComponents();
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxCargo = new javax.swing.JComboBox<>();
        jComboBoxPuntuacion = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(120, 10, 0));
        setPreferredSize(new java.awt.Dimension(1000, 630));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Evaluaciones Sastifacion");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Cargo a Evaluar:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Puntuacion:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Comentario:");

        jComboBoxCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Vigilante", "Meseros", "Cocineros", "Cajero", " " }));
        jComboBoxCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCargoActionPerformed(evt);
            }
        });

        jComboBoxPuntuacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));
        jComboBoxPuntuacion.setMaximumSize(new java.awt.Dimension(72, 22));
        jComboBoxPuntuacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPuntuacionActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

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
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(174, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(34, 34, 34)
                        .addComponent(jComboBoxPuntuacion, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addContainerGap(136, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(149, 149, 149)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBoxPuntuacion, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBoxCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(103, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxPuntuacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPuntuacionActionPerformed
        
    }//GEN-LAST:event_jComboBoxPuntuacionActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    crear();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBoxCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCargoActionPerformed
        
    }//GEN-LAST:event_jComboBoxCargoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBoxCargo;
    private javax.swing.JComboBox<String> jComboBoxPuntuacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables

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
