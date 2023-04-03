desc trip_board_comment;
/*
이름                널?       유형             
----------------- -------- -------------- 
T_CO_NO           NOT NULL NUMBER         
T_COMMENT_CONTENT NOT NULL VARCHAR2(1000) 
T_COMMENT_DATE             DATE           
T_BO_NO                    NUMBER         
USER_ID                    VARCHAR2(50) 
*/

--  댓글 번호로 댓글 1개 보기
select t_co_no, t_comment_content, t_comment_date, t_bo_no, user_id from trip_board_comment where t_co_no=1;

-- 댓글 전체 보기
select * from trip_board_comment;
        
-- 댓글 수정
update trip_board_comment set t_comment_content='댓글수정' where t_co_no=2;

-- 댓글 삭제
delete trip_board_comment where t_co_no=3;

-- 댓글 총 개수
select count(*) cnt from trip_board_comment;