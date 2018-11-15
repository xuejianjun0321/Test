package com.learn.反射.反射基础;

/**
 * @author xuejianjun<xuejianjun@corp.netease.com>
 * @since 2018/11/05 3:46 PM
 */
public class ExamleObject extends FatherObject {

    public int age = 30;

    public String name ="byhige";

    private Integer score  = 60;

    public ExamleObject(String name){
        this.name = name;
    }

    public ExamleObject(){

    }

    public ExamleObject(int age,Integer score){

    }

    @Override
    public void doSomething(){
        super.doSomething();
    }


    public void printName(){
        System.out.println(name);
    }




    @Override
    public void run() {
        System.out.println("run。。。。");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
