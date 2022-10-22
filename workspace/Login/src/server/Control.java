package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import dao.DAO;
import dto.DTO;

public class Control {


		public static void main(String[] args) throws Exception {

			Scanner sc = new Scanner(System.in);

			ServerSocket server = new ServerSocket(25000); // port number 25000

			System.out.println("Waiting for client's connection");

			Socket sock = server.accept(); // return Socket
			OutputStream os = sock.getOutputStream();
			InputStream is = sock.getInputStream();

			DataOutputStream dos = new DataOutputStream(os);
			DataInputStream dis = new DataInputStream(is);

			System.out.println(sock.getInetAddress() + " 로 부터 연결 확인");

			DAO acDAO = DAO.getInstance();
			while (true) {
				boolean isLogined = dis.readBoolean();
				System.out.println(isLogined);
				if (isLogined == true) {
					String uId = dis.readUTF(); // id입력받음.
					String uPw = acDAO.getSHA512(dis.readUTF()); // pw입력받음.

					boolean isCleaned = acDAO.login(uId, uPw);
					dos.writeBoolean(isCleaned);
					System.out.println("로그인 성공");
					System.exit(0);

				} else if (isLogined == false) { // register
					String uId = dis.readUTF(); // id입력받음.
					String uPw = acDAO.getSHA512(dis.readUTF());// pw입력받음.
					System.out.println(uId + uPw);
					int result = acDAO.createAccount(new DTO(uId, uPw));
					if (result > 0) {
						// 로그인 화면
						dos.writeBoolean(true);
						dos.flush();
					} else {
						dos.writeBoolean(false);
						dos.flush();
						
					}
				}

			}
		}
	}

