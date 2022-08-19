package com.mycom.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.board.dao.MemberDAO;
import com.mycom.board.domain.MemberDTO;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	
	public int insertMember(MemberDTO dto) {
		return memberDAO.insertMember(dto);
	}
	
	public int loginCheck(MemberDTO dto) {
		return memberDAO.loginCheck(dto);
	}

	public MemberDTO selectMember(String id) {
		return memberDAO.selectMember(id);
		
	}

	public int updateMember(MemberDTO dto) {
		return memberDAO.updateMember(dto);
	}
}
