
public class Movie {

	private String title;
	private String genre;
	private double review;


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public double getReview() {
		return review;
	}

	public void setReview(double review) {
		this.review = review;
	}

	
	public Movie(String title, String genre, double review) {

		this.title = title;
		this.genre = genre;
		this.review = review;
//		System.out.println("영화 제목 : "+this.title);
//		System.out.println("영화 장르 : "+this.genre);
//		System.out.println("영화 평점 : "+this.review);
	}

	public Movie() {

	}

}
