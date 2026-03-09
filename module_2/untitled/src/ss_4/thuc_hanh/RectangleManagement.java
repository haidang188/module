package ss_4.thuc_hanh;

import java.util.Scanner;

public class RectangleManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a width: ");
        double width = sc.nextDouble();
        System.out.println("Enter a height: ");
        double height = sc.nextDouble();

        Rectangle rectangle = new Rectangle(width, height);
        System.out.println("Your rectangle is: " + rectangle.display());
        System.out.println("Perimeter is: " + rectangle.getPerimeter());
        System.out.println("Area is: " + rectangle.getArea());
    }
}
