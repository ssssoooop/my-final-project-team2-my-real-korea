DROP TABLE kakao_info CASCADE CONSTRAINTS;
DROP TABLE ticket_img CASCADE CONSTRAINTS;
DROP TABLE ticket_review CASCADE CONSTRAINTS;
DROP TABLE payment CASCADE CONSTRAINTS;
DROP TABLE ticket_reserve CASCADE CONSTRAINTS;
DROP TABLE notice CASCADE CONSTRAINTS;
DROP TABLE chat_msg CASCADE CONSTRAINTS;
DROP TABLE chat_room CASCADE CONSTRAINTS;
DROP TABLE wishlist CASCADE CONSTRAINTS;
DROP TABLE ticket CASCADE CONSTRAINTS;
DROP TABLE user_img CASCADE CONSTRAINTS;
DROP TABLE user_add_info CASCADE CONSTRAINTS;
DROP TABLE tour_review CASCADE CONSTRAINTS;
DROP TABLE tour_reserve CASCADE CONSTRAINTS;
DROP TABLE tour_img CASCADE CONSTRAINTS;
DROP TABLE tour CASCADE CONSTRAINTS;
DROP TABLE free_board_comment CASCADE CONSTRAINTS;
DROP TABLE free_board CASCADE CONSTRAINTS;
DROP TABLE trip_board_comment CASCADE CONSTRAINTS;
DROP TABLE trip_board CASCADE CONSTRAINTS;
DROP TABLE user_info CASCADE CONSTRAINTS;
DROP TABLE city CASCADE CONSTRAINTS;

CREATE TABLE city(
		city_no                       		NUMBER		 NULL ,
		city_name                     		VARCHAR2(50)		 NOT NULL,
		latitude                      		NUMBER		 NOT NULL,
		longitude                     		NUMBER		 NOT NULL
);

DROP SEQUENCE city_city_no_SEQ;

CREATE SEQUENCE city_city_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;


CREATE TABLE user_info(
		user_id                       		VARCHAR2(50)		 NOT NULL,
		password                      		VARCHAR2(100)		 NOT NULL,
		name                          		VARCHAR2(50)		 NOT NULL,
		nickname                      		VARCHAR2(50)		 NOT NULL,
		phone                         		VARCHAR2(100)		 NOT NULL,
		email                         		VARCHAR2(100)		 NOT NULL,
		birth                         		DATE		 NOT NULL,
		address                       		VARCHAR2(500)		 NOT NULL,
		gender                        		NUMBER		 NOT NULL,
		point                         		NUMBER		 DEFAULT 0		 NULL ,
		is_admin                      		NUMBER		 DEFAULT 1		 NULL ,
		mail_auth                     		NUMBER(10)		 DEFAULT 0		 NULL ,
		mail_key                      		NUMBER(10)		 DEFAULT 0		 NULL 
);


CREATE TABLE trip_board(
		t_bo_no                       		NUMBER		 NULL ,
		t_bo_title                    		VARCHAR2(100)		 NOT NULL,
		t_bo_content                  		VARCHAR2(2000)		 NOT NULL,
		t_bo_date                     		DATE		 DEFAULT sysdate		 NULL ,
		t_bo_readcount                		NUMBER		 DEFAULT 0		 NULL ,
		t_bo_status                   		NUMBER		 DEFAULT 0		 NULL ,
		t_bo_person                   		NUMBER		 NOT NULL,
		t_bo_img                      		VARCHAR2(500)		 NULL ,
		t_bo_start_date               		DATE		 NOT NULL,
		t_bo_end_date                 		DATE		 NOT NULL,
		t_bo_style                    		VARCHAR2(1000)		 NOT NULL,
		hashtag                       		VARCHAR2(100)		 NULL ,
		city_no                       		NUMBER		 NULL ,
		user_id                       		VARCHAR2(50)		 NULL 
);

DROP SEQUENCE trip_board_t_bo_no_SEQ;

CREATE SEQUENCE trip_board_t_bo_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;



CREATE TABLE trip_board_comment(
		t_co_no                       		NUMBER		 NULL ,
		t_comment_content             		VARCHAR2(1000)		 NOT NULL,
		t_comment_date                		DATE		 DEFAULT sysdate		 NULL ,
		t_bo_no                       		NUMBER		 NULL ,
		user_id                       		VARCHAR2(50)		 NULL 
);

DROP SEQUENCE trip_board_comment_t_co_no_SEQ;

CREATE SEQUENCE trip_board_comment_t_co_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;



