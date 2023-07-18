package leetcode.tree_bst.minimum_depth_of_binary_tree

fun main() {
    print(minDepth(testTreeNode))

}

fun minDepth(root: TreeNode?): Int {
    return when {
        root == null -> 0
        root.left == null && root.right == null -> 1
        root.left == null -> 1 + minDepth(root.right)
        root.right == null -> 1 + minDepth(root.left)
        else -> Math.min(1+minDepth(root.left), 1+minDepth(root.right))
    }
}

val testTreeNode = TreeNode(
    `val` = 3,
    left = TreeNode(
        `val` = 9,
        left = null,
        right = null
    ),
    right = TreeNode(
        `val` = 20,
        left = TreeNode(
            `val` = 15,
            left = null,
            right = null
        ),
        right = TreeNode(
            `val` = 7,
            left = null,
            right = null
        )
    )
)