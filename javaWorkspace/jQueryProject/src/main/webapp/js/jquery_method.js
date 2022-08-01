


// ready라는 event는 로딩되어서 사용할 준비가 끝났을 때 발생하는 event
// document가 ready되면.. 내용이 출력되기 위해 DOM이 생성 됐다는 의미
// $(document).on("ready", function() {
	/*
	$("li").on("click", function() {
		// 지금 발생한 이벤트의 source(event가 발생한 객체)를 알고 싶어요
		// this가 event handler에서 사용될 경우
		// 이 this는 이벤트 source에 대한 문서객체가 되요!
		// 우리는 jQuery를 하고 있고 문서객체를 jQuery객체로 변환해서 사용
		console.log($(this).text());
	});
	*/
// });

/*
$(document).ready(function() {
	$("li").click(function (){
		console.log($(this).text());
	});
})
*/

// document read 축약

$(function() {
	$("li").click(function (){
		console.log($(this).text());
	});
})



// event handler
/*
function myFunc() {
	// 현재 선택된 option이 어떤놈인지 알아내야함
	$("#myDiv").text($("option:selected").text());
}

function printRegion() {
//	console.log($("[type=checkbox]:checked+span").text());
	// 선택된 checkbox를 개별적으로 처리하고 싶어요!
	// each안에는 콜백함수가 와요!
	$("[type=checkbox]:checked+span").each(function(idx, item) {
		// idx : index를 의미하고 0부터 1씩 증가
		// item : 현재 수행시키려는 문서객체를 지정(document object)
		console.log($(item).text());
	})
}
*/



function myFunc() {
	// method를 알아보아요!
	// css는 style을 변경시킴 => repaint가 발생됨 ( 결과적으로 느려짐 )
	// $("#myDiv").css("color","red");
	// $("#myDiv").css("background-color","yellow");
	// $("#myDiv").addClass("myClass"); // style 처리는 이 방식으로 처리해야함
	// removeClass() syle를 제거할 떄 사용
	// text() : tag사이의 글자 가져오는 method
	// text("변경!") : tag사이의 글자 변경 method
	// $("#myDiv").text();
	// val() : 사용자 입력 양식 ( 입력 상자) 안에 들어있는 값을 가져오는 method
	// val("값을 변경해요!") : 사용자 입력 양식 ( 입력 상자) 안에 들어있는 값을 변경하는 method
	// attr() : 속성의 값을 알아오거나 혹은 수정할때 사용
	// console.log($("input[type=text]").attr("size"));
	// $("input[type=text]").attr("size", "30");
	// removeAttr("size") : 특정 속성을 제거
	// each() : 반복처리할 떄 사용
	// remove() : 칮은 element를 삭제
	// $("#myDiv").remove();
	// empty() : 삭제는 삭제인데.. 찾은 element는 삭제하지 않고 그 후손들만 삭제
	// 여기까지는 모두 일단 내가 제어아길 원하는 element를 먼저 찾고 method를 적용
	// 새로운 element를 추가하려면 어떻게 해야할까
	// <li>홍길동</li>
	// <li></li> 먼저 element부터 만들고
	// <li></li> 태그 사이에 글자를 넣어야 함
	// <li>강감찬</li>
	
	// let li = $("<li></li>").text("강감찬");
	// 원하는 element를 만들었으니 원하는 위치에 붙여야 함
	// 화면에 element를 붙이기 위해서는 총 4개의 method가 있어야함
	// 1. append() : 자식으로 맨 마지막에 붙임
	// $("ul").append(li);
	// 2. prepend() : 자식으로 맨 처음에 붙임
	// $("ul").prepend(li);
	// 3. after() : 형제로 바로 뒤에 붙음
	// $("li:eq(2)").after(li);
	// 4. before() : 형제로 바로 앞에 붙임
	
	// on() method는 event를 등록하는 method(event발생시 실행을 지정)
}