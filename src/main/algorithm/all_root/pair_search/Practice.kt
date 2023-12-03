package algorithm.all_root.pair_search

fun test1(array1: IntArray, array2: IntArray, baseLine: Int): Int {
    var min = Int.MAX_VALUE
    array1.forEach { int1 ->
        array2.forEach { int2 ->
            if (int1 + int2 < min && int1 + int2 >= baseLine) {
                min = int1 + int2
            }
        }
    }
    return min
}