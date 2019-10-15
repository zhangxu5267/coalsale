package com.drzyl.sign.mapper;

import com.drzyl.sign.business.param.LoginInfoParam;
import com.drzyl.sign.entity.Org;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;

public interface AccessMapper {
  void modifyPassword(LoginInfoParam loginInfoParam);
}