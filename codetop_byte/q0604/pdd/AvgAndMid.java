package codetop_byte.q0604.pdd;

import java.util.*;

public class AvgAndMid {
    // 中位数用大小堆去卡中间值
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] C = new int[n];
        long[] sum = new long[n];
        for(int i = 0; i < n; i++) {
            C[i] = scanner.nextInt();
            if(i == 0) {
                sum[i] = C[i];
            }else{
                sum[i] = C[i] + sum[i-1];
            }
        }
        int[] mid = new int[n];
        PriorityQueue<Integer> minD = new PriorityQueue<>();
        PriorityQueue<Integer> maxD = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for(int i = 0; i < n; i++) {
            if(i % 2 == 0) {
                // 奇数,放大顶堆
                if(maxD.isEmpty() || C[i] <= minD.peek()) {
                    maxD.offer(C[i]);
                }else{
                    int num = minD.poll();
                    minD.offer(C[i]);
                    maxD.offer(num);
                }
                mid[i] = maxD.peek();
            }else{
                // 偶数,放小顶堆
                if(minD.isEmpty() || C[i] >= maxD.peek()) {
                    minD.offer(C[i]);
                }else{
                    int num = maxD.poll();
                    maxD.offer(C[i]);
                    minD.offer(num);
                }
                mid[i] = minD.peek();
            }
        }
        for(int i = 0; i < n; i++) {
            if(i < n-1) {
                System.out.print((sum[i] % (i+1) == 0 ? sum[i]/(i+1) : sum[i]/(i+1) + 1) + " ");
            }else{
                System.out.println(sum[i] % (i+1) == 0 ? sum[i]/(i+1) : sum[i]/(i+1) + 1);
            }
        }
        for(int i = 0; i < n; i++) {
            if(i < n-1) {
                System.out.print(mid[i] + " ");
            }else{
                System.out.println(mid[i]);
            }
        }
    }
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] C = new int[n];
        long[] sum = new long[n];
        for(int i = 0; i < n; i++) {
            C[i] = scanner.nextInt();
            if(i == 0) {
                sum[i] = C[i];
            }else{
                sum[i] = C[i] + sum[i-1];
            }
        }
        int[] mid = new int[n];
        List<Integer> l = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(i == 0 || mid[i] >= l.get(l.size()-1)) {
                l.add(C[i]);
                mid[i] = l.get(l.size()/2);
            }else{
                int index = binarySearch(l,C[i]);
                l.add(index,C[i]);
                mid[i] = l.get(l.size()/2);
            }
        }
        for(int i = 0; i < n; i++) {
            if(i < n-1) {
                System.out.print((sum[i] % (i+1) == 0 ? sum[i]/(i+1) : sum[i]/(i+1) + 1) + " ");
            }else{
                System.out.println(sum[i] % (i+1) == 0 ? sum[i]/(i+1) : sum[i]/(i+1) + 1);
            }
        }
        for(int i = 0; i < n; i++) {
            if(i < n-1) {
                System.out.print(mid[i] + " ");
            }else{
                System.out.println(mid[i]);
            }
        }
    }

    private static int binarySearch(List<Integer> list, int taregt) {
        int l = 0,r = list.size()-1;
        while(l < r) {
            int mid = l + r >> 1;
            if(list.get(mid) >= taregt) {
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        return list.get(l) >= taregt ? l : l + 1;
    }
}
