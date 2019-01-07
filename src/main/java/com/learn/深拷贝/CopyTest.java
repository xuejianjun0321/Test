package com.learn.深拷贝;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuejianjun<xuejianjun @ corp.netease.com>
 * @since 2019/01/04 15:07
 */
public class CopyTest {


    public static void main(String [] args){


        Teacher teacher1 = new Teacher();
        teacher1.setName("吴老师");
        teacher1.setAge(40);
        teacher1.setSex("男");

        try {
            Teacher teacher2 = ObjectSimpleConvertUtils.objSimpleConvert(teacher1,Teacher.class);
            System.out.println(JSON.toJSON(teacher2));
            System.out.println(teacher1.equals(teacher2));
        } catch (Exception e) {
            e.printStackTrace();
        }

        School schoolA = buildSchool();
        School schoolB = new School();

        BeanUtils.copyProperties(schoolA,schoolB);

        System.out.println(schoolA.equals(schoolB));
    }

    private static School buildSchool() {
        School chinSchool = new School();

        List<ClassRoom> classRoomList = new ArrayList<>();
        ClassRoom firstClassRoom = new ClassRoom();
        firstClassRoom.setLength(10);
        firstClassRoom.setWide(20);

        List<Student> studentList = new ArrayList<>();
        Student zhang = new Student();
        zhang.setName("张");
        zhang.setAge(20);
        zhang.setSex("男");
        studentList.add(zhang);
        Student liming = new Student();
        liming.setName("李敏");
        liming.setAge(20);
        liming.setSex("女");
        studentList.add(liming);
        firstClassRoom.setStudentList(studentList);

        Teacher teacher1 = new Teacher();
        teacher1.setName("吴老师");
        teacher1.setAge(40);
        teacher1.setSex("男");
        firstClassRoom.setTeacher(teacher1);
        classRoomList.add(firstClassRoom);

        ClassRoom sendClassRoom = new ClassRoom();
        sendClassRoom.setLength(10);
        sendClassRoom.setWide(20);

        List<Student> studentList2 = new ArrayList<>();
        Student xue = new Student();
        xue.setName("薛");
        xue.setAge(20);
        xue.setSex("男");
        studentList2.add(xue);
        Student liu = new Student();
        liu.setName("刘");
        liu.setAge(20);
        liu.setSex("女");
        studentList2.add(liu);
        sendClassRoom.setStudentList(studentList2);

        Teacher teacher2 = new Teacher();
        teacher2.setName("草老师");
        teacher2.setAge(40);
        teacher2.setSex("男");
        sendClassRoom.setTeacher(teacher2);
        classRoomList.add(sendClassRoom);

        Playground playground = new Playground();
        playground.setLength(10);
        playground.setWide(30);

        chinSchool.setClassRoomList(classRoomList);
        chinSchool.setPlayground(playground);

        return chinSchool;
    }


    static class School{
       private List<ClassRoom> classRoomList;

       private Playground playground;

        public List<ClassRoom> getClassRoomList() {
            return classRoomList;
        }

        public void setClassRoomList(List<ClassRoom> classRoomList) {
            this.classRoomList = classRoomList;
        }

        public Playground getPlayground() {
            return playground;
        }

        public void setPlayground(Playground playground) {
            this.playground = playground;
        }
    }

    //教室
    static class ClassRoom{

        //长
        private int length;

        //宽
        private int wide;

        private List<Student> studentList;

        private Teacher teacher;

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public int getWide() {
            return wide;
        }

        public void setWide(int wide) {
            this.wide = wide;
        }

        public List<Student> getStudentList() {
            return studentList;
        }

        public void setStudentList(List<Student> studentList) {
            this.studentList = studentList;
        }

        public Teacher getTeacher() {
            return teacher;
        }

        public void setTeacher(Teacher teacher) {
            this.teacher = teacher;
        }
    }

    //学生
    static class Student{
        //名字
        private String name;

        //年龄
        private int age;

        //性别
        private String sex;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }
    }

    //老师
    static class Teacher{

        //名字
        private String name;

        //年龄
        private int age;

        //性别
        private String sex;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }
    }

    //操场
    static class Playground{

        //长
        private int length;

        //宽
        private int wide;

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public int getWide() {
            return wide;
        }

        public void setWide(int wide) {
            this.wide = wide;
        }
    }
}
