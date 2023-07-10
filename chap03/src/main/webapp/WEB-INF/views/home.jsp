<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
<!-- root-context.xml
뷰( JSP 웹 페이지)와 관련 없는 빈 객체를 설정
서비스, 저장소, 데이터베잇, 로그 드으 웹 애플리케이션의 비지니스 로직을 위한 컨텍스트를 설정
servlet-context.xml
뷰( JSP 웹 펭지)와 관련 있는 빈 객체를 설정
컨트롤러, MultipartResolver, Interceptor, URI와 관련 설정을 담는 클래스를 설정

prefix  속성
	JSP 파일이 위치한 경로를 나타내느 ㄴ접두어
	벼롣 설저잉 없는 경우에 접두어 ".jsp"를 사용.
suffix 속성
	뷰 이름의 뒤에 '.jsp'를 붙여서 jsp 파일을 나타내는 접미어로 생략 가능
	
 -->