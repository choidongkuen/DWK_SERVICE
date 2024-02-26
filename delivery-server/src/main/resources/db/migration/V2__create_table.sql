# 메뉴 테이블
create table `menus`
(
    menu_id    bigint(8)      not null comment '메뉴 아이디',
    store_id   bigint(8)      not null comment '상점 아이디',
    menu_name  varchar(45)    not null comment '메뉴 이름',
    price      decimal(10, 2) not null comment '메뉴 가격',
    status     varchar(45)    not null comment '메뉴 상태',
    is_deleted bit(1)         not null default 0 comment '삭제 여부',
    created_at datetime       not null default current_timestamp comment '생성일',
    updated_at datetime       not null default current_timestamp comment '수정일',
    created_by varchar(45)    not null comment '생성자',
    updated_by varchar(45)    not null comment '수정자',
    primary key (`menu_id`),
    index `idx_01_store_id` (`store_id` asc) visible,
    foreign key (`store_id`) references `stores` (store_id)
);


# 카테고리 테이블
create table categories
(
    category_id   bigint(8)   not null auto_increment comment '카테고리 아이디',
    category_name varchar(45) not null comment '카테고리 이름',
    `rank`        int         not null comment '카테고리 메뉴 순서',
    is_deleted    bit(1)      not null default 0 comment '삭제 여부',
    created_at    datetime    not null default current_timestamp comment '생성일',
    updated_at    datetime    not null default current_timestamp comment '수정일',
    created_by    varchar(45) not null comment '생성자',
    updated_by    varchar(45) not null comment '수정자',
    primary key (`category_id`)
);


# 주문 테이블
create table orders
(
    order_id bigint(8) not null auto_increment comment '주문 아이디',
    order_amount decimal(10,0) not null comment '주문 금액',
    discount_amount decimal(10,0) not null comment '할인 금액',
    delivery_fee decimal(10,0) not null comment '배달료',
    total_order_amount decimal(10,0) not null comment '총 주문 금액',
    order_status varchar(45) not null comment '주문 상태',
    is_deleted bit(1) not null default 0 comment '삭제 여부',
    created_at datetime not null default current_timestamp comment '생성일',
    updated_at datetime not null default current_timestamp comment '수정일',
    created_by varchar(45) not null comment '생성자',
    updated_by varchar(45) not null comment '수정자',
    primary key (`order_id`)
)   ENGINE=InnoDB default charset=utf8mb4 collate=utf8mb4_0900_ai_ci;

# 주문 상품
create table order_items
(
    order_item_id bigint(8) not null auto_increment comment '주문 상품 아이디',
    order_id bigint(8) not null comment '주문 아이디',
    menu_id bigint(8) not null comment '음식 메뉴 아이디',
    menu_price decimal(10,0) not null comment '음식 메뉴 가격',
    is_deleted bit(1) not null default 0 comment '삭제 여부',
    created_at datetime not null default current_timestamp comment '생성일',
    updated_at datetime not null default current_timestamp comment '수정일',
    created_by varchar(45) not null comment '생성자',
    updated_by varchar(45) not null comment '수정자',
    primary key (`order_item_id`),
    index `idx_01_order_id`(`order_id`),
    index `idx_02_menu_id`(`menu_id`)
)ENGINE = InnoDB AUTO_INCREMENT=2 default charset=utf8mb4 collate = utf8mb4_0900_ai_ci;
