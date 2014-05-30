import java.util.HashMap;
import java.util.Map;

/**
 * Created by xuyuanp on 5/30/14.
 */
public class LRUCache {

    private Map<Integer, Integer> map = null;
    private int capacity = 0;
    private int[] records;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<Integer, Integer>(this.capacity);
        this.records = new int[this.capacity];
    }

    public int get(int key) {
        if (!this.map.containsKey(key)) {
            return -1;
        }
        int index = this.find(key, this.map.size());
        if (index != -1) {
            this.shift(index);
        }
        return this.map.get(key);
    }

    public void set(int key, int value) {
        int index = this.find(key, this.map.size());
        if (index != -1) {
            this.shift(index);
        } else {
            if (this.map.size() < this.capacity) {
                this.shift(this.map.size());
                this.records[0] = key;
            } else {
                this.map.remove(this.records[this.capacity - 1]);
                this.shift(this.capacity - 1);
                this.records[0] = key;
            }
        }
        this.map.put(key, value);
    }

    private int find(int key, int size) {
        int i;
        for (i = 0; i < size; i++) {
            if (this.records[i] == key) {
                break;
            }
        }
        if (i == size) {
            return -1;
        }
        return i;
    }

    public void shift(int index) {
        int key = this.records[index];
        System.arraycopy(this.records, 0, this.records, 1, index);
        this.records[0] = key;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(1);
        cache.set(2, 1);
        cache.get(2);
        cache.set(3, 2);
        cache.get(2);
        System.out.println(cache.get(3));
    }
}
