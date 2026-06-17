package projectoodi;

public class PurchaseOrder {

    private String poID;
    private String supplierID;
    private String itemName;
    private int quantity;
    private double unitPrice;

    public PurchaseOrder(String poID,
                         String supplierID,
                         String itemName,
                         int quantity,
                         double unitPrice) {

        this.poID = poID;
        this.supplierID = supplierID;
        this.itemName = itemName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public double calculateTotal() {
        return quantity * unitPrice;
    }

    public String getPoID() {
        return poID;
    }

    public String getSupplierID() {
        return supplierID;
    }

    public String getItemName() {
        return itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }
}