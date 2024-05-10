package pack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// 멀티 채팅 서버 : Thread + Socket
public class Net6ChatServer {
	private static final int PORT = 5000;
	//private static List<Socket> clients = new ArrayList<Socket>();	// 메인이 부를거니까 static
	// CopyOnWriteArrayList : 컨텐츠를 읽어 어딘가에 전달할 때 컨텐츠를 복사해서 전달함. 스레드에서 안심하고 처리가 가능. 신뢰도 상!승!
	private static List<Socket> clients = new CopyOnWriteArrayList<Socket>();	// 스레드용 어레이리스트 스레드에 최적화되어있는 클래스
	
	// ExecutorService를 이용하면 Thread pool을 생성해 "병렬 처리"를 할 수 있다.
	private static ExecutorService pool = Executors.newFixedThreadPool(4);	// 괄호 안에 pool의 크기를 준다.  강 위에 배가 4개    항상이 아니라 가끔 사람이 엄청나게 들어오는데 그 날만을 위해서 하드웨어를 업그레이드하긴 좀 그러니까 풀링 처리   
	
	
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(PORT);
		System.out.println("채팅 서버 서비스 시작 ...");
		
		try {
			while(true) {		// 무한루프에 빠트려
				Socket clientSocket = serverSocket.accept();
				System.out.println("새 접속자와 연결 : " + clientSocket.getInetAddress());
				clients.add(clientSocket);		// arraylist에 등록
				
				// 스레드 풀 객체가 스레드를 실행
				pool.execute(new ClientHandler(clientSocket));
			}
		} finally {
			serverSocket.close();
		}
	}
//		catch (Exception e) {			// 에러를 무시할 경우 catch 생략 가능
//			// TODO: handle exception
//		}
		
		
		// 클라이언트와 채팅하기 위한? 클래스
		static class ClientHandler implements Runnable {
			private Socket socket;		// 클라이언트와 통신하기 위한 소켓
			private BufferedReader in;
			private PrintWriter out;
			
			public ClientHandler(Socket socket) throws IOException {
				// 내부적으로 이런 일들이 일어나고 있다는 것을 기억하자.
				this.socket = socket;
				// in, out 객체 인스턴스
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				out = new PrintWriter(socket.getOutputStream(), true);
			}
			
			@Override
			public void run() {
				try {
					String name = in.readLine();	// 접속자명 받기
					if(name == null) {
						throw new IOException("클라이언트 연결이 끊어졌습니다.");
					}
					System.out.println(name + "님이 접속했습니다.");
					broadcastMessage("^^; " + name + "님 입장!");
					
					String message;
					while((message = in.readLine()) != null) {	// null이 아니면 message를 계속 읽어    메세지 수신
						broadcastMessage(name + "님 : " + message);
					}
					
				} catch (Exception e) {
					System.out.println("접속자 연결 오류 : " + e.getMessage());
				} finally {
					try {
						if(socket != null) { 
							socket.close();
							clients.remove(socket);
						}
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
			}
			
			private void broadcastMessage(String message) {		// arraylist에서 접속자명이나 메세지가 넘어올거야
				for(Socket client:clients) {	
					try {
						if(!client.isClosed()) {
							// 클라이언트로 송신할 데이터를 위한 PrintWriter 객체를 생성해 송신 후 자동으로 flush(메모리를 비움)함
							PrintWriter clientOut = 
									new PrintWriter(client.getOutputStream(), true);
							clientOut.println(message);
						}
					} catch (Exception e) {
						System.out.println("broadcastMessage err : " + e.getMessage());
					}
				}
			}
	}
}
