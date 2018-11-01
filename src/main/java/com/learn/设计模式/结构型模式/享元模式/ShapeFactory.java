package com.learn.设计模式.结构型模式.享元模式;

import java.util.HashMap;

/**
 * @author xuejianjun<xuejianjun@corp.netease.com>
 * @since 2018/11/01 4:32 PM
 */
public class ShapeFactory {

    private static final HashMap<String,Shapre> circleMap = new HashMap<>();

    public static Shapre getCircle(String color){
        Circle circle = (Circle) circleMap.get(color);
        if (circle ==null){
            circle = new Circle(color);
            circleMap.put(color,circle);
            System.out.println("Creating circle of color :" + color);
        }

        return circle;
    }

}
