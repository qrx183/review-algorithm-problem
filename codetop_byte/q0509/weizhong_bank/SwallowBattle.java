package codetop_byte.q0509.weizhong_bank;

import java.util.*;

public class SwallowBattle {
    static class Pair {
        int index;
        int energy;
        int score;
        int res;
        Pair() {
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair();
            pairs[i].index = i;
        }
        for (int i = 0; i < n; i++) {
            pairs[i].energy = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            pairs[i].score = scanner.nextInt();
        }

        Arrays.sort(pairs, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.energy - o2.energy;
            }
        });

        int[] res = new int[n];
        int cur = 0;
        PriorityQueue<Integer> p = new PriorityQueue<>();
        for (int i = 0; i < n - 1; i++) {
            if (i < m) {
                p.offer(pairs[i].score);
                cur += pairs[i].score;
            } else {
                if (pairs[i].score >= p.peek()) {
                    cur -= p.poll();
                    p.offer(pairs[i].score);
                    cur += pairs[i].score;
                }
            }
            pairs[i+1].res = cur;
        }
        Arrays.sort(pairs, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.index - o2.index;
            }
        });
        for (int i = 0; i < n; i++) {
            System.out.println(pairs[i].res);
        }
    }
}