CREATE TABLE free_board(
		f_bo_no                       		NUMBER		 NULL ,
		f_bo_title                    		VARCHAR2(500)		 NOT NULL,
		f_bo_content                  		VARCHAR2(1000)		 NOT NULL,
		f_bo_date                     		DATE		 DEFAULT sysdate		 NULL ,
		f_bo_readcount                		NUMBER		 DEFAULT 0		 NULL ,
		city_no                       		NUMBER		 NULL ,
		user_id                       		VARCHAR2(50)		 NULL 
);

DROP SEQUENCE free_board_f_bo_no_SEQ;

CREATE SEQUENCE free_board_f_bo_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;



CREATE TABLE free_board_comment(
		f_co_no                       		NUMBER		 NULL ,
		f_comment_content             		VARCHAR2(1000)		 NOT NULL,
		f_comment_date                		DATE		 DEFAULT sysdate		 NULL ,
		f_bo_no                       		NUMBER		 NULL ,
		user_id                       		VARCHAR2(50)		 NULL 
);

DROP SEQUENCE free_board_comment_f_co_no_SEQ;

CREATE SEQUENCE free_board_comment_f_co_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;



CREATE TABLE tour(
		to_no                         		NUMBER		 NULL ,
		to_name                       		VARCHAR2(1000)		 NOT NULL,
		to_type                       		NUMBER		 NOT NULL,
		to_time                       		NUMBER		 NOT NULL,
		to_person                     		NUMBER		 NOT NULL,
		to_meet                       		VARCHAR2(100)		 NOT NULL,
		to_price                      		NUMBER		 NOT NULL,
		to_info                       		VARCHAR2(4000)		 NOT NULL,
		to_notice                     		VARCHAR2(1000)		 NOT NULL,
		to_count                      		NUMBER		 DEFAULT 0		 NULL ,
		city_no                       		NUMBER		 NULL 
);

DROP SEQUENCE tour_to_no_SEQ;

CREATE SEQUENCE tour_to_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;



CREATE TABLE tour_img(
		to_img_no                     		NUMBER		 NULL ,
		to_img_url                    		VARCHAR2(500)		 NOT NULL,
		to_no                         		NUMBER		 NULL 
);

DROP SEQUENCE tour_img_to_img_no_SEQ;

CREATE SEQUENCE tour_img_to_img_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;



CREATE TABLE tour_reserve(
		to_rs_no                      		NUMBER		 NULL ,
		to_rs_start_day               		DATE		 NOT NULL,
		to_rs_person                  		NUMBER		 NOT NULL,
		to_rs_msg                     		VARCHAR2(500)		 NULL ,
		to_no                         		NUMBER		 NULL ,
		user_id                       		VARCHAR2(50)		 NULL 
);

DROP SEQUENCE tour_reserve_to_rs_no_SEQ;

CREATE SEQUENCE tour_reserve_to_rs_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;



CREATE TABLE tour_review(
		to_review_no                  		NUMBER		 NULL ,
		to_review_date                		DATE		 DEFAULT sysdate		 NULL ,
		to_review_title               		VARCHAR2(1000)		 NOT NULL,
		to_review_content             		VARCHAR2(2000)		 NOT NULL,
		to_review_img                 		VARCHAR2(500)		 NULL ,
		to_review_star                		NUMBER		 NOT NULL,
		to_no                         		NUMBER		 NULL ,
		user_id                       		VARCHAR2(50)		 NULL 
);

DROP SEQUENCE tour_review_to_review_no_SEQ;

CREATE SEQUENCE tour_review_to_review_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;



CREATE TABLE user_add_info(
		introduce                     		VARCHAR2(1000)		 NULL ,
		alcohol                       		NUMBER		 NULL ,
		smoking                       		NUMBER		 NULL ,
		user_id                       		VARCHAR2(50)		 NULL 
);


CREATE TABLE user_img(
		user_img_no                   		NUMBER		 NULL ,
		user_img_url                  		VARCHAR2(500)		 NOT NULL,
		user_id                       		VARCHAR2(50)		 NULL 
);

DROP SEQUENCE user_img_user_img_no_SEQ;

CREATE SEQUENCE user_img_user_img_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;



CREATE TABLE ticket(
		ti_no                         		NUMBER		 NULL ,
		ti_title                      		VARCHAR2(1000)		 NOT NULL,
		ti_date                       		DATE		 DEFAULT sysdate		 NULL ,
		ti_price                      		NUMBER		 NOT NULL,
		ti_info                       		VARCHAR2(4000)		 NOT NULL,
		ti_notice                     		VARCHAR2(1000)		 NOT NULL,
		ti_count                      		NUMBER		 DEFAULT 0		 NULL ,
		city_no                       		NUMBER		 NULL 
);

