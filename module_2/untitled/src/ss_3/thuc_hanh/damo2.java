package ss_3.thuc_hanh;
// Tham chiếu
// OCA, OCP: chứng chỉ lập trình chuyên nghiệp
import java.util.Arrays;

public class damo2 {

    public static void swap(int[] nums) {
        int temp = nums[0];
        nums[0] = nums[1];
        nums[1] = temp;
        System.out.println("Trong method " + Arrays.toString(nums));
    }



    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 5;
        int[] nums = {num1, num2};
        swap(nums);
        System.out.println("Ngoai method " + Arrays.toString(nums));
    }
}
