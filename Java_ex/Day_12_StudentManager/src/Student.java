
public class Student {

	private int id;
	private String name;
	private int kor;
	private int eng;
	private int math;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public int setKor(int kor) {
		return this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}

	public int getSum() {
		return this.eng+this.math+this.kor;
	}

	public double getAvg() {
		return this.getSum()/3.0;
	}
	public Student() {}
	public Student(int id, String name, int kor, int eng, int math) {
		super();
		this.id = id;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public Student(String name, int kor, int eng, int math) {
		this.name=name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	

}
