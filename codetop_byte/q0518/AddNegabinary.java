package codetop_byte.q0518;

import java.util.ArrayList;
import java.util.List;

public class AddNegabinary {
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;
        int i = m-1,j = n-1;
        List<Integer> l = new ArrayList<>();
        int k = 0;
        while(i >= 0 && j >= 0) {
            int num1 = arr1[i];
            int num2 = arr2[j];
            int sum = num1+num2+k;
            if(sum >= 2) {
                k = -1;
                sum = sum % 2;
            }else if(sum == -1){
                sum = 1;
                k = 1;
            }else{
                k = 0;
            }
            l.add(0,sum);
            i--;
            j--;
        }
        while(i >= 0) {
            int num1 = arr1[i];
            int sum = num1 + k;
            if(sum >= 2) {
                k = -1;
                sum = sum % 2;
            }else if(sum == -1){
                sum = 1;
                k = 1;
            }else{
                k = 0;
            }
            l.add(0,sum);
            i--;
        }
        while(j >= 0) {
            int num2 = arr2[j];
            int sum = num2 + k;
            if(sum >= 2) {
                k = -1;
                sum = sum % 2;
            }else if(sum == -1){
                sum = 1;
                k = 1;
            }else{
                k = 0;
            }
            l.add(0,sum);
            j--;
        }
        if(k == -1) {
            l.add(0,1);
            l.add(0,1);
        }
        i = 0;
        while(i < l.size()) {
            if(i+1<l.size() && l.get(i) == 0) {
                while(i+1<l.size() && l.get(i) == 0) {
                    l.remove(i);
                }
            }else{
                break;
            }
        }
        int[] ans = new int[l.size()];
        for(int x = 0; x < l.size(); x++) {
            ans[x] = l.get(x);
        }
        return ans;
    }
}
