# 고객 테이블
create table customer
(
    customer_id bigint(8)    not null auto_increment comment '고객 아이디',
    name        varchar(45)  not null comment '고객 이름',
    email       varchar(45)  not null unique comment '고객 이메일',
    password    varchar(45)  not null comment '고객 비밀번호',
    phone       varchar(45)  not null comment '고객 전화번호',
    address     varchar(255) not null comment '고객 주소',
    status      varchar(45)  not null comment '고객 상태',
    is_deleted  bit(1)       not null default 0 comment '삭제 여부',
    created_at  datetime     not null default CURRENT_TIMESTAMP comment '생성일',
    updated_at  datetime     not null default CURRENT_TIMESTAMP comment '수정일',
    created_by  varchar(45)  not null comment '생성자',
    updated_by  varchar(45)  not null comment '수정자',
    primary key (`customer_id`),
    index `idx_01_email` using btree (`email`) visible,
    index `idx_02_phone` (`phone` asc) visible
);

# 상점 테이블
create table stores
(
    store_id        bigint(8)    not null auto_increment comment '상점 아이디',
    name            varchar(45)  not null comment '상점 이름',
    business_number varchar(45)  not null comment '사업자 번호',
    email           varchar(45)  not null unique comment '상점 이메일',
    phone           varchar(45)  not null comment '상점 전화번호',
    address         varchar(255) not null comment '상점 주소',
    password        varchar(45)  not null comment '상점 비밀번호',
    bank_account    varchar(45)  not null comment '상점 은행 계좌',
    bank_name       varchar(45)  not null comment '상점 은행 명',
    status          varchar(45)  not null comment '상점 상태',
    is_deleted      bit(1)       not null default 0 comment '삭제 여부',
    created_at      datetime     not null default CURRENT_TIMESTAMP comment '생성일',
    updated_at      datetime     not null default CURRENT_TIMESTAMP comment '수정일',
    created_by      varchar(45)  not null comment '생성자',
    updated_by      varchar(45)  not null comment '수정자',
    primary key (`store_id`),
    index `idx_01_business_number` (`business_number` asc) visible,
    index `idx_02_phone` (`phone` asc) visible,
    index `idx_03_bank_account` (`bank_account` asc) visible
);


# 라이더(배달 파트너)
create table delivery_partner
(
    delivery_partner_id bigint(8)   not null auto_increment comment '배달 파트너 아이디',
    email               varchar(45) not null unique comment '배달 파트너 이메일',
    password            varchar(45) not null comment '배달 파트너 비밀번호',
    transportation      varchar(45) not null comment '배달 수단',
    delivery_zone       varchar(45) not null comment '배달지, 배달구역',
    bank_code           varchar(45) not null comment '은행 식별 코드',
    bank_name           varchar(45) not null comment '은행 명',
    bank_account        varchar(45) not null comment '은행 계좌',
    status              varchar(45) not null comment '배달 파트너 상태',
    is_deleted          bit(1)      not null default 0 comment '삭제 여부',
    created_at          datetime    not null default current_timestamp comment '생성일',
    updated_at          datetime    not null default current_timestamp comment '수정일',
    created_by          varchar(45) not null comment '생성자',
    updated_by          varchar(45) not null comment '수정자',
    primary key (`delivery_partner_id`),
    index `idx_01_email` (`email` asc) visible,
    index `idx_02_bank_account` (`bank_account` asc) visible
);
