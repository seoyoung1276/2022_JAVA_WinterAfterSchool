package bookView;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import book.vo.BookVO;

public class bookView2 extends JPanel{
   JTable table;
   DefaultTableModel model;
   ArrayList<BookVO> bookVOList;
   String[] header = {"도서번호", "도서명", "출판사", "저자명", "도서가격", "카테고리"};
   String[] categoryNames = {"IT도서", "소설", "비소설", "수필", "경제", "사회"};
   JPanel panS;
   JComboBox<String> categoryCombo;
   JLabel[] jl = new JLabel[header.length];
   JTextField[] jtf = new JTextField[header.length-1];
   JButton jbAdd = new JButton("도서추가");
   
   public bookView2() {
      setLayout(new BorderLayout());
      
      categoryCombo = new JComboBox<String>(categoryNames);
      
      panS = new JPanel();
      panS = new JPanel(new GridLayout(4, 4));
      
      for(int i = 0; i < header.length; i++) {
         jl[i] = new JLabel(header[i]);
         panS.add(jl[i]);
         if(i < header.length-1) {
            jtf[i] = new JTextField();
            panS.add(jtf[i]);
         } else {
            panS.add(categoryCombo);
         }//if
      }//for
      
      for(int i = 0; i < 3; i++) {
         panS.add(new JLabel("  "));
      }
      panS.add(jbAdd);
      
   }
   
   public void initView() {
      model = new DefaultTableModel(header, bookVOList.size()) {
         @Override
         public boolean isCellEditable(int row, int column) {
            return false;
         }
          
      };
      table = new JTable(model);
      table.getColumnModel().getColumn(0).setPreferredWidth(50);
      table.getColumnModel().getColumn(1).setPreferredWidth(200);
      table.getColumnModel().getColumn(2).setPreferredWidth(100);
      table.getColumnModel().getColumn(4).setPreferredWidth(50);
      table.getColumnModel().getColumn(5).setPreferredWidth(50);
      
      JScrollPane js = new JScrollPane(table);
      
      putResult();
      
      add("Center", js);
      add("South", panS);
   }

   //DefaultTableModel에 도서정보를 설정한다.
   public void putResult() {
      //model의 행 개수 설정
      model.setRowCount(bookVOList.size());
      BookVO vo = null;
      for(int i = 0; i < bookVOList.size(); i++) {
         vo = bookVOList.get(i);
         
         // i:행 번호 / 0:열 번호
         model.setValueAt(vo.getIsbn(), i, 0);
         model.setValueAt(vo.getBookName(), i, 1);
         model.setValueAt(vo.getPublish(), i, 2);
         model.setValueAt(vo.getAuthor(), i, 3);
         model.setValueAt(vo.getPrice(), i, 4);
         model.setValueAt(vo.getCategory(), i, 5);
         
      }//for
      
   }//put

   public void setBookVOList(ArrayList<BookVO> bookVOList) {
      this.bookVOList = bookVOList;
   }//set

   public JButton getJbAdd() {
      return jbAdd;
   }//get
   
   public BookVO neededInsertData() {
      BookVO vo = new BookVO();
      vo.setIsbn(Integer.parseInt(jtf[0].getText()));
      vo.setBookName(jtf[1].getText());
      vo.setPublish(jtf[2].getText());
      vo.setAuthor(jtf[3].getText());
      vo.setPrice(Integer.parseInt(jtf[4].getText()));
      vo.setCategory((String)categoryCombo.getSelectedItem());
      return vo;
   }
   
   public void initInsertData() {
      for(int i = 0; i < jtf.length; i++) {
         jtf[i].setText("");
      }//for
      categoryCombo.setSelectedIndex(0);
   }

}//class