package com.drzyl.sign.mapper;

import com.drzyl.sign.entity.Org;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;

public interface OrgInfoMapper {

  public Collection<Org> getOrgInfo(@Param("ids") List<String> ids) throws Exception;
  
}