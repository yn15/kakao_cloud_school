package board.service;

import java.util.ArrayList;

import board.dao.BoardDAO;
import board.vo.Board;
import user.dao.UserDAO;
import user.vo.User;

public class BoardService {
	
	public ArrayList<Board> boardlist() {
		try {
			BoardDAO dao = new BoardDAO();
			ArrayList<Board> board = dao.select();
			return board;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	public Board board(String bNumber) {
		try {
			BoardDAO dao = new BoardDAO();
			Board board = dao.selectByNumber(bNumber);
			return board;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public int boardWrite(Board board) {
		try {
			BoardDAO dao = new BoardDAO();
			int result = dao.insertBoard(board);
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public int hits(String bNumber, int bHits) {
		try {
			BoardDAO dao = new BoardDAO();
			int result = dao.UpdateHits(bNumber, bHits);
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public int likes(String bNumber, int bLikes) {
		try {
			BoardDAO dao = new BoardDAO();
			int result = dao.UpdateLikes(bNumber, bLikes);
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public int boarddelete(String bNumber) {
		try {
			BoardDAO dao = new BoardDAO();
			int result = dao.deleteBoard(bNumber);
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
