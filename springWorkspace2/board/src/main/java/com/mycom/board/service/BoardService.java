package com.mycom.board.service;

import java.util.List;

import com.mycom.board.domain.BoardDTO;

public interface BoardService {
	// 저장, 리스트, 읽기, 수정, 삭제
	public void insertBoard(BoardDTO dto);
	public List<BoardDTO> listBoard();
	public BoardDTO readBoard(int no);
	public BoardDTO read4Update(int no);
	public int updateBoard(BoardDTO dto);
	public int deleteBoard(BoardDTO dto);
}
