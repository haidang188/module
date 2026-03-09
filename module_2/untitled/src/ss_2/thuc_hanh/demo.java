package ss_2.thuc_hanh;

import java.util.Arrays;

public class demo {
    public static void main(String[] args) {
        /*
        Mang
        * Syntax 1D array
        * dataType[] arrName = new dataType[arrLength]
        */

//        // Tao mang co 3 phan tu
//        int[] number = new int[3];
//
//        // Them phan tu vao mang
//        number[0] = 1;
//        number[1] = 2;
//        number[2] = 3;
//
//        // Hien thi mang
//        for (int i = 0; i < 3; i++) {
//            System.out.println(number[i]);
//        }

//        // Khai bao mang 2 chieu
//        int[][] number = new int[3][3];
//        number[1][1] = 5;
//        System.out.println(number[1][1]);


        /* Vong lap */
        // Khoi tao mang truc tiep
//        int[] numbers = {3, 2, 4, 5};
//        for (int i = 0; i < numbers.length; i++) {
//            System.out.println(numbers[i]);
//        }


        /* for-each: dung de duyet mang
        Syntax:
        *  for (dataType varTemp : arrName)
        *   */
//        int[] numbers = {3,2,4,5};
//        for (int num : numbers) {
//            System.out.println(num);
//        }

        // Hien thi mang, khong dung for
        int[] numbers = {3,2,4,5};
        System.out.println(Arrays.toString(numbers));

        // Hien thi mang 2 chieu, khong dung for
        int[][] numbers1 = {{1,2}, {3,4}};
        System.out.println(Arrays.deepToString(numbers1));






    }
}
