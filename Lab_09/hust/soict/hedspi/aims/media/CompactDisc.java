package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Media  {
	private String artist;
    private List<Track> tracks = new ArrayList<Track>();

    public CompactDisc(String artist, List<Track> tracks) {
        this.artist = artist;
        this.tracks = tracks;
    }

    public CompactDisc(int id, String title, String artist, List<Track> tracks) {
        super(id, title);
        this.artist = artist;
        this.tracks = tracks;
    }

    public CompactDisc(int id, String title, String category, String artist, List<Track> tracks) {
        super(id, title, category);
        this.artist = artist;
        this.tracks = tracks;
    }

    public CompactDisc(int id, String title, String category, float cost, String artist, List<Track> tracks) {
        super(id, title, category, cost);
        this.artist = artist;
        this.tracks = tracks;
    }
    public CompactDisc(int id, String title, String category, float cost, String artist) {
        super(id, title, category, cost);
        this.artist = artist;
    }

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public List<Track> getTracks() {
		return tracks;
	}

	public void setTracks(List<Track> tracks) {
		this.tracks = tracks;
	}
	
	public void addTrack(Track track){
		if(!tracks.contains(track)){
            tracks.add(track);
        }
        else {
			System.out.print("This track already exists. Can't add");
		}
//        int check = 0;
//        for(Track t : tracks){
//            if(t.getTitle().equals(track.getTitle()) && t.getLength() == track.getLength()){
//                check = 1;
//                break;
//            }
//        }
//        if(check == 0)
//            tracks.add(track);
//        else
//            System.out.println("This track already exists.");
    }
	public void removeTrack(Track track){
        if(tracks.contains(track)){
            tracks.remove(track);
        }
        else {
        	System.out.print("This track not exist.");
        }
    }
	public int getLength(){
        int sum = 0 ;
        for(Track t : tracks){
            sum += t.getLength();
        }
        return sum;
    }

    public void play() {
        for(Track t : tracks){
            t.play();
        }
    }
    @Override
    public String toString(){
    	String s = "";
        s += "CompactDisc - "+super.getTitle()+" - "+super.getCategory()+" - "+this.getArtist()+" - "+this.getLength()+"s : "+super.getCost()+" $\n";
        s += "Tracks in Disc: \n";
        for(Track t : this.tracks){
            s += t.toString();
        }
        return s;
    }
    public int compareTo(Object o)
	{
		// sort DVDs by cost or length, rather than title
		CompactDisc tmp = (CompactDisc) o;
		if (this.getTracks().size() != tmp.getTracks().size())
    	{
    		return this.getTracks().size() - tmp.getTracks().size();
    	}
    	else
        	if (this.getLength() != tmp.getLength())
        	{
        		return this.getLength()-tmp.getLength();
        	}
		
        	else
        		return super.compareTo(o);
	}
    

    
}
