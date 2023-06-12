import kotlin.test.Test
import kotlin.test.assertTrue

class HigherOrderFunctionsTest {
    @Test
    fun testReduce() {
        fun Sum (a : Int, b: Int) : Int = a + b;

        var list = listOf<Int>(1, 2, 3, 4, 5);
        var res = list.Reduce(::Sum, 0);

        assertTrue(res == 15);
    }

    @Test
    fun testMap() {
        fun Stringify(a : Int) : String = a.toString() + "s"

        var list = listOf<Int>(1, 2, 3, 4, 5);
        var res = list.Map(::Stringify);

        assertTrue(res[0] == "1s");
        assertTrue(res[1] == "2s");
        assertTrue(res[2] == "3s");
        assertTrue(res[3] == "4s");
        assertTrue(res[4] == "5s");
    }

    @Test
    fun testFilter() {
        fun GreaterThan2(a : Int) : Boolean = a > 2;

        var list = listOf<Int>(1, 2, 3, 4, 5);
        var res = list.Filter(::GreaterThan2);

        assertTrue(res[0] == 3);
        assertTrue(res[1] == 4);
        assertTrue(res[2] == 5);
    }

    @Test
    fun testUnfold() {
        fun ToTwoStrings(a : Int) : List<String> = listOf(a.toString() + "s", (a + 1).toString() + "z")

        var list = listOf<Int>(1, 2, 3, 4, 5);
        var res = list.Unfold(::ToTwoStrings);

        assertTrue(res[0] == "1s");
        assertTrue(res[1] == "2z");
        assertTrue(res[2] == "2s");
        assertTrue(res[3] == "3z");
        assertTrue(res[4] == "3s");
        assertTrue(res[5] == "4z");
        assertTrue(res[6] == "4s");
        assertTrue(res[7] == "5z");
        assertTrue(res[8] == "5s");
        assertTrue(res[9] == "6z");
    }


}