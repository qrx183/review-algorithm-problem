package codetop_byte.q0512.meituan;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.*;

public class ChallengeGames {

    // 闯关类型的题目可以考虑用记忆化搜索,不用过于排斥dfs,dfs加中间状态记录的效率也很高
    // 而且图本身也有一个顺序:从前到后,没有环也就不会出现死循环的状态

    private static String[][] input;
    // 某一类宝石出现的关卡
    private static Map<String, List<Integer>> B = new HashMap<>();
    // 某一类宝石对应的商人出现的关卡
    private static Map<String, List<Integer>> M = new HashMap<>();
    private static int[] f;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        f = new int[n];
        input = new String[n][3];
        Arrays.fill(f,-1);
        scanner.nextLine();
        for(int i = 0; i < n; i++) {
            String s = scanner.nextLine();
            input[i] = s.split(" ");
            if(input[i][0].equals("b")) {
                List<Integer> l = B.get(input[i][1]);
                if (l == null) {
                    l = new ArrayList<>();
                }
                l.add(i);
                B.put(input[i][1],l);
            }else{
                List<Integer> l = M.get(input[i][1]);
                if (l == null) {
                    l = new ArrayList<>();
                }
                l.add(i);
                M.put(input[i][1],l);
            }

        }
        System.out.println(dfs(0,n));
    }
    private static int dfs(int i,int n) {
        if(i >= n) {
            return 0;
        }
        if(f[i] != -1){
            return f[i];
        }
        // 如果当前关卡是商人,则直接跳过.只考虑当前为宝石时是否售卖
        if(input[i][0].equals("m")){
            return dfs(i+1,n);
        }
        String cl = input[i][1];
        List<Integer> ms = M.get(cl);
        int l = 0, r = ms.size()-1;
        while(l < r) {
            int mid = l + r >> 1;
            if(ms.get(mid) >= i){
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        if(l >= n || ms.get(l) == i) {
            return 0;
        }
        int cur = 0;
        for(int j = l; j < ms.size(); j++) {
            cur = Math.max(cur,dfs(ms.get(j)+1,n)+Integer.parseInt(input[ms.get(j)][2]));
        }
        cur = Math.max(cur,dfs(i+1,n));
        f[i] = Math.max(f[i],cur);
        return f[i];
    }


}
