package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import dto.BoardDTO;

@WebServlet("*.board")
public class BoardControllers extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf8");
		try {
			BoardDAO dao = BoardDAO.getInstance();
			if(request.getRequestURI().equals("/writeForm.board")){
				String inputTitle=request.getParameter("inputTitle");
				String inputText=request.getParameter("inputText");
				String writer=(String) request.getSession().getAttribute("loginID");
				int result=dao.insert(new BoardDTO(0,writer,inputTitle,inputText,null,0));
				System.out.println("insert 성공");
				response.sendRedirect("/list.board");
			}else if(request.getRequestURI().equals("/list.board")) { 
				
				int cpage=Integer.parseInt(request.getParameter("cpage")); //사용자한테 받음
				String navi=BoardDAO.getInstance().getPageNavi(cpage);
//				List<BoardDTO>list=dao.selectAll();
				List<BoardDTO>list=BoardDAO.getInstance().selectByRange(cpage*10-9,cpage*10);
				
				request.setAttribute("list", list);
				request.setAttribute("navi", navi);
				
				request.getRequestDispatcher("/board/boardList.jsp").forward(request, response);
			}else if(request.getRequestURI().equals("/detail.board")) {
				int seq=Integer.parseInt(request.getParameter("seq"));

				BoardDAO.getInstance().addViewCount(seq); //view_count

				String loginID=(String) request.getSession().getAttribute("loginID");
				List<BoardDTO> list=dao.selectText(seq);
				request.setAttribute("list", list);
				//request.setAttribute("loginID", loginID); 
				request.getRequestDispatcher("/board/detailBoard.jsp").forward(request, response);
			}else if(request.getRequestURI().equals("/deletePost.board")) {
				int seq=Integer.parseInt(request.getParameter("seq"));
				int result=dao.deletePost(seq);
				System.out.println("del성공");
				response.sendRedirect("/list.board");
			}else if(request.getRequestURI().equals("/updatePost.board")) {
				int seq=Integer.parseInt(request.getParameter("seq"));
				System.out.println("Param : " + seq);
				String inputTitle=request.getParameter("inputTitle");
				String inputText=request.getParameter("inputText");
				System.out.println("test");
				int result=dao.updatePost(seq,inputTitle,inputText);
				System.out.println("update성공");
				response.sendRedirect("/");
				//response.sendRedirect("/detail.board/seq="+seq);
				//sendRedirect는 주소창에 url치는것과 동일

			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		// TODO: handle exception
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
