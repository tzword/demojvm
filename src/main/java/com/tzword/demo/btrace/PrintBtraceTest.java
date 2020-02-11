package com.tzword.demo.btrace;

import com.sun.btrace.AnyType;
import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.*;

@BTrace
public class PrintBtraceTest {
    @OnMethod(
            clazz = "com.tzword.demo.TestAction",
            method = "HelloJvm",
            location = @Location(Kind.ENTRY)
    )
    public static void anyRead(@ProbeClassName String pcn, @ProbeMethodName String pmn, AnyType[] args){
        BTraceUtils.printArray(args);
        BTraceUtils.print("pcn:" + pcn);
        BTraceUtils.print("pmn:" + pmn);
    }
}
