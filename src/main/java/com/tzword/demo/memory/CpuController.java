package com.tzword.demo.memory;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping(value = "/cpu")
public class CpuController {
    
    /** 
     * @Description: 模拟死循环
     * @Param: [] 
     * @return: java.lang.String 
     * @Author: jianghy 
     * @Date: 2020/2/7
     * @Time: 15:58       
     */
    @GetMapping("/deadLoop")
    public String deadLoop(){
        while (true){
            log.info("死循环了吗");
        }
    }


    private Object lock1 = new Object();
    private Object lock2 = new Object();

    /**
     * @Description: 模拟死锁
     * @Param: []
     * @return: java.lang.String
     * @Author: jianghy
     * @Date: 2020/2/7
     * @Time: 16:10
     */
    @GetMapping("/deadLock")
    public String deadLock(){
         new Thread(()->{
             synchronized (lock1){
                 try {
                    Thread.sleep(1000);
                 }catch (Exception e){
                    e.printStackTrace();
                 }
                 synchronized (lock2){
                     log.info("Thread1 over");
                 }
             }
         }).start();

        new Thread(()->{
            synchronized (lock2){
                try {
                    Thread.sleep(1000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                synchronized (lock1){
                    log.info("Thread2 over");
                }
            }
        }).start();
        return "deadLock";
    }
}
