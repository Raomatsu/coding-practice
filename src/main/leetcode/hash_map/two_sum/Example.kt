package leetcode.hash_map.two_sum

fun main () {
    printResult(intArrayOf(2,7,11,15),9)
    printResult(intArrayOf(3,2,4),6)
    printResult(intArrayOf(3,3),6)
}

fun twoSumExample(nums: IntArray, target: Int): IntArray {

    for(index in 0..nums.size-1) {
        for( innerIndex in index+1 until nums.size) {
            if(nums[index] + nums[innerIndex] == target ) return intArrayOf(index, innerIndex)
        }
    }
    return intArrayOf()
}

fun printResult(nums: IntArray, target: Int) {
    println(twoSumExample(nums, target).toList())
}

