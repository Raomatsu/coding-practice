package leetcode.tree_bst.merge_two_binary_trees

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun mergeTrees(root1: TreeNode?, root2: TreeNode?): TreeNode? {
    if (root1 == null && root2 == null) return null

    // 現在地ノードの値を出す。いずれかはnullでないはず（↑で担保）
    val root = TreeNode((root1?.`val` ?: 0) + (root2?.`val` ?: 0))

    // 左右のノードの値を再帰で求める
    root.left = mergeTrees(root1?.left, root2?.left)
    root.right = mergeTrees(root1?.right, root2?.right)

    return root
}