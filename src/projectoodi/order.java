
package projectoodi;

public class order {
    private String orderId;
    private String orderName;
    private String orderQty;
    private String orderPrice;

    public order(String orderId,
            String orderName,
            String orderQty,
            String orderPrice) {

        this.orderId = orderId;
        this.orderName = orderName;
        this.orderQty = orderQty;
        this.orderPrice = orderPrice;

    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(String orderQty) {
        this.orderQty = orderQty;
    }

    public String getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(String orderPrice) {
        this.orderPrice = orderPrice;
    }
     public String displayInfo() {
        return "Order ID: " + orderId +
               "\nOrder Name: " + orderName +
               "\nOrder Qty: " + orderQty +
               "\nOrder Price: " + orderPrice;
    }
}
