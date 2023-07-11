package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.domain.Book;
import com.springmvc.repository.BookRepository;

//@Service
public class BookServiceImpl implements BookService{
//	@Autowired
	private BookRepository bookRepository;
//Spring은 BookRepository 타입에 맞는 빈을 찾아 bookRepository 필드에 주입합니다.	
	public List<Book> getAllBookList() {
		return bookRepository.getAllBookList();
	}
}
