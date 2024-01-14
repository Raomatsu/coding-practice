package leetcode.dynamic_programming.maximum_subarray

fun main() {

}

fun maxSubArray(nums: IntArray): Int {
    var currentMax = nums[0]
    var maxOfAll = nums[0]

    for( i in 1 until nums.size ) {
        currentMax = Math.max(nums[i], currentMax + nums[i])
        maxOfAll = Math.max(maxOfAll, currentMax)
    }

    return maxOfAll
}
