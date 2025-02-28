package e_commerce;

import java.util.*;

public class ECommerceSystem {
    private static List<Product> products = new ArrayList<>();
    private static List<Order> orders = new ArrayList<>();
    private static Map<Integer, List<Order>> userOrderHistory = new HashMap<>();
    private static int orderCounter = 1;
    private static int orderDetailCounter = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        seedData();

        while (true) {
            System.out.println("\n1. Place Order\n2. View Order History\n3. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    placeOrder(scanner);
                    break;
                case 2:
                    viewOrders();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    private static void seedData() {
        products.add(new Product(1, "Laptop", "Electronics", 1200, 10));
        products.add(new Product(2, "Headphones", "Electronics", 100, 20));
        products.add(new Product(3, "T-shirt", "Clothing", 25, 30));
        products.add(new Product(4, "Sneakers", "Clothing", 80, 15));
    }

    private static void placeOrder(Scanner scanner) {
        System.out.print("Enter User ID: ");
        int userID = scanner.nextInt();
        Order newOrder = new Order(orderCounter++, userID);

        while (true) {
            System.out.println("\nAvailable Products:");
            for (Product product : products) {
                System.out.println(product);
            }

            System.out.print("Enter Product ID to order (or 0 to finish): ");
            int productID = scanner.nextInt();
            if (productID == 0) break;

            Product selectedProduct = products.stream().filter(p -> p.getProductID() == productID).findFirst().orElse(null);
            if (selectedProduct == null) {
                System.out.println("Invalid Product ID!");
                continue;
            }

            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();

            try {
                if (quantity > selectedProduct.getStockQuantity()) {
                    throw new Order.OutOfStockException("Not enough stock available for " + selectedProduct.getName() + "!");
                }

                selectedProduct.reduceStock(quantity);
                OrderDetails details = new OrderDetails(orderDetailCounter++, newOrder.getOrderID(), selectedProduct, quantity);
                newOrder.addOrderDetail(details);
            } catch (Order.OutOfStockException e) {
                System.out.println(e.getMessage());
                continue;
            }
        }

        if (!newOrder.getOrderDetailsList().isEmpty()) {
            orders.add(newOrder);

            // Add to user order history map
            if (!userOrderHistory.containsKey(userID)) {
                userOrderHistory.put(userID, new ArrayList<>());
            }
            userOrderHistory.get(userID).add(newOrder);

            System.out.println("Order placed successfully!\n" + newOrder);
        } else {
            System.out.println("No products were ordered.");
        }

    }

    private static void viewOrders() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter User ID: ");
        int userID = scanner.nextInt();

        if (!userOrderHistory.containsKey(userID) || userOrderHistory.get(userID).isEmpty()) {
            System.out.println("No orders found for this user!");
            return;
        }

        for (Order order : userOrderHistory.get(userID)) {
            System.out.println("\n" + order);
        }
    }
}
