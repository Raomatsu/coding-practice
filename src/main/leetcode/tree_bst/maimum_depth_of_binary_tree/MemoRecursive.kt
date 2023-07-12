package leetcode.tree_bst.maimum_depth_of_binary_tree

// グローバル変数としてmemoを定義。
// 配列長は後から書き換える前提
var memo = LongArray(0)

fun main() {
    val n = 50
    // nというのはフィボナッチ数列ではn+1番目の項なので、配列長はn+1
    memo = LongArray(n+1)
    memoRecursiveFibo(n)
}

/**
 * メモ化再帰を使ってフィボナッチ数列のn項目の値を導出する
 */
fun memoRecursiveFibo(n: Int): Long {

    // n番目のメモに値が入っていればそれをそのまま返す
    if (memo[n] != 0L) return memo[n]

    // ベースケース
    if (n == 0) return 0
    if (n == 1) return 1

    (memoRecursiveFibo(n-1) + memoRecursiveFibo(n-2)).let {
        // memoに値をメモ。こうすることで、F(n-1)のターンで計算したものをF(n-2)のターンでは省略できる
        memo[n] = it
        return it
    }
}