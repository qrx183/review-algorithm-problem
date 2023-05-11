package codetop_byte.q0511;

public class MakeConnected {
    int[] fa;
    public int makeConnected(int n, int[][] connections) {
        // 首先计算出多余的线缆,即构成图中成环的边的个数
        fa = new int[n];
        for(int i = 0; i < n; i++) {
            fa[i] = i;
        }
        int cnt = 0;
        int m = connections.length;
        for(int i = 0; i < m; i++) {
            int node1 = connections[i][0];
            int node2 = connections[i][1];

            if(find(node1) == find(node2)) {
                cnt++;
            }else{
                union(node1,node2);
            }
        }
        int curCnt = 0;
        for(int i = 0; i < n; i++) {
            if(fa[i] == i) {
                curCnt++;
            }
        }
        if (cnt >= curCnt-1) {
            return curCnt-1;
        }else{
            return -1;
        }
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
