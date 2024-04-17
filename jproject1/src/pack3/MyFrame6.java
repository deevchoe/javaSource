package pack3;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MyFrame6 extends Frame{
	
	public MyFrame6(String msg) {
		super(msg);
		
		setSize(300, 250);
		setLocation(200, 200);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {		// 익명 클래스를 쓰기 위한 new
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//setBackground(new Color(0, 0, 255));
				setBackground(Color.BLUE);// new 할 수도 있지만 전문가가 final static으로 만들어놓음 -> 가독성이 더 좋아짐
				// 근데 이거는 많이 사용하는 색깔만 생성되어있다.
			}
		});
	}

	public static void main(String[] args) {
		// 내부 무명 클래스
		new MyFrame6("내부 무명 클래스");
	}

}
