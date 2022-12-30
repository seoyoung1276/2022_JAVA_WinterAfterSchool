package book.vo;

import java.util.ArrayList;

import book.vo.BookVO;

public class BookDAO {
	ArrayList<BookVO> svoList = new ArrayList<BookVO>();
	   
	   public void insert(BookVO svo) {
	      svoList.add(svo);
	   }//void
	   
	   public ArrayList<BookVO> select() {
	      return svoList;
	   }
}
