package codetop_byte.q0511;

import org.junit.jupiter.api.Test;

import java.util.*;

public class PondSizes {
    int[] fa;
    int[][] dir = {{1,0},{1,1},{0,1},{-1,1},{-1,0},{-1,-1},{0,-1},{1,-1}};
    public int[] pondSizes(int[][] land) {
        // 这道题其实本身更适合用dfs来做,但是并查集也能做
        List<int[]> nxs = new ArrayList<>();
        int m = land.length;
        int n = land[0].length;
        int l = 0;
        Map<Integer,Integer> map = new HashMap<>();
        int index = 0;
        for(int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 0) {
                    map.put(i*n+j,index++);
                }
            }
        }
        l = map.size();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(land[i][j] != 0) {
                    continue;
                }
                for(int k = 0; k < 8; k++) {
                    int r = i + dir[k][0];
                    int c = j + dir[k][1];
                    if(r >= m || r < 0 || c >= n || c < 0 || land[r][c] != 0) {
                        continue;
                    }
                    nxs.add(new int[]{map.get(i*n+j),map.get(r*n+c)});
                }

            }

        }
        fa = new int[l];
        for(int i = 0; i < l; i++) {
            fa[i] = i;
        }
        for(int i = 0; i < nxs.size(); i++) {
            union(nxs.get(i)[0],nxs.get(i)[1]);
        }
        for(int i = 0; i < fa.length;i++) {
            find(i);
        }
        l = 0;
        Map<Integer,Integer> cntMap = new HashMap<>();
        for(int i = 0; i < fa.length; i++) {
            if(fa[i] == i) {
                l++;
                cntMap.put(i,0);
            }
        }
        for(int i = 0;i < fa.length; i++) {
            cntMap.put(fa[i],cntMap.getOrDefault(fa[i],0)+1);
        }
        int[] res = new int[cntMap.size()];
        int i = 0;
        for(int key : cntMap.keySet()) {
            res[i++] = cntMap.get(key);
        }
        Arrays.sort(res);
        return res;
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

    @Test
    public void show() {
        int[][] land = {{0,2,1,0},{0,1,0,1},{1,1,1,0},{0,1,0,1}};
        System.out.println(Arrays.toString(pondSizes(land)));
    }
}
