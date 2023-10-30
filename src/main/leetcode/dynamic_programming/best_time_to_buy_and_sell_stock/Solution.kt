package leetcode.dynamic_programming.best_time_to_buy_and_sell_stock

import kotlin.math.max

fun main() {

}

fun maxProfit2(prices: IntArray): Int {
    var profit = 0
    // 繰り返しにすると若い番号を無駄に計算しなきゃいけない可能性が出てくる
    // 例) [3,2,1,5,6,7]都かの場合、1があるから3,2は必要以上に計算しなくて良いが、単純なループだと全部計算しないといけなくなる。
    var buy = 0
    var sell = 1

    // whileを使うことでindexに基づくループ
    while(sell < prices.size) {
        // prices[若いindex] > prices[index]ということは、それ以降はprices[若いindex]の考慮不要
        if (prices[buy] > prices[sell]) {
            buy ++
            sell = buy + 1
        } else {
            // maxOfとかいうメソッド便利
            profit = maxOf(profit, prices[sell] - prices[buy])
            sell ++
        }
    }

    return profit
}

/**
 * こっちの方が、小さい要素見つかったときの鞍替え処理がしっくり来る...気がする。
 * ↑のは、[2,3,1,...]みたいなときに、1をsell、2をbuyにしたときに、次をbuyを3にしないといけない気がする
 */
fun maxProfit3(prices: IntArray): Int {
    // リストが空なら0
    if (prices.isEmpty()) return 0

    var r = 1
    var l = 0
    var profit = 0

    while (r < prices.size) {
        profit = max(profit, prices[r] - prices[l])
        if (prices[r] < prices[l]) {
            l = r
        }
        r ++
    }
    return profit
}