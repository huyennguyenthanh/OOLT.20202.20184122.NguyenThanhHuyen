package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {

	private List<String> authors = new ArrayList<String>();

	public Book() {

	}

	public Book(String title) {
		super(title);
	}

	public Book(String title, String category, float cost) {
		super(title, category, cost);
	}

	public Book(String title, String category, float cost, ArrayList<String> authors) {
		super(title, category, cost);
		if (authors.size() != 0) {
			this.authors = authors;
		} else {
			System.out.println("Authors list is empty !");
		}
	}
	
	public void addAuthor(String authorName){
        if(!authors.contains(authorName)){
            authors.add(authorName);
        }
    }
    public void removeAuthor(String authorName){
        if(authors.contains(authorName)){
            authors.remove(authorName);
        }
    }

	public List<String> getAuthors() {
		return authors;
	}

	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}

	

}
