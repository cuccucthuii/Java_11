package HomeWork.G2;

public class Laptop extends Device implements Connectable, Chargeable {

    public Laptop(int id, String name) {
        super(id, name);
    }

    @Override
    public void turnOn() {
        System.out.println(name + " đang khởi động");
    }

    @Override
    public void turnOff() {
        System.out.println(name + " đã tắt");
    }

    @Override
    public void connectWifi() {
        System.out.println(name + " đã kết nối WiFi");
    }

    @Override
    public void charge() {
        System.out.println(name + " đang sạc pin");
    }
}

