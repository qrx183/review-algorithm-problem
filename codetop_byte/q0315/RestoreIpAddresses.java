package codetop_byte.q0315;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RestoreIpAddresses {
    Set<String> set = new HashSet<>();
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        dfs(s, 0, new ArrayList<String>());
        for (String str : set) {
            res.add(str);
        }
        return res;
    }

    private void dfs(String s,int index, List<String> cur) {
        if (index == s.length() && cur.size() == 4) {
            String step = "";
            for (String str : cur) {
                step += str + ".";
            }
            set.add(step.substring(0,step.length()-1));
            return;
        }
        if (cur.size() > 4) {
            return;
        }

            for (int j = 1; j <= 3 && index+j <= s.length();j ++) {
                String sub = s.substring(index, index + j);
                if (isValid(sub)) {
                    cur.add(sub);
                    dfs(s,index+j,cur);
                    cur.remove(cur.size()-1);
                }
        }
    }

    private boolean isValid (String str){
        if (str.length() <= 1) {
            return str.length() == 1;
        }
        if (str.charAt(0) == '0') {
            return false;
        }
        int num = Integer.parseInt(str);
        return num >= 0 && num <= 255;
    }

    @Test
    public void show() {
        String s = "101023";
        System.out.println(restoreIpAddresses(s));
    }
}
