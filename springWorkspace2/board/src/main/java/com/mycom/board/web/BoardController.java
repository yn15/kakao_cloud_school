package com.mycom.board.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.mycom.board.domain.BoardDTO;
import com.mycom.board.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/writeform")
	public String writeform() {
		return "writeform";
	}
	
	@PostMapping("/write")
	public String write(BoardDTO dto) {
		log.info("write dto="+dto);
		boardService.insertBoard(dto);
		return "redirect:/list";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		List<BoardDTO> list = boardService.listBoard();
		log.info("list() list="+list);
		model.addAttribute("list", list);
		return "list";
	}
}
 