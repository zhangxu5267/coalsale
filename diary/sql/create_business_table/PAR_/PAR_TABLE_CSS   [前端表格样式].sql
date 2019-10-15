DROP TABLE "PAR_TABLE_CSS";

CREATE TABLE "PAR_TABLE_CSS" ( 
"ID" 							    VARCHAR2(255)	NOT NULL ,
"CREATE_ID" 					VARCHAR2(255) 	NOT	NULL,
"TABLE_KEY" 					VARCHAR2(255) 	NOT	NULL,
"CONTEXT" 						VARCHAR2(4000) 	NOT	NULL,
PRIMARY KEY ("ID") ) ;

COMMENT ON COLUMN "PAR_TABLE_CSS"."ID" IS 'ID';

COMMENT ON COLUMN "PAR_TABLE_CSS"."CREATE_ID" IS '创建账号';

COMMENT ON COLUMN "PAR_TABLE_CSS"."TABLE_KEY" IS '表格标识';

COMMENT ON COLUMN "PAR_TABLE_CSS"."CONTEXT" IS 'json样式';

COMMENT ON TABLE "PAR_TABLE_CSS" IS '页面表格样式';