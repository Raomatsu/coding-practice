package algorithm.recursive.example

fun main() {
    println(recursiveEx(3))

    println(euclid(9, 6))
}

/**
 * 受け取った整数Nについて、1 + ... + Nを導出する
 */
fun recursiveEx(n: Int): Int {
    if (n == 0) return 0
    return n + recursiveEx(n - 1)
}

/**
 * ユークリッドの互除法。
 * 2つの整数の最大公約数を求める
 */
fun euclid(m: Int, n: Int): Int {
    if (n == 0) return m

    return euclid(n, m % n)
}

/**
 * フィボナッチ数列の、F(n)を求める。
 * 　・F(0) = 0
 * 　・F(1) = 1
 * 　・F(n) = F(n-1) + F(n-2)
 */
// 再帰
// →計算量が爆発的に多くなる
fun fibonacci(n: Int): Int {
    if (n == 0) return 0
    if (n == 1) return 1

    return fibonacci(n - 1) + fibonacci(n - 2)
}

// 増加ループ
fun fibo2(n: Int): Int {
    val nums = IntArray(n)
    nums[0] = 0
    nums[1] = 1

    for (i in 2 .. n) {
        nums[i] = nums[i - 1] + nums[i - 2]
    }

    return nums[n]
}

/**
 * メモ化を使った再帰
 */
fun fibo3(n: Int, memo: MutableList<Int>): Int {
    // ベースケース
    if (n == 0) return 0
    if (n == 1) return 1

    // メモをチェック
    if (memo[n] != 0) return memo[n]

    val result = fibo3(n - 1, memo) + fibo3(n - 2, memo)

    // 答えをメモに格納
    memo[n] = result
    return result
}

/**
 * ナップサック問題
 * arrayの中から、総和がwになる組み合わせが作れるか
 */
fun recursive2(array: IntArray, w: Int, i: Int): Boolean {
    // ベースケース
    if (w == 0) return true
    if (i == 0) return false

    // i番目の数を選ぶ or 選ばない
    return recursive2(array, w - array[i], i - 1) ||
            recursive2(array, w, i - 1)
}