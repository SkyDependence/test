// 键值对

import java.util.ArrayList;

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
    private List<List<Pair>> buckets; // 桶数组

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

    } 

    // 添加
    public void put(int key, String value) {

    }

    // 删除
    public void remove(int key) {

    }

    // 扩容哈希表
    public void extend() {

    }

    // 获取所有键
    public List<Integer> keySet() {

    }

    // 获取所有键值对
    public List<Pair> pairSet() {

    }

    // 获取所有值
    public List<String> valueSet() {

    }

    // 打印哈希表
    public void print() {

    }
}


public class HashMapChain {
    
}
