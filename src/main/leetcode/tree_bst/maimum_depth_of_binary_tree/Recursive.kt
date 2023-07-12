package leetcode.tree_bst.maimum_depth_of_binary_tree

fun main() {
//    print(factorial(4) == 24)
    print(factorialRec(3))
}

/**
 * for文でnの階乗
 */
fun factorial(n: Int): Int {
    var result = 1

    for(i in 1..n) {
        result *= i
    }
    return result
}

/**
 * 再帰的に計算
 */
fun factorialRec(n: Int): Int {
    // n=1になったところから呼び出し元へぐるっと返っていく
    if (n == 1) return 1

    return n * factorialRec(n-1)
}

/**
 * 1 + 2 + ... + n
 */
fun addToN(n: Int): Int {
    if (n == 0) return 0
    return n + addToN(n-1)
}

/**
 * フィボナッチ数列のn項目の値を算出
 */
fun fibo(n: Int): Int {
    if (n == 0) return 0
    else if (n == 1) return 1

    return fibo(n-1) + fibo(n-2)
}