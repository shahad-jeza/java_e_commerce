package e_commerce;

// e_commerce.Product class representing a generic product
class Product {
    private int productID;
    private String name;
    private String category;
    private double price;
    private int stockQuantity;

    // Constructor
    public Product(int productID, String name, String category, double price, int stockQuantity) {
        this.productID = productID;
        this.name = name;
        this.category = category;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    // Getters and Setters
    public int getProductID() { return productID; }
    public void setProductID(int productID) { this.productID = productID; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getStockQuantity() { return stockQuantity; }
    public void setStockQuantity(int stockQuantity) { this.stockQuantity = stockQuantity; }

    // Method to calculate discount (polymorphism)
    public double calculateDiscount() {
        return 0; // Default no discount
    }

    public void reduceStock(int quantity) { this.stockQuantity -= quantity; }

    @Override
    public String toString() {
        return "[ID: " + productID + ", Name: " + name + ", Category: " + category + ", Price: " + price + ", Stock: " + stockQuantity + "]";
    }
}


// e_commerce.Electronics subclass
class Electronics extends Product {
    private int warrantyPeriod;

    public Electronics(int productID, String name, double price, int stockQuantity, int warrantyPeriod) {
        super(productID, name, "e_commerce.Electronics", price, stockQuantity);
        this.warrantyPeriod = warrantyPeriod;
    }

    public int getWarrantyPeriod() { return warrantyPeriod; }
    public void setWarrantyPeriod(int warrantyPeriod) { this.warrantyPeriod = warrantyPeriod; }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.1; // 10% discount on electronics
    }
}

// e_commerce.Clothing subclass
class Clothing extends Product {
    private String size;

    public Clothing(int productID, String name, double price, int stockQuantity, String size) {
        super(productID, name, "e_commerce.Clothing", price, stockQuantity);
        this.size = size;
    }

    public String getSize() { return size; }
    public void setSize(String size) { this.size = size; }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.05; // 5% discount on clothing
    }
}
