package com.learn.设计模式.行为型模式.迭代子模式;

/**
 * 一是需要遍历的对象，即聚集对象，二是迭代器对象，用于对聚集对象进行遍历访问
 * @author xuejianjun<xuejianjun@corp.netease.com>
 * @since 2018/10/31 8:17 PM
 */
public class Test {

    public static void main(String[] args){
        Collection collection = new MyCollection();
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

}
