package com.shinhan.spring.controller.s3;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.shinhan.spring.model.board.BoardDTO;
import com.shinhan.spring.model.board.BoardService;
import com.shinhan.spring.model.s3.S3Uploader;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
 

@Controller
@RequiredArgsConstructor
@Slf4j
public class ImageUploadController {
    private final S3Uploader uploader ;
	final BoardService boardService;
	
	
	 
    @PostMapping("/upload.do")
    public String uploadImage(
			MultipartHttpServletRequest multipart  , HttpSession session) throws Exception {      
        	HttpServletRequest request = (HttpServletRequest)multipart;	
        	MultipartFile multipartFile1 = multipart.getFile("pic1");
        	MultipartFile multipartFile2 = multipart.getFile("pic2");
            String imageUrl1 = uploader.upload(multipartFile1, "images");
            String imageUrl2 = uploader.upload(multipartFile2, "images");
            String title = request.getParameter("title");
    		String content = request.getParameter("content");
    		String writer = request.getParameter("writer");
    		BoardDTO board = BoardDTO.builder().title(title).writer(writer).pic1(imageUrl1).pic2(imageUrl2)
    				.content(content).build(); 	
    		boardService.insertDept(board);
            return "redirect:upload.do";
    }
}


