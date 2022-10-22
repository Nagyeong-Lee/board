import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		DAO dao= DAO.getInstance();
		try {
			ServerSocket server= new ServerSocket(25000); //port번호
			System.out.println("클라이언트의 연결 대기중");
			Socket sock=server.accept();

			System.out.println(sock.getInetAddress()+"로부터 연결");

			OutputStream os=sock.getOutputStream();
			DataOutputStream dos=new DataOutputStream(os); //outputStream 업그레이드

			InputStream is=sock.getInputStream();
			DataInputStream dis=new DataInputStream(is); 

			
			while(true) {
				String cmd = dis.readUTF();
				
				if(cmd.equals("0")) {
					dos.writeUTF("종료");
					dos.flush();
				}else if(cmd.equals("1")) {
					dos.writeUTF(wisewords[(int)(Math.random()*3)]);
					dos.flush();
				}else if(cmd.equals("lotto")) {

					for(int i = 0;i < lottoNum.length*10;i++) {
						int x = (int)(Math.random()*45);
						int y = (int)(Math.random()*45);
						int tmp = lottoNum[x];
						lottoNum[x] = lottoNum[y];
						lottoNum[y] = tmp;
					}
					dos.writeUTF(lottoNum[0]+" "+lottoNum[1]+" "+lottoNum[2]+" "+lottoNum[3]+" "+lottoNum[4]+" "+lottoNum[5]+" ");
					dos.flush();

				}else {
					dos.writeUTF("그런 명령은 없습니다.");
					dos.flush();
				}

			}
		}


		//--------------------------------------------------------------



	}
}