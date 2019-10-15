package com.drzyl.code.mapper;

import java.util.Collection;

import com.drzyl.code.business.vo.OracleTableInfo;

public interface DatabasetableMapper {

  public Collection<OracleTableInfo> getAllTable() throws Exception;

}