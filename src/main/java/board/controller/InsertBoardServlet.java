package board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.service.BoardService;
import board.vo.Board;

@WebServlet("/board/boardForm")
public class InsertBoardServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = "/WEB-INF/views/board/boardForm.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String title = req.getParameter("title");
		String writer = req.getParameter("writer");
		String content = req.getParameter("textarea");
		
		Board board = new Board();
		board.setTitle(title);
		board.setWriter(writer);
		board.setContent(content);
		
		try {
			 
			BoardService service = new BoardService();
			// insert
			int result = service.insert(board);
			
			// update
		//	result = service.update(board);
			
			HttpSession session = req.getSession();
			req.setAttribute("result", result);
			
		 	RequestDispatcher rd = req.getRequestDispatcher("/board/boardList");
			rd.forward(req, resp);
			
		 
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
}
