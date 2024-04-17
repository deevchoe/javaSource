package pack3;

import java.awt.Color;
import java.awt.Frame;	// Frame 클래스가 들어있는 곳
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;	// WindowListener 클래스가 들어있는 곳

// 인터페이스를 이용한 이벤트 처리 
public class MyFrame3 extends Frame implements WindowListener, MouseListener{
	public MyFrame3() {
		// 생성자
		//super("상속사용");  // 생성자를 통해서 값을 준 거
		super.setTitle("상속 사용"); // Frame에 가보면 멤버 필드에 Title이 있다.
		
		display();
		
		super.addWindowListener(this); // 현재 Frame에 이벤트 리스너를 장착
		// Frame 클래스가 갖고있는 메소드
		// 윈도우 이벤트에 대해 귀를 기울이라고..
		// 현재 클래스가 WindowListener를 implements하여 상속 받았기 때문에 argument 칸에 this를 써준다.
		
		addMouseListener(this); // 프레임에다가 나 마우스 이벤트 발생시킬거거든 귀를 기울여~!라는 뜻
	}
	
	void display() {
		setSize(500, 300);
		//super.setSize(500, 300);
		setLocation(200, 150);
		setVisible(true);
	}
	
	// WindowListener가 가진 추상메소드 오버라이딩
	@Override
	public void windowActivated(WindowEvent e) {
		
	}
	
	@Override
	public void windowClosed(WindowEvent e) {
		
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		//System.out.println("종료");
		//setTitle("안녕 종료는 아직...");
		System.exit(0);
	}
	
	@Override
	public void windowDeactivated(WindowEvent e) {
		
	}
	
	@Override
	public void windowDeiconified(WindowEvent e) {
		System.out.println("windowDeiconified");
	}
	
	@Override
	public void windowIconified(WindowEvent e) {
		System.out.println("windowIconified");
	}
	
	@Override
	public void windowOpened(WindowEvent e) {
		System.out.println("windowOpened");
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		//System.out.println("클릭 성공 후 점심 먹기");
		//setBackground(new Color(255, 0, 0));
		//System.out.println((int)(Math.random() * 255));
		int r = (int)(Math.random() * 255);
		int g = (int)(Math.random() * 255);
		int b = (int)(Math.random() * 255);
		setBackground(new Color(r, g, b));
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		new MyFrame3();
	}

}
