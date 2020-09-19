package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ConnectionManager {
	public static Connection getConnnect() {
		Connection conn = null;
		try {
			//driverManager 이용하여 연결
//			String jdbc_url = "jdbc:oracle:thin:@localhost:1521:xe";
//			conn = DriverManager.getConnection(jdbc_url, "hr", "hr");

			//datasource를 이용하여 connection 획득
			Context initContext = new InitialContext();
			DataSource ds = (DataSource)initContext.lookup("java:/comp/env/jdbc/home"); // 호일이형 자리의 db는 연결이 안되기 때문에 일시적으로 본인 db의 HR로 연결되게 만들어놨습니다. 09/19
			conn = ds.getConnection();   //conn 을 할당받음
			System.out.println("dbcp에서 conn할당");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void close(Connection conn) {
		try {
			if( conn != null) conn.close(); //커넥션 풀을 쓰게 되면 할당 받았던것을 반납 한다.
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		if(rs != null) {			
			try {
				if(! rs.isClosed()) rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}
		
		if(pstmt != null) {
			try {
				if(! pstmt.isClosed()) pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(conn != null) {
			try {
				if(! conn.isClosed())  conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
