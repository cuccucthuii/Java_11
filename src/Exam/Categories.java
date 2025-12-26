package Exam;

import java.util.Scanner;

public class Categories implements IShop{
    private int catalogId;
    private String catalogName;
    private String description;
    private boolean catalogStatus;

    public Categories() {
    }

    public Categories(int catalogId, String catalogName, String description, boolean catalogStatus) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.description = description;
        this.catalogStatus = catalogStatus;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCatalogStatus() {
        return catalogStatus;
    }

    public void setCatalogStatus(boolean catalogStatus) {
        this.catalogStatus = catalogStatus;
    }

    public void inputData(Scanner scanner, Categories[] arrCategories, int index){
        System.out.println("Nhập vào id: ");
        this.catalogId = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập vào name: ");
        this.catalogName = scanner.nextLine();
        System.out.println("Nhập vào description: ");
        this.description = scanner.nextLine();
        System.out.println("Nhập vào status (true/false): ");
        this.catalogStatus = Boolean.parseBoolean(scanner.nextLine());
    }

    @Override
    public void displayData() {
        System.out.println("__________________");
        System.out.println("ID: " + catalogId);
        System.out.println("Name: " + catalogName);
        System.out.println("Description: " + description);
        System.out.println("Status: " + (catalogStatus?"Hoạt động":"Không hoạt động"));
    }

}
