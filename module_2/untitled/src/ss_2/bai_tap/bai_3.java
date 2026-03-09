package ss_2.bai_tap;

public class bai_3 {
    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        System.out.println("Cac so nguyen to nho hon 100 la: ");
        for (int N = 2; N < 100; N++) {
            if (isPrime(N)) {
                System.out.print(N + " ");
            }
        }
    }
}
