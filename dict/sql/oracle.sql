drop table SYS_DICT_VALUE;
drop table SYS_DICT;

/*==============================================================*/
/* Name:<数据字典> Table: SYS_DICT                               */
/*==============================================================*/
drop table SYS_DICT;
create table SYS_DICT (
  DICT_ID                         varchar2(36 byte)     visible  not null,
  DICT_KEY                        varchar2(255 byte)    visible  not null,
  DICT_NAME                       varchar2(255 byte)    visible      null,
  NOTES                           varchar2(255 byte)    visible      null,
  WEIGHT_ORDER                    number(11)            visible      null,

  VERSIONS                        number(11)            visible  not null,
  CREATE_ID                       varchar2(36 byte)     visible  not null,
  CREATE_NAME                     varchar2(255 byte)    visible  not null,
  CREATE_TIMES                    number(20)            visible  not null,
  MODIFY_ID                       varchar2(36 byte)     visible      null,
  MODIFY_NAME                     varchar2(255 byte)    visible      null,
  MODIFY_TIMES                    number(20)            visible      null,
  primary key ( DICT_ID ),
  unique ( DICT_KEY )
)
TABLESPACE "USERS"
LOGGING
NOCOMPRESS
PCTFREE 10
INITRANS 1
STORAGE (
  INITIAL 65536
  NEXT 1048576
  MINEXTENTS 1
  MAXEXTENTS 2147483645
  BUFFER_POOL DEFAULT
)
PARALLEL 1
NOCACHE
DISABLE ROW MOVEMENT
;
COMMENT ON TABLE "SYS_DICT" IS '数据字典';
COMMENT ON COLUMN "SYS_DICT"."DICT_ID" IS '数据字典编号';
COMMENT ON COLUMN "SYS_DICT"."DICT_KEY" IS '数据字典标识';
COMMENT ON COLUMN "SYS_DICT"."DICT_NAME" IS '数据字典名称';
COMMENT ON COLUMN "SYS_DICT"."NOTES" IS '说明';
COMMENT ON COLUMN "SYS_DICT"."WEIGHT_ORDER" IS '排序权重';
COMMENT ON COLUMN "SYS_DICT"."VERSIONS" IS '版本号';
COMMENT ON COLUMN "SYS_DICT"."CREATE_ID" IS '创建人账号';
COMMENT ON COLUMN "SYS_DICT"."CREATE_NAME" IS '创建人名称';
COMMENT ON COLUMN "SYS_DICT"."CREATE_TIMES" IS '创建时间';
COMMENT ON COLUMN "SYS_DICT"."MODIFY_ID" IS '修改人账号';
COMMENT ON COLUMN "SYS_DICT"."MODIFY_NAME" IS '修改人名称';
COMMENT ON COLUMN "SYS_DICT"."MODIFY_TIMES" IS '修改时间';

/*==============================================================*/
/* Name:<数据字典值> Table: SYS_DICT_VALUE                       */
/*==============================================================*/
drop table SYS_DICT_VALUE;
create table SYS_DICT_VALUE (
  DICT_VALUE_ID                   varchar2(36 byte)     visible  not null,
  CODE                            varchar2(255 byte)    visible  not null,
  DISPLAY_NAME                    varchar2(255 byte)    visible  not null,
  WEIGHT_ORDER                    number(11)            visible      null,
  DESCRIPTION                     varchar2(4000 byte)   visible      null,

  DICT_ID                         varchar2(36 byte)     visible  not null,

  VERSIONS                        number(11)            visible  not null,
  CREATE_ID                       varchar2(36 byte)     visible  not null,
  CREATE_NAME                     varchar2(255 byte)    visible  not null,
  CREATE_TIMES                    number(20)            visible  not null,
  MODIFY_ID                       varchar2(36 byte)     visible      null,
  MODIFY_NAME                     varchar2(255 byte)    visible      null,
  MODIFY_TIMES                    number(20)            visible      null,
  primary key ( DICT_VALUE_ID ),
  unique ( CODE, DICT_ID )
)
TABLESPACE "USERS"
LOGGING
NOCOMPRESS
PCTFREE 10
INITRANS 1
STORAGE (
  INITIAL 65536
  NEXT 1048576
  MINEXTENTS 1
  MAXEXTENTS 2147483645
  BUFFER_POOL DEFAULT
)
PARALLEL 1
NOCACHE
DISABLE ROW MOVEMENT
;
COMMENT ON TABLE "SYS_DICT_VALUE" IS '数据字典值';
COMMENT ON COLUMN "SYS_DICT_VALUE"."DICT_VALUE_ID" IS '数据字典值编号';
COMMENT ON COLUMN "SYS_DICT_VALUE"."CODE" IS '代码';
COMMENT ON COLUMN "SYS_DICT_VALUE"."DISPLAY_NAME" IS '显示名称';
COMMENT ON COLUMN "SYS_DICT_VALUE"."WEIGHT_ORDER" IS '排序权重';
COMMENT ON COLUMN "SYS_DICT_VALUE"."DESCRIPTION" IS '描述';
COMMENT ON COLUMN "SYS_DICT_VALUE"."DICT_ID" IS '数据字典编号';
COMMENT ON COLUMN "SYS_DICT_VALUE"."VERSIONS" IS '版本号';
COMMENT ON COLUMN "SYS_DICT_VALUE"."CREATE_ID" IS '创建人账号';
COMMENT ON COLUMN "SYS_DICT_VALUE"."CREATE_NAME" IS '创建人名称';
COMMENT ON COLUMN "SYS_DICT_VALUE"."CREATE_TIMES" IS '创建时间';
COMMENT ON COLUMN "SYS_DICT_VALUE"."MODIFY_ID" IS '修改人账号';
COMMENT ON COLUMN "SYS_DICT_VALUE"."MODIFY_NAME" IS '修改人名称';
COMMENT ON COLUMN "SYS_DICT_VALUE"."MODIFY_TIMES" IS '修改时间';

alter table SYS_DICT_VALUE add constraint FK_SYS_DICT_VALUE_DICT_ID foreign key (DICT_ID) references SYS_DICT(DICT_ID);
