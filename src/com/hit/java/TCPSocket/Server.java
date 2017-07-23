package com.hit.java.TCPSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 基于TCP编程的Socket通信
 * 服务器端Socket，即Server Socket
 * 步骤：1、创建服务器端serverSocket对象，绑定监听端口   
 * 		2、调用accept()方法，监听客户请求
 * 		3、建立连接后，通过输入流都去客户发送的请求的内容
 * 		4、通过 输出流，相应客户端
 * 		5、通过输出流，响应客户端
 */
public class Server {
	public static void main(String[] args) {
		try {
			//创建serverSocket对象，绑定端口；
			ServerSocket serverSocket = new ServerSocket(8888);
			System.out.println("服务器端即将启动，等待用户输入~~~~");
			//调用accept()方法,监听客户请求
			Socket socket = serverSocket.accept();
			//通过输入流读取客户端请求
			InputStream is = socket.getInputStream();
			InputStreamReader isr= new InputStreamReader(is);//将字节流转换为字符流
			BufferedReader br = new BufferedReader(isr);//创建缓冲流
			String info = null;
			//一行一行循环读取客户请求内容
			while((info=br.readLine())!=null){
				System.out.println("客户说: "+info);
			}
			//关闭输入流
			socket.shutdownInput();
			//获取输出流
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			pw.write("欢迎您！");
			pw.flush();
			//关闭输出流
			socket.shutdownOutput();
			//关闭其他资源
			is.close();
			isr.close();
			os.close();
			pw.close();
			socket.close();
			serverSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
