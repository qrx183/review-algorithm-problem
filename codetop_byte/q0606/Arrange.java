package codetop_byte.q0606;

import java.util.Scanner;

public class Arrange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            int index = -1;
            for (int j = 0; j < n; j++) {
                nums[j] = scanner.nextInt();
                if (nums[j] == 1) {
                    index = j;
                }
            }
            int res = 1;
            int l = index, r = index;
            for (int k = 0; k < n - 1; k++) {
                if (l - 1 >= 0 && r + 1 < n) {
                    if (nums[l - 1] < nums[r + 1]) {
                        l--;
                        if (nums[l] == r - l + 1) {
                            res++;
                        }
                    } else {
                        r++;
                        if (nums[r] == r - l + 1) {
                            res++;
                        }
                    }
                }else if(l - 1.>= 0) {
                    l--;
                    if (nums[l] == r - l + 1) {
                        res++;
                    }
                }else if(r + 1 < n) {
                    r++;
                    if(nums[r] == r-l+1) {
                        res++;
                    }
            }

        }
        System.out.println(res);
    }
}
}
