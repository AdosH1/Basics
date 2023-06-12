import Hashmap.Hashmap
import kotlin.test.Test
import kotlin.test.assertEquals

class HashmapTest {
    private fun createSimpleHashmap() : Hashmap<Int, Int> {
        var hm = Hashmap<Int, Int>()

        hm.add(1, 1);
        hm.add(2, 2);
        hm.add(3, 3);
        hm.add(4, 4);
        hm.add(5, 5);

        return hm;
    }

    @Test
    fun testAdd() {
        var hm = createSimpleHashmap();

        var i = 1;
        for (key in hm.keys()) {
            assertEquals(hm.get(key), i++)
        }
    }

    @Test
    fun testRemove() {
        var hm = createSimpleHashmap();

        hm.remove(3)

        assertEquals(1, hm.get(1))
        assertEquals(2, hm.get(2))
        assertEquals(null, hm.get(3))
        assertEquals(4, hm.get(4))
        assertEquals(5, hm.get(5))
    }

    @Test
    fun testClear() {
        var hm = createSimpleHashmap();
        hm.clear()

        assertEquals(null, hm.get(1))
        assertEquals(null, hm.get(2))
        assertEquals(null, hm.get(3))
        assertEquals(null, hm.get(4))
        assertEquals(null, hm.get(5))
    }

}