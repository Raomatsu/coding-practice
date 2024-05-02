package leetcode.dynamic_programming.house_robber_2

fun main() {
    print(rob(intArrayOf(2,3,2)))
}
fun rob(nums: IntArray): Int {
    if (nums.size == 1) return nums[0]
    return Math.max(rob(nums, 0, nums.size-2), rob(nums, 1, nums.size-1))
}

private fun rob(nums: IntArray, start: Int, end: Int): Int {
    var a = 0
    var b = 0
    for (i in start..end)
    {
        var temp: Int = b
        if (a + nums[i] > b)
        {
            b = a + nums[i]
        }
        // https://leetcode.com/problems/house-robber/description/都の差分
        a = temp
    }
    return b
}