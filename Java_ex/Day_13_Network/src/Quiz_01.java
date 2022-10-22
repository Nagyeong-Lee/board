import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Quiz_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DataInputStream dis=null;
		DataOutputStream dos=null;

		try {
			Socket client = new Socket("localhost",25000);

			InputStream is = client.getInputStream();
			dis = new DataInputStream(is);

			OutputStream os = client.getOutputStream();
			dos = new DataOutputStream(os);

			while(true) {

				dos.writeUTF(JOptionPane.showInputDialog("전송할 메세지를 입력해주세요"));
				dos.flush();
				System.out.println(dis.readUTF());

			}
			//try(
			//finally 필요X
		
		//){
			
		//}catch(){}
		}catch(Exception e) {
			System.out.println("서버와의 연결 해제");
			//			try {
			//				dis.close(); //stream 반드시 close로 반환되야함, stream 스코프 해결 
			//				dos.close(); //close 예외 발생 가능성있어서 try-catch로 또 묶음
			//			}catch(Exception e){
							//}
		}finally {  //마무리를 위해 반드시 실행되는 코드 , finally는 close를 하는구문
			try {
				dis.close();
				dos.close();
			}catch(Exception e2) {

			}
		}

	}

}

