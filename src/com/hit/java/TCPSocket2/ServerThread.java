package com.hit.java.TCPSocket2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/*
 * �������̴߳���
 */
public class ServerThread extends Thread {
	//������ص�socket
	Socket socket = null;
	//��ʼ��socket
	public ServerThread(Socket socket){
		this.socket = socket;
	}
	
	//��дrun()���� ,��Ӧ�ͻ�������
	public void run(){
		
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		OutputStream os = null;
		//ת��Ϊ��ӡ��
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
			//��ӡ����
			pw.write("��ӭ����½������");
			//ˢ�»���
			pw.flush();
			socket.shutdownOutput();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//�ر���Դ
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
