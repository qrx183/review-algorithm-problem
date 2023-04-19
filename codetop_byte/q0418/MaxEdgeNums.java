package codetop_byte.q0418;

import java.util.*;

public class MaxEdgeNums {
    static class Pairs{
        int start;
        int end;
        public Pairs(int start,int end){
            this.start = start;
            this.end = end;
        }
    }
    static int edge1 = 0;
    static int edge2 = 0;
    public static void main(String[] args) {
        Map<Integer, List<Pairs>> map = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n == 2) {
            System.out.println(1);
            return;
        }
        boolean[] isV = new boolean[n+1];
        for(int i = 1; i <= n-1; i++) {
            int s = i+1;
            int e = scanner.nextInt();
            if(!map.containsKey(s)){
                map.put(s,new ArrayList<>());
            }
            List<Pairs> l = map.get(s);
            l.add(new Pairs(s,e));
            map.put(s,l);
            if(!map.containsKey(e)){
                map.put(e,new ArrayList<>());
            }
            List<Pairs> ll = map.get(e);
            ll.add(new Pairs(e,s));
            map.put(e,ll);
        }
        int s = scanner.nextInt();
        int e = scanner.nextInt();
        isV[s] = true;
        isV[e] = true;
        System.out.println(1+Math.max(dfs(map,s,isV),dfs(map,e,isV)));
    }
    private static int dfs(Map<Integer,List<Pairs>> map,int start,boolean[] isV) {
        List<Pairs> l = map.get(start);
        boolean end = true;
        for (Pairs p : l) {
            if(!isV[p.end]){
                end = false;
                break;
            }
        }
        if(end) {
            return 0;
        }

        int ans = 0;
        for(Pairs p : l) {
            int res = 1;
            int s = p.end;
            if(isV[s]) {
                continue;
            }
            isV[s] = true;
            int t = dfs(map,s,isV);
            res += t;
            isV[s] = false;
            ans = Math.max(ans,res);
        }
        return ans;
    }
}
