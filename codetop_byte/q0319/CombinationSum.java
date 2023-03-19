package codetop_byte.q0319;

import java.util.*;

public class CombinationSum {
    List<Integer> list;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        list = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(res,candidates,target,0);
        return res;
    }
    public void dfs(List<List<Integer>> res,int[] candidates,int target,int index){
        if(target <= 0){
            if(target == 0){
                List<Integer> l = new ArrayList<>(list);
                res.add(l);
            }
            return;
        }

        for(int i = index; i < candidates.length;i++){
            list.add(candidates[i]);
            // 排列组合 递归这里dfs中的index传i还是传index决定了元素中每个元素是否可以无限制取
            // dfs(..,..,i) 表示数组中每个元素可以取多次
            // dfs(..,..,index) 表示数组中每个元素只能取一次
            dfs(res,candidates,target-candidates[i],i);
            list.remove(list.size()-1);
        }
    }
}
