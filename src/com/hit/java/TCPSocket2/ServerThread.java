package com.hit.java.TCPSocket2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/*
 * 服务器线程处理
 */
public class ServerThread extends Thread {
	//创建相关的socket
	Socket socket = null;
	//初始化socket
	public ServerThread(Socket socket){
		this.socket = socket;
	}
	
	//重写run()方法 ,响应客户端请求
	public void run(){
		
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		OutputStream os = null;
		//转换为打印流
		PrintWriter pw = null;
		try {
			is = socket.getInputStream();
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			String info = null;
			while((info = br.readLine())!=null){
				System.out.println(info);
			}
			socket.shutdownInput();
			os = socket.getOutputStream();
			pw = new PrintWriter(os);
			//打印内容
			pw.write("欢迎您登陆！！！");
			//刷新缓存
			pw.flush();
			socket.shutdownOutput();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//关闭资源
			try {
				if(os!=null)
					os.close();
				if(pw!=null)
					pw.close();
				if(is!=null)
					is.close();
				if(isr!=null)
					isr.close();
				if(br!=null)
					br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	

}
