package test.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import test.program.TestDAO;
import test.program.TestVO;
import test.program.TestView;

public class TestController extends JFrame {
   TestDAO dao;
   ArrayList<TestVO> testVOList;
   TestView view2;
   
   public TestController() {
      dao = new TestDAO();
      view2 = new TestView();
      testVOList = dao.select();
      view2.setTestVOList(testVOList);
      view2.initView();
      JButton btnAdd = view2.getBtnAdd();
      btnAdd.addActionListener(btnAddL);   
      add(view2, "Center");
      setTitle("도서관리시스템");
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setLocation(200, 200);
      setSize(600, 500);
      setVisible(true);
   }

   public static void main(String[] args) {
      new TestController();
   }

   ActionListener btnAddL = new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e) {
//         neededInsertData(): panS에 있는 JTextField에 입력된 값들과 JCombobox의 값을
//         BooVO에 필드값들을 초기화하여 BookVO 객체 참조값을 반환하는 메소드
         TestVO vo = view2.neededInsertData();
         dao.insert(vo);
         testVOList = dao.select();
         view2.setTestVOList(testVOList);
         view2.putResult();
         view2.initInsertData();
      }
   };
   
  /* MouseAdapter tableL = new MouseAdapter() {
	   public void mouseClicked(MouseEvent e) {
		   int state = 1;
		   if(e.getClickCount()==2) {
			   state = JOptionPane.showConfirmDialog(TestController.this, "정말 삭제하시겠습니까?");
			   if(state == JOptionPane.YES_OPTION) {
				   dao.delete(table.getSelectedRow());
				   svoList = dao.select();
				   view2.setTestVOList(testVOList);
				   view2.putResult();
				   view2.initInsertData();
			   }
		   }
	   }*/
   }