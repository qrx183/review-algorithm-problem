package codetop_byte.q0510.ali;

import java.util.*;

public class RedChildTree {
    private  static int res = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = scanner.next();
        Map<Integer,Boolean> redMap = new HashMap<>();
        List<List<Integer>> nxs = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            nxs.add(new ArrayList<>());
            redMap.put(i+1,false);
        }
        for(int i = 0; i < n-1; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            nxs.get(x).add(y);
        }
        for(int i = 0; i < n; i++) {
            if(s.charAt(i) == 'R' && nxs.get(i).size() == 0) {
                redMap.put(i+1,true);
            }
        }
        dfs(redMap,nxs,1);
        System.out.println(res);
    }
    private static boolean dfs(Map<Integer,Boolean> redMap,List<List<Integer>> nxs,int index) {
        if(redMap.get(index)) {
            return true;
        }
        boolean isV = true;
        for (int nx : nxs.get(index)) {
            if(!dfs(redMap,nxs,nx)) {
                isV = false;
                break;
            }
        }
        if(isV) {
            redMap.put(index,true);
            res++;
        }
        return isV;
    }
}
