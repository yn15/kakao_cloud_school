package com.mycom.board.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.board.dao.BoardDAO;
import com.mycom.board.domain.BoardDTO;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public void insertBoard(BoardDTO dto) {
		boardDAO.insertBoard(dto);
		
	}

	@Override
	public List<BoardDTO> listBoard(HashMap<String, Integer> map) {
		return boardDAO.listBoard(map);
	}

	@Override
	public BoardDTO readBoard(int no) {
		boardDAO.updateHit(no);
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
