desc wishlist;
select * from wishlist;

-- 위시리스트 리스트 전체 보기 (user_id)
select * from wishlist where user_id='user1';

-- 위시리스트 리스트 보기 + 티켓상품 + 투어상품  (user_id)
select * from wishlist w 
left join ticket ti on w.ti_no=ti.ti_no
left join tour tu on w.to_no=tu.to_no
where user_id='user1';


-- 위시리스트 한 개 보기 (선택)
select * from wishlist where wish_no=3;


-- 위시리스트 담겨있는 티켓/투어 상품의 수 
select count(*) from wishlist where user_id='user1';

-- 위시리스트 전체 삭제 
delete wishlist where user_id='user1';

-- 위시리스트 한 개 삭제
delete wishlist where wish_no=4 and user_id='user2';



