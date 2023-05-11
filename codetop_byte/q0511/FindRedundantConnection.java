package codetop_byte.q0511;

public class FindRedundantConnection {
    int[] fa;
    public int[] findRedundantConnection(int[][] edges) {


        // 树是一个无向无环图,在已有树的基础上,在树的两个点上再添加一个边就会导致这棵树出现环,因此只要找到构成环的那条边即可
        // 而且题目本身也给出提示了:有多个条件返回edge中靠后的值.说明返回的就是刚好构成环的那条边,而非是构成环中的任意一条边
        int n = edges.length;
        for(int i =1; i <= n; i++) {
            fa[i] = i;
        }
        for(int i = 0; i < n; i++) {
            int node1 = edges[i][0];
            int node2 = edges[i][1];
            if(find(node1) != find(node2)) {
                union(node1,node2);
            }else{
                return edges[i];
            }
        }
        return null;


        // 下面是一个O(n2logn)的解法:就是从后往前每次构建树,看是否能构建出一个只有一个根节点的图
//        int n = edges.length;
//        fa = new int[n+1];
//        for(int i = 1; i <= n; i++) {
//            fa[i] = i;
//        }
//        for(int i = n-1; i >= 0; i--) {
//            for(int k = 1; k <= n; k++) {
//                fa[k] = k;
//            }
//            for(int j = 0; j < n; j++) {
//                if(j == i) {
//                    continue;
//                }
//                union(edges[j][0],edges[j][1]);
//            }
//            if(isMatch(fa)) {
//                return edges[i];
//            }
//        }
//        return null;
    }
    private boolean isMatch(int[] fa) {
        int cnt = 0;
        for(int i = 1; i < fa.length;i++) {
            if(fa[i] == i) {
                cnt++;
            }
        }
        return cnt == 1;
    }
    private int find(int x) {
        if(x != fa[x]) {
            fa[x] = find(fa[x]);
        }
        return fa[x];
    }

    private void union(int x,int y) {
        fa[find(x)] = find(y);
    }
}
