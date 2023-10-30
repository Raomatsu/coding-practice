package leetcode.dynamic_programming.best_time_to_buy_and_sell_stock

fun main(){
    val testList1 = intArrayOf(7,6,4,3,1)
    print(maxProfit(testList1))
}

fun maxProfit(prices: IntArray): Int{
    var maxProfit = 0

    // 全priceについて、自身より前にあるpriceとの差を求める。それの最大値を返す。
    for ((index, price) in prices.withIndex()){
        for ((index2, price2) in prices.withIndex()) {
            if (index <= index2) continue
            maxProfit = if (price - price2 > maxProfit) price - price2 else maxProfit
        }
    }

    return maxProfit
}

