package codetop_byte.q0308;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class AddStrings {
    public String addStrings(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();

        char[] res = new char[Math.max(m,n)+1];
        Arrays.fill(res,'0');
        int i = m-1,j = n-1;
        int k = res.length-1;
        int plus = 0;
        while(i >= 0 && j >= 0) {
            int n1 = Integer.parseInt(num1.charAt(i)+"");
            int n2 = Integer.parseInt(num2.charAt(j)+"");
            res[k--] = String.valueOf((n1+n2+plus)%10).charAt(0);
            if (n1 + n2 + plus >= 10) {
                plus = 1;
            }else {
                plus = 0;
            }

            i--;
            j--;
        }
        while(i >= 0) {
            int n1 = Integer.parseInt(num1.charAt(i)+"");
            res[k--] = String.valueOf((n1+plus)%10).charAt(0);
            if (n1 + plus >= 10) {
                plus = 1;
            }else {
                plus = 0;
            }

            i--;
        }
        while(j >= 0) {
            int n2 = Integer.parseInt(num2.charAt(j)+"");
            res[k--] = String.valueOf((n2+plus)%10).charAt(0);
            if (n2 + plus >= 10) {
                plus = 1;
            }else {
                plus = 0;
            }

            j--;
        }
        if (plus == 1){
            res[k--] = '1';
        }
        StringBuilder ans = new StringBuilder();
        for (int index = 0; index < res.length; index++) {
            if(index == 0 && res[index] == '0') {
                continue;
            }
            ans.append(res[index]);
        }
        return ans.toString();
    }
    @Test
    public void show() {
        String num1 = "11";
        String num2 = "123";
        System.out.println(addStrings(num1,num2));
    }
}
