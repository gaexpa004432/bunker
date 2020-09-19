package restaurant;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Paging;
import controller.Controller;
import model.RestaurantDAO;
import model.RestaurantVO;

public class RestaurantBoardController implements Controller {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RestaurantVO restaurant = new RestaurantVO();
		String p = request.getParameter("p");
		// 유효성 체크
		int page = 1;
		if (p != null) {
			page = Integer.parseInt(p);
		}

		Paging paging = new Paging();
		paging.setPageUnit(6); // 한페이지에 출력할 레코드 건수 설정
		paging.setPageSize(3); // 페이지 번호 수 설정
		paging.setPage(page); // paging 반영되게 해주기

		// VO에 담기
		paging.setTotalRecord(RestaurantDAO.getInstance().count(null)); // dao.count() 쓰면 first,last paging에서 알아서 계산다해주고
																		// 카운트에도 넘김
		restaurant.setFirst(paging.getFirst());
		restaurant.setLast(paging.getLast());

		ArrayList<RestaurantVO> list = RestaurantDAO.getInstance().selectAll(restaurant); // 위에 담은 dept를 실행하기위해 selectAll()에 담기
		request.setAttribute("list", list);
		request.setAttribute("paging", paging);
		request.getRequestDispatcher("/restaurant/restaurantBoard.jsp").forward(request, response);
	}

}
