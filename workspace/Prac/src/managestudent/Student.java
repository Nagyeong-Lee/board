package managestudent;

public class Student {
	
	private int id;
	private String name;
	private double kor;
	private double eng;
	private double math;
	private double art;
	
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
	public double getKor() {
		return kor;
	}
	public void setKor(double kor) {
		this.kor = kor;
	}
	public double getEng() {
		return eng;
	}
	public void setEng(double eng) {
		this.eng = eng;
	}
	public double getMath() {
		return math;
	}
	public void setMath(double math) {
		this.math = math;
	}
	public double getArt() {
		return art;
	}
	public void setArt(double art) {
		this.art = art;
	}
	public double getSum() {
		return this.kor+this.eng+this.math+this.art;
	}
	public double getAvg() {
		return this.getSum()/4.0;
	}
	
	public Student() {}
	public Student(int id, String name, double kor, double eng, double math, double art) {
		super();
		this.id = id;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.art = art;
	}

}
