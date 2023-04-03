-- 회원 user_info insert(Parent key)
insert into user_info(user_id,password,name,nickname,phone,email,birth,address,gender) values('user1','1111','김1','별명1','010-1111-1111','kms1@korea.com','1991-01-01','강남구',0);
insert into user_info(user_id,password,name,nickname,phone,email,birth,address,gender) values('user2','2222','김2','별명2','010-2222-2222','kms2@korea.com','1992-02-02','강남구',0);
insert into user_info(user_id,password,name,nickname,phone,email,birth,address,gender) values('user3','3333','김3','별명3','010-3333-3333','kms3@korea.com','1993-03-03','강남구',0);


/******** chat_room ***********/
desc chat_room;
insert into chat_room(room_no,room_name,from_id,to_id) values (chat_room_room_no_seq.nextval,'채팅방1','user1','user2');
insert into chat_room(room_no,room_name,from_id,to_id) values (chat_room_room_no_seq.nextval,'채팅방2','user3','user2');
insert into chat_room(room_no,room_name,from_id,to_id) values (chat_room_room_no_seq.nextval,'채팅방3','user2','user3');

/******** chat_msg ***********/
desc chat_msg;
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