DROP SEQUENCE ticket_ti_no_SEQ;

CREATE SEQUENCE ticket_ti_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;



CREATE TABLE wishlist(
		wish_no                       		NUMBER		 NULL ,
		user_id                       		VARCHAR2(50)		 NULL ,
		ti_no                         		NUMBER		 NULL ,
		to_no                         		NUMBER		 NULL 
);

DROP SEQUENCE wishlist_wish_no_SEQ;

CREATE SEQUENCE wishlist_wish_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;



CREATE TABLE chat_room(
		room_no                       		NUMBER		 NULL ,
		room_name                     		VARCHAR2(100)		 NOT NULL,
		from_id                       		VARCHAR2(50)		 NULL ,
		to_id                         		VARCHAR2(50)		 NULL 
);

DROP SEQUENCE chat_room_room_no_SEQ;

CREATE SEQUENCE chat_room_room_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;



CREATE TABLE chat_msg(
		msg_no                        		NUMBER		 NULL ,
		msg_content                   		VARCHAR2(500)		 NOT NULL,
		msg_send_time                 		DATE		 DEFAULT sysdate		 NULL ,
		msg_read                      		NUMBER		 NULL ,
		room_no                       		NUMBER		 NULL ,
		user_id                       		VARCHAR2(50)		 NULL 
);

DROP SEQUENCE chat_msg_msg_no_SEQ;

CREATE SEQUENCE chat_msg_msg_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;



CREATE TABLE notice(
		n_no                          		NUMBER		 NULL ,
		n_title                       		VARCHAR2(1000)		 NOT NULL,
		n_content                     		VARCHAR2(2000)		 NOT NULL,
		n_date                        		DATE		 DEFAULT sysdate		 NULL ,
		n_readcount                   		NUMBER		 DEFAULT 0		 NULL ,
		n_img                         		VARCHAR2(500)		 NULL ,
		user_id                       		VARCHAR2(50)		 NULL 
);

DROP SEQUENCE notice_n_no_SEQ;

CREATE SEQUENCE notice_n_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;



CREATE TABLE ticket_reserve(
		ti_rs_no                      		NUMBER		 NULL ,
		ti_rs_date                    		DATE		 NOT NULL,
		ti_rs_qty                     		NUMBER		 NOT NULL,
		ti_rs_msg                     		VARCHAR2(500)		 NULL ,
		ti_no                         		NUMBER		 NULL ,
		user_id                       		VARCHAR2(50)		 NULL 
);

DROP SEQUENCE ticket_reserve_ti_rs_no_SEQ;

CREATE SEQUENCE ticket_reserve_ti_rs_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;



CREATE TABLE payment(
		p_no                          		NUMBER		 NULL ,
		p_price                       		NUMBER		 NOT NULL,
		p_qty                         		NUMBER		 NOT NULL,
		p_date                        		DATE		 DEFAULT sysdate		 NULL ,
		p_point                       		NUMBER		 DEFAULT 0		 NULL ,
		p_method                      		NUMBER		 NOT NULL,
		ti_rs_no                      		NUMBER		 NULL ,
		to_rs_no                      		NUMBER		 NULL ,
		user_id                       		VARCHAR2(50)		 NULL 
);

DROP SEQUENCE payment_p_no_SEQ;

CREATE SEQUENCE payment_p_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;



CREATE TABLE ticket_review(
		ti_review_no                  		NUMBER		 NULL ,
		ti_review_date                		DATE		 DEFAULT sysdate		 NULL ,
		ti_review_title               		VARCHAR2(1000)		 NOT NULL,
		ti_review_content             		VARCHAR2(2000)		 NOT NULL,
		ti_review_img                 		VARCHAR2(500)		 NULL ,
		ti_no                         		NUMBER		 NULL ,
		user_id                       		VARCHAR2(50)		 NULL 
);

DROP SEQUENCE ticket_review_ti_review_no_SEQ;

CREATE SEQUENCE ticket_review_ti_review_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;



CREATE TABLE ticket_img(
		ti_img_no                     		NUMBER		 NULL ,
		ti_img_url                    		VARCHAR2(500)		 NOT NULL,
		ti_no                         		NUMBER		 NULL 
);

DROP SEQUENCE ticket_img_ti_img_no_SEQ;

CREATE SEQUENCE ticket_img_ti_img_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;




CREATE TABLE kakao_info(
		kakao_no                      		NUMBER		 NULL ,
		kakao_email                   		VARCHAR2(100)		 NULL ,
		kakao_nickname                		VARCHAR2(100)		 NULL ,
		user_id                       		VARCHAR2(50)		 NULL 
);

