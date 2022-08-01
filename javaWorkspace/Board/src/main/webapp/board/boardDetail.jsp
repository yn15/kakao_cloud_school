<%@page import="board.vo.Board"%>
<%@page import="user.vo.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="comment.vo.Comment"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8">
    <title>게시판 글 상세보기</title>
	<!-- Bootstrap CDN -->
	<!-- CSS only -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
	
	<!-- jQuery CDN -->
	<script src="https://code.jquery.com/jquery-2.2.4.min.js" integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44=" crossorigin="anonymous"></script>
	
	<!-- Custom js -->
	<script src="/book/book/js/bookSearch.js"></script>
	
	<style>
		.bd-placeholder-img {
	        font-size: 1.125rem;
	        text-anchor: middle;
	        -webkit-user-select: none;
	        -moz-user-select: none;
	        user-select: none;
		}

		@media (min-width: 768px) {
	        .bd-placeholder-img-lg {
	          font-size: 3.5rem;
	        }
		}

		.b-example-divider {
	        height: 3rem;
	        background-color: rgba(0, 0, 0, .1);
	        border: solid rgba(0, 0, 0, .15);
	        border-width: 1px 0;
	        box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em rgba(0, 0, 0, .15);
		}

		.b-example-vr {
	        flex-shrink: 0;
	        width: 1.5rem;
	        height: 100vh;
		}

		.bi {
	        vertical-align: -.125em;
	        fill: currentColor;
		}

		.nav-scroller {
	        position: relative;
	        z-index: 2;
	        height: 2.75rem;
	        overflow-y: hidden;
		}

		.nav-scroller .nav {
	        display: flex;
	        flex-wrap: nowrap;
	        padding-bottom: 1rem;
	        margin-top: -1px;
	        overflow-x: auto;
	        text-align: center;
	        white-space: nowrap;
	        -webkit-overflow-scrolling: touch;
		}
	</style>
    
    <!-- Custom styles for this template -->
    <link href="/book/book/css/dashboard.css" rel="stylesheet">
</head>
<body>
<%
	User user = (User) session.getAttribute("user");
	Board board = (Board) request.getAttribute("board");		
%>

<header class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
  <a class="navbar-brand col-md-3 col-lg-2 me-0 px-3 fs-6" href="#"><%=user.getUserName()%></a>
  <button class="navbar-toggler position-absolute d-md-none collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#sidebarMenu" aria-controls="sidebarMenu" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <input id="searchKeyword" class="form-control form-control-dark w-100 rounded-0 border-0" type="text" placeholder="Search" aria-label="Search"> <!-- 검색창 -->
  <div class="navbar-nav">
    <div class="nav-item text-nowrap">
      <a class="nav-link px-3" href="javascript:search()">Search</a> 
    </div>
  </div>
</header>


<div class="container-fluid">
  <div class="row">
    <nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
      <div class="position-sticky pt-3 sidebar-sticky">
        <ul class="nav flex-column"> </ul>
        <ul class="nav flex-column mb-2"> </ul>
      </div>
    </nav>

    <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
      <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom"></div>
      <div class="row">
		  <h2 class="col-sm-8"><%=board.getbTitle()%></h2>
	  </div>
	  <div>
	  	 <form action = "/board/boardlist" method = "post">
	  	 	<input type="submit" value="목록으로 돌아가기"> 
	  	 </form>
	  </div>
	  <br>
	  <% if(user.getUserID().equals(board.getUserID())) { %>
	  <div>
	  	
	  	 <form action = "/board/boarddelete" method = "post">
	  	 	<input type="hidden" name="bNumber" value="<%=board.getbNumber()%>">
	  	 	<input type="submit" value="게시글 삭제">
	  	 </form>
	  </div>
	  <% } %>
      <div class="table-responsive" style="margin-top:20px;">
      
        <table class="table table-striped table-sm">
          <colgroup>
          	<col width="15%">
          	<col width="*">
          </colgroup>
          <thead>
            <tr>
              <th scope="col">분류</th>
              <th scope="col">내용</th>
            </tr>
          </thead>
          <tbody>
			<tr>
				<td>번호</td>
				<td><%=board.getbNumber()%></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><%=board.getbTitle()%></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><%=board.getUserID()%></td>
			</tr>
			<tr>
				<td>작성일</td>
				<td><%=board.getbDate()%></td>
			</tr>
			<tr>
				<td>조회수</td>
				<td><%=board.getbHits()%></td>
			</tr>
			<tr>
				<td>좋아요</td>
				<td><%=board.getbLikes()%></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><pre><%=board.getbContents()%></pre></td>
			</tr>
			<tr>
				<td>댓글수</td>
				<td><%=board.getList().size()%></td>
			</tr>
          </tbody>
        </table>
        <div>
        	<form action="/board/boardlike" method="post">
				<input type="hidden" name="bNumber" value="<%=board.getbNumber()%>">
				<input type="hidden" name="bHits" value="<%=board.getbHits()%>">
				<input type="hidden" name="bLikes" value="<%=board.getbLikes()+1%>">
				<button type="submit">좋아요</button>
        	</form>
        </div>
        <div>
        	댓글 쓰기
        	<form action="/board/comment" method="post">
				<input type="text" name="content" required>
				<input type="hidden" name="bNumber" value="<%=board.getbNumber()%>">
				<input type="hidden" name="bHits" value="<%=board.getbHits()%>">
				<button type="submit">작성 완료</button>
        	</form>
        </div>
        <div>
        	<h3>댓글</h3>
        	<table class="table table-striped table-sm">
	          <colgroup>
	          	<col width="15%">
	          	<col width="*">
	          </colgroup>
	          <thead>
	            <tr>
	              <th scope="col">작성자</th>
	              <th scope="col">내용</th>
	            </tr>
	          </thead>
	          <tbody>
	          	
				<tr>
					<% for(Comment c : board.getList()) { %>
					<td><%= c.getCuserID() %></td>
					<td><%= c.getContent() %></td>
					<td>
					<% if(user.getUserID().equals(c.getCuserID())) { %>
						<form action = "/board/commentdelete" method = "post">
							<input type="hidden" name="cID" value="<%=c.getcID()%>">
							<input type="hidden" name="bHits" value="<%=board.getbHits()%>">
	  	 					<input type="hidden" name="bNumber" value="<%=board.getbNumber()%>">
	  	 					<input type="submit" value="댓글 삭제">
	  	 				</form>
					<% } %>
					<td>
				</tr>
				<% } %>
	          </tbody>
	        </table>
        
        </div>
      </div>
    </main>
  </div>
</div>
</body>
</html>