package com.手撕算法.牛客网.字符串;
import java.util.*;
/**
 * •输入一个字符串，请按长度为8拆分每个输入字符串并进行输出；
 *
 * •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 */
public class 字符串分隔 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){
            String str = sc.nextLine();
            StringBuilder sb = new StringBuilder();//牢记字符串缓冲区的建立语法
            sb.append(str);//字符串缓冲区的加入
            int size = str.length();
            int addZero = 8 - size%8;//addzero的可能值包括8
            while((addZero > 0)&&(addZero<8)){//注意边界调节，避免addzero=8
                sb.append("0");//使用‘’或“”都可
                addZero--;
            }
            String str1 = sb.toString();
            while(str1.length()>0){
                System.out.println(str1.substring(0,8));
                str1 = str1.substring(8);
            }

        }
    }

}
