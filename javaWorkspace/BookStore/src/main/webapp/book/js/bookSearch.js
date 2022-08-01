/**
 * 
 */
 
 function search() {
	let keyword = $("#searchKeyword").val();
	let requestURL = "http://localhost:8080/book/bsearch" + "?keyword=" + keyword;
	window.location.href = requestURL; 
}

 function del(bisbn, keyword) {
	let requestURL = "http://localhost:8080/book/bdelete" + "?bisbn=" + bisbn + "&keyword=" + keyword;
	window.location.href = requestURL;
}