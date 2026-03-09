package project_3.model;

public class Truck extends Vehicle {
    private double payloadCapacity;

    public Truck(String licensePlate, String manufacturerName, int manufacturerYear, String ownerName, double payloadCapacity) {
        super(licensePlate, manufacturerName, manufacturerYear, ownerName);
        this.payloadCapacity = payloadCapacity;
    }

    public double getPayloadCapacity() {
        return payloadCapacity;
    }

    public void setPayloadCapacity(double payloadCapacity) {
        this.payloadCapacity = payloadCapacity;
    }

    @Override
    public String toString() {
        return "Truck{" +
                super.toString() +
                "payloadCapacity=" + payloadCapacity +
                '}';
    }
}
