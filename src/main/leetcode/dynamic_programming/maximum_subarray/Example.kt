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

fun maxSubArray2(nums: IntArray): Int {
    var currentMax = nums[0]
    var maxOfAll = nums[0]

    for( i in 1 until nums.size ) {
        currentMax = if(nums[i] > currentMax + nums[i]) nums[i] else currentMax + nums[i]
        maxOfAll = if(maxOfAll > currentMax) maxOfAll else currentMax
    }

    return maxOfAll
}

fun maxSubArray3(nums: IntArray): Int {
    var currentMax = nums[0]
    var maxOfAll = nums[0]

    for( i in 1 until nums.size ) {
        currentMax = if(nums[i] > currentMax + nums[i]) nums[i] else currentMax + nums[i]
        maxOfAll = if(maxOfAll > currentMax) maxOfAll else currentMax
    }

    return maxOfAll
}