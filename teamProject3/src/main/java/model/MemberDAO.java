package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import common.ConnectionManager;

public class MemberDAO {
	Connection conn;
	PreparedStatement pstmt;
	
	//싱글톤
	static MemberDAO instance;
	public static MemberDAO getInstance() {
		if(instance == null)
			instance = new MemberDAO();
			return instance;
	}
	
	//전체조회
	public ArrayList<MemberVO> selectAll(MemberVO memberVO) {//List혹은 ArrayList쓰기
		MemberVO resultVO = null;
		ResultSet rs = null;
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();//리턴값을 저장할 변수 저장
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "SELECT * FROM MEMBER"
					+ " ORDER BY MEMBER_ID";
			pstmt=conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				resultVO = new MemberVO();
				resultVO.setMember_id(rs.getString("member_id"));
				resultVO.setMember_name(rs.getString("member_name"));
				resultVO.setMember_tel(rs.getString("member_tel"));
				resultVO.setMember_address(rs.getString("member_address"));
				resultVO.setMember_pass(rs.getString("member_pass"));
				resultVO.setMember_gender(rs.getString("member_gender"));
				resultVO.setMember_birth(rs.getString("member_birth"));
				resultVO.setMember_type(rs.getString("member_type"));
				resultVO.setMember_mileage(rs.getInt("member_mileage"));
				resultVO.setSeller_code(rs.getString("seller_code"));
				list.add(resultVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(rs, pstmt, conn);
		}
		return list;
	}
	
	//한건조회
	public MemberVO selectOne(MemberVO memberVO) {
		MemberVO resultVO = null;
		ResultSet rs = null;
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "SELECT * FROM MEMBER"
					+ " WHERE MEMBER_ID=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, memberVO.getMember_id());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				resultVO = new MemberVO();
				resultVO.setMember_id(rs.getString("member_id"));
				resultVO.setMember_name(rs.getString("member_name"));
				resultVO.setMember_tel(rs.getString("member_tel"));
				resultVO.setMember_address(rs.getString("member_address"));
				resultVO.setMember_pass(rs.getString("member_pass"));
				resultVO.setMember_gender(rs.getString("member_gender"));
				resultVO.setMember_birth(rs.getString("member_birth"));
				resultVO.setMember_type(rs.getString("member_type"));
				resultVO.setMember_mileage(rs.getInt("member_mileage"));
				resultVO.setSeller_code(rs.getString("seller_code"));
			} else {
				System.out.println("no data");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(rs, pstmt, conn);//rs를 try안에서 선언하면 지역 변수 이기 때문에 try안에서만 사용 됨 , 그러니까 변수를 try밖으로 빼주고 초기값 null을 주면 에러없이 사용 가능
		}
		return resultVO;
	}
	
	//삭제
	public void delete(MemberVO memberVO) {
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "DELETE MEMBER WHERE MEMBER_ID = ?";
			pstmt = conn.prepareStatement(sql);//statement 만들때 sql넣어 줌
			pstmt.setString(1, memberVO.getMember_id());
			int r = pstmt.executeUpdate();
			System.out.println(r + " 건이 삭제됨");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(null, pstmt, conn);
		}
	}
	
	//수정(해야됨)
	
	//등록
	public int insert(MemberVO memberVO) { 
		int r = 0;
		try {
			
			conn = ConnectionManager.getConnnect();
			
			String sql="insert into member (member_id, member_name, member_tel, member_address, member_pass, "
					+ "member_gender, member_birth, member_type) "
					+ "values (?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberVO.getMember_id());
			pstmt.setString(2, memberVO.getMember_name());
			pstmt.setString(3, memberVO.getMember_tel());
			pstmt.setString(4, memberVO.getMember_address());
			pstmt.setString(5, memberVO.getMember_pass());
			pstmt.setString(6, memberVO.getMember_gender());
			pstmt.setString(7, memberVO.getMember_birth());
			pstmt.setString(8, memberVO.getMember_type());
			r = pstmt.executeUpdate();
			System.out.println(r + " 건이 처리됨");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(conn);
		}
		return r;
		

	}

	}


	

