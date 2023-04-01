package test.program;

import java.util.ArrayList;

//Data Access Object
public class TestDAO {
//   ArrayList: 학생정보객체(StudentVO)들을 저장하기 위해
   ArrayList<TestVO> svoList = new ArrayList<TestVO>();

//   insert: ArrayList에 학생정보객체(StudentVO)를 추가하는 메소드
   public void insert(TestVO svo) {
      svoList.add(svo);
   }
   
//   select: 전체 학생정보객체들을 반환하는 메소드
   public ArrayList<TestVO> select(){
      return svoList;
   }
   
}