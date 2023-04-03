/*************자유게시판 ******************/
desc freeboard;

-- rownum 자유게시판 리스트 페이지  (게시물 시작번호~끝번호)
select * from
    (select rownum idx, s.* from
        (select f_bo_no, f_bo_title, f_bo_content, f_bo_date, f_bo_count, city_no, user_id from freeboard
        order by n_no desc) s
    )
where idx >= 1 and idx <= 10;

-- 리스트 보기
select f_bo_no, f_bo_title, f_bo_content, f_bo_date, f_bo_count, city_no, user_id from freeboard 
order by f_bo_no desc;

-- 게시글 번호로 게시물 1개 보기
select f_bo_no, f_bo_title, f_bo_content, f_bo_date, f_bo_count, city_no, user_id from freeboard where f_bo_no=1;

-- 키워드로 검색된 게시판 리스트
select * from freeboard where f_bo_title like '%추천%';

select * from
    (select rownum idx, s.* from
        (select select f_bo_no, f_bo_title, f_bo_content, f_bo_date, f_bo_count, city_no, user_id from freeboard
        where f_bo_title like '%추천%'
        order by f_bo_no desc) s
    )
where idx >= 1 and idx <= 10;


-- 검색된 게시글 총 개수
select count(*) cnt from freeboard where f_bo_title like '%추천%';

-- 게시물 총 개수 세기
select count(*) cnt from freeboard;

-- 게시물 삭제
delete freeboard where f_bo_no=1;

-- 게시물 내용 수정
update freeboard set f_bo_title='수정',f_bo_content='내용수정', where n_no=3;

-- 게시물 조회수 1 증가
update freeboard set f_bo_count=f_bo_count+1 where f_bo_no=2;
