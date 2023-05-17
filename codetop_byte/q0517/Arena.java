package codetop_byte.q0517;

import java.util.Scanner;

public class Arena {
    private static int m,n;
    private static final int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    private static boolean[][] isV;
    static int res = 0;
    public static void main(String[] args) {
        // 搜索类型的题目中,如果没有说明路径是单向的则不能用记忆化搜索去记忆中间过程.因为中间过程是会发生改变的
        // 搜索题能采用记忆化搜索的前提:a->b遍历过之后,b->a就不能再遍历了.必须有这种单向限制的条件才可以使用记忆化搜索
        // 这道题的破题点就是从出口向其他点遍历,统计能遍历到的点,对于传送门上的点,除非其对应的反方向正好等于进入传送门的位置,否则呜啊
        // 通过这个位置进入传送门上
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        isV = new boolean[n][m];
        char[][] map = new char[n][m];
        for(int i = 0; i < n; i++) {
            String s = scanner.next();
            for(int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j);
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 'O') {
                    isV[i][j] = true;
                    dfs(i,j,map);
                    break;
                }

            }
        }
        System.out.println(m*n-res);

    }
    private static void dfs(int x,int y,char[][] map) {
       res++;
       for(int i = 0; i < 4; i++) {
           int r = x + dir[i][0];
           int c = y + dir[i][1];
           if(r >= m || r < 0 || c >= m || c < 0 || isV[r][c]) {
               continue;
           }
           if(map[r][c] != '.' && map[r][c] != 'O') {
               int[] dirc = getDir(map[r][c],r,c);
               if(dirc[0] != x || dirc[1] != y) {
                   continue;
               }
               isV[r][c] = true;
               dfs(r,c,map);
           }else{
               isV[r][c] = true;
               dfs(r,c,map);
           }
       }
    }
    private static int[] getDir(char ch,int x,int y) {
        if(ch == 'L') {
            return new int[]{x,y-1};
        }else if(ch == 'R') {
            return new int[]{x,y+1};
        }else if(ch == 'U') {
            return new int[]{x-1,y};
        }else if(ch == 'D') {
            return new int[]{x+1,y};
        }
        return null;
    }
}
