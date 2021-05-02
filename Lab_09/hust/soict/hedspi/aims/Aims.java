package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.order.Order;

import java.util.Scanner;

public class Aims {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int check_case1 = 0;
		Order anOrder = null;
		while (true) {
			Menu();
			
			int n = Integer.parseInt(sc.nextLine());
			switch (n) {
			case 1:
				anOrder = new Order(1);
				System.out.println("Create successfully");
				check_case1 = 1;
				break;
			case 2:
				if (check_case1 == 0) {
					System.out.println("Please create new order before add anything! ");
					break;
				}
				MenuMedia();
				String n1 = sc.nextLine();
				switch (n1) {
				case "1":
					addBookToOrder(anOrder, sc);
					break;
				case "2":
					addDvdToOrder(anOrder, sc);
					break;
				case "3":
					addCdToOrder(anOrder, sc);
					break;
				case "0":
					System.out.println("Exit menuMedia.");
					break;
				default:
					System.out.println("Not provide this service. Exit.");
					break;
				}
				break;
			case 3:
				if(check_case1 == 0) {
                    System.err.println("The Media list is null.");
                    break;
                }
                System.out.println("Enter id that you want to delete: ");
                int id = Integer.parseInt(sc.nextLine());
                if(anOrder.searchById(id)==null)
                    System.out.println("Id not found !");
                else {
                	Media media = anOrder.searchById(id);
                    anOrder.removeMedia(media);
                    System.out.println("Deleted successfully.");
                }
                break;
			case 4:
                if(check_case1 == 0) {
                    System.err.println("The Media list is null.");
                    break;
                }
                System.out.println("The items list of order");
                anOrder.printListOrder();
				break;
			case 0:
				sc.close();
				System.out.println("Quit.");
				return;
			default:
				System.err.println("Please enter a service in menu.");
				break;
			}
		}
	}

	public static void Menu() {
		System.out.println("_______MENU______________");
		System.out.println("1. Create new order");
		System.out.println("2. Add item to the order");
		System.out.println("3. Delete item by id");
		System.out.println("4. Print order");
		System.out.println("0. Exit");
		
		System.out.print("You choose: ");
	}

	public static void MenuMedia() {
		System.out.println("______MENU_MEDIA_______________");
		System.out.println("1. Book");
		System.out.println("2. DVD");
		System.out.println("3. CD");
		System.out.println("0. Exit");
	}

	private static void addBookToOrder(Order anOrder, Scanner sc) {
		int id;
		do {
			System.out.printf("Input id: ");
			id = Integer.parseInt(sc.nextLine());
			if (anOrder.searchById(id) != null) {
				System.out.println("This id is already exists. Please enter again");
			}
		} while (anOrder.searchById(id) != null);
		
		System.out.printf("Input title: ");
		String title = sc.nextLine();
		System.out.printf("Input category: ");
		String category = sc.nextLine();
		System.out.printf("Input cost: ");
		float cost = Float.parseFloat(sc.nextLine());
		
		Book book = new Book(id, title, category, cost);
		
		int numberOfAuthors = 0;
		do {
			System.out.printf("Input numbers of authors: ");
			numberOfAuthors = Integer.parseInt(sc.nextLine());
			if (numberOfAuthors <= 0)
				System.err.println("Numbers of authors must have >= 0. Please enter again");
		} while (numberOfAuthors <= 0);
		for (int i = 0; i < numberOfAuthors; i++) {
			System.out.printf("Enter author's name: ");
			String author = sc.nextLine();
			book.addAuthor(author);
		}
		anOrder.addMedia(book);
	}

    private static void addDvdToOrder(Order anOrder, Scanner sc) {
    	
		int id;
		do {
			System.out.printf("Input id: ");
			id = Integer.parseInt(sc.nextLine());
			if (anOrder.searchById(id) != null) {
				System.out.println("This id is already exists. Please enter again");
			}
		} while (anOrder.searchById(id) != null);
		
		System.out.printf("Input title: ");
		String title = sc.nextLine();
		System.out.printf("Input category: ");
		String category = sc.nextLine();
		System.out.printf("Input cost: ");
		float cost = Float.parseFloat(sc.nextLine());
       
        System.out.printf("Input director: ");
        String director = sc.nextLine();

        System.out.printf("Input length: ");
        int length = Integer.parseInt(sc.nextLine());

        DigitalVideoDisc dvd = new DigitalVideoDisc(id, title, category,  cost, director, length);

        anOrder.addMedia(dvd);
    }
    
    private static void addCdToOrder(Order anOrder,Scanner sc) {    	
    	
		int id;
		do {
			System.out.printf("Input id: ");
			id = Integer.parseInt(sc.nextLine());
			if (anOrder.searchById(id) != null) {
				System.out.println("This id is already exists. Please enter again");
			}
		} while (anOrder.searchById(id) != null);
		
		System.out.printf("Input title: ");
		String title = sc.nextLine();
		System.out.printf("Input category: ");
		String category = sc.nextLine();
		System.out.printf("Input cost: ");
		float cost = Float.parseFloat(sc.nextLine());

        System.out.printf("Input artist: ");
        String artist = sc.nextLine();


        int count;
		do {
			System.out.printf("Input numbers of list Track: ");
			count= Integer.parseInt(sc.nextLine());
			if (count <= 0) {
				System.err.println("Numbers of authors must have >= 0. Please enter again");
			}
		} while (count <= 0);

		CompactDisc cd = new CompactDisc(id, title, category, cost,  artist);
        Track track = null;
        String titleTrack;
        int lengthTrack;
        for(int i = 0; i < count; i++) {
            System.out.println("Input Track number " + (i+1));
            System.out.printf("Enter title of track: ");
            titleTrack = sc.nextLine();
            System.out.printf("Enter length track: ");
            lengthTrack = Integer.parseInt(sc.nextLine());
            track = new Track(titleTrack, lengthTrack);
            cd.addTrack(track);
            
        }
        String choice;
        do {
            System.out.printf("Do you want to play ? (yes|no): ");
            choice = sc.nextLine();
            switch (choice) {
                case "yes":
                        cd.play();
                    break;
                case "no":
                    break;
                default:
                    System.err.println("Just yes or no.");
            }
        } while (!choice.equals("no"));
        
        anOrder.addMedia(cd);
    }

}
