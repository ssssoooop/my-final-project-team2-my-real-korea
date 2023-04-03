/*********** select ***************/
	--1. 투어상품 전체 출력(List)
	select * from tour;
	--2. 투어상품 상품번호로 상세보기
	select * from tour where to_no=1;
	--3. 키워드로 투어상품 검색(List)
	select * from tour where to_name like '%여행%';
	--4. 지역으로 투어상품 검색(List)
	select * from tour where city_no=2;
	--5. 여행타입으로 투어상품 검색(List)
	select * from tour where to_type=1;
	--6. 투어번호로 투어이미지 전체보기(List)
	select * from tour_img where to_no=1;
	--7. 유저의 투어예약리스트 전체보기(List)
	select * from tour_reserve where user_id='admin';
	--8. 투어예약번호로 예약 상세보기
	select tr.*, t.* from tour_reserve tr join tour t on tr.to_no=t.to_no where tr.to_rs_no=2;
	--9. 투어상품번호로 투어후기 전체 보기(List)
	select * from tour_review where to_no=1;
	--10. 유저가 작성한 투어후기 전체보기 (List) 
	select * from tour_review where user_id='admin';
	--11. 유저의 투어위시리스트 전체보기(List)
	select * from tour_wishlist where user_id='user1';
	--12. 투어위시리스트 중 하나 상세보기
	select t.*, tw.* from tour t join tour_wishlist tw on t.to_no=tw.to_no where to_wish_no=3;
	
/*********** delete ***************/
	--1. 투어상품 삭제
	delete from tour where to_no=1;
	--2. 투어이미지 하나 삭제
	delete from tour_img where to_img_no=1;
	--3. 투어상품의 이미지 전체 삭제
	delete from tour_img where to_no=1;
	--4. 투어예약 하나 삭제
	delete from tour_reserce where to_rs_no=1;
	--5. 사용자의 투어예약 전체삭제
	delete from tour_reserve where user_id='admin';
	--6. 투어후기 하나 삭제
	delete from tour_review where to_riview_no=1;
	--7. 사용자의 투어후기 전체 삭제
	delete from tour_review where user_id='user1';
	--8. 투어위시리스트 하나 삭제
	delete from tour_wishlist where to_wish_no=1;
	--9. 사용자의 투어위시리스트 전체 삭제
	delete from tour_wishlist where user_id='user2';
	
/*********** update ***************/
	--.1 투어상품 수정
	update tour set to_name='변경', to_type=1, to_time=100,to_person=5,to_meet='강남',to_price=10,to_info='졸려요',to_notice='집갈래요',city_no='3' where to_no=2;
	--2. 투어예약 변경
	update tour_reserve set to_rs_start_day='2000-02-03', to_rs_person='8', to_rs_msg='변경할게요' where to_rs_no=2;
	--3. 투어후기 수정
	update tour_review set to_review_title='바꿔보자', to_review_content='바뀌었나요', to_review_img='change.jpg', to_reveiw_star=2 where to_no=4;
	
	
	