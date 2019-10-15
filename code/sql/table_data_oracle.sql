/*表结构数据*/
/*数据字典*/
INSERT INTO "PRO_DT" VALUES ('180e1ea1-7c27-467f-86ff-450ed33cd493', 'SYS_DICT', 'SYS_DICT', '数据字典', 'SYS_', 'Dict', 'dict', '/Users/moonnow/wode/cs/1', 'dict');
INSERT INTO "PRO_DT" VALUES ('46608dc8-953d-403e-b05a-f282626f666b', 'SYS_DICT_VALUE', 'SYS_DICT_VALUE', '数据字典值', 'SYS_', 'DictValue', 'dictValue', '/Users/moonnow/wode/cs/1', 'dict');

INSERT INTO "PRO_COLUMNS" VALUES ('e9c34cfe-33f3-4fd8-baa3-03fc98c74ab1', 'DICT_ID', '数据字典编号', 'VARCHAR2', 'n', 'DictId', 'dictId', '1', '180e1ea1-7c27-467f-86ff-450ed33cd493');
INSERT INTO "PRO_COLUMNS" VALUES ('3eb42fae-f225-427b-8b0e-c5e0cdd012b5', 'DICT_KEY', '数据字典标识', 'VARCHAR2', 'n', 'DictKey', 'dictKey', '2', '180e1ea1-7c27-467f-86ff-450ed33cd493');
INSERT INTO "PRO_COLUMNS" VALUES ('80f09a9a-c577-451c-86b9-a1e12fc1ef6a', 'DICT_NAME', '数据字典名称', 'VARCHAR2', 'y', 'DictName', 'dictName', '3', '180e1ea1-7c27-467f-86ff-450ed33cd493');
INSERT INTO "PRO_COLUMNS" VALUES ('e12b252f-e4a5-4b58-b21a-4e0a2c7fa7d9', 'NOTES', '说明', 'VARCHAR2', 'y', 'Notes', 'notes', '4', '180e1ea1-7c27-467f-86ff-450ed33cd493');
INSERT INTO "PRO_COLUMNS" VALUES ('e0ae2ba1-a3e3-4171-bc6c-a1ef36de52b4', 'WEIGHT_ORDER', '排序权重', 'NUMBER11', 'y', 'WeightOrder', 'weightOrder', '5', '180e1ea1-7c27-467f-86ff-450ed33cd493');
INSERT INTO "PRO_COLUMNS" VALUES ('11b6158c-f49d-4494-a807-ec400b172904', 'VERSIONS', '版本号', 'NUMBER11', 'n', 'Versions', 'versions', '6', '180e1ea1-7c27-467f-86ff-450ed33cd493');
INSERT INTO "PRO_COLUMNS" VALUES ('fe620f5d-fee1-47f5-aa8d-e5b5f8a4152e', 'CREATE_ID', '创建人账号', 'VARCHAR2', 'n', 'CreateId', 'createId', '7', '180e1ea1-7c27-467f-86ff-450ed33cd493');
INSERT INTO "PRO_COLUMNS" VALUES ('11715167-dfdd-4681-b56e-0e5e682a2147', 'CREATE_NAME', '创建人名称', 'VARCHAR2', 'n', 'CreateName', 'createName', '8', '180e1ea1-7c27-467f-86ff-450ed33cd493');
INSERT INTO "PRO_COLUMNS" VALUES ('d7ac95f3-4d30-47a5-b088-c976015e7d31', 'CREATE_TIMES', '创建时间', 'NUMBER20', 'n', 'CreateTimes', 'createTimes', '9', '180e1ea1-7c27-467f-86ff-450ed33cd493');
INSERT INTO "PRO_COLUMNS" VALUES ('cf1fbb77-2121-49c8-a1d2-342c8919af9d', 'MODIFY_ID', '修改人账号', 'VARCHAR2', 'y', 'ModifyId', 'modifyId', '10', '180e1ea1-7c27-467f-86ff-450ed33cd493');
INSERT INTO "PRO_COLUMNS" VALUES ('a99440ee-2cbd-41d0-b2f8-c0643d30fd89', 'MODIFY_NAME', '修改人名称', 'VARCHAR2', 'y', 'ModifyName', 'modifyName', '11', '180e1ea1-7c27-467f-86ff-450ed33cd493');
INSERT INTO "PRO_COLUMNS" VALUES ('6507b873-03a1-43c0-8c4d-1a31ac2d9c07', 'MODIFY_TIMES', '修改时间', 'NUMBER20', 'y', 'ModifyTimes', 'modifyTimes', '12', '180e1ea1-7c27-467f-86ff-450ed33cd493');
INSERT INTO "PRO_COLUMNS" VALUES ('4975f649-1202-42cc-b87a-8428a75e085c', 'DICT_VALUE_ID', '数据字典值编号', 'VARCHAR2', 'n', 'DictValueId', 'dictValueId', '1', '46608dc8-953d-403e-b05a-f282626f666b');
INSERT INTO "PRO_COLUMNS" VALUES ('18341cd2-5127-43df-a194-08e71edb0c9a', 'CODE', '代码', 'VARCHAR2', 'n', 'Code', 'code', '2', '46608dc8-953d-403e-b05a-f282626f666b');
INSERT INTO "PRO_COLUMNS" VALUES ('f5739a82-9b09-4f28-92e5-b5eb1c34c7b0', 'DISPLAY_NAME', '显示名称', 'VARCHAR2', 'n', 'DisplayName', 'displayName', '3', '46608dc8-953d-403e-b05a-f282626f666b');
INSERT INTO "PRO_COLUMNS" VALUES ('6c92e1ea-44dc-4fda-bc43-e92d4ee4ffa5', 'WEIGHT_ORDER', '排序权重', 'NUMBER11', 'y', 'WeightOrder', 'weightOrder', '4', '46608dc8-953d-403e-b05a-f282626f666b');
INSERT INTO "PRO_COLUMNS" VALUES ('46b6b39f-fc93-4770-8a13-0efcccf09da5', 'DESCRIPTION', '描述', 'VARCHAR2', 'y', 'Description', 'description', '5', '46608dc8-953d-403e-b05a-f282626f666b');
INSERT INTO "PRO_COLUMNS" VALUES ('35f50e9b-cc67-4d5e-af54-625c70d20762', 'DICT_ID', '数据字典编号', 'VARCHAR2', 'n', 'DictId', 'dictId', '6', '46608dc8-953d-403e-b05a-f282626f666b');
INSERT INTO "PRO_COLUMNS" VALUES ('fa7214ef-b9cc-4a9d-9269-7a9fc076878e', 'VERSIONS', '版本号', 'NUMBER11', 'n', 'Versions', 'versions', '7', '46608dc8-953d-403e-b05a-f282626f666b');
INSERT INTO "PRO_COLUMNS" VALUES ('60b7d916-2b6e-4c19-ba53-1c58c8164fd9', 'CREATE_ID', '创建人账号', 'VARCHAR2', 'n', 'CreateId', 'createId', '8', '46608dc8-953d-403e-b05a-f282626f666b');
INSERT INTO "PRO_COLUMNS" VALUES ('641f5a98-2c4f-4be0-9ec2-2a73b836025c', 'CREATE_NAME', '创建人名称', 'VARCHAR2', 'n', 'CreateName', 'createName', '9', '46608dc8-953d-403e-b05a-f282626f666b');
INSERT INTO "PRO_COLUMNS" VALUES ('0675d471-dfab-4e51-a21b-3b3e8c786566', 'CREATE_TIMES', '创建时间', 'NUMBER20', 'n', 'CreateTimes', 'createTimes', '10', '46608dc8-953d-403e-b05a-f282626f666b');
INSERT INTO "PRO_COLUMNS" VALUES ('102b00b2-f991-4fc5-a680-88e6774947be', 'MODIFY_ID', '修改人账号', 'VARCHAR2', 'y', 'ModifyId', 'modifyId', '11', '46608dc8-953d-403e-b05a-f282626f666b');
INSERT INTO "PRO_COLUMNS" VALUES ('37095aa6-ed67-4157-bf6a-5c75e0cba3f8', 'MODIFY_NAME', '修改人名称', 'VARCHAR2', 'y', 'ModifyName', 'modifyName', '12', '46608dc8-953d-403e-b05a-f282626f666b');
INSERT INTO "PRO_COLUMNS" VALUES ('1c24774d-5c64-4f09-84fb-3f52f692b72a', 'MODIFY_TIMES', '修改时间', 'NUMBER20', 'y', 'ModifyTimes', 'modifyTimes', '13', '46608dc8-953d-403e-b05a-f282626f666b');

