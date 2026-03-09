package project_3.model;

public abstract class Vehicle {
    private String licensePlate;
    private String manufacturerName;
    private int manufacturerYear;
    private String ownerName;

    public Vehicle(String licensePlate, String manufacturerName, int manufacturerYear, String ownerName) {
        this.licensePlate = licensePlate;
        this.manufacturerName = manufacturerName;
        this.manufacturerYear = manufacturerYear;
        this.ownerName = ownerName;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public int getManufacturerYear() {
        return manufacturerYear;
    }

    public void setManufacturerYear(int manufacturerYear) {
        this.manufacturerYear = manufacturerYear;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "licensePlate='" + licensePlate + '\'' +
                ", manufacturerName='" + manufacturerName + '\'' +
                ", manufacturerYear=" + manufacturerYear +
                ", ownerName='" + ownerName + '\'' +
                '}';
    }
}

