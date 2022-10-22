package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Client {

	public static void main(String[] args) throws Exception{
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
				String result=dis.readUTF();
				System.out.println("결과 : "+result); 

			}
		}catch(Exception e){
			System.out.println("연결 해제");
		}finally {
			try {
				dis.close();
				dos.close();
			}catch(Exception e2) {

			}
		}
	}
}
