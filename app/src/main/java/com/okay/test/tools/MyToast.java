package com.okay.test.tools;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

/**********************************************************************************
 *@Copyright (C), 2011-2013, 北京国电通网络技术有限公司. 
 *@FileName:     com.gdt.wisdompark.dialog.MyToast.java
 *@Author:　   　　　   
 *@Version :     V1.0
 *@Date:         
 *@Description:  作用　 弹出Toast
 **********************************************************************************
 */
public class MyToast extends Toast{

	static Toast toast;
	public MyToast(Context context) {
		super(context);
	}
	/**
	 * 显示操作失败的提示
	 * @param mContext 上下文
	 * @param result 结果
	 */
	public static void showFailToast(Context mContext,int result){
//		if (toast==null) {
//			
//		}
		Activity activity = (Activity) mContext;  
        while (activity.getParent() != null) {  
            activity = activity.getParent();  
        }  
		toast = Toast.makeText(activity, "", Toast.LENGTH_LONG);
		if (result == -3) {
			toast.setText("网络连接超时!");
		} else if (result == -2) {
			toast.setText("请求超时!");
		} else {
			toast.setText("操作失败!");
		}
		toast.show();
	}
	/**
	 * 显示提示信息——通过id
	 * @param mContext
	 * @param id 字符串id
	 */
	public static void showToast(Context mContext,int id) {
//		if (toast==null) {
//			
//		}
		Activity activity = (Activity) mContext;  
        while (activity.getParent() != null) {  
            activity = activity.getParent();  
        }  
		toast = Toast.makeText(activity, id, Toast.LENGTH_LONG);
		toast.setText(id);
		toast.show();
	}
	/**
	 * 显示提示信息——通过字符串
	 * @param mContext
	 * @param content 字符串
	 */
	public static void showToast(Context mContext,String content) {
//		if (toast==null) {
//			
//		}
		Activity activity = (Activity) mContext;  
        while (activity.getParent() != null) {  
            activity = activity.getParent();  
        }  
		/**-----------------解决返回为空----------**/
		if (null!=content&&!"".equals(content)) {
			toast = Toast.makeText(activity, content, Toast.LENGTH_LONG);
			toast.setText(content);
			toast.show();
		}else {
			toast = Toast.makeText(activity, "", Toast.LENGTH_LONG);
			toast.setText("操作失败!");
			toast.show();
		}
		/**-----------------2014/07/22----------**/
	}
	

}
