package com.drzyl.code.mapper;

import java.util.Collection;

import com.drzyl.code.business.bo.ColumnData;

public interface CodingMapper {

  public String getTableNameAnnotation(String tableName) throws Exception;

  public Collection<ColumnData> getAllColumnDataByTableName(String tableName) throws Exception;
  
  public Collection<String> getPrimaryKeyConstraintNameByTableName(String tableName) throws Exception;
  
  public Collection<String> getPrimaryKeyColumnNameByTableNameAndConstraintName(String tableName, String constraintName) throws Exception;
  
  public Collection<String> getUniqueKeyConstraintNameByTableName(String tableName) throws Exception;
  
  public Collection<String> getUniqueKeyColumnNameByTableNameAndConstraintName(String tableName, String constraintName) throws Exception;

}