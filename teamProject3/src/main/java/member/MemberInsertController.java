package member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.MemberDAO;
import model.MemberVO;

public class MemberInsertController implements Controller {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String member_id = request.getParameter("member_id");
		String member_pass = request.getParameter("member_pass");
		String member_name = request.getParameter("member_name");
		String member_tel = request.getParameter("member_tel");
		String member_gender = request.getParameter("member_gender");
		String member_birth = request.getParameter("member_birth");
		String member_roadAddress = request.getParameter("member_roadAddress");
		String member_postcode = request.getParameter("member_postcode");
		String member_jibunAddress = request.getParameter("member_jibunAddress");
		String member_detailAddress = request.getParameter("member_detailAddress");
		String member_extraAddress = request.getParameter("member_extraAddress");
		String member_type = request.getParameter("member_type");
		
		
		MemberVO memberVO = new MemberVO();
		memberVO.setMember_id(member_id);
		memberVO.setMember_pass(member_pass);
		memberVO.setMember_name(member_name);
		memberVO.setMember_tel(member_tel);
		memberVO.setMember_gender(member_gender);
		memberVO.setMember_birth(member_birth);
		memberVO.setMember_address(member_roadAddress);
		memberVO.setMember_type(member_type);
		
		int r = MemberDAO.getInstance().insert(memberVO);
		System.out.println(r+"건이 실행됨");
		
		request.setAttribute("cnt", r);
		
		request.getRequestDispatcher("/member/memberInsertOutput.jsp").forward(request, response);

	}

}
