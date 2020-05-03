
create database express_transportation;
use express_transportation;
create table personnel_info(
p_id int auto_increment primary key,
p_name varchar(30) comment '姓名',
sex varchar(30) comment '性别',
birthhday varchar(30) comment '出生日期',
phone varchar(30) unique key comment '手机号码',
password varchar(30) comment '密码',
role varchar(30) comment '角色'
);
create table evaluate(
e_id int auto_increment primary key,
waybill_no varchar(30) comment '运单号',
kdy_id int comment '快递员id',
kdy_name varchar(30) comment '快递员名字',
kh_name varchar(30) comment '寄件人',
branch varchar(30) comment '评价分数',
p_content varchar(250) comment '评价内容',
t_content varchar(250) comment '投诉内容'
);
create table positions(
p_id int auto_increment primary key,
waybill_no varchar(30) comment '运单号',
d_position varchar(30) comment '当前位置',
x_position varchar(30) comment '下一站位置',
p_time varchar(30) comment '更新时间'
);
create table waybill(
waybill_no varchar(30) comment '运单号',
weight varchar(30) comment '重量',
price varchar(30) comment '价格',
kdy_id varchar(10) comment '快递员id',
kdy_name varchar(30) comment '快递员姓名',
kdy_phone varchar(30) comment '快递员手机号码',
j_name varchar(30) comment '寄件人姓名',
j_phone varchar(30) comment '寄件人手机',
j_address varchar(30) comment '寄件地址',
s_name varchar(30) comment '收件人姓名',
s_phone varchar(30) comment '收件人手机',
s_address varchar(30) comment '收件地址',
w_status varchar(30) comment '订单状态',
e_id varchar(10) comment '评价id'
);