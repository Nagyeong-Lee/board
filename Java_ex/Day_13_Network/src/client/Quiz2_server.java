package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Quiz2_server {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		ServerSocket server = new ServerSocket(25000);
		Socket socket = server.accept();
		System.out.println("연결됨");
		System.out.println(socket.getInetAddress()+"로부터 연결");

		DataInputStream dis = new DataInputStream(socket.getInputStream());

		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

		while(true) {
			String id=dis.readUTF();
			String pw=dis.readUTF();
			if(id.equals("a") && pw.equals("aa")) {
				dos.writeBoolean(true);
				dos.flush();
			}else {
				dos.writeBoolean(false);
				dos.flush();
			}
		}
	}

}
