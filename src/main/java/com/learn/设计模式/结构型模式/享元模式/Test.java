package com.learn.设计模式.结构型模式.享元模式;

/**
 * @author xuejianjun<xuejianjun@corp.netease.com>
 * @since 2018/11/01 4:37 PM
 */
public class Test {

    private static final String  colors[] ={"read","green","blue","black","white"};

    public static void main(String [] args){
        for (int i=0;i<20;i++){
            Circle circle = (Circle) ShapeFactory.getCircle(getRandomColor());
            circle.setX(getRandomX());
            circle.setY(getRandomY());
            circle.setRadius(100);
            circle.draw();
        }
    }

    private static String getRandomColor(){
        return colors[(int)(Math.random() * colors.length)];
    }

    private static int getRandomX(){
        return (int)(Math.random() *100);
    }

    private static int getRandomY(){
        return (int)(Math.random() * 100);
    }

}
