package com.drzyl.cus.persistent.impl;

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
import com.drzyl.cus.entity.CusAddrDis;
import com.drzyl.cus.persistent.ICusAddrDisPersistent;
import com.drzyl.cus.query.CusAddrDisQuery;
import com.drzyl.cus.vo.CusAddrDisVO;
import lombok.extern.log4j.Log4j2;

/**
 * 客户收货地址表 持久化实现
 */
@Log4j2
@Repository("com.drzyl.cus.CusAddrDisPersistent")
public class CusAddrDisPersistentImpl extends ToolPersistent implements ICusAddrDisPersistent {

  public static final String LOG = "CusAddrDisPersistent";

  public static final String TABLE_ALIAS = "cusAddrDis";

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
  public CusAddrDis saveCusAddrDis(CusAddrDis cusAddrDis) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusAddrDis);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(cusAddrDis)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      if (ToolUtil.isNullStr(cusAddrDis.getCusAddrDisId())) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      this.insert(INSERT_SQL, cusAddrDis);
      return cusAddrDis;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<CusAddrDis> batchSaveCusAddrDis(Collection<CusAddrDis> cusAddrDiss) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusAddrDiss);
    }
    try {
      if (ToolUtil.isEmpty(cusAddrDiss)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      this.insert(INSERT_SQL, cusAddrDiss);
      return cusAddrDiss;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public CusAddrDis updateCusAddrDis(CusAddrDis cusAddrDis) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusAddrDis);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(cusAddrDis)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      if (ToolUtil.isNullStr(cusAddrDis.getCusAddrDisId())) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      this.update(UPDATE_SQL, cusAddrDis);
      return cusAddrDis;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<CusAddrDis> batchUpdateCusAddrDis(Collection<CusAddrDis> cusAddrDiss) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusAddrDiss);
    }
    try {
      if (ToolUtil.isEmpty(cusAddrDiss)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      this.update(UPDATE_SQL, cusAddrDiss);
      return cusAddrDiss;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public void removeCusAddrDis(CusAddrDis cusAddrDis) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusAddrDis);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(cusAddrDis)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      if (ToolUtil.isNullStr(cusAddrDis.getCusAddrDisId())) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
      if (ToolUtil.isNotEmpty(PRIMARY_KEY) && PRIMARY_KEY.size() == 1) {
        for (String pk : PRIMARY_KEY) {
          mapSqlParameterSource.addValue(pk, cusAddrDis.getCusAddrDisId());
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
  public void batchRemoveCusAddrDis(Collection<CusAddrDis> cusAddrDiss) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusAddrDiss);
    }
    try {
      if (ToolUtil.isEmpty(cusAddrDiss)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      this.del(DEL_SQL_BY_PK, cusAddrDiss);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Long getCountCusAddrDis(CusAddrDisQuery cusAddrDisQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusAddrDisQuery);
    }
    try {
      StringBuilder countSql = new StringBuilder(COUNT_SQL);
      if (!ToolUtil.isNullEntityAllFieldValue(cusAddrDisQuery)) {
        this.getExistsSql(cusAddrDisQuery);
        countSql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, cusAddrDisQuery));
      }
      if (ToolUtil.isNullEntityAllFieldValue(cusAddrDisQuery)) {
        return this.queryCount(countSql, Long.class);
      } else {
        return this.queryCount(countSql, cusAddrDisQuery, Long.class);
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public CusAddrDis getCusAddrDisByPk(String cusAddrDisId) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusAddrDisId);
    }
    try {
      if (ToolUtil.isNullStr(cusAddrDisId)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      StringBuilder querySql = new StringBuilder(SELECT_SQL);
      querySql.append(this.getByPkSql(COLUMNS_PARAMETER, PRIMARY_KEY, TABLE_ALIAS));
      MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
      if (ToolUtil.isNotEmpty(PRIMARY_KEY) && PRIMARY_KEY.size() == 1) {
        for (String pk : PRIMARY_KEY) {
          mapSqlParameterSource.addValue(pk, cusAddrDisId);
        }
      }
      Collection<CusAddrDis> cusAddrDisSet = this.query(querySql, mapSqlParameterSource, CusAddrDis.class);
      return ToolUtil.isNotEmpty(cusAddrDisSet) ? cusAddrDisSet.iterator().next() : null;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<CusAddrDis> getAllCusAddrDis() throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
    }
    try {
      StringBuilder querySql = new StringBuilder(SELECT_SQL);
      querySql.append(this.getSortSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS));
      return this.query(querySql, CusAddrDis.class);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<CusAddrDis> queryCusAddrDis(CusAddrDisQuery cusAddrDisQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusAddrDisQuery);
    }
    try {
      StringBuilder querySql = new StringBuilder(SELECT_SQL);
      if (!ToolUtil.isNullEntityAllFieldValue(cusAddrDisQuery)) {
        this.getExistsSql(cusAddrDisQuery);
        querySql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, cusAddrDisQuery));
      }
      querySql.append(this.getSortSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS));
      if (ToolUtil.isNullEntityAllFieldValue(cusAddrDisQuery)) {
        return this.query(querySql, CusAddrDis.class);
      } else {
        return this.query(querySql, cusAddrDisQuery, CusAddrDis.class);
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Paging<CusAddrDis> pagingQueryCusAddrDis(Param param, CusAddrDisQuery cusAddrDisQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + cusAddrDisQuery);
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
      Paging<CusAddrDis> paging = new Paging<>(param);
      StringBuilder countSql = new StringBuilder(COUNT_SQL);
      if (!ToolUtil.isNullEntityAllFieldValue(cusAddrDisQuery)) {
        this.getExistsSql(cusAddrDisQuery);
        countSql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, cusAddrDisQuery));
      }
      Long count = null;
      if (ToolUtil.isNullEntityAllFieldValue(cusAddrDisQuery)) {
        count = this.queryCount(countSql, Long.class);
      } else {
        count = this.queryCount(countSql, cusAddrDisQuery, Long.class);
      }
      paging.setCount(count);
      if (count > 0) {
        StringBuilder querySql = new StringBuilder(this.getPagingSql(TABLE_NAME, COLUMNS_PARAMETER, PRIMARY_KEY, TABLE_ALIAS));
        if (!ToolUtil.isNullEntityAllFieldValue(cusAddrDisQuery)) {
          querySql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, cusAddrDisQuery));
        }
        querySql.append(this.getPagingSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS, paging));
        Collection<CusAddrDis> cusAddrDisSet = null;
        if (ToolUtil.isNullEntityAllFieldValue(cusAddrDisQuery)) {
          cusAddrDisSet = this.query(querySql, CusAddrDis.class);
        } else {
          cusAddrDisSet = this.query(querySql, cusAddrDisQuery, CusAddrDis.class);
        }
        if (ToolUtil.isNotEmpty(cusAddrDisSet)) {
          Set<String> inCusAddrDisId = new LinkedHashSet<>();
          for (CusAddrDis cusAddrDis : cusAddrDisSet) {
            inCusAddrDisId.add(cusAddrDis.getCusAddrDisId());
          }
          CusAddrDisQuery rCusAddrDisQuery = new CusAddrDisQuery();
          rCusAddrDisQuery.setCusAddrDisIdAndin(new ArrayList<>(inCusAddrDisId));
          Collection<CusAddrDis> rCusAddrDisSet = this.queryCusAddrDis(rCusAddrDisQuery);
          if (ToolUtil.isNotEmpty(rCusAddrDisSet)) {
            paging.setData(rCusAddrDisSet);
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
  public CusAddrDisVO getCusAddrDisVOByPk(String cusAddrDisId) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusAddrDisId);
    }
    try {
      if (ToolUtil.isNullStr(cusAddrDisId)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      StringBuilder querySql = new StringBuilder(SELECT_VO_SQL);
      querySql.append(this.getByPkSql(COLUMNS_PARAMETER, PRIMARY_KEY, TABLE_ALIAS));
      MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
      if (ToolUtil.isNotEmpty(PRIMARY_KEY) && PRIMARY_KEY.size() == 1) {
        for (String pk : PRIMARY_KEY) {
          mapSqlParameterSource.addValue(pk, cusAddrDisId);
        }
      }
      Collection<CusAddrDisVO> cusAddrDisVOSet = this.query(querySql, mapSqlParameterSource, CusAddrDisVO.class);
      return ToolUtil.isNotEmpty(cusAddrDisVOSet) ? cusAddrDisVOSet.iterator().next() : null;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<CusAddrDisVO> getAllCusAddrDisVO() throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
    }
    try {
      StringBuilder querySql = new StringBuilder(SELECT_VO_SQL);
      querySql.append(this.getSortSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS));
      return this.query(querySql, CusAddrDisVO.class);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<CusAddrDisVO> queryCusAddrDisVO(CusAddrDisQuery cusAddrDisQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusAddrDisQuery);
    }
    try {
      StringBuilder querySql = new StringBuilder(SELECT_VO_SQL);
      if (!ToolUtil.isNullEntityAllFieldValue(cusAddrDisQuery)) {
        this.getExistsSql(cusAddrDisQuery);
        querySql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, cusAddrDisQuery));
      }
      querySql.append(this.getSortSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS));
      if (ToolUtil.isNullEntityAllFieldValue(cusAddrDisQuery)) {
        return this.query(querySql, CusAddrDisVO.class);
      } else {
        return this.query(querySql, cusAddrDisQuery, CusAddrDisVO.class);
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Paging<CusAddrDisVO> pagingQueryCusAddrDisVO(Param param, CusAddrDisQuery cusAddrDisQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + cusAddrDisQuery);
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
      Paging<CusAddrDisVO> paging = new Paging<>(param);
      StringBuilder countSql = new StringBuilder(COUNT_SQL);
      if (!ToolUtil.isNullEntityAllFieldValue(cusAddrDisQuery)) {
        this.getExistsSql(cusAddrDisQuery);
        countSql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, cusAddrDisQuery));
      }
      Long count = null;
      if (ToolUtil.isNullEntityAllFieldValue(cusAddrDisQuery)) {
        count = this.queryCount(countSql, Long.class);
      } else {
        count = this.queryCount(countSql, cusAddrDisQuery, Long.class);
      }
      paging.setCount(count);
      if (count > 0) {
        StringBuilder querySql = new StringBuilder(this.getPagingSql(TABLE_NAME, COLUMNS_PARAMETER, PRIMARY_KEY, TABLE_ALIAS));
        if (!ToolUtil.isNullEntityAllFieldValue(cusAddrDisQuery)) {
          querySql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, cusAddrDisQuery));
        }
        querySql.append(this.getPagingSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS, paging));
        Collection<CusAddrDis> cusAddrDisSet = null;
        if (ToolUtil.isNullEntityAllFieldValue(cusAddrDisQuery)) {
          cusAddrDisSet = this.query(querySql, CusAddrDis.class);
        } else {
          cusAddrDisSet = this.query(querySql, cusAddrDisQuery, CusAddrDis.class);
        }
        if (ToolUtil.isNotEmpty(cusAddrDisSet)) {
          Set<String> inCusAddrDisId = new LinkedHashSet<>();
          for (CusAddrDis cusAddrDis : cusAddrDisSet) {
            inCusAddrDisId.add(cusAddrDis.getCusAddrDisId());
          }
          CusAddrDisQuery rCusAddrDisQuery = new CusAddrDisQuery();
          rCusAddrDisQuery.setCusAddrDisIdAndin(new ArrayList<>(inCusAddrDisId));
          Collection<CusAddrDisVO> rCusAddrDisVOSet = this.queryCusAddrDisVO(rCusAddrDisQuery);
          if (ToolUtil.isNotEmpty(rCusAddrDisVOSet)) {
            paging.setData(rCusAddrDisVOSet);
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

  private void getExistsSql(CusAddrDisQuery cusAddrDisQuery) throws Exception {
    try {
      if (ToolUtil.isNotNullStr(cusAddrDisQuery.getToolExists())) {
        if ("NEXUS".equals(cusAddrDisQuery.getToolExists().toUpperCase())) {
          cusAddrDisQuery.setToolExists("SELECT NEXUS_ID FROM NEXUS WHERE NEXUS_ID IS NOT NULL AND ID = " + TABLE_ALIAS + ".ID");
        } else {
          cusAddrDisQuery.setToolExists(null);
        }
      }
      if (ToolUtil.isNotNullStr(cusAddrDisQuery.getToolNotExists())) {
        if ("NEXUS".equals(cusAddrDisQuery.getToolNotExists().toUpperCase())) {
          cusAddrDisQuery.setToolNotExists("SELECT NEXUS_ID FROM NEXUS WHERE NEXUS_ID IS NOT NULL AND ID = " + TABLE_ALIAS + ".ID");
        } else {
          cusAddrDisQuery.setToolNotExists(null);
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
