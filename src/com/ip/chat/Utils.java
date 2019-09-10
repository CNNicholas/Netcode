package com.ip.chat;

import java.io.Closeable;

/**
 * 工具类
 * 
 * @author 朱致宇1999
 *
 */
public class Utils {
	/**
	 * 释放资源
	 */
	public static void close(Closeable... targets ) {
		for(Closeable target:targets) {
			try {
				if(null!=target) {
					target.close();
				}
			}catch(Exception e) {
				
			}
		}
	}
}
