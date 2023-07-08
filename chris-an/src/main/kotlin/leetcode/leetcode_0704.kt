package main.kotlin.leetcode

/**
 * Root Equals Sum of Children
 * https://leetcode.com/problems/root-equals-sum-of-children/
 */
class leetcode_0704 {
    fun checkTree(root: TreeNode?): Boolean {
        return root?.run {
            this.`val` == (this.right?.`val` ?: 0) + (this.left?.`val` ?: 0)
        } ?: false
    }
}

 class TreeNode(var `val`: Int) {
     var left: TreeNode? = null
     var right: TreeNode? = null
 }