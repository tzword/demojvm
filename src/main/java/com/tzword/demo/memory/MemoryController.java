package com.tzword.demo.memory;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@Slf4j
@RequestMapping(value = "/memory")
public class MemoryController {

    private List<User> userList = new ArrayList<>();
    private List<Class<?>> classList = new ArrayList<>();
    
    /** 
     * @Description: -Xmx32M -Xms32M 
     * @Param: [] 
     * @return: java.lang.String 
     * @Author: jianghy 
     * @Date: 2020/2/6
     * @Time: 11:15       
     */
    @GetMapping("/heap")
    public String heap(){
        int i = 0;
        while (true){
           User user = new User(i++, UUID.randomUUID().toString());
           log.info(user.toString());
           userList.add(user);
        }
    }

    /** 
     * @Description: -XX:MetaspaceSize=32M -XX:MaxMetaspaceSize=32M 
     * @Param: [] 
     * @return: java.lang.String 
     * @Author: jianghy 
     * @Date: 2020/2/6
     * @Time: 11:15       
     */
    @GetMapping("/noheap")
    public String noheap(){
        int i = 0;
        while (true){
            classList.addAll(Metaspace.createClasses());
        }
    }
}
