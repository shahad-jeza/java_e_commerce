package e_commerce;
import java.util.*;

public class OrderDetails {
    private int orderDetailID;
    private int orderID;
    private int productID;
    private int quantity;
    private double subTotal;

    public OrderDetails(int orderDetailID, int orderID, int productID, int quantity, double subTotal) {
        this.orderDetailID = orderDetailID;
        this.orderID = orderID;
        this.productID = productID;
        this.quantity = quantity;
        this.subTotal = subTotal;
    }

    public OrderDetails(int orderDetailID, int orderID, Product selectedProduct, int quantity) {
        this.orderDetailID = orderDetailID;
        this.orderID = orderID;
        this.productID = selectedProduct.getProductID();
        this.quantity = quantity;
        this.subTotal = selectedProduct.getPrice() * quantity;
    }

    public int getOrderDetailID() { return orderDetailID; }
    public int getOrderID() { return orderID; }
    public int getProductID() { return productID; }
    public int getQuantity() { return quantity; }
    public double getSubTotal() { return subTotal; }

    @Override
    public String toString() {
        return "Product ID: " + productID + " (Qty: " + quantity + ", Subtotal: " + subTotal + ")";
    }
}