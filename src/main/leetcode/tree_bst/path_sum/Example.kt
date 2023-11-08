package leetcode.tree_bst.path_sum

import java.util.*

/**
 * recursive
 */
fun hasPathSum2(root: TreeNode?, targetSum: Int): Boolean {
    if (root == null) return false

    if(root.left == null && root.right == null) {
        // leafノードまで辿り着いたら、targetSum（leafノードより上位のノードまでの値が引かれている）と比較
        return root.`val` == targetSum
    }

    // どこかのleafでtrueが返って来たら連鎖でtrueになる仕組み
    return hasPathSum2(root.left, targetSum - root.`val`)
            || hasPathSum2(root.right, targetSum - root.`val`)
}

/**
 * iterative
 */
fun hasPathSum3(root: TreeNode?, targetSum: Int): Boolean {
    if (root == null) return false

    // TreeNodeと、そのノードまでの合計値
    val q = LinkedList<Pair<TreeNode, Int>>()

    // rootノードを追加
    q.add(Pair(root, root.`val`))

    while (q.isNotEmpty()) {
        // 各ノードについて、そのノードまでの合計値を渡して、targetSumになっているか見ていく
        val currentNode = q.poll().first
        val currentSum = q.poll().second

        // leafノード、かつ和 == targetSumであればtrue
        if (currentNode.left == null && currentNode.right == null
            && currentSum == targetSum) return true

        // 次の子ノードについて調べる
        currentNode.left?.let {
            q.add(Pair(currentNode, currentSum + it.`val`))
        }
        currentNode.right?.let {
            q.add(Pair(currentNode, currentSum + it.`val`))
        }
    }

    return false
}