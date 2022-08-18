package com.mycom.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycom.board.domain.BoardDTO;

@Repository
public class BoardDAOImpl implements BoardDAO{
	
	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace = "com.mycom.board.mapper.BoardMapper";
	@Override
	public void insertBoard(BoardDTO dto) {
		sqlSession.insert(namespace+".insertBoard", dto);
		
	}

	@Override
	public List<BoardDTO> listBoard() {
		return sqlSession.selectList(namespace+".listBoard");
	}

	@Override
	public void updateHit(int no) {
		sqlSession.update(namespace+".updateHit", no);
	}

	@Override
	public BoardDTO getBoard(int no) {
		return sqlSession.selectOne(namespace+".getBoard", no);
	}

	@Override
	public int updateBoard(BoardDTO dto) {
		return sqlSession.update(namespace+".updateBoard", dto);
	}

	@Override
	public int deleteBoard(BoardDTO dto) {
		return sqlSession.delete(namespace+".deleteBoard", dto);
	}
 
}
