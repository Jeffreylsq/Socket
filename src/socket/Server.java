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
			 * Socket 提供的方法：
			 * InputStream getInputStream()
			 * 通过Socket获取输入流的字节是来自远端计算机发送过来的字节
			 * 
			 */
			InputStream input = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(input,"utf-8");
			BufferedReader br = new BufferedReader(isr);
			String str = null;
			
			/*
			 * 通过BufferedReader 读取客户端发送过来的一行字符串这个操作中， 当客户端断开连接时， 由于客户端系统不同
			 * 服务端在这里的表现也不同，通常客户端断开连接，readLine方法会直接抛出异常
			 * 而Linux客户断开连接时，readLine方法会返回为null;
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
