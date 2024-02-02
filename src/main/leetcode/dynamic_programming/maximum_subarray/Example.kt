package leetcode.dynamic_programming.maximum_subarray

fun main() {

}

fun maxProfit(prices: IntArray): Int {
    var profit = 0

    for (i in 0..prices.size - 2) {
        val diff = prices[i + 1] - prices[i]
        if (diff > 0) profit += diff
    }

    return profit
}