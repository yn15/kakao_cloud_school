package com.mycom.board.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {
	@GetMapping("/writeform")
	public String writeform() {
		return "writeform";
	}
}
 