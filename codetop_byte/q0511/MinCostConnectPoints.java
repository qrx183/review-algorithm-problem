package codetop_byte.q0511;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinCostConnectPoints {
    int[] fa;
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        fa = new int[n];
        for(int i = 0; i < n; i++) {
            fa[i] = i;
        }
        Map<Integer,int[]> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            map.put(i,points[i]);
        }
        int len = n*(n-1)/2;
        int[][] po = new int[len][3];
        int index = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                po[index][0] = i;
                po[index][1] = j;
                po[index][2] = Math.abs(map.get(i)[0]-map.get(j)[0]) + Math.abs(map.get(i)[1]-map.get(j)[1]);
                index++;
            }
        }
        Arrays.sort(po,(a,b)->(a[2]-b[2]));
        int ans = 0;
        for(int i = 0; i < len; i++) {
            int s = po[i][0],e = po[i][1], w = po[i][2];
            if(find(s) != find(e)) {
                union(s,e);
                ans += w;
            }
        }
        return ans;
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
        int[][] arr = {{0,0},{2,2},{3,10},{5,2},{7,0}};
        System.out.println(minCostConnectPoints(arr));
    }
}
