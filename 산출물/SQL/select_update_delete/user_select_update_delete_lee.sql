
-- �����ڰ� ȸ�� ��üList�� Ȯ��
select * from user_info;

-- 1���� ȸ�������� Ȯ��
select * from user_info where user_id='mrk111';

-- ȸ�� ���� ����
update user_info 
set password='mrk_1111',name='������',nickname='������',phone='010-2121-2121',email='mrk111@korea.com',address='����� ������ ���ﵿ'
where user_id='mrk111';

-- ȸ�� ����Ʈ ����
update user_info set point+=3000
where user_id='mrk111';

-- ȸ�� �������� ����
update user_add_info set introduce='�ȳ��ϼ���. ������ �������Դϴ�.',alcohol=1,smoking=1
where user_id='mrk111';

-- ȸ�� ������ ���� ����
update user_img set user_img_url='img00.png'
where user_id='mrk111';

-- ȸ�� ����
delete from user_info where user_id ='mrk3';
