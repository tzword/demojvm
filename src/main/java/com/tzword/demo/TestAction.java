package com.tzword.demo;

import com.tzword.demo.memory.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping(value = "/aaa")
public class TestAction {
    @GetMapping("/bbb")
    public String HelloJvm(@RequestParam(value = "param1") String param1){
        log.info("你好，jvm");
        return "hello "+ param1;
    }

    /** 
     * @Description: 构造函数方法测试
     * @Param: [user] 
     * @return: com.tzword.demo.memory.User 
     * @Author: jianghy 
     * @Date: 2020/2/9
     * @Time: 17:00
     */
    @GetMapping("/contructor1")
    public User contructor1(User user){
        log.info("进入构造方法");
        return user;
    }


    /**
     * @Description: 相同的方法名（1个参数）
     * @Param: [name, id]
     * @return: java.lang.String
     * @Author: jianghy
     * @Date: 2020/2/9
     * @Time: 21:49
     */
    @GetMapping("/same1")
    public String same(@RequestParam("name") String name){
        log.info("same1");
        return "name: "+name;
    }

    /**
     * @Description: 相同的方法名（2个参数）
     * @Param: [name, id]
     * @return: java.lang.String
     * @Author: jianghy
     * @Date: 2020/2/9
     * @Time: 21:49
     */
    @GetMapping("/same2")
    public String same(@RequestParam("name") String name,@RequestParam("id") int id){
        log.info("same2");
        return "name: "+name+";id: "+id;
    }
}
