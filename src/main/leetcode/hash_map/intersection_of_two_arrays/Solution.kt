package leetcode.hash_map.intersection_of_two_arrays

fun main(){
    val result = intersection(
        intArrayOf(1,2,2,1),
        intArrayOf(2,2)
    )

    print(result)
}

/**
 * Acceptはされたけど遅い
 */
fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
    var output = mutableSetOf<Int>()

    nums1.forEach {
        if(nums2.contains(it)) {
            output.add(it)
        }
    }

    return output.toIntArray()
}