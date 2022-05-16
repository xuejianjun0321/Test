package com.手撕算法.牛客网;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Scanner;
/**
 * 有6条配置命令，它们执行的结果分别是：
 *
 * 命   令	执   行
 * reset	reset what
 * reset board	board fault
 * board add	where to add
 * board delete	no board at all
 * reboot backplane	impossible
 * backplane abort	install first
 * he he	unknown command
 * 注意：he he不是命令。
 *
 * 为了简化输入，方便用户，以“最短唯一匹配原则”匹配（注：需从首字母开始进行匹配）：
 *
 * 1、若只输入一字串，则只匹配一个关键字的命令行。例如输入：r，根据该规则，匹配命令reset，执行结果为：reset what；输入：res，根据该规则，匹配命令reset，执行结果为：reset what；
 * 2、若只输入一字串，但匹配命令有两个关键字，则匹配失败。例如输入：reb，可以找到命令reboot backpalne，但是该命令有两个关键词，所有匹配失败，执行结果为：unknown command
 *
 * 3、若输入两字串，则先匹配第一关键字，如果有匹配，继续匹配第二关键字，如果仍不唯一，匹配失败。
 * 例如输入：r b，找到匹配命令reset board 和 reboot backplane，执行结果为：unknown command。
 * 例如输入：b a，无法确定是命令board add还是backplane abort，匹配失败。
 * 4、若输入两字串，则先匹配第一关键字，如果有匹配，继续匹配第二关键字，如果唯一，匹配成功。例如输入：bo a，确定是命令board add，匹配成功。
 * 5、若输入两字串，第一关键字匹配成功，则匹配第二关键字，若无匹配，失败。例如输入：b addr，无法匹配到相应的命令，所以执行结果为：unknow command。
 * 6、若匹配失败，打印“unknown command”
 *
 * 注意：有多组输入。
 * 数据范围：数据组数：1\le t\le 800\1≤t≤800 ，字符串长度1\le s\le 20\1≤s≤20
 * 进阶：时间复杂度：O(n)\O(n) ，空间复杂度：O(n)\O(n)
 */
public class 配置文件恢复 {

    /**
     * 本题是关于字符串匹配的题。
     * 先用哈希表将命令都存起来，然后再建立一个包含所有命令的字符串数组类型的哈希视图。然后用输入的字符串数组与该视图的每一个元素去匹配比较。
     */
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        Map<String,String> command=new HashMap<String,String>();//建立命令哈希表
        //向哈希表里添加命令键值对
        command.put("reset","reset what");
        command.put("reset board","board fault");
        command.put("board add","where to add");
        command.put("reboot backplane","impossible");
        command.put("backplane abort","install first");
        command.put("board delet","no board at all");
        Set<String[]> order=new HashSet<String[]>();//建立哈希命令视图
        //遍历哈希表的set视图,向哈希命令表里添加命令
        for(String s:command.keySet())
        {
            order.add(s.split(" "));
        }
        while(sc.hasNextLine())
        {
            String input=sc.nextLine();
            String[] inputChange=input.split(" ");//将输入字符串用空格分隔，以便比较
            String[] compitable=null;//匹配的命令字符串
            //开始遍历命令视图
            for(String[] cmpOrder:order)
            {
                //输入字符串数组长度为一
                if(inputChange.length==1)
                {
                    //命令字符串数组长度为二，不匹配
                    if(cmpOrder.length==2)
                        continue;
                    else
                    {
                        //匹配成功
                        if(cmpOrder[0].startsWith(inputChange[0]))
                        {
                            compitable=cmpOrder;
                            break;
                        }
                    }
                }
                //输入字符串数组长度为二的情况
                if(inputChange.length==2)
                {
                    //如果待比较命令字符串长度为1，不匹配
                    if(cmpOrder.length==1)
                        continue;
                    else
                        //如果输入命令字符串与待比较命令字符串一一匹配，匹配成功
                        if(cmpOrder[0].startsWith(inputChange[0]))
                            if(cmpOrder[1].startsWith(inputChange[1]))
                            {
                                compitable=cmpOrder;
                                break;
                            }
                }
            }
            //从哈希表中找出命令的执行结果并输出
            if(compitable==null)
                System.out.println("unkown command");
            else if(compitable.length==1)
                System.out.println(command.get(compitable[0]));
            else
                System.out.println(command.get(compitable[0]+" "+compitable[1]));
        }
        sc.close();
    }
}
