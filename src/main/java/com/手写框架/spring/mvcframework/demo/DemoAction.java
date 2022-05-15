package com.手写框架.spring.mvcframework.demo;

import com.手写框架.spring.mvcframework.annotation.GPAutowired;
import com.手写框架.spring.mvcframework.annotation.GPController;
import com.手写框架.spring.mvcframework.annotation.GPRequestMapping;
import com.手写框架.spring.mvcframework.annotation.GPRequestParam;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description
 * @ClassName DemoAction
 * @Author jinling
 * @date 2020.07.28 15:16
 */
//虽然，用法一样，但是没有功能
@GPController
@GPRequestMapping("/demo")
public class DemoAction {

  @GPAutowired
  private IDemoService demoService;

  @GPRequestMapping("/query.*")
  public void query(HttpServletRequest req, HttpServletResponse resp,
      @GPRequestParam("name") String name){
//		String result = demoService.get(name);
    String result = "My name is " + name;
    try {
      resp.getWriter().write(result);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @GPRequestMapping("/add")
  public void add(HttpServletRequest req, HttpServletResponse resp,
      @GPRequestParam("a") Integer a, @GPRequestParam("b") Integer b){
    try {
      resp.getWriter().write(a + "+" + b + "=" + (a + b));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @GPRequestMapping("/sub")
  public void add(HttpServletRequest req, HttpServletResponse resp,
      @GPRequestParam("a") Double a, @GPRequestParam("b") Double b){
    try {
      resp.getWriter().write(a + "-" + b + "=" + (a - b));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @GPRequestMapping("/remove")
  public String  remove(@GPRequestParam("id") Integer id){
    return "" + id;
  }

}
