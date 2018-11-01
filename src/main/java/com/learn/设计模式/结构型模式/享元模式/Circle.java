package com.learn.设计模式.结构型模式.享元模式;

/**
 * @author xuejianjun<xuejianjun@corp.netease.com>
 * @since 2018/11/01 4:29 PM
 */
public class Circle implements Shapre {

    private String color;

    private int x;

    private int y;

    private int radius;

    public Circle(String color){
        this.color = color;
    }

    @Override
    public void draw() {
        System.out.println("Circle: Draw() [Color:" + color +",x:" + x +",Y:"+y+",radius"+radius);
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}
