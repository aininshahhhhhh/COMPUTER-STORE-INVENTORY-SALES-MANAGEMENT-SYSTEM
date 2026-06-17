
package projectoodi;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class SupplierFrame extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(SupplierFrame.class.getName());

   
   public SupplierFrame() {
    initComponents();
    
    Connection con = DBConnection.getConnection();

  
    pnlRegister.setVisible(true);
    pnlUpdate.setVisible(false);
    pnlHistory.setVisible(false);
    pnlPurchaseOrder.setVisible(false);

    loadSupplierData();

    // Purchase Order Setup
    loadSupplierIDs();
    loadItems();
    loadPurchaseOrderData();

    txtOrderDate.setText(
            java.time.LocalDate.now().toString());

    txtOrderDate.setEditable(false);
    txtSupplierNamePO.setEditable(false);
    txtPrice.setEditable(false);
    txtTotal.setEditable(false);
}
    
    private void saveTableToFile() {

    try {

        DefaultTableModel model =
                (DefaultTableModel) tblSupplier.getModel();

        java.io.BufferedWriter writer =
                new java.io.BufferedWriter(
                        new java.io.FileWriter("supplier.txt"));

        for (int i = 0; i < model.getRowCount(); i++) {

            writer.write(
                    model.getValueAt(i, 0).toString() + "," +
                    model.getValueAt(i, 1).toString() + "," +
                    model.getValueAt(i, 2).toString() + "," +
                    model.getValueAt(i, 3).toString() + "," +
                    model.getValueAt(i, 4).toString());

            writer.newLine();
        }

        writer.close();

    } catch (Exception e) {

        JOptionPane.showMessageDialog(this,
                e.getMessage());
    }
}
    

    

    private void loadSupplierData() {

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM suppliers";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            DefaultTableModel model =
                    (DefaultTableModel) tblSupplier.getModel();

            model.setRowCount(0);

            while(rs.next()) {

                model.addRow(new Object[] {
                    rs.getString("supplier_id"),
                    rs.getString("supplier_name"),
                    rs.getString("phone"),
                    rs.getString("email"),
                    rs.getString("address")
                });
            }

        } catch(Exception e) {

            JOptionPane.showMessageDialog(
                    this,
                    e.getMessage());
        }
    }
    
        private void loadHistoryData() {

            try {

                Connection con =
                        DBConnection.getConnection();

                String sql =
                        "SELECT * FROM suppliers";

                PreparedStatement ps =
                        con.prepareStatement(sql);

                ResultSet rs =
                        ps.executeQuery();

                DefaultTableModel model =
                        (DefaultTableModel) tbHistory.getModel();

                model.setRowCount(0);

                while(rs.next()) {

                    model.addRow(new Object[] {
                        rs.getString("supplier_id"),
                        rs.getString("supplier_name"),
                        rs.getString("phone"),
                        rs.getString("email"),
                        rs.getString("address")
                    });
                }

            } catch(Exception e) {

                JOptionPane.showMessageDialog(
                        this,
                        e.getMessage());
            }
        }

    
        
    private void loadSupplierIDs() {

    cmbSupplierID.removeAllItems();

    try {

        Connection con =
                DBConnection.getConnection();

        String sql =
                "SELECT supplier_id FROM suppliers";

        PreparedStatement ps =
                con.prepareStatement(sql);

        ResultSet rs =
                ps.executeQuery();

        while(rs.next()) {

            cmbSupplierID.addItem(
                    rs.getString("supplier_id"));
        }

    } catch(Exception e) {

        JOptionPane.showMessageDialog(
                this,
                e.getMessage());
    }
}

    private void loadItems() {

    cmbItemName.removeAllItems();

    cmbItemName.addItem("Laptop");
    cmbItemName.addItem("Desktop PC");
    cmbItemName.addItem("Monitor");
    cmbItemName.addItem("Keyboard");
    cmbItemName.addItem("Mouse");
    cmbItemName.addItem("Printer");
    cmbItemName.addItem("SSD");
    cmbItemName.addItem("RAM");
}
    
    private void loadPurchaseOrderData() {

        try {

            Connection con =
                    DBConnection.getConnection();

            String sql =
                    "SELECT * FROM purchase_orders";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ResultSet rs =
                    ps.executeQuery();

            DefaultTableModel model =
                    (DefaultTableModel)
                    jTable3.getModel();

            model.setRowCount(0);

            while(rs.next()) {

                model.addRow(new Object[] {

                    rs.getString("po_id"),
                    rs.getString("supplier_name"),
                    rs.getString("item_name"),
                    rs.getInt("quantity"),
                    rs.getDouble("price"),
                    rs.getDouble("total"),
                    rs.getDate("order_date")
                });
            }

        } catch(Exception e){

            JOptionPane.showMessageDialog(
                    this,
                    e.getMessage());
        }
    }
    
        private void loadDeletePOData() {

            try {

                Connection con = DBConnection.getConnection();

                String sql =
                        "SELECT * FROM purchase_orders";

                PreparedStatement ps =
                        con.prepareStatement(sql);

                ResultSet rs =
                        ps.executeQuery();

                DefaultTableModel model =
                        (DefaultTableModel) tblDeletePO.getModel();

                model.setRowCount(0);

                while(rs.next()) {

                    model.addRow(new Object[] {

                        rs.getString("po_id"),
                        rs.getString("supplier_id"),
                        rs.getString("supplier_name"),
                        rs.getString("item_name"),
                        rs.getInt("quantity"),
                        rs.getDouble("price"),
                        rs.getDouble("total"),
                        rs.getDate("order_date")
                    });
                }

                rs.close();
                ps.close();
                con.close();

            } catch(Exception e) {

                JOptionPane.showMessageDialog(
                        this,
                        e.getMessage());
            }
        }
  

    
    private void btnUpdateSupplierActionPerformed(
            java.awt.event.ActionEvent evt) {

        loadSupplierData();
    }
    
    



   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        txtSupplierName1 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAddress1 = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtPOID1 = new javax.swing.JTextField();
        txtSupplierNamePO1 = new javax.swing.JTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        lblFormtitle7 = new javax.swing.JLabel();
        lblFormtitle14 = new javax.swing.JLabel();
        txtQuantityView1 = new javax.swing.JTextField();
        lblFormtitle16 = new javax.swing.JLabel();
        lblFormtitle18 = new javax.swing.JLabel();
        txtTotalView1 = new javax.swing.JTextField();
        lblFormtitle20 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnRegister = new javax.swing.JButton();
        btnUpdateSupp = new javax.swing.JButton();
        btnView = new javax.swing.JButton();
        btnCreatePO = new javax.swing.JButton();
        btnDeletePO = new javax.swing.JButton();
        btnViewPO = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        pnlContent = new javax.swing.JPanel();
        pnlRegister = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtSupplierName = new javax.swing.JTextField();
        txtSupplierID = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAddress = new javax.swing.JTextArea();
        btnSave = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        lblFormtitle = new javax.swing.JLabel();
        pnlUpdate = new javax.swing.JPanel();
        lblFormtitle1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtUpdateID = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtUpdateName = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtUpdateAddress = new javax.swing.JTextArea();
        btnUpdate = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblSupplier = new javax.swing.JTable();
        txtUpdateEmail = new javax.swing.JTextField();
        txtUpdatePhone = new javax.swing.JTextField();
        btnDelete = new javax.swing.JButton();
        pnlHistory = new javax.swing.JPanel();
        lblFormtitle2 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbHistory = new javax.swing.JTable();
        pnlPurchaseOrder = new javax.swing.JPanel();
        lblFormtitle3 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtPOID = new javax.swing.JTextField();
        cmbSupplierID = new javax.swing.JComboBox<>();
        txtSupplierNamePO = new javax.swing.JTextField();
        cmbItemName = new javax.swing.JComboBox<>();
        txtQuantity = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        txtOrderDate = new javax.swing.JTextField();
        btnCalculate = new javax.swing.JButton();
        btnSavePO = new javax.swing.JButton();
        btnClearPO = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        pnlDeletePO = new javax.swing.JPanel();
        lblFormtitle4 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblDeletePO = new javax.swing.JTable();
        btnDeletePOpage2 = new javax.swing.JButton();
        pnlViewPO = new javax.swing.JPanel();
        pnlViewPO1 = new javax.swing.JPanel();
        lblFormtitle10 = new javax.swing.JLabel();
        txtSupplierIDView = new javax.swing.JTextField();
        lblFormtitle11 = new javax.swing.JLabel();
        txtSupplierNameView = new javax.swing.JTextField();
        lblFormtitle12 = new javax.swing.JLabel();
        txtItemView = new javax.swing.JTextField();
        lblFormtitle13 = new javax.swing.JLabel();
        txtQuantityView = new javax.swing.JTextField();
        lblFormtitle15 = new javax.swing.JLabel();
        txtPriceView = new javax.swing.JTextField();
        lblFormtitle17 = new javax.swing.JLabel();
        txtTotalView = new javax.swing.JTextField();
        lblFormtitle19 = new javax.swing.JLabel();
        txtDateView = new javax.swing.JTextField();
        btnClearViewPO = new javax.swing.JButton();
        lblFormtitle5 = new javax.swing.JLabel();
        lblFormtitle21 = new javax.swing.JLabel();
        txtSearchPOID = new javax.swing.JTextField();
        btnSearchPO = new javax.swing.JButton();

        jMenuItem1.setText("jMenuItem1");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        txtAddress1.setColumns(20);
        txtAddress1.setRows(5);
        jScrollPane2.setViewportView(txtAddress1);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane7.setViewportView(jTable2);

        lblFormtitle7.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblFormtitle7.setText("PURCHASE ORDER ID : ");

        lblFormtitle14.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblFormtitle14.setText("QUANTITY : ");

        lblFormtitle16.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblFormtitle16.setText("PRICE : ");

        lblFormtitle18.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblFormtitle18.setText("TOTAL AMOUNT : ");

        lblFormtitle20.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblFormtitle20.setText("SUPPLIER ID : ");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setToolTipText("SUPPLIER MANAGEMENT");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("SUPPLIER MANAGEMENT");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(193, 193, 193))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 153, 153));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("MENU");

        btnRegister.setText("Register Supplier");
        btnRegister.addActionListener(this::btnRegisterActionPerformed);

        btnUpdateSupp.setText("Update Supplier");
        btnUpdateSupp.addActionListener(this::btnUpdateSuppActionPerformed);

        btnView.setText("View History");
        btnView.addActionListener(this::btnViewActionPerformed);

        btnCreatePO.setText("Create Purchase Order");
        btnCreatePO.addActionListener(this::btnCreatePOActionPerformed);

        btnDeletePO.setText("Delete Purchase Order");
        btnDeletePO.addActionListener(this::btnDeletePOActionPerformed);

        btnViewPO.setText("View Purchase Order");
        btnViewPO.addActionListener(this::btnViewPOActionPerformed);

        btnBack.setText("BACK");
        btnBack.addActionListener(this::btnBackActionPerformed);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegister, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUpdateSupp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCreatePO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDeletePO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnViewPO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnBack)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegister)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUpdateSupp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnView)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCreatePO)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDeletePO)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnViewPO)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 244, Short.MAX_VALUE)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlContent.setLayout(new java.awt.CardLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("SUPPLIER ID         :");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("SUPPLIER NAME  :");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("PHONE NUMBER :");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("EMAIL                   :");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("ADDRESS              :");

        txtSupplierID.addActionListener(this::txtSupplierIDActionPerformed);

        txtPhone.addActionListener(this::txtPhoneActionPerformed);

        txtAddress.setColumns(20);
        txtAddress.setRows(5);
        jScrollPane1.setViewportView(txtAddress);

        btnSave.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSave.setText("SAVE");
        btnSave.addActionListener(this::btnSaveActionPerformed);

        btnClear.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnClear.setText("CLEAR");
        btnClear.addActionListener(this::btnClearActionPerformed);

        lblFormtitle.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblFormtitle.setText("REGISTER SUPPLIER");

        javax.swing.GroupLayout pnlRegisterLayout = new javax.swing.GroupLayout(pnlRegister);
        pnlRegister.setLayout(pnlRegisterLayout);
        pnlRegisterLayout.setHorizontalGroup(
            pnlRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegisterLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(pnlRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnlRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRegisterLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlRegisterLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(pnlRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSupplierName, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSupplierID, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(94, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRegisterLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblFormtitle, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(189, 189, 189))
        );
        pnlRegisterLayout.setVerticalGroup(
            pnlRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegisterLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lblFormtitle, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(pnlRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSupplierID, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSupplierName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRegisterLayout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRegisterLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(pnlRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(95, Short.MAX_VALUE))
        );

        pnlContent.add(pnlRegister, "card3");

        lblFormtitle1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblFormtitle1.setText("UPDATE INFO SUPPLIER");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("SUPPLIER ID         :");

        txtUpdateID.addActionListener(this::txtUpdateIDActionPerformed);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("SUPPLIER NAME  :");

        txtUpdateName.addActionListener(this::txtUpdateNameActionPerformed);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("PHONE NUMBER :");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("EMAIL                   :");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("ADDRESS              :");

        txtUpdateAddress.setColumns(20);
        txtUpdateAddress.setRows(5);
        jScrollPane3.setViewportView(txtUpdateAddress);

        btnUpdate.setText("UPDATE");
        btnUpdate.addActionListener(this::btnUpdateActionPerformed);

        tblSupplier.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID ", "Supplier Name", "Phone Number", "Email", "Address"
            }
        ));
        tblSupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSupplierMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblSupplier);

        btnDelete.setText("DELETE");
        btnDelete.addActionListener(this::btnDeleteActionPerformed);

        javax.swing.GroupLayout pnlUpdateLayout = new javax.swing.GroupLayout(pnlUpdate);
        pnlUpdate.setLayout(pnlUpdateLayout);
        pnlUpdateLayout.setHorizontalGroup(
            pnlUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUpdateLayout.createSequentialGroup()
                .addGroup(pnlUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlUpdateLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(pnlUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlUpdateLayout.createSequentialGroup()
                                .addGroup(pnlUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtUpdatePhone, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtUpdateName, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnlUpdateLayout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtUpdateID, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlUpdateLayout.createSequentialGroup()
                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlUpdateLayout.createSequentialGroup()
                                .addGroup(pnlUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtUpdateEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane5)))
                    .addGroup(pnlUpdateLayout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(lblFormtitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        pnlUpdateLayout.setVerticalGroup(
            pnlUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUpdateLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lblFormtitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUpdateID, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUpdateName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUpdatePhone, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUpdateEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pnlContent.add(pnlUpdate, "card4");

        lblFormtitle2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblFormtitle2.setText("VIEW HISTORY");

        tbHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Supplier Name", "Phone NUmber", "Email", "Address"
            }
        ));
        jScrollPane6.setViewportView(tbHistory);

        javax.swing.GroupLayout pnlHistoryLayout = new javax.swing.GroupLayout(pnlHistory);
        pnlHistory.setLayout(pnlHistoryLayout);
        pnlHistoryLayout.setHorizontalGroup(
            pnlHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHistoryLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(pnlHistoryLayout.createSequentialGroup()
                .addGap(225, 225, 225)
                .addComponent(lblFormtitle2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlHistoryLayout.setVerticalGroup(
            pnlHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHistoryLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblFormtitle2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pnlContent.add(pnlHistory, "card5");

        lblFormtitle3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblFormtitle3.setText("CREATE PURCHASE ORDER");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel13.setText("PURCHASE ORDER ID  :");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel14.setText("SUPPLIER ID                 :");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel15.setText("SUPPLIER NAME          :");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel16.setText("ITEM NAME                  :");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel17.setText("UNIT PRICE (RM)          :");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel18.setText("TOTAL AMOUNT          :");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel19.setText("ORDER DATE                 :");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel20.setText("QUANTITY                    :");

        txtPOID.addActionListener(this::txtPOIDActionPerformed);

        cmbSupplierID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbSupplierID.addActionListener(this::cmbSupplierIDActionPerformed);

        txtSupplierNamePO.addActionListener(this::txtSupplierNamePOActionPerformed);

        cmbItemName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbItemName.addActionListener(this::cmbItemNameActionPerformed);

        txtQuantity.addActionListener(this::txtQuantityActionPerformed);

        txtPrice.addActionListener(this::txtPriceActionPerformed);

        txtTotal.addActionListener(this::txtTotalActionPerformed);

        txtOrderDate.addActionListener(this::txtOrderDateActionPerformed);

        btnCalculate.setText("CALCULATE");
        btnCalculate.addActionListener(this::btnCalculateActionPerformed);

        btnSavePO.setText("SAVE ");
        btnSavePO.addActionListener(this::btnSavePOActionPerformed);

        btnClearPO.setText("CLEAR");
        btnClearPO.addActionListener(this::btnClearPOActionPerformed);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PO ID", "Supplier", "Item", "Quantity", "Price", "Total", "Date"
            }
        ));
        jScrollPane8.setViewportView(jTable3);

        javax.swing.GroupLayout pnlPurchaseOrderLayout = new javax.swing.GroupLayout(pnlPurchaseOrder);
        pnlPurchaseOrder.setLayout(pnlPurchaseOrderLayout);
        pnlPurchaseOrderLayout.setHorizontalGroup(
            pnlPurchaseOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPurchaseOrderLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(pnlPurchaseOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlPurchaseOrderLayout.createSequentialGroup()
                        .addGroup(pnlPurchaseOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlPurchaseOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtTotal, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPrice, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtQuantity, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbItemName, javax.swing.GroupLayout.Alignment.LEADING, 0, 312, Short.MAX_VALUE)
                            .addComponent(txtSupplierNamePO, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbSupplierID, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtOrderDate)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlPurchaseOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblFormtitle3, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(pnlPurchaseOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtPOID, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pnlPurchaseOrderLayout.createSequentialGroup()
                                        .addComponent(btnSavePO, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnClearPO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCalculate)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlPurchaseOrderLayout.setVerticalGroup(
            pnlPurchaseOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPurchaseOrderLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblFormtitle3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlPurchaseOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtPOID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPurchaseOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(cmbSupplierID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPurchaseOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtSupplierNamePO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPurchaseOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(cmbItemName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPurchaseOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPurchaseOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPurchaseOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addGroup(pnlPurchaseOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCalculate)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPurchaseOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtOrderDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPurchaseOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSavePO)
                    .addComponent(btnClearPO))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pnlContent.add(pnlPurchaseOrder, "card6");

        lblFormtitle4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblFormtitle4.setText("DELETE PURCHASE ORDER");

        tblDeletePO.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "PO ID", "Supplier ID", "Supplier Name", "Item", "Quantity", "Price", "Total", "Date"
            }
        ));
        tblDeletePO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDeletePOMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(tblDeletePO);

        btnDeletePOpage2.setText("DELETE");
        btnDeletePOpage2.addActionListener(this::btnDeletePOpage2ActionPerformed);

        javax.swing.GroupLayout pnlDeletePOLayout = new javax.swing.GroupLayout(pnlDeletePO);
        pnlDeletePO.setLayout(pnlDeletePOLayout);
        pnlDeletePOLayout.setHorizontalGroup(
            pnlDeletePOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDeletePOLayout.createSequentialGroup()
                .addGroup(pnlDeletePOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDeletePOLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDeletePOLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnDeletePOpage2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(pnlDeletePOLayout.createSequentialGroup()
                .addGap(186, 186, 186)
                .addComponent(lblFormtitle4, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlDeletePOLayout.setVerticalGroup(
            pnlDeletePOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDeletePOLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblFormtitle4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDeletePOpage2)
                .addContainerGap(107, Short.MAX_VALUE))
        );

        pnlContent.add(pnlDeletePO, "card2");

        lblFormtitle10.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblFormtitle10.setText("SUPPLIER ID : ");

        lblFormtitle11.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblFormtitle11.setText("SUPPLIER NAME : ");

        lblFormtitle12.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblFormtitle12.setText("ITEM NAME : ");

        txtItemView.addActionListener(this::txtItemViewActionPerformed);

        lblFormtitle13.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblFormtitle13.setText("QUANTITY : ");

        lblFormtitle15.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblFormtitle15.setText("PRICE : ");

        lblFormtitle17.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblFormtitle17.setText("TOTAL AMOUNT : ");

        lblFormtitle19.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblFormtitle19.setText("ORDER DATE : ");

        btnClearViewPO.setText("CLEAR");
        btnClearViewPO.addActionListener(this::btnClearViewPOActionPerformed);

        lblFormtitle5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblFormtitle5.setText("VIEW PURCHASE ORDER");

        lblFormtitle21.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblFormtitle21.setText("PURCHASE ORDER ID : ");

        btnSearchPO.setText("SEARCH");
        btnSearchPO.addActionListener(this::btnSearchPOActionPerformed);

        javax.swing.GroupLayout pnlViewPO1Layout = new javax.swing.GroupLayout(pnlViewPO1);
        pnlViewPO1.setLayout(pnlViewPO1Layout);
        pnlViewPO1Layout.setHorizontalGroup(
            pnlViewPO1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlViewPO1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(pnlViewPO1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlViewPO1Layout.createSequentialGroup()
                        .addComponent(lblFormtitle17)
                        .addGap(30, 30, 30)
                        .addComponent(txtTotalView))
                    .addGroup(pnlViewPO1Layout.createSequentialGroup()
                        .addComponent(lblFormtitle15)
                        .addGap(88, 88, 88)
                        .addComponent(txtPriceView))
                    .addGroup(pnlViewPO1Layout.createSequentialGroup()
                        .addComponent(lblFormtitle19)
                        .addGap(50, 50, 50)
                        .addGroup(pnlViewPO1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlViewPO1Layout.createSequentialGroup()
                                .addComponent(btnClearViewPO)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtDateView)))
                    .addGroup(pnlViewPO1Layout.createSequentialGroup()
                        .addGroup(pnlViewPO1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFormtitle10)
                            .addComponent(lblFormtitle11)
                            .addComponent(lblFormtitle12)
                            .addComponent(lblFormtitle13))
                        .addGap(32, 32, 32)
                        .addGroup(pnlViewPO1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtQuantityView)
                            .addComponent(txtItemView)
                            .addComponent(txtSupplierNameView)
                            .addGroup(pnlViewPO1Layout.createSequentialGroup()
                                .addComponent(txtSupplierIDView, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(59, 59, 59))
            .addGroup(pnlViewPO1Layout.createSequentialGroup()
                .addGroup(pnlViewPO1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlViewPO1Layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(lblFormtitle5, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlViewPO1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(lblFormtitle21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearchPOID, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearchPO)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlViewPO1Layout.setVerticalGroup(
            pnlViewPO1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlViewPO1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblFormtitle5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlViewPO1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFormtitle21, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearchPOID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchPO))
                .addGap(18, 18, 18)
                .addGroup(pnlViewPO1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblFormtitle10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSupplierIDView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlViewPO1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFormtitle11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSupplierNameView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlViewPO1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFormtitle12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtItemView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlViewPO1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFormtitle13, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtQuantityView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlViewPO1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFormtitle15, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPriceView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlViewPO1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFormtitle17, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotalView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlViewPO1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFormtitle19, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDateView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnClearViewPO)
                .addContainerGap(67, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlViewPOLayout = new javax.swing.GroupLayout(pnlViewPO);
        pnlViewPO.setLayout(pnlViewPOLayout);
        pnlViewPOLayout.setHorizontalGroup(
            pnlViewPOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlViewPOLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(pnlViewPO1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlViewPOLayout.setVerticalGroup(
            pnlViewPOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlViewPOLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(pnlViewPO1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pnlContent.add(pnlViewPO, "card7");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlContent, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        pnlRegister.setVisible(true);
        pnlUpdate.setVisible(false);
        pnlHistory.setVisible(false);
        pnlPurchaseOrder.setVisible(false);
        pnlDeletePO.setVisible(false);
        pnlViewPO.setVisible(false);
        
        
        

   
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void btnUpdateSuppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateSuppActionPerformed
        pnlRegister.setVisible(false);
        pnlUpdate.setVisible(true);
        pnlHistory.setVisible(false);
        pnlPurchaseOrder.setVisible(false);
        pnlDeletePO.setVisible(false);
      pnlViewPO.setVisible(false);

        loadSupplierData();
    }//GEN-LAST:event_btnUpdateSuppActionPerformed

    private void btnCreatePOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreatePOActionPerformed
        pnlRegister.setVisible(false);
        pnlUpdate.setVisible(false);
        pnlHistory.setVisible(false);
        pnlPurchaseOrder.setVisible(true);
        pnlDeletePO.setVisible(false);
        pnlViewPO.setVisible(false);

        loadPurchaseOrderData();
    }//GEN-LAST:event_btnCreatePOActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        pnlRegister.setVisible(false);
        pnlUpdate.setVisible(false);
        pnlHistory.setVisible(true);
        pnlPurchaseOrder.setVisible(false);
        pnlDeletePO.setVisible(false);
        pnlViewPO.setVisible(false);

        loadHistoryData();
    }//GEN-LAST:event_btnViewActionPerformed

    private void btnDeletePOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletePOActionPerformed
        pnlRegister.setVisible(false);
        pnlUpdate.setVisible(false);
        pnlHistory.setVisible(false);
        pnlPurchaseOrder.setVisible(false);
        pnlDeletePO.setVisible(true);
        pnlViewPO.setVisible(false);

        loadDeletePOData();
    }//GEN-LAST:event_btnDeletePOActionPerformed

    private void btnViewPOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewPOActionPerformed
       pnlRegister.setVisible(false);
        pnlUpdate.setVisible(false);
        pnlHistory.setVisible(false);
       pnlPurchaseOrder.setVisible(false);
       pnlDeletePO.setVisible(false);
        pnlViewPO.setVisible(true);
    }//GEN-LAST:event_btnViewPOActionPerformed

    private void txtPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhoneActionPerformed

    private void txtSupplierIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSupplierIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSupplierIDActionPerformed

    private void txtUpdateIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUpdateIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUpdateIDActionPerformed

    private void txtUpdateNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUpdateNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUpdateNameActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        

    try {

        Connection con =
                DBConnection.getConnection();

        String sql =
                "UPDATE suppliers " +
                "SET supplier_name=?, phone=?, email=?, address=? " +
                "WHERE supplier_id=?";

        PreparedStatement ps =
                con.prepareStatement(sql);

        ps.setString(1, txtUpdateName.getText());
        ps.setString(2, txtUpdatePhone.getText());
        ps.setString(3, txtUpdateEmail.getText());
        ps.setString(4, txtUpdateAddress.getText());
        ps.setString(5, txtUpdateID.getText());

        int result = ps.executeUpdate();

        if(result > 0){

            JOptionPane.showMessageDialog(
                    this,
                    "Supplier Updated Successfully!");

            loadSupplierData();

        } else {

            JOptionPane.showMessageDialog(
                    this,
                    "Supplier Not Found!");
        }

    } catch(Exception e){

        JOptionPane.showMessageDialog(
                this,
                e.getMessage());
    }

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        

    try {

        Connection con = DBConnection.getConnection();

        if(con == null) {

            JOptionPane.showMessageDialog(
                    this,
                    "Database connection failed!");

            return;
        }

        // Check empty fields
        if(txtSupplierID.getText().trim().isEmpty()
                || txtSupplierName.getText().trim().isEmpty()
                || txtPhone.getText().trim().isEmpty()
                || txtEmail.getText().trim().isEmpty()
                || txtAddress.getText().trim().isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please fill in all fields!");

            return;
        }

        // Check duplicate Supplier ID
        String checkSQL =
                "SELECT supplier_id FROM suppliers WHERE supplier_id=?";

        PreparedStatement checkPS =
                con.prepareStatement(checkSQL);

        checkPS.setString(
                1,
                txtSupplierID.getText().trim());

        ResultSet rs =
                checkPS.executeQuery();

        if(rs.next()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Supplier ID already exists!",
                    "Duplicate ID",
                    JOptionPane.WARNING_MESSAGE);

            rs.close();
            checkPS.close();
            con.close();

            return;
        }

        // Insert supplier
        String sql =
                "INSERT INTO suppliers "
                + "(supplier_id, supplier_name, phone, email, address) "
                + "VALUES (?, ?, ?, ?, ?)";

        PreparedStatement ps =
                con.prepareStatement(sql);

        ps.setString(
                1,
                txtSupplierID.getText().trim());

        ps.setString(
                2,
                txtSupplierName.getText().trim());

        ps.setString(
                3,
                txtPhone.getText().trim());

        ps.setString(
                4,
                txtEmail.getText().trim());

        ps.setString(
                5,
                txtAddress.getText().trim());

        int result =
                ps.executeUpdate();

        if(result > 0) {

            JOptionPane.showMessageDialog(
                    this,
                    "Supplier Saved Successfully!");

            loadSupplierData();
            loadSupplierIDs();

            // Clear fields
            txtSupplierID.setText("");
            txtSupplierName.setText("");
            txtPhone.setText("");
            txtEmail.setText("");
            txtAddress.setText("");
        }

        rs.close();
        checkPS.close();
        ps.close();
        con.close();

    } catch(Exception e) {

        JOptionPane.showMessageDialog(
                this,
                e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
    }

    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        txtSupplierID.setText("");
        txtSupplierName.setText("");
        txtPhone.setText("");
        txtEmail.setText("");
        txtAddress.setText("");
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        

    try {

        Connection con =
                DBConnection.getConnection();

        String sql =
                "DELETE FROM suppliers WHERE supplier_id=?";

        PreparedStatement ps =
                con.prepareStatement(sql);

        ps.setString(1,
                txtUpdateID.getText());

        int confirm =
                JOptionPane.showConfirmDialog(
                        this,
                        "Delete this supplier?",
                        "Confirm",
                        JOptionPane.YES_NO_OPTION);

        if(confirm == JOptionPane.YES_OPTION){

            ps.executeUpdate();

            JOptionPane.showMessageDialog(
                    this,
                    "Supplier Deleted Successfully!");

            loadSupplierData();
        }

    } catch(Exception e){

        JOptionPane.showMessageDialog(
                this,
                e.getMessage());
    }


    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tblSupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSupplierMouseClicked
        int row = tblSupplier.getSelectedRow();

        txtUpdateID.setText(tblSupplier.getValueAt(row, 0).toString());
        txtUpdateName.setText(tblSupplier.getValueAt(row, 1).toString());
        txtUpdatePhone.setText(tblSupplier.getValueAt(row, 2).toString());
        txtUpdateEmail.setText(tblSupplier.getValueAt(row, 3).toString());
        txtUpdateAddress.setText(tblSupplier.getValueAt(row, 4).toString());
    }//GEN-LAST:event_tblSupplierMouseClicked

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        Dashboard dashboard = new Dashboard();
        dashboard.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnClearPOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearPOActionPerformed
        

    txtPOID.setText("");
    txtQuantity.setText("");
    txtPrice.setText("");
    txtTotal.setText("");

    txtOrderDate.setText(
     java.time.LocalDate.now().toString());

    }//GEN-LAST:event_btnClearPOActionPerformed

    private void txtPOIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPOIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPOIDActionPerformed

    private void cmbSupplierIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSupplierIDActionPerformed
       
    try {

        if(cmbSupplierID.getSelectedItem() == null){
            return;
        }

        Connection con =
                DBConnection.getConnection();

        String sql =
                "SELECT supplier_name " +
                "FROM suppliers " +
                "WHERE supplier_id=?";

        PreparedStatement ps =
                con.prepareStatement(sql);

        ps.setString(
                1,
                cmbSupplierID.getSelectedItem().toString());

        ResultSet rs =
                ps.executeQuery();

        if(rs.next()) {

            txtSupplierNamePO.setText(
                    rs.getString("supplier_name"));
        }

    } catch(Exception e) {

        JOptionPane.showMessageDialog(
                this,
                e.getMessage());
    }

    }//GEN-LAST:event_cmbSupplierIDActionPerformed

    private void txtSupplierNamePOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSupplierNamePOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSupplierNamePOActionPerformed

    private void cmbItemNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbItemNameActionPerformed
            
     
    if (cmbItemName.getSelectedItem() == null) {
        return;
    }

    String item =
            cmbItemName.getSelectedItem().toString();

    switch(item) {

        case "Laptop":
            txtPrice.setText("2500");
            break;

        case "Desktop PC":
            txtPrice.setText("3500");
            break;

        case "Monitor":
            txtPrice.setText("800");
            break;

        case "Keyboard":
            txtPrice.setText("120");
            break;

        case "Mouse":
            txtPrice.setText("60");
            break;

        case "Printer":
            txtPrice.setText("650");
            break;

        case "SSD":
            txtPrice.setText("350");
            break;

        case "RAM":
            txtPrice.setText("280");
            break;
    }

        

    }//GEN-LAST:event_cmbItemNameActionPerformed

    private void txtQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuantityActionPerformed

    private void txtPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPriceActionPerformed

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed

    private void txtOrderDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOrderDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOrderDateActionPerformed

    private void btnCalculateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalculateActionPerformed
 
    try {

        int qty =
                Integer.parseInt(
                        txtQuantity.getText());

        double price =
                Double.parseDouble(
                        txtPrice.getText());

        double total = qty * price;

        txtTotal.setText(
                String.format("%.2f", total));

    } catch (NumberFormatException e) {

        JOptionPane.showMessageDialog(this,
                "Please enter valid numeric values.",
                "Input Error",
                JOptionPane.ERROR_MESSAGE);

    } catch (Exception e) {

        JOptionPane.showMessageDialog(this,
                e.getMessage());
    }


    }//GEN-LAST:event_btnCalculateActionPerformed

    private void btnSavePOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSavePOActionPerformed
        
    try {

        Connection con = DBConnection.getConnection();

        if(con == null) {

            JOptionPane.showMessageDialog(
                    this,
                    "Database connection failed!");

            return;
        }

        // Check empty fields
        if(txtPOID.getText().trim().isEmpty()
                || txtQuantity.getText().trim().isEmpty()
                || txtPrice.getText().trim().isEmpty()
                || txtTotal.getText().trim().isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please fill in all fields!");

            return;
        }

        // Check duplicate PO ID
        String checkSQL =
                "SELECT po_id FROM purchase_orders WHERE po_id=?";

        PreparedStatement checkPS =
                con.prepareStatement(checkSQL);

        checkPS.setString(
                1,
                txtPOID.getText().trim());

        ResultSet rs =
                checkPS.executeQuery();

        if(rs.next()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Purchase Order ID already exists!",
                    "Duplicate PO ID",
                    JOptionPane.WARNING_MESSAGE);

            rs.close();
            checkPS.close();
            con.close();

            return;
        }

        // Insert Purchase Order
        String sql =
                "INSERT INTO purchase_orders "
                + "(po_id, supplier_id, supplier_name, item_name, "
                + "quantity, price, total, order_date) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement ps =
                con.prepareStatement(sql);

        ps.setString(
                1,
                txtPOID.getText().trim());

        ps.setString(
                2,
                cmbSupplierID.getSelectedItem().toString());

        ps.setString(
                3,
                txtSupplierNamePO.getText().trim());

        ps.setString(
                4,
                cmbItemName.getSelectedItem().toString());

        ps.setInt(
                5,
                Integer.parseInt(
                        txtQuantity.getText().trim()));

        ps.setDouble(
                6,
                Double.parseDouble(
                        txtPrice.getText().trim()));

        ps.setDouble(
                7,
                Double.parseDouble(
                        txtTotal.getText().trim()));

        ps.setDate(
                8,
                java.sql.Date.valueOf(
                        txtOrderDate.getText().trim()));

        int result =
                ps.executeUpdate();

        if(result > 0) {

            JOptionPane.showMessageDialog(
                    this,
                    "Purchase Order Saved Successfully!");

            loadPurchaseOrderData();
            loadDeletePOData();

            // Clear fields
            txtPOID.setText("");
            txtQuantity.setText("");
            txtPrice.setText("");
            txtTotal.setText("");
        }

        rs.close();
        checkPS.close();
        ps.close();
        con.close();

    } catch(NumberFormatException e) {

        JOptionPane.showMessageDialog(
                this,
                "Quantity, Price or Total contains invalid numbers!");

    } catch(Exception e) {

        JOptionPane.showMessageDialog(
                this,
                e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
    }


    }//GEN-LAST:event_btnSavePOActionPerformed

    private void tblDeletePOMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDeletePOMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblDeletePOMouseClicked

    private void btnDeletePOpage2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletePOpage2ActionPerformed
       

    int row =
            tblDeletePO.getSelectedRow();

    if(row == -1){

        JOptionPane.showMessageDialog(
                this,
                "Please select a Purchase Order.");
        return;
    }

    try {

        String poID =
                tblDeletePO.getValueAt(
                        row,
                        0).toString();

        Connection con =
                DBConnection.getConnection();

        String sql =
                "DELETE FROM purchase_orders "
                + "WHERE po_id=?";

        PreparedStatement ps =
                con.prepareStatement(sql);

        ps.setString(1, poID);

        int confirm =
                JOptionPane.showConfirmDialog(
                        this,
                        "Delete PO " + poID + "?",
                        "Confirm",
                        JOptionPane.YES_NO_OPTION);

        if(confirm == JOptionPane.YES_OPTION){

            ps.executeUpdate();

            JOptionPane.showMessageDialog(
                    this,
                    "Purchase Order Deleted!");

            loadDeletePOData();
            loadPurchaseOrderData();
        }

        ps.close();
        con.close();

    } catch(Exception e){

        JOptionPane.showMessageDialog(
                this,
                e.getMessage());
    }

    }//GEN-LAST:event_btnDeletePOpage2ActionPerformed

    private void btnSearchPOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchPOActionPerformed
       

    

    try {

        Connection con =
                DBConnection.getConnection();

        String sql =
                "SELECT * FROM purchase_orders "
                + "WHERE po_id=?";

        PreparedStatement ps =
                con.prepareStatement(sql);

        ps.setString(
                1,
                txtSearchPOID.getText());

        ResultSet rs =
                ps.executeQuery();

        if(rs.next()) {

            txtSupplierIDView.setText(
                    rs.getString("supplier_id"));

            txtSupplierNameView.setText(
                    rs.getString("supplier_name"));

            txtItemView.setText(
                    rs.getString("item_name"));

            txtQuantityView.setText(
                    rs.getString("quantity"));

            txtPriceView.setText(
                    rs.getString("price"));

            txtTotalView.setText(
                    rs.getString("total"));

            txtDateView.setText(
                    rs.getString("order_date"));

        } else {

            JOptionPane.showMessageDialog(
                    this,
                    "Purchase Order Not Found!");
        }

        rs.close();
        ps.close();
        con.close();

    } catch(Exception e){

        JOptionPane.showMessageDialog(
                this,
                e.getMessage());
    }

    }//GEN-LAST:event_btnSearchPOActionPerformed

    private void btnClearViewPOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearViewPOActionPerformed
        txtSearchPOID.setText("");

        txtSupplierIDView.setText("");
        txtSupplierNameView.setText("");
        txtItemView.setText("");
        txtQuantityView.setText("");
        txtPriceView.setText("");
        txtTotalView.setText("");
        txtDateView.setText("");
    }//GEN-LAST:event_btnClearViewPOActionPerformed

    private void txtItemViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtItemViewActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtItemViewActionPerformed

  
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(() -> new SupplierFrame().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCalculate;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnClearPO;
    private javax.swing.JButton btnClearViewPO;
    private javax.swing.JButton btnCreatePO;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDeletePO;
    private javax.swing.JButton btnDeletePOpage2;
    private javax.swing.JButton btnRegister;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSavePO;
    private javax.swing.JButton btnSearchPO;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnUpdateSupp;
    private javax.swing.JButton btnView;
    private javax.swing.JButton btnViewPO;
    private javax.swing.JComboBox<String> cmbItemName;
    private javax.swing.JComboBox<String> cmbSupplierID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JLabel lblFormtitle;
    private javax.swing.JLabel lblFormtitle1;
    private javax.swing.JLabel lblFormtitle10;
    private javax.swing.JLabel lblFormtitle11;
    private javax.swing.JLabel lblFormtitle12;
    private javax.swing.JLabel lblFormtitle13;
    private javax.swing.JLabel lblFormtitle14;
    private javax.swing.JLabel lblFormtitle15;
    private javax.swing.JLabel lblFormtitle16;
    private javax.swing.JLabel lblFormtitle17;
    private javax.swing.JLabel lblFormtitle18;
    private javax.swing.JLabel lblFormtitle19;
    private javax.swing.JLabel lblFormtitle2;
    private javax.swing.JLabel lblFormtitle20;
    private javax.swing.JLabel lblFormtitle21;
    private javax.swing.JLabel lblFormtitle3;
    private javax.swing.JLabel lblFormtitle4;
    private javax.swing.JLabel lblFormtitle5;
    private javax.swing.JLabel lblFormtitle7;
    private javax.swing.JPanel pnlContent;
    private javax.swing.JPanel pnlDeletePO;
    private javax.swing.JPanel pnlHistory;
    private javax.swing.JPanel pnlPurchaseOrder;
    private javax.swing.JPanel pnlRegister;
    private javax.swing.JPanel pnlUpdate;
    private javax.swing.JPanel pnlViewPO;
    private javax.swing.JPanel pnlViewPO1;
    private javax.swing.JTable tbHistory;
    private javax.swing.JTable tblDeletePO;
    private javax.swing.JTable tblSupplier;
    private javax.swing.JTextArea txtAddress;
    private javax.swing.JTextArea txtAddress1;
    private javax.swing.JTextField txtDateView;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtItemView;
    private javax.swing.JTextField txtOrderDate;
    private javax.swing.JTextField txtPOID;
    private javax.swing.JTextField txtPOID1;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtPriceView;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtQuantityView;
    private javax.swing.JTextField txtQuantityView1;
    private javax.swing.JTextField txtSearchPOID;
    private javax.swing.JTextField txtSupplierID;
    private javax.swing.JTextField txtSupplierIDView;
    private javax.swing.JTextField txtSupplierName;
    private javax.swing.JTextField txtSupplierName1;
    private javax.swing.JTextField txtSupplierNamePO;
    private javax.swing.JTextField txtSupplierNamePO1;
    private javax.swing.JTextField txtSupplierNameView;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtTotalView;
    private javax.swing.JTextField txtTotalView1;
    private javax.swing.JTextArea txtUpdateAddress;
    private javax.swing.JTextField txtUpdateEmail;
    private javax.swing.JTextField txtUpdateID;
    private javax.swing.JTextField txtUpdateName;
    private javax.swing.JTextField txtUpdatePhone;
    // End of variables declaration//GEN-END:variables
}
