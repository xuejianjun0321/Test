package com.手撕算法.牛客网;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;
/**
 * 开发一个简单错误记录功能小模块，能够记录出错的代码所在的文件名称和行号。
 *
 *
 * 处理：
 *
 *
 * 1、 记录最多8条错误记录，循环记录，最后只用输出最后出现的八条错误记录。对相同的错误记录只记录一条，但是错误计数增加。最后一个斜杠后面的带后缀名的部分（保留最后16位）和行号完全匹配的记录才做算是“相同”的错误记录。
 * 2、 超过16个字符的文件名称，只记录文件的最后有效16个字符；
 * 3、 输入的文件可能带路径，记录文件名称不能带路径。也就是说，哪怕不同路径下的文件，如果它们的名字的后16个字符相同，也被视为相同的错误记录
 * 4、循环记录时，只以第一次出现的顺序为准，后面重复的不会更新它的出现时间，仍以第一次为准
 *
 * 数据范围：错误记录数量满足 1 \le n \le 100 \1≤n≤100  ，每条记录长度满足 1 \le len \le 100 \1≤len≤100
 */
public class 简单错误记录 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> map = new LinkedHashMap<String, Integer>();
        while (sc.hasNext()) {
            String str = sc.next();
            int LineNum = sc.nextInt();
            String[] split = str.split("\\\\");  //根据\分割
            String FileName = split[split.length - 1];
            //只保留最后16位
            if (FileName.length() > 16)
                FileName = FileName.substring(FileName.length() - 16);
            String key = FileName + " " + LineNum;
            //放入到HashMap中
            int Number = 1;
            if(map.containsKey(key))
                map.put(key, map.get(key)+1);
            else {
                map.put(key, Number);
            }
        }
        int count = 0;
        for(String string:map.keySet()){
            count++;
            if(count>(map.keySet().size()-8)) //输出最后八个记录
                System.out.println(string+" "+map.get(string));
        }
    }

}
