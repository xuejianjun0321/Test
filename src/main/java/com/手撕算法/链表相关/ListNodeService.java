package com.手撕算法.链表相关;

import java.util.Vector;

/**
 * @author xuejianjun<xuejianjun @ corp.netease.com>
 * @since 2019/03/05 15:10
 */
public class ListNodeService {

    /**
     * 反转链表
     */
    public ListNode reverseList(ListNode head) {
        // 正确性判断
        if (null == head || null == head.nextNode) {
            return head;
        }
        ListNode pre = null;
        while (null != head) {
            ListNode temp = head;
            head = head.nextNode;
            temp.nextNode = pre;
            pre = temp;
        }
        return pre;
    }

    /** 合并两个有序链表 */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = null;
        if (l1.val < l2.val) {
            head = l1;
            head.nextNode = mergeTwoLists(l1.nextNode, l2);
        } else {
            head = l2;
            head.nextNode = mergeTwoLists(l1, l2.nextNode);
        }
        return head;
    }

    /**
     * 求两个链表中第一个公共结点
     *
     * @param pHead1 链表1头结点
     * @param pHead2 链表2头结点
     * @return 链表第一个公共结点
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        // 1.正确性判断
        if (null == pHead1 || null == pHead2) {
            return null;
        }

        // 2.遍历链表1把所有结点保存在列表中中
        Vector<ListNode> nodeList1 = new Vector<>();
        while (null != pHead1) {
            nodeList1.add(pHead1);
            pHead1 = pHead1.nextNode;
            // 判断是否成环，成环则退出循环
            if (nodeList1.contains(pHead1)) {
                break;
            }
        }   // end while：链表1中的所有结点都存入了nodeList1中

        // 3.遍历链表2比较列表中的数据
        Vector<ListNode> nodeList2 = new Vector<>();
        while (null != pHead2) {
            // 先判断nodeList1中是否存在相同结点，存在则返回
            if (nodeList1.contains(pHead2)) {
                return pHead2;
            }
            // 如果不存在则继续遍历，并判断是否成环
            nodeList2.add(pHead2);
            pHead2 = pHead2.nextNode;
            if (nodeList2.contains(pHead2)) {
                break;
            }
        }   // end while：遍历完了链表2并将所有结点保存在了nodeList2中

        // 如果遍历完链表2则返回null
        return null;
    }


    /**
     * 1、你有两个用链表代表的整数，其中每个节点包含一个数字。数字存储按照在原来整数中相反的顺序，使得第一个数字位于链表的开头。写出一个函数将两个整数相加，用链表形式返回和。
     *
     * 给出两个链表 3->1->5->null 和 5->9->2->null，返回 8->0->8->null
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addLists(ListNode l1, ListNode l2) {
        // write your code here
        ListNode dummy = new ListNode(-1);
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode p = dummy;
        int flag = 0;
        while (p1 != null || p2 != null) {
            int temp = flag;
            if (p1 != null) {
                temp += p1.val;
                p1 = p1.nextNode;
            }
            if (p2 != null) {
                temp += p2.val;
                p2 = p2.nextNode;
            }
            if (temp > 9) {
                temp -= 10;
                flag = 1;
            } else {
                flag = 0;
            }
            p.nextNode = new ListNode(temp);
            p = p.nextNode;
        }
        if (flag == 1) {
            p.nextNode = new ListNode(1);
        }
        return dummy.nextNode;
    }

    /**
     * 2、假定用一个链表表示两个数，其中每个节点仅包含一个数字。假设这两个数的数字顺序排列，请设计一种方法将两个数相加，并将其结果表现为链表的形式。
     *
     * 给出 6->1->7 + 2->9->5。即，617 + 295。
     *
     * 返回 9->1->2。即，912 。
     *
     * 思路：翻转之后转化成上面的问题，然后计算结果，然后在翻转一次就行了
     *
     *
     * ---------------------
     * 作者：哎呦、不错哦
     * 来源：CSDN
     * 原文：https://blog.csdn.net/l1394049664/article/details/81350125
     * 版权声明：本文为博主原创文章，转载请附上博文链接！
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addLists2(ListNode l1, ListNode l2) {
        // write your code here
        ListNode l11 = reverse(l1);
        ListNode l22 = reverse(l2);
        ListNode p1 = l11;
        ListNode p2 = l22;
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        int flag = 0;
        while (p1 != null || p2 != null) {
            int temp = flag;
            if (p1 != null) {
                temp += p1.val;
                p1 = p1.nextNode;
            }
            if (p2 != null){
                temp += p2.val;
                p2 = p2.nextNode;
            }
            if (temp > 9) {
                temp -= 10;
                flag = 1;
            } else {
                flag = 0;
            }
            ListNode node = new ListNode(temp);
            p.nextNode = node;
            p = p.nextNode;
        }
        if (flag == 1) {
            ListNode node = new ListNode(1);
            p.nextNode = node;
        }
        return reverse(dummy.nextNode);
    }

    public ListNode reverse (ListNode head) {
        ListNode newhead = null;
        while (head != null) {
            ListNode temp = head.nextNode;
            head.nextNode = newhead;
            newhead = head;
            head = temp;
        }
        return newhead;
    }

}
