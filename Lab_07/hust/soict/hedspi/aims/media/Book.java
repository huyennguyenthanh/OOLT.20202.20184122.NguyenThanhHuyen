package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {

	private List<String> authors = new ArrayList<String>();

	public Book() {

	}

	public Book(int id,String title) {
		super(id,title);
	}

	public Book(int id,String title, String category, float cost) {
		super(id,title, category, cost);
	}

	public Book(int id,String title, String category, float cost, ArrayList<String> authors) {
		super(id,title, category, cost);
		if (authors.size() != 0) {
			this.authors = authors;
		} else {
			System.out.println("Error. Authors list is empty.");
		}
	}
	
	public void addAuthor(String authorName){
        if(!authors.contains(authorName)){
            authors.add(authorName);
        }
        else {
			System.out.print("This book already existed. Can't add.");
		}
    }
    public void removeAuthor(String authorName){
        if(authors.contains(authorName)){
            authors.remove(authorName);
        }
        else {
        	System.out.print("This book not exist.");
        }
    }

	public List<String> getAuthors() {
		return authors;
	}

	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}
	
	@Override
    public void printInfo(){
        System.out.println("Book - "+super.getTitle()+" - "+super.getCategory()+" - Author : "+authors.toString()+" - "+super.getCost()+" $");
    }

	

}
