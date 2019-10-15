package com.drzyl.code.business.service.impl;

import java.util.Collection;

import com.drzyl.code.business.persistent.IDatabasePersistent;
import com.drzyl.code.business.service.IDatabasetableService;
import com.drzyl.code.business.vo.DataBaseInfo;
import com.drzyl.code.business.vo.OracleTableInfo;
import com.drzyl.code.mapper.DatabasetableMapper;
import com.drzyl.tool.util.ToolUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 数据库表信息 服务实现
 */
@Log4j2
@Service("com.drzyl.code.business.DatabasetableService")
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true, rollbackFor = Exception.class)
public class DatabasetableServiceImpl implements IDatabasetableService {

  public static final String LOG = "DatabasetableService";

  @Autowired
  private DatabasetableMapper databasetableMapper;

  @Resource(name = "com.drzyl.code.DatabasePersistent")
  private IDatabasePersistent databasePersistent;

  @Override
  public Collection<OracleTableInfo> getAllTable() throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
    }
    try {
      return databasetableMapper.getAllTable();
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public DataBaseInfo getDataBaseType() throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
    }
    try {
      DataBaseInfo dataBaseInfo = new DataBaseInfo();
      dataBaseInfo.setDataBaseType(databasePersistent.getDataBaseType());
      return dataBaseInfo;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

}
