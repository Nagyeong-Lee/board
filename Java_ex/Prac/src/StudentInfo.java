
public class StudentInfo {

	private String name;
	private int kor;
	private int eng;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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
	
	public int getSum() {
		return this.eng+this.kor;
	}

	public double getAvg() {
		return this.getSum()/2.0;
	}
	
	public StudentInfo() {}
	public StudentInfo(String name, int kor, int eng) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
	}
	
	
}
