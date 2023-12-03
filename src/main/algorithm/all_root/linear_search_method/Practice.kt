package algorithm.all_root.linear_search_method

fun main() {
}

/**
 * vと一致する値があるかどうか
 */
fun test1(array: IntArray, v: Int): Boolean {
    array.forEach {
        if (it == v) return true
    }

    return false
}

fun kotlinSolution1(array: IntArray, v: Int): Boolean {
    return array.toList().contains(v)
}

/**
 * 数列の最小値
 */
fun test2(array: IntArray): Int {
    var min = Int.MAX_VALUE
    array.forEach {
        if (it < min) {
            min = it
        }
    }
    return min
}

fun kotlinSolution2(array: IntArray): Int {
    return array.min()
}