package com.hit.java.TCPSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/*
 * 客户端
 * 1、创建Socket对象，指定服务器端地址和端口
 * 2、获取输出流。向客户端发送请求
 */
public class Client {

	public static void main(String[] args) {
		try {
			//创建Socket的对象，并指定服务器地址及端口
			Socket socket = new Socket("localHost",8888);
			//获取输出流
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os);//将输出流包装为打印流
			pw.write("用户名： yp201536 ； 密码：201536");
			pw.flush();//刷新缓存
			//关闭输出流
			socket.shutdownOutput();
			//获取输入流，接收服务端的响应
			InputStream is = socket.getInputStream();
			//将字节流转换为字符流
			InputStreamReader isr = new InputStreamReader(is);
			//创建缓冲流
			BufferedReader br = new BufferedReader(isr);
			String info = null;
			while((info = br.readLine()) != null){
				System.out.println("服务器端说：" + info );
			}
			//关闭输入流
			socket.shutdownInput();
			//关闭其他资源
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
