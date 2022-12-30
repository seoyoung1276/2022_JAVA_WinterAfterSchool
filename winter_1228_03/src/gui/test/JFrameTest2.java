package gui.test;

import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Inner(내부) 클래스로 ActionListener를 구현 

public class JFrameTest2 extends JFrame implements ActionListener{
	ImageIcon icon = new ImageIcon("images/image1.png");
	JLabel lbl = new JLabel(icon, JLabel.CENTER);
	JButton btn1 = new JButton("leellarmarz");
	JButton btn2 = new JButton("uneducatedkid");
	JButton btn3 = new JButton("layone");

	public JFrameTest2() {
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		JPanel pan = new JPanel();
		pan.add(btn1); pan.add(btn2); pan.add(btn3);
		add(pan, "North");
		add(lbl, "Center");
		setTitle("JFrame 상속 연습");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(200, 200);
		setSize(700, 1000);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new JFrameTest2();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object btnSource = e.getSource();
		if(btnSource == btn1) {
			icon = new ImageIcon("images/image2.jpg");
		}else if(btnSource == btn2) {
			icon = new ImageIcon("images/image1.jpg");
		}else{
			icon = new ImageIcon("images/image4.png");
		}
		lbl.setIcon(icon);
	}

}
