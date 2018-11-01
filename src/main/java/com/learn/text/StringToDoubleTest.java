package com.learn.text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringToDoubleTest {

    public static void main(String[] args) {

        Integer str = null;

        if (str ==1){
            System.out.print("ture");
        }




    }

    public static boolean isNumeric(String str){
        Pattern pattern = Pattern.compile("^\\d+(\\.\\d+)?$");
        Matcher isNum = pattern.matcher(str);
        if( !isNum.matches() ){
            return false;
        }
        return true;
    }


}
