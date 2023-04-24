package codetop_byte.q0424;

import java.util.Scanner;

public class DecimalConversion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s= scanner.next();
        int res = 0;
        int index = 0;
        for(int i = s.length()-1; i > 1; i--) {
            char ch = s.charAt(i);
            if(ch >= '0' && ch <= '9') {
                res += (int)(ch-'0') * (int)Math.pow(16,index);
            }else{
                res += (int)(ch-'A'+10) * (int)Math.pow(16,index);
            }
            index++;
        }
        System.out.println(res);
    }
}
