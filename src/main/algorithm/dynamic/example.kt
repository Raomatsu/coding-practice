package algorithm.dynamic

import kotlin.math.abs
import kotlin.math.min

fun main() {
    print(q1(intArrayOf(2,9,4,5,1,6,10)))
}

/**
 * Q1
 * array：各足場の高さ
 */
fun q1(array: IntArray): Int {

    // i番目の足場までの最小コスト
    val costList = IntArray(array.size)

    // 0,1番目の足場までのコストは一意
    costList[0] = 0
    costList[1] = array[1] - array[0]

    for (i in 2 until array.size) {
        // 最小コストを入れていく
        costList[i] = min(
            // 2個前の足場から来るコスト
            abs((costList[i-2] + array[i] - array[i-2])),
            // 隣の足場から来るコスト
            abs((costList[i-1] + array[i] - array[i-1]))
        )
    }

    return costList[array.size - 1]
}

fun q1_2(array: IntArray): Int {
    val costList = IntArray(array.size) { Int.MAX_VALUE }

    // 出発地点のコストは0
    costList[0] = 0

    for(i in 1 until array.size) {
        // かかるコストを比較して小さい方を選んでいく→緩和
        costList[i] = min(
            costList[i],
            abs(costList[i-1] + array[i] - array[i - 1])
        )
        if ( i > 1 ) {
            costList[i] = min(
                costList[i],
                abs(costList[i - 2] + array[i] - array[i - 2])
            )
        }
    }
    return costList[array.size - 1]
}

// 「配る」遷移形式での動的計画法
fun q1_3(array: IntArray): Int {
    val costList = IntArray(array.size) { Int.MAX_VALUE }
    costList[0] = 0

    for(i in array.indices) {
        if (i + 1 < array.size) {
            costList[i + 1] = min(
                costList[i + 1],
                costList[i] + abs(costList[i] - costList[i + 1])
            )
        }
        if (i + 2 < array.size) {
            costList[i + 2] = min(
                costList[i + 2],
                costList[i] + abs(costList[i] - costList[i + 2])
            )
        }
    }

    return costList.last()
}

/**
 *メモ化再帰
 * */
val array_4 = IntArray(100) // ここに足場の情報が入るとする
val costList_4 = IntArray(100) { Int.MAX_VALUE}
// i番目の足場の最小コストを算出
fun recursive(i: Int): Int {
    // メモされた値であれば即return
    if (costList_4[i] < Int.MAX_VALUE) return costList_4[i]

    // ベースケース
    if (i == 0) return 0

    var cost = 0

    // i-1から来るのを想定する場合
    cost = min(
        costList_4[i],
        abs(recursive(i - 1) + abs(array_4[i] - costList_4[i - 1]))
    )

    // i-2から来るのを想定する場合
    cost = min(
        costList_4[i],
        abs(recursive(i - 2) + abs(array_4[i] - costList_4[i - 1]))
    )

    costList_4[i] = cost
    return cost
}