package com.mycom.board.service;

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
	public List<BoardDTO> listBoard() {
		return boardDAO.listBoard();
	}

	@Override
	public BoardDTO readBoard(int no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateBoard(BoardDTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBoard(BoardDTO dtd) {
		// TODO Auto-generated method stub
		return 0;
	}

}
