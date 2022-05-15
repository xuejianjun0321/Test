package com.手写框架.spring.mvcframework.demo;

/**
 * @Description
 * @ClassName DemoService
 * @Author jinling
 * @date 2020.07.28 15:17
 */

import com.手写框架.spring.mvcframework.annotation.GPService;

/**
 * 核心业务逻辑
 */
@GPService
public class DemoService implements IDemoService{

  @Override
  public String get(String name) {
    return "My name is " + name;
  }

}
