
-- 회원 user_info insert
insert into user_info(user_id,password,name,nickname,phone,email,birth,address,gender,point,is_admin) 
	values('admin','admin0000','관리자','관리자','010-0000-0000','admin0@gmail.com','2000-01-01','테헤란로0',0,0,0); 

insert into user_info(user_id,password,name,nickname,phone,email,birth,address,gender,point,is_admin) 
	values('user1','user1111','회원1','마리코1','010-1111-1111','user1@gmail.com','2001-01-01','테헤란로1',0,0,1); 

insert into user_info(user_id,password,name,nickname,phone,email,birth,address,gender,point,is_admin) 
	values('user2','user2222','회원2','마리코2','010-2222-2222','user2@gmail.com','2002-02-02','테헤란로2',1,0,1); 

insert into user_info(user_id,password,name,nickname,phone,email,birth,address,gender,point,is_admin) 
	values('user3','user3333','회원3','마리코3','010-3333-3333','user3@gmail.com','2003-03-03','테헤란로3',1,0,1); 

-- 지역 city insert
insert into city(city_no,city_name,latitude,longitude) values(city_city_no_seq.nextval,'서울',1,1);
insert into city(city_no,city_name,latitude,longitude) values(city_city_no_seq.nextval,'경기',2,2);
insert into city(city_no,city_name,latitude,longitude) values(city_city_no_seq.nextval,'강원',3,3);
insert into city(city_no,city_name,latitude,longitude) values(city_city_no_seq.nextval,'부산',4,4);
insert into city(city_no,city_name,latitude,longitude) values(city_city_no_seq.nextval,'대전',5,5);

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

