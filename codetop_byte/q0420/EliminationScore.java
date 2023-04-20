package codetop_byte.q0420;

import java.util.Arrays;
import java.util.Scanner;

public class EliminationScore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int[] scores = new int[n];
        for(int i = 0; i < n; i++) {
            scores[i] = scanner.nextInt();
        }
        Arrays.sort(scores);
        int l = x-1;
        while(l < n && !(n-l-1 >= x && n-l-1<=y) && l <= y){
            l++;
        }
        if(isValid(n,l,x,y)){
            System.out.println(scores[l]);
        }else{
            System.out.println(-1);
        }
    }
    private static boolean isValid(int n,int index,int x,int y) {
        return index+1 >= x && index+1 <= y && (n-index-1)>=x && (n-index-1)<=y;
    }

}
