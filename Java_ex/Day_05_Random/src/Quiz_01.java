import java.util.Scanner;

public class Quiz_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		System.out.print("0~9까지의 랜덤 수 : ");
		int num1=(int)(Math.random()*10);
		System.out.println(num1);
		System.out.print("1~10까지의 랜덤 수 : ");
		int num2=(int)(Math.random()*10)+1;
		System.out.println(num2);
		System.out.print("20~35까지의 랜덤 수 : ");
		int num3=(int)(Math.random()*16)+20;
		System.out.println(num3);
		System.out.print("0 또는 1 : ");
		int num4 = (int)(Math.random()*2);
		System.out.println(num4);
	}

}
