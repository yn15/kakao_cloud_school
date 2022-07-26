package member.service;

import member.dao.MemberDAO;
import member.vo.Member;

public class MemberService {
	
	public Member login(Member member) {
		
		try {
			MemberDAO dao = new MemberDAO();
			member = dao.select(member);
			return member;
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}
	
}
