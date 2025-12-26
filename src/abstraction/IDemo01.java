package abstraction;

import javax.swing.plaf.PanelUI;
import java.util.Scanner;

public interface IDemo01 {
    // Chỉ chứa các hằng số  và phương thức trừu tượng (Trước Java 8)
    // Các bổ từ truy cập mặc định và bắt buộc là Public
    // Các thuộc tính mặc định là Static Final (Hằng số)
    // Các phương thức mặc định là Abstract

    public float Pi = 3.14f; // Tự hiểu là public static final
    float MARK_PASS = 5;

    public abstract void inputData(Scanner scanner);
    void displayData();

}
