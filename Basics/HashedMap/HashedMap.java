package Basics.HashedMap;

public class HashedMap<K, V> {
    /*
     * what is a hash function?
     * A hash function is a function that converts data of varying size to a value
     * of fixed size.
     * Usually, the output is a 32 bit integer.
     * The output is called a hash code, hash value, or simply hash.
     * If two different items have the same hash value, it is called a collision.
     * A good hash function minimizes collisions.
     * A hash table is a data structure that uses a hash function to map keys to
     * values.
     * A valid hash function must always return the same hash value for the same
     * input, which means,
     * two identical items must have the same hash value.
     * A hash table maps an item of one type to an item of another type.
     * Data is stored in an array format, where each data value has a unique index
     * value.
     * When we add a (key, value) pair to a hash table, the key is hashed
     * and the resulting hash value is used as the index at which to store the
     * value.
     * When we want to retrieve a value, we hash the key again and use the hash
     * value
     * to find the index where the value is stored.
     * But, as the number of keys increase, the possibility of collision increases.
     * if two keys have the same hash value, we do something called chaining.
     * Instead of storing the entry directly in the array, we use a list of
     * key-value pairs for each entry in the array.
     * So, each entry in the array is a list of key-value pairs.
     * The list is usually a linked list, but it can be any data structure that
     * supports insertion and traversal.
     * Another strategy is open addressing, where we find the next available slot in
     * the array. If there is no available slot,
     * we can resize the array and rehash all the keys.
     * Average time complexity for search, insert and delete is O(1). This is
     * because the underlying array increases dynamically.
     */

    static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int SIZE = 16; // initial capacity of the hash table
    private Entry<K, V>[] table;

    @SuppressWarnings("unchecked")
    public HashedMap() {
        table = new Entry[SIZE];
    }

    private int getIndex(K key) {
        return Math.abs(key.hashCode()) % SIZE;
    }

    public void put(K key, V value) {
        int index = getIndex(key);

        // If slot is empty, insert
        if (table[index] == null) {
            table[index] = new Entry<>(key, value);
            return;
        }

        // If same key, update
        if (table[index].key.equals(key)) {
            table[index].value = value;
            return;
        }

        // If different key already exists => overwrite (no chaining/rehash here)
        table[index] = new Entry<>(key, value);
    }

    public V get(K key) {
        int index = getIndex(key);
        if (table[index] != null && table[index].key.equals(key)) {
            return table[index].value;
        }
        return null; // Not found
    }

    public void remove(K key) {
        int index = getIndex(key);
        if (table[index] != null && table[index].key.equals(key)) {
            table[index] = null;
        }
    }
}
