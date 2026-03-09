package ss_3.thuc_hanh;
// Tham trị
public class demo1 {

    public static void swap(int num1, int num2) {
        int temp = num1;
        num1 = num2;
        num2 = temp;
        System.out.println("num1 = " + num1 + " num2 = " + num2);
    }
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 5;
        swap(num1, num2);
        System.out.println("num1 = " + num1 + " num2 = " + num2);
    }
}
