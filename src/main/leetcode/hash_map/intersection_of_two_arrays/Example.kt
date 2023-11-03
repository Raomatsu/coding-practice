package leetcode.hash_map.intersection_of_two_arrays

fun main() {
    val result = intersection3(
        intArrayOf(1,2,2,1),
        intArrayOf(2,2)
    )

}
/**
 * kotlinの標準関数バリバリ利用バージョン
 */
fun intersection2(nums1: IntArray, nums2: IntArray): IntArray {
    return nums1.toSet().intersect(nums1.toSet()).toIntArray()
}

/**
 * アルゴリズム意識バージョン
 */
fun intersection3(nums1: IntArray, nums2: IntArray): IntArray {
    // 要素数は、登場する最大の数字+1。例えば、最大の数字が2なら、num1/2[i] >= 0なので、全重複してても要素数は3になる。的な。
    val array = IntArray(Math.max(nums1.max()!!, nums2.max()!!) + 1)

    // arrayの各要素を、nums1とnums2を合算した集合と捉えて、num2に存在する数字にあたる要素にフラグを立てる
    for (i in 0 until nums2.size) {
        array[nums2[i]] = 1
    }
    val list = mutableListOf<Int>()

    // ↑でフラグを立てた数字がnums1にあれば、それを重複要素として抽出
    for (i in 0 until nums1.size) {
        if (array[nums1[i]] == 1) {
            list.add(nums1[i])
            array[nums1[i]] = 0
        }
    }

    return list.toIntArray()
}