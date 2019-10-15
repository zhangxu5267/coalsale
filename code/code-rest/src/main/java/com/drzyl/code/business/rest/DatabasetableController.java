package com.drzyl.code.business.rest;

import com.drzyl.code.business.persistent.IDatabasePersistent;
import com.drzyl.code.business.service.IDatabasetableService;
import com.drzyl.code.business.vo.DataBaseInfo;
import com.drzyl.code.business.vo.OracleTableInfo;
import com.drzyl.tool.rest.Responses;
import com.drzyl.tool.rest.ToolController;
import com.drzyl.tool.util.Param;
import com.drzyl.tool.util.ToolUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 数据库表信息 REST API
 */
@Log4j2
@RestController
@Scope("prototype")
@RequestMapping(value = { "code/databasetable" })
public class DatabasetableController extends ToolController {

  public static final String LOG = "DatabasetableController";

  @Resource(name = "com.drzyl.code.business.DatabasetableService")
  private IDatabasetableService databasetableService;

  /**
   * 获取Oracle数据库表信息
   */
  @PostMapping(params = { ToolUtil.ACTION + "get_all_table" })
  public Responses<OracleTableInfo> getAllTable(Param param) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
    }
    Responses<OracleTableInfo> responses = new Responses<>();
    try {
      responses.setData(databasetableService.getAllTable());
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 获取当前连接数据库类型
   */
  @PostMapping(params = { ToolUtil.ACTION + "get_data_base_type" })
  public Responses<DataBaseInfo> getDataBaseType(Param param) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
    }
    Responses<DataBaseInfo> responses = new Responses<>();
    try {
      responses.setData(databasetableService.getDataBaseType());
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

}
