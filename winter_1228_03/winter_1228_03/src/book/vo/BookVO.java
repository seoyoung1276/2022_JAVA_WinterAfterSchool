package book.vo;

public class BookVO {
   private int isbn;         //도서번호
   private String bookName;   //책 이름
   private String publish;   //출판사
   private String author;      //저자
   private int price;         //가격
   private String category;   //카테고리
   
   //생성자
   public BookVO() {
      
   }
   public BookVO(int isbn, String bookName, String publish, String author, int price, String category) {
      this.isbn = isbn;
      this.bookName = bookName;
      this.publish = publish;
      this.author = author;
      this.price = price;
      this.category = category;
   }//BookVO

   public int getIsbn() {
      return isbn;
   }
   public void setIsbn(int isbn) {
      this.isbn = isbn;
   }

   public String getBookName() {
      return bookName;
   }
   public void setBookName(String bookName) {
      this.bookName = bookName;
   }

   public String getPublish() {
      return publish;
   }
   public void setPublish(String publish) {
      this.publish = publish;
   }
   
   public String getAuthor() {
      return author;
   }
   public void setAuthor(String author) {
      this.author = author;
   }

   public int getPrice() {
      return price;
   }
   public void setPrice(int price) {
      this.price = price;
   }

   public String getCategory() {
      return category;
   }
   public void setCategory(String category) {
      this.category = category;
   }

   @Override
   public String toString() {
      return "BookVO [도서번호 = " + isbn + ", 책 이름 = " + bookName + ", 출판사 = " + publish + ", 가격 = " + price
            + ", 카테고리 = " + category + "]";
   }
   

}//class