function getData(){
	$('tbody').empty();
	let promise = new Promise(function(resovle, reject){
		$.ajax({
			async : true, 
			url : 'http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json',
			type: 'GET',
			data : { 
				key: 'ae2de2e13f21a1aab04ed94560a6d565',
				targetDt: $('#searchDate').val().replace(/\-/g, '')
			},
			timeout: 3000,
			dataType: 'json', 
			success : function(result){
				console.log(result);
				movie = result['boxOfficeResult']['dailyBoxOfficeList'];
	
				resovle(movie);
			},
			error : function(){
				// 만약 서보 호출에 실패하면 이 함수가 호출됨
				alert('error');
			}
		});
	})
	
	promise.then(function(movie){
		
		for(const e of movie){
			let tr = $("<tr></tr>");
            let orderTd = $('<td></td>').text(e['rank']);
            tr.append(orderTd);
            let posterTd = $('<td></td>');
            let posterImg = $("<img />");
            $.ajax({
                  url : 'https://dapi.kakao.com/v2/search/image',
                  type: 'GET',
                  data : { 
                     query: e['movieNm']
                  },
				  headers: {
					 Authorization: 'KakaoAK a9eadee4c24eac5ff2e59296f254f100'
				  },
                  dataType: 'json',
                  success : function(imgResult){
                     posterImg.attr('src', imgResult.documents[0].thumbnail_url);
                  },
                  error : function(){
					 alert("이미지 검색 실패");
                  }
               });
            posterTd.append(posterImg);
            tr.append(posterTd);
            let titleTd = $('<td></td>').text(e['movieNm']);
            tr.append(titleTd);
			let actor;
			$.ajax({
                  async : false, // 데이터가 돌아올때까지 hold되있는것을 sync 아니면 다른 처리를 하고있겠다 async
                  url : 'http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.json',
                  type: 'GET',
                  data : { // 서버쪽에 보낼 데이터
                     key: 'ae2de2e13f21a1aab04ed94560a6d565',
                     movieCd: e['movieCd']
                  },
                  timeout: 3000,
                  dataType: 'json', // 오는 데이터타입 (그냥 올떄는 json문자열로 오기때문에 javascript json 객체로 변환시켜 받아야함)
                  success : function(result){
                     actor = result['movieInfoResult']['movieInfo']['actors'][0]['peopleNm'];
                  	console.log(actor);
                  },
                  error : function(){
                  }
               });
			let actorTd = $('<td></td>').text(actor);
            tr.append(actorTd);
            let deleteTd = $('<td></td>');
            tr.append(deleteTd);
            $('tbody').append(tr);
		}
	})
	
	promise;
}


/*
function getData(){
   // 서버 프로그램을 호출해서 결과를 받아와서 화면처리
   // 비동기 방식으로 처리 (Non-blocking)
   // AJAX를 이용해 처리해보아요
   $.ajax({
      async : true, // 데이터가 돌아올때까지 hold되있는것을 sync 아니면 다른 처리를 하고있겠다 async
      url : 'http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json',
      type: 'GET',
      data : { // 서버쪽에 보낼 데이터
         key: 'ae2de2e13f21a1aab04ed94560a6d565',
         targetDt: $('#searchDate').val().replace(/\-/g, '')
      },
      timeout: 3000,
      dataType: 'json', // 오는 데이터타입 (그냥 올떄는 json문자열로 오기때문에 javascript json 객체로 변환시켜 받아야함)
      success : function(result){
         // 만약 서버 호출이 성공하면 이 함수가 호출됨
         // result는 서버가 전달해준 json에 대한 javascript객체
         console.log(result);
         movie = result['boxOfficeResult']['dailyBoxOfficeList'];
         // 얻어온 값을 이용해서 tag를 만들어야 해요
         // 그리고 DOM에 붙여요
         
         
         //<tr>
         //     <td>1,001</td>
         //     <td>random</td>
         //     <td>data</td>
         //     <td>placeholder</td>
         //     <td>text</td>
         //   </tr>
         
         $('tbody').empty();
         for(const e of movie){
            let tr = $("<tr></tr>");
            let orderTd = $('<td></td>').text(e['rank']);
            tr.append(orderTd);
            let posterTd = $('<td></td>');
            tr.append(posterTd);
            let titleTd = $('<td></td>').text(e['movieNm']);
            tr.append(titleTd);
            let actorTd = $('<td></td>').text();
            tr.append(actorTd);
            let deleteTd = $('<td></td>');
            tr.append(deleteTd);
            $('tbody').append(tr);
         }
         
      },
      error : function(){
         // 만약 서보 호출에 실패하면 이 함수가 호출됨
         alert('error');
      }
   });
}
*/

