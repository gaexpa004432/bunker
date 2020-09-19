package model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import common.ConnectionManager;

public class ProductDAO {
	Connection conn;
	PreparedStatement pstmt;

	// 싱글톤
	static ProductDAO instance;

	public static ProductDAO getInstance() {
		if (instance == null)
			instance = new ProductDAO();
		return instance;
	}

	public int productInsert(ProductVO productVO) {
		int r = 0;
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "insert into product(product_number, product_name, product_price"
					+ "product_unit, product_status, seller_code" + "values (?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, productVO.getProduct_number());
			pstmt.setString(2, productVO.getProduct_name());
			pstmt.setInt(3, productVO.getProduct_price());
			pstmt.setString(4, productVO.getProduct_unit());
			pstmt.setString(5, productVO.getProduct_status());
			pstmt.setInt(6, productVO.getSeller_code());

			r = pstmt.executeUpdate();
			System.out.println(r + " 건이 처리됨");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(conn);
		}
		return r;
	}
}
