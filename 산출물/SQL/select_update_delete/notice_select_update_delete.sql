/************* 공지사항 게시판 ******************/
desc notice;

-- rownum 공지사항 게시판 리스트 페이지  (게시물 시작번호~끝번호)
select * from
    (select rownum idx, s.* from
        (select n_no, n_title, n_content, n_date, n_readcount, n_img, user_id from notice
        order by n_no desc) s
    )
where idx >= 1 and idx <= 10;

/******** 공지사항 리스트 정렬 **********/
-- rownum 공지사항 게시판 리스트 페이지  (게시물 시작번호~끝번호) (최신순)
select * from
    (select rownum idx, s.* from
        (select n_no, n_title, n_content, n_date, n_readcount, n_img, user_id from notice
        order by n_date desc) s
    )
where idx >= 1 and idx <= 10;

-- rownum 공지사항 게시판 리스트 페이지  (게시물 시작번호~끝번호) (오래된순)
select * from
    (select rownum idx, s.* from
        (select n_no, n_title, n_content, n_date, n_readcount, n_img, user_id from notice
        order by n_date asc) s
    )
where idx >= 1 and idx <= 10;

-- rownum 공지사항 게시판 리스트 페이지  (게시물 시작번호~끝번호) (조회수 높은순)
select * from
    (select rownum idx, s.* from
        (select n_no, n_title, n_content, n_date, n_readcount, n_img, user_id from notice
        order by n_readcount desc) s
    )
where idx >= 1 and idx <= 10;


-- 공지사항 게시판 리스트 보기
select n_no, n_title, n_content, n_date, n_readcount, n_img, user_id from notice 
order by n_no desc;

-- 게시글 번호로 게시물 1개 보기
select n_no, n_title, n_content, n_date, n_readcount, n_img, user_id from notice where n_no=1;

-- 키워드로 검색된 공지사항 게시판 리스트
select * from notice where n_title like '%공지%';
select * from notice where n_title like '%공지%' order by n_no desc;

select * from
    (select rownum idx, s.* from
        (select n_no, n_title, n_content, n_date, n_readcount, n_img, user_id from notice
        where n_title like '%공지사항%'
        order by n_no desc) s
    )
where idx >= 1 and idx <= 10;


-- 검색된 게시글 총 개수
select count(*) cnt from notice where n_title like '%공지%';

-- 게시물 총 개수 세기
select count(*) cnt from notice;

-- 게시물 삭제
delete notice where n_no=1;

-- 게시물 내용 수정
update notice set n_title='제목수정',n_content='내용수정',n_img='img1111.png' where n_no=2;

-- 게시물 조회수 1 증가
update notice set n_readcount=n_readcount+1 where n_no=3;

