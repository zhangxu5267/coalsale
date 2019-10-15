drop table PRO_VIRTUAL_COLUMNS;
drop table PRO_QUERY;
drop table PRO_SORT;
drop table PRO_PK;
drop table PRO_COLUMNS;
drop table PRO_DT;

/*==============================================================*/
/* Name:<数据库表> Table: PRO_DT                                 */
/*==============================================================*/
drop table PRO_DT;
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
drop table PRO_COLUMNS;
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
drop table PRO_PK;
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
drop table PRO_SORT;
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
drop table PRO_QUERY;
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
drop table PRO_VIRTUAL_COLUMNS;
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
