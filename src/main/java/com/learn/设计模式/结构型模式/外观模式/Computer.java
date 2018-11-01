package com.learn.设计模式.结构型模式.外观模式;

/**
 * @author xuejianjun<xuejianjun@corp.netease.com>
 * @since 2018/10/31 4:39 PM
 */
public class Computer {

    private CPU cpu;

    private Memory memory;

    private Disk disk;

    public Computer(){
        cpu = new CPU();
        memory = new Memory();
        disk = new Disk();
    }

    public void startup(){
        System.out.println("start the computer!");
        cpu.startUp();
        memory.startUp();
        disk.startup();
    }

    public void shutdown(){
        System.out.println("shutdown the computer!");
        cpu.shutdown();
        memory.shutdown();
        disk.shutdown();
    }

}
