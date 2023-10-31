package leetcode.binary_search.search_insert_position

fun searchInsert(nums: IntArray, target: Int): Int {
    // 見つかった場合
    val index = nums.indexOf(target)
    if (index != -1) return index

    // 見つからなかった場合
    var insertIndex = 0
    while ( insertIndex < nums.size && target > nums[insertIndex] ) {
        insertIndex ++
    }

    return  insertIndex
}