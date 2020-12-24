create table user(
    id int unsigned key unique auto_increment,
    username varchar(50) not null ,
    password varchar(50) not null,
    address varchar(100)
);

insert into user
values (null, 'admin', '123456', 'London'),
       (null, 'guest', '123456', 'New York'),
       (null,'zhangsan','123456','上海'),
       (null,'lisi','123456','北京'),
       (null,'王五','123456','广州');

create table phone
(
    pid     int unsigned key unique auto_increment,
    p_brand varchar(50),
    p_model varchar(50),
    p_size  double(4, 2),
    p_price double(8, 2)
);

insert into phone
values (null, '小米', '小米10', 6.67, 3999.00),
       (null, '小米', '小米10至尊纪念版', 6.67, 5999.00),
       (null, '华为', 'HUAWEI P40 Pro+', 6.58, 7988.00),
       (null, '华为', 'Mate40 Pro', 6.76, 7999.00);


create table computer
(
    cid     int unsigned key unique auto_increment,
    c_brand varchar(50),
    c_model varchar(50),
    c_cpu   varchar(50),
    c_gpu   varchar(50)
);
insert into computer
values (null, '联想', '联想小新Air14', 'i7-1165G7', 'MX450'),
       (null, 'ROG玩家国度', 'ROG魔霸新锐', 'i7-10870H', 'RTX2060'),
       (null, '联想', '拯救者R7000P', 'AMD R7', 'RTX2060'),
       (null, '华硕', '飞行堡垒8', 'i7-10870H', 'GTX1660Ti');

create table dog
(
    did       int unsigned key unique auto_increment,
    d_name    varchar(50),
    d_species varchar(50),
    d_age     int comment '月'
);
insert into dog
values (null,'毛豆','博美',8),
       (null,'曲奇','柴犬',12),
       (null,'二哈','哈士奇',9),
       (null,'老黄','中华田园犬',11);

