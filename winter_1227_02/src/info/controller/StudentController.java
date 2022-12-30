package info.controller;

import java.util.ArrayList;
import java.util.Scanner;

import info.view.StudentView;
import info.vo.StudentDAO;
import info.vo.StudentVO;

public class StudentController {
	public static final int CONTINUE = 1;
	public static final int BREAK = 0;
	
	//여러 학생 정보(동적 인원수)를 입력 받기 위해서
	ArrayList<String> names = new ArrayList<String>();
	ArrayList<Integer> stuIds = new ArrayList<Integer>();
	ArrayList<Integer> grades = new ArrayList<Integer>();
	ArrayList<String> majors = new ArrayList<String>();
	ArrayList<String> mobiles = new ArrayList<String>();
	
	//콘솔 창에서 입력받은 학생 정보를 사용하여 각각의 ArrayList를 저장해 둔다.
	public void consoleToList() {
		//콘솔에 입력 받기 위해 Scanner 생성
		Scanner s1 = new Scanner(System.in); //문자열 입력
		Scanner s2 = new Scanner(System.in); //정수 입력
		
		//flag : 콘솔 창에서 학생 정보를 입력 받을 때 계속 입력받을 것인지 멈출 것인지의 상태를 저장하는 변수
		int flag = CONTINUE;
		System.out.println("========== 학생 정보 ==========");
		while(true) {
			if(flag == CONTINUE) {
				System.out.print("성명 : ");
				names.add(s1.nextLine());
				System.out.print("학번 : ");
				stuIds.add(s2.nextInt());
				System.out.print("학년 : ");
				grades.add(s2.nextInt());
				System.out.print("전공 : ");
				majors.add(s1.nextLine());
				System.out.print("전화번호 : ");
				mobiles.add(s1.nextLine());	
			} else if(flag == BREAK){
				break;
			}//if
			
			//계속 입력할 것인지 멈출 것인지 확인
			System.out.print("계속 입력하시겠습니까?(네 : 1 / 아니요 : 0) : ");
			flag = s2.nextInt();
			System.out.println();
			
		}//while
		
		s1.close();
		s2.close();
	}
	
	//StudentVO객체를 생성하고 생성된 StudentVO객체를 StudentDAO 객체의 ArrayList에 저장한다.(insert() 사용)
	public void voToDAO(StudentDAO dao) {
		for (int i = 0; i < names.size(); i++) {
			StudentVO svo = new StudentVO(names.get(i), stuIds.get(i), grades.get(i), majors.get(i), mobiles.get(i));
			dao.insert(svo);
		};
	}

	public static void main(String[] args) {
		StudentController controller = new StudentController();
		
		//콘솔 창에서 입력 받은 값을 각각의 정보를 저장하는 ArrayList에 저장하는 메소드
		controller.consoleToList();
		
		//입력 받은 값들을 사용하여 StudentVO객체에 생성하는 DAO의 ArrayList에 저장하는 메소드
		StudentDAO dao = new StudentDAO();
		controller.voToDAO(dao);
		
		//화면에 출력
		StudentView sview = new StudentView();
		sview.view(dao.select());
	}

}