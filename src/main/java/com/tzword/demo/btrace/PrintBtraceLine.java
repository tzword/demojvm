package com.tzword.demo.btrace;

import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.*;

/**
 * Created by tzwor on 2020/2/12.
 */
@BTrace
public class PrintBtraceLine {
    @OnMethod(
            clazz = "com.tzword.demo.TestAction",
            method = "exception",
            location = @Location(value = Kind.LINE,line = 71)
    )
    public static void anyMethod(@ProbeClassName String pcn, @ProbeMethodName String pmn,int line){
        BTraceUtils.println(line);
    }
}
