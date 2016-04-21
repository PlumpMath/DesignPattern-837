/**
 * Created by mike on 4/20/16.
 */
class CarProduce {
    private String name;

    public CarProduce(String name) {
        this.name = name;
    }

    public void drive() {
        System.out.println("Driving car " + name);
    }
}

class ShipProduce {
    private String name;

    public ShipProduce(String name) {
        this.name = name;
    }

    public void drive() {
        System.out.println("Driving ship " + name);
    }
}

class VehicleFactory {
    public ShipProduce getShip(String name) {
        return new ShipProduce(name);
    }
    public CarProduce getCar(String name) {
        return new CarProduce(name);
    }
}

public class FactoryPattern {
    public static void main(String[] args) {
        VehicleFactory factory = new VehicleFactory();
        CarProduce myCar = factory.getCar("Benz");
        ShipProduce myShip = factory.getShip("Alpha");
        myCar.drive();
        myShip.drive();
    }
}
