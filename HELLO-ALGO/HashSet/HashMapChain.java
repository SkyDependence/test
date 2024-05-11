// 键值对

import java.util.ArrayList;
import java.util.*;

class Pair {
    public int key;
    public String value;

    public Pair(int key, String value) {
        this.key = key;
        this.value = value;
    }
}


// 链式哈希表
class ChainHashMap {
    private int size; // 键值对数量
    private int capacity; // 哈希表容量
    private double loadThres; // 触发扩容机制的负载因子阈值
    private int extendRatio; // 扩容倍数
    List<List<Pair>> buckets; // 桶数组

    // 构造方法
    public ChainHashMap() {
        size = 0;
        this.capacity = 4;
        loadThres = 2.0 / 3.0;
        buckets = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            buckets.add(new ArrayList<>());
        }
        extendRatio = 2;
    }

    // 哈希函数
    public int hashFunc(int key) {
        return key % capacity;
    }

    // 负载因子
    public double loadFactor() {
        return (double) size / capacity;
    }

    // 查询操作
    public String get(int key) {
        int index = hashFunc(key);
        List<Pair> bucket = buckets.get(index);
        // 遍历桶，若找到 key 则返回对应 value
        for (Pair pair : bucket) {
            if (pair.key == key) {
                return pair.value;
            }
        }
        // 没找到则返回 null
        return null;
    } 

    // 添加
    public void put(int key, String value) {
        // 若超过阈值则扩容
        if (loadFactor() > loadThres) {
            extend();
        }
        int index = hashFunc(key);
        List<Pair> bucket = buckets.get(index);
        // 遍历桶，若存在，则修改 value
        for (Pair pair : bucket) {
            if (pair.key == key) {
                pair.value = value;
                return;
            }
        }
        // 若不存在，则添加到尾部
        bucket.add(new Pair(key, value));
        size++;
    }

    // 删除
    public void remove(int key) {
        int index = hashFunc(key);
        List<Pair> bucket = buckets.get(index);
        // 遍历桶，找到则移除
        for (int i = 0; i < bucket.size(); i++) {
            if (bucket.get(i).key == key) {
                bucket.remove(i);
                size--;
                break;
            }
        }
    }

    // 扩容哈希表
    private void extend() {
        capacity *= extendRatio;
        // 暂存哈希表
        List<List<Pair>> tempList = buckets;
        // 初始化哈希表
        buckets = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            buckets.add(new ArrayList<>());
        }
        size = 0;
        // 将原哈希表搬运到新哈希表
        for (List<Pair> pairs : tempList) {
            for (Pair pair : pairs) {
                put(pair.key, pair.value);
            }
        }
    }

    // 获取所有键
    public List<Integer> keySet() {
        List<String> keySet = new ArrayList<>();
        for (List<Pair> bucket : buckets) {
            for (Pair pair : bucket) {
                keySet.add(pair.key);
            }
        }
        return keySet;
    }

    // 获取所有键值对
    public List<Pair> pairSet() {
        List<Pair> pairSet = new ArrayList<>();
        for (List<Pair> bucket : buckets) {
            pairSet.add(bucket);
        }
        return pairSet;
    }

    // 获取所有值
    public List<String> valueSet() {
        List<String> valueSet = new ArrayList<>();
        for (List<Pair> bucket : buckets) {
            for (Pair pair : bucket) {
                valueSet.add(pair.value);
            }
        }
        return valueSet;
    }

    // 打印哈希表
    public void print() {
        for (List<Pair> bucket : buckets) {
            for (Pair pair : bucket) {
                System.out.println(pair.key + " -> " + pair.value);
            }
        }
    }
}


public class HashMapChain {
    public static void main(String[] args) {
        ChainHashMap chainHashMap = new ChainHashMap();
        
        chainHashMap.put(1, "1");
        chainHashMap.put(2, "2");
        chainHashMap.put(3, "3");
        chainHashMap.put(4, "4");
        chainHashMap.put(5, "5");
        chainHashMap.put(6, "6");

        System.out.println(chainHashMap.get(3));
        System.out.println(chainHashMap.get(4));

        chainHashMap.remove(2);

        chainHashMap.print();

        chainHashMap.remove(3);
        System.out.println(chainHashMap.valueSet().toString());
    }
}

