package project_3.model;

public class Car extends Vehicle {
    private int seatCount;
    private String vehicleType;

    public Car(String licensePlate, String manufacturerName, int manufacturerYear, String ownerName, int seatCount, String vehicleType) {
        super(licensePlate, manufacturerName, manufacturerYear, ownerName);
        this.seatCount = seatCount;
        this.vehicleType = vehicleType;
    }
    public Car(String licensePlate, String manufacturerName, int manufacturerYear, int seatCount, String vehicleType) {
        super(licensePlate, manufacturerName, manufacturerYear, vehicleType);
        this.seatCount = seatCount;
        this.vehicleType = vehicleType;
    }


    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    @Override
    public String toString() {
        return "Car{" +
                super.toString() +
                "seatCount=" + seatCount +
                ", vehicleType='" + vehicleType + '\'' +
                '}';
    }
}
