package com.springmvc.repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.springmvc.domain.Book;

public interface BookRepository {
		List<Book> getAllBookList();
		List<Book> getBookListByCategory(String category);
		Set<Book> getBookListByFilter(Map<String, List<String>> filter);
		Book getBookById(String bookId);
		
}
//사용자가 /filter/{bookFilter} 경로로 GET 요청을 보냅니다.
//Spring MVC는 {bookFilter}에 해당하는 값을 추출하여 bookFilter 변수에 바인딩합니다
//이 변수는 Map<Spring, List<String>> 형태로 선언되어 있으며,
//genre=romance, author=John과 같은 매트릭스 변수를 파싱하여 Map 형태로 저장합니다.
//bookService.getBookListByFilter(bookFilter)를 호출하여 해당 필터에 맞는
//도서 목록을 가져옵니다. bookByFilter 변수에 결과를 저장합니다.
//모델에 bookList라는 이름으로 도서 목록을 추가합니다.
//"books"라는 뷰를 반홥합니다.
//Spring MVC는 "books"라는 뷰를 뷰 리졸버를 통해 찾아 처리하고,
//도서 목록을 출력하는데 사용합니다.