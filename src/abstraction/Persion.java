package abstraction;

import java.util.Scanner;

public abstract class Persion {
    private String name;
    private int age;

    public Persion() {
    }
    public Persion(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // khai bao 1 phuong thuc truu tuong
    public abstract void inputData(Scanner scanner);

    public abstract void displayData();
}
