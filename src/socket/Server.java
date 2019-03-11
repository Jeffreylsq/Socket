package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	private ServerSocket server;
	
	public Server() {
		
		try {
			System.out.println("Starting Server");
			server = new ServerSocket(12001);
			System.out.println("Finish starting server");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void start() {
		
		try {
			System.out.println("Connecting with client");
			Socket socket = server.accept();
			System.out.println("Already connect with client");
			
			
			/*
			 * Socket �ṩ�ķ�����
			 * InputStream getInputStream()
			 * ͨ��Socket��ȡ���������ֽ�������Զ�˼�������͹������ֽ�
			 * 
			 */
			InputStream input = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(input,"utf-8");
			BufferedReader br = new BufferedReader(isr);
			String str = null;
			
			/*
			 * ͨ��BufferedReader ��ȡ�ͻ��˷��͹�����һ���ַ�����������У� ���ͻ��˶Ͽ�����ʱ�� ���ڿͻ���ϵͳ��ͬ
			 * �����������ı���Ҳ��ͬ��ͨ���ͻ��˶Ͽ����ӣ�readLine������ֱ���׳��쳣
			 * ��Linux�ͻ��Ͽ�����ʱ��readLine�����᷵��Ϊnull;
			 */
			while((str = br.readLine())!= null) {
				
				System.out.println("Client said: " + str);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {

		Server server = new Server();
		server.start();
	}

}
