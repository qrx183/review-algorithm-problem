package codetop_byte.q0528;

import java.util.Arrays;
import java.util.Scanner;

public class AircraftBattle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int n = scanner.nextInt();
        int[] ress = new int[t];
        for(int i = 0; i < t; i++) {
            int[] arr = new int[n];
            for(int j = 0; j < n; j++) {
                arr[j] = scanner.nextInt();
            }
            Arrays.sort(arr);
            int k = 0;
            int res = 0;
            while(k < n) {
                if(k+1 < n && arr[k] == arr[k+1] && arr[k] == 1) {
                    res++;
                    k+=2;
                }else{
                    res++;
                    k+=1;
                }
            }
            ress[i] = res;
        }
        for(int res : ress) {
            System.out.println(res);
        }
    }
}
