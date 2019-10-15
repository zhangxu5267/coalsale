/* 获取除系统表的 [PRO_DT] 数据 */
SELECT x.*,x.ROWID FROM PRO_DT x
WHERE DT_SQL not like 'SYS_%'

/* 获取除系统表的 [PRO_COLUMNS] 数据 in 中的数据 是 [PRO_DT].[TD_ID]*/
SELECT x.*,x.ROWID FROM PRO_COLUMNS x
WHERE dt_id in (
'c7a9ce4f-c634-4e3d-9cec-bacb07f7a6b5',
'bd4db03a-7f84-486f-bee1-30a4fa32e0ba',
'0dbe6262-5d6a-4c69-a02e-74f7b13618d8',
'f34bc0c4-bd37-4c8c-9f3f-1b565126aa26',
'0622c005-37fd-44e5-9d14-17ec43212a64',
'eb0780fd-1677-4bf5-bb8c-9eaa89ce0bb4',
'4082e383-7910-4c53-9354-876fb6599f59',
'9560b069-31af-4f23-89f6-e7a3a62db78d',
'1c1d837f-04af-4714-8519-51768c6ddce9',
'78341afe-3d71-4d80-8c5a-558c4ca1a39c',
'415378ec-15f0-4efd-9535-85f2b95c7c5c'
)

/* 获取除系统表的 [PRO_PK] 数据 in 中的数据 是 [PRO_DT].[TD_ID]*/
SELECT x.*,x.ROWID FROM COALSALE.PRO_PK x
WHERE dt_id in (
'c7a9ce4f-c634-4e3d-9cec-bacb07f7a6b5',
'bd4db03a-7f84-486f-bee1-30a4fa32e0ba',
'0dbe6262-5d6a-4c69-a02e-74f7b13618d8',
'f34bc0c4-bd37-4c8c-9f3f-1b565126aa26',
'0622c005-37fd-44e5-9d14-17ec43212a64',
'eb0780fd-1677-4bf5-bb8c-9eaa89ce0bb4',
'4082e383-7910-4c53-9354-876fb6599f59',
'9560b069-31af-4f23-89f6-e7a3a62db78d',
'1c1d837f-04af-4714-8519-51768c6ddce9',
'78341afe-3d71-4d80-8c5a-558c4ca1a39c',
'415378ec-15f0-4efd-9535-85f2b95c7c5c'
)

/* 获取除系统表的 [PRO_QUERY] 数据 in 中的数据 是 [PRO_DT].[TD_ID]*/
SELECT x.*,x.ROWID FROM COALSALE.PRO_QUERY x
WHERE dt_id in (
'c7a9ce4f-c634-4e3d-9cec-bacb07f7a6b5',
'bd4db03a-7f84-486f-bee1-30a4fa32e0ba',
'0dbe6262-5d6a-4c69-a02e-74f7b13618d8',
'f34bc0c4-bd37-4c8c-9f3f-1b565126aa26',
'0622c005-37fd-44e5-9d14-17ec43212a64',
'eb0780fd-1677-4bf5-bb8c-9eaa89ce0bb4',
'4082e383-7910-4c53-9354-876fb6599f59',
'9560b069-31af-4f23-89f6-e7a3a62db78d',
'1c1d837f-04af-4714-8519-51768c6ddce9',
'78341afe-3d71-4d80-8c5a-558c4ca1a39c',
'415378ec-15f0-4efd-9535-85f2b95c7c5c'
)

/* 获取除系统表的 [PRO_SORT] 数据 in 中的数据 是 [PRO_DT].[TD_ID]*/
SELECT x.*,x.ROWID FROM COALSALE.PRO_SORT x
WHERE dt_id in (
'c7a9ce4f-c634-4e3d-9cec-bacb07f7a6b5',
'bd4db03a-7f84-486f-bee1-30a4fa32e0ba',
'0dbe6262-5d6a-4c69-a02e-74f7b13618d8',
'f34bc0c4-bd37-4c8c-9f3f-1b565126aa26',
'0622c005-37fd-44e5-9d14-17ec43212a64',
'eb0780fd-1677-4bf5-bb8c-9eaa89ce0bb4',
'4082e383-7910-4c53-9354-876fb6599f59',
'9560b069-31af-4f23-89f6-e7a3a62db78d',
'1c1d837f-04af-4714-8519-51768c6ddce9',
'78341afe-3d71-4d80-8c5a-558c4ca1a39c',
'415378ec-15f0-4efd-9535-85f2b95c7c5c'
)

/* 获取除系统表的 [PRO_SORT] 数据 in 中的数据 是 [PRO_DT].[TD_ID]*/
SELECT x.*,x.ROWID FROM COALSALE.PRO_VIRTUAL_COLUMNS x
WHERE TARGET_DT_ID in (
'c7a9ce4f-c634-4e3d-9cec-bacb07f7a6b5',
'bd4db03a-7f84-486f-bee1-30a4fa32e0ba',
'0dbe6262-5d6a-4c69-a02e-74f7b13618d8',
'f34bc0c4-bd37-4c8c-9f3f-1b565126aa26',
'0622c005-37fd-44e5-9d14-17ec43212a64',
'eb0780fd-1677-4bf5-bb8c-9eaa89ce0bb4',
'4082e383-7910-4c53-9354-876fb6599f59',
'9560b069-31af-4f23-89f6-e7a3a62db78d',
'1c1d837f-04af-4714-8519-51768c6ddce9',
'78341afe-3d71-4d80-8c5a-558c4ca1a39c',
'415378ec-15f0-4efd-9535-85f2b95c7c5c'
)