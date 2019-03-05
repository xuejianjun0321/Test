package com.手撕算法.二叉树相关算法;



import java.util.*;

/**
 * @author xuejianjun<xuejianjun @ corp.netease.com>
 * @since 2019/03/05 15:02
 */
public class 二叉树的几种非递归遍历 {

    /** 前序遍历递归实现 */
    public void preOrderTraverse1(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + "  ");
            preOrderTraverse1(root.left);
            preOrderTraverse1(root.right);
        }
    }

    /** 中序遍历递归实现 */
    public void inOrderTraverse1(TreeNode root) {
        if (root != null) {
            preOrderTraverse1(root.left);
            System.out.print(root.val + "  ");
            preOrderTraverse1(root.right);
        }
    }

    /** 中序遍历递归实现 */
    public void postOrderTraverse1(TreeNode root) {
        if (root != null) {
            preOrderTraverse1(root.left);
            preOrderTraverse1(root.right);
            System.out.print(root.val + "  ");
        }
    }


    /** 层序遍历 */
    public void levelTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + "  ");
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    /** 前序遍历非递归实现 */
    public void preOrderTraverse2(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode pNode = root;
        while (pNode != null || !stack.isEmpty()) {
            if (pNode != null) {
                System.out.print(pNode.val + "  ");
                stack.push(pNode);
                pNode = pNode.left;
            } else { //pNode == null && !stack.isEmpty()
                TreeNode node = stack.pop();
                pNode = node.right;
            }
        }
    }

    /**
     * 非递归中序遍历二叉树
     *
     * @param root 二叉树根节点
     * @return 中序遍历结果集
     */
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.addFirst(root);
                root = root.left;
            }
            root = stack.removeFirst();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }

    /**
     * 二叉树的后序遍历
     *
     * @param root 二叉树根节点
     * @return 后序遍历结果集
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode pre = null;
        while (!stack.isEmpty() || root != null) {

            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.peek();
            // i ：判断如果右子树不为空且不为
            if (root.right != null && root.right != pre) {
                root = root.right;
            } else {
                root = stack.pop();
                list.add(root.val);
                pre = root;
                root = null;
            }
        }
        return list;
    }

}
