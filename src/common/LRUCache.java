package common;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache extends LinkedHashMap {

    private int capacity;

    public LRUCache(int capacity, float loadFactor) {
        super(capacity, loadFactor, true);
        this.capacity = capacity;
    }


    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > this.capacity;
    }


    public int get(int key){
        return (int)super.get(key);
    }

}