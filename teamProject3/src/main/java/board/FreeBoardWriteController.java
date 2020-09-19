package board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.FreeBoardDAO;
import model.FreeBoardVO;   

public class FreeBoardWriteController implements Controller {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		FreeBoardVO freeboard = new FreeBoardVO();
		System.out.println("ㄷㅌㄷ쳣ㄷ");
		freeboard.setMember_name(request.getParameter("member_name"));
		freeboard.setBoard_sub(request.getParameter("board_sub"));
		freeboard.setBoard_content(request.getParameter("board_content"));
		freeboard.setBoard_file(request.getParameter("board_file"));
		freeboard.setBoard_groupcode(request.getParameter("board_group_code"));
		
		FreeBoardDAO DAO = new FreeBoardDAO();
		DAO.insert(freeboard);
		
		response.sendRedirect("freeBoardList.do");
	}

}
