package com.tzword.demo.btrace;

import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.OnMethod;
import com.sun.btrace.annotations.ProbeClassName;
import com.sun.btrace.annotations.ProbeMethodName;

/**
 * Created by tzwor on 2020/2/13.
 */
@BTrace
public class PrintBtraceRegex {
    @OnMethod(
            clazz = "com.tzword.demo.TestAction",
            method = "/.*/"
    )
    public static void anyMethod(@ProbeClassName String pcn, @ProbeMethodName String pmn){
        BTraceUtils.println("pcn:"+pcn+" ,pmn:"+pmn);
    }
}
