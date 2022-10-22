import java.awt.Robot;

public class Playing_01 { //매크로

	public static void main(String[] args) throws Exception{

		Robot r = new Robot();
		r.mouseMove(400, 400);
		for(int i=0; i<400; i++) {
			r.delay(2);
			r.mouseMove(400+i, 400);
		}
	}

}
