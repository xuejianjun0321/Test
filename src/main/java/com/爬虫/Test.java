package com.爬虫;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * @author xuejianjun<xuejianjun@corp.netease.com>
 * @since 2018/11/30 11:39 AM
 */
public class Test {

    public static void main(String[] args){
            //获取编辑推荐页
            Document document= null;
            try {
                document = Jsoup.connect("https://www.zhihu.com/explore/recommendations")
                        //模拟火狐浏览器
                        .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.110 Safari/537.36")
                        .get();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Element elmain=document.getElementById("zh-recommend-list-full");
            Elements url=elmain.select("div").select("div:nth-child(2)")
                    .select("h2").select("a[class=question_link]");
            for(Element question:url){
                //输出href后的值，即主页上每个关注问题的链接
                String URL=question.attr("abs:href");
                //下载问题链接指向的页面
                Document document2= null;
                try {
                    document2 = Jsoup.connect(URL)
                            .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.110 Safari/537.36")
                            .get();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //问题
                Elements title= document2.select("h1.QuestionHeader-title");

                //问题描述
                Elements detail= document2.select("div.QuestionHeader-detail").select("span").select("a");

                //回答
                Elements answer= document2.select(".RichContent-inner");

                System.out.println("\n"+"链接："+URL
                        +"\n"+"标题："+title.text()
                        +"\n"+"问题描述："+detail.text()
                        +"\n"+"回答："+answer.text());
            }
        }

}
