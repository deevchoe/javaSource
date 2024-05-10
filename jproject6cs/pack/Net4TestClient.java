package pack;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Net4TestClient {

	public static void main(String[] args) {
		
		try {
//			InetAddress ia = InetAddress.getByname("127.0.0.1");
//			//System.out.println(ia);
//			Socket soket = new Socket(ia, 9999);
			
			Socket socket = new Socket("127.0.0.1", 9999);	// 서버와 접속   서버의 accept가 받고 서버의 socket과 client의 소켓이 연결됨
			
			PrintWriter writer = new PrintWriter(
					new OutputStreamWriter(socket.getOutputStream(), 
															StandardCharsets.UTF_8), true);
			writer.println("안녕 난 choioo이야" + "\n");  // 서버로 전송
			//System.out.println(); 	// 콘솔로 전송
			writer.close();
			socket.close();
			
		} catch (Exception e) {
			System.out.println("client err : " + e);
		}
		// 특정 컴의 접속 후 메세지 전달용

	}

}
