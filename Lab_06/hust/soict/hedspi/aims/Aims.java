package hust.soict.hedspi.aims;

import java.util.ArrayList;
import java.util.List;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.order.*;


public class Aims {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Order anOrder1 = new Order();

		
		Book b1 = new Book("The Lion King");
		
		b1.setCategory("Animation");
		b1.setCost(19.95f);
		List<String> tmp = new ArrayList();
		tmp.add("Roger Allers");
		b1.setAuthors(tmp);
		
		anOrder1.addMedia(b1);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Start War", "Science Fiction");
		dvd2.setCost(24.95f);
		dvd2.setDirector("George Lucas");
		dvd2.setLength(124);
		
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Alladin", "Animation", "John Musker", 90, 18.99f);
		
		
		anOrder1.addMedia(b1);
		anOrder1.addMedia(dvd2);
		anOrder1.addMedia(dvd3);
		anOrder1.removeMedia(dvd2);
		System.out.println("After remove : ");
		anOrder1.printListOrder();

		anOrder1.printListOrder();

		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Harry and Potter and the Secret Room");
		System.out.println(dvd4.searchTitle("Potter Harry"));

		
		Media dvdLucky =  anOrder1.getLuckyItem();
		System.out.println("The lucky item is : " + dvdLucky.getTitle());
		anOrder1.printListOrder();
		
		
	}

}
