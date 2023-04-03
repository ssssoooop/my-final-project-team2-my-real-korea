/*************** user ***********************/
--user_info
insert into user_info(user_id,password,name,nickname,phone,email,birth,address,gender,point,is_admin,mail_auth,mail_key) 
	values('admin','admin0000','관리자','관리자','010-0000-0000','admin0@gmail.com','2000-01-01','테헤란로0',0,0,0,1,0); 

insert into user_info(user_id,password,name,nickname,phone,email,birth,address,gender,point,is_admin,mail_auth,mail_key) 
	values('user1','user1111','회원1','마리코1','010-1111-1111','user1@gmail.com','2001-01-01','테헤란로1',0,0,1,1,0); 

insert into user_info(user_id,password,name,nickname,phone,email,birth,address,gender,point,is_admin,mail_auth,mail_key) 
	values('user2','user2222','회원2','마리코2','010-2222-2222','user2@gmail.com','2002-02-02','테헤란로2',1,0,1,1,0); 

insert into user_info(user_id,password,name,nickname,phone,email,birth,address,gender,point,is_admin,mail_auth,mail_key) 
	values('user3','user3333','회원3','마리코3','010-3333-3333','user3@gmail.com','2003-03-03','테헤란로3',1,0,1,1,0); 
--user_photo
insert into user_img(user_img_no,user_img_url,user_id) values(10,'010.png','admin');
insert into user_img(user_img_no,user_img_url,user_id) values(11,'011.png','user1');
insert into user_img(user_img_no,user_img_url,user_id) values(12,'012.png','user2');
insert into user_img(user_img_no,user_img_url,user_id) values(13,'013.png','user3');
--user_add_info
insert into user_add_info(introduce,alcohol,smoking,user_id) values('관리자인사',0,0,'admin'); 
insert into user_add_info(introduce,alcohol,smoking,user_id) values('안녕1',0,0,'user1'); 
insert into user_add_info(introduce,alcohol,smoking,user_id) values('안녕2',1,0,'user2'); 
insert into user_add_info(introduce,alcohol,smoking,user_id) values('안녕3',0,1,'user3'); 

/*************** city ***********************/
-- city
insert into city(city_no,city_name,latitude,longitude) values(city_city_no_seq.nextval,'서울',1,1);
insert into city(city_no,city_name,latitude,longitude) values(city_city_no_seq.nextval,'경기',2,2);
insert into city(city_no,city_name,latitude,longitude) values(city_city_no_seq.nextval,'강원',3,3);
insert into city(city_no,city_name,latitude,longitude) values(city_city_no_seq.nextval,'부산',4,4);
insert into city(city_no,city_name,latitude,longitude) values(city_city_no_seq.nextval,'대전',5,5);

/*************** notice ***********************/
-- 공지사항 notice insert

