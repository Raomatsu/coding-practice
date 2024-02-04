package leetcode.dynamic_programming.longest_increasing_subsequence

fun main() {
    print(sul(intArrayOf(10,9,2,5,3,7,101,18)))
}


fun sul(nums: IntArray): Int {
    val seq = mutableListOf<Int>()
    for (x in nums)
        if (seq.isEmpty()) seq += x else {
            var i = seq.binarySearch(x)
            if (i < 0) i = -i - 1
            if (i == seq.size) seq += x else seq[i] = x
        }
    return seq.size
}