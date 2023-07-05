package leetcode.hash_map.two_sum

fun main(){
    printResultEx2(intArrayOf(2,7,11,15),9)
    printResultEx2(intArrayOf(3,2,4),6)
    printResultEx2(intArrayOf(3,3),6)
}

/**
 * 基本はリストから連想配列の要素を生成していく（key：値　value：インデックス）
 * 各周で、それまで追加した要素の中に、足すとtargetになるものがないか探して、
 * 見つかればセットにして返却する。
 */
fun twoSumExample2(nums: IntArray, target: Int): IntArray {
    val hashMap = mutableMapOf<Int, Int>() // value to index

    for((i,v) in nums.withIndex()) {
        val diff = target -v
        val indexForDiffValue = hashMap.get(diff)

        indexForDiffValue?.let {
            return@twoSumExample2 intArrayOf(indexForDiffValue, i)
        }

        hashMap[v] = i
    }

    throw IllegalStateException("no solution found")
}

fun printResultEx2(nums: IntArray, target: Int){
    println(twoSumExample2(nums, target).toList())

}