package member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.MemberDAO;
import model.MemberVO;

public class MemberLoginController implements Controller {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1. 파라미터 받기
		MemberVO memberVO = new MemberVO();
		memberVO.setMember_id(request.getParameter("member_id"));
		memberVO.setMember_pass(request.getParameter("member_pass"));
		
		//2. 서비스처리
		MemberVO resultVO = MemberDAO.getInstance().selectOne(memberVO);
		
		//3. 결과저장
		String page = "";
		if(resultVO == null) {//일치하는 아이디가 없으면 에러메시지를 띄우면서 login페이지에 머무르기
			request.setAttribute("errormsg", "해당아이디가 없습니다");
			page = "memberLogin.jsp";	
		} else {
			if(memberVO.getMember_pass().equals(resultVO.getMember_pass())) { //로그인 성공
				request.getSession().setAttribute("login", resultVO);//세션에 로그인 정보 저장
				request.getSession().setAttribute("id", memberVO.getMember_id());//사용자의 id를 준다
				page = "memberOutput.jsp";
			} else { //패스워드 불일치
				request.setAttribute("errormsg", "패스워드 불일치"); //패스워드 맞지 않으면 에러 메시지
				page = "memberLogin.jsp";
			}
		}
		
		//4. 뷰페이지 이동(redirect, forward) 또는 뷰페이지 직접 출력
		request.getRequestDispatcher(page).forward(request, response);
	}

}
