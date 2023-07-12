package com.springmvc.repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.springmvc.domain.Book;

@Repository
public class BookRepositoryImpl implements BookRepository {

	private List<Book> listOfBooks = new ArrayList<Book>();

	public BookRepositoryImpl() {
		Book book1 = new Book("ISBN1234", "C# 교과서", 30000);
		book1.setAuthor("박용준");
		book1.setDescription("C# 교과서는 생애 첫 프로그래밍 언어로 C#을 시작하는 독자를 대상으로");
		book1.setPublisher("길벗");
		book1.setCategory("IT전문서");
		book1.setUnitsInStock(1000);
		book1.setReleaseDate("2020/05/29");
		Book book2 = new Book("ISBN1235", "Node.js 교과서", 36000);
		book2.setAuthor("조헌영");
		book2.setDescription("이 책은 프론트부터 서버, 데이터베이스, 배포까지");
		book2.setPublisher("길벗");
		book2.setCategory("IT전문서");
		book2.setUnitsInStock(1000);
		book2.setReleaseDate("2020/07/25");
		Book book3 = new Book("ISBN1236", "어도비 XD CC 2020", 25000);
		book3.setAuthor("조헌영");
		book3.setDescription("어도비 XD 프로그램을 통해 UI/UX 디자인을 배우고자");
		book3.setPublisher("길벗");
		book3.setCategory("IT활용서");
		book3.setUnitsInStock(1000);
		book3.setReleaseDate("2019/05/29");

		listOfBooks.add(book1);
		listOfBooks.add(book2);
		listOfBooks.add(book3);
	}

	@Override
	public List<Book> getAllBookList() {

		return listOfBooks;
	}

	@Override
	public List<Book> getBookListByCategory(String category) {
		List<Book> booksByCategory = new ArrayList<Book>();
		for (int i = 0; i < listOfBooks.size(); i++) {
			Book book = listOfBooks.get(i);
			if (category.equalsIgnoreCase(book.getCategory())) {
				booksByCategory.add(book);
			}
			return booksByCategory;
		}
		return booksByCategory;
	}

	@Override
	public Set<Book> getBookListByFilter(Map<String, List<String>> filter) {
		Set<Book> booksByPublisher = new HashSet<Book>();
		Set<Book> booksByCategory = new HashSet<Book>();

		Set<String> booksByFilter = filter.keySet();

		if (booksByFilter.contains("publisher")) {
			for (int j = 0; j < filter.get("publisher").size(); j++) {
				String publisherName = filter.get("publisher").get(j);
				for (int i = 0; i < listOfBooks.size(); i++) {
					Book book = listOfBooks.get(i);

					if (publisherName.equalsIgnoreCase(book.getPublisher())) {
						booksByPublisher.add(book);
					}
				}
			}
		}
		if(booksByFilter.contains("category")) {
			for(int i=0; i<filter.get("category").size(); i++) {
				String category = filter.get("category").get(i);
				List<Book> list= getBookListByCategory(category);
				booksByCategory.addAll(list);
			}
		}
		booksByCategory.retainAll(booksByPublisher);
		return booksByCategory;
	}

	@Override
	public Book getBookById(String bookId) {
		Book bookInfo = null;
		for(int i=0; i<listOfBooks.size(); i++) {
			Book book = listOfBooks.get(i);
			if(book!=null && book.getBookId()!=null && book.getBookId().equals(bookId)) {
				bookInfo = book;
				break;
			}
		}
		if(bookInfo == null) {
			throw new IllegalArgumentException("도서 ID가" + bookId + "인 해당 도서를 찾을 수 없습니다.");
		}
		return bookInfo;
	}// Annotation을 이용한 DI 빈 설정
	//@Component 일반적인 컴포넌트로 등록하기 위한 클래스에 사용합니다.
	
	@Override
	public void setNewBook(Book book) {
		listOfBooks.add(book);
	}
}
