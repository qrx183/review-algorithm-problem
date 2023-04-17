package codetop_byte.q0417;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRU {
    LinkedList<Integer> queue;
    Map<Integer,Integer> cache;
    int capacity;
    public LRU(int capacity) {
        cache = new HashMap<>();
        queue = new LinkedList<>();
        this.capacity = capacity;
        // write code here
    }

    public int get(int key) {
        // write code here
        if(cache.containsKey(key)){
            queue.remove((Integer) key);
            queue.offerFirst(key);
            return cache.get(key);
        }else{
            return -1;
        }
    }

    public void set(int key, int value) {
        // write code here
        if(cache.containsKey(key)){
            // 更新
            queue.remove((Integer)key);
            queue.offerFirst(key);
            cache.put(key,value);
        }else{
            // 新增
            if(queue.size() == capacity) {
                // 淘汰数据
                int oldKey = queue.pollLast();
                cache.remove(oldKey);
                cache.put(key,value);
                queue.offerFirst(key);
            }else{
                cache.put(key,value);
                queue.offerFirst(key);
            }
        }
    }
}
