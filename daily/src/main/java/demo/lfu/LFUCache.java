package demo.lfu;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

// 为方便读者理解核心逻辑，该写法没有删除空的 LinkedHashMap
public class LFUCache {
    private final int capacity;
    private final Map<Integer, Integer> keyToFreq = new HashMap<>();
    private final Map<Integer, Map<Integer, Integer>> freqToMap = new HashMap<>();
    private int minFreq;

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        return move(key, null);
    }

    public void put(int key, int value) {
        if (move(key, value) != -1) { // 有这本书
            return;
        }
        if (keyToFreq.size() == capacity) { // 书太多了
            Map<Integer, Integer> map = freqToMap.get(minFreq); // 最左边那摞书
            Integer oldestKey = map.keySet().iterator().next(); // 这摞书最下面的书
            map.remove(oldestKey); // 移除
            keyToFreq.remove(oldestKey);
        }
        // 新书，放在「看过 1 次」的最上面
        keyToFreq.put(key, 1);
        freqToMap.computeIfAbsent(1, k -> new LinkedHashMap<>()).put(key, value);
        minFreq = 1;
    }

    // 把 key 从第 freq 摞书中抽出来，放到第 freq+1 摞书的最上面
    // 返回 key 对应的 value
    private int move(Integer key, Integer value) {
        Integer freq = keyToFreq.getOrDefault(key, null);
        if (freq == null) { // 没有这本书
            return -1;
        }
        Map<Integer, Integer> map = freqToMap.get(freq);
        Integer v = map.remove(key); // 从第 freq 摞书中抽出来
        if (value == null) {
            value = v;
        }
        // 抽出来后，这摞书是空的，且这摞书是最左边的
        if (map.size() == 0 && minFreq == freq) {
            minFreq++;
        }
        // 看书次数 +1
        keyToFreq.merge(key, 1, Integer::sum);
        // 放在右边这摞书的最上面
        freqToMap.computeIfAbsent(freq + 1, k -> new LinkedHashMap<>()).put(key, value);
        return value;
    }
}