insert into notice(n_no,n_title,n_content,n_date,n_readcount,n_img,user_id) values (notice_n_no_seq.nextval,'공지사항은1','공지사항내용1',sysdate,1,'img.png','user1'); 
insert into notice(n_no,n_title,n_content,n_date,n_readcount,n_img,user_id) values (notice_n_no_seq.nextval,'공지사항은2','공지사항내용2',sysdate,2,'img.png','user2'); 
insert into notice(n_no,n_title,n_content,n_date,n_readcount,n_img,user_id) values (notice_n_no_seq.nextval,'공지사항삼3','공지사항내용3',sysdate,3,'img.png','user3'); 
insert into notice(n_no,n_title,n_content,n_date,n_readcount,n_img,user_id) values (notice_n_no_seq.nextval,'공지사항이다4','공지사항내용4','2023/04/02',4,'img.png','user1'); 
insert into notice(n_no,n_title,n_content,n_date,n_readcount,n_img,user_id) values (notice_n_no_seq.nextval,'공지사항이야5','공지사항내용5','2023/04/03',8,'img.png','user2'); 
insert into notice(n_no,n_title,n_content,n_date,n_readcount,n_img,user_id) values (notice_n_no_seq.nextval,'공지사항안내6','공지사항내용6','2023/04/05',10,'img.png','user3'); 
insert into notice(n_no,n_title,n_content,n_date,n_readcount,n_img,user_id) values (notice_n_no_seq.nextval,'공지사항안내7','공지사항내용7','2023/05/02',15,'img.png','user1'); 
insert into notice(n_no,n_title,n_content,n_date,n_readcount,n_img,user_id) values (notice_n_no_seq.nextval,'공지사항결제8','공지사항내용8','2023/06/03',23,'img.png','user2'); 
insert into notice(n_no,n_title,n_content,n_date,n_readcount,n_img,user_id) values (notice_n_no_seq.nextval,'공지사항결론9','공지사항내용9','2023/07/05',2,'img.png','user3'); 
insert into notice(n_no,n_title,n_content,n_date,n_readcount,n_img,user_id) values (notice_n_no_seq.nextval,'공지사항이다10','공지사항내용4','2023/04/02',4,'img.png','user1'); 
insert into notice(n_no,n_title,n_content,n_date,n_readcount,n_img,user_id) values (notice_n_no_seq.nextval,'공지사항이야11','공지사항내용5','2023/04/03',8,'img.png','user2'); 
insert into notice(n_no,n_title,n_content,n_date,n_readcount,n_img,user_id) values (notice_n_no_seq.nextval,'공지사항안내12','공지사항내용6','2023/04/05',10,'img.png','user3'); 
insert into notice(n_no,n_title,n_content,n_date,n_readcount,n_img,user_id) values (notice_n_no_seq.nextval,'공지사항안내13','공지사항내용7','2023/05/02',15,'img.png','user1'); 
insert into notice(n_no,n_title,n_content,n_date,n_readcount,n_img,user_id) values (notice_n_no_seq.nextval,'공지사항결제14','공지사항내용8','2023/06/03',23,'img.png','user2'); 
insert into notice(n_no,n_title,n_content,n_date,n_readcount,n_img,user_id) values (notice_n_no_seq.nextval,'공지사항결론15','공지사항내용9','2023/07/05',2,'img.png','user3'); 
insert into notice(n_no,n_title,n_content,n_date,n_readcount,n_img,user_id) values (notice_n_no_seq.nextval,'공지사항이다16','공지사항내용4','2023/04/02',4,'img.png','user1'); 
insert into notice(n_no,n_title,n_content,n_date,n_readcount,n_img,user_id) values (notice_n_no_seq.nextval,'공지사항이야17','공지사항내용5','2023/04/03',8,'img.png','user2'); 
insert into notice(n_no,n_title,n_content,n_date,n_readcount,n_img,user_id) values (notice_n_no_seq.nextval,'공지사항안내18','공지사항내용6','2023/04/05',10,'img.png','user3'); 
insert into notice(n_no,n_title,n_content,n_date,n_readcount,n_img,user_id) values (notice_n_no_seq.nextval,'공지사항안내19','공지사항내용7','2023/05/02',15,'img.png','user1'); 
insert into notice(n_no,n_title,n_content,n_date,n_readcount,n_img,user_id) values (notice_n_no_seq.nextval,'공지사항결제20','공지사항내용8','2023/06/03',23,'img.png','user2'); 
insert into notice(n_no,n_title,n_content,n_date,n_readcount,n_img,user_id) values (notice_n_no_seq.nextval,'공지사항결론21','공지사항내용9','2023/07/05',2,'img.png','user3'); 


/*************** tour ***********************/
--insert tour
insert into tour(to_no,to_name,to_type,to_time,to_person,to_meet,to_price,to_info,to_notice,to_count,city_no)
    values(TOUR_TO_NO_SEQ.nextval,'레저여행',1,2,10,'잠실역',200000,'바다에서놀아요','준비물:여벌옷',0,3);
