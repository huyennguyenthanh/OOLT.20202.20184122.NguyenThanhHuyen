package hust.soict.hedspi.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Track;



public class TestMediaCompareTo {
    public static void main(String[] args) {
    	// DVD sort by title
        test1();
        // DVD sort by cost -> length -> title
        test2();
        // CD sort by number of track -> total length ->title
        test3();
        
    }
    
    
	public static void test1() {
		
		// Sort by Title
		Collection collection = new ArrayList();
		
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1,"Star Wars","Science Fiction",24.95f,"George Lucas",124);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc(2,"The Lion King","Animation",19.95f,"Roger Allers",87);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc(3,"Aladdin","Animation",18.99f,"John Musker",90);


        collection.add(dvd1);
        collection.add(dvd2);
        collection.add(dvd3);
        
        Iterator iterator = collection.iterator();

        System.out.println("----------------------------------");
        System.out.println("The DVDs currently in the order are: ");

        while(iterator.hasNext()) {
            System.out.println(((DigitalVideoDisc) iterator.next()).getTitle());
        }

        java.util.Collections.sort((List) collection);
        iterator = collection.iterator();
        System.out.println("----------------------------------");
        
        System.out.println("The DVDs in sorted order are: ");

        while(iterator.hasNext()) {
            System.out.println(((DigitalVideoDisc) iterator.next()).getTitle());
        }
        
        System.out.println("----------------------------------");
	}
	
	public static void test2() 
	{
		// Sort by cost, length and title
		Collection collection = new ArrayList();
		
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1,"Star Wars","",30f,"",124);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc(2,"The Lion King","",25f,"",87);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc(3,"Aladdin","",45f,"",90);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc(4,"Michia","",30f,"",23); // same cost
        DigitalVideoDisc dvd5 = new DigitalVideoDisc(5,"Hacker","",30f,"",124); // same length and cost


        collection.add(dvd1);
        collection.add(dvd2);
        collection.add(dvd3);
        collection.add(dvd4);
        collection.add(dvd5);
        
        Iterator iterator = collection.iterator();

        System.out.println("----------------------------------");
        System.out.println("The DVDs currently in the order are: ");

        while(iterator.hasNext()) {
            System.out.println(((DigitalVideoDisc) iterator.next()).getTitle());
        }

        java.util.Collections.sort((List) collection);
        iterator = collection.iterator();
        System.out.println("----------------------------------");
        
        System.out.println("The DVDs in sorted order are: ");

        while(iterator.hasNext()) {
            System.out.println(((DigitalVideoDisc) iterator.next()).getTitle());
        }
        
        System.out.println("----------------------------------");
	}
	
	public static void test3() {
		
		
		Collection collection = new ArrayList();
		
		
		CompactDisc cd1 = new CompactDisc(1, "Mamamia", "Rock",27f ,"Taylor");
		CompactDisc cd2 = new CompactDisc(2, "Sakura", "Jar",11f ,"Selena");
		CompactDisc cd3 = new CompactDisc(3, "Hanoi", "Jar",10f ,"Clamp");
		CompactDisc cd4 = new CompactDisc(4, "Quy Nhon", "Jar",45f ,"Luffy");
		
		Track t1 = new Track("abc", 10);
		Track t2 = new Track("abc", 20);
		Track t3 = new Track("def", 30);
		Track t4 = new Track("def", 10);
		Track t5 = new Track("lalala", 15);
		Track t6 = new Track("be you", 5);

		
		cd1.addTrack(t3);
		cd2.addTrack(t1 );
		cd2.addTrack(t4 ); // cd2 more tracks than cd1
		cd3.addTrack(t1); 
		cd3.addTrack(t2 );// same number of track then cd2, but longer length
		cd4.addTrack(t5);
		cd4.addTrack(t6); //same number tracks, same length, but difirent titlt then cd2
		
		
		collection.add(cd1);
        collection.add(cd2);
        collection.add(cd3);
        collection.add(cd4);
		
        Iterator iterator = collection.iterator();

        System.out.println("----------------------------------");
        System.out.println("The CDs currently in the order are: ");

        while(iterator.hasNext()) {
            System.out.println(((CompactDisc) iterator.next()).getTitle());
        }

        java.util.Collections.sort((List) collection);
        iterator = collection.iterator();
        System.out.println("----------------------------------");
        
        System.out.println("The CDs in sorted order are: ");

        while(iterator.hasNext()) {
            System.out.println(((CompactDisc) iterator.next()).getTitle());
        }
        
        System.out.println("----------------------------------");
	}


}
