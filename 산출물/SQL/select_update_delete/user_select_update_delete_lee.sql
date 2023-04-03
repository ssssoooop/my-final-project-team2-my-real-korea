
-- 관리자가 회원 전체List를 확인
select * from user_info;

-- 1명의 회원정보를 확인
select * from user_info where user_id='mrk111';

-- 회원 정보 수정
update user_info 
set password='mrk_1111',name='마수정',nickname='마수정',phone='010-2121-2121',email='mrk111@korea.com',address='서울시 강남구 역삼동'
where user_id='mrk111';

-- 회원 포인트 수정
update user_info set point+=3000
where user_id='mrk111';

-- 회원 선택정보 수정
update user_add_info set introduce='안녕하세요. 수정된 마리코입니다.',alcohol=1,smoking=1
where user_id='mrk111';

-- 회원 프로필 사진 수정
update user_img set user_img_url='img00.png'
where user_id='mrk111';

-- 회원 삭제
delete from user_info where user_id ='mrk3';
