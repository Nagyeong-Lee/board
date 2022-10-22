import java.util.ArrayList;

public class MovieArr {

	ArrayList arr = new ArrayList();
	
	public void storeMovies(Movie m) {
		arr.add(m);
	}
	
	public ArrayList getMovies() {
		return arr;
	}
	
}
