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
insert into tour_reserve(to_rs_no,to_rs_desc,to_rs_start_day,to_rs_person,to_rs_msg,to_no,user_id) values(TOUR_RESERVE_TO_RS_NO_SEQ.nextval,'예약설명','2023-03-27',2,'테스트1',1,'admin');
insert into tour_reserve(to_rs_no,to_rs_desc,to_rs_start_day,to_rs_person,to_rs_msg,to_no,user_id) values(TOUR_RESERVE_TO_RS_NO_SEQ.nextval,'예약설명','2023-02-27',2,'테스트2',2,'user2');
insert into tour_reserve(to_rs_no,to_rs_desc,to_rs_start_day,to_rs_person,to_rs_msg,to_no,user_id) values(TOUR_RESERVE_TO_RS_NO_SEQ.nextval,'예약설명','2023-01-27',2,'테스트3',3,'admin');


--insert tourReview
insert into tour_review(to_review_no,to_review_date,to_review_title,to_review_content,to_review_img,to_review_star,to_no,user_id) values(TOUR_REVIEW_TO_REVIEW_NO_SEQ.nextval,sysdate,'리뷰1','테스트1',null,3,1,'admin');
insert into tour_review(to_review_no,to_review_date,to_review_title,to_review_content,to_review_img,to_review_star,to_no,user_id) values(TOUR_REVIEW_TO_REVIEW_NO_SEQ.nextval,sysdate,'리뷰2','테스트2',null,5,2,'user2');
insert into tour_review(to_review_no,to_review_date,to_review_title,to_review_content,to_review_img,to_review_star,to_no,user_id) values(TOUR_REVIEW_TO_REVIEW_NO_SEQ.nextval,sysdate,'리뷰3','테스트3',null,4,3,'admin');

--insert tourWishlist
insert into tour_wishlist(to_wish_no,to_no,user_id,wish_no) values(TOUR_WISHLIST_TO_WISH_NO_SEQ.nextval,1,'admin',1);
insert into tour_wishlist(to_wish_no,to_no,user_id,wish_no) values(TOUR_WISHLIST_TO_WISH_NO_SEQ.nextval,4,'admin',1);
insert into tour_wishlist(to_wish_no,to_no,user_id,wish_no) values(TOUR_WISHLIST_TO_WISH_NO_SEQ.nextval,2,'user1',2);
insert into tour_wishlist(to_wish_no,to_no,user_id,wish_no) values(TOUR_WISHLIST_TO_WISH_NO_SEQ.nextval,1,'user2',3);

