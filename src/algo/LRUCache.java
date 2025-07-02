package algo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {


    private int capacity;
    private Map<Integer, Integer> cacheMap;
    private LinkedList<Integer> lruList;

    LRUCache(int capacity) {
        this.capacity = capacity;
        cacheMap = new HashMap<>();
        lruList = new LinkedList<>();
    }

    public int get(int key) {
        if (!cacheMap.containsKey(key)) {
            return -1;
        }

        lruList.remove(Integer.valueOf(key));
        lruList.addFirst(key);
        return cacheMap.get(key);
    }

    public void put(int key, int value) {
        if (cacheMap.containsKey(key)) {
            cacheMap.put(key, value);
            lruList.remove(Integer.valueOf(key));
        } else {
            if (cacheMap.size() >= capacity) {
                int lastKey = lruList.removeLast();
                cacheMap.remove(lastKey);
            }
            cacheMap.put(key, value);
        }
        lruList.addFirst(key);
    }

    public static void main(String[] args) {

        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));

    }
}
