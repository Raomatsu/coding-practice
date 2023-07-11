package leetcode.tree_bst.maimum_depth_of_binary_tree

import kotlin.math.pow

fun main(){

}

fun maxDepth(root: TreeNode?): Int {
    var depth = 0
    var numOfNodes = 0.0
    if(root == null) return 0

    // 2の0乗～2のdepth乗までを足した値がノードの数に等しくなるまで足しこむ
    while(numOfNodes <= root.`val`) {
        depth++
        numOfNodes += 2.0.pow(depth.toDouble() - 1.0)
    }

    return depth
}