package book.vo;

import java.util.ArrayList;

import book.vo.BookVO;

public class BookView {
	  ArrayList<BookVO> svoList = new ArrayList<BookVO>();
	   
	   public void view(ArrayList<BookVO> svoList) {
	       //개선된(enhanced) for문
	       for(BookVO svo : svoList) {
	          System.out.print("책 이름:" + svo.getBookName() + "\t"); //변수명 소문자여도 대문자로 안하며 못 알아 처먹음 병신새끼
	          System.out.print("도서번호:" + svo.getIsbn() + "\t");
	          System.out.print("출판사:" + svo.getPublish() + "\t");
	          System.out.print("저자:" + svo.getAuthor() + "\t");
	          System.out.print("가격:" + svo.getPrice() + "\t");
	          System.out.print("카테고리:" + svo.getCategory() + "\n");
	       }
	    }
	   
	   public ArrayList<BookVO> select() {
	      return svoList;
	   }
}
