/************ chat_room *************/
-- 채팅방 번호로 채팅방 보기(채팅방 선택 가능)
select * from chat_room where room_no=1;

-- from_id, to_id 로 채팅방 찾기 -> 채팅방 중복 체크 가능
select * from chat_room where from_id='user2' and to_id='user3';

-- 회원의 채팅방 목록 보기(room_no, room_name, msg_send_time, msg_content)
select a.room_no, a.room_name, msg_no, msg_send_time, msg_content,msg_read, user_id
from (select room_no, room_name from chat_room where from_id='user1' or to_id='user1') a
inner join (select aa.msg_no, aa.msg_send_time, aa.room_no, aa.msg_content,aa.msg_read, aa.user_id from chat_msg aa
            ) b 
on a.room_no = b.room_no
order by msg_send_time desc;

-- 채팅방 안읽은 메세지 수
select count(*) from chat_msg where room_no=1 and msg_read=0 and user_id!='user1';

-- 보내는 사람(from_id)으로 채팅중인 사람들 보기
select room_no, from_id as you_id from chat_room where to_id='user2';

-- 채팅방 삭제
delete from chat_room where room_no=1;


/************ chat_msg *************/

-- 채팅방 1개 전체 대화 보기 
select * from chat_msg where room_no=1 order by msg_no;

-- 채팅 메세지 1개 보기
select * from chat_msg where msg_no=4;

-- 로그인한 회원이 읽지 않은 채팅방 1개의 메세지
select * from chat_msg where room_no=1 and msg_read=0 and user_id!='user1';

-- 로그인한 회원이 채팅방 1개의 읽지 않은 메세지의 수
select count(*) from chat_msg where room_no=1 and msg_read=0 and user_id!='user1';

-- 로그인한 회원이 읽지 않은 메세지의 총 개수
select count(*) from (select * from chat_msg 
                        where room_no in
                            (select room_no from chat_room c
                            where from_id='user2' or to_id='user2')
                    ) cr
where cr.msg_read=0 and cr.user_id!='user2';

-- 로그인한 회원이 읽지 않은 메세지 전체 보기
select * from (select * from chat_msg 
                        where room_no in
                            (select room_no from chat_room c
                            where from_id='user2' or to_id='user2')
                    ) cr
where cr.msg_read=0 and cr.user_id!='user2';

-- 로그인한 회원이 채팅방 전체의 읽지 않은 메세지가 있는 채팅방번호와 메세지의 수
select room_no, count(*) from chat_msg
where room_no in (select room_no from chat_room where from_id='user2' or to_id='user2')
and msg_read=0 and user_id!='user2'
group by room_no;

-- 메세지 읽음 수 1로 변경
update chat_msg set msg_read=1 where room_no=1 and user_id='user1';

-- 채팅 메세지 1개 삭제
delete chat_msg where msg_no=3;

-- + 삭제된 메세지 내용 변경
update chat_msg set msg_content='삭제된 메세지입니다.' where msg_no=3;
