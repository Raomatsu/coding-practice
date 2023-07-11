package leetcode.tree_bst.maimum_depth_of_binary_tree

fun main() {

}

fun maxDepthExample(root: TreeNode?): Int {
    if (root == null) return 0

    // 再帰を使う。
    // TreeNode==nullとなる = 終端が来るまで掘る。終端が来たら値が返って来る。
    // 「左右どっちもnull」のTreeNodeが（引数として渡されたmaxDepthが）1を返す。
    return Math.max(1 + maxDepthExample(root.left), 1 + maxDepthExample(root.right))
}