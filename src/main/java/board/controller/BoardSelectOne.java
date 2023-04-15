package board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.service.BoardService;
import board.vo.Board;

@WebServlet("/board/selectOne")
public class BoardSelectOne extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = "/WEB-INF/views/board/editForm.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Board board = new Board();
		
		int boardNo = board.getNum();
		
		try {
			
			BoardService service = new BoardService(); 
			
			HttpSession session = req.getSession();
			
			session.setAttribute("list2", list2);
			
			//req.getRequestDispatcher(req.getContextPath() + "/board/boardList").forward(req, resp);
			
			resp.sendRedirect(req.getContextPath()+ "/board/editForm");
		 
		} catch(Exception e) {
			e.printStackTrace();
		}
	
	}
	
}
	
 
