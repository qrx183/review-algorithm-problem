package codetop_byte.q0611;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MinSum {
    private static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        char[][] map = new char[N][N];
        Queue<int[]> q = new LinkedList<>();
        boolean[][] isV = new boolean[N][N];
        int res = 0;
        for(int i = 0; i < N; i++) {
            String s = scanner.next();
            for(int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j);
                if(map[i][j] == 'C') {
                    q.offer(new int[]{i,j,0,0});
                    isV[i][j] = true;
                }
            }
        }
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0],y = cur[1],w = cur[2];
            if(cur[3] == 1) {
                res += w;
            }
            for(int i = 0; i < 4; i++) {
                int r = x + dir[i][0],c = y + dir[i][1];
                if(r < 0 || r >= N || c < 0 || c >= N || isV[r][c] || map[r][c] == 'B') {
                    continue;
                }
                isV[r][c] = true;
                q.offer(new int[]{r,c,w+1,1});
            }
        }
        System.out.println(res);
    }
}
