package com.mycom.board.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycom.board.domain.MemberDTO;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace = "com.mycom.board.mapper.MemberMapper";
	
	public int insertMember(MemberDTO dto) {
		return sqlSession.insert(namespace+".insertMember", dto);
	}

	public int loginCheck(MemberDTO dto) {
		return sqlSession.selectOne(namespace+".loginCheck", dto);
	}

	public MemberDTO selectMember(String id) {
		return sqlSession.selectOne(namespace+".selectMember", id);
	}

	public int updateMember(MemberDTO dto) {
		return sqlSession.update(namespace+".updateMember", dto);
	}

}
