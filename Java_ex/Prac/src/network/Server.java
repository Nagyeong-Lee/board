package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Server {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		ServerSocket server = new ServerSocket(25000);
		Socket sock = server.accept();
		System.out.println("연결 성공");

		System.out.println(sock.getInetAddress());

		OutputStream os = sock.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);

		InputStream is = sock.getInputStream();
		DataInputStream dis = new DataInputStream(is);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd : HH : mm : ss");


		String[]wiseWord= {"a","b","c"};

		while(true) {
			String date=sdf.format(System.currentTimeMillis());
			String str=dis.readUTF();
			if(str.equals("date")) {
				dos.writeUTF(date);
				dos.flush();
			}else if(str.equals("lotto")) {
				int[]lotto = new int[45];
				for(int i=0; i<lotto.length; i++) {
					lotto[i]=i+1;
				}
				for(int i=0; i<lotto.length; i++) {
					int x = (int)(Math.random()*45);
					int y = (int)(Math.random()*45);
					int tmp =lotto[x]; 
					lotto[x]=lotto[y];
					lotto[y]=lotto[x];
				}
				dos.writeUTF(lotto[0]+" "+lotto[1]+" "+lotto[2]+" "+lotto[3]+" "+lotto[4]+" "+lotto[5]);
				dos.flush();
			}else if(str.equals("wiseword")) {
				int z = (int)(Math.random()*3);
				dos.writeUTF(wiseWord[z]);
				dos.flush();
			}else {
				dos.writeUTF("그런 명령은 x");
				dos.flush();
			}

		}

	}

}
