package com.drzyl.sign.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

/**
 * 岗位 SYS_POST 实体类
 */
@Data
@TableName(value = "SYS_POST")
public class Post implements Serializable {

  private static final long serialVersionUID = 1L;

  @TableId
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

}
