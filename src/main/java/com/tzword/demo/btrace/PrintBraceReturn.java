package com.tzword.demo.btrace;

import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.*;

/**
 * Created by tzwor on 2020/2/11.
 */
@BTrace
public class PrintBraceReturn {
    @OnMethod(
            clazz = "com.tzword.demo.TestAction",
            method = "HelloJvm",
            location = @Location(Kind.RETURN)
    )
    public static void anyMethod(@ProbeClassName String pcm,@ProbeMethodName String pmn,@Return String returnvalue){
        BTraceUtils.print(" pcm:"+pcm);
        BTraceUtils.print(" pmn:"+pmn);
        BTraceUtils.print(" returnvalue:"+returnvalue);
    }
}