insert into tour(to_no,to_name,to_type,to_time,to_person,to_meet,to_price,to_info,to_notice,to_count,city_no)
    values(TOUR_TO_NO_SEQ.nextval,'별자리탐험',2,1,10,'강릉기차역',30000,'별보러가요','운동화',0,3);
insert into tour(to_no,to_name,to_type,to_time,to_person,to_meet,to_price,to_info,to_notice,to_count,city_no)
    values(TOUR_TO_NO_SEQ.nextval,'빵집투어',2,1,5,'대전역',40000,'성심당을시작으로','굶주린배',0,5);
insert into tour(to_no,to_name,to_type,to_time,to_person,to_meet,to_price,to_info,to_notice,to_count,city_no)
    values(TOUR_TO_NO_SEQ.nextval,'야경투어',2,1,10,'서울역',50000,'부산야경투어','사투리공부하기',0,4);
insert into tour(to_no,to_name,to_type,to_time,to_person,to_meet,to_price,to_info,to_notice,to_count,city_no)
    values(TOUR_TO_NO_SEQ.nextval,'호수탐험',1,2,10,'사당역',60000,'근교호수투어','인생사진찍어드려요',0,2);


--insert tourImg
insert into tour_img(to_img_no,to_img_url,to_no) values(TOUR_IMG_TO_IMG_NO_SEQ.nextval,'a',1);
insert into tour_img(to_img_no,to_img_url,to_no) values(TOUR_IMG_TO_IMG_NO_SEQ.nextval,'b',2);
insert into tour_img(to_img_no,to_img_url,to_no) values(TOUR_IMG_TO_IMG_NO_SEQ.nextval,'c',3);
insert into tour_img(to_img_no,to_img_url,to_no) values(TOUR_IMG_TO_IMG_NO_SEQ.nextval,'d',4);
insert into tour_img(to_img_no,to_img_url,to_no) values(TOUR_IMG_TO_IMG_NO_SEQ.nextval,'e',3);
--insert tourReserve
insert into tour_reserve(to_rs_no,to_rs_start_day,to_rs_person,to_rs_msg,to_no,user_id) values(TOUR_RESERVE_TO_RS_NO_SEQ.nextval,'2023-03-27',2,'테스트1',1,'admin');
insert into tour_reserve(to_rs_no,to_rs_start_day,to_rs_person,to_rs_msg,to_no,user_id) values(TOUR_RESERVE_TO_RS_NO_SEQ.nextval,'2023-02-27',2,'테스트2',2,'user2');
insert into tour_reserve(to_rs_no,to_rs_start_day,to_rs_person,to_rs_msg,to_no,user_id) values(TOUR_RESERVE_TO_RS_NO_SEQ.nextval,'2023-01-27',2,'테스트3',3,'admin');
--insert tourReview
insert into tour_review(to_review_no,to_review_date,to_review_title,to_review_content,to_review_img,to_review_star,to_no,user_id) values(TOUR_REVIEW_TO_REVIEW_NO_SEQ.nextval,sysdate,'리뷰1','테스트1',null,3,1,'admin');
insert into tour_review(to_review_no,to_review_date,to_review_title,to_review_content,to_review_img,to_review_star,to_no,user_id) values(TOUR_REVIEW_TO_REVIEW_NO_SEQ.nextval,sysdate,'리뷰2','테스트2',null,5,2,'user2');
insert into tour_review(to_review_no,to_review_date,to_review_title,to_review_content,to_review_img,to_review_star,to_no,user_id) values(TOUR_REVIEW_TO_REVIEW_NO_SEQ.nextval,sysdate,'리뷰3','테스트3',null,4,3,'admin');

/*************** chat ***********************/