DROP SEQUENCE kakao_info_kakao_no_SEQ;

CREATE SEQUENCE kakao_info_kakao_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;




ALTER TABLE city ADD CONSTRAINT IDX_city_PK PRIMARY KEY (city_no);

ALTER TABLE user_info ADD CONSTRAINT IDX_user_info_PK PRIMARY KEY (user_id);

ALTER TABLE trip_board ADD CONSTRAINT IDX_trip_board_PK PRIMARY KEY (t_bo_no);
ALTER TABLE trip_board ADD CONSTRAINT IDX_trip_board_FK0 FOREIGN KEY (city_no) REFERENCES city (city_no) on delete cascade;
ALTER TABLE trip_board ADD CONSTRAINT IDX_trip_board_FK1 FOREIGN KEY (user_id) REFERENCES user_info (user_id) on delete cascade;

ALTER TABLE trip_board_comment ADD CONSTRAINT IDX_trip_board_comment_PK PRIMARY KEY (t_co_no);
ALTER TABLE trip_board_comment ADD CONSTRAINT IDX_trip_board_comment_FK0 FOREIGN KEY (t_bo_no) REFERENCES trip_board (t_bo_no) on delete cascade;
ALTER TABLE trip_board_comment ADD CONSTRAINT IDX_trip_board_comment_FK1 FOREIGN KEY (user_id) REFERENCES user_info (user_id) on delete cascade;

ALTER TABLE free_board ADD CONSTRAINT IDX_free_board_PK PRIMARY KEY (f_bo_no);
ALTER TABLE free_board ADD CONSTRAINT IDX_free_board_FK0 FOREIGN KEY (city_no) REFERENCES city (city_no) on delete cascade;
ALTER TABLE free_board ADD CONSTRAINT IDX_free_board_FK1 FOREIGN KEY (user_id) REFERENCES user_info (user_id) on delete cascade;

ALTER TABLE free_board_comment ADD CONSTRAINT IDX_free_board_comment_PK PRIMARY KEY (f_co_no);
ALTER TABLE free_board_comment ADD CONSTRAINT IDX_free_board_comment_FK0 FOREIGN KEY (f_bo_no) REFERENCES free_board (f_bo_no) on delete cascade;
ALTER TABLE free_board_comment ADD CONSTRAINT IDX_free_board_comment_FK1 FOREIGN KEY (user_id) REFERENCES user_info (user_id) on delete cascade;

ALTER TABLE tour ADD CONSTRAINT IDX_tour_PK PRIMARY KEY (to_no);
ALTER TABLE tour ADD CONSTRAINT IDX_tour_FK0 FOREIGN KEY (city_no) REFERENCES city (city_no) on delete cascade;

ALTER TABLE tour_img ADD CONSTRAINT IDX_tour_img_PK PRIMARY KEY (to_img_no);
ALTER TABLE tour_img ADD CONSTRAINT IDX_tour_img_FK0 FOREIGN KEY (to_no) REFERENCES tour (to_no) on delete cascade;

ALTER TABLE tour_reserve ADD CONSTRAINT IDX_tour_reserve_PK PRIMARY KEY (to_rs_no);
ALTER TABLE tour_reserve ADD CONSTRAINT IDX_tour_reserve_FK0 FOREIGN KEY (to_no) REFERENCES tour (to_no) on delete cascade;
ALTER TABLE tour_reserve ADD CONSTRAINT IDX_tour_reserve_FK1 FOREIGN KEY (user_id) REFERENCES user_info (user_id) on delete cascade;

ALTER TABLE tour_review ADD CONSTRAINT IDX_tour_review_PK PRIMARY KEY (to_review_no);
ALTER TABLE tour_review ADD CONSTRAINT IDX_tour_review_FK0 FOREIGN KEY (to_no) REFERENCES tour (to_no) on delete cascade;
ALTER TABLE tour_review ADD CONSTRAINT IDX_tour_review_FK1 FOREIGN KEY (user_id) REFERENCES user_info (user_id) on delete cascade;

ALTER TABLE user_add_info ADD CONSTRAINT IDX_user_add_info_FK0 FOREIGN KEY (user_id) REFERENCES user_info (user_id) on delete cascade;

ALTER TABLE user_img ADD CONSTRAINT IDX_user_img_PK PRIMARY KEY (user_img_no);
ALTER TABLE user_img ADD CONSTRAINT IDX_user_img_FK0 FOREIGN KEY (user_id) REFERENCES user_info (user_id) on delete cascade;

