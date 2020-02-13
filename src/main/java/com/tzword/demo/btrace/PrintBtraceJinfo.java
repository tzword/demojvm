package com.tzword.demo.btrace;

import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.BTrace;

/**
 * Created by tzwor on 2020/2/13.
 */
@BTrace
public class PrintBtraceJinfo {
    static {
        BTraceUtils.println("System propertitys:");
        BTraceUtils.printProperties();
        BTraceUtils.println("VM flag:");
        BTraceUtils.printVmArguments();
        BTraceUtils.println("OS Environment");
        BTraceUtils.printEnv();
    }
}
