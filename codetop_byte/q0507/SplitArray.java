package codetop_byte.q0507;

public class SplitArray {
    public int splitArray(int[] nums, int k) {

        // 感觉像是二分,但是没有想明白怎么去构造二分的情景
        int n = nums.length;
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        int avg = sum / k;
        int res = 0;
        return -1;
    }
}
