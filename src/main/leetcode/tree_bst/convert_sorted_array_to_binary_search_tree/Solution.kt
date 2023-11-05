package leetcode.tree_bst.convert_sorted_array_to_binary_search_tree

import kotlin.math.ceil

fun main() {
    print(sortedArrayToBST(intArrayOf(-10,-3,0,5,9)))
}

fun sortedArrayToBST(nums: IntArray): TreeNode? {
    if (nums.isEmpty()) return null

    val left = 0
    val right = nums.size - 1
    val center = (left + right / 2)

    // 真ん中の要素
    val root = TreeNode(nums[center])

    // centerより左/右側で同じことする
    root.left = sortedArrayToBST(nums.take(center).toIntArray())
    root.right = sortedArrayToBST(nums.takeLast(nums.size - (center + 1)).toIntArray())

    return root
}