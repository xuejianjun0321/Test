package com.手撕算法.二叉树相关算法;

/**
 * https://www.cnblogs.com/edisonchou/p/4774626.html
 * @author xuejianjun<xuejianjun @ corp.netease.com>
 * @since 2019/03/06 09:44
 */
public class 二叉树的镜像 {

    public static void SetMirrorRecursively(TreeNode root)
    {
        if (root == null || (root.left == null && root.right == null))
        {
            return;
        }

        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;

        if (root.left != null)
        {
            // 递归调整左子树为镜像
            SetMirrorRecursively(root.left);
        }

        if (root.right != null)
        {
            // 递归调整右子树为镜像
            SetMirrorRecursively(root.right);
        }
    }

}
