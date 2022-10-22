import java.io.File;
import java.util.Scanner;

import it.sauronsoftware.ftp4j.FTPClient;
public class FTP {

	//	client.connect("192.168.50.67", 21);  0718

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		FTPClient client = new FTPClient();

		A:while(true) {
			System.out.println("=== FTP Client Program ===");
			System.out.println("1. Connect FTP Server");
			System.out.println("2. Exit Program");
			System.out.print(">> ");
			int menu = Integer.parseInt(sc.nextLine());

			if(menu == 1) {
				System.out.println("Input IP");
				System.out.print(">> ");
				String ip = sc.nextLine();

				System.out.println("Input port");
				System.out.print(">> ");
				int port = Integer.parseInt(sc.nextLine());

				client.connect(ip,port);
				System.out.println("FTP Server is connected");

				System.out.print("Input ID : ");
				String ID = sc.nextLine();

				System.out.print("Input password : ");
				String password = sc.nextLine();
				client.login(ID,password);

				System.out.println("Login Success!");
				System.out.println("====================");

				while(true) {
					System.out.println("1. Upload File");
					System.out.println("2. Download File");
					System.out.println("3. Disconnect FTP Server");
					System.out.println("4. Delete File");
					System.out.print(">> ");
					int menu2 = Integer.parseInt(sc.nextLine());

					if(menu2 == 1) {
						System.out.println("업로드 파일 경로");
						String path=sc.nextLine();
						client.upload(new File(path));
					}else if(menu2 ==2 ) {
						System.out.println("다음 목록 중에 고르세요.");
						try{
							String[] filenames = client.listNames();
							for(int i = 0; i < filenames.length;i++) {
								System.out.println(filenames[i]);
							}
							System.out.println("파일 주소를 입력해주세요");
							System.out.print(">> ");
							String address=sc.nextLine();

							System.out.println("저장할 이름을 입력해주세요");
							System.out.print(">> ");
							String downloadName=sc.nextLine();
							client.download(downloadName, new File("d:/다운/다운성공.txt"));
							break A;
						}catch(Exception e) {
							
						}

					}else if(menu2 == 3) {

						System.out.println("서버 연결 해제");
						client.disconnect(true);
						break ;
						
					}else if(menu2 == 4) {

						String[] filenames = client.listNames();
						for(int i = 0; i < filenames.length;i++) {
							System.out.println(filenames[i]);
						}
						client.deleteFile(sc.nextLine());
					}
				}
			}else if(menu == 2) {
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			}else {
				System.out.println("메뉴를 다시 확인해주세요.");
			}


		}

	}
}

