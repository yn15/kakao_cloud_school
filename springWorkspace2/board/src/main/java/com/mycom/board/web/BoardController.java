package com.mycom.board.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	// http://localhost:8080/board/read/no
	@GetMapping("/read/{no}")
	public String read(@PathVariable(value = "no") int no, Model model) {
		BoardDTO dto = boardService.readBoard(no);
		log.info("read() dto="+dto);
		model.addAttribute("b", dto);
		return "read";
	}
	
	@GetMapping("/updateform/{no}")
	public String updateform(@PathVariable(value="no") int no, Model model) {
		BoardDTO dto = boardService.read4Update(no);
		log.info("updateform() dto=" +dto);
		model.addAttribute("b", dto);
		return "updateform";
	}
	
	@PostMapping("/update")
	public String update(BoardDTO dto) {
		log.info("update() dto=" + dto);
		int ok = boardService.updateBoard(dto);
		log.info("update() ok=" + ok);
		if(ok==0) {
			return "fail";
		} else {
			return "redirect:/list";
		}
	}
	
	@PostMapping("/delete")
	public String delete(BoardDTO dto) {
		log.info("delete() dto=" + dto);
		int ok = boardService.deleteBoard(dto);
		if(ok==0) {
			return "fail";
		} else {
			return "redirect:/list";
		}
	}
}
 