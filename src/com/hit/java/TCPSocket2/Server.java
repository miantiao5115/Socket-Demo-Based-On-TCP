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
			//����serverSocket�Ķ��󣬲��󶨶˿ں�
			ServerSocket serverSocket = new ServerSocket(8888);
			System.out.println("��������׼���������ȴ��ͻ��˵�����~~");
			Socket socket = null;
			int count = 0;
			while(true){
				socket = serverSocket.accept();
				ServerThread st = new ServerThread(socket);
				st.start();
				count++;//�����½�ͻ��˵�����
				System.out.println("�ͻ��˵�������" + count);
				InetAddress address = InetAddress.getLocalHost();
				System.out.println("��ǰ��¼�ͻ��˵�IP��ַΪ��" + address.getHostAddress());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
