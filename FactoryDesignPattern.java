abstract class VehicleF {
    public abstract void printVehicle();
}

class TwoWheeler extends VehicleF {
    public void printVehicle() {
        System.out.println("Two Wheeler!");
    }
}

class ThreeWheeler extends VehicleF {
    public void printVehicle() {
        System.out.println("Three Wheeler!");
    }
}

interface VehicleFactory {
    VehicleF createVehicle();
}

class TwoWheelerFactory implements VehicleFactory {
    public TwoWheeler createVehicle() {
        return new TwoWheeler();
    }
}

class ThreeWheelerFactory implements VehicleFactory {
    public ThreeWheeler createVehicle() {
        return new ThreeWheeler();
    }
}

class Client {
    private VehicleF pVehicle;
    public Client(VehicleFactory vFactory) {
        pVehicle = vFactory.createVehicle();
    }

    public VehicleF getVehicle() {
        return pVehicle;
    }
}

public class FactoryDesignPattern {
    public static void main(String[] args) {
        VehicleFactory twoWheeler = new TwoWheelerFactory();
        Client twoClient = new Client(twoWheeler);
        twoClient.getVehicle();
        VehicleF twovehicle = twoClient.getVehicle();
        twovehicle.printVehicle();

        VehicleFactory threeWheeler = new ThreeWheelerFactory();
        Client threeClient = new Client(threeWheeler);
        threeClient.getVehicle();
        VehicleF threevehicle = threeClient.getVehicle();
        threevehicle.printVehicle();
    }    
}
