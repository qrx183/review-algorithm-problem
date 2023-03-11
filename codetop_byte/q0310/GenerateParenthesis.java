package codetop_byte.q0310;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenerateParenthesis {
    Set<String> set = new HashSet<>();
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(n,0,0,new StringBuilder());
        for (String str : set) {
            res.add(str);
        }
        return res;
    }
    private void dfs(int n,int leftNum,int rightNum,StringBuilder str) {
        // 这个leftNum 和 rightNum应该放到最外面比较合适
        if (str.length() == n * 2) {
            set.add(new String(str));
            return;
        }
        if (rightNum > leftNum) {
            return;
        }
        if (leftNum < n) {
            str.append('(');
            leftNum+=1;
            dfs(n,leftNum,rightNum,str);
            leftNum-=1;
            str.deleteCharAt(str.length()-1);
        }
        if(rightNum < Math.min(leftNum,n)) {
            str.append(")");
            rightNum += 1;
            dfs(n,leftNum,rightNum,str);
            rightNum-=1;
            str.deleteCharAt(str.length()-1);
        }


    }
    @Test
    public void show() {
        System.out.println(generateParenthesis(3));
    }
}
