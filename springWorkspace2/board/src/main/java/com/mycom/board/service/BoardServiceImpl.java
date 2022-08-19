package com.mycom.board.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycom.board.dao.BoardDAO;
import com.mycom.board.domain.BoardDTO;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public void insertBoard(BoardDTO dto) {
		boardDAO.insertBoard(dto);
		// int a = 1/0; 에러 때문에 insert 롤백
	}

	@Override
	public List<BoardDTO> listBoard(HashMap<String, Integer> map) {
		return boardDAO.listBoard(map);
	}
	
	@Transactional // 원하는 곳에 rollback 가능
	@Override
	public BoardDTO readBoard(int no) {
		boardDAO.updateHit(no);
//		int a = 1/0; 오류로 인해 조회수가 업데이트 되지 않음 (rollback 됨)
		return boardDAO.getBoard(no);
	}

	@Override
	public int updateBoard(BoardDTO dto) {
		return boardDAO.updateBoard(dto);
	}

	@Override
	public int deleteBoard(BoardDTO dto) {
		return boardDAO.deleteBoard(dto);
	}

	@Override
	public BoardDTO read4Update(int no) {
		return boardDAO.getBoard(no);
	}

	@Override
	public int countBoard() {
		return boardDAO.countBoard();
	}

}
