package client;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Quiz2_client {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub


		Socket client = new Socket("localhost",25000);

		InputStream is = client.getInputStream();
		DataInputStream dts = new DataInputStream(is);

		OutputStream os = client.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		//		while(true) {
		//			dos.writeUTF("a");
		//			dos.writeUTF("b");
		//		}
		while(true) {
			dos.writeUTF(JOptionPane.showInputDialog("ID"));
			//		dos.flush();
			dos.writeUTF(JOptionPane.showInputDialog("PW"));
			dos.flush();
			System.out.println(dts.readBoolean()); //true or false 반환 
			//		dos.writeUTF(JOptionPane.showInputDialog("msg입력"));
		}
	}

}
