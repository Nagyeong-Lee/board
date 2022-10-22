
public class Student { //Student 참조자료형

	private int kor;
	private int eng;
	private  String name;
	

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getSum() {
		return this.kor+this.eng;
	}
	public double getAverage() {
		return this.getSum()/2.0;
	}

	
	public Student() {

	}  //기본 생성자 무조건 만들기 //생성자 단축기 alt shift s o 엔터

	public Student(int kor, int eng, String name) {

		this.kor = kor;
		this.eng = eng;
		this.name = name;
	}
	
}
