package com.aop.Log;



import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/index")
public class TestController {


    @RestController
    @RequestMapping(value = "/index")
    public class IndexController {

        @SysLog(requestUrl = "/index请求")
        @RequestMapping(method = RequestMethod.GET)
        public String index() {
            return "index";
        }
    }
}
