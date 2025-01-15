class Vehicle2 {
    private String vehicleType;
    private int kmph;

    public void setVehicleType(String newVehicleType) {
        this.vehicleType = newVehicleType;
    }

    public void setKmph(int newKmph) {
        this.kmph = newKmph;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public int getKmph() {
        return kmph;
    }
}

public class Encapsulation {
    public static void main(String args[]) {
        Vehicle2 v = new Vehicle2();
        v.setVehicleType("Car");
        v.setKmph(60);

        System.out.println("Vehicle Type: " + v.getVehicleType());
        System.out.println("Kilometer per hour: " + v.getKmph());
    }
}
