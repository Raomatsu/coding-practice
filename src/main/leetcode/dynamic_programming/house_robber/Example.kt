package leetcode.dynamic_programming.house_robber

fun main() {

}
fun maxProfit(prices: IntArray): Int {
    var profit = 0

    for (i in 0..prices.size - 2) {
        // 次要素都のが大きければ差分+1
        val diff = prices[i + 1] - prices[i]
        if (diff > 0) profit += diff
    }

    return profit
}