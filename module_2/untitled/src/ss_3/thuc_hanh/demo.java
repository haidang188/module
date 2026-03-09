package ss_3.thuc_hanh;

public class demo {
    /*
    * Syntax
    * AM (access modifier) - static/ non-static - return data type - methodName(list of parameters) {
    *       method boby
    * }
    *
    * return data type: quy định kiểu dữ liệu trả về
    * 1. Không trả về gì: dùng void
    * 2. Có trả về: dùng kiểu dữ liệu tương ứng */

    public static int sum(int num1, int num2) {
        return num1 + num2;
    }

    public static void saySth(String msg) {
        System.out.println(msg);
    }

    public static void main(String[] args) {
        int result = sum(1, 2);
        System.out.println(result);
        saySth("Hello World");
    }
}
