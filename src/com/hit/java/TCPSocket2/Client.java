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
 * �ͻ���Socket
 */
public class Client {

	public static void main(String[] args) {
		try {
			//����Socket�Ķ��󣬲��󶨶˿�
			Socket socket = new Socket("localHost",8888);
			//����OutputStream()������������
			OutputStream os = socket.getOutputStream();
			//ת��Ϊ��ӡ��
			PrintWriter pw = new PrintWriter(os);
			//��ӡ����
			pw.write("�˺ţ�tom   ���룺123456");
			//ˢ�»���
			pw.flush();
			socket.shutdownOutput();
			InputStream is = socket.getInputStream();//����InputStream()��������ַ�������������
			InputStreamReader isr = new InputStreamReader(is);//���ַ���ת�����ֽ���
			BufferedReader br = new BufferedReader(isr);//����������
			String info = null;
			while((info = br.readLine())!=null){
				System.out.println(info);
			}
			//�ر���Դ
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
