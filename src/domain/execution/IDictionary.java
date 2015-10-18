package domain.execution;

/**
 * Dictionary interface which maps a string to an int.
 */
public interface IDictionary {
    /**
     * Will return the value mapped to the key given as parameter.
     *
     * @param key Key whose value will be returned
     * @return the value mapped to key
     * @throws InvalidKeyException if key is not present.
     */
    int get(String key) throws InvalidKeyException;

    /**
     * Maps value to key. If key doesn't exist it will be added. Otherwise the previous value will be overwritten.
     *
     * @param key   Value will be mapped to this key.
     * @param value that will be mapped to key.
     */
    void put(String key, int value);
}
