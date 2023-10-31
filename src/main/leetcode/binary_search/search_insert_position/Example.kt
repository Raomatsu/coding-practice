package leetcode.binary_search.search_insert_position

fun searchInsert2(nums: IntArray, target: Int): Int {
    // 最後まで計算するパターンを弾く
    if (target > nums[nums.size - 1]) return nums.size

    var output = nums.size
    for (i in nums.indices) {
        if(nums[i] >= target) {
            output = i
            break
        }
    }

    return output
}

/**
 * 二分探索
 * [1,3,5,6], 5
 */
fun searchInsert3(nums: IntArray, target: Int): Int {
    var l = 0
    var r = nums.size - 1
    var mid: Int
    var currentItem: Int

    while (l <= r) {
        mid = (l + r) / 2
        currentItem = nums[mid]

        when {
            currentItem == target -> return mid
            currentItem > target -> r = mid - 1
            else -> l = mid + 1
        }
    }

    return l
}

