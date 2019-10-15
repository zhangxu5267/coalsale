package com.drzyl.sign.query;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * 岗位 SYS_POST 查询类
 */
@Data
public class PostQuery implements Serializable {

  private static final long serialVersionUID = 1L;

  protected String toolExists; // 解决多对多关系预留字段之存在

  protected String toolNotExists; // 解决多对多关系预留字段之不存在

  protected String postId; // 岗位编号

  protected String postName; // 岗位名称

  protected Integer weightOrder; // 排序权重

  protected String orgId; // 组织机构编号

  protected Integer versions; // 版本号

  protected String createId; // 创建人账号

  protected String createName; // 创建人名称

  protected Long createTimes; // 创建时间

  protected String modifyId; // 修改人账号

  protected String modifyName; // 修改人名称

  protected Long modifyTimes; // 修改时间

  protected List<String> postIdAndin; // 岗位编号Andin查询

  protected String postNameAndeq; // 岗位名称Andeq查询

  protected String orgIdAndeq; // 组织机构编号Andeq查询

  protected String postNameAndKeyLike; // 岗位名称AndKeyLike查询

  protected String orgIdOrKeyLike; // 组织机构编号OrKeyLike查询

  protected String createIdOrKeyLike; // 创建人账号OrKeyLike查询

  protected String createNameOrKeyLike; // 创建人名称OrKeyLike查询

  protected String modifyIdOrKeyLike; // 修改人账号OrKeyLike查询

  protected String modifyNameOrKeyLike; // 修改人名称OrKeyLike查询

}
