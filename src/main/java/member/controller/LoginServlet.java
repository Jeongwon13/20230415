package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.service.MemberService;
import member.vo.Member;

@WebServlet("/board/login")
public class LoginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String inputEmail = req.getParameter("inputEmail");
		String inputPw = req.getParameter("inputPw");
		
		System.out.println("inputEmail : " + inputEmail);
		System.out.println("inputPw : " + inputPw);
		
		Member mem = new Member();
		mem.setMemberEmail(inputEmail);
		mem.setMemberPw(inputPw);
		
		try {
			MemberService service = new MemberService();
			
			Member loginMember = service.login(mem);
			
			HttpSession session = req.getSession();
			
			if(loginMember != null) {
				
				session.setAttribute("loginMember", loginMember);
				
				session.setMaxInactiveInterval(3600);
				
				Cookie c = new Cookie("saveId", inputEmail);
				
				if(req.getParameter("saveId") != null) {
					c.setMaxAge(60 * 60 * 24 * 30);
				} else {
					c.setMaxAge(0);
				}
				
				c.setPath(req.getContextPath());
				resp.addCookie(c);
		
			} else {
				session.setAttribute("message", "아이디 또는 비밀번호가 일치하지 않습니다.");
			}
			
			
			resp.sendRedirect(req.getContextPath()+"/board/main");
//		
// 		RequestDispatcher rd = req.getRequestDispatcher("board/main");
// 		rd.forward(req, resp);
//	
			
			
		} catch(Exception e) {
			System.out.println("로그인 실패");
			e.printStackTrace();
		}
		
	}
}
