package netflix;

import java.util.ArrayList;

public class Manager {
	
	private ArrayList<Movie>arrayList = new ArrayList<>();

	public void addMovie(Movie m) {
		arrayList.add(m);
	}
	
	public ArrayList<Movie> getMovie() {
		return arrayList;
	}
	
	public ArrayList<Movie> searchMovie(String title) {
		ArrayList<Movie>result=new ArrayList<>();
		for(Movie m : arrayList) {
			if(m.getTitle().equalsIgnoreCase(title)) {
				result.add(m);
				break;
			}
		}
		return result;
	}
	
	
	
}
