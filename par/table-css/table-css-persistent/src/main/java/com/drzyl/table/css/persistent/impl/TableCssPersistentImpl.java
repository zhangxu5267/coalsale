package com.drzyl.table.css.persistent.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.drzyl.tool.exception.ToolException;
import com.drzyl.tool.persistent.impl.ToolPersistent;
import com.drzyl.tool.util.Paging;
import com.drzyl.tool.util.Param;
import com.drzyl.tool.util.ToolUtil;
import com.drzyl.table.css.entity.TableCss;
import com.drzyl.table.css.persistent.ITableCssPersistent;
import com.drzyl.table.css.query.TableCssQuery;
import com.drzyl.table.css.vo.TableCssVO;
import lombok.extern.log4j.Log4j2;

/**
 * 页面表格样式 持久化实现
 */
@Log4j2
@Repository("com.drzyl.table.css.TableCssPersistent")
public class TableCssPersistentImpl extends ToolPersistent implements ITableCssPersistent {

  public static final String LOG = "TableCssPersistent";

  public static final String TABLE_ALIAS = "tableCss";

  public static final LinkedHashSet<String> PRIMARY_KEY = new LinkedHashSet<>();
  public static final LinkedHashSet<String> COLUMNS = new LinkedHashSet<>();
  public static final LinkedHashMap<String, String> COLUMNS_PARAMETER = new LinkedHashMap<>();
  public static final LinkedHashSet<String> VIRTUAL_COLUMNS = new LinkedHashSet<>();
  public static final LinkedHashMap<String, String> SORT = new LinkedHashMap<>();

  private static StringBuilder INSERT_SQL = new StringBuilder();
  private static StringBuilder UPDATE_SQL = new StringBuilder();
  private static StringBuilder DEL_SQL_BY_PK = new StringBuilder();
  public static StringBuilder SELECT_SQL = new StringBuilder();
  public static StringBuilder SELECT_VO_SQL = new StringBuilder();
  public static StringBuilder COUNT_SQL = new StringBuilder();

  @PostConstruct
  private void init() {
    super.init(TABLE_NAME, PRIMARY_KEY, COLUMNS, COLUMNS_PARAMETER, VIRTUAL_COLUMNS, SORT);
    INSERT_SQL = getInsertSql(TABLE_NAME, COLUMNS, COLUMNS_PARAMETER);
    UPDATE_SQL = getUpdateSql(TABLE_NAME, COLUMNS, COLUMNS_PARAMETER, PRIMARY_KEY);
    DEL_SQL_BY_PK = getDelSql(TABLE_NAME, COLUMNS_PARAMETER, PRIMARY_KEY);
    SELECT_SQL = getSelectSql(TABLE_NAME, COLUMNS, COLUMNS_PARAMETER, PRIMARY_KEY, TABLE_ALIAS);
    SELECT_VO_SQL = getSelectSql(TABLE_NAME, COLUMNS, COLUMNS_PARAMETER, VIRTUAL_COLUMNS, PRIMARY_KEY, TABLE_ALIAS);
    COUNT_SQL = getCountSql(TABLE_NAME, COLUMNS_PARAMETER, PRIMARY_KEY, TABLE_ALIAS);
  }

