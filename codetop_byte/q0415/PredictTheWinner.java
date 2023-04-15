package codetop_byte.q0415;

import org.junit.Test;

public class PredictTheWinner {
    Boolean[][][] f;
    int m;
    int[] nums;
    /*
        这道题不能用传统意义上的记忆化搜索的博弈:f[i][j][step]:[i,j]区间内step win or lose
        原因在于通过不同的路径走到f[i][j][step]之前,target1和target2的和不一定是相同的,所以仅仅依靠f[i][j][step]来推断之前的情况是不靠谱的
        这里需要记录的是f[i][j]:在[i,j]区间先手和后手之间的得分查值,>=0说明先手赢,反之后手赢


        这里比较难想同时也是比较秀的方式就是利用差值来作为先手和后手的区分
     */
    public boolean PredictTheWinner(int[] nums) {
        m = nums.length;
        if (m == 1){
            return true;
        }
        this.nums = nums;
        f = new Boolean[m][m][2];
        return dfs(0,m-1,0,0,0);
    }

    private boolean dfs(int l,int r,int target1,int target2,int step) {
        if (l == r) {
            f[l][r][step] = step == 0 ? target1+nums[l] > target2 : target1 > nums[l]+target2;
            return f[l][r][step];
        }
        if (l == r-1) {
            f[l][r][step] = step == 0 ? target1+Math.max(nums[l],nums[r]) > target2+Math.min(nums[l],nums[r]) : target1+Math.min(nums[l],nums[r]) > target2+Math.max(nums[l],nums[r]);
        }
        if (f[l][r][step]) {
            return f[l][r][step];
        }
        Boolean ans;
        if (step == 0) {
           ans = dfs(l+1,r,target1+nums[l],target2,1) || dfs(l,r-1,target1+nums[r],target2,1);
        }else{
            ans = dfs(l+1,r,target1,target2+nums[l],0) || dfs(l,r-1,target1,target2+nums[r],0);
        }
        f[l][r][step] = ans;
        return !ans;
    }
    @Test
    public void show(){
        int[] nums = {2,4,55,6,8};
        System.out.println(PredictTheWinner(nums));
    }
}
