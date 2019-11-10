package com.xy.t_bytecode.bean;


import java.text.SimpleDateFormat;

public class LogPrintInterceptor {

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");

	public static void startLogPrint() {

		long timeMillisStart = System.currentTimeMillis();
		System.out.println("---start log print---"+dateFormat.format(timeMillisStart));
	}
	
	public static void endLogPrint() {
		long timeMillisEnd = System.currentTimeMillis();
        System.out.println("---end log print---"+dateFormat.format(timeMillisEnd));
	}

}
