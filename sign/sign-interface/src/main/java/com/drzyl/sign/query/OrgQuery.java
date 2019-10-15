package com.drzyl.sign.query;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * 组织机构 SYS_ORG 查询类
 */
@Data
public class OrgQuery implements Serializable {

  private static final long serialVersionUID = 1L;

  protected String toolExists; // 解决多对多关系预留字段之存在

  protected String toolNotExists; // 解决多对多关系预留字段之不存在

  protected String orgId; // 组织机构编号

  protected String orgName; // 组织机构名称

  protected String orgType; // 组织机构类型

  protected String idPath; // 编号路径

  protected String namePath; // 名称路径

  protected Integer weightOrder; // 排序权重

  protected String orgPid; // 上级组织机构编号

  protected Integer versions; // 版本号

  protected String createId; // 创建人账号

  protected String createName; // 创建人名称

  protected Long createTimes; // 创建时间

  protected String modifyId; // 修改人账号

  protected String modifyName; // 修改人名称

  protected Long modifyTimes; // 修改时间

  protected List<String> orgIdAndin; // 组织机构编号Andin查询

  protected String orgNameAndKeyLike; // 组织机构名称AndKeyLike查询

  protected String orgTypeOrKeyLike; // 组织机构类型OrKeyLike查询

  protected String idPathOrKeyLike; // 编号路径OrKeyLike查询

  protected String namePathOrKeyLike; // 名称路径OrKeyLike查询

  protected String orgPidOrKeyLike; // 上级组织机构编号OrKeyLike查询

  protected String createIdOrKeyLike; // 创建人账号OrKeyLike查询

  protected String createNameOrKeyLike; // 创建人名称OrKeyLike查询

  protected String modifyIdOrKeyLike; // 修改人账号OrKeyLike查询

  protected String modifyNameOrKeyLike; // 修改人名称OrKeyLike查询

}
