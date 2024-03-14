/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author 58412
 */
public class Ventana1 extends javax.swing.JFrame {
    BookingHotel bookingHotel;
    /**
     * Creates new form Interfaz1
     */
    public Ventana1(BookingHotel bookingHotel) {
        initComponents();
        setTitle("Hotel Booking");
        setLocationRelativeTo(null);
        setResizable(false);
        this.bookingHotel = bookingHotel;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        buscarCliente = new javax.swing.JButton();
        nombre = new javax.swing.JTextField();
        apellido = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        datosCliente = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        buscarReservacion = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cedula = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buscarCliente.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        buscarCliente.setText("Buscar Cliente");
        buscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarClienteActionPerformed(evt);
            }
        });
        jPanel2.add(buscarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 200, 50));

        nombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel2.add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 200, 40));

        apellido.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel2.add(apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 200, 40));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Nombre del Cliente");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 200, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Apellido del Cliente");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 200, 30));

        jScrollPane1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        datosCliente.setEditable(false);
        datosCliente.setColumns(20);
        datosCliente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        datosCliente.setRows(5);
        jScrollPane1.setViewportView(datosCliente);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 50, 310, 310));

        jTabbedPane2.addTab("Búsqueda de Clientes", jPanel2);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buscarReservacion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        buscarReservacion.setText("Buscar Reservación");
        jPanel3.add(buscarReservacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 200, 50));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Cédula de Identidad");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 200, 30));
        jPanel3.add(cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 200, 40));

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 50, 310, 310));

        jTabbedPane2.addTab("Búsqueda de Reservación", jPanel3);

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jTabbedPane2.addTab("Historial de Habitación", jPanel4);

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jTabbedPane2.addTab("Check-In", jPanel5);

        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jTabbedPane2.addTab("Check-Out", jPanel6);

        jPanel1.add(jTabbedPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 440));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarClienteActionPerformed
        // TODO add your handling code here:
        String nombreC = nombre.getText().trim();
        String apellidoC = apellido.getText().trim();
        String info;
        if (bookingHotel.getHashEstado().buscar(apellidoC, nombreC) == null) {
            info = """
                   El cliente buscado no se encuentra
                   hospedado en el Hotel.""";
        } else {
            info = bookingHotel.getHashEstado().buscar(apellidoC, nombreC).toString();
        }
        datosCliente.setText(info);
        nombre.setText("");
        apellido.setText("");
    }//GEN-LAST:event_buscarClienteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventana1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apellido;
    private javax.swing.JButton buscarCliente;
    private javax.swing.JButton buscarReservacion;
    private javax.swing.JTextField cedula;
    private javax.swing.JTextArea datosCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField nombre;
    // End of variables declaration//GEN-END:variables
}
