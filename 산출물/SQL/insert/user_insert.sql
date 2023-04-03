
--user_info
insert into user_info(user_id,password,name,nickname,phone,email,birth,address,gender,point,is_admin) 
	values('admin','admin0000','관리자','관리자','010-0000-0000','admin0@gmail.com','2000-01-01','테헤란로0',0,0,0); 

insert into user_info(user_id,password,name,nickname,phone,email,birth,address,gender,point,is_admin) 
	values('user1','user1111','회원1','마리코1','010-1111-1111','user1@gmail.com','2001-01-01','테헤란로1',0,0,1); 

insert into user_info(user_id,password,name,nickname,phone,email,birth,address,gender,point,is_admin) 
	values('user2','user2222','회원2','마리코2','010-2222-2222','user2@gmail.com','2002-02-02','테헤란로2',1,0,1); 

insert into user_info(user_id,password,name,nickname,phone,email,birth,address,gender,point,is_admin) 
	values('user3','user3333','회원3','마리코3','010-3333-3333','user3@gmail.com','2003-03-03','테헤란로3',1,0,1); 

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




