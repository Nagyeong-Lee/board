import java.util.Scanner;

//import java.util.Scanner;
//
//public class Quiz_02 {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//		/*넷플릭스예제
//		 * 배열 크기 10
//		 * 1.신규영화등록
//		 * 2.영화목록출력
//		 * 3.영화검색 (제목으로 검색)
//		 * 4.프로그램 종료
//		 * 선택 >> 
//		 * 
//		 * 1번 선택시
//		 * 영화 제목,장르,평점을 입력받아 저장소에 저장 (클래스이름/배열이름은 알아서)
//		 * 
//		 * 2번 선탟;
//		 * 배열에 저장되어있는 모든 영화 정보를 제목/장르/평점 순으로 출력
//		 * 배열에 한명의 정보도 저장되어 있지 않을 시 출력할 내용이 없습니다.라고 안내
//		 * 
//		 * 3번 선택시
//		 * 검색할 영화를 입력받아 검색된 대상만의 제목/장르/평점만 출력
//		 * 검색대상이없다면 찾을수없습니다 출력
//		 */
//
//
//		Scanner sc = new Scanner(System.in);
//		Movie[]nf=new Movie[10];
//
//		 while(true) {
//			System.out.println("1.신규영화등록");
//			System.out.println("2.영화목록출력");
//			System.out.println("3.영화검색");
//			System.out.println("4.프로그램 종료");
//			System.out.print("선택 >> ");
//			int menu = Integer.parseInt(sc.nextLine());
//
//			if(menu==1) {
//				for(int i=0; i<nf.length; i++) {
//					System.out.println((i+1)+"번째 영화");
//					//					nf[i]=new Netflix(sc.nextLine(),sc.nextLine(),Double.parseDouble(sc.nextLine()));
//					nf[i]=new Movie();
//					nf[i].setTitle(sc.nextLine());
//					nf[i].setGenre(sc.nextLine());
//					nf[i].setReview(Double.parseDouble(sc.nextLine()));
//				}
//			}else if(menu==2) {
//				System.out.println("제목\t장르\t평점");
//				for(int i=0; i<nf.length; i++) {
//					if(nf[i]==null) {
//						System.out.println("출력할 내용이 없습니다.");
//						break;
//					}else {
//						System.out.println(nf[i].getTitle()+"\t"+nf[i].getGenre()+"\t"+nf[i].getReview());
//					}
//				}
//
//			}else if(menu==3) {
//
//				String searchMovie=sc.nextLine();
//
//				boolean notFound=true;
//				for(int i=0; i<nf.length; i++) {
//					if(searchMovie.equals(nf[i].getTitle())) {
//						System.out.println(nf[i].getTitle()+"\t"+nf[i].getGenre()+"\t"+nf[i].getReview());
//						notFound=false;
//
//					}
//				}if(notFound) {
//					System.out.println("찾을 수 없습니다.");
//
//				}
//			}
//
//
//			else if(menu==4) {
//				System.out.println("프로그램을 종료합니다.");
//				System.exit(0);
//
//			}
//		}
//	}
//}
//
//
//

public class Quiz_02 {
  public static int getValidNum(String ui) {
     Scanner sc = new Scanner(System.in);
     while(true) {
        try {
           System.out.print(ui);
           return Integer.parseInt(sc.nextLine());
        }catch(Exception e) {
           System.out.println("숫자를 입력해야 합니다.");
        }
     }
  }
  public static double getValidDouble(String ui) {
     Scanner sc = new Scanner(System.in);
     while(true) {
        try {
           System.out.print(ui);
           return Double.parseDouble(sc.nextLine());
        }catch(Exception e) {
           System.out.println("숫자를 입력해야 합니다.");
        }
     }
  }
 
  public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     Movie[] movies = new Movie[10];
     int index = 0;
     
     while(true) {
        System.out.println("<< Netflix 영화 프로그램 >>");
        System.out.println("1. 신규 영화 등록");
        System.out.println("2. 영화 목록 출력");
        System.out.println("3. 영화 검색 (제목)");
        System.out.println("4. 프로그램 종료");
        int menu = getValidNum(">> ");
       
        if(menu == 1) {
           
           System.out.print("영화 제목 : ");
           String title = sc.nextLine();
           
           System.out.print("영화 장르 : ");
           String genre = sc.nextLine();
           
           double score = getValidDouble("영화 평점 : ");
           
           Movie mov = new Movie(title,genre,score);
           movies[index++] = mov;
           
        }else if(menu == 2) {
           System.out.println("제목\t장르\t평점");
           for(int i = 0;i < index;i++) {
              System.out.println(movies[i].getTitle()+"\t"+
                             movies[i].getGenre()+"\t"+
                             movies[i].getReview());      
           }
        }else if(menu == 3) {
           System.out.print("검색할 영화의 제목 : ");
           String title = sc.nextLine();
           
           boolean notFound = true;
           for(int i = 0;i < index;i++) {
              if(movies[i].getTitle().equals(title)) {
                 System.out.println(movies[i].getTitle()+"\t"+
                       movies[i].getGenre()+"\t"+
                       movies[i].getReview());
                 notFound = false;
              }
           }
           if(notFound) {System.out.println("\"" + title + "\" 영화를 찾지 못했습니다.");}
           
           
        }else if(menu == 4) {
           System.out.println("프로그램을 종료합니다.");
           System.exit(0);
        }else {
           System.out.println("메뉴를 다시 확인해주세요.");
        }
     }
  }
}
