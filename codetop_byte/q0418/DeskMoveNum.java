package codetop_byte.q0418;

import java.util.Scanner;

public class DeskMoveNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int a = scanner.nextInt();
        scanner.nextLine();
        String[][] seat = new String[m+1][n+1];
        for(int i = 0; i < m; i++) {
            String s = scanner.nextLine();
            String[] seats = s.split(" ");
            for(int j = 0; j < n; j++) {
                seat[i][j] = seats[j];
            }
        }
        for(int i = 0;i < n; i++) {
            seat[m][i] = seat[0][i];
        }
        for(int i = 0; i < m; i++) {
            seat[i][n] = seat[i][0];
        }
        seat[m][n] = seat[0][0];
        int res = 0;
        for(int i = 0; i < m;i++) {
            for(int j = 0; j < n; j++) {
                String oldSeat = seat[i][j];
                String newSeat = seat[i+1][j+1];
                res += diffDeskHeightNum(oldSeat,newSeat);
            }
        }
        System.out.println(res);
    }
    private static int diffDeskHeightNum(String oldSeat,String newSeat){
        int res = 0;
        int l = oldSeat.length();
        for(int i = 0; i < l;i++) {
            if(oldSeat.charAt(i) != newSeat.charAt(i)) {
                res++;
            }
        }
        return res;
    }
}

/*
来源：微信小程序【TechGuide】 实时题库 闪电速递！

## 思路
简单模拟，循环遍历修改前后座位的位置，记录需要重新调整桌子高度的同学数量，输出结果。
## 代码
### Python版本
```python
import sys

def solve(cas):
    n, m, a = map(int, input().split())
    s = [input().split() for _ in range(n)]
    change = [[s[(i - 1 + n) % n][(j - 1 + m) % m] for j in range(m)] for i in range(n)]
    ans = sum(s[i][j][k] != change[i][j][k] for i in range(n) for j in range(m) for k in range(a))
    print(ans)

if __name__ == '__main__':
    T = 1
    # T = int(input())
    for _ in range(T):
        solve(_)
# vx公众号关注TechGuide 实时题库 闪电速递。
```

### Java版本

```java
import java.util.*;

public class Main {
    static String[][] s = new String[205][205];
    static String[][] change = new String[205][205];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = 1;
        // T = sc.nextInt();
        while (T-- > 0) {
            solve(T);
        }
    }

    static void solve(int cas) {
        int n = sc.nextInt(), m = sc.nextInt(), a = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                s[i][j] = sc.next();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int r = (i - 1 + n) % n, c = (j - 1 + m) % m;
                change[i][j] = s[r][c];
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < a; k++) {
                    if (s[i][j].charAt(k) != change[i][j].charAt(k)) {
                        ans++;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
 */