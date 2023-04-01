package info.view;

import java.util.ArrayList;
import info.vo.StudentVO;

//화면에 보여주기(출력) 위한 객체
public class StudentView {

// view(ArrayList<StudentVO> svoList): 화면에 출력을 위한 메소드
	public void view(ArrayList<StudentVO> svoList) {
		for (StudentVO svo : svoList) {
			System.out.println("==================");
			System.out.println("= 성명: " + svo.getName());
			System.out.println("= 학번: " + svo.getStuId());
			System.out.println("= ");
		}
	}
}
