package recipe;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.ProductDAO;
import model.ProductVO;

public class ProductInsertController implements Controller {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String product_number = request.getParameter("product_number");
		String product_name = request.getParameter("product_name");
		String product_price = request.getParameter("product_price");
		String product_unit = request.getParameter("product_unit");
//		String product_status = request.getParameter("product_status");
		String seller_code = request.getParameter("seller_code");
		System.out.println(product_name + product_price + product_unit + seller_code);
		
		ProductVO product = new ProductVO();
//		product.setProduct_number(Integer.parseInt(product_number));
		product.setProduct_name(product_name);
		product.setProduct_price(Integer.parseInt(product_price));
		product.setProduct_unit(product_unit);
//		product.setProduct_status(product_status);
		product.setSeller_code(Integer.parseInt(seller_code));
	
		
		//서비스 처리   db처리
		int r = ProductDAO.getInstance().productInsert(product);
		
		//결과 저장
		request.setAttribute("cnt", r);
	}

}
