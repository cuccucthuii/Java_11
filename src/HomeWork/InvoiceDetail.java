package HomeWork;

import java.util.Scanner;

public class InvoiceDetail {
    private Product product;
    private int quantity;
    private double subtotal;

    public InvoiceDetail(){}

    public InvoiceDetail(Product product, int quantity, double subtotal) {
        this.product = product;
        this.quantity = quantity;
        this.subtotal = subtotal;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public void inputData(Scanner scanner, Product[] arrProd, int indexProd) {
        inputPrud(scanner,arrProd,indexProd);
        inputQuantity(scanner);
        subTotal();

    }

    public void inputPrud(Scanner scanner, Product[] arrProd, int indexProd) {
        do {
            Product selectedProduct = null;

            System.out.println("Lựa chọn sản phẩm trong cửa hàng");
            for (int i = 0; i < indexProd; i++) {
                System.out.println("ID: "+arrProd[i].getProductId() + " - Name: "+arrProd[i].getProductName());
            }

            System.out.println("Lựa chọn của bạn (Chọn sản phẩm theo mã hoá đơn): ");
            String choice = scanner.nextLine();

            for (int i = 0; i < indexProd; i++) {
                if (arrProd[i].getProductId().equalsIgnoreCase(choice)) {
                    selectedProduct = arrProd[i];
                    break;
                }
            }

            if (selectedProduct == null) {
                System.err.println("Vui lòng chọn sản phẩm có trong cửa hàng!");
            }else {
                this.product = selectedProduct;
                break;
            }

        }while (true);
    }

    public void inputQuantity(Scanner scanner) {
        do {
            System.out.println("Số lượng mua: ");
            int quant = Integer.parseInt(scanner.nextLine());

            if (quant > 0) {
                this.quantity = quant;
                break;
            }else {
                System.err.println("Số lượng mua phải lớn hơn 0");
            }
        }while (true);
    }

    public void subTotal(){
        if (this.product != null && this.quantity > 0) {
            this.subtotal = product.getProductPrice()* quantity;
        }else{
            this.subtotal = 0;
        }
    }

    public void displayInfo(){
        System.out.println("ID: " + product.getProductId());
        System.out.println("Name: " + product.getProductName());
        System.out.println("Price: " + product.getProductPrice());
        System.out.println("Quantity: " + quantity);
        System.out.println("Subtotal: " + subtotal);
    }

}
