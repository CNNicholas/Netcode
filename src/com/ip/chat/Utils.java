package com.ip.chat;

import java.io.Closeable;

/**
 * ������
 * 
 * @author ������1999
 *
 */
public class Utils {
	/**
	 * �ͷ���Դ
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
