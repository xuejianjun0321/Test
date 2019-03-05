package com.手撕算法.链表相关;

/**
 * @author xuejianjun<xuejianjun @ corp.netease.com>
 * @since 2019/03/05 15:11
 */
public class ListNode {

    int val;
    ListNode nextNode;
    ListNode(int val){
        this.val=val;
        this.nextNode=null;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(ListNode nextNode) {
        this.nextNode = nextNode;
    }
}
