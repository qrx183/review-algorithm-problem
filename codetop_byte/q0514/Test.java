package codetop_byte.q0514;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class Test {
    public static void main(String[] args) {
       Map<Integer,Integer> map = new HashMap<>();
       map.put(1,null);
       map.put(null,2);
       System.out.println(map.get(null));
        ConcurrentHashMap<Integer,Integer> map1 = new ConcurrentHashMap<>();
        map1.put(null,1);
        System.out.println(map1.get(null));
        Set<Integer> set = new TreeSet<>();
        Set<Integer> hashSet = new HashSet<>();
    }
}
