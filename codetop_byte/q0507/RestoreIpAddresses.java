package codetop_byte.q0507;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {
    List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        dfs(s, 0, new ArrayList<>());
        return res;
    }

    private void dfs(String s, int index, List<String> list) {
        if (list.size() > 4) {
            return;
        }
        if (list.size() == 4 && index == s.length()) {
            String cur = "";
            for (int i = 0; i < 4; i++) {
                cur += list.get(i);
                if (i < 3) {
                    cur += ".";
                }
            }
            res.add(cur);
            return;
        }
        for (int i = 1; i <= 3; i++) {
            if (index + i <= s.length() && isMatch(s.substring(index, index + i))) {
                list.add(s.substring(index, index + i));
                dfs(s, index + i, list);
                list.remove(list.size() - 1);
            }
        }


    }

    private boolean isMatch(String s) {
        int n = s.length();
        if (n == 1) {
            return true;
        }
        if (s.charAt(0) == '0') {
            return false;
        }
        int num = Integer.parseInt(s);
        return num >= 0 && num <= 255;
    }
}
