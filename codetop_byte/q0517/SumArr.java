package codetop_byte.q0517;

import java.util.*;

public class SumArr {
    public static void main(String[] args) {
        // 删除一个元素求数量为k的连续子数组的最大和其实就是求数量为k+1的连续子数组的和-该子数组中的最小值后的最大值,所以只需要维护一个优先队列即可
        // 靠靠靠,想不到啊.呜呜呜呜
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] nums = new int[n];
        Deque<Integer> d = new LinkedList<>();
        PriorityQueue<int[]> p = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int sum = 0;
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            nums[i]  = scanner.nextInt();
            int num = nums[i];
            p.offer(new int[]{i,num});
            sum += num;
            if(i >= k) {
                while(p.peek()[0] < i-k) {
                    p.poll();
                }
                res = Math.max(res,sum-p.peek()[1]);
                sum -= nums[i-k];
            }
        }
        System.out.println(res);
    }
}
