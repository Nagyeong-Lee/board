
public class Exam_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Student[]stds=new Student[3];  //Student도 참조자료형임, 참조배열
		//student 인스턴스가 만들어진것이 아니라 주소 값을 갖는 변수가 만들어짐.?
		//객체 배열은 객체 생성해서 각각 인덱스에 넣어줘야함

		Student std = new Student(90,40,"Alex");

		Student[]stds=new Student[3]; //setter이용해서 초기화
		stds[0]=new Student();
		stds[0].setKor(50);
		stds[0].setEng(80);
		stds[0].setName("Tom");

		stds[1]=new Student(100,50,"Jane"); //생성자 이용해서 초기화

		stds[2]=std; //주소 공유해서 값 불러오기
		//		System.out.println(stds[2].getName());
		//		System.out.println(stds[2].getKor());
		//		System.out.println(stds[2].getEng());

		System.out.println("이름\t국어\t영어\t합계\t평균");
//		for(int i=0; i<stds.length; i++) {
//			System.out.println(stds[i].getName()+"\t"+stds[i].getKor()+"\t"+stds[i].getEng()+"\t"+(stds[i].getKor()+stds[i].getEng())+"\t"+(stds[i].getKor()+stds[i].getEng())/2.0);
//		}
		for(int i=0; i<stds.length; i++) {  //if stds[2]가 null이어도 stds.length는 배열의 길이라서 3임.
			System.out.println(stds[i].getName()+"\t"+stds[i].getKor()+"\t"+stds[i].getEng()+"\t"+stds[i].getSum()+"\t"+stds[i].getAverage());
		}
	}

}
