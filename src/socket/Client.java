package socket;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	private Socket socket;
	
	
	public Client() {
		
		try {
			System.out.println("Connecting with Server");
			socket = new Socket("localhost", 12001);
			System.out.println("Already connected with server");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void start() {
		
		try {
			OutputStream out = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(out,"utf-8");
			BufferedWriter bw = new BufferedWriter(osw);
			PrintWriter pw = new PrintWriter(bw,true);
			
			Scanner kb = new Scanner(System.in);
			System.out.println("Please enter message");
			while(true) {
				String str = kb.nextLine();
				if("exit".equals(str.toLowerCase())) {
					break;
				}
				pw.println(str);
			}
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {

		Client client = new Client();
		client.start();
	}

}
