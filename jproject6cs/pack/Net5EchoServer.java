package pack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

// Echo Server : 클라이언트의 요청에 계속 반응을 보이는 서버

public class Net5EchoServer {
	ServerSocket ss;
	Socket socket;
	PrintWriter out;
	BufferedReader reader;
	
	public Net5EchoServer() {
		try {
			ss = new ServerSocket(8888);
			System.out.println("서버 서비스 중...");
			
			socket = ss.accept();		// 클라이언트 접속 대기 후 클라이언트와 소통하기 위한 소켓 객체 생성
			
			out = new PrintWriter(new OutputStreamWriter(
					socket.getOutputStream(), StandardCharsets.UTF_8), true);	// 클라이언트에게 보여주기위한? out 객체..?
			reader = new BufferedReader(
					new InputStreamReader(
							socket.getInputStream(), StandardCharsets.UTF_8));	// 클라이언트가 읽기 위한? reader 객체..?
		} catch (Exception e) {
			System.out.println("Net5EchoServer err : " + e);
			System.exit(0);		// 에러나면 응용 프로그램 강제로 끝낼거야
		}

	}
	
	public void receiveSendData() {
		try {
			String msg = reader.readLine();		// 클라이언트의 자료 수신
			System.out.println("수신된 메세지 : " + msg);
			
			out.println("서버가 보낸 메세지 : " + msg + "잘 봤어");	// 자료 전송
		} catch (Exception e) {
			System.out.println("receiveSendData err : " + e);
		} finally {
			try {
				reader.close();
				out.close();
				socket.close();
				ss.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	
	public static void main(String[] args) {
		while(true) {
			Net5EchoServer server = new Net5EchoServer();
			server.receiveSendData();
		}
	}
	
}
