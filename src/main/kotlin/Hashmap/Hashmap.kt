package Hashmap

class Hashmap<K, V>() {
    val DEFAULT_MAX_SIZE : Int = 1024;
    var items : Array<KeyValue<K, V>?> = arrayOfNulls(DEFAULT_MAX_SIZE);

    operator fun get(k : K) : V? {
        val index = hash(k);
        val item = items[index]
        return findKey(item, k);
    }

    operator fun set(k : K, v : V) {
        add(k, v)
    }

    // If index not taken, sets kv at index
    // If key is taken, sets the value of k
    // Otherwise, append to end of the list
    fun add(k : K, v : V) {
        val index = hash(k);
        var item = items[index];
        var (prev, curr, next) = traverseKeys(item, k)

        if (prev == null) items[index] = KeyValue(k, v)
        else if (curr?.value == k) curr?.value = v;
        else prev.next = KeyValue(k, v)
    }

    fun remove(k : K) : V? {
        val index = hash(k);
        var item = items[index];
        var (prev, curr, next) = traverseKeys(item, k)

        // no key found
        if (curr == null) return null;
        // if key is the first key, we need to replace the first element in the linked list
        else if (curr?.key == item?.key) {
            items[index] = item?.next;
            return item?.value;
        }
        // key is further down the linked list and we need to remove it at the end or between 2 nodes
        else {
            prev?.next = next;
            return curr?.value;
        }
    }

    fun clear() {
        items = arrayOfNulls(DEFAULT_MAX_SIZE);
    }

    fun keys() : List<K> {
        var l = mutableListOf<K>()
        for (e in items) {
            if (e != null) {
                l.add(e.key)
            }
        }
        return l;
    }

    private fun hash(k : K) : Int {
        return k.hashCode() % DEFAULT_MAX_SIZE;
    }

    private fun findKey(item : KeyValue<K, V>?, k : K) : V? {
        if (item == null) return null
        else {
            if (item?.key == k) return item?.value;
            else return findKey(item?.next, k);
        }
    }

    /// Traverses a linked list of keys until it finds the key or null
    /// If key not found, prev is the last element and curr is null
    // If key is found, curr = Hashmap.KeyValue
    private fun traverseKeys(item : KeyValue<K, V>?, k : K) : Triple<KeyValue<K, V>?, KeyValue<K, V>?, KeyValue<K, V>?> {
        var prev : KeyValue<K, V>? = null;
        var curr = item;
        var next = item?.next;

        if (curr == null || curr?.value == k) return Triple(prev, curr, next)
        else {
            while (true) {
                prev = curr;
                curr = item?.next;
                next = curr?.next;
                if (curr == null || curr?.key == k) {
                    return Triple(prev, curr, next)
                }
            }
        }
    }
}

class KeyValue<K, V>(var key : K, var value : V) {
    var next : KeyValue<K, V>? = null
}