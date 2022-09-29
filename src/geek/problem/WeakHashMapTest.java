package geek.problem;

import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapTest {
    public static void main(String[] args) {
        Map<String, Integer> cache = getCache();
        while (cache.size() == 3) {
            System.out.println(cache.size());
        }
    }

    public static Map<String, Integer> getCache() {
        Map<String, Integer> cache = new WeakHashMap<>();
        cache.put(new String("1"), 1);
        cache.put(new String("2"), 2);
        cache.put(new String("3"), 3);
        return cache;
    }
}