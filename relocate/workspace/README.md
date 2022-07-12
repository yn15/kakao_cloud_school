루프백 주소 : 자신의 컴퓨터 아이피(localhost, 127.0.0.1)
cmd : inpconfig

아이피 컴퓨터를 찾아가기 위한 값



---------
모델1 : hthml, css, javascript, java가 같은 파일에 있다
        문제점
        1. 디자인 변경시 디자이너가 못 건드림, 프로그래머가 항상 따라다니면서 수정을 도와줘야한다
        2. 디자인을 개편하거나 프로그램을 개편하면 처음부터 다시 만들어야한다

모델 2 : 
        화면단(presention)과 비즈니스로직(DB에 데이터 읽고 쓰는 업무) 분리시키자
        ==> MVC
            M - model, 비즈니스로직(DB에 데이터 읽고 쓰기)
            V - view, 프리젠테이션(html, css, javascript, 최소한의 java코드)
            C - controller - view와 model의 가교 역할(서블릿의 역할 중요)

            ==> 이를 프레임 워크화 - Spring framework

            디자인 파트에 자바 소스가 별로 없어서 디자이너가 수정 가능
            모델단 냅두고 프리젠테이션만 새로 만들 수 있음 - 디자인만 수정 가능

모델2 방식의 게시판을 만든다 
    DB가 없으니까 Model단에서 가짜 데이터를 만들고
    컨트롤러를 통해서 이 데이터를 View단으로 보낸다

    모든 요청은 컨트롤러가 받는다
    컨트롤러가 고객의 요청을 분석해서 모델로부터 데이터를 가져와 request객체에 저장하고 jsp로 전달한다.
    그러면 jsp는 request 객체로부터 값을 읽어서 출력하는 작업을 한다.

    서블릿을 컨트롤러로 사용할 예정
    요청이 list.jsp, write.jsp, view.jsp
    요청시 기본 파라미터로 cmd를 넘겨준다
    cmd(list, write, view, save)

    모델은 Dto(Data transfer object) - 디비의 테이블과 1대1 맵핑인 경우가 많다
            택배상자                    디비의 필드명들이 클래스의 멤버변수가 된다.
                                       여러개의 테이블이 조인되서 올 때는 테이블과 1대1 맵핑이 아니다.

            Dao(Data access object) - 디비에 가서 데이터를 읽어오거나 데이터를 쓰거나 하는 일을 하는 클래스이다.
            택배배달하시는 분


# JSP
