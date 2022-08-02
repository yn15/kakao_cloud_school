
 
 function getBoard(bNumber, bHits){
	//let requestURL = "http://localhost:8080/board/boarddetail" + "?bNumber=" + bNumber;
	//window.location.href = requestURL;
	var form = document.createElement('form'); // 폼객체 생성
	form.setAttribute('method', 'post'); //get,post 가능
	form.setAttribute('action', "/board/boarddetail"); //보내는 url
	var objs;
	objs = document.createElement('input'); // 값이 들어있는 녀석의 형식
	objs.setAttribute('type', 'hidden'); // 값이 들어있는 녀석의 type
	objs.setAttribute('name', 'bNumber');
	objs.setAttribute('value', bNumber); // 값이 들어있는 녀석의 type
	form.appendChild(objs);
	// hisdhflsnl
	var objs2;
	objs2 = document.createElement('input');
	objs2.setAttribute('type', 'hidden'); // 값이 들어있는 녀석의 type
	objs2.setAttribute('name', 'bHits');
	objs2.setAttribute('value', bHits);
	form.appendChild(objs2);
	
	document.body.appendChild(form);
	form.submit();
}

 function search() {
	let keyword = $("#searchKeyword").val();
	
	var form = document.createElement('form'); // 폼객체 생성
	form.setAttribute('method', 'post'); //get,post 가능
	form.setAttribute('action', "/board/boardsearch");
	
	var objs;
	objs = document.createElement('input'); // 값이 들어있는 녀석의 형식
	objs.setAttribute('type', 'hidden'); // 값이 들어있는 녀석의 type
	objs.setAttribute('name', 'keyword');
	objs.setAttribute('value', keyword); // 값이 들어있는 녀석의 type
	form.appendChild(objs);
	document.body.appendChild(form);
	form.submit();
}


