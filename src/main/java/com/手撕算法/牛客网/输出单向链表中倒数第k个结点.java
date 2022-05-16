package com.手撕算法.牛客网;
import java.util.Scanner;
/**
 * 描述
 * 输入一个单向链表，输出该链表中倒数第k个结点，链表的倒数第1个结点为链表的尾指针。
 *
 * 链表结点定义如下：
 * struct ListNode
 * {
 *     int m_nKey;
 *     ListNode* m_pNext;
 * };
 * 正常返回倒数第k个结点指针，异常返回空指针.
 * 要求：
 * (1)正序构建链表;
 * (2)构建后要忘记链表长度。
 * 数据范围：链表长度满足 1 \le n \le 1000 \1≤n≤1000  ， k \le n \k≤n  ，链表中数据满足 0 \le val \le 10000 \0≤val≤10000
 *
 * 本题有多组样例输入。
 */
public class 输出单向链表中倒数第k个结点 {

    /**
     * 构造单链表，使用头插法，解决问题；
     */
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int num = scan.nextInt();
            ListNode header = new ListNode();
            for (int i=0; i< num;i++) {
                int value = scan.nextInt();
                ListNode node = new ListNode(value, header.next);
                header.next = node;
            }
            int target = scan.nextInt();
            for (int i=0; i<target; i++) {
                header = header.next;
            }
            System.out.println(header.value);
        }

    }
}


class ListNode{
    int value;
    ListNode next;
    public ListNode(){

    }
    public ListNode(int value, ListNode next){
        this.value = value;
        this.next = next;
    }
}

