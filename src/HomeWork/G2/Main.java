package HomeWork.G2;

public class Main {
    public static void main(String[] args) {

        Device[] devices = new Device[3];
        devices[0] = new SmartPhone(1, "iPhone 15");
        devices[1] = new Laptop(2, "MacBook Pro");
        devices[2] = new Television(3, "Samsung TV");

        for (Device d : devices) {
            d.turnOn();

            if (d instanceof Connectable) {
                ((Connectable) d).connectWifi();
            }

            if (d instanceof Chargeable) {
                ((Chargeable) d).charge();
            }

            d.turnOff();
            System.out.println("----------------------");
        }
    }
}