  @Override
  public TableCss saveTableCss(TableCss tableCss) throws Exception {
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
      this.insert(INSERT_SQL, tableCss);
      return tableCss;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<TableCss> batchSaveTableCss(Collection<TableCss> tableCsss) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + tableCsss);
    }
    try {
      if (ToolUtil.isEmpty(tableCsss)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      this.insert(INSERT_SQL, tableCsss);
      return tableCsss;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
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
      this.update(UPDATE_SQL, tableCss);
      return tableCss;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<TableCss> batchUpdateTableCss(Collection<TableCss> tableCsss) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + tableCsss);
    }
    try {
      if (ToolUtil.isEmpty(tableCsss)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      this.update(UPDATE_SQL, tableCsss);
      return tableCsss;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public void removeTableCss(TableCss tableCss) throws Exception {
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
      MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
      if (ToolUtil.isNotEmpty(PRIMARY_KEY) && PRIMARY_KEY.size() == 1) {
        for (String pk : PRIMARY_KEY) {
          mapSqlParameterSource.addValue(pk, tableCss.getId());
        }
      }
      this.del(DEL_SQL_BY_PK, mapSqlParameterSource);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public void batchRemoveTableCss(Collection<TableCss> tableCsss) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + tableCsss);
    }
    try {
      if (ToolUtil.isEmpty(tableCsss)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      this.del(DEL_SQL_BY_PK, tableCsss);
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
      StringBuilder countSql = new StringBuilder(COUNT_SQL);
      if (!ToolUtil.isNullEntityAllFieldValue(tableCssQuery)) {
        this.getExistsSql(tableCssQuery);
        countSql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, tableCssQuery));
      }
      if (ToolUtil.isNullEntityAllFieldValue(tableCssQuery)) {
        return this.queryCount(countSql, Long.class);
      } else {
        return this.queryCount(countSql, tableCssQuery, Long.class);
      }
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
      StringBuilder querySql = new StringBuilder(SELECT_SQL);
      querySql.append(this.getByPkSql(COLUMNS_PARAMETER, PRIMARY_KEY, TABLE_ALIAS));
      MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
      if (ToolUtil.isNotEmpty(PRIMARY_KEY) && PRIMARY_KEY.size() == 1) {
        for (String pk : PRIMARY_KEY) {
          mapSqlParameterSource.addValue(pk, id);
        }
      }
      Collection<TableCss> tableCssSet = this.query(querySql, mapSqlParameterSource, TableCss.class);
      return ToolUtil.isNotEmpty(tableCssSet) ? tableCssSet.iterator().next() : null;
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
      StringBuilder querySql = new StringBuilder(SELECT_SQL);
      querySql.append(this.getSortSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS));
      return this.query(querySql, TableCss.class);
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
      StringBuilder querySql = new StringBuilder(SELECT_SQL);
      if (!ToolUtil.isNullEntityAllFieldValue(tableCssQuery)) {
        this.getExistsSql(tableCssQuery);
        querySql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, tableCssQuery));
      }
      querySql.append(this.getSortSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS));
      if (ToolUtil.isNullEntityAllFieldValue(tableCssQuery)) {
        return this.query(querySql, TableCss.class);
      } else {
        return this.query(querySql, tableCssQuery, TableCss.class);
      }
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
      if (param.getRows() < 0) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      if (param.getPage() < 1) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      Paging<TableCss> paging = new Paging<>(param);
      StringBuilder countSql = new StringBuilder(COUNT_SQL);
      if (!ToolUtil.isNullEntityAllFieldValue(tableCssQuery)) {
        this.getExistsSql(tableCssQuery);
        countSql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, tableCssQuery));
      }
      Long count = null;
      if (ToolUtil.isNullEntityAllFieldValue(tableCssQuery)) {
        count = this.queryCount(countSql, Long.class);
      } else {
        count = this.queryCount(countSql, tableCssQuery, Long.class);
      }
      paging.setCount(count);
      if (count > 0) {
        StringBuilder querySql = new StringBuilder(this.getPagingSql(TABLE_NAME, COLUMNS_PARAMETER, PRIMARY_KEY, TABLE_ALIAS));
        if (!ToolUtil.isNullEntityAllFieldValue(tableCssQuery)) {
          querySql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, tableCssQuery));
        }
        querySql.append(this.getPagingSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS, paging));
        Collection<TableCss> tableCssSet = null;
        if (ToolUtil.isNullEntityAllFieldValue(tableCssQuery)) {
          tableCssSet = this.query(querySql, TableCss.class);
        } else {
          tableCssSet = this.query(querySql, tableCssQuery, TableCss.class);
        }
        if (ToolUtil.isNotEmpty(tableCssSet)) {
          Set<String> inId = new LinkedHashSet<>();
          for (TableCss tableCss : tableCssSet) {
            inId.add(tableCss.getId());
          }
          TableCssQuery rTableCssQuery = new TableCssQuery();
          rTableCssQuery.setIdAndin(new ArrayList<>(inId));
          Collection<TableCss> rTableCssSet = this.queryTableCss(rTableCssQuery);
          if (ToolUtil.isNotEmpty(rTableCssSet)) {
            paging.setData(rTableCssSet);
          }
        }
      }
      return paging;
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
      StringBuilder querySql = new StringBuilder(SELECT_VO_SQL);
      querySql.append(this.getByPkSql(COLUMNS_PARAMETER, PRIMARY_KEY, TABLE_ALIAS));
      MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
      if (ToolUtil.isNotEmpty(PRIMARY_KEY) && PRIMARY_KEY.size() == 1) {
        for (String pk : PRIMARY_KEY) {
          mapSqlParameterSource.addValue(pk, id);
        }
      }
      Collection<TableCssVO> tableCssVOSet = this.query(querySql, mapSqlParameterSource, TableCssVO.class);
      return ToolUtil.isNotEmpty(tableCssVOSet) ? tableCssVOSet.iterator().next() : null;
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
      StringBuilder querySql = new StringBuilder(SELECT_VO_SQL);
      querySql.append(this.getSortSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS));
      return this.query(querySql, TableCssVO.class);
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
      StringBuilder querySql = new StringBuilder(SELECT_VO_SQL);
      if (!ToolUtil.isNullEntityAllFieldValue(tableCssQuery)) {
        this.getExistsSql(tableCssQuery);
        querySql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, tableCssQuery));
      }
      querySql.append(this.getSortSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS));
      if (ToolUtil.isNullEntityAllFieldValue(tableCssQuery)) {
        return this.query(querySql, TableCssVO.class);
      } else {
        return this.query(querySql, tableCssQuery, TableCssVO.class);
      }
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
      if (param.getRows() < 0) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      if (param.getPage() < 1) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      Paging<TableCssVO> paging = new Paging<>(param);
      StringBuilder countSql = new StringBuilder(COUNT_SQL);
      if (!ToolUtil.isNullEntityAllFieldValue(tableCssQuery)) {
        this.getExistsSql(tableCssQuery);
        countSql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, tableCssQuery));
      }
      Long count = null;
      if (ToolUtil.isNullEntityAllFieldValue(tableCssQuery)) {
        count = this.queryCount(countSql, Long.class);
      } else {
        count = this.queryCount(countSql, tableCssQuery, Long.class);
      }
      paging.setCount(count);
      if (count > 0) {
        StringBuilder querySql = new StringBuilder(this.getPagingSql(TABLE_NAME, COLUMNS_PARAMETER, PRIMARY_KEY, TABLE_ALIAS));
        if (!ToolUtil.isNullEntityAllFieldValue(tableCssQuery)) {
          querySql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, tableCssQuery));
        }
        querySql.append(this.getPagingSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS, paging));
        Collection<TableCss> tableCssSet = null;
        if (ToolUtil.isNullEntityAllFieldValue(tableCssQuery)) {
          tableCssSet = this.query(querySql, TableCss.class);
        } else {
          tableCssSet = this.query(querySql, tableCssQuery, TableCss.class);
        }
        if (ToolUtil.isNotEmpty(tableCssSet)) {
          Set<String> inId = new LinkedHashSet<>();
          for (TableCss tableCss : tableCssSet) {
            inId.add(tableCss.getId());
          }
          TableCssQuery rTableCssQuery = new TableCssQuery();
          rTableCssQuery.setIdAndin(new ArrayList<>(inId));
          Collection<TableCssVO> rTableCssVOSet = this.queryTableCssVO(rTableCssQuery);
          if (ToolUtil.isNotEmpty(rTableCssVOSet)) {
            paging.setData(rTableCssVOSet);
          }
        }
      }
      return paging;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  private void getExistsSql(TableCssQuery tableCssQuery) throws Exception {
    try {
      if (ToolUtil.isNotNullStr(tableCssQuery.getToolExists())) {
        if ("NEXUS".equals(tableCssQuery.getToolExists().toUpperCase())) {
          tableCssQuery.setToolExists("SELECT NEXUS_ID FROM NEXUS WHERE NEXUS_ID IS NOT NULL AND ID = " + TABLE_ALIAS + ".ID");
        } else {
          tableCssQuery.setToolExists(null);
        }
      }
      if (ToolUtil.isNotNullStr(tableCssQuery.getToolNotExists())) {
        if ("NEXUS".equals(tableCssQuery.getToolNotExists().toUpperCase())) {
          tableCssQuery.setToolNotExists("SELECT NEXUS_ID FROM NEXUS WHERE NEXUS_ID IS NOT NULL AND ID = " + TABLE_ALIAS + ".ID");
        } else {
          tableCssQuery.setToolNotExists(null);
        }
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

}
