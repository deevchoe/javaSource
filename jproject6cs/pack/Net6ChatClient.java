package pack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Net6ChatClient {
	private static final String HOST = "192.168.0.21";
	private static final int PORT = 5000;
	
	public static void main(String[] args) throws IOException{
		Socket socket = new Socket(HOST, PORT);		// 서버의 accept를 만남
		System.out.println("서버에 연결되었습니다.");
		
		BufferedReader in = new BufferedReader(
				new InputStreamReader(socket.getInputStream()));
		PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("접속자명 입력 : ");
		String name = scanner.nextLine();
		out.println(name);		// 서버로 접속자명 전송
	
		Thread readThread = new Thread(new Runnable() {		// 서버가 수신 받은 데이터를 언제 보낼지 모르기 때문에? 스레드로 처리
			@Override
			public void run() {
				try {
					String serverMessage;
					while((serverMessage = in.readLine()) != null) {
						System.out.println(serverMessage);
					}
				} catch (Exception e) {
					System.out.println("수신 데이터 오류 : " + e.getMessage());
				}
			}
		});
		readThread.start();
		
		String msg;
		while((msg = scanner.nextLine()) != null) {
			if(msg.isEmpty()) {
				out.println(msg);	// 채팅 메세지 전송
			}
		}
		
		socket.close();
		scanner.close();
	}
}