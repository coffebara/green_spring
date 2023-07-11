package com.springmvc.controller;

import java.util.List;

import org.springframework.ui.Model;

import com.springmvc.domain.Book;
import com.springmvc.service.BookService;




//@Controller
public class BookController {

//	@Autowired
	private BookService bookService;
	
//	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public String requestBookList(Model model) {
		List<Book> list = bookService.getAllBookList();
		model.addAttribute("bookList", list);
		return "books";
	}
}
//1. 웹 애플리케이션을 개발할 때 유연성과 확장성을 높이려면 BookController
//	컨트롤러에서 저장소 객체인 BookRepository로 직접 접근하지 말고
//	서비스객체인 BookService로 저장소 객체에 접근해야 합니다.
//2. 요청 매핑 @RequestMapping
//3. 요청 처리 메서드
//4. 모델 데이터
//5. 뷰 이름