ALTER TABLE ticket ADD CONSTRAINT IDX_ticket_PK PRIMARY KEY (ti_no);
ALTER TABLE ticket ADD CONSTRAINT IDX_ticket_FK0 FOREIGN KEY (city_no) REFERENCES city (city_no) on delete cascade;

ALTER TABLE wishlist ADD CONSTRAINT IDX_wishlist_PK PRIMARY KEY (wish_no);
ALTER TABLE wishlist ADD CONSTRAINT IDX_wishlist_FK0 FOREIGN KEY (user_id) REFERENCES user_info (user_id) on delete cascade;
ALTER TABLE wishlist ADD CONSTRAINT IDX_wishlist_FK1 FOREIGN KEY (ti_no) REFERENCES ticket (ti_no) on delete cascade;
ALTER TABLE wishlist ADD CONSTRAINT IDX_wishlist_FK2 FOREIGN KEY (to_no) REFERENCES tour (to_no) on delete cascade;

ALTER TABLE chat_room ADD CONSTRAINT IDX_chat_room_PK PRIMARY KEY (room_no);
ALTER TABLE chat_room ADD CONSTRAINT IDX_chat_room_FK0 FOREIGN KEY (from_id) REFERENCES user_info (user_id) on delete cascade;
ALTER TABLE chat_room ADD CONSTRAINT IDX_chat_room_FK1 FOREIGN KEY (to_id) REFERENCES user_info (user_id) on delete cascade;

ALTER TABLE chat_msg ADD CONSTRAINT IDX_chat_msg_PK PRIMARY KEY (msg_no);
ALTER TABLE chat_msg ADD CONSTRAINT IDX_chat_msg_FK0 FOREIGN KEY (room_no) REFERENCES chat_room (room_no) on delete cascade;
ALTER TABLE chat_msg ADD CONSTRAINT IDX_chat_msg_FK1 FOREIGN KEY (user_id) REFERENCES user_info (user_id) on delete cascade;

ALTER TABLE notice ADD CONSTRAINT IDX_notice_PK PRIMARY KEY (n_no);
ALTER TABLE notice ADD CONSTRAINT IDX_notice_FK0 FOREIGN KEY (user_id) REFERENCES user_info (user_id) on delete cascade;

ALTER TABLE ticket_reserve ADD CONSTRAINT IDX_ticket_reserve_PK PRIMARY KEY (ti_rs_no);
ALTER TABLE ticket_reserve ADD CONSTRAINT IDX_ticket_reserve_FK0 FOREIGN KEY (ti_no) REFERENCES ticket (ti_no) on delete cascade;
ALTER TABLE ticket_reserve ADD CONSTRAINT IDX_ticket_reserve_FK1 FOREIGN KEY (user_id) REFERENCES user_info (user_id) on delete cascade;

ALTER TABLE payment ADD CONSTRAINT IDX_payment_PK PRIMARY KEY (p_no);
ALTER TABLE payment ADD CONSTRAINT IDX_payment_FK0 FOREIGN KEY (ti_rs_no) REFERENCES ticket_reserve (ti_rs_no) on delete cascade;
ALTER TABLE payment ADD CONSTRAINT IDX_payment_FK1 FOREIGN KEY (to_rs_no) REFERENCES tour_reserve (to_rs_no) on delete cascade;
ALTER TABLE payment ADD CONSTRAINT IDX_payment_FK2 FOREIGN KEY (user_id) REFERENCES user_info (user_id) on delete cascade;

ALTER TABLE ticket_review ADD CONSTRAINT IDX_ticket_review_PK PRIMARY KEY (ti_review_no);
ALTER TABLE ticket_review ADD CONSTRAINT IDX_ticket_review_FK0 FOREIGN KEY (ti_no) REFERENCES ticket (ti_no) on delete cascade;
ALTER TABLE ticket_review ADD CONSTRAINT IDX_ticket_review_FK1 FOREIGN KEY (user_id) REFERENCES user_info (user_id) on delete cascade;

ALTER TABLE ticket_img ADD CONSTRAINT IDX_ticket_img_PK PRIMARY KEY (ti_img_no);
ALTER TABLE ticket_img ADD CONSTRAINT IDX_ticket_img_FK0 FOREIGN KEY (ti_no) REFERENCES ticket (ti_no) on delete cascade;

ALTER TABLE kakao_info ADD CONSTRAINT IDX_kakao_info_PK PRIMARY KEY (kakao_no);
ALTER TABLE kakao_info ADD CONSTRAINT IDX_kakao_info_FK0 FOREIGN KEY (user_id) REFERENCES user_info (user_id) on delete cascade;

