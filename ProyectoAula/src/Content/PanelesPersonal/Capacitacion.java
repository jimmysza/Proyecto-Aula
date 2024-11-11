
package Content.PanelesPersonal;

import Content.PanelesPersonal.PanelesCapacitaciones.CajerosCapacitaciones;
import Content.PanelesPersonal.PanelesCapacitaciones.CocineroCapacitaciones;
import Content.PanelesPersonal.PanelesCapacitaciones.MeseroCapacitaciones;
import Content.PanelesPersonal.PanelesCapacitaciones.VigilantesCapacitaciones;

public class Capacitacion extends javax.swing.JPanel {
    
    CajerosCapacitaciones panelCajero = new CajerosCapacitaciones();
    CocineroCapacitaciones panelCocinero = new CocineroCapacitaciones();
    MeseroCapacitaciones panelMesero = new MeseroCapacitaciones();
    VigilantesCapacitaciones panelVigilante = new VigilantesCapacitaciones();
  
    public Capacitacion() {
        initComponents();
        
        
        main.add(panelCajero);
        main.add(panelCocinero);
        main.add(panelMesero);
        main.add(panelVigilante);
        
        panelCajero.setVisible(true);
        panelCocinero.setVisible(false);
        panelMesero.setVisible(false);
        panelVigilante.setVisible(false);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        main = new javax.swing.JLayeredPane();
        jButton4 = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(1070, 600));
        setPreferredSize(new java.awt.Dimension(970, 600));
        setRequestFocusEnabled(false);

        jButton1.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jButton1.setText("Vigilante");
        jButton1.setMaximumSize(new java.awt.Dimension(150, 40));
        jButton1.setPreferredSize(new java.awt.Dimension(150, 40));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jButton2.setText("Mesero");
        jButton2.setMaximumSize(new java.awt.Dimension(150, 40));
        jButton2.setPreferredSize(new java.awt.Dimension(150, 40));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jButton3.setText("Cocinero");
        jButton3.setMaximumSize(new java.awt.Dimension(150, 40));
        jButton3.setPreferredSize(new java.awt.Dimension(150, 40));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        main.setMaximumSize(new java.awt.Dimension(860, 380));
        main.setMinimumSize(new java.awt.Dimension(860, 380));
        main.setPreferredSize(new java.awt.Dimension(860, 380));
        main.setLayout(new java.awt.CardLayout());

        jButton4.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jButton4.setText("Cajero");
        jButton4.setMaximumSize(new java.awt.Dimension(150, 40));
        jButton4.setPreferredSize(new java.awt.Dimension(150, 40));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(main, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(main, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        panelCajero.setVisible(false);
        panelCocinero.setVisible(false);
        panelMesero.setVisible(true);
        panelVigilante.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        panelCajero.setVisible(false);
        panelCocinero.setVisible(false);
        panelMesero.setVisible(false);
        panelVigilante.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        panelCajero.setVisible(false);
        panelCocinero.setVisible(true);
        panelMesero.setVisible(false);
        panelVigilante.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        panelCajero.setVisible(true);
        panelCocinero.setVisible(false);
        panelMesero.setVisible(false);
        panelVigilante.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLayeredPane main;
    // End of variables declaration//GEN-END:variables
}
