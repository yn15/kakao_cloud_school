package com.mycom.board.web;

import java.util.HashMap;
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
	public String list0() {
		return "redirect:/list/1";
	}
	
	@GetMapping("/list/{pg}")
	public String list(@PathVariable(value="pg") int pg, Model model) {
		log.info("list() pg=" + pg);
		int size = 10; // 한 페이지에 보여줄 글의 수
		int begin = (pg-1)*size; // 시작 글번호(인덱스)
		int count = boardService.countBoard(); // 글의 총 개수
		log.info("list() count=" + count);
		int totalPage = count/size + (count%10==0 ? 0 : 1); // 총 필요 페이지
		log.info("list() totalPage=" + totalPage);
		int pageSize = 10; // 한 페이지에 보여줄 링크의 수
		int startPage = ((pg-1) / pageSize * 10) + 1;  // 시작링크
		int endPage = startPage+(pageSize-1); // 끝 링크
		if(endPage > totalPage) {
			endPage = totalPage;
		}
		int max = count - (pg-1) * size; // 현재 페이지의 가장 큰 수
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("begin", begin);
		map.put("size", size);
		List<BoardDTO> list = boardService.listBoard(map);
//		List<BoardDTO> list = boardService.listBoard();
		log.info("list() list="+list);
		model.addAttribute("list", list);
		model.addAttribute("pg", pg);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("max", max);
		
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
	
	@GetMapping("/write300")
	public String write300() {
		for (int i = 1; i<=300; i++) {
			BoardDTO dto = new BoardDTO();
			dto.setName("타잔" + i);
			dto.setPasswd("1234");
			dto.setTitle("호랑이" + i);
			dto.setContent("강아지" + i);
			boardService.insertBoard(dto);
		}
		return "redirect:/list";
	}
}
 