import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static int getInt(String str) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			try {
				System.out.print(str);
				return Integer.parseInt(sc.nextLine());
			}catch(Exception e) {
				System.out.println("숫자를 입력하세요");
			}
		}
	}

	public static double getDouble(String str) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			try {
				System.out.print(str);
				return Double.parseDouble(sc.nextLine());
			}catch(Exception e) {
				System.out.println("평점 실수로 입력");
			}
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		MovieArr movieArr=new MovieArr();
		ArrayList movie=movieArr.getMovies();
		while(true) {
			System.out.println("<< Netflix 영화 프로그램 >>");
			System.out.println("1. 신규 영화 등록");
			System.out.println("2. 영화 목록 출력");
			System.out.println("3. 영화 검색 (제목)");
			System.out.println("4. 프로그램 종료");
			int menu=Main.getInt(">> ");

			if(menu==1) {
				System.out.print("영화 제목 : ");
				String title=sc.nextLine();

				System.out.print("영화 장르 : ");
				String genre=sc.nextLine();

				double review=Main.getDouble("영화 평점 : ");

				Movie m = new Movie(title,genre,review);
				movieArr.storeMovies(m);

			}else if(menu==2) {
				System.out.println("영화\t장르\t평점");
				Movie mm = new Movie();
				for(int i=0; i<movie.size(); i++  ) {
					System.out.println(((Movie)movie.get(i)).getTitle()+"\t"+
							((Movie)movie.get(i)).getGenre()+"\t"+
							((Movie)movie.get(i)).getReview()+"\t");
				}

			}else if(menu==3) {
				System.out.print("검색할 영화의 제목 : ");
				String searchMovie=sc.nextLine();

				boolean notFound=true;

				for(int i=0; i<movie.size(); i++  ) {
					if(searchMovie.equals(((Movie)movie.get(i)).getTitle())){
						System.out.println("영화\t장르\t평점");
						System.out.println(((Movie)movie.get(i)).getTitle()+"\t"+
								((Movie)movie.get(i)).getGenre()+"\t"+
								((Movie)movie.get(i)).getReview()+"\t");
						notFound=false;
					}
				}
				if(notFound) {
					System.out.println(searchMovie+"는 없습니다.");
				}

			}else if(menu==4) {
				System.out.println("프로그램 종료");
				System.exit(0);
			}else {
				System.out.println("메뉴를 다시 선택해주세요");
			}
		}
	}
}

