package codetop_byte.q0515;

import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;
import java.util.Scanner;

public class TrapRainWater {
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int trapRainWater(int[][] heightMap) {
        // 使用堆解决，保存<x,y,h>，表示位置和高度
        // 二维接雨水: 接雨水的本质就是最短路,找到当前堆中最小的格子,然后遍历4个方向有没有可以注水的

        // 二维不能像一维那样统计4个相邻方向的最大左右高度,然后一个一个算.因为横向最短和纵向最短会互相影响
        int m = heightMap.length;
        int n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        // 将边界加进去
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
                    visited[i][j] = true;
                    heap.offer(new int[] {i, j, heightMap[i][j]});
                }
            }
        }

        int ans = 0;

        // 每次从堆中弹出最小的元素，并检查它上下左右的位置是否可以注水
        while (!heap.isEmpty()) {
            int[] element = heap.poll();
            int x = element[0];
            int y = element[1];
            int h = element[2];

            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny]) {
                    if (heightMap[nx][ny] < h) {
                        ans += h - heightMap[nx][ny];
                    }
                    visited[nx][ny] = true;
                    heap.offer(new int[] {nx, ny, Math.max(h, heightMap[nx][ny])});
                }
            }
        }

        return ans;
    }
    @Test
    public void show(){
        int[][] heightMap = {{12,13,1,12},{13,4,13,12},{13,8,10,12},{12,13,12,12},{13,13,13,13}};
        System.out.println(trapRainWater(heightMap));
    }

}
