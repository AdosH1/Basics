import Hashmap.Hashmap

class EvilObject(value : Int);

fun main(args: Array<String>) {

    var hm = Hashmap<Int, Int>()

    hm[1] = 1;
    hm[2] = 2;

    println(hm[1])

}