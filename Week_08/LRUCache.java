import java.util.LinkedHashMap;
import java.util.Map;

//146 LRUCache 缓存机制 https://leetcode-cn.com/problems/lru-cache/#/
public class LRUCache {
    private  final int capacity;
    private LinkedHashMap<Integer, Integer> map;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        return map.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        map.put(key, value);
    }
}
