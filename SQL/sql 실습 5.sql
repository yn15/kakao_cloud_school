CREATE DATABASE moviedb;
USE moviedb;

CREATE TABLE movieTBL (
	movie_id INT,
    movie_title VARCHAR(30),
    movie_script LONGTEXT,
    movie_film LONGBLOB
) DEFAULT CHARSET = utf8mb4;

-- 데이터를 입력
insert into movietbl values(1, '쉰들러 리스트', 
	load_file('C:\sql\Schindler.txt'),
    load_file('C:\sql\Schindler.mp4')
);

select * from movietbl;

delete from movieTBL;
-- 환경설정이 안되었기 때문에 정상적으로 동작하지 않음
-- 설정 필요

select movie_film
from movietbl
where movie_id=1
into dumpfile 'C:/sql/video.output.mp4';
