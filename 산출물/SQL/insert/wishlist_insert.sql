desc wishlist;

/*****user info*******/
insert into user_info(user_id,password,name,nickname,phone,email,birth,address,gender,point,is_admin) 
	values('admin','admin0000','관리자','관리자','010-0000-0000','admin0@gmail.com','2000-01-01','테헤란로0',0,0,0); 

insert into user_info(user_id,password,name,nickname,phone,email,birth,address,gender,point,is_admin) 
	values('user1','user1111','회원1','마리코1','010-1111-1111','user1@gmail.com','2001-01-01','테헤란로1',0,0,1); 

insert into user_info(user_id,password,name,nickname,phone,email,birth,address,gender,point,is_admin) 
	values('user2','user2222','회원2','마리코2','010-2222-2222','user2@gmail.com','2002-02-02','테헤란로2',1,0,1); 

insert into user_info(user_id,password,name,nickname,phone,email,birth,address,gender,point,is_admin) 
	values('user3','user3333','회원3','마리코3','010-3333-3333','user3@gmail.com','2003-03-03','테헤란로3',1,0,1); 

/*****city*******/
insert into city(city_no,city_name,latitude,longitude) values(city_city_no_seq.nextval,'서울',1,1);
insert into city(city_no,city_name,latitude,longitude) values(city_city_no_seq.nextval,'경기',2,2);
insert into city(city_no,city_name,latitude,longitude) values(city_city_no_seq.nextval,'강원',3,3);
insert into city(city_no,city_name,latitude,longitude) values(city_city_no_seq.nextval,'부산',4,4);
insert into city(city_no,city_name,latitude,longitude) values(city_city_no_seq.nextval,'대전',5,5);

/*****ticket*******/
INSERT INTO TICKET (TI_NO, TI_TITLE,TI_DATE,TI_PRICE,TI_INFO,TI_NOTICE,TI_COUNT,CITY_NO)
VALUES (TICKET_TI_NO_SEQ.NEXTVAL,'서울로 가보 자고', SYSDATE, 10000, '이 티켓은 서울로 가는 티켓', '눈 뜨고 코 베이지 않게 주의 하세요.',default,1);
INSERT INTO TICKET (TI_NO, TI_TITLE,TI_DATE,TI_PRICE,TI_INFO,TI_NOTICE,TI_COUNT,CITY_NO)
VALUES (TICKET_TI_NO_SEQ.NEXTVAL,'부산으로 가보 자고', SYSDATE, 20000, '이 티켓은 부산으로 가는 티켓', '갈매기를 주의 하세요.',default,2);
INSERT INTO TICKET (TI_NO, TI_TITLE,TI_DATE,TI_PRICE,TI_INFO,TI_NOTICE,TI_COUNT,CITY_NO)
VALUES (TICKET_TI_NO_SEQ.NEXTVAL,'제주도로 가보 자고', SYSDATE, 40000, '이 티켓은 제주도로 가는 티켓 ', '돌아 오기 싫을 수 있으니 주의 하세요.',default,3);
INSERT INTO TICKET (TI_NO, TI_TITLE,TI_DATE,TI_PRICE,TI_INFO,TI_NOTICE,TI_COUNT,CITY_NO)
VALUES (TICKET_TI_NO_SEQ.NEXTVAL,'어디 든지 가보 자고', SYSDATE, 99999, '이 티켓은 어디든 가는 티켓', '어디로 갈지 모르니 주의 하세요.',default,4);

/*****tour*******/
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


/*****wishlist*******/

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




