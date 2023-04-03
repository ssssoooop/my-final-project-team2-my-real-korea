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

-- 동행게시판 댓글 insert
insert into trip_board_comment(t_co_no, t_comment_content, t_comment_date, t_bo_no, user_id) 
                        values(TRIP_BOARD_COMMENT_T_CO_NO_SEQ.nextval, '댓글1', sysdate, 1, 'user2');
insert into trip_board_comment(t_co_no, t_comment_content, t_comment_date, t_bo_no, user_id) 
                        values(TRIP_BOARD_COMMENT_T_CO_NO_SEQ.nextval, '댓글2', sysdate, 2, 'user3');
insert into trip_board_comment(t_co_no, t_comment_content, t_comment_date, t_bo_no, user_id) 
                        values(TRIP_BOARD_COMMENT_T_CO_NO_SEQ.nextval, '댓글3', sysdate, 3, 'user1');