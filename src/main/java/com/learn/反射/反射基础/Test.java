package com.learn.反射.反射基础;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author xuejianjun<xuejianjun@corp.netease.com>
 * @since 2018/11/05 3:51 PM
 */
public class Test {

    public static void main(String[] args) {

        try {
            System.out.println("-----------------------反射获取类--------------------");

            Class examleObjectClass = ExamleObject.class;
            System.out.println(examleObjectClass);
            System.out.println();

            /** 获取类名 */
            //类的名字有两种方式得到，一种是getName()，一种是getSimpleName()。第一种得到的是全限定名，第二种得到的是这个类的名字，不带包名
            System.out.println("getName获取类名:" + examleObjectClass.getName());

            Class examleObjectClass2 = Class.forName("com.learn.反射.反射基础.ExamleObject");
            System.out.println();
            System.out.println(examleObjectClass2);
            System.out.println("getSimpleName获取类名：" + examleObjectClass2.getSimpleName());

            /** 得到类的包名，父类和实现的接口  */
            Package packageInfo = examleObjectClass.getPackage();
            System.out.println("包信息"+packageInfo);
            System.out.println();

            Class superClass = examleObjectClass.getSuperclass();
            System.out.println("父类为："+superClass);
            System.out.println();


            /** 获取构造器 */
            Constructor[] constructors = examleObjectClass.getConstructors();
            for (Constructor constructor : constructors){
                System.out.println("构造器为："+ constructor);
            }

            System.out.println();

            Constructor[] constructors2 = examleObjectClass.getConstructors();
            for (Constructor constructor : constructors2){
                Class[] parameterTypes = constructor.getParameterTypes();
                System.out.println("构造器参数如下========================");
                for (Class clz : parameterTypes){
                    System.out.println("参数类型 " + clz.toString());
                }
            }

            System.out.println();

            /** 变量 */
            Field[] fields = examleObjectClass.getFields();
            for (Field field1 : fields ){
                System.out.println("变量为：" + field1);
            }

            Constructor constructor = examleObjectClass.getConstructor(String.class);
            //设置变量
            ExamleObject object = (ExamleObject) constructor.newInstance("byhige");
            System.out.println("最初变量为：" + object.age);
            Field age = examleObjectClass.getField("age");
            age.set(object,80);
            System.out.println("设置后的变量为："+ object.age);


            /** 方法 */
            Method[] methods = examleObjectClass.getMethods();
            for (Method method : methods){
                System.out.println("方法为:"+method);
            }

            System.out.println();
            Method method = examleObjectClass.getMethod("setAge",int.class);
            System.out.println("方法为:"+method);

            /** 执行方法 */
            method.invoke(object,2);
            System.out.println("执行方法后："+object.age);
            object.run();
            object.doSomething();


            //test
            Class testCal = ExamleObject.class;
            Object examleObject = testCal.newInstance();
            Method testM = testCal.getMethod("run");
            testM.invoke(examleObject);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
