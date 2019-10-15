/*==============================================================*/
/* Name:<数据库表> Table: PRO_DT                                 */
/*==============================================================*/
create table PRO_DT (
  DT_ID                           varchar2(36 byte)     visible  not null,
  DT_SQL                          varchar2(4000 byte)   visible  not null,
  DT_NAME                         varchar2(255 byte)    visible      null,
  DT_NAME_ANNOTATION              varchar2(255 byte)    visible      null,
  DT_PREFIX                       varchar2(255 byte)    visible      null,
  INITIAL_CASE_ENTITY_NAME        varchar2(255 byte)    visible      null,
  INITIAL_LOWERCASE_ENTITY_NAME   varchar2(255 byte)    visible      null,
  PRO_PATH                        varchar2(2000 byte)   visible      null,
  PRO_ALL_NAME                    varchar2(255 byte)    visible      null,
  primary key ( DT_ID ),
  unique ( DT_NAME )
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
COMMENT ON TABLE "PRO_DT" IS '数据库表';
COMMENT ON COLUMN "PRO_DT"."DT_ID" IS '数据库表编号';
COMMENT ON COLUMN "PRO_DT"."DT_SQL" IS '数据库表sql';
COMMENT ON COLUMN "PRO_DT"."DT_NAME" IS '表名';
COMMENT ON COLUMN "PRO_DT"."DT_NAME_ANNOTATION" IS '表名注释';
COMMENT ON COLUMN "PRO_DT"."DT_PREFIX" IS '数据库表前缀';
COMMENT ON COLUMN "PRO_DT"."INITIAL_CASE_ENTITY_NAME" IS '首字母大写实体类名';
COMMENT ON COLUMN "PRO_DT"."INITIAL_LOWERCASE_ENTITY_NAME" IS '首字母小写实体类名';
COMMENT ON COLUMN "PRO_DT"."PRO_PATH" IS '项目路径';
COMMENT ON COLUMN "PRO_DT"."PRO_ALL_NAME" IS '项目全称';

/*==============================================================*/
/* Name:<列> Table: PRO_COLUMNS                                 */
/*==============================================================*/
create table PRO_COLUMNS (
  COLUMNS_ID                      varchar2(36 byte)     visible  not null,
  COLUMN_NAME                     varchar2(255 byte)    visible      null,
  COLUMN_NAME_ANNOTATION          varchar2(255 byte)    visible      null,
  DATA_TYPE                       varchar2(255 byte)    visible      null,
  IS_NULL                         varchar2(1 byte)      visible      null,
  INITIAL_CASE_COLUMN_NAME        varchar2(255 byte)    visible      null,
  INITIAL_LOWERCASE_COLUMN_NAME   varchar2(255 byte)    visible      null,
  WEIGHT_ORDER                    number(11)            visible      null,

  DT_ID                           varchar2(36 byte)     visible  not null,
  primary key ( COLUMNS_ID ),
  unique ( COLUMN_NAME, DT_ID )
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
COMMENT ON TABLE "PRO_COLUMNS" IS '列';
COMMENT ON COLUMN "PRO_COLUMNS"."COLUMNS_ID" IS '列编号';
COMMENT ON COLUMN "PRO_COLUMNS"."COLUMN_NAME" IS '列名';
COMMENT ON COLUMN "PRO_COLUMNS"."COLUMN_NAME_ANNOTATION" IS '列名注释';
COMMENT ON COLUMN "PRO_COLUMNS"."DATA_TYPE" IS '数据类型';
COMMENT ON COLUMN "PRO_COLUMNS"."IS_NULL" IS '是否为空';
COMMENT ON COLUMN "PRO_COLUMNS"."INITIAL_CASE_COLUMN_NAME" IS '首字母大写列名';
COMMENT ON COLUMN "PRO_COLUMNS"."INITIAL_LOWERCASE_COLUMN_NAME" IS '首字母小写列名';
COMMENT ON COLUMN "PRO_COLUMNS"."WEIGHT_ORDER" IS '排序权重';
COMMENT ON COLUMN "PRO_COLUMNS"."DT_ID" IS '数据库表编号';

alter table PRO_COLUMNS add constraint FK_PRO_COLUMN_DT_ID foreign key (DT_ID) references PRO_DT(DT_ID);

/*==============================================================*/
/* Name:<主键> Table: PRO_PK                                    */
/*==============================================================*/
create table PRO_PK (
  PK_ID                           varchar2(36 byte)     visible  not null,
  DT_ID                           varchar2(36 byte)     visible  not null,
  COLUMNS_ID                      varchar2(36 byte)     visible  not null,
  primary key ( PK_ID ),
  unique ( DT_ID, COLUMNS_ID )
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
COMMENT ON TABLE "PRO_PK" IS '主键';
COMMENT ON COLUMN "PRO_PK"."PK_ID" IS '主键编号';
COMMENT ON COLUMN "PRO_PK"."DT_ID" IS '数据库表编号';
COMMENT ON COLUMN "PRO_PK"."COLUMNS_ID" IS '列编号';

alter table PRO_PK add constraint FK_PRO_PK_DT_ID foreign key (DT_ID) references PRO_DT(DT_ID);
alter table PRO_PK add constraint FK_PRO_PK_COLUMNS_ID foreign key (COLUMNS_ID) references PRO_COLUMNS(COLUMNS_ID);

/*==============================================================*/
/* Name:<排序> Table: PRO_SORT                                  */
/*==============================================================*/
create table PRO_SORT (
  SORT_ID                         varchar2(36 byte)     visible  not null,
  SORT_RULE                       varchar2(255 byte)    visible  not null,
  DT_ID                           varchar2(36 byte)     visible  not null,
  COLUMNS_ID                      varchar2(36 byte)     visible  not null,
  primary key ( SORT_ID ),
  unique ( DT_ID, COLUMNS_ID )
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
COMMENT ON TABLE "PRO_SORT" IS '排序';
COMMENT ON COLUMN "PRO_SORT"."SORT_ID" IS '排序编号';
COMMENT ON COLUMN "PRO_SORT"."SORT_RULE" IS '排序规则';
COMMENT ON COLUMN "PRO_SORT"."DT_ID" IS '数据库表编号';
COMMENT ON COLUMN "PRO_SORT"."COLUMNS_ID" IS '列编号';

alter table PRO_SORT add constraint FK_PRO_SORT_DT_ID foreign key (DT_ID) references PRO_DT(DT_ID);
alter table PRO_SORT add constraint FK_PRO_SORT_COLUMNS_ID foreign key (COLUMNS_ID) references PRO_COLUMNS(COLUMNS_ID);

/*==============================================================*/
/* Name:<查询> Table: PRO_QUERY                                 */
/*==============================================================*/
create table PRO_QUERY (
  QUERY_ID                        varchar2(36 byte)     visible  not null,
  QUERY_TYPE                      varchar2(255 byte)    visible  not null,
  DT_ID                           varchar2(36 byte)     visible  not null,
  COLUMNS_ID                      varchar2(36 byte)     visible  not null,
  WEIGHT_ORDER                    number(11)            visible      null,
  primary key ( QUERY_ID ),
  unique ( QUERY_TYPE, DT_ID, COLUMNS_ID )
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
COMMENT ON TABLE "PRO_QUERY" IS '查询';
COMMENT ON COLUMN "PRO_QUERY"."QUERY_ID" IS '查询编号';
COMMENT ON COLUMN "PRO_QUERY"."QUERY_TYPE" IS '查询类型';
COMMENT ON COLUMN "PRO_QUERY"."DT_ID" IS '数据库表编号';
COMMENT ON COLUMN "PRO_QUERY"."COLUMNS_ID" IS '列编号';
COMMENT ON COLUMN "PRO_QUERY"."WEIGHT_ORDER" IS '排序权重';

alter table PRO_QUERY add constraint FK_PRO_QUERY_DT_ID foreign key (DT_ID) references PRO_DT(DT_ID);
alter table PRO_QUERY add constraint FK_PRO_QUERY_COLUMNS_ID foreign key (COLUMNS_ID) references PRO_COLUMNS(COLUMNS_ID);

/*==============================================================*/
/* Name:<虚拟列> Table: PRO_VIRTUAL_COLUMNS                     */
/*==============================================================*/
create table PRO_VIRTUAL_COLUMNS (
  VIRTUAL_COLUMNS_ID              varchar2(36 byte)     visible  not null,

  SOURCE_DT_ID                    varchar2(36 byte)     visible  not null,
  TARGET_DT_ID                    varchar2(36 byte)     visible  not null,

  SOURCE_COLUMNS_ID               varchar2(36 byte)     visible  not null,
  TARGET_COLUMNS_ID               varchar2(36 byte)     visible  not null,

  TARGET_DISPLAY_COLUMNS_ID       varchar2(36 byte)     visible  not null,

  DISPLAY_COLUMNS_ALIAS           varchar2(255 byte)    visible  not null,

  VIRTUAL_COLUMNS_SQL             varchar2(2000 byte)   visible  not null,

  WEIGHT_ORDER                    number(11)            visible      null,
  primary key ( VIRTUAL_COLUMNS_ID )
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
COMMENT ON TABLE "PRO_VIRTUAL_COLUMNS" IS '虚拟列';
COMMENT ON COLUMN "PRO_VIRTUAL_COLUMNS"."VIRTUAL_COLUMNS_ID" IS '虚拟列编号';
COMMENT ON COLUMN "PRO_VIRTUAL_COLUMNS"."SOURCE_DT_ID" IS '源表数据库表编号';
COMMENT ON COLUMN "PRO_VIRTUAL_COLUMNS"."TARGET_DT_ID" IS '目标表数据库表编号';
COMMENT ON COLUMN "PRO_VIRTUAL_COLUMNS"."SOURCE_COLUMNS_ID" IS '源表列编号';
COMMENT ON COLUMN "PRO_VIRTUAL_COLUMNS"."TARGET_COLUMNS_ID" IS '目标表列编号';
COMMENT ON COLUMN "PRO_VIRTUAL_COLUMNS"."TARGET_DISPLAY_COLUMNS_ID" IS '目标表显示字段列编号';
COMMENT ON COLUMN "PRO_VIRTUAL_COLUMNS"."DISPLAY_COLUMNS_ALIAS" IS '显示字段别名';
COMMENT ON COLUMN "PRO_VIRTUAL_COLUMNS"."VIRTUAL_COLUMNS_SQL" IS '虚拟列sql';
COMMENT ON COLUMN "PRO_VIRTUAL_COLUMNS"."WEIGHT_ORDER" IS '排序权重';

alter table PRO_VIRTUAL_COLUMNS add constraint FK_PRO_VIRTUA_COL_SOURCE_DT_ID foreign key (SOURCE_DT_ID) references PRO_DT(DT_ID);
alter table PRO_VIRTUAL_COLUMNS add constraint FK_PRO_VIRTUA_COL_TARGET_DT_ID foreign key (TARGET_DT_ID) references PRO_DT(DT_ID);
alter table PRO_VIRTUAL_COLUMNS add constraint FK_PRO_VIRTUA_COL_SOURC_COL_ID foreign key (SOURCE_COLUMNS_ID) references PRO_COLUMNS(COLUMNS_ID);
alter table PRO_VIRTUAL_COLUMNS add constraint FK_PRO_VIRTUA_COL_TARGE_COL_ID foreign key (TARGET_COLUMNS_ID) references PRO_COLUMNS(COLUMNS_ID);
alter table PRO_VIRTUAL_COLUMNS add constraint FK_PRO_VIRTUA_COL_T_DIS_COL_ID foreign key (TARGET_DISPLAY_COLUMNS_ID) references PRO_COLUMNS(COLUMNS_ID);

/*==============================================================*/
/* Name:<数据字典> Table: SYS_DICT                               */
/*==============================================================*/
create table SYS_DICT (
  DICT_ID                         varchar2(36 byte)     visible  not null,
  DICT_KEY                        varchar2(255 byte)    visible  not null,
  DICT_NAME                       varchar2(255 byte)    visible      null,
  NOTES                           varchar2(4000 byte)   visible      null,
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

/*==============================================================*/
/* Name:<账号> Table: SYS_ACCOUNT                               */
/*==============================================================*/
create table SYS_ACCOUNT (
  ACCOUNT_ID                      varchar2(36 byte)     visible  not null,
  ACCOUNT                         varchar2(255 byte)    visible  not null,
  PASSWORD                        varchar2(255 byte)    visible  not null,
  MOBILE_PHONE_NUMBER             varchar2(255 byte)    visible      null,
  COOKIES_EXPIRE_TIMES_BROWSER    number(20)            visible      null,
  COOKIES_EXPIRE_TIMES_ANDROID    number(20)            visible      null,
  COOKIES_EXPIRE_TIMES_IOS        number(20)            visible      null,
  COOKIES_EXPIRE_TIMES_WECHATAPP  number(20)            visible      null,

  NEXUS_TYPE                      varchar2(255 byte)    visible      null,
  NEXUS_OBJECT_ID                 varchar2(255 byte)    visible      null,

  VERSIONS                        number(11)            visible  not null,
  CREATE_ID                       varchar2(36 byte)     visible  not null,
  CREATE_NAME                     varchar2(255 byte)    visible  not null,
  CREATE_TIMES                    number(20)            visible  not null,
  MODIFY_ID                       varchar2(36 byte)     visible      null,
  MODIFY_NAME                     varchar2(255 byte)    visible      null,
  MODIFY_TIMES                    number(20)            visible      null,
  primary key ( ACCOUNT_ID ),
  unique ( ACCOUNT )
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
COMMENT ON TABLE "SYS_ACCOUNT" IS '账号';
COMMENT ON COLUMN "SYS_ACCOUNT"."ACCOUNT_ID" IS '账号编号';
COMMENT ON COLUMN "SYS_ACCOUNT"."ACCOUNT" IS '账号';
COMMENT ON COLUMN "SYS_ACCOUNT"."PASSWORD" IS '密码';
COMMENT ON COLUMN "SYS_ACCOUNT"."MOBILE_PHONE_NUMBER" IS '手机号';
COMMENT ON COLUMN "SYS_ACCOUNT"."COOKIES_EXPIRE_TIMES_BROWSER" IS '浏览器会话过期时间';
COMMENT ON COLUMN "SYS_ACCOUNT"."COOKIES_EXPIRE_TIMES_ANDROID" IS '安卓APP会话过期时间';
COMMENT ON COLUMN "SYS_ACCOUNT"."COOKIES_EXPIRE_TIMES_IOS" IS '苹果APP会话过期时间';
COMMENT ON COLUMN "SYS_ACCOUNT"."COOKIES_EXPIRE_TIMES_WECHATAPP" IS '微信小程序会话过期时间';
COMMENT ON COLUMN "SYS_ACCOUNT"."NEXUS_TYPE" IS '关联类型';
COMMENT ON COLUMN "SYS_ACCOUNT"."NEXUS_OBJECT_ID" IS '对象编号';
COMMENT ON COLUMN "SYS_ACCOUNT"."VERSIONS" IS '版本号';
COMMENT ON COLUMN "SYS_ACCOUNT"."CREATE_ID" IS '创建人账号';
COMMENT ON COLUMN "SYS_ACCOUNT"."CREATE_NAME" IS '创建人名称';
COMMENT ON COLUMN "SYS_ACCOUNT"."CREATE_TIMES" IS '创建时间';
COMMENT ON COLUMN "SYS_ACCOUNT"."MODIFY_ID" IS '修改人账号';
COMMENT ON COLUMN "SYS_ACCOUNT"."MODIFY_NAME" IS '修改人名称';
COMMENT ON COLUMN "SYS_ACCOUNT"."MODIFY_TIMES" IS '修改时间';

/*==============================================================*/
/* Name:<会话> Table: SYS_SESSION                               */
/*==============================================================*/
create table SYS_SESSION (
  SESSION_ID                      varchar2(36 byte)     visible  not null,
  ACCOUNT_ID                      varchar2(36 byte)     visible  not null,
  LOGIN_KEY                       varchar2(255 byte)    visible  not null,
  CURRENT_TIMES                   number(20)            visible  not null,
  AES_KEY                         varchar2(255 byte)    visible  not null,

  COOKIES_EXPIRE_TIMES_BROWSER    number(20)            visible      null,
  COOKIES_EXPIRE_TIMES_ANDROID    number(20)            visible      null,
  COOKIES_EXPIRE_TIMES_IOS        number(20)            visible      null,
  COOKIES_EXPIRE_TIMES_WECHATAPP  number(20)            visible      null,
  primary key ( SESSION_ID ),
  unique ( ACCOUNT_ID, LOGIN_KEY )
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
COMMENT ON TABLE "SYS_SESSION" IS '会话';
COMMENT ON COLUMN "SYS_SESSION"."SESSION_ID" IS '会话编号';
COMMENT ON COLUMN "SYS_SESSION"."ACCOUNT_ID" IS '账号编号';
COMMENT ON COLUMN "SYS_SESSION"."LOGIN_KEY" IS '登录标识';
COMMENT ON COLUMN "SYS_SESSION"."CURRENT_TIMES" IS '当前时间';
COMMENT ON COLUMN "SYS_SESSION"."AES_KEY" IS 'AES密钥';
COMMENT ON COLUMN "SYS_SESSION"."COOKIES_EXPIRE_TIMES_BROWSER" IS '浏览器会话过期时间';
COMMENT ON COLUMN "SYS_SESSION"."COOKIES_EXPIRE_TIMES_ANDROID" IS '安卓APP会话过期时间';
COMMENT ON COLUMN "SYS_SESSION"."COOKIES_EXPIRE_TIMES_IOS" IS '苹果APP会话过期时间';
COMMENT ON COLUMN "SYS_SESSION"."COOKIES_EXPIRE_TIMES_WECHATAPP" IS '微信小程序会话过期时间';

alter table SYS_SESSION add constraint FK_SYS_SESSION_ACCOUNT_ID foreign key (ACCOUNT_ID) references SYS_ACCOUNT(ACCOUNT_ID);

/*==============================================================*/
/* Name:<登录日志> Table: SYS_LOGIN_LOG                          */
/*==============================================================*/
create table SYS_LOGIN_LOG (
  LOG_ID                          varchar2(36 byte)     visible  not null,
  LOGIN_KEY                       varchar2(255 byte)    visible  not null,
  ACCOUNT_ID                      varchar2(36 byte)     visible  not null,
  ACCOUNT                         varchar2(255 byte)    visible  not null,
  MOBILE_PHONE_NUMBER             varchar2(255 byte)    visible      null,
  LOGIN_TIMES                     number(20)            visible  not null,
  primary key ( LOG_ID )
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
COMMENT ON TABLE "SYS_LOGIN_LOG" IS '登录日志';
COMMENT ON COLUMN "SYS_LOGIN_LOG"."LOG_ID" IS '登录日志编号';
COMMENT ON COLUMN "SYS_LOGIN_LOG"."LOGIN_KEY" IS '登录标识';
COMMENT ON COLUMN "SYS_LOGIN_LOG"."ACCOUNT_ID" IS '账号编号';
COMMENT ON COLUMN "SYS_LOGIN_LOG"."ACCOUNT" IS '账号';
COMMENT ON COLUMN "SYS_LOGIN_LOG"."MOBILE_PHONE_NUMBER" IS '手机号';
COMMENT ON COLUMN "SYS_LOGIN_LOG"."LOGIN_TIMES" IS '登录时间';

/*==============================================================*/
/* Name:<组织机构> Table: SYS_ORG                                */
/*==============================================================*/
create table SYS_ORG (
  ORG_ID                          varchar2(36 byte)     visible  not null,
  ORG_NAME                        varchar2(255 byte)    visible  not null,
  ORG_TYPE                        varchar2(255 byte)    visible      null,
  ID_PATH                         varchar2(4000 byte)   visible      null,
  NAME_PATH                       varchar2(4000 byte)   visible      null,
  WEIGHT_ORDER                    number(11)            visible      null,

  ORG_PID                         varchar2(36 byte)     visible      null,

  VERSIONS                        number(11)            visible  not null,
  CREATE_ID                       varchar2(36 byte)     visible  not null,
  CREATE_NAME                     varchar2(255 byte)    visible  not null,
  CREATE_TIMES                    number(20)            visible  not null,
  MODIFY_ID                       varchar2(36 byte)     visible      null,
  MODIFY_NAME                     varchar2(255 byte)    visible      null,
  MODIFY_TIMES                    number(20)            visible      null,
  primary key ( ORG_ID )
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
COMMENT ON TABLE "SYS_ORG" IS '组织机构';
COMMENT ON COLUMN "SYS_ORG"."ORG_ID" IS '组织机构编号';
COMMENT ON COLUMN "SYS_ORG"."ORG_NAME" IS '组织机构名称';
COMMENT ON COLUMN "SYS_ORG"."ORG_TYPE" IS '组织机构类型';
COMMENT ON COLUMN "SYS_ORG"."ID_PATH" IS '编号路径';
COMMENT ON COLUMN "SYS_ORG"."NAME_PATH" IS '名称路径';
COMMENT ON COLUMN "SYS_ORG"."WEIGHT_ORDER" IS '排序权重';
COMMENT ON COLUMN "SYS_ORG"."ORG_PID" IS '上级组织机构编号';
COMMENT ON COLUMN "SYS_ORG"."VERSIONS" IS '版本号';
COMMENT ON COLUMN "SYS_ORG"."CREATE_ID" IS '创建人账号';
COMMENT ON COLUMN "SYS_ORG"."CREATE_NAME" IS '创建人名称';
COMMENT ON COLUMN "SYS_ORG"."CREATE_TIMES" IS '创建时间';
COMMENT ON COLUMN "SYS_ORG"."MODIFY_ID" IS '修改人账号';
COMMENT ON COLUMN "SYS_ORG"."MODIFY_NAME" IS '修改人名称';
COMMENT ON COLUMN "SYS_ORG"."MODIFY_TIMES" IS '修改时间';

alter table SYS_ORG add constraint FK_SYS_ORG_ORG_PID foreign key (ORG_PID) references SYS_ORG(ORG_ID);

/*==============================================================*/
/* Name:<岗位> Table: SYS_POST                                  */
/*==============================================================*/
create table SYS_POST (
  POST_ID                         varchar2(36 byte)     visible  not null,
  POST_NAME                       varchar2(255 byte)    visible  not null,
  WEIGHT_ORDER                    number(11)            visible      null,

  ORG_ID                          varchar2(36 byte)     visible  not null,

  VERSIONS                        number(11)            visible  not null,
  CREATE_ID                       varchar2(36 byte)     visible  not null,
  CREATE_NAME                     varchar2(255 byte)    visible  not null,
  CREATE_TIMES                    number(20)            visible  not null,
  MODIFY_ID                       varchar2(36 byte)     visible      null,
  MODIFY_NAME                     varchar2(255 byte)    visible      null,
  MODIFY_TIMES                    number(20)            visible      null,
  primary key ( POST_ID ),
  unique ( POST_NAME, ORG_ID )
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
COMMENT ON TABLE "SYS_POST" IS '岗位';
COMMENT ON COLUMN "SYS_POST"."POST_ID" IS '岗位编号';
COMMENT ON COLUMN "SYS_POST"."POST_NAME" IS '岗位名称';
COMMENT ON COLUMN "SYS_POST"."WEIGHT_ORDER" IS '排序权重';
COMMENT ON COLUMN "SYS_POST"."ORG_ID" IS '组织机构编号';
COMMENT ON COLUMN "SYS_POST"."VERSIONS" IS '版本号';
COMMENT ON COLUMN "SYS_POST"."CREATE_ID" IS '创建人账号';
COMMENT ON COLUMN "SYS_POST"."CREATE_NAME" IS '创建人名称';
COMMENT ON COLUMN "SYS_POST"."CREATE_TIMES" IS '创建时间';
COMMENT ON COLUMN "SYS_POST"."MODIFY_ID" IS '修改人账号';
COMMENT ON COLUMN "SYS_POST"."MODIFY_NAME" IS '修改人名称';
COMMENT ON COLUMN "SYS_POST"."MODIFY_TIMES" IS '修改时间';

alter table SYS_POST add constraint FK_SYS_POST_ORG_ID foreign key (ORG_ID) references SYS_ORG(ORG_ID);

/*==============================================================*/
/* Name:<员工> Table: SYS_STAFF                                 */
/*==============================================================*/
create table SYS_STAFF (
  STAFF_ID                        varchar2(36 byte)     visible  not null,
  STAFF_NO                        varchar2(255 byte)    visible  not null,
  STAFF_NAME                      varchar2(255 byte)    visible  not null,
  MOBILE_PHONE_NUMBER             varchar2(255 byte)    visible      null,
  GENDER                          varchar2(255 byte)    visible      null,
  EMERGENCY_CONTACT_NAME          varchar2(255 byte)    visible      null,
  EMERG_CONT_MOBILE_PHONE_NUMBER  varchar2(255 byte)    visible      null,
  WEIGHT_ORDER                    number(11)            visible      null,
  DESCRIPTION                     varchar2(4000 byte)   visible      null,

  VERSIONS                        number(11)            visible  not null,
  CREATE_ID                       varchar2(36 byte)     visible  not null,
  CREATE_NAME                     varchar2(255 byte)    visible  not null,
  CREATE_TIMES                    number(20)            visible  not null,
  MODIFY_ID                       varchar2(36 byte)     visible      null,
  MODIFY_NAME                     varchar2(255 byte)    visible      null,
  MODIFY_TIMES                    number(20)            visible      null,
  primary key ( STAFF_ID ),
  unique ( STAFF_NO )
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
COMMENT ON TABLE "SYS_STAFF" IS '员工';
COMMENT ON COLUMN "SYS_STAFF"."STAFF_ID" IS '员工编号';
COMMENT ON COLUMN "SYS_STAFF"."STAFF_NO" IS '员工工号';
COMMENT ON COLUMN "SYS_STAFF"."STAFF_NAME" IS '员工姓名';
COMMENT ON COLUMN "SYS_STAFF"."MOBILE_PHONE_NUMBER" IS '手机号';
COMMENT ON COLUMN "SYS_STAFF"."GENDER" IS '性别';
COMMENT ON COLUMN "SYS_STAFF"."EMERGENCY_CONTACT_NAME" IS '紧急联系人姓名';
COMMENT ON COLUMN "SYS_STAFF"."EMERG_CONT_MOBILE_PHONE_NUMBER" IS '紧急联系人手机号';
COMMENT ON COLUMN "SYS_STAFF"."WEIGHT_ORDER" IS '排序权重';
COMMENT ON COLUMN "SYS_STAFF"."DESCRIPTION" IS '描述';
COMMENT ON COLUMN "SYS_STAFF"."VERSIONS" IS '版本号';
COMMENT ON COLUMN "SYS_STAFF"."CREATE_ID" IS '创建人账号';
COMMENT ON COLUMN "SYS_STAFF"."CREATE_NAME" IS '创建人名称';
COMMENT ON COLUMN "SYS_STAFF"."CREATE_TIMES" IS '创建时间';
COMMENT ON COLUMN "SYS_STAFF"."MODIFY_ID" IS '修改人账号';
COMMENT ON COLUMN "SYS_STAFF"."MODIFY_NAME" IS '修改人名称';
COMMENT ON COLUMN "SYS_STAFF"."MODIFY_TIMES" IS '修改时间';

/*==============================================================*/
/* Name:<岗位员工> Table: SYS_POST_STAFF_NEXUS                   */
/*==============================================================*/
create table SYS_POST_STAFF_NEXUS (
  NEXUS_ID                        varchar2(36 byte)     visible  not null,
  POST_ID                         varchar2(36 byte)     visible  not null,
  STAFF_ID                        varchar2(36 byte)     visible  not null,
  DEFAULT_POST                    varchar2(255 byte)    visible      null,
  primary key ( NEXUS_ID ),
  unique ( POST_ID, STAFF_ID )
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
COMMENT ON TABLE "SYS_POST_STAFF_NEXUS" IS '岗位员工';
COMMENT ON COLUMN "SYS_POST_STAFF_NEXUS"."NEXUS_ID" IS '关系编号';
COMMENT ON COLUMN "SYS_POST_STAFF_NEXUS"."POST_ID" IS '岗位编号';
COMMENT ON COLUMN "SYS_POST_STAFF_NEXUS"."STAFF_ID" IS '员工编号';
COMMENT ON COLUMN "SYS_POST_STAFF_NEXUS"."DEFAULT_POST" IS '默认岗位';

alter table SYS_POST_STAFF_NEXUS add constraint FK_SYS_POST_STA_NEXUS_POST_ID foreign key (POST_ID) references SYS_POST(POST_ID);
alter table SYS_POST_STAFF_NEXUS add constraint FK_SYS_POST_STA_NEXUS_STAFF_ID foreign key (STAFF_ID) references SYS_STAFF(STAFF_ID);

/*==============================================================*/
/* Name:<角色> Table: SYS_ROLE                                  */
/*==============================================================*/
create table SYS_ROLE (
  ROLE_ID                         varchar2(36 byte)     visible  not null,
  ROLE_NAME                       varchar2(255 byte)    visible  not null,
  ROLE_TYPE                       varchar2(255 byte)    visible      null,
  ACCESS_LIST                     varchar2(4000 byte)   visible      null,
  WEIGHT_ORDER                    number(11)            visible      null,

  VERSIONS                        number(11)            visible  not null,
  CREATE_ID                       varchar2(36 byte)     visible  not null,
  CREATE_NAME                     varchar2(255 byte)    visible  not null,
  CREATE_TIMES                    number(20)            visible  not null,
  MODIFY_ID                       varchar2(36 byte)     visible      null,
  MODIFY_NAME                     varchar2(255 byte)    visible      null,
  MODIFY_TIMES                    number(20)            visible      null,
  primary key ( ROLE_ID ),
  unique ( ROLE_NAME )
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
COMMENT ON TABLE "SYS_ROLE" IS '角色';
COMMENT ON COLUMN "SYS_ROLE"."ROLE_ID" IS '角色编号';
COMMENT ON COLUMN "SYS_ROLE"."ROLE_NAME" IS '角色名称';
COMMENT ON COLUMN "SYS_ROLE"."ROLE_TYPE" IS '角色类型';
COMMENT ON COLUMN "SYS_ROLE"."ACCESS_LIST" IS '权限列表';
COMMENT ON COLUMN "SYS_ROLE"."WEIGHT_ORDER" IS '排序权重';
COMMENT ON COLUMN "SYS_ROLE"."VERSIONS" IS '版本号';
COMMENT ON COLUMN "SYS_ROLE"."CREATE_ID" IS '创建人账号';
COMMENT ON COLUMN "SYS_ROLE"."CREATE_NAME" IS '创建人名称';
COMMENT ON COLUMN "SYS_ROLE"."CREATE_TIMES" IS '创建时间';
COMMENT ON COLUMN "SYS_ROLE"."MODIFY_ID" IS '修改人账号';
COMMENT ON COLUMN "SYS_ROLE"."MODIFY_NAME" IS '修改人名称';
COMMENT ON COLUMN "SYS_ROLE"."MODIFY_TIMES" IS '修改时间';

/*==============================================================*/
/* Name:<角色岗位> Table: SYS_ROLE_POST_NEXUS                    */
/*==============================================================*/
create table SYS_ROLE_POST_NEXUS (
  NEXUS_ID                        varchar2(36 byte)     visible  not null,
  ROLE_ID                         varchar2(36 byte)     visible  not null,
  POST_ID                         varchar2(36 byte)     visible  not null,
  primary key ( NEXUS_ID ),
  unique ( ROLE_ID, POST_ID )
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
COMMENT ON TABLE "SYS_ROLE_POST_NEXUS" IS '角色岗位';
COMMENT ON COLUMN "SYS_ROLE_POST_NEXUS"."NEXUS_ID" IS '关系编号';
COMMENT ON COLUMN "SYS_ROLE_POST_NEXUS"."ROLE_ID" IS '角色编号';
COMMENT ON COLUMN "SYS_ROLE_POST_NEXUS"."POST_ID" IS '岗位编号';

alter table SYS_ROLE_POST_NEXUS add constraint FK_SYS_ROLE_POST_NEXUS_ROLE_ID foreign key (ROLE_ID) references SYS_ROLE(ROLE_ID);
alter table SYS_ROLE_POST_NEXUS add constraint FK_SYS_ROLE_POST_NEXUS_POST_ID foreign key (POST_ID) references SYS_POST(POST_ID);
