package HomeWork.Xs2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class InvoiceManagement {
    public static Invoice[] arrInvoice = new Invoice[100];
    public static int currentInvoice = 0;

    public static Product[] arrProd = new Product[100];
    public static int currentProd = 0;

    public static InvoiceDetail[] arrInvoiceDetails = new InvoiceDetail[100];
    public static int currentInvoiceDetail = 0;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("================ QUẢN LÝ HÓA ĐƠN =================");
            System.out.println("1. Quản lý sản phẩm");
            System.out.println("2. Quản lý hóa đơn");
            System.out.println("3. Báo cáo doanh thu");
            System.out.println("4. Thoát");
            System.out.println("====================================================");
            System.out.print("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("--> Đang truy cập: Quản lý sản phẩm...");
                    mainProduct();
                    break;
                case 2:
                    System.out.println("--> Đang truy cập: Quản lý hóa đơn...");
                    mainInvoice();
                    break;
                case 3:
                    System.out.println("--> Đang xem: Báo cáo doanh thu...");
                    mainDanhThu();
                    break;
                case 4:
                    System.out.println("Đã thoát chương trình. Tạm biệt!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("!! Lựa chọn không hợp lệ (Chỉ nhập từ 1-4). Vui lòng thử lại.");
            }
            System.out.println();
        } while (true);
    }

    public static void mainProduct() {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("============== QUẢN LÝ SẢN PHẨM ==============");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Hiển thị danh sách sản phẩm");
            System.out.println("3. Cập nhật thông tin sản phẩm");
            System.out.println("4. Xóa sản phẩm (nếu chưa có trong hóa đơn nào)");
            System.out.println("5. Tìm kiếm sản phẩm theo tên");
            System.out.println("6. Thoát"); // Quay về menu chính
            System.out.println("==============================================");
            System.out.print("Lựa chọn của bạn: ");
            int subChoice = Integer.parseInt(scanner.nextLine());

            switch (subChoice) {
                case 1:
                    System.out.println("--> Chức năng: Thêm sản phẩm mới...");
                    inputProduct(scanner);
                    break;
                case 2:
                    System.out.println("--> Chức năng: Hiển thị danh sách...");
                    displayProduct();
                    break;
                case 3:
                    System.out.println("--> Chức năng: Cập nhật sản phẩm...");
                    updateProduct(scanner);
                    break;
                case 4:
                    System.out.println("--> Chức năng: Xóa sản phẩm...");
                    deleteProduct(scanner);
                    break;
                case 5:
                    System.out.println("--> Chức năng: Tìm kiếm sản phẩm...");
                    searchProductByName(scanner);
                    break;
                case 6:
                    System.out.println("... Quay lại menu chính.");
                    return;
                default:
                    System.out.println("!! Lựa chọn không hợp lệ (Nhập 1-6).");
            }
            System.out.println();
        } while (true);
    }

    public static void inputProduct(Scanner scanner) {
        System.out.println("Nhập số lượng sản phẩm: ");
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.println("Nhập sản phẩm thứ: " + (i + 1));
            arrProd[currentProd] = new Product();
            arrProd[currentProd].inputData(scanner, arrProd, currentProd);
            currentProd++;
        }
    }

    public static void displayProduct() {
        if (currentProd == 0) {
            System.out.println("Chưa có dữ liệu");
            return;
        }
        for (int i = 0; i < currentProd; i++) {
            arrProd[i].displayData();
        }
    }

    public static void updateProduct(Scanner scanner) {
        if (currentProd == 0) {
            System.out.println("Chưa có dữ liệu");
            return;
        }
        System.out.println("Nhập vào id sản phẩm cần update: ");
        String id = scanner.nextLine();

        int indexUpdate = findProductId(id);
        if (indexUpdate == -1) {
            System.err.println("Không tìm thấy id");
            return;
        }

        do {
            System.out.println("CHọn thông tin cần cập nhật");
            System.out.println("1. Tên sản phẩm");
            System.out.println("2. Giá sản phẩm");
            System.out.println("3. Trạng thái sản phẩm");
            System.out.println("4. Thoát");
            System.out.println("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Nhập tên: ");
                    arrProd[indexUpdate].setProductName(scanner.nextLine());
                    break;
                case 2:
                    System.out.println("Nhập vào giá: ");
                    arrProd[indexUpdate].setProductPrice(Double.parseDouble(scanner.nextLine()));
                    break;
                case 3:
                    do {
                        System.out.println("Chọn vào trạng thái: ");
                        String status = scanner.nextLine();

                        if (status.equalsIgnoreCase("AVAILABLE")) {
                            arrProd[indexUpdate].setProductStatus(ProductStatus.AVAILABLE);
                            break;
                        } else if (status.equalsIgnoreCase("OUT_OF_STOCK")) {
                            arrProd[indexUpdate].setProductStatus(ProductStatus.OUT_OF_STOCK);
                            break;
                        } else if (status.equalsIgnoreCase("STOP_SELLING")) {
                            arrProd[indexUpdate].setProductStatus(ProductStatus.STOP_SELLING);
                            break;
                        } else {
                            System.err.println("Invalid product status");
                        }
                    } while (true);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("CHọn từ 1 - 4");
            }
        } while (true);
    }

    public static void deleteProduct(Scanner scanner) {
        if (currentProd == 0) {
            System.out.println("Chưa có dữ liệu");
            return;
        }
        System.out.println("Nhập vào id cần xoá");
        String id = scanner.nextLine();

        int indexDelete = findProductId(id);

        if (indexDelete == -1) {
            System.out.println("Không tìm thấy id");
            return;
        }

        for (int i = 0; i < currentInvoice; i++) {
            Invoice invoice = arrInvoice[i];
            InvoiceDetail[] details = invoice.getInvoiceDetails();
            if (details != null) {
                for (int j = 0; j < details.length; j++) {
                    if (details[j] != null && details[j].getProduct() != null) {
                        if (details[j].getProduct().getProductId().equals(id)) {
                            System.out.println("Tồn tại sản phẩm trong hoá đơn. Không thể xoá");
                            return;
                        }
                    }
                }
            }
        }

        for (int i = indexDelete; i < currentProd - 1; i++) {
            arrProd[i] = arrProd[i + 1];
        }
        arrProd[currentProd - 1] = null;
        currentProd--;
    }

    public static void searchProductByName(Scanner scanner) {
        if (currentProd == 0) {
            System.out.println("Chưa có dữ liệu");
            return;
        }

        System.out.println("Nhập vào tên sản phẩm cần tìm: ");
        String name = scanner.nextLine();
        int count = 0;
        for (int i = 0; i < currentProd; i++) {
            if (arrProd[i].getProductName().toLowerCase().contains(name.toLowerCase())) {
                arrProd[i].displayData();
                count++;
            }
        }
        System.out.println("Tìm thấy " + count + " Sản phẩm liên quan");
    }

    public static int findProductId(String id) {
        for (int i = 0; i < currentProd; i++) {
            if (arrProd[i].getProductId().toLowerCase().contains(id.toLowerCase())) {
                return i;
            }
        }
        return -1;
    }

    public static void mainInvoice() {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("=============== QUẢN LÝ HÓA ĐƠN =================");
            System.out.println("1. Thêm hóa đơn");
            System.out.println("2. Hiển thị danh sách hóa đơn");
            System.out.println("3. Cập nhật thông tin hóa đơn");
            System.out.println("4. Xóa hóa đơn");
            System.out.println("5. Tìm hóa đơn theo mã");
            System.out.println("6. Tìm hóa đơn theo tên khách hàng");
            System.out.println("7. Thoát");
            System.out.println("=================================================");
            System.out.print("Lựa chọn của bạn: ");
            int subChoice = Integer.parseInt(scanner.nextLine());

            switch (subChoice) {
                case 1:
                    System.out.println("--> Chức năng: Thêm hóa đơn mới...");
                    inputInvoice(scanner);
                    break;
                case 2:
                    System.out.println("--> Chức năng: Hiển thị danh sách hóa đơn...");
                    displayInvoice();
                    break;
                case 3:
                    System.out.println("--> Chức năng: Cập nhật hóa đơn...");
                    updateInvoice(scanner);
                    break;
                case 4:
                    System.out.println("--> Chức năng: Xóa hóa đơn...");
                    deleteInvoice(scanner);
                    break;
                case 5:
                    System.out.println("--> Chức năng: Tìm kiếm theo mã hóa đơn...");
                    searchInvoiceById(scanner);
                    break;
                case 6:
                    System.out.println("--> Chức năng: Tìm kiếm theo tên khách hàng...");
                    searchInvoiceByName(scanner);
                    break;
                case 7:
                    System.out.println("... Quay lại menu chính.");
                    return;
                default:
                    System.out.println("!! Lựa chọn không hợp lệ (Nhập từ 1-7).");
            }
            System.out.println();

        } while (true);
    }

    public static void inputInvoice(Scanner scanner) {
        if (currentProd == 0) {
            System.out.println("Chưa có sản phẩm nào trong hệ thống!");
            return;
        }
        arrInvoice[currentInvoice] = new Invoice();
        arrInvoice[currentInvoice].inputData(scanner, arrProd, currentProd);
        currentInvoice++;
    }

    public static void displayInvoice() {
        if (currentInvoice == 0) {
            System.out.println("Chưa có hoá đơn trong hệ thống");
            return;
        }
        for (int i = 0; i < currentInvoice; i++) {
            arrInvoice[i].displayInvoice();
        }
    }

    public static void updateInvoice(Scanner scanner) {
        if (currentInvoice == 0) {
            System.out.println("Chưa có hoá đơn trong hệ thống!");
            return;
        }
        System.out.println("Nhập vào mã hoá đơn cần update: ");
        String id = scanner.nextLine();

        int indexUpdate = searchInvoiceById(id);
        if (indexUpdate == -1) {
            System.out.println("Không tìm thấy hoá đơn!");
            return;
        }
        do {
            System.out.println("Lựa chọn thông tin cần cập nhật");
            System.out.println("1. Tên Khách Hàng");
            System.out.println("2. Ngày Tạo");
            System.out.println("3. Hoá đơn chi tiết");
            System.out.println("4. Thoát");
            System.out.println("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Nhập tên: ");
                    arrInvoice[indexUpdate].inputName(scanner);
                    break;
                case 2:
                    System.out.println("Nhập ngày: ");
                    arrInvoice[indexUpdate].inputDate(scanner);
                    break;
                case 3:
                    System.out.println("Nhập thông tin hoá đơn chi tiết");
                    arrInvoice[indexUpdate].invoiceDetails(scanner, arrProd, currentProd);
                    arrInvoice[indexUpdate].totalAmount();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("1-4");

            }
        } while (true);

    }

    public static void deleteInvoice(Scanner scanner) {
        if (currentInvoice == 0) {
            System.out.println("Chưa có dữ liệu trong hệ thống!");
            return;
        }
        System.out.println("Nhập vào mã hoá đơn: ");
        String id = scanner.nextLine();

        int indexDelete = searchInvoiceById(id);
        if (indexDelete == -1) {
            System.out.println("Không tìm thấy mã hoá đơn");
            return;
        }

        for (int i = indexDelete; i < currentInvoice; i++) {
            arrInvoice[i] = arrInvoice[i + 1];
        }
        arrInvoice[currentInvoice - 1] = null; // Xoá tham chiếu của phần tử cuối cùng trong mảng
        currentInvoice--;
    }

    public static void searchInvoiceById(Scanner scanner) {
        if (currentInvoice == 0) {
            System.out.println("Chưa có dữ liệu");
            return;
        }
        System.out.println("Nhập vào mã hoá đơn: ");
        String id = scanner.nextLine();

        int indexSearch = searchInvoiceById(id);
        if (indexSearch == -1) {
            System.out.println("Không tìm thấy hoá đơn");
            return;
        }
        arrInvoice[indexSearch].displayInvoice();
    }

    public static void searchInvoiceByName(Scanner scanner) {
        if (currentInvoice == 0) {
            System.out.println("Chưa có dữ liệu");
            return;
        }
        System.out.println("Nhập vào tên khách hàng: ");
        String name = scanner.nextLine();

        boolean found = false;

        for (int i = 0; i < currentInvoice; i++) {
            if (arrInvoice[i].getCustomerName().toLowerCase().contains(name.toLowerCase())) {
                arrInvoice[i].displayInvoice();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không thấy khách hàng cần tìm");
        }
    }

    public static int searchInvoiceById(String id) {
        for (int i = 0; i < currentInvoice; i++) {
            if (arrInvoice[i].getInvoiceId().equalsIgnoreCase(id)) {
                return i;
            }
        }
        return -1;
    }

    public static void mainDanhThu() {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("================= QUẢN LÝ DOANH THU =================");
            System.out.println("1. Tính tổng doanh thu tất cả hóa đơn");
            System.out.println("2. Tìm hóa đơn có giá trị lớn nhất");
            System.out.println("3. Thống kê số hóa đơn theo khoảng ngày (nhập từ - đến)");
            System.out.println("4. Thống kê tổng doanh thu theo khoảng ngày");
            System.out.println("5. Thoát");
            System.out.println("=====================================================");
            System.out.print("Lựa chọn của bạn: ");

            int subChoice = Integer.parseInt(scanner.nextLine());

            switch (subChoice) {
                case 1:
                    System.out.println("--> Đang tính toán: Tổng doanh thu toàn bộ cửa hàng...");
                    totalAmount();
                    break;
                case 2:
                    System.out.println("--> Đang tìm kiếm: Hóa đơn có giá trị cao nhất...");
                    searchMaxInvoice();
                    break;
                case 3:
                    System.out.println("--> Chức năng: Đếm số hóa đơn trong khoảng thời gian...");
                    System.out.println("    (Gợi ý: Nhập ngày bắt đầu và ngày kết thúc)");
                    countInvoice(scanner);
                    break;
                case 4:
                    System.out.println("--> Chức năng: Tính tổng tiền thu được trong khoảng thời gian...");
                    totalRevenueByDateRange(scanner);
                    break;
                case 5:
                    System.out.println("... Quay lại menu chính.");
                    return;
                default:
                    System.out.println("!! Lựa chọn không hợp lệ (Nhập từ 1-5).");
            }
            System.out.println(); // Dòng trống cho thoáng

        } while (true);
    }

    public static void totalAmount() {
        if (currentInvoice == 0) {
            System.out.println("Chưa có hoá đơn nào!");
            return;
        }
        double totalAmount = 0;

        for (int i = 0; i < currentInvoice; i++) {
            totalAmount += arrInvoice[i].getTotalAmount();
        }
        System.out.println("Total amount: " + totalAmount);
    }

    public static void searchMaxInvoice() {
        if (currentInvoice == 0) {
            System.out.println("Chưa có dữ liệu");
            return;
        }

        Invoice maxInvoice = arrInvoice[0];

        for (int i = 1; i < currentInvoice; i++) {
            if (arrInvoice[i].getTotalAmount() > maxInvoice.getTotalAmount()) {
                maxInvoice = arrInvoice[i];
            }
        }
        System.out.println("Hoá đơn cao nhất: ");
        maxInvoice.displayInvoice();
    }

    public static void countInvoice(Scanner scanner) {
        if (currentInvoice == 0) {
            System.out.println("Chưa có dữ liệu}");
            return;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        try {
            int count = 0;
            System.out.println("Nhập vào khoảng thời gian từ: ");
            Date date1 = sdf.parse(scanner.nextLine());
            System.out.println("Đến: ");
            Date date2 = sdf.parse(scanner.nextLine());

            for (int i = 0; i < currentInvoice; i++) {
                if (arrInvoice[i] != null) {
                    Date date = arrInvoice[i].getInvoiceDate();
                    if (!date.before(date1) && !date.after(date2)) {
                        count++;
                    }
                }
            }
            System.out.println("Số lượng hoá đơn trong khoảng ngày: " + count);
        } catch (Exception e) {
            System.out.println("Vui lòng nhập đúng format date" + e.getMessage());
        }


    }

    public static void totalRevenueByDateRange(Scanner scanner) {
        if (currentInvoice == 0) {
            System.out.println("Chưa có giữ liệu");
            return;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);

        try {
            System.out.println("Nhập vào ngày bắt đầu: ");
            Date date1 = sdf.parse(scanner.nextLine());
            System.out.println("Đến: ");
            Date date2 = sdf.parse(scanner.nextLine());
            double totalRevenue = 0;
            for (int i = 0; i < currentInvoice; i++) {
                if (arrInvoice[i] != null) {
                    Date date = arrInvoice[i].getInvoiceDate();
                    if (!date.before(date1) && !date.after(date2)) {
                        totalRevenue += arrInvoice[i].totalAmount();
                    }
                }
            }
            System.out.println("Total revenue: " + totalRevenue);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
