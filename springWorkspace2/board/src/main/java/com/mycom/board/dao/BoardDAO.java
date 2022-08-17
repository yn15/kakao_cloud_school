package com.mycom.board.dao;

import java.util.List;

import com.mycom.board.domain.BoardDTO;

public interface BoardDAO {
	// 저장, 리스트, 조회수 증가, 읽기, 수정, 삭제
	
	public void insertBoard(BoardDTO dto);
	public List<BoardDTO> listBoard();
	public void updateHit(int no);
	public BoardDTO getBoard(int no);
	public int updateBoard(BoardDTO dto);
	public int deleteBoard(BoardDTO dto);
	
}
