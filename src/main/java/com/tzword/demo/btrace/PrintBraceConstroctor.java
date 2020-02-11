package com.tzword.demo.btrace;

import com.sun.btrace.AnyType;
import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.OnMethod;
import com.sun.btrace.annotations.ProbeClassName;
import com.sun.btrace.annotations.ProbeMethodName;

@BTrace
public class PrintBraceConstroctor {
    @OnMethod(
            clazz = "com.tzword.demo.memory.User",
            method = "<init>"
    )
    public static void anyMethod(@ProbeClassName String pcn, @ProbeMethodName String pmn, AnyType[] args){
        BTraceUtils.print("pcn:" + pcn);
        BTraceUtils.print("  pmn:" + pmn);
        BTraceUtils.printArray(args);
    }
}
