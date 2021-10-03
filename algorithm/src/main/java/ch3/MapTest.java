package ch3;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author yuchao
 * @create 2021-08-22-10:13 上午
 */
public class MapTest {

    public static void main(String[] args) {
        Map<Integer, String> map = new ConcurrentHashMap<>();

        map.put(0, "111");
        map.put(1, "111");
        map.put(2, "111");
        map.put(3, "111");
        map.put(4, "111");
        map.put(5, "111");
        map.put(6, "111");
        map.put(7, "111");
        map.put(8, "111");
        map.put(9, "111");
        map.put(10, "111");
        map.put(11, "111");
        map.put(12, "111");


    }
}
