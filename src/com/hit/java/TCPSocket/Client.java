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
 * �ͻ���
 * 1������Socket����ָ���������˵�ַ�Ͷ˿�
 * 2����ȡ���������ͻ��˷�������
 */
public class Client {

	public static void main(String[] args) {
		try {
			//����Socket�Ķ��󣬲�ָ����������ַ���˿�
			Socket socket = new Socket("localHost",8888);
			//��ȡ�����
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os);//���������װΪ��ӡ��
			pw.write("�û����� yp201536 �� ���룺201536");
			pw.flush();//ˢ�»���
			//�ر������
			socket.shutdownOutput();
			//��ȡ�����������շ���˵���Ӧ
			InputStream is = socket.getInputStream();
			//���ֽ���ת��Ϊ�ַ���
			InputStreamReader isr = new InputStreamReader(is);
			//����������
			BufferedReader br = new BufferedReader(isr);
			String info = null;
			while((info = br.readLine()) != null){
				System.out.println("��������˵��" + info );
			}
			//�ر�������
			socket.shutdownInput();
			//�ر�������Դ
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
