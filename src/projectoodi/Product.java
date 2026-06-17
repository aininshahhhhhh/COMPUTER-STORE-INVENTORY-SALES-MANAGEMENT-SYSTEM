/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectoodi;

/**
 *
 * @author lqmnn
 */
public class Product {

    private String productId;
    private String productName;
    private String productQty;

    public Product(String productId,
            String productName,
            String productQty) {

        this.productId = productId;
        this.productName = productName;
        this.productQty = productQty;

    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductQty() {
        return productQty;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductQty(String productQty) {
        this.productQty = productQty;
    }
    
    public String displayInfo() {
        return "Product ID: " + productId +
               "\nProduct Name: " + productName +
               "\nProduct Qty: " + productQty ;
    }
}
