package com.mycom.board.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycom.board.domain.MemberDTO;
import com.mycom.board.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/member")
@Slf4j
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	// GET http://localhost:8080/board/memeber/join
	@GetMapping("/join")
	public String joinform() {
		return "/member/join";
	}
	
	@PostMapping("/join")
	public String join(MemberDTO dto) {
		log.info("join() dto" + dto);
		int ok = memberService.insertMember(dto);
		if(ok == 0) {
			return "/member.join_fail";
		}else {
			return "redirect:/member/loginform";
		}
	}
	
	@GetMapping("/loginform")
	public String loginform() {
		return "member/loginform";
	}
	
	@PostMapping("/login")
	public String login(MemberDTO dto, HttpServletRequest request) {
		log.info("login() dto=" +dto);
		int ok = memberService.loginCheck(dto);
		log.info("login() ok=" +ok);
		if(ok == 0) {
			return "member/login_fail";
		}else {
			HttpSession session = request.getSession();
			session.setAttribute("id", dto.getId());
			return "redirect:/member/loginok";
		}
	}
	
	@GetMapping("/loginok")
	public String loginok(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		model.addAttribute("id", id);
		return "member/loginok";
	}
	
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "index";
	}
	
	
	@GetMapping("/updateform")
	public String updateform(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		MemberDTO dto = memberService.selectMember(id);
		log.info("updateform() dto=" +dto);
		model.addAttribute("id", id);
		model.addAttribute("m", dto);
		return "member/updateform";
	}
	
	@PostMapping("/update")
	public String update(MemberDTO dto) {
		log.info("update() dto = " + dto);
		int ok = memberService.updateMember(dto);
		if(ok == 0) {
			return "member/login_fail";
		}else {
			return "redirect:/member/loginok";
		}
		
	}
	
	@GetMapping("/deleteform")
	public String deleteform(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		model.addAttribute("id", id);
		return "member/deleteform";
	}
	
	@PostMapping("/delete")
	public String delete(HttpServletRequest request, MemberDTO dto) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		log.info("delete() id=" + id);
		log.info("delete() dto=" + dto);
		int ok = memberService.deleteMember(dto);
		if(ok == 0) {
			return "member/delete_fail";
		}else {
			session.invalidate();
			return "redirect:/";
		}
	}
}
