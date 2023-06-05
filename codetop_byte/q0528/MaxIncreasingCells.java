package codetop_byte.q0528;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MaxIncreasingCells {
    int m, n;
    boolean[][] isV;
    int[][] mat;
    int[][] f;
    int res = 0;
    // 行上的最小值坐标以及列上的最小值
    // 通过率98% ..
    // 这道题一眼顶真:记忆化搜索,但是需要记录每个点遍历的点:当前点所在行所在列比当前值大的最小的点
    // 这个提前统计能遍历的点这一块超时了
    // 正确做法时排序每一行每一列,然后在dfs的时候通过二分得到比当前值大的最小值遍历
    List<int[]>[][][] minDis;
    int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int[][][] R;
    int[][][] C;

    public int maxIncreasingCells(int[][] mat) {
        this.mat = mat;
        m = mat.length;
        n = mat[0].length;
        f = new int[m][n];
        minDis = new List[m][n][2];
        R = new int[m][n][2];
        C = new int[n][m][2];
        for (int i = 0; i < m; i++) {
            Arrays.fill(f[i], -1);
        }
        for (int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                R[i][j] = new int[]{mat[i][j],j};
            }
            Arrays.sort(R[i], new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                C[i][j] = new int[]{mat[j][i],j};
            }
            Arrays.sort(C[i], new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(i, j);
            }
        }
        return res;


    }

    private int dfs(int r, int c) {
        if (f[r][c] != -1) {
            return f[r][c];
        }
        int cnt = 1;
        // 按行递归
        int num = mat[r][c];
        int index = binary(R[r],num);
        if(index < n) {
            int o = R[r][index][0];
            for(; index < n && R[r][index][0] == o; index ++) {
                int x = r, y = R[r][index][1];
                int curCnt = 1 + dfs(x,y);
                cnt = Math.max(cnt,curCnt);
            }
        }

        index = binary(C[c],num);
        if(index < m) {
            int o = C[c][index][0];
            for(; index < m && o == C[c][index][0]; index ++) {
                int x = C[c][index][1],y = c;
                int curCnt = 1 + dfs(x,y);
                cnt = Math.max(cnt,curCnt);
            }
        }

//        for (int i = 0; i < 2; i++) {
//            for (int j = 0; j < minDis[r][c][i].size(); j++) {
//                int x = minDis[r][c][i].get(j)[0];
//                int y = minDis[r][c][i].get(j)[1];
//                if ((x == -1 || y == -1)) {
//                    continue;
//                }
//                int curCnt = 1 + dfs(x, y);
//                cnt = Math.max(cnt, curCnt);
//            }
//
//        }
        f[r][c] = cnt;
        res = Math.max(res, cnt);
        return f[r][c];
    }
    private int binary(int[][] arr,int target) {
        int l = 0,r = arr.length-1;
        while(l < r) {
            int mid = l + r + 1 >> 1;
            if(arr[mid][0] <= target) {
                l = mid;
            }else{
                r = mid - 1;
            }
        }
        return arr[l][0] > target ? l : l + 1;
    }
    @Test
    public void show() {
        int[][] mat = {{3,1}, {3,4}};
        System.out.println(maxIncreasingCells(mat));
    }
}
