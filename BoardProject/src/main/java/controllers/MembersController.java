package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MembersDAO;
import dto.MembersDTO;

@WebServlet("*.mem")
public class MembersController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf8"); //한글 안깨지게

		try {
			System.out.println("members controller 동작");
			String uri=request.getRequestURI();
			System.out.println(uri);
			if(request.getRequestURI().equals("/duplCheck.mem")) {
				String id=request.getParameter("id");
				MembersDAO dao = MembersDAO.getInstance();
				boolean result=dao.isIdExist(id);
				request.setAttribute("id", id);
				request.setAttribute("result", result);
				request.getRequestDispatcher("/member/duplCheckView.jsp").forward(request, response);
			}else if(request.getRequestURI().equals("/signup.mem")) {
				System.out.println("signup.mem 동작");
				MembersDAO dao = MembersDAO.getInstance();
				String id01=request.getParameter("id");
				String password=request.getParameter("password");
				String name=request.getParameter("name");
				String phone=request.getParameter("phone");
				String email=request.getParameter("email");
				String zonecode=request.getParameter("zonecode");
				String roadAddress=request.getParameter("roadAddress");
				String jibunAddress=request.getParameter("jibunAddress");
				dao.insert(new MembersDTO(id01,password,name,phone,email,zonecode,roadAddress,jibunAddress,null));
				response.sendRedirect("/index.jsp");
			}else if(request.getRequestURI().equals("/login.mem")) {
				MembersDAO dao = MembersDAO.getInstance();
				String loginID=request.getParameter("loginID");
				String loginPW=MembersDAO.getSHA512(request.getParameter("loginPW"));
				boolean result=dao.isLoginAvailable(loginID,loginPW);
				if(result) {
					System.out.println("로그인 성공");
					//이게 ㄹㅇ 로그인
					//서버안의 session이라는 창고에 key value 형식으로 기록 남겨놓기 (모든 페이지에서 세션에 접근 가능)
					//세션이 key값을 client한테 줌.브라우저별로 key값이 다름
					//session값 jstl로 받을 수 있음
					request.getSession().setAttribute("loginID", loginID);
					response.sendRedirect("/");
				}else {
					System.out.println("로그인 실패");
					response.sendRedirect("/");
				}
			}else if(request.getRequestURI().equals("/logout.mem")) { 
				request.getSession().invalidate(); // 다 날리기
				response.sendRedirect("/index.jsp");
			}else if(request.getRequestURI().equals("/deleteAccount.mem")) {
				String loginID=(String)request.getSession().getAttribute("loginID");
				MembersDAO dao = MembersDAO.getInstance();
				int result=dao.delAccount(loginID);
				System.out.println(result);
				System.out.println(loginID);
				request.getSession().invalidate();
				response.sendRedirect("/index.jsp");
			}else if(request.getRequestURI().equals("/myPage.mem")) {
				String loginID=(String) request.getSession().getAttribute("loginID");
				MembersDAO dao = MembersDAO.getInstance();
				List<MembersDTO>list=dao.selectAll(loginID);
				if(list.size()>0) {
					request.setAttribute("list", list);
					request.getRequestDispatcher("/member/myPage.jsp").forward(request, response);
				}
			}else if(request.getRequestURI().equals("/update.mem")) {
				MembersDAO dao = MembersDAO.getInstance();
				String password=request.getParameter("password");
				String name=request.getParameter("name");
				String phone=request.getParameter("phone");
				String email=request.getParameter("email");
				String zonecode=request.getParameter("zonecode");
				String roadAddress=request.getParameter("roadAddress");
				String jibunAddress=request.getParameter("jibunAddress");
				String loginID=(String)request.getSession().getAttribute("loginID");
				int reuslt=dao.update(new MembersDTO(null,password,name,phone,email,zonecode,roadAddress,jibunAddress,null),loginID);

				if(reuslt>0) {
					System.out.println("정보 수정 성공");
					response.sendRedirect("/myPage.mem");
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
			response.sendRedirect("/error.jsp");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
