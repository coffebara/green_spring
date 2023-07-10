package com.springmvc.service;

import java.util.List;
import com.springmvc.domain.Book;

public interface BookService {
	List<Book> getAllBookList();
}
//@Autowired
//- 타입을 기준으로 의존성 주입
//- 같은 타입 빈이 두 개 이상 있을 경우 변수이름으로 빈을 찾음
//- Spring 애노테이션
//
//@Qualifier
//- 빈의 이름으로 의존성 주입
//- Autowired 와 같이 사용
//- Spring 애노테이션
//
//@Resouce
//- name을 속성으 이용하여 빈의 이름을 직접 지정
//- JavaSE의 애노테이션
//
//@Inject
//- Autowired 애노테이션을 사용하는 것과 같다
//- javaSe의 애노테이션