-- chat_room
insert into chat_room(room_no,room_name,from_id,to_id) values (chat_room_room_no_seq.nextval,'채팅방1','user1','user2');
insert into chat_room(room_no,room_name,from_id,to_id) values (chat_room_room_no_seq.nextval,'채팅방2','user3','user2');
insert into chat_room(room_no,room_name,from_id,to_id) values (chat_room_room_no_seq.nextval,'채팅방3','user2','user3');

--chat_msg
insert into chat_msg(msg_no,msg_content,msg_send_time,msg_read,room_no,user_id) 
values(chat_msg_msg_no_seq.nextval,'안녕하세요1',sysdate,0,1,'user1');

insert into chat_msg(msg_no,msg_content,msg_send_time,msg_read,room_no,user_id) 
values(chat_msg_msg_no_seq.nextval,'혹시1',sysdate,0,1,'user1');

insert into chat_msg(msg_no,msg_content,msg_send_time,msg_read,room_no,user_id) 
values(chat_msg_msg_no_seq.nextval,'네 안녕하세요2',sysdate,0,1,'user2');

insert into chat_msg(msg_no,msg_content,msg_send_time,msg_read,room_no,user_id) 
values(chat_msg_msg_no_seq.nextval,'말씀하세요2',sysdate,0,1,'user2');

insert into chat_msg(msg_no,msg_content,msg_send_time,msg_read,room_no,user_id) 
values(chat_msg_msg_no_seq.nextval,'반갑습니다3',sysdate,0,2,'user3');

insert into chat_msg(msg_no,msg_content,msg_send_time,msg_read,room_no,user_id) 
values(chat_msg_msg_no_seq.nextval,'하이요2',sysdate,0,2,'user2');

insert into chat_msg(msg_no,msg_content,msg_send_time,msg_read,room_no,user_id) 
values(chat_msg_msg_no_seq.nextval,'저기요2',sysdate,0,3,'user2');

insert into chat_msg(msg_no,msg_content,msg_send_time,msg_read,room_no,user_id) 
values(chat_msg_msg_no_seq.nextval,'안녕하세요3',sysdate,0,3,'user3');

/*************** freeBoard ***********************/
-- freeboard
insert into free_board values (free_board_f_bo_no_seq.nextval,'서울 맛집 추천','추천받습니다',sysdate,0,1,'user1');
insert into free_board values (free_board_f_bo_no_seq.nextval,'경기 맛집 추천','추천받습니다',sysdate,0,2,'user2');
insert into free_board values (free_board_f_bo_no_seq.nextval,'강원 맛집 추천','추천받습니다',sysdate,0,3,'user3');

-- freeboard comment
insert into free_board_comment values (FREE_BOARD_COMMENT_F_CO_NO_SEQ.nextval,'명동교자 칼국수 맛있어요',sysdate,1,'user3');
insert into free_board_comment values (FREE_BOARD_COMMENT_F_CO_NO_SEQ.nextval,'카페는 어떠신가요.',sysdate,2,'user1');
insert into free_board_comment values (FREE_BOARD_COMMENT_F_CO_NO_SEQ.nextval,'강원 맛집 저도 궁금하군요.',sysdate,3,'user2');


