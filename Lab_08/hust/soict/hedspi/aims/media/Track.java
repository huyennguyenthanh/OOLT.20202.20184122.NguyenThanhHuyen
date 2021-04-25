package hust.soict.hedspi.aims.media;

public class Track implements Playable {
	private String title;
    int length;

    public Track(String title) {
        this.title = title;
    }

    public Track(int length) {
        this.length = length;
    }

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }
    public void play() {
        System.out.println("Playing Track: " + this.getTitle());
        System.out.println("Track length: " + this.getLength());
    }
    
    @Override
    public String toString(){
        return "Track "+this.getTitle() + " - "+ this.getLength() + "\n";

    }
    
    @Override 
	public boolean equals(Object o)
	{
		Track tmp = (Track) o;
		if (this.title.equals(tmp.title) && this.length == tmp.length)
			return true;
		return false;
		
	}

}
