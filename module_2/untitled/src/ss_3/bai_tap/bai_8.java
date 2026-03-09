package ss_3.bai_tap;

import java.util.Scanner;

public class bai_8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = "hai dang";

        System.out.println("Nhap ky tu can dem: ");
        char ch = sc.next().charAt(0);
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                count++;
            }
        }
        System.out.println("So lan xuat hien cua '" + ch + "' la: " + count);
    }
}
