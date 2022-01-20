package lru;

/**
 * @author yuchao
 * @create 2021-11-10-3:52 下午
 */
public interface Cache<K, V> {

    boolean put(K key, V value);

    int size();

    boolean isEmpty();

    void clear();
}
