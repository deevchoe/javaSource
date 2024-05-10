package pack7gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Ex50Packman extends JFrame implements KeyListener {
	Image image;
	int x = 100, y = 100;
	int selImage = 1;
	
	
	public Ex50Packman() {
		super("상하좌우 화살표를 사용하세요");
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Study\\Academy\\Acorn\\jsource\\jproject1\\src\\pack7gui\\pack1.jpg"));	// 절대경로만 된다.
		
		setLayout(null);	// 배치 관리자 없음  --> 화살표 키를 이용해서 찔끔찔끔 움직여야 되니까
		setResizable(false);	// 창 크기 변경 불가
		
		setBounds(200, 200, 500, 400);
		setBackground(Color.WHITE);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		addKeyListener(this);
		
		x = super.getWidth() / 2;	// Frame의 너비 절반
		y = super.getHeight() / 2;	// Frame의 높이 절반
	}
	
	@Override
	public void paint(Graphics g) {
		// Frame에 뭔가를 그려주는 메소드로 자동 호출
		switch(selImage) {
		case 1: 
			image = Toolkit.getDefaultToolkit().getImage("D:\\Study\\Academy\\Acorn\\jsource\\jproject1\\src\\pack7gui\\pack1.jpg");
			break;
		case 2:
			image = Toolkit.getDefaultToolkit().getImage("D:\\Study\\Academy\\Acorn\\jsource\\jproject1\\src\\pack7gui\\pack2.jpg");
			break;
		case 3:
			image = Toolkit.getDefaultToolkit().getImage("D:\\Study\\Academy\\Acorn\\jsource\\jproject1\\src\\pack7gui\\pack3.jpg");
			break;
		case 4:
			image = Toolkit.getDefaultToolkit().getImage("D:\\Study\\Academy\\Acorn\\jsource\\jproject1\\src\\pack7gui\\pack4.jpg");
			break;
		case 5:
			image = Toolkit.getDefaultToolkit().getImage("D:\\Study\\Academy\\Acorn\\jsource\\jproject1\\src\\pack7gui\\pack5.jpg");
			break;
		case 6:
			image = Toolkit.getDefaultToolkit().getImage("D:\\Study\\Academy\\Acorn\\jsource\\jproject1\\src\\pack7gui\\pack6.jpg");
			break;
		case 7:
			image = Toolkit.getDefaultToolkit().getImage("D:\\Study\\Academy\\Acorn\\jsource\\jproject1\\src\\pack7gui\\pack7.jpg");
			break;
		case 8:
			image = Toolkit.getDefaultToolkit().getImage("D:\\Study\\Academy\\Acorn\\jsource\\jproject1\\src\\pack7gui\\pack8.jpg");
			break;
		}
				
		g.clearRect(0, 0, getWidth(), getHeight());		// 화면 전체를 선택 후 클리어 : 잔상 해결
		
		g.drawImage(image, x - image.getWidth(this) / 2,
				y - image.getHeight(this)	/ 2, this);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		//System.out.println("key : " + key);
		
		if(key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_NUMPAD6) {	// 오른쪽 화살표
			//System.out.println("go");
			selImage = (selImage == 1)?2:1;		// 삼항 연산자
			//x = x + 10;
			x = (x < getWidth())?x += 5:-image.getWidth(this);	// x값이 Frame의 너비보다 작으면 x 값을 늘려줘
		}
		if(key == KeyEvent.VK_LEFT || key == KeyEvent.VK_NUMPAD4) {	// 왼쪽 화살표
			//System.out.println("Back");
			selImage = (selImage == 3)?4:3;		// 삼항 연산자
			//x = x - 10;
			x = (x > 0)?x -= 10:super.getWidth();	// x값이 0보다 작으면 x 값을 줄여주...고..  클래스의 너비를ㄹ..?
		}
		if(key == KeyEvent.VK_DOWN || key == KeyEvent.VK_NUMPAD2) {	// 아래 화살표
			//System.out.println("go");
			selImage = (selImage == 5)?6:5;		// 삼항 연산자
			//x = x + 10;
			y = (y < getWidth())?y += 5:-image.getWidth(this);	// x값이 Frame의 너비보다 작으면 x 값을 늘려줘
		}
		if(key == KeyEvent.VK_UP || key == KeyEvent.VK_NUMPAD8) {	// 위 화살표
			//System.out.println("go");
			selImage = (selImage == 7)?8:7;		// 삼항 연산자
			//x = x + 10;
			y = (y > 0)?y -= 5:getHeight();	
		}
		
		repaint(); 		// paint() 호출
	}
	
	
	
	@Override
	public void keyReleased(KeyEvent e) {	}
	@Override
	public void keyTyped(KeyEvent e) {	}
	
	public static void main(String[] args) {
		// 키보드 이벤트 연습
		new Ex50Packman();

	}

}
