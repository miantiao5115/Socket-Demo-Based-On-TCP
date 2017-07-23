package com.hit.java.TCPSocket2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		try {
			//创建serverSocket的对象，并绑定端口号
			ServerSocket serverSocket = new ServerSocket(8888);
			System.out.println("服务器已准备就绪，等待客户端的链接~~");
			Socket socket = null;
			int count = 0;
			while(true){
				socket = serverSocket.accept();
				ServerThread st = new ServerThread(socket);
				st.start();
				count++;//计算登陆客户端的数量
				System.out.println("客户端的数量：" + count);
				InetAddress address = InetAddress.getLocalHost();
				System.out.println("当前登录客户端的IP地址为：" + address.getHostAddress());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
