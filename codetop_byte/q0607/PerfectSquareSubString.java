package codetop_byte.q0607;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PerfectSquareSubString {
    private static long[] arr = new long[100000];
    static {
        for(int i = 0; i < arr.length; i++) {
            arr[i] = (long) (i + 1) *(i+1);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int l = scanner.nextInt();
        int r = scanner.nextInt();
        char[] chs = new char[100005];
        int i = 1;
        int index = 0;
        Map<Character,Integer> map = new HashMap<>();
        while(i <= r) {
            String s = arr[index] + "";
            for(int j = 0; j < s.length(); j++) {
                chs[i] = s.charAt(j);
                if(i >= l) {
                    map.put(chs[i],map.getOrDefault(chs[i],0)+1);
                }
                i++;
                if(i > r) {
                    break;
                }
            }
            if(i > r) {
                break;
            }
            chs[i] = ',';

            if(i >= l) {
                map.put(',',map.getOrDefault(',',0)+1);
            }
            i++;
            index++;
        }
        i = 0;
        for(; i <= 10; i++) {
            if(i < 10) {
                System.out.println((i+"") + ":" + (map.get((char)(i+'0')) == null ? 0 : map.get((char)(i+'0'))));
            }else{
                System.out.println(",:" + (map.get(',') == null ? 0 : map.get(',')));
            }
        }
    }
}
