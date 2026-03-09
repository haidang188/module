package ss_5.bai_tap.bai1;

public class Circle {
    private double radius = 1.0;
    private String color = "red";

    public Circle() {

    }
    public Circle(double r) {
        radius = r;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getRadius() {
        return radius;
    }

}
