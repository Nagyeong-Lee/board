package Main;

import java.sql.Timestamp;
import java.util.List;
import java.util.Scanner;
import DAO.Bulletin_Board_DAO;
import DTO.Bulletin_Board_DTO;

public class BulletinBoard_Main {

	static Scanner sc = new Scanner(System.in);

	public static int getInt(String str) {  //정수 입력 method
		while(true) {
			int menu=0;
			System.out.print(str);
			try {
				menu=Integer.parseInt(sc.nextLine());
			}catch(Exception e) {
				//				e.printStackTrace();
				System.out.println("메뉴를 다시 입력해주세요.");
				continue;
			}
			return menu;
		}
	}

	public static String getString(String str) {
		String returnVal="";
		while(true) {
			System.out.print(str);
			try {
				returnVal=sc.nextLine();
			}catch(Exception e) {
				System.out.println("문자로 다시 입력해주세요.");
				continue;
			}
			return returnVal;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Bulletin_Board_DAO dao = Bulletin_Board_DAO.getInstance();

		while(true) {
			System.out.println("1.글 작성하기");
			System.out.println("2.글 수정하기"); //작성자로
			System.out.println("3.글 삭제하기"); //글 번호로
			System.out.println("4.글 검색하기"); //작성자로
			System.out.println("5.전체 글 보기");
			System.out.println("0.프로그램 종료");
			int menu=getInt(">> ");

			if(menu==0) {
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			}else if(menu==1) {
				String writer=getString("작성자 : ");
				String text=getString("글 내용 : ");
				try {
					int result=dao.insertText(new Bulletin_Board_DTO(0,writer,text,null));
					if(result>0) {
						System.out.println("글 작성 완료!");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(menu==2) {
				String writer=getString("작성자 입력 : ");
				try {
					boolean isWriterExist=dao.isWriterExist(writer);
					if(isWriterExist) {
						String updateWriter=getString("수정할 작성자 : ");
						String updateText=getString("수정할 글 : ");
						int result=dao.updateText(writer,updateWriter,updateText);
						if(result>0) {
							System.out.println("글 수정 완료!");
						}
					}else {
						System.out.println("해당 작성자는 존재하지 않습니다.");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}else if(menu==3) {
				int deleteTextNum=getInt("삭제할 글 번호 :  ");
				try {
					boolean isTextExist = dao.checkTextExist(deleteTextNum);
					if(isTextExist) {
						int result=dao.deleteText(deleteTextNum);
						if(result>0) {
							System.out.println("글 삭제 완료!");
						}
					}else {
						System.out.println("해당 글 번호는 존재하지 않습니다.");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}else if(menu==4) {
				String searchWriter=getString("작성자 입력 : ");
				boolean isWriterExist;
				try {
					isWriterExist = dao.isWriterExist(searchWriter);
					if(isWriterExist) {
						List<Bulletin_Board_DTO>list=dao.searchText(searchWriter);
						if(list.size()>0) {
							//							for(Bulletin_Board_DTO dto : list) {
							//								System.out.println(dto.getText_num()+"\t"+dto.getWriter()+
							//										"\t"+dto.getText()+"\t"+dto.getWrite_time());
							//							}
							for(Bulletin_Board_DTO dto : list) {
								Timestamp write_time=dto.getWrite_time();
								System.out.println(dto.getText_num()+"\t"+dto.getWriter()+
										"\t"+dto.getText()+"\t"+ dao.getTransformedTime(write_time));
							}
						}
					}else {
						System.out.println("해당 작성자는 존재하지 않습니다.");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}else if(menu==5) {
				try {
					List<Bulletin_Board_DTO>list =  dao.selectAll();
					if(list.size()>0) {
						for(Bulletin_Board_DTO dto : list) {
							System.out.println(dto.getText_num()+"\t"+dto.getWriter()+"\t"+
									dto.getText()+"\t"+dao.getTransformedTime(dto.getWrite_time()));
						}
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				System.out.println("메뉴를 다시 선택해주세요.");
			}

		}
	}

}
