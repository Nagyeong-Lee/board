package basic;

public class Exam_01 {

	public int plus(int n1, int n2) {
		return n1+n2;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Temp.b=10;
		Temp t1 = new Temp();
		Temp t2 = new Temp();
		System.out.println(t1.b);
		System.out.println(t2.b);
		t2.b=50;
		System.out.println(t1.b);
		
		Exam_01 e =new Exam_01();
		e.plus(10,20);
		
	}

}
