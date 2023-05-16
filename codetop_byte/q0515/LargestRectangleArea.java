package codetop_byte.q0515;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class LargestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        // 柱状图中的最大矩形面积
        // 遍历每个高左侧和右侧单增的最长长度lWidth,rWidth,然后求res = Math.max(res,heights[i]*(lWitdh[i]+rWitdh[i]-1))
        int n = heights.length;
        Deque<Integer> d = new LinkedList<>();
        int[] lWidths = new int[n];
        int[] rWidths = new int[n];
        Arrays.fill(lWidths,1);
        Arrays.fill(rWidths,1);
        int i = 0;
        while(i < n) {
            while(!d.isEmpty() && heights[d.peek()] > heights[i]) {
                lWidths[d.peek()] = Math.max(lWidths[d.peek()],i-d.peek());
                d.pop();
            }
            if(!d.isEmpty()) {
                lWidths[d.peek()] = Math.max(lWidths[d.peek()],i-d.peek()+1);
            }

            d.push(i);
            i++;
        }
        int h = d.peek();
        // 这里要对连续递增的高度对应的最大宽度进行更新. 因为上述入栈过程中没法有效更新 1,2,4,5这种多个递增的情况对应的最大宽度
        while(!d.isEmpty()) {
            lWidths[d.peek()] = Math.max(lWidths[d.peek()],h-d.peek()+1);
            d.pop();
        }
        i = n-1;
        d = new LinkedList<>();
        while(i >= 0) {
            while(!d.isEmpty() && heights[d.peek()] > heights[i]) {
                rWidths[d.peek()] = Math.max(rWidths[d.peek()],d.peek()-i);
                d.pop();
            }
            if(!d.isEmpty()) {
                rWidths[d.peek()] = Math.max(rWidths[d.peek()],d.peek()-i+1);
            }

            d.push(i);
            i--;
        }
        h = d.peek();
        while(!d.isEmpty()) {
            rWidths[d.peek()] = Math.max(rWidths[d.peek()],d.peek()-h+1);
            d.pop();
        }
        int res = 0;
        for(int j = 0; j < n; j++) {
            int width = lWidths[j]+rWidths[j]-1;
            res = Math.max(res,width*heights[j]);
        }
        return res;
    }
}
