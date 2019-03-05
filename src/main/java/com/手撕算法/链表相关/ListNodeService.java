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

}
