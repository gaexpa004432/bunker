package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import common.ConnectionManager;

public class FreeBoardDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	
	//등록 
	   public int insert(FreeBoardVO freeboardVO) {
	       int r = 0;
		   try {
	         conn = ConnectionManager.getConnnect();
	         String sql = "INSERT INTO BOARD (BOARD_NO, MEMBER_NAME, BOARD_SUB, BOARD_CONTENT,"
	         		+ "BOARD_DATE, BOARD_FILE, BOARD_GROUPCODE"
	         		+ ")"
	               + "VALUES (BOARD_SEQ.NEXTVAL,?,?,?,SYSDATE,?,?)"; //시퀀스
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, freeboardVO.getMember_name());
	         pstmt.setString(2, freeboardVO.getBoard_sub());
	         pstmt.setString(3, freeboardVO.getBoard_content());
	         r = pstmt.executeUpdate();
	         System.out.println(r + "건이 입력됨");

	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         ConnectionManager.close(conn);
	      }
	   return r;
	   }
	   
	   //전체조회 (페이징처리가 되는)
		public ArrayList<FreeBoardVO> selectAll() {
			 FreeBoardVO resultVO = null;
			 ResultSet rs = null;
			 ArrayList<FreeBoardVO> list = new ArrayList<FreeBoardVO>();
			 try {
				 conn = ConnectionManager.getConnnect();
				 String sql = "select * from board";
				 pstmt = conn.prepareStatement(sql);
	
				rs = pstmt.executeQuery();
				while(rs.next()) {
					resultVO = new FreeBoardVO();
					resultVO.setMember_name(rs.getString("member_name"));
					resultVO.setBoard_sub(rs.getString("board_sub"));
					resultVO.setBoard_content(rs.getString("board_content"));
					list.add(resultVO);
					System.out.println(resultVO.getBoard_sub());
				} 
			 }catch(Exception e) {
				 e.printStackTrace();		 
			 } finally {
				 ConnectionManager.close(rs, pstmt, conn);
			 }
			return list;
		}
	   
		//삭제
				public int delete(FreeBoardVO freeboardVO) {
				       int r = 0;
					   try {
				         conn = ConnectionManager.getConnnect();
				         String sql = "delete from board where board_no = ?";
				         pstmt = conn.prepareStatement(sql);
				         pstmt.setInt(1, freeboardVO.getBoard_no());
				  
				         r = pstmt.executeUpdate();
				         System.out.println(r + "건이 입력됨");

				      } catch (Exception e) {
				         e.printStackTrace();
				      } finally {
				         ConnectionManager.close(conn);
				      }
				   return r;
				   }
				
				//수정
				public int update(FreeBoardVO freeboardVO) {
				       int r = 0;
					   try {
				         conn = ConnectionManager.getConnnect();
				         String sql = "update board set board_sub=?, board_content=?" 
				         		+ "where board_no=?";
				         pstmt = conn.prepareStatement(sql);
				         pstmt.setString(1, freeboardVO.getBoard_sub());
				         pstmt.setString(2, freeboardVO.getBoard_content());
				         pstmt.setInt(3, freeboardVO.getBoard_no());
				  
				         r = pstmt.executeUpdate();
				         System.out.println(r + "건이 입력됨");

				      } catch (Exception e) {
				         e.printStackTrace();
				      } finally {
				         ConnectionManager.close(conn);
				      }
				   return r;
				   }
				
	   
}
