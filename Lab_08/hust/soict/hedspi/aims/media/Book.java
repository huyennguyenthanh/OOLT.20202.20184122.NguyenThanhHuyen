package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Book extends Media {

	private List<String> authors = new ArrayList<String>();

	
	 private String content;
	public List<String>contentTokens =  new ArrayList<String>();
    public Map<String, Integer> wordFrequency = new TreeMap<String, Integer>();
    
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
	public Book(int id, String title, String category, float cost, ArrayList<String> authors, String content) {
        super(id, title, category, cost);
        if(authors.size() != 0) {
            this.authors = authors;
            this.content = content;
        }else {
            System.out.println("Authors list is empty !");
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
	
//	@Override
//    public void printInfo(){
//        System.out.println("Book - "+super.getTitle()+" - "+super.getCategory()+" - Author : "+authors.toString()+" - "+super.getCost()+" $");
//    }
	@Override
    public String toString() {
        String string = "";
        string += "Id: " + super.getId() + " - ";
        string += "Title: "	+ super.getTitle() + " - ";
        string += "Category: " + super.getCategory() + " - ";
        string += "Cost: " + super.getCost()+ " - ";
        string += "Author: " + getAuthors()+ " \n";
        string += "Number of tokens: " + contentTokens.size() + "\n";
        string += "Work frequency: \n";
        for(Map.Entry<String, Integer> entry: wordFrequency.entrySet()) {
            string += entry.getKey() + " - "+ entry.getValue() + "\n";
        }
        return string;
    }
	
	public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        processContent();
    }
    private void processContent() {
    	
    	// split the content to tokens by spaces or punctuation
    	// then sort these tokens from a à z 
    	
    	content = content.replaceAll("[^a-zA-Z ]", "").toLowerCase();
        contentTokens.addAll(Arrays.asList(content.split("\\s+")));
        Collections.sort(contentTokens);
        
        //Count the frequency of each token
        
        java.util.Iterator<String> iterator = contentTokens.iterator();
        while(iterator.hasNext()) {
            String string = iterator.next();
            if (wordFrequency.containsKey(string) == false) {
                wordFrequency.put(string, 1);
            }else {
                int numOfToken = wordFrequency.get(string);
                numOfToken++;
                wordFrequency.put(string, numOfToken);
            }
        }
    }



}
