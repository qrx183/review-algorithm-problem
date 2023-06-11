package codetop_byte.q0611;

import java.util.Arrays;
import java.util.Scanner;

public class LogThrottling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] records = new int[N];
        int sum = 0;
        for(int i = 0; i < N; i++) {

            records[i] = scanner.nextInt();
            sum += records[i];
        }
        int total = scanner.nextInt();
        if(sum <= total) {
            System.out.println(-1);
            return;
        }
        Arrays.sort(records);
        int i = N-1;
        while(i >= 0 && sum-records[i] > total) {
            sum-=records[i];
            i--;
        }
        if(i >= 0) {
            sum-=records[i];
        }
        i--;

        while(i >= 0 && (total-sum) / (N-i-1) < records[i]){
            sum -= records[i];
            i--;
        }
        System.out.println((total-sum) / (N-i-1));

    }
}
