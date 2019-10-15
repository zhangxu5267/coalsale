package com.drzyl.code.persistent.business.impl;

import com.drzyl.code.business.persistent.IDatabasePersistent;
import com.drzyl.code.entity.Columns;
import com.drzyl.code.persistent.IColumnsPersistent;
import com.drzyl.code.query.ColumnsQuery;
import com.drzyl.code.vo.ColumnsVO;
import com.drzyl.tool.exception.ToolException;
import com.drzyl.tool.persistent.impl.ToolPersistent;
import com.drzyl.tool.util.Paging;
import com.drzyl.tool.util.Param;
import com.drzyl.tool.util.ToolUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * 列 持久化实现
 */
@Log4j2
@Repository("com.drzyl.code.DatabasePersistent")
public class DatabasePersistentImpl extends ToolPersistent implements IDatabasePersistent {

  public static final String LOG = "DatabasePersistent";

  @Override
  public String getDataBaseType() throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
    }
    try {
      if (dataBaseType.equals(MYSQL)) {
        return "mysql";
      } else if (dataBaseType.equals(ORACLE)) {
        return "oracle";
      } else {
        return "mysql";
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

}