/*************** ticket ***********************/
--TICKET 티켓 상품
INSERT INTO TICKET (TI_NO, TI_TITLE,TI_DATE,TI_PRICE,TI_INFO,TI_NOTICE,TI_COUNT,CITY_NO)
VALUES (TICKET_TI_NO_SEQ.NEXTVAL,'서울로 가보 자고', SYSDATE, 10000, '이 티켓은 서울로 가는 티켓', '눈 뜨고 코 베이지 않게 주의 하세요.',default,1);
INSERT INTO TICKET (TI_NO, TI_TITLE,TI_DATE,TI_PRICE,TI_INFO,TI_NOTICE,TI_COUNT,CITY_NO)
VALUES (TICKET_TI_NO_SEQ.NEXTVAL,'부산으로 가보 자고', SYSDATE, 20000, '이 티켓은 부산으로 가는 티켓', '갈매기를 주의 하세요.',default,2);
INSERT INTO TICKET (TI_NO, TI_TITLE,TI_DATE,TI_PRICE,TI_INFO,TI_NOTICE,TI_COUNT,CITY_NO)
VALUES (TICKET_TI_NO_SEQ.NEXTVAL,'제주도로 가보 자고', SYSDATE, 40000, '이 티켓은 제주도로 가는 티켓 ', '돌아 오기 싫을 수 있으니 주의 하세요.',default,3);
INSERT INTO TICKET (TI_NO, TI_TITLE,TI_DATE,TI_PRICE,TI_INFO,TI_NOTICE,TI_COUNT,CITY_NO)
VALUES (TICKET_TI_NO_SEQ.NEXTVAL,'어디 든지 가보 자고', SYSDATE, 99999, '이 티켓은 어디든 가는 티켓', '어디로 갈지 모르니 주의 하세요.',default,4);
--TICKET_RESERVE 티켓 예약
INSERT INTO TICKET_RESERVE (TI_RS_NO, TI_RS_DATE, TI_RS_QTY, TI_RS_MSG, TI_NO, USER_ID) VALUES (TICKET_RESERVE_TI_RS_NO_SEQ.NEXTVAL,'2023-03-26', 1,'요청사항입니다....',1,'user1');
INSERT INTO TICKET_RESERVE (TI_RS_NO, TI_RS_DATE, TI_RS_QTY, TI_RS_MSG, TI_NO, USER_ID) VALUES (TICKET_RESERVE_TI_RS_NO_SEQ.NEXTVAL,'2023-04-26', 3,'요청사항입니다....2',2,'user2');
INSERT INTO TICKET_RESERVE (TI_RS_NO, TI_RS_DATE, TI_RS_QTY, TI_RS_MSG, TI_NO, USER_ID) VALUES (TICKET_RESERVE_TI_RS_NO_SEQ.NEXTVAL,'2023-03-31', 4,'요청사항입니다....3',3,'user3');
--TICKET_REVIEW 티켓 리뷰
INSERT INTO TICKET_REVIEW (TI_REVIEW_NO, TI_REVIEW_DATE, TI_REVIEW_TITLE, TI_REVIEW_CONTENT, TI_NO, USER_ID) VALUES (TICKET_REVIEW_TI_REVIEW_NO_SEQ.NEXTVAL,'2023-03-27','티켓예약1번후기작성', '서울로 가보자고는 짱이다.',1,'user1');
INSERT INTO TICKET_REVIEW (TI_REVIEW_NO, TI_REVIEW_DATE, TI_REVIEW_TITLE, TI_REVIEW_CONTENT, TI_NO, USER_ID) VALUES (TICKET_REVIEW_TI_REVIEW_NO_SEQ.NEXTVAL, '2023-04-27','티켓2번후기작성','부산으로 가보자고 후기입니다.',2,'user2');
--TICKET_IMG 티켓 사진
INSERT INTO TICKET_IMG (TI_IMG_NO, TI_IMG_URL,TI_NO) VALUES(TICKET_IMG_TI_IMG_NO_SEQ.NEXTVAL,'DEFAULT.JPG',1);
INSERT INTO TICKET_IMG (TI_IMG_NO, TI_IMG_URL,TI_NO) VALUES(TICKET_IMG_TI_IMG_NO_SEQ.NEXTVAL,'DEFAULT.JPG',2);

/*************** tripBoard ***********************/
-- 동행게시판 trip_board insert
insert into trip_board(t_bo_no,t_bo_title,t_bo_content,t_bo_date,t_bo_readcount,t_bo_status,t_bo_person,
                    t_bo_img,t_bo_start_date,t_bo_end_date,t_bo_style,hashtag,city_no,user_id) 
            values (trip_board_t_bo_no_seq.nextval,'동행게시판제목1','동행게시판내용1',sysdate,0,0,1,
                    'img1.png','2023-05-01','2023-05-10','무계획','아무나다좋아',1,'user1'); 
                    
