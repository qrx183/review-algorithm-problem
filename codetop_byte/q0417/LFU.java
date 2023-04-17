package codetop_byte.q0417;

import org.junit.jupiter.api.Test;

import java.util.*;

public class LFU {
    private LinkedList<Integer> queue; // 存储key的队列
    private Map<Integer,List<Integer>> map; // key为get,set次数和,value为获取次数为key对应的元素列表(从前往后时间优先级依次升高)
    private Map<Integer,Integer> cache; // key 为要存储的key,value为要存储的value
    private Map<Integer,Integer> keyNumber; // key 为存储的key,value为key的次数,方便获取map中的key
    public int[] LFU (int[][] operators, int k) {
        // write code here
        int m = operators.length;
        queue = new LinkedList<>();
        map = new HashMap<>();
        cache = new HashMap<>();
        keyNumber = new HashMap<>();
        int length = 0;
        for(int i = 0; i < m; i++) {
            if (operators[i][0] == 2) {
                length++;
            }
        }
        int[] ans = new int[length];
        int index = 0;
        for(int i = 0; i < m; i++) {
            if(operators[i][0] == 1) {
                // set
                int key = operators[i][1];
                int value = operators[i][2];
                if (cache.containsKey(key)) {

                    // 更新元素

                    cache.put(key,value);
                    queue.remove((Integer)key);
                    queue.addFirst(key);
                    int oldNumber = keyNumber.getOrDefault(key,0);
                    keyNumber.put(key,oldNumber+1);
                    // 删除原次数中的元素
                    List<Integer> oldL = map.get(oldNumber);
                    if(oldL == null) {
                        oldL = new ArrayList<>();
                    }else{
                        oldL.remove((Integer)key);
                    }
                    if(oldL.size() == 0) {
                        map.remove(oldNumber);
                    }else{
                        map.put(oldNumber,oldL);
                    }

                    // 将key添加到新的次数对应的keyList中
                    List<Integer> newL = map.get(oldNumber+1);
                    if(newL == null) {
                        newL = new ArrayList<>();
                    }
                    newL.add(key);
                    map.put(oldNumber+1,newL);

                }else{
                    // 新增元素

                    if(queue.size() < k) {
                        // 不涉及淘汰数据
                        queue.addFirst(key);
                        keyNumber.put(key,1);
                        cache.put(key,value);
                        List<Integer> oldL = map.get(1);
                        if(oldL == null) {
                            oldL = new ArrayList<>();
                        }
                        oldL.add(key);
                        map.put(1,oldL);
                    }else {
                        // 涉及淘汰数据
                        for(int j = 1; j <= m; j++) {
                            if(map.containsKey(j)){
                                List<Integer> oldL = map.get(j);
                                int dKey = oldL.remove(0);
                                map.put(j,oldL);
                                keyNumber.remove(dKey);
                                queue.remove((Integer)dKey);
                                cache.remove((Integer)dKey);
                                break;
                            }
                        }
                        queue.addFirst(key);
                        keyNumber.put(key,1);
                        cache.put(key,value);
                        List<Integer> oldL = map.get(1);
                        if(oldL == null) {
                            oldL = new ArrayList<>();
                        }
                        oldL.add(key);
                        map.put(1,oldL);

                    }
                }
            }else{
                // get
                int key = operators[i][1];
                if(!cache.containsKey(key)){
                    // 返回-1
                    ans[index++] = -1;
                }else{
                    int value = cache.get(key);
                    queue.remove((Integer)key);
                    queue.addFirst(key);
                    int oldNumber = keyNumber.get(key);
                    keyNumber.put(key,oldNumber+1);
                    List<Integer> oldL = map.get(oldNumber);
                    if(oldL == null) {
                        oldL = new ArrayList<>();
                    }else{
                        oldL.remove((Integer) key);
                    }
                    if(oldL.size() == 0){
                        map.remove(oldNumber);
                    }else{
                        map.put(oldNumber,oldL);
                    }

                    List<Integer> newL = map.get(oldNumber+1);
                    if(newL == null){
                        newL = new ArrayList<>();
                    }
                    newL.add(key);
                    map.put(oldNumber+1,newL);
                    ans[index++] = value;
                }

            }
        }
        return ans;
    }
    @Test
    public void show() {
        int[][] o = {{1,1,1},{1,2,2},{1,3,3},{1,4,4},{2,4},{2,3},{2,2},{2,1},{1,5,5},{2,4}};
        System.out.println(Arrays.toString(LFU(o, 4)));
    }
}
