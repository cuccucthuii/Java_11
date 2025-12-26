package abstraction;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {

        //Khởi tạo đối tượng gián tiếp từ lớp Persion
        // Bắt buộc phải triển khai phương thức trừu tượng của nó
        Persion persion = new Persion() {
            @Override
            public void inputData(Scanner scanner) {

            }

            @Override
            public void displayData() {

            }
        };
    }
}
