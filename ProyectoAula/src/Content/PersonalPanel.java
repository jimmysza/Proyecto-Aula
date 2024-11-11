package Content;

import Content.PanelesPersonal.Capacitacion;
import Content.PanelesPersonal.DiagnosticosCajeros;
import Content.PanelesPersonal.DiagnosticosCocinero;
import Content.PanelesPersonal.DiagnosticosMesero;
import Content.PanelesPersonal.DiagnosticosVigilante;
import Content.PanelesPersonal.MainPanelPersonal;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class PersonalPanel extends javax.swing.JPanel {

    Capacitacion panelCapa = new Capacitacion();
    DiagnosticosVigilante panelVigilante = new DiagnosticosVigilante();
    DiagnosticosCajeros panelCajeros = new DiagnosticosCajeros();
    DiagnosticosCocinero panelCocinero = new DiagnosticosCocinero();
    DiagnosticosMesero panelMesero = new DiagnosticosMesero();
    MainPanelPersonal panelMain = new MainPanelPersonal();

    public PersonalPanel() {
        initComponents();

        // Añadir los paneles al JLayeredPane
        main.add(panelCapa);
        main.add(panelVigilante);
        main.add(panelMain);
        main.add(panelCajeros);
        main.add(panelCocinero);
        main.add(panelMesero);

        // Configurar la visibilidad de los paneles
        panelMain.setVisible(true);
        panelCapa.setVisible(false);
        panelVigilante.setVisible(false);
        panelCajeros.setVisible(false);
        panelCocinero.setVisible(false);
        panelMesero.setVisible(false);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Personal Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1216, 760);

        // Agregar el panel principal al JFrame
        frame.add(new PersonalPanel());

        frame.setVisible(true);
    }

    public void capacitacioAprendizaje() {

        int cargo = Integer.parseInt(JOptionPane.showInputDialog(null, """
        Escoja el Cargo para realizar el diagnostico:
                1. Vigilante
                2. Mesero
                3. Cocinero
                4. Cajero
                ¿Cuál es el número correspondiente al cargo (1-4):"""));

        // Llama al método de capacitación correspondiente según el cargo
        switch (cargo) {
            case 1 -> {
                panelMain.setVisible(false);
                panelCapa.setVisible(false);
                panelVigilante.setVisible(true);
                panelCajeros.setVisible(false);
                panelCocinero.setVisible(false);
                panelMesero.setVisible(false);
            }
            case 2 -> {
                panelMain.setVisible(false);
                panelCapa.setVisible(false);
                panelVigilante.setVisible(false);
                panelCajeros.setVisible(false);
                panelCocinero.setVisible(false);
                panelMesero.setVisible(true);
            }
            case 3 -> {
                panelMain.setVisible(false);
                panelCapa.setVisible(false);
                panelVigilante.setVisible(false);
                panelCajeros.setVisible(false);
                panelCocinero.setVisible(true);
                panelMesero.setVisible(false);
            }
            case 4 -> {
                panelMain.setVisible(false);
                panelCapa.setVisible(false);
                panelVigilante.setVisible(false);
                panelCajeros.setVisible(true);
                panelCocinero.setVisible(false);
                 panelMesero.setVisible(false);
            }
            default ->
                JOptionPane.showMessageDialog(null, "Error Ingreso el codigo incorrecto");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        main = new javax.swing.JLayeredPane();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1216, 760));
        setPreferredSize(new java.awt.Dimension(1216, 760));
        setRequestFocusEnabled(false);

        jPanel1.setBackground(new java.awt.Color(207, 10, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(387, 64));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Personal Seccion");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(830, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
        );

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("Capacitacion");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setText("Diagnostico");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        main.setPreferredSize(new java.awt.Dimension(970, 600));
        main.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1216, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(main, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(165, 165, 165))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                        .addComponent(main, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       capacitacioAprendizaje();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        panelCapa.setVisible(true);
        panelVigilante.setVisible(false);
        panelMain.setVisible(false);
        panelCajeros.setVisible(false);
        panelCocinero.setVisible(false);
        panelMesero.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLayeredPane main;
    // End of variables declaration//GEN-END:variables
}
