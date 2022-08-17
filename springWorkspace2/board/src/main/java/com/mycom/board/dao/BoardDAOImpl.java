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
		// TODO Auto-generated method stub
		
	}

	@Override
	public BoardDTO getBoard(int no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateBoard(BoardDTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBoard(BoardDTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}
 
}
