import java.util.Scanner;

public class Quiz_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//3명 학생의 이름/국어/영어를 입력받아 합계/평균내기
		Scanner sc = new Scanner(System.in);
		String[]name=new String[3];
		int[]kor=new int[3];
		int[]eng=new int[3];

		/* 숫자 고정
		 * final int PEOPLE=3;
		 * String[]name=new String[PEOPLE];
		   int[]kor=new int[PEOPLE];
		   int[]eng=new int[PEOPLE];
		 */

		for(int i=0; i<name.length; i++) {
			System.out.print((i+1)+"번째 학생 이름 : ");
			name[i]=sc.nextLine();
			System.out.print(name[i]+" 학생 국어 : ");
			kor[i]=sc.nextInt();
			System.out.print(name[i]+" 학생 영어 : ");
			eng[i]=sc.nextInt();
			sc.nextLine();
		}
		System.out.println("이름\t국어\t영어\t합계\t평균");

		for(int i=0; i<name.length; i++) {
			int result=kor[i]+eng[i];
			System.out.println(name[i]+'\t'+kor[i]+'\t'+eng[i]+'\t'+(kor[i]+eng[i])+'\t'+(result/2.0));
		}
		//System.out.println("이름\t국어\t영어\t합계\t평균"); //\t
		//	for(int i=0; i<name.length; i++) {
		//		double result=kor[i]+eng[i];
		//		System.out.println(name[i]+\t+kor[i]+\t+eng[i]+\t+(kor[i]+eng[i])+\t+(result/2.0));
		//	}
	}

}
