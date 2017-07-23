package com.hit.java.TCPSocket2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/*
 * 客户端Socket
 */
public class Client {

	public static void main(String[] args) {
		try {
			//创建Socket的对象，并绑定端口
			Socket socket = new Socket("localHost",8888);
			//调用OutputStream()方法获得输出流
			OutputStream os = socket.getOutputStream();
			//转换为打印流
			PrintWriter pw = new PrintWriter(os);
			//打印内容
			pw.write("账号：tom   密码：123456");
			//刷新缓存
			pw.flush();
			socket.shutdownOutput();
			InputStream is = socket.getInputStream();//调用InputStream()方法获得字符输入流输入流
			InputStreamReader isr = new InputStreamReader(is);//将字符流转换成字节流
			BufferedReader br = new BufferedReader(isr);//创建缓冲流
			String info = null;
			while((info = br.readLine())!=null){
				System.out.println(info);
			}
			//关闭资源
			socket.shutdownInput();
			is.close();
			isr.close();
			br.close();
			os.close();
			pw.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
