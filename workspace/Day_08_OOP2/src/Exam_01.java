
public class Exam_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//변수 - 배열 - 구조체 -> 클래스


		//		String[]name= {"tom"};
		//		int[]score= {50,80};

		Student std1= new Student(50,80,"Tom");//배열로 쓰는것보다 클래스로 만드는게 좋음
		
		Student std2 = new Student(100,50,"Jane");
		
		Student std3 = new Student(90,40,"Alex");
		System.out.println("이름\t국어\t영어");
		System.out.println(std1.getName() + "\t"+std1.getKor()+"\t"+std1.getEng());
		System.out.println(std2.getName() + "\t"+std2.getKor()+"\t"+std2.getEng());
		System.out.println(std3.getName() + "\t"+std3.getKor()+"\t"+std3.getEng());
	}

}
