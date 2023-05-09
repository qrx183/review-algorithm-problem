package codetop_byte.q0509.weizhong_bank;

import java.util.Scanner;

public class IntervalCounting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] A = new int[n];
        int[] B = new int[n];
        for(int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }
        for(int i = 0; i < n; i++) {{
            B[i] = scanner.nextInt();
        }}
        int La = scanner.nextInt();
        int Ra = scanner.nextInt();
        int Lb = scanner.nextInt();
        int Rb = scanner.nextInt();

        int[] sumA = new int[n];
        int[] sumB = new int[n];
        sumA[0] = A[0];
        sumB[0] = B[0];
        for(int i = 1;i < n; i++) {
            sumA[i] = sumA[i-1]+A[i];
            sumB[i] = sumB[i-1]+B[i];
        }

        int res = 0;
        for(int i = 0; i < n; i++) {
            int l = 0, r = i;
            int l1 = func1(sumA,l,r,sumA[i]-Ra);
            int r1 = func2(sumA,l,r,sumA[i]-La);
            int l2 = func1(sumB,l,r,sumB[i]-Rb);
            int r2 = func2(sumB,l,r,sumB[i]-Lb);
            int l3 = Math.max(l1,l2);
            int r3 = Math.min(r1,r2);
            if(La <= sumA[r3]-sumA[l3] && Ra >= sumA[r3]-sumA[l3] && Lb <= sumB[r3]-sumB[l3] && Rb >= sumB[r3]-sumB[l3]){
                res += r3-l3+1;
            }
        }
        System.out.println(res);
    }

    private static int func1(int[] sums,int l,int r,int target) {
        // 找到第一个大于等于的
        while(l < r) {
            int mid = l + r >> 1;
            if(sums[mid] >= target) {
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        return l;
    }
    private static int func2(int[] sums,int l, int r, int target) {
        // 找到第一个小于等于的
        while(l < r) {
            int mid = l + r + 1 >> 1;
            if(sums[mid] <= target) {
                l = mid;
            }else{
                r = mid - 1;
            }
        }
        return l;
    }
}