INSERT INTO "PRO_PK" VALUES ('11242ed9-c21f-4209-91ba-e83b6ee3896b', '180e1ea1-7c27-467f-86ff-450ed33cd493', 'e9c34cfe-33f3-4fd8-baa3-03fc98c74ab1');
INSERT INTO "PRO_PK" VALUES ('b57db4fe-5b48-4704-ab51-30e0486e63f5', '46608dc8-953d-403e-b05a-f282626f666b', '4975f649-1202-42cc-b87a-8428a75e085c');

INSERT INTO "PRO_QUERY" VALUES ('83408bf6-5107-48d3-bfcf-05d738f7a530', 'Andin', '180e1ea1-7c27-467f-86ff-450ed33cd493', 'e9c34cfe-33f3-4fd8-baa3-03fc98c74ab1', '1');
INSERT INTO "PRO_QUERY" VALUES ('6ed6f598-24ec-4fc4-9b57-f60fdb7b8c54', 'Andeq', '180e1ea1-7c27-467f-86ff-450ed33cd493', '3eb42fae-f225-427b-8b0e-c5e0cdd012b5', '2');
INSERT INTO "PRO_QUERY" VALUES ('9481428f-e77a-4877-9778-5c690574e4a6', 'AndKeyLike', '180e1ea1-7c27-467f-86ff-450ed33cd493', '3eb42fae-f225-427b-8b0e-c5e0cdd012b5', '3');
INSERT INTO "PRO_QUERY" VALUES ('a126b971-fabf-4e95-bfe1-3551bfb8eec2', 'OrKeyLike', '180e1ea1-7c27-467f-86ff-450ed33cd493', '80f09a9a-c577-451c-86b9-a1e12fc1ef6a', '4');
INSERT INTO "PRO_QUERY" VALUES ('4c020bcb-17fe-47fb-bb82-2419277e6462', 'OrKeyLike', '180e1ea1-7c27-467f-86ff-450ed33cd493', 'e12b252f-e4a5-4b58-b21a-4e0a2c7fa7d9', '5');
INSERT INTO "PRO_QUERY" VALUES ('63b4c614-899a-4327-91b5-080a93059434', 'OrKeyLike', '180e1ea1-7c27-467f-86ff-450ed33cd493', 'fe620f5d-fee1-47f5-aa8d-e5b5f8a4152e', '6');
INSERT INTO "PRO_QUERY" VALUES ('5915dfaa-6406-4cc3-b1bf-2334fca66725', 'OrKeyLike', '180e1ea1-7c27-467f-86ff-450ed33cd493', '11715167-dfdd-4681-b56e-0e5e682a2147', '7');
INSERT INTO "PRO_QUERY" VALUES ('23323547-f04a-4390-a963-01c56510fccd', 'OrKeyLike', '180e1ea1-7c27-467f-86ff-450ed33cd493', 'cf1fbb77-2121-49c8-a1d2-342c8919af9d', '8');
INSERT INTO "PRO_QUERY" VALUES ('f4ebb06e-9fdd-41fb-9c76-47b3c8865185', 'OrKeyLike', '180e1ea1-7c27-467f-86ff-450ed33cd493', 'a99440ee-2cbd-41d0-b2f8-c0643d30fd89', '9');
INSERT INTO "PRO_QUERY" VALUES ('d207833c-a940-448b-bee2-f5a742c301f2', 'Andin', '46608dc8-953d-403e-b05a-f282626f666b', '4975f649-1202-42cc-b87a-8428a75e085c', '1');
INSERT INTO "PRO_QUERY" VALUES ('b5a4bafe-bc69-4566-b3bc-86458fb0203b', 'Andeq', '46608dc8-953d-403e-b05a-f282626f666b', '18341cd2-5127-43df-a194-08e71edb0c9a', '2');
INSERT INTO "PRO_QUERY" VALUES ('34cde160-7166-417d-b47f-ff56c57f9bfc', 'Andeq', '46608dc8-953d-403e-b05a-f282626f666b', '35f50e9b-cc67-4d5e-af54-625c70d20762', '3');
INSERT INTO "PRO_QUERY" VALUES ('bb396386-bbf8-4f2b-8346-3ed6f4c42109', 'AndKeyLike', '46608dc8-953d-403e-b05a-f282626f666b', '18341cd2-5127-43df-a194-08e71edb0c9a', '4');
INSERT INTO "PRO_QUERY" VALUES ('2dfdf19c-5a15-48fd-81b0-e39442333cac', 'OrKeyLike', '46608dc8-953d-403e-b05a-f282626f666b', 'f5739a82-9b09-4f28-92e5-b5eb1c34c7b0', '5');
INSERT INTO "PRO_QUERY" VALUES ('5b6eeed0-c0de-4423-8a53-9b71cf85a1d7', 'OrKeyLike', '46608dc8-953d-403e-b05a-f282626f666b', '46b6b39f-fc93-4770-8a13-0efcccf09da5', '6');
INSERT INTO "PRO_QUERY" VALUES ('918a9847-b94a-4f51-8ca6-eb354f71be57', 'OrKeyLike', '46608dc8-953d-403e-b05a-f282626f666b', '35f50e9b-cc67-4d5e-af54-625c70d20762', '7');
INSERT INTO "PRO_QUERY" VALUES ('c368997c-65d1-43f0-a33f-9f45000fdf47', 'OrKeyLike', '46608dc8-953d-403e-b05a-f282626f666b', '60b7d916-2b6e-4c19-ba53-1c58c8164fd9', '8');
INSERT INTO "PRO_QUERY" VALUES ('f8810dc0-461b-4dbe-bf6d-7c64419cc9de', 'OrKeyLike', '46608dc8-953d-403e-b05a-f282626f666b', '641f5a98-2c4f-4be0-9ec2-2a73b836025c', '9');
INSERT INTO "PRO_QUERY" VALUES ('4930cad1-7279-4f11-be27-21934aeadb37', 'OrKeyLike', '46608dc8-953d-403e-b05a-f282626f666b', '102b00b2-f991-4fc5-a680-88e6774947be', '10');
INSERT INTO "PRO_QUERY" VALUES ('df32d5fd-b0d6-4507-bb36-3f11f14f29f8', 'OrKeyLike', '46608dc8-953d-403e-b05a-f282626f666b', '37095aa6-ed67-4157-bf6a-5c75e0cba3f8', '11');

INSERT INTO "PRO_SORT" VALUES ('9fb9a3ca-a254-45e2-b951-3615e0d22206', 'ASC', '180e1ea1-7c27-467f-86ff-450ed33cd493', 'e0ae2ba1-a3e3-4171-bc6c-a1ef36de52b4');
INSERT INTO "PRO_SORT" VALUES ('3f58dc29-5bce-40ee-8fa8-fe4c356ba3e8', 'ASC', '46608dc8-953d-403e-b05a-f282626f666b', '6c92e1ea-44dc-4fda-bc43-e92d4ee4ffa5');
