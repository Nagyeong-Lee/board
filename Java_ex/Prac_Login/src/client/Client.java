package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.math.BigInteger;
import java.net.Socket;
import java.security.MessageDigest;
import java.util.Scanner;

public class Client {

	public static String getSHA256(String input){ //암호화

		String toReturn = null;
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			digest.reset();
			digest.update(input.getBytes("utf8"));
			toReturn = String.format("%064x", new BigInteger(1, digest.digest()));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return toReturn;
	}  

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		try(Socket client= new Socket("localhost",25000);
				DataInputStream dis = new DataInputStream(client.getInputStream());
				DataOutputStream dos = new DataOutputStream(client.getOutputStream());){

			A : while(true) {
				System.out.println("<<로그인 프로그램>>");
				System.out.println("1.로그인");
				System.out.println("2.회원가입");
				System.out.println("0.종료");
				System.out.print(">> ");

				int menu=Integer.parseInt(sc.nextLine());
				dos.writeInt(menu);
				dos.flush();

				if(menu==1) {

					try {
						System.out.print("id : ");
						dos.writeUTF(sc.nextLine());
						dos.flush();

						System.out.print("pw : ");
						dos.writeUTF(getSHA256(sc.nextLine()));
						dos.flush();

						String msg=dis.readUTF();
						System.out.println(msg);
						break A;
					}catch(Exception e) {
						e.printStackTrace();
					}

				}else if(menu==2) {

					try {
						System.out.print("이름 : ");
						String name=sc.nextLine();
						dos.writeUTF(name);
						dos.flush();

						System.out.print("ID : ");
						String id=sc.nextLine();
						dos.writeUTF(id);
						dos.flush();

						System.out.print("PW : ");
						String pw=getSHA256(sc.nextLine());
						dos.writeUTF(pw);
						dos.flush();

						String msg=dis.readUTF();
						System.out.println(msg);
						
						break A;
					}catch(Exception e) {
						e.printStackTrace();
					}

				}else if(menu==0) {
					try {
						String msg=dis.readUTF();
						System.out.println(msg);
						System.exit(0);
					}catch(Exception e) {
						e.printStackTrace();
					}
				}else {
					try {
						String msg=dis.readUTF();
						System.out.println(msg);
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
			}

		}
	}
}

