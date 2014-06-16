package com.luckypants.books;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import com.luckypants.model.Book;



public class readfromfile {
	public static void main(String[] args) {
		 
		readfromfile obj = new readfromfile();
		obj.readCsvFile();
	
}
	public ArrayList<Book> readCsvFile() {
		 
		String csvFile = "D:/New folder/samplefile.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		String[] title = null;
		String[] author= null;
		String[] authorid= null;
		String[] Isbn= null;
		String[] genres= null;
		ArrayList<Book> b = null;
	 
		try {
				b=new ArrayList<Book>();
			br = new BufferedReader(new FileReader(csvFile));
			while((line = br.readLine()) != null) {
				String[] book_data = line.split(cvsSplitBy);String stitle='"'+"title"+ '"'+":";
				String sauthor='"'+"author"+ '"'+":";
				String sauthorid='"'+"_author_id"+ '"'+":";
				String sISBN='"'+"ISBN"+ '"'+":";
				String sgenres='"'+"genres"+ '"'+":";
				
				for(int i=0;i<book_data.length; i++){
					switch(i){
					case 0: title=book_data[i].split(stitle);
							break;
					case 1: author=book_data[i].split(sauthor);
							break;
					case 2: authorid=book_data[i].split(sauthorid);
							break;
					case 3: Isbn=book_data[i].split(sISBN);
							break;
					case 4: genres=book_data[i].split(sgenres);
							break;
					
					}
				}
				Book b1= new Book();
				b1.setTitle(title[1]);
		
				b1.setAuthor(author[1]);
				b1.set_author_id(authorid[1]);
				b1.setISBN(Isbn[1]);
				String gen="";
				for(String s: genres){
					gen=gen+s;
				}
				b1.setGenres(gen);
				b.add(b1);
	 
			}
		
	 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return b;
		
	  }
	

}
