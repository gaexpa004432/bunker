package board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.FreeBoardDAO;
import model.FreeBoardVO;

public class FreeBoardListController implements Controller {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String url = "FreeBoardList.jsp";
		 FreeBoardDAO DAO = new FreeBoardDAO();//모든 데이터 다 들고오기
		 DAO.selectAll(); //db에서 실행한 모든 데이터를 가짐
		 ArrayList<FreeBoardVO> list = DAO.selectAll(); //DB에서 조회한 모든데이터를 리스트에 담아둠
		 request.setAttribute("list", list); //데이터를 담아둔 리스트를 리퀘스트라는 변수안에 저장
		 request.getRequestDispatcher(url).forward(request, response);
	}

}
