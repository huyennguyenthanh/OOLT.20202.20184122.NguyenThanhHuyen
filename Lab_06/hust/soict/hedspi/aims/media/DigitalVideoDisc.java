package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Media {

	private String director;
	private int length;

	
	
	public DigitalVideoDisc(String title)
	{
		super(title);
	}
	public DigitalVideoDisc(String title, String category)
	{
		super(title,category);
	}
	public DigitalVideoDisc(String title, String category, String director)
	{
		super(title,category);
		this.director = director;
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost)
	{
		super(title,category, cost);
		this.director = director;
		this.length = length;
	}
	
	
	
	
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}

	private void remove(String [] s, int index)
	{
		for(int i = index; i < s.length -1; i++)
		{
		      s[i] = s[i+1];
		      }
	}
	public boolean searchTitle(String title)
	{
		String [] search_token = title.toLowerCase().split(" ");
		String [] title_token = super.getTitle().toLowerCase().split(" ");
		
		int n = 0;
		for (int i = 0; i < title_token.length; i++)
		{
			for(int j = 0; j < search_token.length; j++)
				if (title_token[i].equals(search_token[j]))
				{
					n += 1;
					remove(search_token, j);
					break;
				}
					
		}
		if (n == search_token.length)
			return true;
		
		return false;
	}
	
}
