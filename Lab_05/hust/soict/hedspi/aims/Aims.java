package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.disc.*;
import hust.soict.hedspi.aims.order.*;


public class Aims {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Order anOrder1 = new Order();
		Order anOrder2 = new Order();
		Order anOrder3 = new Order();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King");
		
		dvd1.setCategory("Animation");
		dvd1.setCost(19.95f);
		dvd1.setDirector("Roger Allers");
		dvd1.setLength(87);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Start War", "Science Fiction");
		dvd2.setCost(24.95f);
		dvd2.setDirector("George Lucas");
		dvd2.setLength(124);
		
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Alladin", "Animation", "John Musker", 90, 18.99f);
		
		anOrder1.addDigitalVideoDisc(dvd1);
		anOrder1.addDigitalVideoDisc(dvd2);
		anOrder2.addDigitalVideoDisc(dvd1);
		anOrder2.addDigitalVideoDisc(dvd3);
		anOrder3.addDigitalVideoDisc(dvd3);

		
		
		
//		anOrder1.removeDigitalVideoDisc(dvd2);
//		System.out.println("After remove : ");
//		anOrder1.printListOrder();
//			
//		
		anOrder1.addDigitalVideoDisc(dvd1,dvd2,dvd3);
		// anOrder2.addDigitalVideoDisc(dvd1,dvd3, dvd2, dvd2);
//		
//		

//		anOrder2.printListOrder();
//		anOrder3.printListOrder();
		
		
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Harry and Potter and the Secret Room");
		System.out.println(dvd4.searchTitle("Potter Harry"));

		
		DigitalVideoDisc dvdLucky =  anOrder1.getLuckyItem();
		System.out.println("The lucky item is : " + dvdLucky.getTitle());
		anOrder1.printListOrder();
		
		
	}

}
