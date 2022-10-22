package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import dao.DAO;
import dto.DTO;

public class Control {

	public static void main(String[] args) throws Exception{

		DAO dao = DAO.getInstance();
		DTO dto = new DTO();

		try(ServerSocket server = new ServerSocket(25000);
				Socket client=server.accept();
				DataInputStream dis = new DataInputStream(client.getInputStream());
				DataOutputStream dos = new DataOutputStream(client.getOutputStream());){

			System.out.println(client.getInetAddress()+"와의 연결성공");

			A : while(true) {
				int menu=dis.readInt();
				if(menu==1) {
					try {
						String id=dis.readUTF();
						String pw=dis.readUTF();

						boolean result=dao.login(new DTO(null,id,pw));
						if(result) {
							dos.writeUTF("로그인 성공");
							dos.flush();
						}else {
							dos.writeUTF("로그인 실패");
							dos.flush();
						}
						break A;
					}catch(Exception e) {
						e.printStackTrace();
					}
				}else if(menu==2) {
					try {
						String name=dis.readUTF();
						String id=dis.readUTF();
						String pw=dis.readUTF();

						int result=dao.insert(new DTO(name,id,pw));
						if(result>0) {
							dos.writeUTF("회원가입 성공");
							dos.flush();
						}else {
							dos.writeUTF("회원가입 실패");
							dos.flush();
						}
						break A;
					}catch(Exception e) {
						e.printStackTrace();
					}
				}else if(menu==0) {
					try {
						dos.writeUTF("프로그램을 종료합니다");
						dos.flush();
						System.exit(0);
					}catch(Exception e) {
						e.printStackTrace();
					}
				}else {
					try {
						dos.writeUTF("메뉴를 다시 선택하세요");
						dos.flush();
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
			}

		}

	}
}
