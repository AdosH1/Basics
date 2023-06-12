class Iterator<T>(var value : T, var head : Iterator<T>? = null) {
    public var next : Iterator<T>? = null;

    fun add(it : T) : Iterator<T> {
        var c = if (head == null)  Iterator(it, this) else  Iterator(it, head);

        if (next == null) next = c;
        else {
            var n = next;
            next = c;
            c.next = n;
        }
        return c;
    }

    fun remove(value : T) : Boolean {
        var e = head ?: this;
        var prev : Iterator<T>? = null;
        var found =  false;

        while (true) {
            if (e.value == value) {
                found = true;
                break;
            }
            prev = e;
            e = e.next!!;
        }
        if (!found) return false;

        if (prev != null) {
            var n = e.next
            if (n != null) prev.next = n;
            else prev.next = null;
        }
        return true;
    }

    fun toList() : List<T> {
        var l = mutableListOf<T>();
        var e = head ?: this;
        while (true) {
            l.add(e.value);
            if (e.next == null) break;
            e = e.next!!;
        }
        return l;
    }

    companion object
    {
        fun <T> fromList(l : List<T>) : Iterator<T>? {
            if (l.size < 1) return null;

            var it = Iterator(l[0]);
            for (i in 1 until l.size) {
                it = it.add(l[i]);
            }
            return it.head;
        }
    }
}