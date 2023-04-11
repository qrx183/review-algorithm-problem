package codetop_byte.q0411;

import java.util.HashMap;
import java.util.Map;

public class IntegerReplacement {
    Map<Integer,Integer> cache = new HashMap<>();
    public int integerReplacement(int n) {
        // 这道题本身很简单. 但是如果用普通的dp自下而上去解,需要构造一个f[n]的数组,而当n过大时,容易造成oom
        // 因此采用自上而下的记忆化搜索更合适
        if (n == 1){
            return 0;
        }
        if (!cache.containsKey(n)) {
            if (n % 2 == 0) {
                cache.put(n,integerReplacement(n/2)+1);
            }else{
                cache.put(n,Math.min(integerReplacement(n/2),integerReplacement(n/2+1))+2);
            }
        }
        return cache.get(n);
    }
}
