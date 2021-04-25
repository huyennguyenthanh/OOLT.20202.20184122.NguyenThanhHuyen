package hust.soict.hedspi.test;

import hust.soict.hedspi.aims.media.Book;
public class BookTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Book b = new Book(1,"Information Technology","Article",50.00f);
		b.setContent("The most basic information technology definition is that it's the application of technology to solve business or organizational problems on a broad scale. No matter the role, a member of an IT department works with others to solve technology problems, both big and small.");
		System.out.println(b.toString());
	}

	
}

