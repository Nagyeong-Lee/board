package netflix;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);

	public static String getString(String str) {  //문자열 입력
		while(true) {
			try {
				System.out.print(str);
				return sc.nextLine();
			}catch(Exception e) {
				System.out.println("문자열 입력");
			}
		}
	}

	public static void main(String[] args) {

		Manager manager = new Manager();

		while(true) {

			System.out.println("<<Netflix>>");
			System.out.println("1.영화 정보 등록");
			System.out.println("2.영화 정보 출력");
			System.out.println("3.영화 정보 검색");
			System.out.println("4.영화 정보 삭제");
			System.out.println("5.영화 정보 수정");
			System.out.println("6.프로그램 종료");
			System.out.print(">> ");
			int menu=Integer.parseInt(sc.nextLine());

			if(menu==1) {
				manager.addMovie(new Movie("헐크","액션",6.8,"X"));
				manager.addMovie(new Movie("탑건","액션",9.15,"O"));
				manager.addMovie(new Movie("컨저링","호러",7.1,"X"));
				manager.addMovie(new Movie("어벤저스","액션",9.5,"O"));
				manager.addMovie(new Movie("알라딘","애니매이션",8.7,"O"));
				System.out.println("영화 등록 완료");

			}else if(menu==2) {
				ArrayList<Movie>arr=manager.getMovie();
				System.out.println("제목\t장르\t평점\t추천");
				if(arr.size()==0) {
					System.out.println("출력할 정보가 없습니다.");
				}else {
					for(Movie m : arr) {
						System.out.println(m.getTitle()+"\t"+
								m.getGenre()+"\t"+
								m.getReview()+"\t"+
								m.getRecom());
					}
				}
			}else if(menu==3) {  
				String title=getString("제목 입력 : ");
				ArrayList<Movie>result=manager.searchMovie(title);
				if(result.size()==0) {
					System.out.println("출력할 정보가 없습니다.");
				}else {
					System.out.println("제목\t장르\t평점\t추천");
					for(Movie m : result) {
						System.out.println(m.getTitle()+"\t"+
								m.getGenre()+"\t"+
								m.getReview()+"\t"+
								m.getRecom());
					}
				}

			}else if(menu==4) {

			}else if(menu==5) {

			}else if(menu==6) {
				System.out.println("프로그램 종료");
				System.exit(0);
			}else {
				System.out.println("메뉴를 다시 입력해주세요");
			}
		}
	}

}
