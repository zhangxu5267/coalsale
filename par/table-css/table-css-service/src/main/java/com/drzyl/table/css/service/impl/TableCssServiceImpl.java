package com.drzyl.table.css.service.impl;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.drzyl.tool.exception.ToolException;
import com.drzyl.tool.util.Paging;
import com.drzyl.tool.util.Param;
import com.drzyl.tool.util.ToolUtil;
import com.drzyl.table.css.entity.TableCss;
import com.drzyl.table.css.persistent.ITableCssPersistent;
import com.drzyl.table.css.query.TableCssQuery;
import com.drzyl.table.css.service.ITableCssService;
import com.drzyl.table.css.vo.TableCssVO;
import lombok.extern.log4j.Log4j2;

/**
 * 页面表格样式 服务实现
 */
@Log4j2
@Service("com.drzyl.table.css.TableCssService")
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true, rollbackFor = Exception.class)
public class TableCssServiceImpl implements ITableCssService {

  public static final String LOG = "TableCssService";

  @Resource(name = "com.drzyl.table.css.TableCssPersistent")
  private ITableCssPersistent tableCssPersistent;

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public TableCss saveTableCss(TableCss tableCss) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + tableCss);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(tableCss)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      tableCss.setId(ToolUtil.getUUID());
      return tableCssPersistent.saveTableCss(tableCss);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public Collection<TableCss> batchSaveTableCss(Collection<TableCss> tableCsss) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + tableCsss);
    }
    try {
      if (ToolUtil.isEmpty(tableCsss)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      for (TableCss tableCss : tableCsss) {
        if (ToolUtil.isNullEntityAllFieldValue(tableCss)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        tableCss.setId(ToolUtil.getUUID());
      }
      return tableCssPersistent.batchSaveTableCss(tableCsss);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public TableCss updateTableCss(TableCss tableCss) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + tableCss);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(tableCss)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      if (ToolUtil.isNullStr(tableCss.getId())) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      TableCss oldTableCss = tableCssPersistent.getTableCssByPk(tableCss.getId());
      if (ToolUtil.isNullEntityAllFieldValue(oldTableCss)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return tableCssPersistent.updateTableCss(tableCss);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public Collection<TableCss> batchUpdateTableCss(Collection<TableCss> tableCsss) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + tableCsss);
    }
    try {
      if (ToolUtil.isEmpty(tableCsss)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      for (TableCss tableCss : tableCsss) {
        if (ToolUtil.isNullEntityAllFieldValue(tableCss)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        if (ToolUtil.isNullStr(tableCss.getId())) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        TableCss oldTableCss = tableCssPersistent.getTableCssByPk(tableCss.getId());
        if (ToolUtil.isNullEntityAllFieldValue(oldTableCss)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
      }
      return tableCssPersistent.batchUpdateTableCss(tableCsss);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public void removeTableCss(TableCss tableCss) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + tableCss);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(tableCss)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      Set<TableCss> tableCssSet = new LinkedHashSet<>();
      if (ToolUtil.isNullStr(tableCss.getId())) {
        TableCssQuery tableCssQuery = new TableCssQuery();
        BeanUtils.copyProperties(tableCss, tableCssQuery);
        tableCssSet.addAll(tableCssPersistent.queryTableCss(tableCssQuery));
      } else {
        TableCss oldTableCss = tableCssPersistent.getTableCssByPk(tableCss.getId());
        if (ToolUtil.isNullEntityAllFieldValue(oldTableCss)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        tableCssSet.add(oldTableCss);
      }
      if (ToolUtil.isNotEmpty(tableCssSet)) {
        tableCssPersistent.batchRemoveTableCss(tableCssSet);
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public void batchRemoveTableCss(Collection<TableCss> tableCsss) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + tableCsss);
    }
    try {
      if (ToolUtil.isEmpty(tableCsss)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      Set<TableCss> tableCssSet = new LinkedHashSet<>();
      for (TableCss tableCss : tableCsss) {
        if (ToolUtil.isNullEntityAllFieldValue(tableCss)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        if (ToolUtil.isNullStr(tableCss.getId())) {
          TableCssQuery tableCssQuery = new TableCssQuery();
          BeanUtils.copyProperties(tableCss, tableCssQuery);
          tableCssSet.addAll(tableCssPersistent.queryTableCss(tableCssQuery));
        } else {
          TableCss oldTableCss = tableCssPersistent.getTableCssByPk(tableCss.getId());
          if (ToolUtil.isNullEntityAllFieldValue(oldTableCss)) {
            throw new ToolException(ToolException.E_PARAM_ERR);
          }
          tableCssSet.add(oldTableCss);
        }
      }
      if (ToolUtil.isNotEmpty(tableCssSet)) {
        tableCssPersistent.batchRemoveTableCss(tableCssSet);
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Long getCountTableCss(TableCssQuery tableCssQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + tableCssQuery);
    }
    try {
      return tableCssPersistent.getCountTableCss(tableCssQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public TableCss getTableCssByPk(String id) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + id);
    }
    try {
      if (ToolUtil.isNullStr(id)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return tableCssPersistent.getTableCssByPk(id);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<TableCss> getAllTableCss() throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
    }
    try {
      return tableCssPersistent.getAllTableCss();
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<TableCss> queryTableCss(TableCssQuery tableCssQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + tableCssQuery);
    }
    try {
      return tableCssPersistent.queryTableCss(tableCssQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Paging<TableCss> pagingQueryTableCss(Param param, TableCssQuery tableCssQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + tableCssQuery);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(param)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return tableCssPersistent.pagingQueryTableCss(param, tableCssQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public TableCssVO getTableCssVOByPk(String id) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + id);
    }
    try {
      if (ToolUtil.isNullStr(id)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return tableCssPersistent.getTableCssVOByPk(id);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<TableCssVO> getAllTableCssVO() throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
    }
    try {
      return tableCssPersistent.getAllTableCssVO();
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<TableCssVO> queryTableCssVO(TableCssQuery tableCssQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + tableCssQuery);
    }
    try {
      return tableCssPersistent.queryTableCssVO(tableCssQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Paging<TableCssVO> pagingQueryTableCssVO(Param param, TableCssQuery tableCssQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + tableCssQuery);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(param)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return tableCssPersistent.pagingQueryTableCssVO(param, tableCssQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

}
