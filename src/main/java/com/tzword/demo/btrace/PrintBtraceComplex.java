package com.tzword.demo.btrace;

import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.*;
import com.tzword.demo.memory.User;

import java.lang.reflect.Field;

/**
 * 打印复杂对象
 */
@BTrace
public class PrintBtraceComplex {
    @OnMethod(
            clazz = "com.tzword.demo.TestAction",
            method = "getComplex",
            location = @Location(Kind.ENTRY)
    )
    public static void anyMethod(@ProbeClassName String pcn, @ProbeMethodName String pmn,User user){
        BTraceUtils.printFields(user);
        Field field = BTraceUtils.field("com.tzword.demo.memory.User","name");
        BTraceUtils.println(BTraceUtils.get(field,user));
        BTraceUtils.println("pcn:"+pcn+"pmn:"+pmn);
    }
}
