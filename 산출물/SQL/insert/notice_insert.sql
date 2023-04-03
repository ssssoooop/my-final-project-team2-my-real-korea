desc notice;
desc user_info;

-- 회원 user_info insert(Parent key)
insert into user_info(user_id,password,name,nickname,phone,email,birth,address,gender) values('user1','1111','김1','별명1','010-1111-1111','kms1@korea.com','1991-01-01','강남구',0);
insert into user_info(user_id,password,name,nickname,phone,email,birth,address,gender) values('user2','2222','김2','별명2','010-2222-2222','kms2@korea.com','1992-02-02','강남구',0);
insert into user_info(user_id,password,name,nickname,phone,email,birth,address,gender) values('user3','3333','김3','별명3','010-3333-3333','kms3@korea.com','1993-03-03','강남구',0);

-- 공지사항 notice insert

insert into notice(n_no,n_title,n_content,n_date,n_readcount,n_img,user_id) values (notice_n_no_seq.nextval,'공지사항은1','공지사항내용1',sysdate,1,'img.png','user1'); 
insert into notice(n_no,n_title,n_content,n_date,n_readcount,n_img,user_id) values (notice_n_no_seq.nextval,'공지사항은2','공지사항내용2',sysdate,2,'img.png','user2'); 
insert into notice(n_no,n_title,n_content,n_date,n_readcount,n_img,user_id) values (notice_n_no_seq.nextval,'공지사항삼3','공지사항내용3',sysdate,3,'img.png','user3'); 

insert into notice(n_no,n_title,n_content,n_date,n_readcount,n_img,user_id) values (notice_n_no_seq.nextval,'공지사항이다4','공지사항내용4','2023/04/02',4,'img.png','user1'); 
insert into notice(n_no,n_title,n_content,n_date,n_readcount,n_img,user_id) values (notice_n_no_seq.nextval,'공지사항이야5','공지사항내용5','2023/04/03',8,'img.png','user2'); 
insert into notice(n_no,n_title,n_content,n_date,n_readcount,n_img,user_id) values (notice_n_no_seq.nextval,'공지사항안내6','공지사항내용6','2023/04/05',10,'img.png','user3'); 
insert into notice(n_no,n_title,n_content,n_date,n_readcount,n_img,user_id) values (notice_n_no_seq.nextval,'공지사항안내7','공지사항내용7','2023/05/02',15,'img.png','user1'); 
insert into notice(n_no,n_title,n_content,n_date,n_readcount,n_img,user_id) values (notice_n_no_seq.nextval,'공지사항결제8','공지사항내용8','2023/06/03',23,'img.png','user2'); 
insert into notice(n_no,n_title,n_content,n_date,n_readcount,n_img,user_id) values (notice_n_no_seq.nextval,'공지사항결론9','공지사항내용9','2023/07/05',2,'img.png','user3'); 
insert into notice(n_no,n_title,n_content,n_date,n_readcount,n_img,user_id) values (notice_n_no_seq.nextval,'공지사항이다10','공지사항내용4','2023/04/02',4,'img.png','user1'); 
insert into notice(n_no,n_title,n_content,n_date,n_readcount,n_img,user_id) values (notice_n_no_seq.nextval,'공지사항이야11','공지사항내용5','2023/04/03',8,'img.png','user2'); 
insert into notice(n_no,n_title,n_content,n_date,n_readcount,n_img,user_id) values (notice_n_no_seq.nextval,'공지사항안내12','공지사항내용6','2023/04/05',10,'img.png','user3'); 
insert into notice(n_no,n_title,n_content,n_date,n_readcount,n_img,user_id) values (notice_n_no_seq.nextval,'공지사항안내13','공지사항내용7','2023/05/02',15,'img.png','user1'); 
insert into notice(n_no,n_title,n_content,n_date,n_readcount,n_img,user_id) values (notice_n_no_seq.nextval,'공지사항결제14','공지사항내용8','2023/06/03',23,'img.png','user2'); 
insert into notice(n_no,n_title,n_content,n_date,n_readcount,n_img,user_id) values (notice_n_no_seq.nextval,'공지사항결론15','공지사항내용9','2023/07/05',2,'img.png','user3'); 
insert into notice(n_no,n_title,n_content,n_date,n_readcount,n_img,user_id) values (notice_n_no_seq.nextval,'공지사항이다16','공지사항내용4','2023/04/02',4,'img.png','user1'); 
insert into notice(n_no,n_title,n_content,n_date,n_readcount,n_img,user_id) values (notice_n_no_seq.nextval,'공지사항이야17','공지사항내용5','2023/04/03',8,'img.png','user2'); 
insert into notice(n_no,n_title,n_content,n_date,n_readcount,n_img,user_id) values (notice_n_no_seq.nextval,'공지사항안내18','공지사항내용6','2023/04/05',10,'img.png','user3'); 
insert into notice(n_no,n_title,n_content,n_date,n_readcount,n_img,user_id) values (notice_n_no_seq.nextval,'공지사항안내19','공지사항내용7','2023/05/02',15,'img.png','user1'); 
insert into notice(n_no,n_title,n_content,n_date,n_readcount,n_img,user_id) values (notice_n_no_seq.nextval,'공지사항결제20','공지사항내용8','2023/06/03',23,'img.png','user2'); 
insert into notice(n_no,n_title,n_content,n_date,n_readcount,n_img,user_id) values (notice_n_no_seq.nextval,'공지사항결론21','공지사항내용9','2023/07/05',2,'img.png','user3'); 

