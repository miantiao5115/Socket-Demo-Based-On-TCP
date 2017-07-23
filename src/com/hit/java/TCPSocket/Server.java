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
 * ����TCP��̵�Socketͨ��
 * ��������Socket����Server Socket
 * ���裺1��������������serverSocket���󣬰󶨼����˿�   
 * 		2������accept()�����������ͻ�����
 * 		3���������Ӻ�ͨ����������ȥ�ͻ����͵����������
 * 		4��ͨ�� ���������Ӧ�ͻ���
 * 		5��ͨ�����������Ӧ�ͻ���
 */
public class Server {
	public static void main(String[] args) {
		try {
			//����serverSocket���󣬰󶨶˿ڣ�
			ServerSocket serverSocket = new ServerSocket(8888);
			System.out.println("�������˼����������ȴ��û�����~~~~");
			//����accept()����,�����ͻ�����
			Socket socket = serverSocket.accept();
			//ͨ����������ȡ�ͻ�������
			InputStream is = socket.getInputStream();
			InputStreamReader isr= new InputStreamReader(is);//���ֽ���ת��Ϊ�ַ���
			BufferedReader br = new BufferedReader(isr);//����������
			String info = null;
			//һ��һ��ѭ����ȡ�ͻ���������
			while((info=br.readLine())!=null){
				System.out.println("�ͻ�˵: "+info);
			}
			//�ر�������
			socket.shutdownInput();
			//��ȡ�����
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			pw.write("��ӭ����");
			pw.flush();
			//�ر������
			socket.shutdownOutput();
			//�ر�������Դ
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
