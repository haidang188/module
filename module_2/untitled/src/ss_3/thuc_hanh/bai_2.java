package ss_3.thuc_hanh;
// Tìm giá trị trong mảng
import java.util.Scanner;

public class bai_2 {
    public static void main(String[] args) {

        String[] students = {"Nguyen", "Ha", "Hai", "Dang", "Ha Tinh", "Da Nang", "Nghe An"};
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a name's student: ");
        String input = sc.nextLine();

        boolean isExist = false;
        for (int i = 0; i < students.length; i++) {
            if (students[i].equals(input)) {
                System.out.println("Position of the students in the list " + input + " is: " + i);
                isExist = true;
                break;
            }
        }
        if (!isExist) {
            System.out.println("Not found" + input + "in the list.");
        }
    }
}
