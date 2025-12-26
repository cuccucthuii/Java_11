package HomeWork.Xs2;

import java.util.Scanner;

public class Product {
    private String productId;
    private String productName;
    private double productPrice;
    private ProductStatus productStatus;

    public Product() {
    }

    ;

    public Product(String productId, String productName, double productPrice, ProductStatus productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productStatus = productStatus;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public ProductStatus getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(ProductStatus productStatus) {
        this.productStatus = productStatus;
    }

    public void inputData(Scanner scanner, Product[] products, int index) {
        inputProductId(scanner);
        inputProductName(scanner, products, index);
        inputPrice(scanner);
        inputStatus(scanner);
    }

    public void displayData() {
        System.out.println("Product Id : " + productId + " - Product Name : " + productName + " - Product Price : " + productPrice + " - Product Status : " + productStatus);
    }

    public void inputProductId(Scanner scanner) {
        String regexId = "^[CSA]\\d{3}$";
        do {
            System.out.println("Enter product ID: ");
            this.productId = scanner.nextLine();

            if (productId.matches(regexId)) {
                break;
            } else {
                System.err.println("Invalid product ID");
            }
        } while (true);
    }

    public void inputProductName(Scanner scanner, Product[] products, int index) {
        String regexName = "^(?=.*\\S).{10,50}$";

        do {

            boolean isDuplicate = false;
            System.out.println("Enter product name: ");
            String name = scanner.nextLine();

            for (int i = 0; i < index; i++) {
                if (products[i] != null && name.equalsIgnoreCase(products[i].getProductName())) {
                    isDuplicate = true;
                    System.out.println("Product name is already in use");
                    break;
                }
            }

            if (!name.matches(regexName)) {
                System.err.println("Invalid product name");
                continue;
            }

            if (!isDuplicate) {
                this.productName = name;
                break;
            }
        } while (true);
    }

    public void inputPrice(Scanner scanner) {
        do {
            System.out.println("Enter product price: ");
            Double price = Double.parseDouble(scanner.nextLine());

            if (price > 0) {
                this.productPrice = price;
                break;
            } else {
                System.err.println("Invalid product price");
            }
        } while (true);
    }

    public void inputStatus(Scanner scanner) {
        do {
            System.out.println("Enter product status: ");
            String status = scanner.nextLine();

            if (status.equalsIgnoreCase("AVAILABLE")) {
                this.productStatus = ProductStatus.AVAILABLE;
                break;
            } else if (status.equalsIgnoreCase("OUT_OF_STOCK")) {
                this.productStatus = ProductStatus.OUT_OF_STOCK;
                break;
            } else if (status.equalsIgnoreCase("STOP_SELLING")) {
                this.productStatus = ProductStatus.STOP_SELLING;
                break;
            } else {
                System.err.println("Invalid product status");
            }
        } while (true);
    }
}
