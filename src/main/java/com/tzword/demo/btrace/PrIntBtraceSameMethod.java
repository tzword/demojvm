package com.tzword.demo.btrace;

import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.OnMethod;
import com.sun.btrace.annotations.ProbeClassName;
import com.sun.btrace.annotations.ProbeMethodName;

@BTrace
public class PrIntBtraceSameMethod {
    @OnMethod(
        clazz = "com.tzword.demo.TestAction",
        method = "same"
    )
    public static void anyMethod(@ProbeClassName String pcn, @ProbeMethodName String pmn, String name,int id){
        BTraceUtils.print(" pcn:"+pcn);
        BTraceUtils.print(" name:"+name);
        BTraceUtils.print(" id:"+id);
    }
}