insert into trip_board(t_bo_no,t_bo_title,t_bo_content,t_bo_date,t_bo_readcount,t_bo_status,t_bo_person,
                    t_bo_img,t_bo_start_date,t_bo_end_date,t_bo_style,hashtag,city_no,user_id) 
            values (trip_board_t_bo_no_seq.nextval,'동행게시판제목2','동행게시판내용2',sysdate,0,0,2,
                    'img2.png','2023-06-01','2023-06-10','계획형','인싸만',2,'user2');
                    
insert into trip_board(t_bo_no,t_bo_title,t_bo_content,t_bo_date,t_bo_readcount,t_bo_status,t_bo_person,
                    t_bo_img,t_bo_start_date,t_bo_end_date,t_bo_style,hashtag,city_no,user_id) 
            values (trip_board_t_bo_no_seq.nextval,'동행게시판제목3','동행게시판내용3',sysdate,0,0,1,
                    'img3.png','2023-07-01','2023-07-10','맛집투어','맛있는거좋아하는사람',3,'user3'); 

-- 동행게시판 댓글 insert
insert into trip_board_comment(t_co_no, t_comment_content, t_comment_date, t_bo_no, user_id) 
                        values(TRIP_BOARD_COMMENT_T_CO_NO_SEQ.nextval, '댓글1', sysdate, 1, 'user2');
insert into trip_board_comment(t_co_no, t_comment_content, t_comment_date, t_bo_no, user_id) 
                        values(TRIP_BOARD_COMMENT_T_CO_NO_SEQ.nextval, '댓글2', sysdate, 2, 'user3');
insert into trip_board_comment(t_co_no, t_comment_content, t_comment_date, t_bo_no, user_id) 
                        values(TRIP_BOARD_COMMENT_T_CO_NO_SEQ.nextval, '댓글3', sysdate, 3, 'user1');                   

/*************** wishlist ***********************/
-- 티켓 상품 위시리스트에 추가
insert into wishlist(wish_no,user_id,ti_no,to_no) values(WISHLIST_WISH_NO_SEQ.nextval,'user1',1,null);
insert into wishlist(wish_no,user_id,ti_no,to_no) values(WISHLIST_WISH_NO_SEQ.nextval,'user1',2,null);
insert into wishlist(wish_no,user_id,ti_no,to_no) values(WISHLIST_WISH_NO_SEQ.nextval,'user2',3,null);
insert into wishlist(wish_no,user_id,ti_no,to_no) values(WISHLIST_WISH_NO_SEQ.nextval,'user2',4,null);
insert into wishlist(wish_no,user_id,ti_no,to_no) values(WISHLIST_WISH_NO_SEQ.nextval,'user3',1,null);
insert into wishlist(wish_no,user_id,ti_no,to_no) values(WISHLIST_WISH_NO_SEQ.nextval,'user3',2,null);

-- 투어 상품 위시리스트에 추가
insert into wishlist(wish_no,user_id,ti_no,to_no) values(WISHLIST_WISH_NO_SEQ.nextval,'user1',null,2);
insert into wishlist(wish_no,user_id,ti_no,to_no) values(WISHLIST_WISH_NO_SEQ.nextval,'user1',null,3);
insert into wishlist(wish_no,user_id,ti_no,to_no) values(WISHLIST_WISH_NO_SEQ.nextval,'user2',null,1);
insert into wishlist(wish_no,user_id,ti_no,to_no) values(WISHLIST_WISH_NO_SEQ.nextval,'user2',null,2);
insert into wishlist(wish_no,user_id,ti_no,to_no) values(WISHLIST_WISH_NO_SEQ.nextval,'user3',null,3);
insert into wishlist(wish_no,user_id,ti_no,to_no) values(WISHLIST_WISH_NO_SEQ.nextval,'user3',null,4);


commit;