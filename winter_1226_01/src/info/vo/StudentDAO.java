package info.vo;

import java.util.ArrayList;

public class StudentDAO {
   ArrayList<StudentVO> svoList = new ArrayList<StudentVO>();
   
   public void insert(StudentVO svo) {
      svoList.add(svo);
   }//void
   
   public ArrayList<StudentVO> select() {
      return svoList;
   }
}