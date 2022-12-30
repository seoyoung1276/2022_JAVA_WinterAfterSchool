package book.controller;


	import java.util.ArrayList;
	import java.util.Scanner;

	import book.vo.BookDAO;
	import book.vo.BookVO;
	import book.vo.BookView;
	
 public class bookinfoController {
		public static final int CONTINUE = 1;
		public static final int EXIT = 0;
	   ArrayList<BookVO> svoList = new ArrayList<BookVO>();
	 
	   
	    public void insert(BookVO svo) {
	      svoList.add(svo);
	   }
	    
	    public void view() {
	       //개선된(enhanced) for문
	       for(BookVO svo : svoList) {
	          System.out.print("책 이름 : " + svo.getBookName() + "\n");
	          System.out.print("도서번호 : " + svo.getIsbn() + "\n");
	          System.out.print("출판사 : " + svo.getPublish() + "\n");
	          System.out.print("저자 : " + svo.getAuthor() + "\n");
	          System.out.print("가격 : " + svo.getPrice() + "\n");
	          System.out.print("카테고리 : " + svo.getCategory() + "\n\n");
	       }
	    }

	   public static void main(String[] args) {
		   ArrayList<String> bookName = new ArrayList<String>();
		   ArrayList<Integer> isbn = new ArrayList<Integer>();
		   ArrayList<String> publish = new ArrayList<String>();
		   ArrayList<String> author = new ArrayList<String>();
		   ArrayList<Integer> price = new ArrayList<Integer>();
		   ArrayList<String> category = new ArrayList<String>();
		   
		   Scanner s1 = new Scanner(System.in);
		   Scanner s2 = new Scanner(System.in);
	      
		   int flag = CONTINUE;
		   System.out.println("=====     도서 정보 입력 화면     =====");
		   while (true) {
			   if(flag == CONTINUE) {
				   if(flag == CONTINUE) {
			            System.out.print("책 이름 : ");
			            bookName.add(s2.nextLine());
			            System.out.print("도서번호 : ");
			            isbn.add(s1.nextInt());
			            System.out.print("출판사 : ");
			            publish.add(s2.nextLine());
			            System.out.print("저자 : ");
			            author.add(s2.nextLine());
			            System.out.print("가격 : ");
			            price.add(s1.nextInt());
			            System.out.print("카테고리 : ");
			            category.add(s2.nextLine());   
			   }else if(flag == EXIT) {
				   break;
			   }
			   System.out.println("계속 입력하시겠습니까?(계속: 1, 종료:0) : ");
			   flag = s2.nextInt();
			   System.out.println("----------------------------------");
		     }
		   } 
			   
		   BookDAO dao = new BookDAO();
	      
	      for(int i = 0; i < bookName.size(); i++) {
	        BookVO svo = new BookVO();
	        dao.insert(svo);
	      }
	      
	      BookView bookView = new BookView();
	      bookView.view(dao.select());
	      
	      s1.close();
	      s2.close();
	   }//main

	}//class
