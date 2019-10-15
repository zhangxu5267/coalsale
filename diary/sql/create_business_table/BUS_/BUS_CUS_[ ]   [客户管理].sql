﻿DROP TABLE BUS_CUS_TAG_TEMP;
DROP TABLE BUS_CUS_TAG;
DROP TABLE BUS_CUS_AGENT;
DROP TABLE BUS_CUS_ADDR_DIS;
DROP TABLE BUS_CUS_ADDRESS;
DROP TABLE BUS_CUS_BASE_INFO;
DROP TABLE BUS_CUS_BASE;

/*==============================================================*/
/* NAME:<客户基础信息> TABLE: BUS_CUS_BASE                         */
/*==============================================================*/
-- DROP TABLE BUS_CUS_BASE;
CREATE TABLE BUS_CUS_BASE (
  CUS_BASE_ID						VARCHAR2(255 BYTE)		VISIBLE	NOT NULL,
  CUSTOM_NO							VARCHAR2(255 BYTE)		VISIBLE	NOT NULL,
  COMPANY_NAME						VARCHAR2(255 BYTE)		VISIBLE		NULL,
  CREDIT_CODE						VARCHAR2(255 BYTE)		VISIBLE		NULL,
  ADDRESS							VARCHAR2(255 BYTE)		VISIBLE		NULL,
  LEGAL_REP							VARCHAR2(255 BYTE)		VISIBLE		NULL, 
  LEGAL_PHONE						VARCHAR2(255 BYTE)		VISIBLE		NULL, 
  LEGAL_FAX							VARCHAR2(255 BYTE)		VISIBLE		NULL, 
  OPENING_BANK						VARCHAR2(255 BYTE)		VISIBLE		NULL, 
  BANK_ACCOUNT						VARCHAR2(255 BYTE)		VISIBLE		NULL, 
  REG_NUMBER						VARCHAR2(255 BYTE)		VISIBLE		NULL, 
  CON_PHONE							VARCHAR2(255 BYTE)		VISIBLE		NULL, 
  ZIPCODE							VARCHAR2(255 BYTE)		VISIBLE		NULL, 
  REMARK							VARCHAR2(4000 BYTE)		VISIBLE		NULL,
  VERSIONS							NUMBER(11)				VISIBLE	NOT NULL,
  UPLOAD_IDS						VARCHAR2(255 BYTE)		VISIBLE	 	NULL,
  ACT_PROCESS_INSTANCE_ID			VARCHAR2(255 BYTE)		VISIBLE	 	NULL,
  ACT_PROCESS_STATUS				VARCHAR2(255 BYTE)		VISIBLE	 	NULL,
  CREATE_ID							VARCHAR2(255 BYTE)		VISIBLE	NOT NULL,
  CREATE_NAME						VARCHAR2(255 BYTE)		VISIBLE	NOT NULL,
  CREATE_ORG						VARCHAR2(255 BYTE)		VISIBLE		NULL,
  CREATE_TIMES						NUMBER(20)				VISIBLE	NOT NULL,
  MODIFY_ID							VARCHAR2(255 BYTE)		VISIBLE		NULL,
  MODIFY_NAME						VARCHAR2(255 BYTE)		VISIBLE		NULL,
  MODIFY_ORG						VARCHAR2(255 BYTE)		VISIBLE		NULL,
  MODIFY_TIMES						NUMBER(20)				VISIBLE		NULL, 
  DEL_FLAG							VARCHAR2(255 BYTE)		VISIBLE		NULL, 
  PRIMARY KEY ( CUS_BASE_ID ),
  UNIQUE ( CUSTOM_NO )
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
COMMENT ON TABLE "BUS_CUS_BASE" IS '客户基础信息';
COMMENT ON COLUMN "BUS_CUS_BASE"."CUS_BASE_ID" IS 'ID';
COMMENT ON COLUMN "BUS_CUS_BASE"."CUSTOM_NO" IS '客户编码';
COMMENT ON COLUMN "BUS_CUS_BASE"."COMPANY_NAME" IS '单位名称';
COMMENT ON COLUMN "BUS_CUS_BASE"."CREDIT_CODE" IS '社会统一信用代码';
COMMENT ON COLUMN "BUS_CUS_BASE"."ADDRESS" IS '地址';
COMMENT ON COLUMN "BUS_CUS_BASE"."LEGAL_REP" IS '法定代表人';
COMMENT ON COLUMN "BUS_CUS_BASE"."LEGAL_PHONE" IS '法定代表人电话';
COMMENT ON COLUMN "BUS_CUS_BASE"."LEGAL_FAX" IS '法定代表人传真';
COMMENT ON COLUMN "BUS_CUS_BASE"."OPENING_BANK" IS '开户银行';
COMMENT ON COLUMN "BUS_CUS_BASE"."BANK_ACCOUNT" IS '银行账号';
COMMENT ON COLUMN "BUS_CUS_BASE"."REG_NUMBER" IS '纳税登记号';
COMMENT ON COLUMN "BUS_CUS_BASE"."CON_PHONE" IS '联系电话';
COMMENT ON COLUMN "BUS_CUS_BASE"."ZIPCODE" IS '邮政编码';
COMMENT ON COLUMN "BUS_CUS_BASE"."ACT_PROCESS_INSTANCE_ID" IS '流程实例ID';
COMMENT ON COLUMN "BUS_CUS_BASE"."ACT_PROCESS_STATUS" IS '流程状态';
COMMENT ON COLUMN "BUS_CUS_BASE"."UPLOAD_IDS" IS '附件IDs';
COMMENT ON COLUMN "BUS_CUS_BASE"."REMARK" IS '备注';
COMMENT ON COLUMN "BUS_CUS_BASE"."VERSIONS" IS '版本号';
COMMENT ON COLUMN "BUS_CUS_BASE"."CREATE_ID" IS '创建人账号';
COMMENT ON COLUMN "BUS_CUS_BASE"."CREATE_NAME" IS '创建人名称';
COMMENT ON COLUMN "BUS_CUS_BASE"."CREATE_TIMES" IS '创建时间';
COMMENT ON COLUMN "BUS_CUS_BASE"."MODIFY_ID" IS '修改人账号';
COMMENT ON COLUMN "BUS_CUS_BASE"."MODIFY_NAME" IS '修改人名称';
COMMENT ON COLUMN "BUS_CUS_BASE"."MODIFY_TIMES" IS '修改时间';
COMMENT ON COLUMN "BUS_CUS_BASE"."CREATE_ORG" IS '创建机构';
COMMENT ON COLUMN "BUS_CUS_BASE"."MODIFY_ORG" IS '修改机构';
COMMENT ON COLUMN "BUS_CUS_BASE"."DEL_FLAG" IS '逻辑删除0=删除,1=显示';

/*==============================================================*/
/* NAME:<客户详细信息> TABLE: BUS_CUS_BASE_INFO                    */
/*==============================================================*/
-- DROP TABLE BUS_CUS_BASE_INFO;
CREATE TABLE BUS_CUS_BASE_INFO (
  CUS_BASE_INFO_ID					VARCHAR2(255 BYTE)		VISIBLE	NOT NULL,
  CUS_BASE_ID						VARCHAR2(255 BYTE)		VISIBLE	NOT NULL,
  CUS_NO							VARCHAR2(255 BYTE)		VISIBLE	NOT NULL,
  ORG_ID							VARCHAR2(255 BYTE)		VISIBLE		NULL,
  IS_KEY							VARCHAR2(255 BYTE)		VISIBLE		NULL,
  CUS_REGION						VARCHAR2(255 BYTE)		VISIBLE		NULL,
  CUS_PROVINCE						VARCHAR2(255 BYTE)		VISIBLE		NULL,
  CUS_INDUSTRY						VARCHAR2(255 BYTE)		VISIBLE		NULL,
  CUS_COMNATURE						VARCHAR2(255 BYTE)		VISIBLE		NULL,
  CUS_TYPE							VARCHAR2(255 BYTE)		VISIBLE		NULL,
  TRAN_TYPE							VARCHAR2(255 BYTE)		VISIBLE		NULL,
  CUS_PARENT						VARCHAR2(255 BYTE)		VISIBLE		NULL,
  CUS_SUB							VARCHAR2(255 BYTE)		VISIBLE		NULL,
  FAX								VARCHAR2(255 BYTE)		VISIBLE		NULL,
  REMARK							VARCHAR2(4000 BYTE)		VISIBLE		NULL,
  UPLOAD_IDS						VARCHAR2(255 BYTE)		VISIBLE		NULL, 
  ACT_PROCESS_INSTANCE_ID			VARCHAR2(255 BYTE)		VISIBLE		NULL,
  ACT_PROCESS_STATUS				VARCHAR2(255 BYTE)		VISIBLE		NULL,
  VERSIONS							NUMBER(11)				VISIBLE	NOT NULL,
  CREATE_ID							VARCHAR2(255 BYTE)		VISIBLE	NOT NULL,
  CREATE_NAME						VARCHAR2(255 BYTE)		VISIBLE	NOT NULL,
  CREATE_ORG						VARCHAR2(255 BYTE)		VISIBLE		NULL,
  CREATE_TIMES						NUMBER(20)				VISIBLE	NOT NULL,
  MODIFY_ID							VARCHAR2(255 BYTE)		VISIBLE		NULL,
  MODIFY_NAME						VARCHAR2(255 BYTE)		VISIBLE		NULL,
  MODIFY_ORG						VARCHAR2(255 BYTE)		VISIBLE		NULL,
  MODIFY_TIMES						NUMBER(20)				VISIBLE		NULL,
  DEL_FLAG							VARCHAR2(255 BYTE)		VISIBLE		NULL, 
  PRIMARY KEY ( CUS_BASE_INFO_ID )
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
COMMENT ON TABLE "BUS_CUS_BASE_INFO" IS '客户详细信息';
COMMENT ON COLUMN "BUS_CUS_BASE_INFO"."CUS_BASE_INFO_ID" IS 'ID';
COMMENT ON COLUMN "BUS_CUS_BASE_INFO"."CUS_BASE_ID" IS '客户ID';
COMMENT ON COLUMN "BUS_CUS_BASE_INFO"."CUS_NO" IS '客户编码';
COMMENT ON COLUMN "BUS_CUS_BASE_INFO"."ORG_ID" IS '所属机构';
COMMENT ON COLUMN "BUS_CUS_BASE_INFO"."IS_KEY" IS '是否重要';
COMMENT ON COLUMN "BUS_CUS_BASE_INFO"."CUS_REGION" IS '客户所属区域';
COMMENT ON COLUMN "BUS_CUS_BASE_INFO"."CUS_PROVINCE" IS '客户省份';
COMMENT ON COLUMN "BUS_CUS_BASE_INFO"."CUS_INDUSTRY" IS '客户所属行业';
COMMENT ON COLUMN "BUS_CUS_BASE_INFO"."CUS_COMNATURE" IS '客户企业性质';
COMMENT ON COLUMN "BUS_CUS_BASE_INFO"."CUS_TYPE" IS '客户分类';
COMMENT ON COLUMN "BUS_CUS_BASE_INFO"."CUS_PARENT" IS '上级客户';
COMMENT ON COLUMN "BUS_CUS_BASE_INFO"."CUS_SUB" IS '下级客户';
COMMENT ON COLUMN "BUS_CUS_BASE_INFO"."FAX" IS '公司传真';
COMMENT ON COLUMN "BUS_CUS_BASE_INFO"."TRAN_TYPE" IS '交易类型';
COMMENT ON COLUMN "BUS_CUS_BASE_INFO"."ACT_PROCESS_INSTANCE_ID" IS '流程实例ID';
COMMENT ON COLUMN "BUS_CUS_BASE_INFO"."ACT_PROCESS_STATUS" IS '流程状态';
COMMENT ON COLUMN "BUS_CUS_BASE_INFO"."UPLOAD_IDS" IS '附件IDs';
COMMENT ON COLUMN "BUS_CUS_BASE_INFO"."REMARK" IS '备注';
COMMENT ON COLUMN "BUS_CUS_BASE_INFO"."VERSIONS" IS '版本号';
COMMENT ON COLUMN "BUS_CUS_BASE_INFO"."CREATE_ID" IS '创建人账号';
COMMENT ON COLUMN "BUS_CUS_BASE_INFO"."CREATE_NAME" IS '创建人名称';
COMMENT ON COLUMN "BUS_CUS_BASE_INFO"."CREATE_TIMES" IS '创建时间';
COMMENT ON COLUMN "BUS_CUS_BASE_INFO"."MODIFY_ID" IS '修改人账号';
COMMENT ON COLUMN "BUS_CUS_BASE_INFO"."MODIFY_NAME" IS '修改人名称';
COMMENT ON COLUMN "BUS_CUS_BASE_INFO"."MODIFY_TIMES" IS '修改时间';
COMMENT ON COLUMN "BUS_CUS_BASE_INFO"."CREATE_ORG" IS '创建机构';
COMMENT ON COLUMN "BUS_CUS_BASE_INFO"."MODIFY_ORG" IS '修改机构';
COMMENT ON COLUMN "BUS_CUS_BASE_INFO"."DEL_FLAG" IS '逻辑删除0=删除,1=显示';



/*==============================================================*/
/* NAME:<客户收货单位表> TABLE: BUS_CUS_ADDRESS                    */
/*==============================================================*/
-- DROP TABLE BUS_CUS_ADDRESS;
CREATE TABLE BUS_CUS_ADDRESS (
  CUS_ADDRESS_ID					VARCHAR2(255 BYTE)		VISIBLE	NOT NULL,
  CUS_BASE_ID						VARCHAR2(255 BYTE)		VISIBLE	NOT NULL,
  CUS_NO							VARCHAR2(255 BYTE)		VISIBLE		NULL,
  REC_ADDRESS						VARCHAR2(255 BYTE)		VISIBLE		NULL,
  DELINE							VARCHAR2(255 BYTE)		VISIBLE		NULL,
  ARRIVE_STATION_NAME				VARCHAR2(255 BYTE)		VISIBLE		NULL,
  ARRIVE_STATION_NO					VARCHAR2(255 BYTE)		VISIBLE		NULL,
  REMARK							VARCHAR2(4000 BYTE)		VISIBLE		NULL,
  UPLOAD_IDS						VARCHAR2(255 BYTE)		VISIBLE		NULL, 
  ACT_PROCESS_INSTANCE_ID			VARCHAR2(255 BYTE)		VISIBLE		NULL,
  ACT_PROCESS_STATUS				VARCHAR2(255 BYTE)		VISIBLE		NULL,
  VERSIONS							NUMBER(11)				VISIBLE	NOT NULL,
  CREATE_ID							VARCHAR2(255 BYTE)		VISIBLE	NOT NULL,
  CREATE_NAME						VARCHAR2(255 BYTE)		VISIBLE	NOT NULL,
  CREATE_ORG						VARCHAR2(255 BYTE)		VISIBLE		NULL,
  CREATE_TIMES						NUMBER(20)				VISIBLE	NOT NULL,
  MODIFY_ID							VARCHAR2(255 BYTE)		VISIBLE		NULL,
  MODIFY_NAME						VARCHAR2(255 BYTE)		VISIBLE		NULL,
  MODIFY_ORG						VARCHAR2(255 BYTE)		VISIBLE		NULL,
  MODIFY_TIMES						NUMBER(20)				VISIBLE		NULL,
  DEL_FLAG							VARCHAR2(255 BYTE)		VISIBLE		NULL, 
  PRIMARY KEY ( CUS_ADDRESS_ID )
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
COMMENT ON TABLE "BUS_CUS_ADDRESS" IS '客户收货单位';
COMMENT ON COLUMN "BUS_CUS_ADDRESS"."CUS_ADDRESS_ID" IS 'ID';
COMMENT ON COLUMN "BUS_CUS_ADDRESS"."CUS_BASE_ID" IS '客户ID';
COMMENT ON COLUMN "BUS_CUS_ADDRESS"."CUS_NO" IS '客户编码';
COMMENT ON COLUMN "BUS_CUS_ADDRESS"."REC_ADDRESS" IS '收货地址';
COMMENT ON COLUMN "BUS_CUS_ADDRESS"."DELINE" IS '专线';
COMMENT ON COLUMN "BUS_CUS_ADDRESS"."ARRIVE_STATION_NAME" IS '到站名称';
COMMENT ON COLUMN "BUS_CUS_ADDRESS"."ARRIVE_STATION_NO" IS '到站编码';
COMMENT ON COLUMN "BUS_CUS_ADDRESS"."REMARK" IS '备注';
COMMENT ON COLUMN "BUS_CUS_ADDRESS"."UPLOAD_IDS" IS '附件IDs';
COMMENT ON COLUMN "BUS_CUS_ADDRESS"."ACT_PROCESS_INSTANCE_ID" IS '流程实例ID';
COMMENT ON COLUMN "BUS_CUS_ADDRESS"."ACT_PROCESS_STATUS" IS '流程状态';
COMMENT ON COLUMN "BUS_CUS_ADDRESS"."VERSIONS" IS '版本号';
COMMENT ON COLUMN "BUS_CUS_ADDRESS"."CREATE_ID" IS '创建人账号';
COMMENT ON COLUMN "BUS_CUS_ADDRESS"."CREATE_NAME" IS '创建人名称';
COMMENT ON COLUMN "BUS_CUS_ADDRESS"."CREATE_TIMES" IS '创建时间';
COMMENT ON COLUMN "BUS_CUS_ADDRESS"."MODIFY_ID" IS '修改人账号';
COMMENT ON COLUMN "BUS_CUS_ADDRESS"."MODIFY_NAME" IS '修改人名称';
COMMENT ON COLUMN "BUS_CUS_ADDRESS"."MODIFY_TIMES" IS '修改时间';
COMMENT ON COLUMN "BUS_CUS_ADDRESS"."CREATE_ORG" IS '创建机构';
COMMENT ON COLUMN "BUS_CUS_ADDRESS"."MODIFY_ORG" IS '修改机构';
COMMENT ON COLUMN "BUS_CUS_ADDRESS"."DEL_FLAG" IS '逻辑删除0=删除,1=显示';



/*==============================================================*/
/* NAME:<客户收货地址表> TABLE: BUS_CUS_ADDR_DIS                    */
/*==============================================================*/
-- DROP TABLE BUS_CUS_ADDR_DIS;
CREATE TABLE BUS_CUS_ADDR_DIS (
  CUS_ADDR_DIS_ID					VARCHAR2(255 BYTE)		VISIBLE	NOT NULL,
  CUS_BASE_ID						VARCHAR2(255 BYTE)		VISIBLE		NULL,
  REC_ADDRESS						VARCHAR2(255 BYTE)		VISIBLE		NULL,
  REMARK							VARCHAR2(4000 BYTE)		VISIBLE		NULL,
  UPLOAD_IDS						VARCHAR2(255 BYTE)		VISIBLE		NULL, 
  ACT_PROCESS_INSTANCE_ID			VARCHAR2(255 BYTE)		VISIBLE		NULL,
  ACT_PROCESS_STATUS				VARCHAR2(255 BYTE)		VISIBLE		NULL,
  VERSIONS							NUMBER(11)				VISIBLE	NOT NULL,
  CREATE_ID							VARCHAR2(255 BYTE)		VISIBLE	NOT NULL,
  CREATE_NAME						VARCHAR2(255 BYTE)		VISIBLE	NOT NULL,
  CREATE_ORG						VARCHAR2(255 BYTE)		VISIBLE		NULL,
  CREATE_TIMES						NUMBER(20)				VISIBLE	NOT NULL,
  MODIFY_ID							VARCHAR2(255 BYTE)		VISIBLE		NULL,
  MODIFY_NAME						VARCHAR2(255 BYTE)		VISIBLE		NULL,
  MODIFY_ORG						VARCHAR2(255 BYTE)		VISIBLE		NULL,
  MODIFY_TIMES						NUMBER(20)				VISIBLE		NULL,
  DEL_FLAG							VARCHAR2(255 BYTE)		VISIBLE		NULL, 
  PRIMARY KEY ( CUS_ADDR_DIS_ID )
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
COMMENT ON TABLE "BUS_CUS_ADDR_DIS" IS '客户收货地址表';
COMMENT ON COLUMN "BUS_CUS_ADDR_DIS"."CUS_ADDR_DIS_ID" IS 'ID';
COMMENT ON COLUMN "BUS_CUS_ADDR_DIS"."CUS_BASE_ID" IS '客户ID';
COMMENT ON COLUMN "BUS_CUS_ADDR_DIS"."REC_ADDRESS" IS '所属机构';
COMMENT ON COLUMN "BUS_CUS_ADDR_DIS"."REMARK" IS '备注';
COMMENT ON COLUMN "BUS_CUS_ADDR_DIS"."UPLOAD_IDS" IS '附件IDs';
COMMENT ON COLUMN "BUS_CUS_ADDR_DIS"."ACT_PROCESS_INSTANCE_ID" IS '流程实例ID';
COMMENT ON COLUMN "BUS_CUS_ADDR_DIS"."ACT_PROCESS_STATUS" IS '流程状态';
COMMENT ON COLUMN "BUS_CUS_ADDR_DIS"."VERSIONS" IS '版本号';
COMMENT ON COLUMN "BUS_CUS_ADDR_DIS"."CREATE_ID" IS '创建人账号';
COMMENT ON COLUMN "BUS_CUS_ADDR_DIS"."CREATE_NAME" IS '创建人名称';
COMMENT ON COLUMN "BUS_CUS_ADDR_DIS"."CREATE_TIMES" IS '创建时间';
COMMENT ON COLUMN "BUS_CUS_ADDR_DIS"."MODIFY_ID" IS '修改人账号';
COMMENT ON COLUMN "BUS_CUS_ADDR_DIS"."MODIFY_NAME" IS '修改人名称';
COMMENT ON COLUMN "BUS_CUS_ADDR_DIS"."MODIFY_TIMES" IS '修改时间';
COMMENT ON COLUMN "BUS_CUS_ADDR_DIS"."CREATE_ORG" IS '创建机构';
COMMENT ON COLUMN "BUS_CUS_ADDR_DIS"."MODIFY_ORG" IS '修改机构';
COMMENT ON COLUMN "BUS_CUS_ADDR_DIS"."DEL_FLAG" IS '逻辑删除0=删除,1=显示';


/*==============================================================*/
/* NAME:<客户委托信息> TABLE: BUS_CUS_AGENT                    */
/*==============================================================*/
-- DROP TABLE BUS_CUS_AGENT;
CREATE TABLE BUS_CUS_AGENT (
  CUS_AGENT_ID						VARCHAR2(255 BYTE)		VISIBLE	NOT NULL,
  CUS_BASE_ID						VARCHAR2(255 BYTE)		VISIBLE		NULL,
  AE_PER							VARCHAR2(255 BYTE)		VISIBLE		NULL,
  AE_PHONE							VARCHAR2(255 BYTE)		VISIBLE		NULL,
  AE_FAX							VARCHAR2(255 BYTE)		VISIBLE		NULL,
  AE_MATTER							VARCHAR2(255 BYTE)		VISIBLE		NULL,
  AE_DATE							VARCHAR2(255 BYTE)		VISIBLE		NULL,
  ORG_ID							VARCHAR2(255 BYTE)		VISIBLE		NULL,
  AE_EDATE							VARCHAR2(255 BYTE)		VISIBLE		NULL,
  UPLOAD_IDS						VARCHAR2(255 BYTE)		VISIBLE		NULL, 
  REMARK							VARCHAR2(4000 BYTE)		VISIBLE		NULL,
  ACT_PROCESS_INSTANCE_ID			VARCHAR2(255 BYTE)		VISIBLE		NULL,
  ACT_PROCESS_STATUS				VARCHAR2(255 BYTE)		VISIBLE		NULL,
  VERSIONS							NUMBER(11)				VISIBLE	NOT NULL,
  CREATE_ID							VARCHAR2(255 BYTE)		VISIBLE	NOT NULL,
  CREATE_NAME						VARCHAR2(255 BYTE)		VISIBLE	NOT NULL,
  CREATE_ORG						VARCHAR2(255 BYTE)		VISIBLE		NULL,
  CREATE_TIMES						NUMBER(20)				VISIBLE	NOT NULL,
  MODIFY_ID							VARCHAR2(255 BYTE)		VISIBLE		NULL,
  MODIFY_NAME						VARCHAR2(255 BYTE)		VISIBLE		NULL,
  MODIFY_ORG						VARCHAR2(255 BYTE)		VISIBLE		NULL,
  MODIFY_TIMES						NUMBER(20)				VISIBLE		NULL,
  DEL_FLAG							VARCHAR2(255 BYTE)		VISIBLE		NULL, 
  PRIMARY KEY ( CUS_AGENT_ID )
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
COMMENT ON TABLE "BUS_CUS_AGENT" IS '客户委托信息';
COMMENT ON COLUMN "BUS_CUS_AGENT"."CUS_AGENT_ID" IS 'ID';
COMMENT ON COLUMN "BUS_CUS_AGENT"."CUS_BASE_ID" IS '客户ID';
COMMENT ON COLUMN "BUS_CUS_AGENT"."AE_PER" IS '委托代理人';
COMMENT ON COLUMN "BUS_CUS_AGENT"."AE_PHONE" IS '委托代理人电话';
COMMENT ON COLUMN "BUS_CUS_AGENT"."AE_FAX" IS '委托代理人传真';
COMMENT ON COLUMN "BUS_CUS_AGENT"."AE_MATTER" IS '委托事项';
COMMENT ON COLUMN "BUS_CUS_AGENT"."AE_DATE" IS '委托时间';
COMMENT ON COLUMN "BUS_CUS_AGENT"."ORG_ID" IS '机构ID';
COMMENT ON COLUMN "BUS_CUS_AGENT"."AE_EDATE" IS '委托结束时间';
COMMENT ON COLUMN "BUS_CUS_AGENT"."REMARK" IS '备注';
COMMENT ON COLUMN "BUS_CUS_AGENT"."UPLOAD_IDS" IS '附件IDs';
COMMENT ON COLUMN "BUS_CUS_AGENT"."ACT_PROCESS_INSTANCE_ID" IS '流程实例ID';
COMMENT ON COLUMN "BUS_CUS_AGENT"."ACT_PROCESS_STATUS" IS '流程状态';
COMMENT ON COLUMN "BUS_CUS_AGENT"."VERSIONS" IS '版本号';
COMMENT ON COLUMN "BUS_CUS_AGENT"."CREATE_ID" IS '创建人账号';
COMMENT ON COLUMN "BUS_CUS_AGENT"."CREATE_NAME" IS '创建人名称';
COMMENT ON COLUMN "BUS_CUS_AGENT"."CREATE_TIMES" IS '创建时间';
COMMENT ON COLUMN "BUS_CUS_AGENT"."MODIFY_ID" IS '修改人账号';
COMMENT ON COLUMN "BUS_CUS_AGENT"."MODIFY_NAME" IS '修改人名称';
COMMENT ON COLUMN "BUS_CUS_AGENT"."MODIFY_TIMES" IS '修改时间';
COMMENT ON COLUMN "BUS_CUS_AGENT"."CREATE_ORG" IS '创建机构';
COMMENT ON COLUMN "BUS_CUS_AGENT"."MODIFY_ORG" IS '修改机构';
COMMENT ON COLUMN "BUS_CUS_AGENT"."DEL_FLAG" IS '逻辑删除0=删除,1=显示';


/*==============================================================*/
/* NAME:<客户标签表> TABLE: BUS_CUS_TAG                    */
/*==============================================================*/
-- DROP TABLE BUS_CUS_TAG;
CREATE TABLE BUS_CUS_TAG (
  CUS_TAG_ID						VARCHAR2(255 BYTE)		VISIBLE	NOT NULL,
  TAG_NO							VARCHAR2(255 BYTE)		VISIBLE		NULL,
  TAG_NAME							VARCHAR2(255 BYTE)		VISIBLE		NULL,
  TAG_STATE							VARCHAR2(255 BYTE)		VISIBLE		NULL,
  REMARK							VARCHAR2(4000 BYTE)		VISIBLE		NULL,
  UPLOAD_IDS						VARCHAR2(255 BYTE)		VISIBLE		NULL, 
  ACT_PROCESS_INSTANCE_ID			VARCHAR2(255 BYTE)		VISIBLE		NULL,
  ACT_PROCESS_STATUS				VARCHAR2(255 BYTE)		VISIBLE		NULL,
  VERSIONS							NUMBER(11)				VISIBLE	NOT NULL,
  CREATE_ID							VARCHAR2(255 BYTE)		VISIBLE	NOT NULL,
  CREATE_NAME						VARCHAR2(255 BYTE)		VISIBLE	NOT NULL,
  CREATE_ORG						VARCHAR2(255 BYTE)		VISIBLE		NULL,
  CREATE_TIMES						NUMBER(20)				VISIBLE	NOT NULL,
  MODIFY_ID							VARCHAR2(255 BYTE)		VISIBLE		NULL,
  MODIFY_NAME						VARCHAR2(255 BYTE)		VISIBLE		NULL,
  MODIFY_ORG						VARCHAR2(255 BYTE)		VISIBLE		NULL,
  MODIFY_TIMES						NUMBER(20)				VISIBLE		NULL,
  DEL_FLAG							VARCHAR2(255 BYTE)		VISIBLE		NULL, 
  PRIMARY KEY ( CUS_TAG_ID )
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
COMMENT ON TABLE "BUS_CUS_TAG" IS '客户标签表';
COMMENT ON COLUMN "BUS_CUS_TAG"."CUS_TAG_ID" IS 'ID';
COMMENT ON COLUMN "BUS_CUS_TAG"."TAG_NO" IS '标签编号';
COMMENT ON COLUMN "BUS_CUS_TAG"."TAG_NAME" IS '标签名称';
COMMENT ON COLUMN "BUS_CUS_TAG"."TAG_STATE" IS '标签状态';
COMMENT ON COLUMN "BUS_CUS_TAG"."REMARK" IS '备注';
COMMENT ON COLUMN "BUS_CUS_TAG"."UPLOAD_IDS" IS '附件IDs';
COMMENT ON COLUMN "BUS_CUS_TAG"."ACT_PROCESS_INSTANCE_ID" IS '流程实例ID';
COMMENT ON COLUMN "BUS_CUS_TAG"."ACT_PROCESS_STATUS" IS '流程状态';
COMMENT ON COLUMN "BUS_CUS_TAG"."VERSIONS" IS '版本号';
COMMENT ON COLUMN "BUS_CUS_TAG"."CREATE_ID" IS '创建人账号';
COMMENT ON COLUMN "BUS_CUS_TAG"."CREATE_NAME" IS '创建人名称';
COMMENT ON COLUMN "BUS_CUS_TAG"."CREATE_TIMES" IS '创建时间';
COMMENT ON COLUMN "BUS_CUS_TAG"."MODIFY_ID" IS '修改人账号';
COMMENT ON COLUMN "BUS_CUS_TAG"."MODIFY_NAME" IS '修改人名称';
COMMENT ON COLUMN "BUS_CUS_TAG"."MODIFY_TIMES" IS '修改时间';
COMMENT ON COLUMN "BUS_CUS_TAG"."CREATE_ORG" IS '创建机构';
COMMENT ON COLUMN "BUS_CUS_TAG"."MODIFY_ORG" IS '修改机构';
COMMENT ON COLUMN "BUS_CUS_TAG"."DEL_FLAG" IS '逻辑删除0=删除,1=显示';



/*==============================================================*/
/* NAME:<客户标签中间表> TABLE: BUS_USER_TAG                    */
/*==============================================================*/
-- DROP TABLE BUS_CUS_TAG_TEMP;
CREATE TABLE BUS_CUS_TAG_TEMP (
  CUS_TAG_TEMP_ID					VARCHAR2(255 BYTE)		VISIBLE	NOT NULL,
  CUS_TAG_ID						VARCHAR2(255 BYTE)		VISIBLE 	NULL,
  CUS_BASE_ID						VARCHAR2(255 BYTE)		VISIBLE		NULL, 
  PRIMARY KEY ( CUS_TAG_TEMP_ID )
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
COMMENT ON TABLE "BUS_CUS_TAG_TEMP" IS '客户标签中间表';
COMMENT ON COLUMN "BUS_CUS_TAG_TEMP"."CUS_TAG_TEMP_ID" IS 'ID';
COMMENT ON COLUMN "BUS_CUS_TAG_TEMP"."CUS_TAG_ID" IS '客户ID';
COMMENT ON COLUMN "BUS_CUS_TAG_TEMP"."CUS_BASE_ID" IS '标签ID';

/*==============================================================*/
/* 主外键关联                                                                                                                                     */
/*==============================================================*/
-- 收货单位和客户表
ALTER TABLE BUS_CUS_ADDRESS ADD CONSTRAINT FK_BUS_CUS_ADDRESS_TO_BUS_CUS_BASE FOREIGN KEY (CUS_BASE_ID) REFERENCES BUS_CUS_BASE(CUS_BASE_ID);
-- 收货地址和客户表
ALTER TABLE BUS_CUS_ADDR_DIS ADD CONSTRAINT FK_BUS_CUS_ADDR_DIS_TO_BUS_CUS_BASE FOREIGN KEY (CUS_BASE_ID) REFERENCES BUS_CUS_BASE(CUS_BASE_ID);
-- 委托信息和客户表
ALTER TABLE BUS_CUS_AGENT ADD CONSTRAINT FK_BUS_CUS_AGENT_TO_BUS_CUS_BASE FOREIGN KEY (CUS_BASE_ID) REFERENCES BUS_CUS_BASE(CUS_BASE_ID);
-- 客户详情和客户表
ALTER TABLE BUS_CUS_BASE_INFO ADD CONSTRAINT FK_BUS_CUS_BASE_INFO_TO_BUS_CUS_BASE FOREIGN KEY (CUS_BASE_ID) REFERENCES BUS_CUS_BASE(CUS_BASE_ID);
-- 客户标签中间表、客户表、客户标签表
ALTER TABLE BUS_CUS_TAG_TEMP ADD CONSTRAINT FK_BUS_CUS_TAG_TEMP_TO_BUS_CUS_BASE FOREIGN KEY (CUS_BASE_ID) REFERENCES BUS_CUS_BASE(CUS_BASE_ID);
ALTER TABLE BUS_CUS_TAG_TEMP ADD CONSTRAINT FK_BUS_CUS_TAG_TEMP_TO_BUS_CUS_TAG FOREIGN KEY (CUS_TAG_ID) REFERENCES BUS_CUS_TAG(CUS_TAG_ID);




