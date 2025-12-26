package HomeWork;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Invoice {
    /***
     * invoiceId – String: mã hóa đơn (HDxxxx, 6 ký tự)
     * customerName – String: tên khách hàng
     * invoiceDate – Date: ngày lập hóa đơn
     * invoiceDetails – mảng InvoiceDetail: danh sách sản phẩm
     * totalAmount – double: tổng tiền hóa đơn (tính từ invoiceDetails)
     */

    private String invoiceId;
    private String customerName;
    private Date invoiceDate;
    private InvoiceDetail[] invoiceDetails;
    private double totalAmount;

    /***
     * Constructor đầy đủ và không tham số
     * Getter/Setter
     * inputData(Scanner scanner, Product[] arrProd, int prodIndex)
     * calculateTotalAmount(): tính tổng tiền
     * displayData()
     */
    public Invoice() {
    }

    public Invoice(String invoiceId, String customerName, Date invoiceDate, InvoiceDetail[] invoiceDetails, double totalAmount) {
        this.invoiceId = invoiceId;
        this.customerName = customerName;
        this.invoiceDate = invoiceDate;
        this.invoiceDetails = invoiceDetails;
        this.totalAmount = totalAmount;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public InvoiceDetail[] getInvoiceDetails() {
        return invoiceDetails;
    }

    public void setInvoiceDetails(InvoiceDetail[] invoiceDetails) {
        this.invoiceDetails = invoiceDetails;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    /**
     * * inputData(Scanner scanner, Product[] arrProd, int prodIndex)
     * * calculateTotalAmount(): tính tổng tiền
     * * displayData()
     */

    public void inputData(Scanner scanner, Product[] arrProd, int proIndex) {
        inputId(scanner);
        inputName(scanner);
        inputDate(scanner);
        invoiceDetails(scanner, arrProd, proIndex);
        totalAmount();
    }

    public void displayInvoice(){
        System.out.println("ID: " + invoiceId);
        System.out.println("Customer: " + customerName);
        System.out.println("Date: " + invoiceDate);

        System.out.println("Invoice Details:");
        for (int i = 0; i < invoiceDetails.length; i++) {
            invoiceDetails[i].displayInfo();
        }
        System.out.println("_________________");
        System.out.println("Total Amount: " + totalAmount);
    }

    //invoiceId – String: mã hóa đơn (HDxxxx, 6 ký tự)
    public void inputId(Scanner scanner) {
        String regex = "^HD\\d{6}$";

        do {
            System.out.println("Nhập vào mã hoá đơn: ");
            String id = scanner.nextLine();

            if (id.matches(regex)) {
                this.invoiceId = id;
                break;
            } else {
                System.err.println("Nhập mã hoá đơn theo định dạng HD+000000");
            }
        } while (true);
    }

    //customerName – String: tên khách hàng
    public void inputName(Scanner scanner) {
        System.out.println("Nhập vào tên khách hàng: ");
        this.customerName = scanner.nextLine();
    }

    //invoiceDate – Date: ngày lập hóa đơn
    public void inputDate(Scanner scanner) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        do {
            try {
                System.out.println("Nhập vào ngày tạo: ");
                String date = scanner.nextLine();
                this.invoiceDate = sdf.parse(date);
                break;
            } catch (Exception e) {
                System.out.println("Lỗi nhập vào ngày tạo!");
            }
        } while (true);
    }
    //invoiceDetails – mảng InvoiceDetail: danh sách sản phẩm
    public void invoiceDetails(Scanner scanner, Product[] arrProd, int proIndex) {

        System.out.println("Nhập số lượng sản phẩm muốn mua: ");
        int n = Integer.parseInt(scanner.nextLine());

        invoiceDetails = new InvoiceDetail[n];
        for (int i = 0; i < n; i++) {
            invoiceDetails[i] = new InvoiceDetail();
            invoiceDetails[i].inputData(scanner,arrProd,proIndex);
        }

    }

    //totalAmount – double: tổng tiền hóa đơn (tính từ invoiceDetails)
    public void totalAmount() {
        double total = 0;
        for (int i = 0; i < invoiceDetails.length; i++) {
            total += invoiceDetails[i].getSubtotal();
        }
        this.totalAmount = total;
    }

}
