package org.nullmaster.controller;

import java.io.File;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class HomeController {
	
	@RequestMapping("uploadForm")
	public String uploadForm() {
		return "uploadForm";
	}
	
//	@RequestMapping("uploadPro")
//	public String uploadPro() {
//		return "uploadPro";
//	}
	
	@RequestMapping("uploadPro")
	public String uploadPro(MultipartFile save, String id) {
		
		File f = new File("/Users/youngjoon/Desktop/" + save.getOriginalFilename());
		try {
			save.transferTo(f); // �뾽濡쒕뱶
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		save.getOriginalFilename(); // �뙆�씪紐� �솗�씤
//		save.getContentType(); // �뙆�씪 醫낅쪟
//		save.getSize(); // �뙆�씪 �겕湲�
		
		return "uploadPro";
	}
	
}
