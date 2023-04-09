package codetop_byte.q0409;

import java.util.List;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] f = new boolean[n];
        for(int i = 0; i < n; i++) {
            for (int k = 0; k <= i; k++) {
                if(k == i && wordDict.contains(s.substring(0,k+1))) {
                    f[i] = true;
                    break;
                }
                if (f[k] && wordDict.contains(s.substring(k+1,i+1))) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[n-1];
    }
}
