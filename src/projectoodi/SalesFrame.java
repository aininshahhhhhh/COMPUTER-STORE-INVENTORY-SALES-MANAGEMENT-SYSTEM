
package projectoodi;

import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

  

    
    public class SalesFrame extends javax.swing.JFrame {
        private String role;

        public SalesFrame() {
            this("Customer");
        }

    public SalesFrame(String role) {

        this.role = role;

        initComponents();
        quantityCheckoutText.setEditable(true);

        createOrderFile();

        loadViewData();
        loadDeleteProduct();
        loadProducts();

        // LOAD PRODUCTS FROM DATABASE TO CHECKOUT COMBOBOX
        loadProductComboBox();

        PnlView.setVisible(true);
        PnlAddItems.setVisible(false);
        PnlCheckout.setVisible(false);
        pnlRemovecart.setVisible(false);
        PnlSalesView.setVisible(false);
    }
 
        
      private void loadProductComboBox() {

        cbSelectProduct1.removeAllItems();

        String url = "jdbc:mysql://localhost:3306/computerstore";
        String username = "root";
        String password = "";

        String query = "SELECT product_name FROM products";

        try {

            java.sql.Connection conn =
                    java.sql.DriverManager.getConnection(
                            url, username, password);

            java.sql.PreparedStatement pst =
                    conn.prepareStatement(query);

            java.sql.ResultSet rs =
                    pst.executeQuery();

            while (rs.next()) {

                cbSelectProduct1.addItem(
                        rs.getString("product_name"));
            }

            rs.close();
            pst.close();
            conn.close();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Error loading products:\n"
                    + e.getMessage());
        }
    }   
            private void loadViewData() {

        try {

            DefaultTableModel model =
                    (DefaultTableModel) tblView.getModel();

            model.setRowCount(0);

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader("order.txt"));

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length >= 4) {

                    model.addRow(new Object[]{
                        data[0],
                        data[1],
                        data[2],
                        data[3]
                    });
                }
            }

            reader.close();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    this,
                    e.getMessage());
        }
    }

        private void loadSalesData() {

        try {

            DefaultTableModel model =
                    (DefaultTableModel) tblSales.getModel();

            model.setRowCount(0);

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader("order.txt"));

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length >= 6) {

                    model.addRow(new Object[]{
                        data[0],
                        data[1],
                        data[2],
                        data[3],
                        data[4],
                        data[5],
                    });
                }
            }

            reader.close();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    this,
                    e.getMessage());
        }
    }
        
        private void loadDeleteProduct() {

            try {

                DefaultTableModel model
                        = (DefaultTableModel) tblRemove.getModel();

                model.setRowCount(0);

                try (BufferedReader reader = new BufferedReader(
                        new FileReader("order.txt"))) {
                    String line;

                    while ((line = reader.readLine()) != null) {

                        String[] data = line.split(",");

                        if (data.length >= 4) {
                            model.addRow(data);
                        }
                    }
                }

            } catch (IOException e) {

                JOptionPane.showMessageDialog(this,
                        e.getMessage());
            }
        }

       
        private void createOrderFile() {

            try {

                File file = new File("order.txt");

                if (!file.exists()) {
                    file.createNewFile();
                }

            } catch (Exception e) {

                JOptionPane.showMessageDialog(
                        this,
                        e.getMessage());
            }
        }
        
        private void loadProducts() {

        try {

            cbSelectProduct.removeAllItems();

            File file = new File("product.txt");

            if (!file.exists()) {

                file.createNewFile();

                return;
            }

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader(file));

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length >= 3) {

                    cbSelectProduct.addItem(data[1]);
                    
                }
            }

            reader.close();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    this,
                    e.getMessage());
        }
    }
       
        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        productID2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        AddItems = new javax.swing.JButton();
        ViewCart = new javax.swing.JButton();
        Checkout = new javax.swing.JButton();
        Back = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        remove = new javax.swing.JButton();
        Salesview = new javax.swing.JButton();
        jPanelContent = new javax.swing.JPanel();
        PnlAddItems = new javax.swing.JPanel();
        addItemsProduct = new javax.swing.JLabel();
        productID = new javax.swing.JLabel();
        price = new javax.swing.JLabel();
        quantity = new javax.swing.JLabel();
        priceText = new javax.swing.JTextField();
        quantityText = new javax.swing.JTextField();
        addtocartButton = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        cbSelectProduct = new javax.swing.JComboBox<>();
        productID1 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        productID3 = new javax.swing.JLabel();
        txtNameCustomer = new javax.swing.JTextField();
        PnlView = new javax.swing.JPanel();
        viewCartProduct = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblView = new javax.swing.JTable();
        PnlCheckout = new javax.swing.JPanel();
        checkoutProduct = new javax.swing.JLabel();
        customerDetails = new javax.swing.JPanel();
        customerInfo = new javax.swing.JLabel();
        nameCheckout = new javax.swing.JLabel();
        noPhoneCheckout = new javax.swing.JLabel();
        addressCheckout = new javax.swing.JLabel();
        nameCheckoutText = new javax.swing.JTextField();
        nophoneCheckoutText = new javax.swing.JTextField();
        addressCheckoutText = new javax.swing.JTextField();
        paymentMethod = new javax.swing.JPanel();
        paymentCheckout = new javax.swing.JLabel();
        fpxPayment = new javax.swing.JButton();
        cashMethod = new javax.swing.JPanel();
        cashCheckout = new javax.swing.JLabel();
        cashInput = new javax.swing.JLabel();
        paidAmount = new javax.swing.JLabel();
        changeAmount = new javax.swing.JLabel();
        cashText = new javax.swing.JTextField();
        paidamountText = new javax.swing.JTextField();
        changeText = new javax.swing.JTextField();
        calculateCashButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        paymentsummaryCheckout = new javax.swing.JPanel();
        paymentSummary = new javax.swing.JLabel();
        quantityCheckout = new javax.swing.JLabel();
        priceCheckout = new javax.swing.JLabel();
        totalCheckout = new javax.swing.JLabel();
        quantityCheckoutText = new javax.swing.JTextField();
        PriceText = new javax.swing.JTextField();
        grandtotalText = new javax.swing.JTextField();
        calculatePayment = new javax.swing.JButton();
        productID4 = new javax.swing.JLabel();
        cbSelectProduct1 = new javax.swing.JComboBox<>();
        productID5 = new javax.swing.JLabel();
        txtID1 = new javax.swing.JTextField();
        doneCheckoutButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        pnlRemovecart = new javax.swing.JPanel();
        lblFormtitle4 = new javax.swing.JLabel();
        deleteProductBtn = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblRemove = new javax.swing.JTable();
        PnlSalesView = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblSales = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        productID2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        productID2.setText("Select Product          :");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("SALES MANAGEMENT");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(280, 280, 280))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(153, 255, 153));

        AddItems.setText("Add Items");
        AddItems.addActionListener(this::AddItemsActionPerformed);

        ViewCart.setText("View Cart");
        ViewCart.addActionListener(this::ViewCartActionPerformed);

        Checkout.setText("Checkout");
        Checkout.addActionListener(this::CheckoutActionPerformed);

        Back.setText("Back");
        Back.addActionListener(this::BackActionPerformed);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("MENU");

        remove.setText("Remove Cart");
        remove.addActionListener(this::removeActionPerformed);

        Salesview.setText("Sales View");
        Salesview.addActionListener(this::SalesviewActionPerformed);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(Back)
                            .addComponent(AddItems, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ViewCart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Salesview, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(remove, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Checkout, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))
                                .addGap(2, 2, 2)))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(AddItems)
                .addGap(18, 18, 18)
                .addComponent(ViewCart)
                .addGap(18, 18, 18)
                .addComponent(remove)
                .addGap(18, 18, 18)
                .addComponent(Checkout)
                .addGap(18, 18, 18)
                .addComponent(Salesview)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Back)
                .addGap(15, 15, 15))
        );

        jPanelContent.setLayout(new java.awt.CardLayout());

        PnlAddItems.setBackground(new java.awt.Color(204, 255, 204));

        addItemsProduct.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        addItemsProduct.setText("ADD ITEMS PRODUCT");

        productID.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        productID.setText("Select Product          :");

        price.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        price.setText("Quantity Buy           :");

        quantity.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        quantity.setText("Price                          :");

        priceText.addActionListener(this::priceTextActionPerformed);

        quantityText.addActionListener(this::quantityTextActionPerformed);

        addtocartButton.setText("Add to Cart");
        addtocartButton.addActionListener(this::addtocartButtonActionPerformed);

        clear.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        clear.setText("CLEAR");
        clear.addActionListener(this::clearActionPerformed);

        cbSelectProduct.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbSelectProduct.addActionListener(this::cbSelectProductActionPerformed);

        productID1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        productID1.setText("ID                               :");

        txtID.addActionListener(this::txtIDActionPerformed);

        productID3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        productID3.setText("Name                        :");

        txtNameCustomer.addActionListener(this::txtNameCustomerActionPerformed);

        javax.swing.GroupLayout PnlAddItemsLayout = new javax.swing.GroupLayout(PnlAddItems);
        PnlAddItems.setLayout(PnlAddItemsLayout);
        PnlAddItemsLayout.setHorizontalGroup(
            PnlAddItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlAddItemsLayout.createSequentialGroup()
                .addGap(227, 227, 227)
                .addComponent(addItemsProduct)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PnlAddItemsLayout.createSequentialGroup()
                .addGroup(PnlAddItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PnlAddItemsLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(PnlAddItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(price, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(quantity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(productID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(productID1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(productID3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(23, 23, 23)
                        .addGroup(PnlAddItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(quantityText, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbSelectProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNameCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(priceText, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 127, Short.MAX_VALUE))
                    .addGroup(PnlAddItemsLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(PnlAddItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addtocartButton))))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        PnlAddItemsLayout.setVerticalGroup(
            PnlAddItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlAddItemsLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(addItemsProduct)
                .addGap(12, 12, 12)
                .addGroup(PnlAddItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(productID1)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(PnlAddItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(productID3)
                    .addComponent(txtNameCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PnlAddItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbSelectProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(productID))
                .addGap(18, 18, 18)
                .addGroup(PnlAddItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quantity)
                    .addComponent(quantityText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PnlAddItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(price)
                    .addComponent(priceText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70)
                .addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addtocartButton)
                .addGap(80, 80, 80))
        );

        jPanelContent.add(PnlAddItems, "card3");

        PnlView.setBackground(new java.awt.Color(204, 255, 204));

        viewCartProduct.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        viewCartProduct.setText("View Cart Product");

        tblView.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "NAME", "PRICE", "QUANTITY"
            }
        ));
        jScrollPane2.setViewportView(tblView);
        if (tblView.getColumnModel().getColumnCount() > 0) {
            tblView.getColumnModel().getColumn(0).setResizable(false);
            tblView.getColumnModel().getColumn(0).setHeaderValue("ID");
        }

        javax.swing.GroupLayout PnlViewLayout = new javax.swing.GroupLayout(PnlView);
        PnlView.setLayout(PnlViewLayout);
        PnlViewLayout.setHorizontalGroup(
            PnlViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlViewLayout.createSequentialGroup()
                .addGap(255, 255, 255)
                .addComponent(viewCartProduct)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnlViewLayout.createSequentialGroup()
                .addContainerGap(105, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100))
        );
        PnlViewLayout.setVerticalGroup(
            PnlViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlViewLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(viewCartProduct)
                .addGap(32, 32, 32)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(98, Short.MAX_VALUE))
        );

        jPanelContent.add(PnlView, "card2");

        PnlCheckout.setBackground(new java.awt.Color(204, 255, 204));

        checkoutProduct.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        checkoutProduct.setText("CHECKOUT PRODUCT");

        customerDetails.setBackground(new java.awt.Color(0, 204, 51));

        customerInfo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        customerInfo.setText("CUSTOMER INFO");

        nameCheckout.setText("NAME          :");

        noPhoneCheckout.setText("NO PHONE  :");

        addressCheckout.setText("ADDRESS     :");

        nameCheckoutText.addActionListener(this::nameCheckoutTextActionPerformed);

        addressCheckoutText.addActionListener(this::addressCheckoutTextActionPerformed);

        javax.swing.GroupLayout customerDetailsLayout = new javax.swing.GroupLayout(customerDetails);
        customerDetails.setLayout(customerDetailsLayout);
        customerDetailsLayout.setHorizontalGroup(
            customerDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customerDetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(customerDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(customerInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(customerDetailsLayout.createSequentialGroup()
                        .addGroup(customerDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(nameCheckout, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(noPhoneCheckout, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addressCheckout, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(customerDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(nophoneCheckoutText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                            .addComponent(nameCheckoutText, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addressCheckoutText))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        customerDetailsLayout.setVerticalGroup(
            customerDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customerDetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(customerInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(customerDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameCheckout)
                    .addComponent(nameCheckoutText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(customerDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(noPhoneCheckout)
                    .addComponent(nophoneCheckoutText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(customerDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addressCheckout)
                    .addComponent(addressCheckoutText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        paymentMethod.setBackground(new java.awt.Color(0, 204, 51));

        paymentCheckout.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        paymentCheckout.setText("PAYMENT METHOD");

        fpxPayment.setText("FPX");
        fpxPayment.addActionListener(this::fpxPaymentActionPerformed);

        javax.swing.GroupLayout paymentMethodLayout = new javax.swing.GroupLayout(paymentMethod);
        paymentMethod.setLayout(paymentMethodLayout);
        paymentMethodLayout.setHorizontalGroup(
            paymentMethodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paymentMethodLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paymentMethodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paymentMethodLayout.createSequentialGroup()
                        .addComponent(paymentCheckout)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(fpxPayment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        paymentMethodLayout.setVerticalGroup(
            paymentMethodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paymentMethodLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(paymentCheckout)
                .addGap(18, 18, 18)
                .addComponent(fpxPayment)
                .addContainerGap(104, Short.MAX_VALUE))
        );

        cashMethod.setBackground(new java.awt.Color(0, 204, 51));

        cashCheckout.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cashCheckout.setText("CASH METHOD");

        cashInput.setText("Cash Input     :");

        paidAmount.setText("Paid Amount : ");

        changeAmount.setText("Change :");

        changeText.addActionListener(this::changeTextActionPerformed);

        calculateCashButton.setText("Calculate");
        calculateCashButton.addActionListener(this::calculateCashButtonActionPerformed);

        javax.swing.GroupLayout cashMethodLayout = new javax.swing.GroupLayout(cashMethod);
        cashMethod.setLayout(cashMethodLayout);
        cashMethodLayout.setHorizontalGroup(
            cashMethodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cashMethodLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cashMethodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cashMethodLayout.createSequentialGroup()
                        .addComponent(cashCheckout, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(cashMethodLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(cashMethodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(paidAmount, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                            .addComponent(cashInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(cashMethodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(paidamountText, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                            .addComponent(cashText))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                        .addGroup(cashMethodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(cashMethodLayout.createSequentialGroup()
                                .addComponent(changeAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(changeText, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(calculateCashButton, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(81, 81, 81))))
        );
        cashMethodLayout.setVerticalGroup(
            cashMethodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cashMethodLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cashCheckout)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(cashMethodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cashInput)
                    .addComponent(cashText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(calculateCashButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cashMethodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(paidAmount)
                    .addComponent(changeAmount)
                    .addComponent(paidamountText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(changeText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(this::cancelButtonActionPerformed);

        paymentsummaryCheckout.setBackground(new java.awt.Color(0, 204, 51));

        paymentSummary.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        paymentSummary.setText("PAYMENT SUMMARY");

        quantityCheckout.setText("Quantity                    :");

        priceCheckout.setText("Price                           :");

        totalCheckout.setText("Grand Total                :");

        quantityCheckoutText.addActionListener(this::quantityCheckoutTextActionPerformed);

        PriceText.addActionListener(this::PriceTextActionPerformed);

        grandtotalText.addActionListener(this::grandtotalTextActionPerformed);

        calculatePayment.setText("Calculate");
        calculatePayment.addActionListener(this::calculatePaymentActionPerformed);

        productID4.setText("Select Product          :");

        cbSelectProduct1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbSelectProduct1.addActionListener(this::cbSelectProduct1ActionPerformed);

        productID5.setText("ID                               :");

        txtID1.addActionListener(this::txtID1ActionPerformed);

        javax.swing.GroupLayout paymentsummaryCheckoutLayout = new javax.swing.GroupLayout(paymentsummaryCheckout);
        paymentsummaryCheckout.setLayout(paymentsummaryCheckoutLayout);
        paymentsummaryCheckoutLayout.setHorizontalGroup(
            paymentsummaryCheckoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paymentsummaryCheckoutLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paymentsummaryCheckoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paymentsummaryCheckoutLayout.createSequentialGroup()
                        .addComponent(quantityCheckout, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paymentsummaryCheckoutLayout.createSequentialGroup()
                        .addGroup(paymentsummaryCheckoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(paymentsummaryCheckoutLayout.createSequentialGroup()
                                .addComponent(paymentSummary)
                                .addGap(49, 49, 49)
                                .addComponent(calculatePayment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(paymentsummaryCheckoutLayout.createSequentialGroup()
                                .addGroup(paymentsummaryCheckoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(priceCheckout, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(productID4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(totalCheckout, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(paymentsummaryCheckoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(grandtotalText, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(paymentsummaryCheckoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(paymentsummaryCheckoutLayout.createSequentialGroup()
                                            .addGap(0, 0, Short.MAX_VALUE)
                                            .addComponent(cbSelectProduct1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(PriceText)
                                        .addComponent(quantityCheckoutText, javax.swing.GroupLayout.Alignment.LEADING))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, paymentsummaryCheckoutLayout.createSequentialGroup()
                                .addComponent(productID5, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtID1)))
                        .addGap(78, 78, 78)))
                .addContainerGap())
        );
        paymentsummaryCheckoutLayout.setVerticalGroup(
            paymentsummaryCheckoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paymentsummaryCheckoutLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paymentsummaryCheckoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(paymentSummary)
                    .addComponent(calculatePayment))
                .addGap(21, 21, 21)
                .addGroup(paymentsummaryCheckoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(productID4)
                    .addComponent(cbSelectProduct1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(paymentsummaryCheckoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(productID5)
                    .addComponent(txtID1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(paymentsummaryCheckoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quantityCheckout)
                    .addComponent(quantityCheckoutText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(paymentsummaryCheckoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(priceCheckout)
                    .addComponent(PriceText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(paymentsummaryCheckoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalCheckout)
                    .addComponent(grandtotalText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        doneCheckoutButton.setText("Done");
        doneCheckoutButton.addActionListener(this::doneCheckoutButtonActionPerformed);

        saveButton.setText("Save");
        saveButton.addActionListener(this::saveButtonActionPerformed);

        javax.swing.GroupLayout PnlCheckoutLayout = new javax.swing.GroupLayout(PnlCheckout);
        PnlCheckout.setLayout(PnlCheckoutLayout);
        PnlCheckoutLayout.setHorizontalGroup(
            PnlCheckoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlCheckoutLayout.createSequentialGroup()
                .addGap(279, 279, 279)
                .addComponent(checkoutProduct)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(PnlCheckoutLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PnlCheckoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PnlCheckoutLayout.createSequentialGroup()
                        .addGroup(PnlCheckoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cashMethod, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(PnlCheckoutLayout.createSequentialGroup()
                                .addGroup(PnlCheckoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(customerDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(paymentMethod, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(paymentsummaryCheckout, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(17, 17, 17))
                    .addGroup(PnlCheckoutLayout.createSequentialGroup()
                        .addComponent(saveButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cancelButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(doneCheckoutButton)
                        .addGap(60, 60, 60))))
        );
        PnlCheckoutLayout.setVerticalGroup(
            PnlCheckoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlCheckoutLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(checkoutProduct)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PnlCheckoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PnlCheckoutLayout.createSequentialGroup()
                        .addComponent(customerDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(paymentMethod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(paymentsummaryCheckout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cashMethod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PnlCheckoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(doneCheckoutButton)
                    .addComponent(saveButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelContent.add(PnlCheckout, "card5");

        lblFormtitle4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblFormtitle4.setText("REMOVE CART");

        deleteProductBtn.setText("DELETE");
        deleteProductBtn.addActionListener(this::deleteProductBtnActionPerformed);

        tblRemove.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "NAME", "PRICE", "QUANTITY"
            }
        ));
        tblRemove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRemoveMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblRemove);

        javax.swing.GroupLayout pnlRemovecartLayout = new javax.swing.GroupLayout(pnlRemovecart);
        pnlRemovecart.setLayout(pnlRemovecartLayout);
        pnlRemovecartLayout.setHorizontalGroup(
            pnlRemovecartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRemovecartLayout.createSequentialGroup()
                .addGroup(pnlRemovecartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRemovecartLayout.createSequentialGroup()
                        .addGap(414, 414, 414)
                        .addComponent(deleteProductBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlRemovecartLayout.createSequentialGroup()
                        .addGap(233, 233, 233)
                        .addComponent(lblFormtitle4, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnlRemovecartLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(86, Short.MAX_VALUE))
        );
        pnlRemovecartLayout.setVerticalGroup(
            pnlRemovecartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRemovecartLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblFormtitle4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                .addGap(79, 79, 79)
                .addComponent(deleteProductBtn)
                .addContainerGap())
        );

        jPanelContent.add(pnlRemovecart, "card5");

        tblSales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NAME", "NO PHONE", "ADDRESS", "PRICE", "QUANTITY", "GRAND TOTAL"
            }
        ));
        jScrollPane4.setViewportView(tblSales);
        if (tblSales.getColumnModel().getColumnCount() > 0) {
            tblSales.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel3.setText("SALES VIEW");

        javax.swing.GroupLayout PnlSalesViewLayout = new javax.swing.GroupLayout(PnlSalesView);
        PnlSalesView.setLayout(PnlSalesViewLayout);
        PnlSalesViewLayout.setHorizontalGroup(
            PnlSalesViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlSalesViewLayout.createSequentialGroup()
                .addGroup(PnlSalesViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PnlSalesViewLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PnlSalesViewLayout.createSequentialGroup()
                        .addGap(196, 196, 196)
                        .addComponent(jLabel3)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        PnlSalesViewLayout.setVerticalGroup(
            PnlSalesViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnlSalesViewLayout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        jPanelContent.add(PnlSalesView, "card6");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanelContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddItemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddItemsActionPerformed
        PnlView.setVisible(false);
        PnlAddItems.setVisible(true);
        PnlCheckout.setVisible(false);
        pnlRemovecart.setVisible(false);
        PnlSalesView.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_AddItemsActionPerformed

    private void ViewCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewCartActionPerformed
        PnlView.setVisible(true);
        PnlAddItems.setVisible(false);
        PnlCheckout.setVisible(false);
        pnlRemovecart.setVisible(false);
        PnlSalesView.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_ViewCartActionPerformed

    private void CheckoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckoutActionPerformed
        PnlView.setVisible(false);
        PnlAddItems.setVisible(false);
        PnlCheckout.setVisible(true);
        pnlRemovecart.setVisible(false);
        PnlSalesView.setVisible(false);// TODO add your handling code here:
    }//GEN-LAST:event_CheckoutActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        
    Dashboard dashboard = new Dashboard();
    dashboard.setVisible(true);

    this.dispose();

    }//GEN-LAST:event_BackActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        nameCheckoutText.setText("");
        nophoneCheckoutText.setText("");
        addressCheckoutText.setText("");
        quantityCheckoutText.setText("");
        PriceText.setText("");
        grandtotalText.setText(""); // TODO add your handling code here:
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void addressCheckoutTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressCheckoutTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addressCheckoutTextActionPerformed

    private void grandtotalTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grandtotalTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_grandtotalTextActionPerformed

    private void quantityCheckoutTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityCheckoutTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantityCheckoutTextActionPerformed

    private void calculateCashButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calculateCashButtonActionPerformed
      
    try {

        double total =
                Double.parseDouble(
                        grandtotalText.getText());

        double cash =
                Double.parseDouble(
                        cashText.getText());

        if (cash < total) {
            throw new Exception(
                    "Insufficient cash amount!");
        }

        paidamountText.setText(
                String.format("%.2f", total));

        double change = cash - total;

        changeText.setText(
                String.format("%.2f", change));

    } catch (Exception e) {

        JOptionPane.showMessageDialog(
                this,
                e.getMessage(),
                "Payment Error",
                JOptionPane.ERROR_MESSAGE);
    }

    
  


    }//GEN-LAST:event_calculateCashButtonActionPerformed

    private void doneCheckoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doneCheckoutButtonActionPerformed
        String name = nameCheckoutText.getText().trim();
        String phone = nophoneCheckoutText.getText().trim();
        String address = addressCheckoutText.getText().trim();
        String grandTotalStr = grandtotalText.getText().trim();
    try {

if (name.isEmpty()) {
            throw new Exception("Enter customer name!");
        }
        if (grandTotalStr.isEmpty()) {
            throw new Exception("Please calculate payment first!");
        }
        JOptionPane.showMessageDialog(
                this,
                "Thank You For Your Purchase!");
        
        double grandTotal = Double.parseDouble(grandTotalStr);
        
        java.sql.Connection conn = DBConnection.getConnection();
        if (conn != null) {
            // Arahan SQL untuk mengemas kini rekod jualan produk terakhir yang nilai nama pelanggannya masih NULL
            String sql = "UPDATE sales SET customer_name = ?, phone = ?, address = ?, grand_total = ? "
                       + "WHERE customer_name IS NULL ORDER BY sale_id DESC LIMIT 1";
            
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            
            pst.setString(1, name);
            pst.setString(2, phone);
            pst.setString(3, address);
            pst.setDouble(4, grandTotal);

            int rowsUpdated = pst.executeUpdate();
            
            pst.close();
            conn.close(); // Tutup sambungan database

            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(this, "Thank You For Your Purchase! Data saved to database.");
            } else {
                // Jika tiada rekod NULL, kita update berdasarkan ID jualan paling akhir secara umum
                java.sql.Connection conn2 = DBConnection.getConnection();
                String sql2 = "UPDATE sales SET customer_name = ?, phone = ?, address = ?, grand_total = ? ORDER BY sale_id DESC LIMIT 1";
                java.sql.PreparedStatement pst2 = conn2.prepareStatement(sql2);
                pst2.setString(1, name);
                pst2.setString(2, phone);
                pst2.setString(3, address);
                pst2.setDouble(4, grandTotal);
                pst2.executeUpdate();
                pst2.close();
                conn2.close();
                JOptionPane.showMessageDialog(this, "Thank You For Your Purchase!");
            }
        } else {
            throw new Exception("Database connection failed!");
        }

        
        
        nameCheckoutText.setText("");
        nophoneCheckoutText.setText("");
        addressCheckoutText.setText("");

        quantityCheckoutText.setText("");
        PriceText.setText("");
        grandtotalText.setText("");

        cashText.setText("");
        paidamountText.setText("");
        changeText.setText("");

    } catch (Exception e) {

        JOptionPane.showMessageDialog(
                this,
                e.getMessage());
    }
       // TODO add your handling code here:
       
       
       
    }//GEN-LAST:event_doneCheckoutButtonActionPerformed

    private void calculatePaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calculatePaymentActionPerformed

    try {

        DefaultTableModel model =
                (DefaultTableModel) tblView.getModel();

        if (model.getRowCount() == 0) {

            JOptionPane.showMessageDialog(
                    this,
                    "Cart is empty.");

            return;
        }

        double total = 0;



        String qtyText = quantityCheckoutText.getText().trim();
        String priceText = PriceText.getText().trim();
        
        if (qtyText.isEmpty() || priceText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in the Quantity and Price fields first!");
            return;
        }
        
             int quantity = Integer.parseInt(qtyText);
             double price = Double.parseDouble(priceText);

        
        double grandTotal = (quantity * price);

       grandtotalText.setText(
                String.format("%.2f", grandTotal));
    
    } catch (Exception e) {

        JOptionPane.showMessageDialog(
                this,
                "Invalid data inside order.txt\n"
                + e.getMessage());
    }

    }//GEN-LAST:event_calculatePaymentActionPerformed

    private void nameCheckoutTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameCheckoutTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameCheckoutTextActionPerformed

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
        PnlView.setVisible(false);
        PnlAddItems.setVisible(false);
        PnlCheckout.setVisible(false);
        pnlRemovecart.setVisible(true);
        PnlSalesView.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_removeActionPerformed

    private void tblRemoveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRemoveMouseClicked

        

        int row = tblRemove.getSelectedRow();
        
        quantityText.setText(tblRemove.getValueAt(row, 2).toString());
        priceText.setText(tblRemove.getValueAt(row, 3).toString());

        // TODO add your handling code here:
    }//GEN-LAST:event_tblRemoveMouseClicked

    private void deleteProductBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteProductBtnActionPerformed


    try {

        int row = tblRemove.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(this,
                    "Please select a product.");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to remove this item from the cart?",
                "Delete Confirmation",
                JOptionPane.YES_NO_OPTION);

        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        DefaultTableModel model =
                (DefaultTableModel) tblRemove.getModel();

        model.removeRow(row);

        BufferedWriter writer =
                new BufferedWriter(
                        new FileWriter("order.txt"));

        for (int i = 0; i < model.getRowCount(); i++) {

            writer.write(
                    model.getValueAt(i, 0).toString() + ","
                    + model.getValueAt(i, 1).toString() + ","
                    + model.getValueAt(i, 2).toString() + ","
                    + model.getValueAt(i, 3).toString());

            writer.newLine();
        }

        writer.close();

        loadViewData();
        loadDeleteProduct();

        JOptionPane.showMessageDialog(
                this,
                "Product Deleted Successfully");

    } catch (Exception e) {

        JOptionPane.showMessageDialog(
                this,
                e.getMessage());
    }

    }//GEN-LAST:event_deleteProductBtnActionPerformed

    private void fpxPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fpxPaymentActionPerformed

       

    try {

        if (grandtotalText.getText().trim().isEmpty()) {
            throw new Exception(
                    "Please calculate payment first!");
        }

        int confirm =
                JOptionPane.showConfirmDialog(
                        this,
                        "Proceed with FPX payment?",
                        "FPX Payment",
                        JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {

            JOptionPane.showMessageDialog(
                    this,
                    "FPX Payment Successful!\nTransaction ID : FPX"
                    + System.currentTimeMillis());
        }

    } catch (Exception e) {

        JOptionPane.showMessageDialog(
                this,
                e.getMessage(),
                "FPX Error",
                JOptionPane.ERROR_MESSAGE);
    }

    }//GEN-LAST:event_fpxPaymentActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed

        txtNameCustomer.setText("");
        txtID.setText("");
        txtID1.setText("");
        quantityText.setText("");
        priceText.setText("");
        cbSelectProduct.setSelectedIndex(-1);
        
    }//GEN-LAST:event_clearActionPerformed

    private void addtocartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addtocartButtonActionPerformed
      
    try {

        String id = txtID.getText().trim();
        String name = txtNameCustomer.getText().trim();
        String qty = quantityText.getText().trim();
        String price = priceText.getText().trim();

        if (id.isEmpty()
                || name.isEmpty()
                || qty.isEmpty()
                || price.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please complete all fields.");

            return;
        }
        
        int quantityBuy = Integer.parseInt(qty);
        int unitPrice = Integer.parseInt(price);
        double calculatedSubtotal = quantityBuy;
        double grandTotal = quantityBuy * unitPrice;
        
        java.sql.Connection conn = DBConnection.getConnection();
        if (conn != null) {
            // Kita masukkan data ke kolum utama mengikut keperluan minimum jadual sales korang
            String sql = "INSERT INTO sales (product_name, subtotal, grand_total, sale_date) VALUES (?, ?, ?, NOW())";
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            
            pst.setString(1, name);                 // customer_name
            pst.setDouble(2, calculatedSubtotal);    // subtotal
            pst.setDouble(3, grandTotal); // grand_total 
            

            int rowsInserted = pst.executeUpdate();
            
            pst.close();
            conn.close();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(this, "Added To Cart & Saved to Database Successfully!");
            }
            

        } else {
            throw new Exception("Database connection failed!");
        }

        Integer.parseInt(qty);
        Double.parseDouble(price);

        BufferedWriter writer =
                new BufferedWriter(
                        new FileWriter(
                                "order.txt",
                                true));

        writer.write(
                id + ","
                + name + ","
                + qty + ","
                + price);

        writer.newLine();

        writer.close();

        loadViewData();
        loadDeleteProduct();



    } catch (NumberFormatException e) {

        JOptionPane.showMessageDialog(
                this,
                "Quantity and Price must be numeric.");

    } catch (Exception e) {

        JOptionPane.showMessageDialog(
                this,
                e.getMessage());
    }

    }//GEN-LAST:event_addtocartButtonActionPerformed

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void txtNameCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameCustomerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameCustomerActionPerformed

    private void cbSelectProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSelectProductActionPerformed
    
    try {

        if (cbSelectProduct.getSelectedItem() == null) {
            return;
        }

        String selectedProduct =
                cbSelectProduct.getSelectedItem().toString().trim();

        BufferedReader reader =
                new BufferedReader(
                        new FileReader("product.txt"));

        String line;

        while ((line = reader.readLine()) != null) {

            String[] data = line.split(",");

            if (data.length >= 4) {

                String productName =
                        data[1].trim();

                if (productName.equalsIgnoreCase(selectedProduct)) {

                    txtID.setText(data[0].trim());          // ID
                    txtNameCustomer.setText(data[1].trim()); // Name
                    quantityText.setText(data[3].trim());       // Price

                    break;
                }
            }
        }

        reader.close();

    } catch (Exception e) {

        JOptionPane.showMessageDialog(
                this,
                "Error loading product:\n" + e.getMessage());
    }

    }//GEN-LAST:event_cbSelectProductActionPerformed

    private void quantityTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityTextActionPerformed
    try {

        if (cbSelectProduct.getSelectedItem() == null) {
            return;
        }

        String selectedProduct =
                cbSelectProduct.getSelectedItem().toString().trim();

        BufferedReader reader =
                new BufferedReader(
                        new FileReader("product.txt"));

        String line;

        while ((line = reader.readLine()) != null) {

            String[] data = line.split(",");

            if (data.length >= 4) {

                String productName =
                        data[1].trim();

                if (productName.equalsIgnoreCase(selectedProduct)) {

                    txtID.setText(data[0].trim());          // ID
                    txtNameCustomer.setText(data[1].trim()); // Name
                    quantityText.setText(data[3].trim());       // Price

                    break;
                }
            }
        }

        reader.close();

    } catch (Exception e) {

        JOptionPane.showMessageDialog(
                this,
                "Error loading product:\n" + e.getMessage());
    }        // TODO add your handling code here:
    }//GEN-LAST:event_quantityTextActionPerformed

    private void priceTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceTextActionPerformed

    private void SalesviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalesviewActionPerformed
        PnlView.setVisible(false);
        PnlAddItems.setVisible(false);
        PnlCheckout.setVisible(false);
        pnlRemovecart.setVisible(false);
        PnlSalesView.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_SalesviewActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
                                  
    try {
        
        String name = nameCheckoutText.getText().trim();
        String nophone = nophoneCheckoutText.getText().trim();
        String address = addressCheckoutText.getText().trim();
        String price1 = PriceText.getText().trim();
        String qty = quantityCheckoutText.getText().trim();
        String grandtotal = grandtotalText.getText().trim();
                
        if (name.isEmpty()
                || nophone.isEmpty()
                || address.isEmpty()
                || price1.isEmpty()
                || qty.isEmpty()
                || grandtotal.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please complete all fields.");
            return;
        }     
        
       
        BufferedWriter writer =
                new BufferedWriter(
                        new FileWriter(
                                "sales.txt",
                                true));

        writer.write(
                
                 name + ","
                + nophone + ","
                + address + ","
                + price1 + ","
                + qty + ","
                + grandtotal);

        writer.newLine();
        writer.close();

        // 2. DI SINI PERUBAHAN UTAMA: Masukkan terus ke JTable secara live!
        // Sila pastikan 'jTable1' ditukar kepada nama variable JTable korang yang sebenar (cth: tblCheckout atau jTable1)
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) tblSales.getModel();
        
        // Susunan data dimasukkan mengikut lajur jadual: NAME, NO PHONE, ADDRESS, ID, PRICE, QUANTITY, GRAND TOTAL
        model.addRow(new Object[]{
            name,       // NAME
            nophone,    // NO PHONE
            address,    // ADDRESS
            price1,     // PRICE
            qty,        // QUANTITY
            grandtotal  // GRAND TOTAL
        });

        JOptionPane.showMessageDialog(this, "Data Saved and Added to Table Successfully!");

        // Padam kod loadViewData() dan loadDeleteProduct() lama jika ia punca conflict database
        // loadViewData();
        // loadDeleteProduct();

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(
                this,
                "Quantity and Price must be numeric.");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(
                this,
                e.getMessage());
    }

                               // TODO add your handling code here:
    }//GEN-LAST:event_saveButtonActionPerformed

    private void PriceTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PriceTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PriceTextActionPerformed

    private void cbSelectProduct1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSelectProduct1ActionPerformed
  

    try {

        if (cbSelectProduct1.getSelectedItem() == null) {
            return;
        }

        String selectedProduct =
                cbSelectProduct1.getSelectedItem().toString();

        String url =
                "jdbc:mysql://localhost:3306/computerstore";

        String username = "root";
        String password = "";

        String query =
                "SELECT product_id, price_unit "
                + "FROM products "
                + "WHERE product_name = ?";

        java.sql.Connection conn =
                java.sql.DriverManager.getConnection(
                        url,
                        username,
                        password);

        java.sql.PreparedStatement pst =
                conn.prepareStatement(query);

        pst.setString(1, selectedProduct);

        java.sql.ResultSet rs =
                pst.executeQuery();

        if (rs.next()) {

            // Display Product ID
            txtID1.setText(
                    rs.getString("product_id"));

            // Clear quantity for user input
            quantityCheckoutText.setText("");

            // Display Product Price
            PriceText.setText(
                    rs.getString("price_unit"));
        }

        rs.close();
        pst.close();
        conn.close();

    } catch (Exception e) {

        JOptionPane.showMessageDialog(
                this,
                "Error retrieving product details:\n"
                + e.getMessage());
    }


    }//GEN-LAST:event_cbSelectProduct1ActionPerformed

    private void txtID1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtID1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtID1ActionPerformed

    private void changeTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_changeTextActionPerformed

   public static void main(String args[]) {

    java.awt.EventQueue.invokeLater(() ->
            new SalesFrame().setVisible(true));
}   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddItems;
    private javax.swing.JButton Back;
    private javax.swing.JButton Checkout;
    private javax.swing.JPanel PnlAddItems;
    private javax.swing.JPanel PnlCheckout;
    private javax.swing.JPanel PnlSalesView;
    private javax.swing.JPanel PnlView;
    private javax.swing.JTextField PriceText;
    private javax.swing.JButton Salesview;
    private javax.swing.JButton ViewCart;
    private javax.swing.JLabel addItemsProduct;
    private javax.swing.JLabel addressCheckout;
    private javax.swing.JTextField addressCheckoutText;
    private javax.swing.JButton addtocartButton;
    private javax.swing.JButton calculateCashButton;
    private javax.swing.JButton calculatePayment;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel cashCheckout;
    private javax.swing.JLabel cashInput;
    private javax.swing.JPanel cashMethod;
    private javax.swing.JTextField cashText;
    private javax.swing.JComboBox<String> cbSelectProduct;
    private javax.swing.JComboBox<String> cbSelectProduct1;
    private javax.swing.JLabel changeAmount;
    private javax.swing.JTextField changeText;
    private javax.swing.JLabel checkoutProduct;
    private javax.swing.JButton clear;
    private javax.swing.JPanel customerDetails;
    private javax.swing.JLabel customerInfo;
    private javax.swing.JButton deleteProductBtn;
    private javax.swing.JButton doneCheckoutButton;
    private javax.swing.JButton fpxPayment;
    private javax.swing.JTextField grandtotalText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelContent;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblFormtitle4;
    private javax.swing.JLabel nameCheckout;
    private javax.swing.JTextField nameCheckoutText;
    private javax.swing.JLabel noPhoneCheckout;
    private javax.swing.JTextField nophoneCheckoutText;
    private javax.swing.JLabel paidAmount;
    private javax.swing.JTextField paidamountText;
    private javax.swing.JLabel paymentCheckout;
    private javax.swing.JPanel paymentMethod;
    private javax.swing.JLabel paymentSummary;
    private javax.swing.JPanel paymentsummaryCheckout;
    private javax.swing.JPanel pnlRemovecart;
    private javax.swing.JLabel price;
    private javax.swing.JLabel priceCheckout;
    private javax.swing.JTextField priceText;
    private javax.swing.JLabel productID;
    private javax.swing.JLabel productID1;
    private javax.swing.JLabel productID2;
    private javax.swing.JLabel productID3;
    private javax.swing.JLabel productID4;
    private javax.swing.JLabel productID5;
    private javax.swing.JLabel quantity;
    private javax.swing.JLabel quantityCheckout;
    private javax.swing.JTextField quantityCheckoutText;
    private javax.swing.JTextField quantityText;
    private javax.swing.JButton remove;
    private javax.swing.JButton saveButton;
    private javax.swing.JTable tblRemove;
    private javax.swing.JTable tblSales;
    private javax.swing.JTable tblView;
    private javax.swing.JLabel totalCheckout;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtID1;
    private javax.swing.JTextField txtNameCustomer;
    private javax.swing.JLabel viewCartProduct;
    // End of variables declaration//GEN-END:variables
    }
