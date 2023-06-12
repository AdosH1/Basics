import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class IteratorTest {
    fun generateIterator(n : Int) : Iterator<Int> {
        var it = Iterator(1);
        for (i in 2..n) {
            it = it.add(i);
        }
        return it;
    }

    @Test
    fun testAdd() {
        var it = generateIterator(5);

        var res = it.head
        assertTrue(res?.value == 1);
        res = res?.next;
        assertTrue(res?.value == 2);
        res = res?.next;
        assertTrue(res?.value == 3);
        res = res?.next;
        assertTrue(res?.value == 4);
        res = res?.next;
        assertTrue(res?.value == 5);
    }

    @Test
    fun testRemove() {
        var it = generateIterator(5);
        it.remove(3);

        var res = it.head
        assertTrue(res?.value == 1);
        res = res?.next;
        assertTrue(res?.value == 2);
        res = res?.next;
        assertTrue(res?.value == 4);
        res = res?.next;
        assertTrue(res?.value == 5);
    }

    @Test
    fun testToList() {
        var it = generateIterator(5);

        var res = it.toList();
        var compare = listOf<Int>(1, 2, 3, 4, 5);
        assertEquals(res, compare);
    }

    @Test
    fun testToIterator() {
        var list = listOf<Int>(1, 2, 3, 4, 5);
        var res = Iterator.fromList(list);

        assertTrue(res?.value == 1);
        res = res?.next
        assertTrue(res?.value == 2);
        res = res?.next;
        assertTrue(res?.value == 3);
        res = res?.next;
        assertTrue(res?.value == 4);
        res = res?.next;
        assertTrue(res?.value == 5);
    }
}