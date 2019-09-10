package com.ip.loc;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * URL: ͳһ��Դ��λ��,�����������ʯ֮һ(html http),������Դ
 * 1��Э��
 * 2�������������
 * 3���˿�: Ĭ��80
 * 4��������Դ
 *  http://www.baidu.com:80/index.html?uname=shsxt&age=18#a
 * 
 * 
 *
 */
public class URLTest01 {

	public static void main(String[] args) throws MalformedURLException {
		URL url = new URL("https://image.baidu.com/search/detail?z=0&word=%E7%8E%8B%E4%B9%89%E5%8D%9A%E4%BD%9C%E5%93%81&hs=0&pn=2&spn=0&di=0&pi=42860072193&tn=baiduimagedetail&is=0%2C0&ie=utf-8&oe=utf-8&cs=1635775129%2C499054354&os=&simid=&adpicid=0&lpn=0&fm=&sme=&cg=&bdtype=-1&oriquery=&objurl=http%3A%2F%2Fb.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2F32fa828ba61ea8d3fcd2e9ce9e0a304e241f5803.jpg&fromurl=&gsm=0&catename=pcindexhot&islist=&querylist=");
		//��ȡ�ĸ�ֵ
		System.out.println("Э��:"+url.getProtocol());
		System.out.println("����|ip:"+url.getHost());
		System.out.println("�˿�:"+url.getPort());
		System.out.println("������Դ1:"+url.getFile());
		System.out.println("������Դ2:"+url.getPath());
		
		//����
		System.out.println("����:"+url.getQuery());
		//ê��
		System.out.println("ê��:"+url.getRef());
	}

}
