package com.springmvc.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.domain.Book;
import com.springmvc.service.BookService;



//컨트롤러
//웹 브라우저에서 들어온 사용자 요청을 구현된 메서드에서 처리하고
//그 결과를 빈에 전달하는 스프링의 빈 객체

@Controller
@RequestMapping("/books") // 요청대로 매핑경로 설정
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping
	public String requestBookList(Model model) {
		List<Book> list = bookService.getAllBookList();
		model.addAttribute("bookList", list);
		return "books";
	}


	@GetMapping("/all")
	public ModelAndView requestAllBooks() {
		ModelAndView modelAndView = new ModelAndView();
		List<Book> list = bookService.getAllBookList();                         
		modelAndView.addObject("bookList", list);
		modelAndView.setViewName("books");
		
		return modelAndView;
	}

	@GetMapping("/{category}")
	public String requestBooksByCategory(@PathVariable("category") String bookCategory, Model model) {
		List<Book> booksByCategory = bookService.getBookListByCategory(bookCategory);
		model.addAttribute("bookList", booksByCategory);
		
		return "books";
	}
	
	@GetMapping("filter/{bookFilter}")
//	@MatrixVariable 어노테이션은 URL 경로의 일부인 행렬 변수를 메서드 인자
	public String requestBooksByFilter(@MatrixVariable(pathVar="bookFilter") Map<String, List<String>> bookFilter, Model model) {
//		pathVar 속성은 URL 경로에서 행렬 변수의 이름
		Set<Book> booksByFilter = bookService.getBookListByFilter(bookFilter);
//bookService 객체의 getBookListByFilter 메서드를 호출하여
//bookFilter를 인자로 전달하고, 결과를 booksByFilter에 저장
		model.addAttribute("bookList", booksByFilter);
		
		return "books";
	}
	
	@GetMapping("book")
	public String requestBookById(@RequestParam("id") String bookId, Model model) {
		Book booksById = bookService.getBookById(bookId);
//@RequestParam 어노테이션은 요청의 쿼리 파라미터를 메서드 인자로 바인딩하도록 지시
//"id"라는 이름의 쿼리 파라미터를 가져와서 String 타입의 bookId 인자에 바인딩합니다.
		model.addAttribute("book", booksById);
		
		return "book";
	}//이 값은 뷰 리졸버에 의해 처리되어 실제 뷰를 결정하는 데 사용됩니다.
}//WEB-INF/views/ 디렉토리 내의 "book.jsp"파일이 뷰로 사용됩니ㅏㄷ.