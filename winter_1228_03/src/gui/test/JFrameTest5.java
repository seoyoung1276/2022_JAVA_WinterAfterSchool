package gui.test;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JFrameTest5 extends JFrame {
	ImageIcon icon = new ImageIcon("images/image1.png");
	JLabel lbl = new JLabel(icon, JLabel.CENTER);
	JButton btn1 = new JButton("leellarmarz");
	JButton btn2 = new JButton("uneducatedkid");
	JButton btn3 = new JButton("layone");

public JFrameTest5 () {
	JPanel pan = new JPanel();
	ButtonListener btnListener = new ButtonListener(btn1, btn2, lbl);
	btn1.addActionListener(btnListener);
	btn2.addActionListener(btnListener);
	btn3.addActionListener(btnListener);
	JPanel pan1 = new JPanel();
	pan1.add(btn1); pan1.add(btn2); pan1.add(btn3);
	add(pan1, "North");
	
	add(lbl, "Center");
	setTitle("JFrame 상속 연습");
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setLocation(450, 40);
	setSize(700, 800);
	setVisible(true);
	
    }
}
