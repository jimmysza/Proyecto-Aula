package Content.PanelesGerente;

import Content.PanelesGerente.panelVisualizarResenas.MostrarEvaluaciones;
import Content.PanelesGerente.panelVisualizarResenas.MostrarPeticion;
import Content.PanelesGerente.panelVisualizarResenas.MostrarQuejas;
import Content.PanelesGerente.panelVisualizarResenas.MostrarReclamos;
import Content.PanelesGerente.panelVisualizarResenas.RespuestasDiagnosticosPaneles.Cajero;
import Content.PanelesGerente.panelVisualizarResenas.RespuestasDiagnosticosPaneles.Cocinero;
import Content.PanelesGerente.panelVisualizarResenas.RespuestasDiagnosticosPaneles.Mesero;
import Content.PanelesGerente.panelVisualizarResenas.RespuestasDiagnosticosPaneles.Vigilante;
import javax.swing.JOptionPane;

public class VisualizarResenas extends javax.swing.JPanel {

    MostrarEvaluaciones panelEvaluaciones = new MostrarEvaluaciones();
    MostrarPeticion panelPeticion = new MostrarPeticion();
    MostrarQuejas panelQuejas = new MostrarQuejas();
    MostrarReclamos panelReclamos = new MostrarReclamos();
    

    public VisualizarResenas() {
        initComponents();

        main.add(panelEvaluaciones);
        main.add(panelPeticion);
        main.add(panelQuejas);
        main.add(panelReclamos);
        

        panelEvaluaciones.setVisible(false);
        panelPeticion.setVisible(false);
        panelQuejas.setVisible(false);
        panelReclamos.setVisible(false);
        panelV.setVisible(false);
        panelM.setVisible(false);
        panelC.setVisible(false);
        panelCo.setVisible(false);

        main.add(panelV);
        main.add(panelM);
        main.add(panelC);
        main.add(panelCo);

        panelV.setVisible(false);
        panelM.setVisible(false);
        panelC.setVisible(false);
        panelCo.setVisible(false);
    }

    Vigilante panelV = new Vigilante();
    Mesero panelM = new Mesero();
    Cajero panelC = new Cajero();
    Cocinero panelCo = new Cocinero();

    public void capacitacioAprendizaje() {

        int cargo = Integer.parseInt(JOptionPane.showInputDialog(null, """
        Escoja el Cargo para ver las respuestas del diagnostico:
                1. Vigilante
                2. Mesero
                3. Cocinero
                4. Cajero
                ¿Cuál es el número correspondiente al cargo (1-4):"""));

        switch (cargo) {
            case 1 -> {
                panelV.setVisible(true);
                panelEvaluaciones.setVisible(false);
                panelPeticion.setVisible(false);
                panelQuejas.setVisible(false);
                panelReclamos.setVisible(false);
                panelM.setVisible(false);
                panelC.setVisible(false);
                panelCo.setVisible(false);
            }
            case 2 -> {
                panelEvaluaciones.setVisible(false);
                panelPeticion.setVisible(false);
                panelQuejas.setVisible(false);
                panelReclamos.setVisible(false);
                panelV.setVisible(false);
                panelC.setVisible(false);
                panelCo.setVisible(false);
                panelM.setVisible(true);

            }
            case 3 -> {
                panelEvaluaciones.setVisible(false);
                panelPeticion.setVisible(false);
                panelQuejas.setVisible(false);
                panelReclamos.setVisible(false);
                panelV.setVisible(false);
                panelM.setVisible(false);
                panelC.setVisible(false);
                panelCo.setVisible(true);

            }
            case 4 -> {
                panelEvaluaciones.setVisible(false);
                panelPeticion.setVisible(false);
                panelQuejas.setVisible(false);
                panelReclamos.setVisible(false);
                panelV.setVisible(false);
                panelM.setVisible(false);
                panelC.setVisible(false);
                panelCo.setVisible(false);

                panelC.setVisible(true);

            }
            default ->
                JOptionPane.showMessageDialog(null, "Error Ingreso el codigo incorrecto");
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new VisualizarResenas().setVisible(true);
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        main = new javax.swing.JLayeredPane();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(930, 610));

        jButton1.setText("Evaluaciones Sastifaccion");
        jButton1.setMaximumSize(new java.awt.Dimension(160, 30));
        jButton1.setPreferredSize(new java.awt.Dimension(160, 30));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Peticiones");
        jButton2.setMaximumSize(new java.awt.Dimension(160, 30));
        jButton2.setPreferredSize(new java.awt.Dimension(160, 30));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Quejas");
        jButton3.setMaximumSize(new java.awt.Dimension(160, 30));
        jButton3.setPreferredSize(new java.awt.Dimension(160, 30));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Reclamos");
        jButton4.setMaximumSize(new java.awt.Dimension(160, 30));
        jButton4.setPreferredSize(new java.awt.Dimension(160, 30));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Respuestas Diagnosticos");
        jButton5.setMaximumSize(new java.awt.Dimension(160, 30));
        jButton5.setPreferredSize(new java.awt.Dimension(160, 30));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        main.setPreferredSize(new java.awt.Dimension(650, 530));
        main.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addComponent(main, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(main, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(92, 92, 92)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(94, 94, 94)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        panelPeticion.setVisible(false);
        panelQuejas.setVisible(false);
        panelReclamos.setVisible(false);
        panelV.setVisible(false);
        panelM.setVisible(false);
        panelC.setVisible(false);
        panelCo.setVisible(false);
        panelEvaluaciones.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        panelEvaluaciones.setVisible(false);
        panelQuejas.setVisible(false);
        panelReclamos.setVisible(false);
        panelV.setVisible(false);
        panelM.setVisible(false);
        panelC.setVisible(false);
        panelCo.setVisible(false);
        panelPeticion.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        panelEvaluaciones.setVisible(false);
        panelPeticion.setVisible(false);
        panelReclamos.setVisible(false);
        panelV.setVisible(false);
        panelM.setVisible(false);
        panelC.setVisible(false);
        panelCo.setVisible(false);
        panelQuejas.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        panelEvaluaciones.setVisible(false);
        panelPeticion.setVisible(false);
        panelQuejas.setVisible(false); 
        panelV.setVisible(false);
        panelM.setVisible(false);
        panelC.setVisible(false);
        panelCo.setVisible(false);
        panelReclamos.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        capacitacioAprendizaje();
    }//GEN-LAST:event_jButton5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLayeredPane main;
    // End of variables declaration//GEN-END:variables
}
