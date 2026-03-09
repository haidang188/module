package project_3.model;

public class Motor extends Vehicle {
    private int engine;

    public Motor(String licensePlate, String manufacturerName, int manufacturerYear, String ownerName, int engine) {
        super(licensePlate, manufacturerName, manufacturerYear, ownerName);
        this.engine = engine;
    }

    public int getEngine() {
        return engine;
    }

    public void setEngine(int engine) {
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Motor{" +
                super.toString() +
                "engine=" + engine +
                '}';
    }
}
