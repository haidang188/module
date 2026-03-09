package ss_4.bai_tap.bai1;

import java.util.Scanner;

public class QuadraticEquationManagement {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap a: ");
        double a = sc.nextDouble();
        System.out.println("Nhap b: ");
        double b = sc.nextDouble();
        System.out.println("Nhap c: ");
        double c = sc.nextDouble();

        QuadraticEquation equation = new QuadraticEquation(a, b, c);
        double delta = equation.getDiscriminant();
        System.out.println("Your equation: " + equation.display());
        if (delta < 0) {
            System.out.println("Phuong trinh vo nghiem");
        } else if (delta == 0) {
            System.out.println("Phuong trinh co nghiem kep: x = " + equation.getRoot1());
        } else {
            System.out.println("Phuong trinh co 2 nghiem: ");
            System.out.println("x1 = " + equation.getRoot1());
            System.out.println("x2 = " + equation.getRoot2());
        }


    }
}
