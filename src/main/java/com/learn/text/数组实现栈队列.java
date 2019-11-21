package com.learn.text;

/**
 * @author xuejianjun<xuejianjun @ corp.netease.com>
 * @since 2019/11/21 16:13
 */
public class 数组实现栈队列 {

    /**
     * 数组实现栈
     */
     class ArrayStack{

        private Integer [] arr;

        private Integer size;

        //构造函数：根据给定的size初始化栈
        public ArrayStack(int initSize){
            if (initSize<0){
                throw new RuntimeException("初始化不能小于0");
            }

            arr = new  Integer[initSize];
            size = 0;
        }

        //查看栈顶元素但不移除
        public Integer peek(){
            if (size == 0){
                return null;
            }
            return arr[size-1];
        }

        //进栈
        public void push(int obj){

            if (size == arr.length){
                throw new  RuntimeException("栈已满");
            }
            arr[size++] = obj;
        }

        //出栈
        public Integer pop(){
            if (size == 0){
                throw new RuntimeException("此栈已空");
            }
            return arr[--size];
        }


    }


    /**
     * 数组实现队列
     */
     class ArrayQueue{

        private Integer[] arr;
        private Integer size;
        private Integer first;
        private Integer last;

        //初始化队列
        public ArrayQueue(int initSize){
            if (initSize<0){
                throw new RuntimeException("初始化队列大小不能小于0");
            }
            arr = new Integer[initSize];
            size = 0;
            first = 0;
            last = 0;
        }

        //返回队首元素，但不删除
        public Integer peek(){
            if (size == 0){
                return null;
            }
            return arr[first];
        }

        //入队
        public void push(int obj){
            if (size == arr.length){
                throw new RuntimeException("此队列已满");
            }
            size ++ ;
            arr[last] = obj;
            last = last == arr.length -1 ? 0 : last +1;
        }

        //出队
        public Integer poll(){
            if (size ==0){
                throw new  RuntimeException("队列已空");
            }

            size --;
            int tmp = first;
            first = first == arr.length-1 ?0 : first +1;
            return arr[tmp];
        }

        public Integer queueLength(){
            return last - first;
        }

    }


}
