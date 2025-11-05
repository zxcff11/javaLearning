package demo.lfu;


import java.util.HashMap;
import java.util.Map;

public class lfu_1 {
    private final int Capability;
    private final Map<Integer, Integer> keyToFreq = new HashMap<Integer, Integer>();
    private final Map<Integer, Map<Integer, Integer>> freqToMap = new HashMap<>();
    private int minFreq;

    public lfu_1(int capability) {
        Capability = capability;
    }

    private int get(int key) {
        return move(key, null);
    }

    private void put(int key, Integer value) {
        if (move(key, value) != -1) {
            return;
        }
        if (keyToFreq.size() == Capability) {
            Map<Integer, Integer> map = freqToMap.get(minFreq);
            Integer oldestKey = map.keySet().iterator().next();
            map.remove(oldestKey);
            keyToFreq.remove(oldestKey);
        }

        keyToFreq.put(key, 1);
        freqToMap.computeIfAbsent(1, k -> new HashMap<>()).put(key, value);
        minFreq = 1;
    }

    private int move(int key, Integer value) {

        Integer freq = keyToFreq.get(key);
        if (freq == null) {
            return -1;
        }

        Map<Integer, Integer> map = freqToMap.get(freq);
        Integer v = map.remove(key);
        if (value == null) {
            value = v;
        }

        if (map.size() == 0 && minFreq == freq) {
            minFreq++;
        }

        keyToFreq.merge(key, 1, Integer::sum);
        freqToMap.computeIfAbsent(freq + 1, k -> new HashMap<>()).put(key, value);

        return value;
    }
}
