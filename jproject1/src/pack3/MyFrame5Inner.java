package pack3;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;	// java.awt.event 패키지 내에 있는 추상클래스
import java.awt.event.WindowEvent;

public class MyFrame5Inner extends Frame{	// Frame을 갖다 쓰고 있음
	//private Wevent wevent = new Wevent(); 	// wevent 객체 생성
	//private Wevent wevent; 	// wevent 객체 생성
	private int x, y;	// mouseClicked 에서 발생한 x, y 좌표를 기억
	private String[] names = {"정재형", "이원재", "지명기", "김성하", "최지연"};
	public MyFrame5Inner() {
		setTitle("내부 클래스");
		
		setSize(300, 250);
		setLocation(200, 200);
		setVisible(true);
		
		// 객체를 불러와서 객체 변수를 생성한 경우
		//wevent = new Wevent();
		//addWindowListener(wevent); // Frame이 가지고 있는 메소드 windowlistner를 달래 이걸 Wevent가 갖고 있어 그러니까 wevent 객체를 생성
		addWindowListener(new Wevent());	// 객체만 불러온경우
		addMouseListener(new Mevent());
	}
	
	class Wevent extends WindowAdapter{	// 내부 클래스		MyFrame5Inner 클래스 내부에서만 쓸 수 있는 내부 클래스
		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}
	
	class Mevent extends MouseAdapter{	// 내부 클래스
		@Override
		public void mouseClicked(MouseEvent e) {
			//setTitle("클릭!");
			
			// 좌표 출력
			//int x = e.getX();	// 지역변수에 값 치환
			//int y = e.getY();
			
			x = e.getX();	// 전역변수에 값 치환
			y = e.getY();
			setTitle("x : " + x + ", y : " + y);
			
			//paint(getGraphics());	// 자동호출되는 paint()를 명시적으로 호출		-> refresh가 안됨
			repaint(); 		// Graphics 객체를 가진 paint()를 호출.		-> refresh가 됨
		}
	}
	
	@Override
		public void paint(Graphics g) {		// 자동 호출이 기본
			// Graphics : Frame이 제공하는 그림 그리기 객체
			//g.drawString("홍길동", 100, 100);
			g.setFont(new Font("굴림", Font.BOLD, (int)(Math.random() * 50 + 8)));
			
			int n = (int)(Math.random() * 5);
			//g.drawString("홍길동", x, y);
			g.drawString(names[n], x, y);
		}
	
	public static void main(String[] args) {
		new MyFrame5Inner();	// 생성자 호출
	}
}
