/**
 * 
 */
 function myFunc() {
	// jQuery
	// 1. 내가 원하는 Element를 찾아서 jQuery객체로 변환
	//    HTML Element를 referencing하는 jQuery객체를 생성
	//    selector 이용
	//	  1-1. 전체 선택자(universial selector)
	//	  $("문자열 형태로 selector를 명시")
	//	  $ 기호로 "*"
	//	  $("*").css("color", "red"); // 전경색(글자색)
	//	  1-2. 태그 선택자(tag selector)
	//	  alert($("div").text());
	//	  $("div").text("깔깔깔깔깔깔깔깔깔깔깔깔깔깔깔깔"); // tag사이의 글자를 인자를 이용해 변환
	//	  1-3. 아이디 선택자(id selector)
	// 	  기호로 "#"
	//	  $("#myLi").remove();
	//	  1-4 class 선택자(class selector)
	//	  $(".haha").css("background-color", "red");
	//	  더불어서 block-level element와 inline element에 대해서도 알아보았어요
	//	  1-5 구조 선택자
	//	  기호로 ">"(자식 선택자) " " (후손 선택자)
	//	  $("div li").css("color", "blue");
	//	  $("ul.myclass > li").css("color", "yellow");
	//	  기호로 "+"는 바로 다음에 나오는 형제를의미
	//	  기호로 "~"는 바로 다음에 나오는 형제 모두를 의미
	//	  $("#seoul + li").remove();
	//	  $("#seoul ~ li").remove();
	//	  참고로 특수 선택자
	// 	  기호로 :xxx
	//    $("ul.myclass > li:first + li").remove();
	//	  $("ul.myclass > li:last").remove();
	//	  $("ul.myclass > li:nth-child(2)").remove();  // 1 2 3
	//	  1-6 속성 선택자
	//	  기호로 "[]"
	alert($("[size=30]").val());
}