package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.BoardDTO;

public class BoardDAO {

	private static BoardDAO instance=null;
	public static synchronized BoardDAO getInstance() {
		if(instance==null) {
			instance=new BoardDAO();
		}
		return instance;
	} 
	private BoardDAO() {}

	private Connection getConnection() throws Exception {
		Context cx = new InitialContext();
		DataSource ds = (DataSource) cx.lookup("java:comp/env/jdbc/oracle");
		return ds.getConnection();
	}

	public int insert(BoardDTO dto) throws Exception {
		String sql="insert into board values(board_seq.nextval,?,?,?,sysdate,?)";
		try(
				Connection con = getConnection();
				PreparedStatement pstat= con.prepareStatement(sql);){
			pstat.setString(1, dto.getWriter());
			pstat.setString(2, dto.getTitle());
			pstat.setString(3, dto.getContents());
			pstat.setInt(4, dto.getView_count());
			int result=pstat.executeUpdate();
			con.commit();
			return result;
		}
	}

	public List<BoardDTO> selectAll() throws Exception{
		List<BoardDTO>list=new ArrayList<>();
		String sql="select * from board order by 5 desc";
		try(
				Connection con = getConnection();
				PreparedStatement pstat= con.prepareStatement(sql);
				ResultSet rs = pstat.executeQuery();){
			while(rs.next()) {
				int seq=rs.getInt("seq");
				String writer=rs.getString("writer");
				String title=rs.getString("title");
				String contents=rs.getString("contents");
				String write_date=formedDate(rs.getTimestamp("write_date"));
				int view_count=rs.getInt("view_count");
				list.add(new BoardDTO(seq,writer,title,contents,write_date,view_count));
			}
			return list;
		}
	}

	//날짜 변환
	public String formedDate(Timestamp write_date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(write_date);
	}


	//무조건 하나인데 굳이 list?x
	public List<BoardDTO> selectText(int seq) throws Exception{
		List<BoardDTO> list=new ArrayList<>();
		String sql="select * from board where seq=?";
		try(
				Connection con = getConnection();
				PreparedStatement pstat= con.prepareStatement(sql);
				){
			pstat.setInt(1, seq);
			try(ResultSet rs = pstat.executeQuery();){
				while(rs.next()) {
					int seq01=rs.getInt("seq");
					String writer=rs.getString("writer");
					String title=rs.getString("title");
					String content=rs.getString("contents");
					String write_date=formedDate(rs.getTimestamp("write_date"));
					int view_count=rs.getInt("view_count");
					list.add(new BoardDTO(seq01,writer,title,content,write_date,view_count));
				}
			}
		}
		return list;
	}

	//post 삭제
	public int deletePost(int seq) throws Exception {
		int result=0;
		String sql="delete from board where seq=?";
		try(
				Connection con = getConnection();
				PreparedStatement pstat= con.prepareStatement(sql);){
			pstat.setInt(1, seq);
			result=pstat.executeUpdate();
			con.commit();
		}
		return result;
	}

	//post 업데이트
	public int updatePost(int seq,String inputTitle,String inputText) throws Exception {
		int result=0;
		String sql="update board set title=?,contents=? where seq=?";
		try(
				Connection con = getConnection();
				PreparedStatement pstat= con.prepareStatement(sql);){
			pstat.setString(1, inputTitle);
			pstat.setString(2, inputText);
			pstat.setInt(3, seq);
			result=pstat.executeUpdate();
			con.commit();
		}
		return result;
	}

	//viewCount
	public int addViewCount(int seq) throws Exception {
		int result=0;
		String sql="update board set view_count = view_count+1 where seq=?";
		try(
				Connection con = getConnection();
				PreparedStatement pstat= con.prepareStatement(sql);){
			pstat.setInt(1, seq);
			result=pstat.executeUpdate();
			con.commit();
		}
		return result;
	}

	//글 개수 세기
	public int getRecordCount() throws Exception{
		String sql="select count(*) from board";
		try(
				Connection con = getConnection();
				PreparedStatement pstat=con.prepareStatement(sql);
				ResultSet rs = pstat.executeQuery();){
			rs.next();
			return rs.getInt(1);
		}
	}

	//Paging (service layer에 있어야함)
	//int pageTotalCount= (recordTotalCount+(recordCountPerPage-1)) / recordCountPerPage;
	public String getPageNavi(int currentPage) throws Exception{
		int recordTotalCount=this.getRecordCount(); //board테이블에 글 144개 있다고 가정
		int recordCountPerPage=10;  //게시판 한 페이지당 10개의 글 보여주기로 가정
		int naviCountPerPage=10; //게시판 하단의 Page Navigator가 한번에 몇개씩 보여질지 설정


		int pageTotalCount=0;
		if((recordTotalCount%recordCountPerPage) > 0 ) {
			pageTotalCount=(recordTotalCount/recordCountPerPage)+1; 
			//게시글 개수 / 한 페이지당 보여줄 게시글 +1 = 전체 페이지의 개수 
		}else {
			pageTotalCount=(recordTotalCount/recordCountPerPage); 
		}

		//장난질 방지
		if(currentPage< 1 ) {
			currentPage=1; 
		}else if(currentPage > pageTotalCount) {
			currentPage=pageTotalCount;
		}
		//7page : 1~10
		//15page : 11~20
		//28page : 21~30
		//20,10들어갈때 currentPage-1
		int startNavi=(currentPage-1)/recordCountPerPage*recordCountPerPage+1; //내비의 시작점
		int endNavi=startNavi+(recordCountPerPage-1); //내비 끝나는점

		if(endNavi>pageTotalCount) {
			endNavi=pageTotalCount;
		}

		boolean needPrev=true;
		boolean needNext=true;

		if(startNavi==1) {
			needPrev=false;
		}else if(endNavi==pageTotalCount) {
			needNext=false;
		}

		StringBuilder sb= new StringBuilder(); //문자열을 하나로 연결해주는 클래스


		if(needPrev) {
			sb.append("<a href='/list.board?cpage="+(startNavi-1)+"'><</a>");
		}

		for(int i=startNavi; i<=endNavi; i++) {
			sb.append("<a href='/list.board?cpage="+i+"'> " +i+ " </a>");
		}

		if(needNext) {
			sb.append("<a href='/list.board?cpage="+(endNavi+1)+"'>></a>");
		}

		return sb.toString();
	}

	public List<BoardDTO> selectByRange(int start,int end) throws Exception{
		//seq로 불러오면 안되는게 중간에 삭제된것도 있을까봐 행번호로 가져와야됨 -> row_number() over() 함수 사용
		//가장 최신글 불러오기
		//select board.*,row_number() over(order by seq desc) rn from board;
		//그냥 *,row_number()하면 모든것과 row_number라서 안됨 . 테이블명.*로 해주기
		List<BoardDTO> list=new ArrayList<>();
		String sql="select * from ( select board.*,row_number() over(order by seq desc) rn from board) where rn between ? and ?";
		try(
				Connection con = getConnection();
				PreparedStatement pstat= con.prepareStatement(sql);
				){
			pstat.setInt(1, start);
			pstat.setInt(2, end);
			try(ResultSet rs = pstat.executeQuery();){
				while(rs.next()) {
					int seq01=rs.getInt("seq");
					String writer=rs.getString("writer");
					String title=rs.getString("title");
					String content=rs.getString("contents");
					String write_date=formedDate(rs.getTimestamp("write_date"));
					int view_count=rs.getInt("view_count");
					list.add(new BoardDTO(seq01,writer,title,content,write_date,view_count));
				}
			}
		}
		return list;
	}

}