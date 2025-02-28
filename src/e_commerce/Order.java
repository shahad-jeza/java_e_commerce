package e_commerce;
import e_commerce.OrderDetails;

import java.util.*;


class Order {
    private int orderID;
    private int userID;
    private List<OrderDetails> orderDetailsList;

    public Order(int orderID, int userID) {
        this.orderID = orderID;
        this.userID = userID;
        this.orderDetailsList = new ArrayList<>();
    }

    public int getOrderID() {
        return orderID;
    }

    public int getUserID() {
        return userID;
    }

    public List<OrderDetails> getOrderDetailsList() {
        return orderDetailsList;
    }

    public void addOrderDetail(OrderDetails detail) {
        orderDetailsList.add(detail);
    }

    public double getTotalPrice() {
        return orderDetailsList.stream().mapToDouble(OrderDetails::getSubTotal).sum();
    }

    @Override
    public String toString() {
        StringBuilder details = new StringBuilder("e_commerce.Order ID: " + orderID + " | User ID: " + userID + "\n");
        for (OrderDetails detail : orderDetailsList) {
            details.append(detail).append("\n");
        }
        details.append("Total: ").append(getTotalPrice());
        return details.toString();
    }

    // Custom Exception for Out of Stock
    public static class OutOfStockException extends Exception {
        public OutOfStockException(String message) {
            super(message);
        }
    }
}