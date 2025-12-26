package Exam;

import java.util.Scanner;

public class Product implements IShop {
    private int productid;
    public String productName;
    private float price;
    private String description;
    private int catalogId;
    private int productStatus;

    public Product() {
    }

    ;

    public Product(int productid, String productName, float price, String description, int catalogId, int productStatus) {
        this.productid = productid;
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.catalogId = catalogId;
        this.productStatus = productStatus;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public int getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(int productStatus) {
        this.productStatus = productStatus;
    }

    public void inputData(Scanner scanner, Product[] products, int indexProduct, Categories[] categories, int indexCatalog) {
        System.out.println("Nhập vào id sản phẩm: ");
        this.productid = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập vào tên sản phẩm: ");
        this.productName = scanner.nextLine();
        System.out.println("Nhập vào giá sản phẩm: ");
        this.price = Float.parseFloat(scanner.nextLine());
        System.out.println("Nhập vào mô tả sản phẩm: ");
        this.description = scanner.nextLine();
        boolean isExist = false;
        do {
            System.out.println("Lựa chọn danh mục sản phẩm: ");
            for (int i = 0; i < indexCatalog; i++) {
                System.out.printf("ID: %d - Name: %s%n",
                        categories[i].getCatalogId(),
                        categories[i].getCatalogName());
            }
            System.out.println("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < indexCatalog; i++) {
                if (choice == categories[i].getCatalogId()) {
                    isExist = true;
                    break;
                }
            }
            if (!isExist) {
                System.err.println("Vui lòng chọn lại danh mục");
            }else{
                this.catalogId = choice;
                break;
            }
        } while (true);

        System.out.println("Lựa chọn trạng thái sản phẩm: ");
        do {
            this.productStatus = Integer.parseInt(scanner.nextLine());
            if (this.productStatus < 0 || this.productStatus > 2) {
                System.err.println("Vui lòng chọn (0: Đang bán – 1: Hết hàng – 2: Không bán)");
            }
        }while (this.productStatus < 0 || this.productStatus > 2);

    };

    @Override
    public void displayData() {
        System.out.println("ID: " + this.productid);
        System.out.println("Product Name: " + this.productName);
        System.out.println("Price: " + this.price);
        System.out.println("Description: " + this.description);
        System.out.println("Catalog ID: " + this.catalogId);
        if (this.productStatus == 0) {
            System.out.println("Product Status: Đang bán");
        }else if (this.productStatus == 1) {
            System.out.println("Product Status: Hết hàng");
        }else{
            System.out.println("Product Status: Không bán");
        }
    }
}
