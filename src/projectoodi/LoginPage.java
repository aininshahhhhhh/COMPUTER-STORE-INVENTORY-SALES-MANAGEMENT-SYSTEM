
package projectoodi;


public class LoginPage extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(LoginPage.class.getName());

    
    public LoginPage() {
        initComponents();
        
        cbAs.setModel(new javax.swing.DefaultComboBoxModel<>(
        new String[] {"Admin", "Staff", "Customer"}
    ));
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtUsername1 = new javax.swing.JTextField();
        txtUsername2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        btnLogin = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cbAs = new javax.swing.JComboBox<>();
        txtpassword = new javax.swing.JPasswordField();

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("PASSWORD :");

        jFormattedTextField1.setText("jFormattedTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("PASSWORD :");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("LOGIN ");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("USERNAME :");

        txtUsername.addActionListener(this::txtUsernameActionPerformed);

        btnLogin.setText("LOGIN");
        btnLogin.addActionListener(this::btnLoginActionPerformed);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("AS                 :");

        cbAs.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbAs.addActionListener(this::cbAsActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                            .addComponent(jLabel2)
                            .addComponent(txtpassword)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnLogin)
                            .addComponent(cbAs, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(136, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(96, 96, 96)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(313, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbAs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(btnLogin)
                .addContainerGap(125, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(173, 173, 173)
                    .addComponent(jLabel3)
                    .addContainerGap(259, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameActionPerformed

    private void cbAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbAsActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
  
        try {

            String username = txtUsername.getText().trim();
            String password = txtpassword.getText().trim();
            String role = cbAs.getSelectedItem().toString();

            // Validation
            if(username.isEmpty() || password.isEmpty()) {
                throw new Exception("Username and Password cannot be empty!");
            }

            if(role.equals("Admin")
                    && username.equals("admin")
                    && password.equals("admin123")) {

                Dashboard dashboard = new Dashboard(role);
                dashboard.setVisible(true);
                this.dispose();

            }

            else if(role.equals("Staff")
                    && username.equals("staff")
                    && password.equals("staff123")) {

                Dashboard dashboard = new Dashboard(role);
                dashboard.setVisible(true);
                this.dispose();

            }

            else if(role.equals("Customer")
                    && username.equals("customer")
                    && password.equals("customer123")) {

                Dashboard dashboard = new Dashboard(role);
                dashboard.setVisible(true);
                this.dispose();

            }

            else {
                throw new Exception("Invalid Username or Password!");
            }

        }
        catch(Exception e) {

            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    e.getMessage(),
                    "Login Error",
                    javax.swing.JOptionPane.ERROR_MESSAGE
            );
        }


    }//GEN-LAST:event_btnLoginActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(() -> new LoginPage().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JComboBox<String> cbAs;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtUsername;
    private javax.swing.JTextField txtUsername1;
    private javax.swing.JTextField txtUsername2;
    private javax.swing.JPasswordField txtpassword;
    // End of variables declaration//GEN-END:variables
}
