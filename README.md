# Java E-Commerce System

A simple console-based e-commerce system that demonstrates object-oriented programming principles in Java.

## Features

- Create and manage products with different categories
- Place orders with multiple items
- View order history by user
- Stock management with out-of-stock exception handling
- Discount calculation based on product type

## Project Structure

### Core Classes

- **Product**: Base class for all product types
  - Properties: ProductID, Name, Category, Price, StockQuantity
  - Methods: calculateDiscount(), reduceStock()

- **Electronics**: Extends Product
  - Additional property: warrantyPeriod
  - Overrides calculateDiscount() to provide 10% discount

- **Clothing**: Extends Product
  - Additional property: size
  - Overrides calculateDiscount() to provide 5% discount

- **Order**: Represents a customer order
  - Properties: OrderID, UserID, List of OrderDetails
  - Methods: addOrderDetail(), getTotalPrice()
  - Custom exception: OutOfStockException

- **OrderDetails**: Represents an individual item in an order
  - Properties: OrderDetailID, OrderID, ProductID, Quantity, SubTotal

### System Class

- **ECommerceSystem**: Main class that manages the application flow
  - Maintains collections of products and orders
  - Provides a simple command-line interface
  - Implements user order history using HashMap

## OOP Principles Demonstrated

1. **Inheritance**: Electronics and Clothing classes extend the base Product class
2. **Polymorphism**: calculateDiscount() method is overridden in subclasses
3. **Encapsulation**: Private properties with public getters/setters
4. **Abstraction**: High-level operations like placing orders abstract the underlying complexity

## Java Collections Used

- ArrayList: For storing products and order details
- HashMap: For managing user order history

## Exception Handling

- Custom OutOfStockException for handling insufficient inventory
- Try-catch blocks for graceful error handling

## How to Run

1. Compile the Java files:
```
javac e_commerce/*.java
```

2. Run the application:
```
java e_commerce.ECommerceSystem
```

3. Follow the on-screen instructions to place orders and view order history

## Sample Usage

```
1. Place Order
2. View Order History
3. Exit
Enter choice: 1
Enter User ID: 1

Available Products:
[ID: 1, Name: Laptop, Category: Electronics, Price: 1200.0, Stock: 10]
[ID: 2, Name: Headphones, Category: Electronics, Price: 100.0, Stock: 20]
[ID: 3, Name: T-shirt, Category: Clothing, Price: 25.0, Stock: 30]
[ID: 4, Name: Sneakers, Category: Clothing, Price: 80.0, Stock: 15]

Enter Product ID to order (or 0 to finish): 1
Enter quantity: 2
Order placed successfully!
```

Fell free to contribute!
