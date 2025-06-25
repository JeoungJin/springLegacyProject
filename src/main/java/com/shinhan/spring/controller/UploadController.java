package com.shinhan.spring.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.shinhan.spring.model.board.BoardDTO;
import com.shinhan.spring.model.board.BoardService;
import com.shinhan.spring.util.UploadFileUtils;

@Controller
public class UploadController {

	
	@Autowired
	BoardService boardService;
	
	
	@GetMapping("/upload.do")
	public String f_get() {
		return "upload/uploadForm";
	}
	
	//@PostMapping("/upload.do")
	public  @ResponseBody  String insertPost( 
			MultipartHttpServletRequest multipart  , HttpSession session) {

		HttpServletRequest request = (HttpServletRequest)multipart;		
		String uploadPath = session.getServletContext().getRealPath("./resources/uploadImage");
		MultipartFile multipartFile = multipart.getFile("pic1");
		String fileName = multipartFile.getOriginalFilename(); // ̹    ̸  
		String newfileName = "";
		String ymdpath = UploadFileUtils.calcPath(uploadPath);		 
		try {
			newfileName = UploadFileUtils.fileUpload(uploadPath, fileName,
					multipartFile.getBytes(), ymdpath);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "redirect:insert.do";
		}
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String writer = request.getParameter("writer");
		BoardDTO board = BoardDTO.builder().title(title)
				.writer(writer)
				.content(content).build(); 	
	 
		board.setPic1(ymdpath + File.separator + newfileName);
 
		boardService.insertDept(board);
		return "OK";
	}

	
}










