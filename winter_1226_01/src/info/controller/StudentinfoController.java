package info.controller;

import java.util.ArrayList;
import java.util.Scanner;

import info.vo.StudentDAO;
import info.vo.StudentVO;
import info.vo.StudentView;

public class StudentinfoController {
	public static final int CONTINUE = 1;
	public static final int EXIT = 0;
   ArrayList<StudentVO> svoList = new ArrayList<StudentVO>();
 
   
    public void insert(StudentVO svo) {
      svoList.add(svo);
   }
    
    public void view() {
       //개선된(enhanced) for문
       for(StudentVO svo : svoList) {
          System.out.print("성명 : " + svo.getName() + "\n");
          System.out.print("학번 : " + svo.getStuId() + "\n");
          System.out.print("학년 : " + svo.getGrade() + "\n");
          System.out.print("전공 : " + svo.getMajor() + "\n");
          System.out.print("주소 : " + svo.getAddress() + "\n");
          System.out.print("핸드폰 번호 : " + svo.getMobile() + "\n\n");
       }
    }

   public static void main(String[] args) {
	   ArrayList<String> names = new ArrayList<String>();
	   ArrayList<Integer> stuIds = new ArrayList<Integer>();
	   ArrayList<Integer> grades = new ArrayList<Integer>();
	   ArrayList<String> majors = new ArrayList<String>();
	   ArrayList<String> mobiles = new ArrayList<String>();
	   ArrayList<String> address = new ArrayList<String>();
	   
	   Scanner s1 = new Scanner(System.in);
	   Scanner s2 = new Scanner(System.in);
      
	   int flag = CONTINUE;
	   System.out.println("=====     학생 정보 입력 화면     =====");
	   while (true) {
		   if(flag == CONTINUE) {
			   if(flag == CONTINUE) {
		            System.out.print("성명 : ");
		            names.add(s2.next());
		            System.out.print("학번 : ");
		            stuIds.add(s1.nextInt());
		            System.out.print("학년 : ");
		            grades.add(s1.nextInt());
		            System.out.print("전공 : ");
		            majors.add(s2.next());
		            System.out.print("주소 : ");
		            address.add(s2.next());
		            System.out.print("핸드폰 번호 : ");
		            mobiles.add(s1.next());   
		   }else if(flag == EXIT) {
			   break;
		   }
		   System.out.println("계속 입력하시겠습니까?(계속: 1, 종료:0) : ");
		   flag = s2.nextInt();
		   System.out.println("----------------------------------");
	     }
	   } 
		   
	   StudentDAO dao = new StudentDAO();
      
      for(int i = 0; i < names.size(); i++) {
         StudentVO svo = new StudentVO(names.get(i), stuIds.get(i), grades.get(i), majors.get(i), address.get(i), mobiles.get(i));
        dao.insert(svo);
      }
      
      StudentView stuView = new StudentView();
      stuView.view(dao.select());
      
      s1.close();
      s2.close();
   }//main

}//class