package codetop_byte.q0511;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class SlidingPuzzle {
    class Pair {
        int[][] board;
        int step;
        int x;
        int y;

        Pair() {

        }

        Pair(int[][] board, int step, int x, int y) {
            this.board = board;
            this.step = step;
            this.x = x;
            this.y = y;
        }
    }

    int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int slidingPuzzle(int[][] board) {
        // 这道题的难点是如何将每一个状态下的board对应到isV[i]的状态中从而实现剪枝.
        // 很简单的方式:平铺..
        Queue<Pair> q = new LinkedList<>();
        int x = 0, y = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 0) {
                    x = i;
                    y = j;
                    break;
                }
            }
        }
        boolean[] isV = new boolean[600000];
        q.offer(new Pair(board, 0, x, y));
        int ans = getIsV(board);
        isV[ans] = true;
        while (!q.isEmpty()) {
            Pair p = q.poll();
            if (isMatch(p.board)) {
                return p.step;
            }


            for (int i = 0; i < 4; i++) {
                x = p.x + dir[i][0];
                y = p.y + dir[i][1];
                if (x < 0 || x >= 2 || y < 0 || y >= 3) {
                    continue;
                }
                int[][] curBoard = swap(p.board, p.x, p.y, x, y);
                int curA = getIsV(curBoard);
                if (isV[curA]) {
                    continue;
                }
                isV[curA] = true;

                Pair curP = new Pair(curBoard, p.step + 1, x, y);
                q.offer(curP);
            }
        }
        return -1;
    }

    private int getIsV(int[][] board) {
        int ans = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                ans = ans * 10 + board[i][j];
            }
        }
        return ans;
    }

    private int[][] swap(int[][] board, int x, int y, int r, int c) {
        int[][] res = new int[2][3];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                res[i][j] = board[i][j];
            }
        }
        int tmp = res[x][y];
        res[x][y] = res[r][c];
        res[r][c] = tmp;
        return res;
    }

    private boolean isMatch(int[][] board) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] != (i * 3 + j + 1) % 6) {
                    return false;
                }
            }
        }
        return true;
    }

    @Test
    public void show() {
        int[][] board = {{4, 1, 2}, {5, 0, 3}};
        System.out.println(slidingPuzzle(board));
    }
}
