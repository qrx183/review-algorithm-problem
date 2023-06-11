package codetop_byte.q0608;

import java.util.Scanner;


public class SmoothedValue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = i+1;
        }

        int tmp = arr[1];
        arr[1] = arr[k];
        arr[k] = tmp;
        for(int i = 0; i < n; i++) {
            if(i < n-1) {
                System.out.print(arr[i] + " ");
            }else{
                System.out.print(arr[i]);
            }
        }
    }
}
