package com.springmvc.controller;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
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
	//WEB-INF/views/ 디렉토리 내의 "book.jsp"파일이 뷰로 사용됩니다.
	
	@GetMapping("/add")  
    public String requestAddBookForm(@ModelAttribute("NewBook") Book book) {  
        return "addBook";
    }  
    @PostMapping("/add") 
    public String submitAddNewBook(@ModelAttribute("NewBook") Book book, HttpServletRequest request) {
    	MultipartFile bookImage = book.getBookImage();  
    	//신규 도서 등록 페이지에서 커멘드 객체의매개변수 중 도서 이미지에 해당하는 매개변수를
    	//MultipartFile 객체의 bokImage 변수로 전달합니다.
    	 String saveName = bookImage.getOriginalFilename();  
         File saveFile = new File("C:\\upload", saveName); 
        
        if (bookImage != null && !bookImage.isEmpty()) {
            try {
                bookImage.transferTo(saveFile);  
            } catch (Exception e) {
                throw new RuntimeException("도서 이미지 업로드가 실패하였습니다", e);
            }
        }
    	
        bookService.setNewBook(book); 
        return "redirect:/books"; 
    } 
	
	
	/*
	 * @PostMapping("/add") public String
	 * submitAddNewBook(@ModelAttribute("NewBook") Book book) {
	 * bookService.setNewBook(book); //setNewBook 메서드를 호출하여 저장하는 역할 return
	 * "redirect:/books"; }//redirect:/books를 반환하여 "/books" 경로로 리다이렉트합니다
	 */	
	@ModelAttribute
	public void addAttributes(Model model) {
		model.addAttribute("addTitle", "신규 도서 등록");
	}//모델에 "addTitle"이라는 이름으로 "신규 도서 등록" 값을 추가합니다.
	
	@InitBinder
	//사용자가 입력한 데이터가 커멘드 객체의 프로퍼티에 매핑되기 전에 데이터 바인딩을
	//사용자 정의(customizing) 가능
	public void initBinder(WebDataBinder binder) {
		binder.setAllowedFields("bookId","name","unitPrice","author","description","publisher",
								"category","unitInStock","totalPages","releaseDate","condition", "bookImage");
	}//바인딩할 필드를 제한합니다, GET요청으로는 도서 등록 폼을 제공하고,
}//POST요청으로는 도서를 저장하고 "/books"로 리다이렉트합니다.