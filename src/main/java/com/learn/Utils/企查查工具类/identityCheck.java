package com.learn.Utils.企查查工具类;




import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

import java.util.Date;

public class identityCheck {
    public static boolean identityCheck(String token,String timeStamp){
        System.out.println("-----------------开始调用--------------->");
        System.out.println("token"+token);
        String key = "6ce70dfb92ba47ee808637586165433b";
        String keyword = "654021050001177";
        //企业关键字模糊查询
        String url = "http://api.qichacha.com/ECIV4/GetDetailsByName?key=" + key + "&keyword=" + keyword;
        //企业关键字获取详细信息
        // http://api.qichacha.com/ECIV4/GetDetailsByName?key=AppKey&keyword=北京小桔科技有限公司
        System.out.println("请求url:" + url);
        boolean match = false; //是否匹配
        try {
            String result = HttpClientUtil.doGet(url,token,timeStamp);
            System.out.println("请求结果：" + result);

            // parse status from json
            System.out.println( FormartJson(result, "Status"));
            JSONObject obj= JSON.parseObject(result);
            JSONObject Srt = (JSONObject)obj.get("Result");
            System.out.println("+++++" + Srt.get("Industry"));

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("<-----------------调用结束---------------");
        return match;
    }

    public static void main(String[] args) throws Exception{
        String key = "6ce70dfb92ba47ee808637586165433b";
        int secondTimestamp = getSecondTimestamp(new Date()); //精确到秒的时间戳
        String secretKey ="7E6E5DEC3C33C1402DFA145A156A969F"; //密钥
        String token = MD5Util.MD5(key+secondTimestamp+secretKey); //token:验证加密值（key+Timespan+SecretKey组成的32位md5加密的大写字符串）
        System.out.println(token);
        identityCheck(token,secondTimestamp+"");

    }

    /**
     * 获取精确到秒的时间戳
     * @return
     */
    public static int getSecondTimestamp(Date date){
        if (null == date) {
            return 0;
        }
        String timestamp = String.valueOf(date.getTime());
        int length = timestamp.length();
        if (length > 3) {
            return Integer.valueOf(timestamp.substring(0,length-3));
        } else {
            return 0;
        }
    }

    // 解析JSON
    protected static String FormartJson(String jsonString, String key) throws JSONException {

        JSONObject obj= JSON.parseObject(jsonString);
        return (String) obj.get(key);
    }


}
