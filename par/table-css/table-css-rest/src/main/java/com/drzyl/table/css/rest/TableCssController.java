package com.drzyl.table.css.rest;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drzyl.tool.exception.ToolException;
import com.drzyl.tool.rest.Responses;
import com.drzyl.tool.rest.ToolController;
import com.drzyl.tool.util.Param;
import com.drzyl.tool.util.ToolUtil;
import com.drzyl.table.css.entity.TableCss;
import com.drzyl.table.css.query.TableCssQuery;
import com.drzyl.table.css.service.ITableCssService;
import com.drzyl.table.css.vo.TableCssVO;
import lombok.extern.log4j.Log4j2;

/**
 * 页面表格样式 REST API
 */
@Log4j2
@RestController
@Scope("prototype")
@RequestMapping(value = { "table/css/tableCss" })
public class TableCssController extends ToolController {

  public static final String LOG = "TableCssController";

  @Resource(name = "com.drzyl.table.css.TableCssService")
  private ITableCssService tableCssService;

  /**
   * 保存 页面表格样式 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_SAVE })
  public Responses<TableCss> save(Param param, @RequestBody TableCss tableCss) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + tableCss);
    }
    Responses<TableCss> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(tableCss)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(tableCssService.saveTableCss(tableCss));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 批量保存 页面表格样式 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_BATCH_SAVE })
  public Responses<TableCss> batchSave(Param param, @RequestBody List<TableCss> tableCsss) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + tableCsss);
    }
    Responses<TableCss> responses = new Responses<>();
    try {
      if (ToolUtil.isEmpty(tableCsss)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(tableCssService.batchSaveTableCss(tableCsss));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 修改 页面表格样式 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_UPDATE })
  public Responses<TableCss> update(Param param, @RequestBody TableCss tableCss) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + tableCss);
    }
    Responses<TableCss> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(tableCss)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(tableCssService.updateTableCss(tableCss));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 批量修改 页面表格样式 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_BATCH_UPDATE })
  public Responses<TableCss> batchUpdate(Param param, @RequestBody List<TableCss> tableCsss) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + tableCsss);
    }
    Responses<TableCss> responses = new Responses<>();
    try {
      if (ToolUtil.isEmpty(tableCsss)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(tableCssService.batchUpdateTableCss(tableCsss));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 删除 页面表格样式 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_REMOVE })
  public Responses<TableCss> remove(Param param, @RequestBody TableCss tableCss) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + tableCss);
    }
    Responses<TableCss> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(tableCss)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      tableCssService.removeTableCss(tableCss);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 批量删除 页面表格样式 信息
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_BATCH_REMOVE })
  public Responses<TableCss> batchRemove(Param param, @RequestBody List<TableCss> tableCsss) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + tableCsss);
    }
    Responses<TableCss> responses = new Responses<>();
    try {
      if (ToolUtil.isEmpty(tableCsss)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      tableCssService.batchRemoveTableCss(tableCsss);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 通过主键获取 页面表格样式 数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_GET_BY_PK })
  public Responses<TableCss> getByPk(Param param, @RequestBody TableCss tableCss) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + tableCss);
    }
    Responses<TableCss> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(tableCss)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      if (ToolUtil.isNullStr(tableCss.getId())) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(tableCssService.getTableCssByPk(tableCss.getId()));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 获取 页面表格样式 数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_GET_ALL })
  public Responses<TableCss> getAll(Param param, @RequestBody TableCssQuery tableCssQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + tableCssQuery);
    }
    Responses<TableCss> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(tableCssQuery)) {
        responses.setData(tableCssService.getAllTableCss());
      } else {
        responses.setData(tableCssService.queryTableCss(tableCssQuery));
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 分页获取 页面表格样式 数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_PAGING })
  public Responses<TableCss> paging(Param param, @RequestBody TableCssQuery tableCssQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + tableCssQuery);
    }
    Responses<TableCss> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(tableCssQuery)) {
        responses.setData(tableCssService.pagingQueryTableCss(param, null));
      } else {
        responses.setData(tableCssService.pagingQueryTableCss(param, tableCssQuery));
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 通过主键获取 页面表格样式 展示数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_GET_VO_BY_PK })
  public Responses<TableCssVO> getVOByPk(Param param, @RequestBody TableCss tableCss) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + tableCss);
    }
    Responses<TableCssVO> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(tableCss)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      if (ToolUtil.isNullStr(tableCss.getId())) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      responses.setData(tableCssService.getTableCssVOByPk(tableCss.getId()));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 获取 页面表格样式 展示数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_GET_ALL_VO })
  public Responses<TableCssVO> getAllVO(Param param, @RequestBody TableCssQuery tableCssQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + tableCssQuery);
    }
    Responses<TableCssVO> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(tableCssQuery)) {
        responses.setData(tableCssService.getAllTableCssVO());
      } else {
        responses.setData(tableCssService.queryTableCssVO(tableCssQuery));
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

  /**
   * 分页获取 页面表格样式 展示数据
   */
  @PostMapping(params = { ToolUtil.ACTION + ToolUtil.ACTION_PAGING_VO })
  public Responses<TableCssVO> pagingVO(Param param, @RequestBody TableCssQuery tableCssQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + tableCssQuery);
    }
    Responses<TableCssVO> responses = new Responses<>();
    try {
      if (ToolUtil.isNullEntityAllFieldValue(tableCssQuery)) {
        responses.setData(tableCssService.pagingQueryTableCssVO(param, null));
      } else {
        responses.setData(tableCssService.pagingQueryTableCssVO(param, tableCssQuery));
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
    return responses;
  }

}
