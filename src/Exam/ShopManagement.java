package Exam;

import java.util.Scanner;

public class ShopManagement {
    public static Categories[] arrCatelog = new Categories[100];
    public static int currentCatelog = 0;

    public static Product[] arrProduct = new Product[100];
    public static int currentProduct = 0;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShopManagement sm = new ShopManagement();
        do {
            System.out.println("******************SHOP MENU*******************");
            System.out.println("1. Quản lý danh mục sản phẩm");
            System.out.println("2. Quản lý sản phẩm");
            System.out.println("3. Thoát");
            System.out.println("Lựa chọn của bạn:");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    sm.catelogMenu();
                    break;
                case 2:
                    sm.productMenu();
                    break;
                case 3:
                    System.out.println("Tạm biệt!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Chọn từ 1 - 3");
            }
        } while (true);
    }

    public void catelogMenu() {
        Scanner scanner = new Scanner(System.in);
        ShopManagement sm = new ShopManagement();
        do {
            System.out.println("*****************CATEGORIES MENU*******************");
            System.out.println("1. Nhập thông tin các danh mục");
            System.out.println("2. Hiển thị thông tin các danh mục");
            System.out.println("3. Cập nhật thông tin danh mục");
            System.out.println("4. Xóa danh mục");
            System.out.println("5. Cập nhật trạng thái danh mục");
            System.out.println("6. Thoát");
            System.out.println("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    sm.inputCatelog(scanner);
                    break;
                case 2:
                    sm.displayCatelog();
                    break;
                case 3:
                    sm.updateCatelog(scanner);
                    break;
                case 4:
                    sm.deleteCatelog(scanner);
                    break;
                case 5:
                    sm.updateStatusCatelog(scanner);
                    break;
                case 6:
                    System.out.println("Tạm biệt!");
                    return;
                default:
                    System.out.println("Chọn từ 1 - 6");

            }
        } while (true);
    }

    public void inputCatelog(Scanner scanner) {
        System.out.println("Nhập số lượng danh mục cần thêm: ");
        int index = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < index; i++) {
            System.out.printf("Nhập thông tin danh mục thứ %d", i + 1);
            System.out.println();
            arrCatelog[i] = new Categories();
            arrCatelog[i].inputData(scanner, arrCatelog, currentCatelog);
            currentCatelog++;
        }
    }

    public void displayCatelog() {
        for (int i = 0; i < currentCatelog; i++) {
            arrCatelog[i].displayData();
        }
    }

    public void updateCatelog(Scanner scanner) {
        System.out.println("Nhập vào ID cần cập nhật: ");
        int id = Integer.parseInt(scanner.nextLine());

        int indexUpdate = searchCatelogId(id);
        if (indexUpdate == -1) {
            System.out.println("ID không tồn tại");
            return;
        }
        boolean isExist = false;
        do {
            System.out.println("Lựa chọn thay đổi giá trị cho Categories");
            System.out.println("1. Sửa thông tin name: ");
            System.out.println("2. Sửa thông tin description: ");
            System.out.println("3. Sửa thông tin status (true/false): ");
            System.out.println("4. Huỷ");
            System.out.println("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Nhập tên cần sửa: ");
                    arrCatelog[indexUpdate].setCatalogName(scanner.nextLine());
                    break;
                case 2:
                    System.out.println("Nhập vào mô tả cần sửa: ");
                    arrCatelog[indexUpdate].setDescription(scanner.nextLine());
                    break;
                case 3:
                    System.out.println("Nhâp vào status (true/false): ");
                    arrCatelog[indexUpdate].setCatalogStatus(Boolean.parseBoolean(scanner.nextLine()));
                    break;
                case 4:
                    isExist = true;
                    break;
                default:
                    System.out.println("Chọn từ 1 - 4");
            }
        } while (!isExist);
    }

    public static int searchCatelogId(int idCatelog) {
        for (int i = 0; i < currentCatelog; i++) {
            if (arrCatelog[i].getCatalogId() == idCatelog) {
                return i;
            }
        }
        return -1;
    }

    public void deleteCatelog(Scanner scanner) {
        System.out.println("Nhập vào id cần xoá: ");
        int id = Integer.parseInt(scanner.nextLine());

        int indexDelete = searchCatelogId(id);
        if (indexDelete == -1) {
            System.err.println("Không tìm thấy ID!");
            return;
        }
        for (int i = 0; i < currentProduct; i++) {
            if (arrProduct[i].getCatalogId() == id) {
                System.out.println("Danh mục đang có sản phẩm tồn tại. Không thể xoá!");
                return;
            }
        }
        // Tiến hành xoá
        for (int i = 0; i < currentCatelog; i++) {
            arrCatelog[i] = arrCatelog[i + 1];
        }
        currentCatelog--;
        System.out.printf("Xoá thành công danh mục với id %d ", id);
    }

    public void updateStatusCatelog(Scanner scanner) {
        System.out.println("Nhập vào id cần cập nhật: ");
        int id = Integer.parseInt(scanner.nextLine());

        int indexUpdate = searchCatelogId(id);
        if (indexUpdate == -1) {
            System.out.println("Không tìm thấy ID!");
            return;
        }

        System.out.println("Nhâp vào status (true/false): ");
        arrCatelog[indexUpdate].setCatalogStatus(Boolean.parseBoolean(scanner.nextLine()));
    }

    // Product

    public void productMenu() {
        Scanner scanner = new Scanner(System.in);
        ShopManagement sm = new ShopManagement();
        do {
            System.out.println("******************PRODUCT MANAGEMENT*******************");
            System.out.println("1. Nhập thông tin các sản phẩm");
            System.out.println("2. Hiển thị thông tin các sản phẩm");
            System.out.println("3. Sắp xếp các sản phẩm theo giá");
            System.out.println("4. Cập nhật thông tin sản phẩm theo mã sản phẩm");
            System.out.println("5. Xóa sản phẩm theo mã sản phẩm");
            System.out.println("6. Tìm kiếm các sản phẩm theo tên sản phẩm");
            System.out.println("Tìm kiếm sản phẩm trong khoảng giá a – b (a,b nhập từ bàn phím)");
            System.out.println("8. Thoát");
            System.out.println("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    sm.inputData(scanner);
                    break;
                case 2:
                    sm.displayProduct();
                    break;
                case 3:
                    System.out.println("Lua chon sap xep");
                    System.out.println("1. Tang dan");
                    System.out.println("2. Giam dan");

                    System.out.println("Lua chon cua ban: ");
                    int choice1 = Integer.parseInt(scanner.nextLine());
                    switch (choice1) {
                        case 1:
                            sm.sortProductByPriceASC();
                            break;
                        case 2:
                            sm.sortProductByPriceDESC();
                            break;
                        default:
                            System.out.println("Chon tu 1 - 3");
                    }
                    break;
                case 4:
                    sm.updateProductById(scanner);
                    break;
                case 5:
                    sm.deleteProductById(scanner);
                    break;
                case 6:
                    sm.searchProductByName(scanner);
                    break;
                case 7:
                    sm.searchProductByPrice(scanner);
                    break;
                case 8:
                    System.out.println("Tạm biệt!");
                    return;
                default:
                    System.out.println("Chọn từ 1 - 8");
            }

        } while (true);
    }

    public void inputData(Scanner scanner) {
        if (currentCatelog == 0) {
            System.out.println("Chưa tồn tại danh mục. Không thể thêm sản phẩm");
            return;
        }

        System.out.println("Nhập số lượng sản phẩm cần thêm: ");
        int index = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < index; i++) {
            System.out.printf("Nhập thông tin sản phẩm thứ %d", i + 1);
            System.out.println();
            arrProduct[i] = new Product();
            arrProduct[i].inputData(scanner, arrProduct, currentProduct, arrCatelog, currentCatelog);
            currentProduct++;
        }
    }

    public void displayProduct() {
        if (currentProduct == 0) {
            System.out.println("chưa có sản phẩm");
            return;
        }

        for (int i = 0; i < currentProduct; i++) {
            arrProduct[i].displayData();
        }
    }

    public void sortProductByPriceASC() {
        if (currentProduct == 0) {
            System.out.println("Chưa có sản phẩm");
            return;
        }

        for (int i = 0; i < currentProduct; i++) {
            for (int j = i + 1; j < currentProduct; j++) {
                if (arrProduct[i].getPrice() > arrProduct[j].getPrice()) {
                    Product temp = arrProduct[i];
                    arrProduct[i] = arrProduct[j];
                    arrProduct[j] = temp;
                }
            }
        }
        System.out.println("Sản phẩm sau khi sắp xếp!");
        for (int i = 0; i < currentProduct; i++) {
            arrProduct[i].displayData();
        }
    }

    public void sortProductByPriceDESC() {
        if (currentProduct == 0) {
            System.out.println("Chua co du lieu!");
            return;
        }
        for (int i = 0; i < currentProduct; i++) {
            for (int j = i + 1; j < currentProduct; j++) {
                if (arrProduct[i].getPrice() < arrProduct[j].getPrice()) {
                    Product temp = arrProduct[i];
                    arrProduct[i] = arrProduct[j];
                    arrProduct[j] = temp;
                }
            }
        }
        System.out.println("Sản phẩm sau khi sắp xếp!");
        for (int i = 0; i < currentProduct; i++) {
            arrProduct[i].displayData();
        }
    }

    public void updateProductById(Scanner scanner) {
        if (currentProduct == 0) {
            System.out.println("Chưa có dữ liệu!");
            return;
        }

        System.out.println("Nhập vào ID sản phẩm cần update: ");
        int id = Integer.parseInt(scanner.nextLine());

        int indexUpdate = searchProductId(id);
        if (indexUpdate == -1) {
            System.out.println("Sản phẩm không tồn tại với id = " + id);
            return;
        }

        do {
            System.out.println("Lựa chọn thông tin cần cập nhật: ");
            System.out.println("1. Sửa thông tin tên sản phẩm: ");
            System.out.println("2. Sửa thông tin giá sản phẩm: ");
            System.out.println("3. Sửa thông tin mô tả sản phẩm: ");
            System.out.println("4. Sửa thông tin danh mục sản phẩm: ");
            System.out.println("5. Sửa thông tin trạng thái sản phẩm: ");
            System.out.println("6. Thoát");
            System.out.println("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Nhập vào tên: ");
                    arrProduct[indexUpdate].setProductName(scanner.nextLine());
                    break;
                case 2:
                    System.out.println("Nhập vào giá: ");
                    arrProduct[indexUpdate].setPrice(Float.parseFloat(scanner.nextLine()));
                    break;
                case 3:
                    System.out.println("Nhậpv vào mô tả: ");
                    arrProduct[indexUpdate].setDescription(scanner.nextLine());
                    break;
                case 4:
                    System.out.println("Lựa chọn danh mục");
                    boolean isExist = false; // biến check
                    do {
                        for (int i = 0; i < currentCatelog; i++) {
                            System.out.println("ID: " + arrCatelog[i].getCatalogId() + " - Tên danh mục: " + arrCatelog[i].getCatalogName());
                        }
                        System.out.println("Lựa chọn của bạn: ");
                        int choice1 = Integer.parseInt(scanner.nextLine());
                        for (int i = 0; i < currentCatelog; i++) {
                            if (arrCatelog[i].getCatalogId() == choice1) {
                                isExist = true;
                                break;
                            }
                        }
                        if (!isExist) {
                            System.err.println("Vui lòng chọn danh mục có sẵn");
                        }else {
                            arrProduct[indexUpdate].setCatalogId(choice1);
                            break;
                        }
                    } while (true);
                    break;
                case 5:
                    System.out.println("Nhập vào trạng thái sản phẩm");
                    System.out.println("0 - Đang bán");
                    System.out.println("1 - Hết hàng");
                    System.out.println("2 - Không bán");
                    System.out.println("Lựa chọn của bạn: ");
                    int choice2 = Integer.parseInt(scanner.nextLine());
                    switch (choice2) {
                        case 0:
                            arrProduct[indexUpdate].setProductStatus(0);
                            break;
                        case 1:
                            arrProduct[indexUpdate].setProductStatus(1);
                            break;
                        case 2:
                            arrProduct[indexUpdate].setProductStatus(2);
                            break;
                        default:
                            System.out.println("Chọn từ 0 - 2");
                    }
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Lựa chọn từ 1 - 6");
            }
        } while (true);

    }

    public void deleteProductById(Scanner scanner) {
        if (currentProduct == 0) {
            System.out.println("Không có dữ liệu sản phẩm");
            return;
        }
        System.out.println("Nhập vào id cần xoá:");
        int id = Integer.parseInt(scanner.nextLine());

        int indexDelete = searchProductId(id);
        if (indexDelete == -1) {
            System.out.println("Sản phẩm không tồn tại với id = "+id);
            return;
        }

        for (int i = 0; i < currentCatelog; i++) {
            arrProduct[indexDelete] = arrProduct[indexDelete + 1];
        }
        currentProduct--;
    }

    public int searchProductId(int id) {
        for (int i = 0; i < currentProduct; i++) {
            if (arrProduct[i].getProductid() == id) {
                return i;
            }
        }
        return -1;
    }

    public void searchProductByName(Scanner scanner) {
        if (currentProduct == 0) {
            System.out.println("Chưa có dữ liệu");
            return;
        }
        System.out.println("Nhập vào tên cầm tìm: ");
        String name = scanner.nextLine();

        int count = 0;
        for (int i = 0; i < currentProduct; i++) {
            if (arrProduct[i].getProductName().toLowerCase().contains(name.toLowerCase())) {
                arrProduct[i].displayData();
                count++;
            }
        }
        System.out.printf("Tìm thấy %d sản phẩm liên quan",count);
        System.out.println();
    }

    public void searchProductByPrice(Scanner scanner) {
        if (currentProduct == 0) {
            System.out.println("Chưa có dữ liệu!");
            return;
        }

        System.out.println("Nhập vào giá sản phẩm từ : ");
        float price1 = Float.parseFloat(scanner.nextLine());
        System.out.println("Đến: ");
        float price2 = Float.parseFloat(scanner.nextLine());
        int count = 0;
        for (int i = 0; i < currentProduct; i++) {
            if (arrProduct[i].getPrice() >= price1 && arrProduct[i].getPrice() <= price2) {
                arrProduct[i].displayData();
                count++;
            }
        }
        System.out.println("Tìm thấy tổng sản phẩm: "+count);
    }


}
