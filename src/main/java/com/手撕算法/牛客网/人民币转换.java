package com.手撕算法.牛客网;
import java.util.Scanner;
/**
 * 考试题目和要点：
 *
 * 1、中文大写金额数字前应标明“人民币”字样。中文大写金额数字应用壹、贰、叁、肆、伍、陆、柒、捌、玖、拾、佰、仟、万、亿、元、角、分、零、整等字样填写。
 *
 * 2、中文大写金额数字到“元”为止的，在“元”之后，应写“整字，如532.00应写成“人民币伍佰叁拾贰元整”。在”角“和”分“后面不写”整字。
 *
 * 3、阿拉伯数字中间有“0”时，中文大写要写“零”字，阿拉伯数字中间连续有几个“0”时，中文大写金额中间只写一个“零”字，如6007.14，应写成“人民币陆仟零柒元壹角肆分“。
 * 4、10应写作“拾”，100应写作“壹佰”。例如，1010.00应写作“人民币壹仟零拾元整”，110.00应写作“人民币壹佰拾元整”
 * 5、十万以上的数字接千不用加“零”，例如，30105000.00应写作“人民币叁仟零拾万伍仟元整”
 */
public class 人民币转换 {
    public static String[] ten = {"零","壹","贰","叁","肆","伍","陆","柒","捌","玖"};
    public static String[] power = {"万","亿"};
    public static String[] daiwei = {"元","角","分","整"};
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String[] s = in.nextLine().split("\\.");//分割为整数部分和小数部分
            if(s[1].equals("00")){
                System.out.println("人民币" + solveZheng(Double.parseDouble(s[0])) + "元整");
            }else if(s[0].equals("0")){
                System.out.println("人民币" + solveXiao(s[1]));
            }else{
                System.out.println("人民币" + solveZheng(Double.parseDouble(s[0])) + "元" + solveXiao(s[1]));
            }
        }
    }
    public static String solveXiao(String s2){
        StringBuilder sb = new StringBuilder();
        int jiao = Integer.parseInt(s2.substring(0,1));
        int fen = Integer.parseInt(s2.substring(1,2));
        if(jiao!=0){
            sb.append(ten[jiao]);
            sb.append("角");
        }
        if(fen!=0){
            sb.append(ten[fen]);
            sb.append("分");
        }
        return sb.toString();
    }
    public static String solveZheng(double zheng){
        StringBuilder sb = new StringBuilder();
        int pow = 0;
        while((int)zheng != 0){
            if(pow!=0){
                sb.append(power[pow-1]);
            }
            int temp = (int)(zheng % 10000);
            //个位
            int gewei = temp % 10;
            int shiwei = (temp / 10) % 10;
            int baiwei = (temp/100) % 10;
            int qianwei = (temp/1000) % 10;
            if(gewei!=0){
                sb.append(ten[gewei]);
            }
            //十位
            if(shiwei!=0){
                sb.append("拾");
                if(shiwei!=1){
                    sb.append(ten[shiwei]);
                }
            }else{
                if(gewei != 0 && (temp>99 || (int)zheng > 10000)){
                    sb.append(ten[0]);
                }
            }
            //百位
            if(baiwei!=0){
                sb.append("佰");
                sb.append(ten[baiwei]);
            }else{
                if(shiwei != 0 && (temp>999 || (int)zheng > 10000)){
                    sb.append(ten[0]);
                }
            }
            if(qianwei!=0){
                sb.append("仟");
                sb.append(ten[qianwei]);
            }else{
                if(baiwei != 0 && (int)zheng > 10000){
                    sb.append(ten[0]);//
                }
            }
            zheng /= 10000;
            pow++;
            if(pow>2){
                pow=1;
            }
        }
        return sb.reverse().toString();
    }
}
