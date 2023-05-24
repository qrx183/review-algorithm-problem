package codetop_byte.q0524.meituan;

import java.util.Scanner;

public class TankBattle {
    static int dCount = 1,wCount = 1;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 小D的指令集
        String ds = scanner.next();
        // 小W的指令集
        String ws = scanner.next();
        // 规定小D占领的格子标记为1,小W占领的格子标记为2,0表示没有被占领的格子
        // F表示开火,D,U,W,R表示移动
        int[][] map = new int[16][16];
        // 统计小D和小W占领的格子数
        map[0][0] = 1;
        map[15][15] = 2;
        // 表示当前小D和小W坦克的指向:0(右),1(下),2(左),3(上)
        int dDir = 0,wDir = 2;
        int[] dPos = {0,0};
        int[] wPos = {15,15};
        int n = ds.length();
        for(int i = 0; i < n; i++) {
            int dChar = ds.charAt(i);
            int wChar = ws.charAt(i);
            if(dChar == 'F' || wChar == 'F') {
                if(dChar == 'F' && wChar == 'F') {
                    boolean dWin = fairAndWin(dPos,dDir,wPos);
                    boolean wWin = fairAndWin(wPos,wDir,dPos);
                    if(dWin && wWin) {
                        System.out.println((i+1) + " 平局");
                        return;
                    }else if(dWin) {
                        System.out.println((i+1) + " D");
                        return;
                    }else if(wWin) {
                        System.out.println((i+1) + " W");
                        return;
                    }
                }else if(dChar == 'F') {
                    boolean dWin = fairAndWin(dPos,dDir,wPos);
                    if(dWin) {
                        System.out.println((i+1) + " D");
                        return;
                    }else{
                        int[] cur = move(wPos,wChar,map,'W');
                        wPos = new int[] {cur[0],cur[1]};
                        wDir = cur[2];
                        if(cur[3] == dPos[0] && cur[4] == dPos[1]) {
                            System.out.println((i+1) + " 平局");
                            return;
                        }
                    }
                }else {
                    boolean wWin = fairAndWin(wPos,wDir,dPos);
                    if(wWin) {
                        System.out.println((i+1) + " W");
                        return;
                    }else{
                        int[] cur = move(dPos,dChar,map,'D');
                        dPos = new int[] {cur[0],cur[1]};
                        dDir = cur[2];
                        if (cur[3] == wPos[0] && cur[4] == wPos[1]) {
                            System.out.println((i+1) + " 平局");
                            return;
                        }
                    }
                }
            }else{
                // 没有人开火
                int[] dCur = move(dPos,dChar,map,'D');
                int[] wCur = move(wPos,wChar,map,'W');
                if(dCur[3] == wCur[3] && dCur[4] == wCur[4]) {
                    System.out.println((i+1) + " 平局");
                    return;
                }
                dPos = new int[]{dCur[0],dCur[1]};
                dDir = dCur[2];
                wPos = new int[]{wCur[0],wCur[1]};
                wDir = wCur[2];
            }
        }
        if(dCount == wCount) {
            System.out.println(n + " 平局");
        }else if(dCount > wCount) {
            System.out.println(n + " D");
        }else{
            System.out.println(n + " W");
        }
    }
    private static int[] move(int[] pos,int ch,int[][] map,char who) {
        int r = pos[0];
        int c = pos[1];
        int dir = -1;

        if(ch == 'D') {
            r += 1;
            dir = 1;
        }else if(ch == 'R') {
            c += 1;
            dir = 0;
        }else if(ch == 'U') {
            r -= 1;
            dir = 3;
        }else if(ch == 'L') {
            c -= 1;
            dir = 2;
        }
        // 不考虑占位问题的情况下应该移动的位置
        int curR = r;
        int curC = c;
        if(map[pos[0]][pos[1]] == map[r][c] || map[r][c] == 0) {
            map[r][c] = map[pos[0]][pos[1]];
            if(who == 'D') {
                dCount ++;
            }else{
                wCount ++;
            }
        }else{
            r = pos[0];
            c= pos[1];
        }
        return new int[] {r,c,dir,curR,curC};
    }
    // dPos 和 dir 表示开火的一方,wPos表示被开火的位置
    private static boolean fairAndWin(int[] dPos, int dir, int[] wPos) {
            int dr = dPos[0],dc = dPos[1];
            int wr = wPos[0],wc = wPos[1];
            if(dr != wr && dc != wc) {
                return false;
            }
            if(dr == wr) {
                return (dc < wc && dir == 0) || (dc > wc && dir == 2);
            }
            return (dr < wr && dir == 3) || (dr > wr && dir == 1);
    }
}
