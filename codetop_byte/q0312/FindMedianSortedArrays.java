package codetop_byte.q0312;

public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 寻找两个有序数组的中位数其实就是在找第k小的数字.那么我们可以每次都从nums1,nums2找找到第k/2小的数字索引i,j
        // nums1,nums2中较小的数字索引i之前的数字一定不是第k小的数字,所以可以把这一部分过滤掉,转为找num1[i+1:],nums2中第k-(i之前的数字)
        int m = nums1.length;
        int n = nums2.length;
        if((m+n)%2 == 1) {
            return getNumK(nums1,nums2,(m+n)/2+1)*1.0;
        }else{
            return (getNumK(nums1,nums2,(m+n)/2+1)+getNumK(nums1,nums2,(m+n)/2))/2.0;
        }
    }

    private int getNumK(int[] nums1,int[] nums2,int k) {
        int i1 = 0;
        int i2 = 0;
        int m = nums1.length,n = nums2.length;
        while(true){
            if (i1 == m) {
                return nums2[i2+k-1];
            }
            if (i2 == n) {
                return nums1[i1+k-1];
            }
            if (k == 1){
                return Math.min(nums1[i1],nums2[i2]);
            }
            int half = k / 2;
            int index1 = Math.min(i1+half,m)-1,index2 = Math.min(i2+half,n)-1;
            if(nums1[index1] < nums2[index2]) {
                k -= index1-i1+1;
                i1 = index1+1;
            }else{
                k -= index2-i2+1;
                i2 = index2+1;
            }
        }
    }
}
