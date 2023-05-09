package codetop_byte.q0509.weizhong_bank;

import java.lang.reflect.Array;
import java.util.*;

public class ChaoticKeyBoard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        List<int[]> l = new ArrayList<>();
        int[][] input = new int[n][2];
        for (int i = 0; i < n; i++) {
            input[i][0] = scanner.nextInt();
            input[i][1] = scanner.nextInt();
        }
        int i = 0;
        while(i < n) {
            int ch = input[i][0];
            int cnt = input[i][1];
            while(i+1<n && ch == input[i+1][0]) {
                cnt += input[i+1][1];
                i++;
            }
            int[] cur = new int[2];
            cur[0] = ch;
            cur[1] = cnt;
            l.add(cur);
            i++;
        }
        Map<Integer,Integer> res = new HashMap<>();
        for(int[] arr : l) {
            int ch = arr[0];
            int cnt = arr[1]%k==0 ? (arr[1]/k-1)*k*2+k : arr[1]/k *2*k+arr[1]%k;
            res.put(ch,res.getOrDefault(ch,0)+cnt);
        }
        System.out.println(res.size());
        List<List<Integer>> result = new ArrayList<>();
        for(int key : res.keySet()) {
            result.add(Arrays.asList(key,res.get(key)));
        }
        Collections.sort(result, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(0) - o2.get(0);
            }
        });
        for(List<Integer> cur : result) {
            System.out.print(cur.get(0) + " ");
            System.out.println(cur.get(1));
        }
    }
}
