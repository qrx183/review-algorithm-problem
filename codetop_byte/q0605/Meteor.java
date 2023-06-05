package codetop_byte.q0605;

import javafx.scene.transform.Scale;

import java.util.*;

public class Meteor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer>[] se = new List[n];
        for(int i = 0; i < n; i++) {
            se[i] = new ArrayList<>();
            se[i].add(scanner.nextInt());
        }
        for(int i = 0; i < n; i++){
            se[i].add(scanner.nextInt());
        }
        Arrays.sort(se, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(0) - o2.get(0);
            }
        });
        int i = 0;
        // x:观测的最多的流星数  y:可供选择的最佳时刻数量
        int x = 1,y = 0;
        while(i < n) {
            List<Integer> cur = se[i];
            int cnt = 1;
            while(i+1<n && (!(cur.get(1) < se[i+1].get(0)))) {
                cur.set(0,se[i+1].get(0));
                cur.set(1,Math.min(se[i].get(1),se[i+1].get(1)));
                i++;
                cnt++;
            }
            if(x < cnt) {
                x = cnt;
                y = cur.get(1)-cur.get(0)+1;
            }else if(x == cnt) {
                x = cnt;
                y += cur.get(1) - cur.get(0) + 1;
            }
            if(i == n-1) {
                if(x == 1) {
                    y += se[i].get(1) - se[i].get(0) + 1;
                }
                break;
            }
        }
        System.out.println(x + " " + y);
    }
}
