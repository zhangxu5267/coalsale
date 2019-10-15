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
import com.drzyl.cus.entity.CusTagTemp;
import com.drzyl.cus.persistent.ICusTagTempPersistent;
import com.drzyl.cus.query.CusTagTempQuery;
import com.drzyl.cus.vo.CusTagTempVO;
import lombok.extern.log4j.Log4j2;

/**
 * 客户标签中间表 持久化实现
 */
@Log4j2
@Repository("com.drzyl.cus.CusTagTempPersistent")
public class CusTagTempPersistentImpl extends ToolPersistent implements ICusTagTempPersistent {

  public static final String LOG = "CusTagTempPersistent";

  public static final String TABLE_ALIAS = "cusTagTemp";

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
  public CusTagTemp saveCusTagTemp(CusTagTemp cusTagTemp) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusTagTemp);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(cusTagTemp)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      if (ToolUtil.isNullStr(cusTagTemp.getCusTagTempId())) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      this.insert(INSERT_SQL, cusTagTemp);
      return cusTagTemp;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<CusTagTemp> batchSaveCusTagTemp(Collection<CusTagTemp> cusTagTemps) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusTagTemps);
    }
    try {
      if (ToolUtil.isEmpty(cusTagTemps)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      this.insert(INSERT_SQL, cusTagTemps);
      return cusTagTemps;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public CusTagTemp updateCusTagTemp(CusTagTemp cusTagTemp) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusTagTemp);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(cusTagTemp)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      if (ToolUtil.isNullStr(cusTagTemp.getCusTagTempId())) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      this.update(UPDATE_SQL, cusTagTemp);
      return cusTagTemp;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<CusTagTemp> batchUpdateCusTagTemp(Collection<CusTagTemp> cusTagTemps) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusTagTemps);
    }
    try {
      if (ToolUtil.isEmpty(cusTagTemps)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      this.update(UPDATE_SQL, cusTagTemps);
      return cusTagTemps;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public void removeCusTagTemp(CusTagTemp cusTagTemp) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusTagTemp);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(cusTagTemp)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      if (ToolUtil.isNullStr(cusTagTemp.getCusTagTempId())) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
      if (ToolUtil.isNotEmpty(PRIMARY_KEY) && PRIMARY_KEY.size() == 1) {
        for (String pk : PRIMARY_KEY) {
          mapSqlParameterSource.addValue(pk, cusTagTemp.getCusTagTempId());
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
  public void batchRemoveCusTagTemp(Collection<CusTagTemp> cusTagTemps) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusTagTemps);
    }
    try {
      if (ToolUtil.isEmpty(cusTagTemps)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      this.del(DEL_SQL_BY_PK, cusTagTemps);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Long getCountCusTagTemp(CusTagTempQuery cusTagTempQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusTagTempQuery);
    }
    try {
      StringBuilder countSql = new StringBuilder(COUNT_SQL);
      if (!ToolUtil.isNullEntityAllFieldValue(cusTagTempQuery)) {
        this.getExistsSql(cusTagTempQuery);
        countSql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, cusTagTempQuery));
      }
      if (ToolUtil.isNullEntityAllFieldValue(cusTagTempQuery)) {
        return this.queryCount(countSql, Long.class);
      } else {
        return this.queryCount(countSql, cusTagTempQuery, Long.class);
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public CusTagTemp getCusTagTempByPk(String cusTagTempId) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusTagTempId);
    }
    try {
      if (ToolUtil.isNullStr(cusTagTempId)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      StringBuilder querySql = new StringBuilder(SELECT_SQL);
      querySql.append(this.getByPkSql(COLUMNS_PARAMETER, PRIMARY_KEY, TABLE_ALIAS));
      MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
      if (ToolUtil.isNotEmpty(PRIMARY_KEY) && PRIMARY_KEY.size() == 1) {
        for (String pk : PRIMARY_KEY) {
          mapSqlParameterSource.addValue(pk, cusTagTempId);
        }
      }
      Collection<CusTagTemp> cusTagTempSet = this.query(querySql, mapSqlParameterSource, CusTagTemp.class);
      return ToolUtil.isNotEmpty(cusTagTempSet) ? cusTagTempSet.iterator().next() : null;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<CusTagTemp> getAllCusTagTemp() throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
    }
    try {
      StringBuilder querySql = new StringBuilder(SELECT_SQL);
      querySql.append(this.getSortSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS));
      return this.query(querySql, CusTagTemp.class);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<CusTagTemp> queryCusTagTemp(CusTagTempQuery cusTagTempQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusTagTempQuery);
    }
    try {
      StringBuilder querySql = new StringBuilder(SELECT_SQL);
      if (!ToolUtil.isNullEntityAllFieldValue(cusTagTempQuery)) {
        this.getExistsSql(cusTagTempQuery);
        querySql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, cusTagTempQuery));
      }
      querySql.append(this.getSortSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS));
      if (ToolUtil.isNullEntityAllFieldValue(cusTagTempQuery)) {
        return this.query(querySql, CusTagTemp.class);
      } else {
        return this.query(querySql, cusTagTempQuery, CusTagTemp.class);
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Paging<CusTagTemp> pagingQueryCusTagTemp(Param param, CusTagTempQuery cusTagTempQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + cusTagTempQuery);
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
      Paging<CusTagTemp> paging = new Paging<>(param);
      StringBuilder countSql = new StringBuilder(COUNT_SQL);
      if (!ToolUtil.isNullEntityAllFieldValue(cusTagTempQuery)) {
        this.getExistsSql(cusTagTempQuery);
        countSql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, cusTagTempQuery));
      }
      Long count = null;
      if (ToolUtil.isNullEntityAllFieldValue(cusTagTempQuery)) {
        count = this.queryCount(countSql, Long.class);
      } else {
        count = this.queryCount(countSql, cusTagTempQuery, Long.class);
      }
      paging.setCount(count);
      if (count > 0) {
        StringBuilder querySql = new StringBuilder(this.getPagingSql(TABLE_NAME, COLUMNS_PARAMETER, PRIMARY_KEY, TABLE_ALIAS));
        if (!ToolUtil.isNullEntityAllFieldValue(cusTagTempQuery)) {
          querySql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, cusTagTempQuery));
        }
        querySql.append(this.getPagingSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS, paging));
        Collection<CusTagTemp> cusTagTempSet = null;
        if (ToolUtil.isNullEntityAllFieldValue(cusTagTempQuery)) {
          cusTagTempSet = this.query(querySql, CusTagTemp.class);
        } else {
          cusTagTempSet = this.query(querySql, cusTagTempQuery, CusTagTemp.class);
        }
        if (ToolUtil.isNotEmpty(cusTagTempSet)) {
          Set<String> inCusTagTempId = new LinkedHashSet<>();
          for (CusTagTemp cusTagTemp : cusTagTempSet) {
            inCusTagTempId.add(cusTagTemp.getCusTagTempId());
          }
          CusTagTempQuery rCusTagTempQuery = new CusTagTempQuery();
          rCusTagTempQuery.setCusTagTempIdAndin(new ArrayList<>(inCusTagTempId));
          Collection<CusTagTemp> rCusTagTempSet = this.queryCusTagTemp(rCusTagTempQuery);
          if (ToolUtil.isNotEmpty(rCusTagTempSet)) {
            paging.setData(rCusTagTempSet);
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
  public CusTagTempVO getCusTagTempVOByPk(String cusTagTempId) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusTagTempId);
    }
    try {
      if (ToolUtil.isNullStr(cusTagTempId)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      StringBuilder querySql = new StringBuilder(SELECT_VO_SQL);
      querySql.append(this.getByPkSql(COLUMNS_PARAMETER, PRIMARY_KEY, TABLE_ALIAS));
      MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
      if (ToolUtil.isNotEmpty(PRIMARY_KEY) && PRIMARY_KEY.size() == 1) {
        for (String pk : PRIMARY_KEY) {
          mapSqlParameterSource.addValue(pk, cusTagTempId);
        }
      }
      Collection<CusTagTempVO> cusTagTempVOSet = this.query(querySql, mapSqlParameterSource, CusTagTempVO.class);
      return ToolUtil.isNotEmpty(cusTagTempVOSet) ? cusTagTempVOSet.iterator().next() : null;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<CusTagTempVO> getAllCusTagTempVO() throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
    }
    try {
      StringBuilder querySql = new StringBuilder(SELECT_VO_SQL);
      querySql.append(this.getSortSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS));
      return this.query(querySql, CusTagTempVO.class);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<CusTagTempVO> queryCusTagTempVO(CusTagTempQuery cusTagTempQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusTagTempQuery);
    }
    try {
      StringBuilder querySql = new StringBuilder(SELECT_VO_SQL);
      if (!ToolUtil.isNullEntityAllFieldValue(cusTagTempQuery)) {
        this.getExistsSql(cusTagTempQuery);
        querySql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, cusTagTempQuery));
      }
      querySql.append(this.getSortSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS));
      if (ToolUtil.isNullEntityAllFieldValue(cusTagTempQuery)) {
        return this.query(querySql, CusTagTempVO.class);
      } else {
        return this.query(querySql, cusTagTempQuery, CusTagTempVO.class);
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Paging<CusTagTempVO> pagingQueryCusTagTempVO(Param param, CusTagTempQuery cusTagTempQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + cusTagTempQuery);
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
      Paging<CusTagTempVO> paging = new Paging<>(param);
      StringBuilder countSql = new StringBuilder(COUNT_SQL);
      if (!ToolUtil.isNullEntityAllFieldValue(cusTagTempQuery)) {
        this.getExistsSql(cusTagTempQuery);
        countSql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, cusTagTempQuery));
      }
      Long count = null;
      if (ToolUtil.isNullEntityAllFieldValue(cusTagTempQuery)) {
        count = this.queryCount(countSql, Long.class);
      } else {
        count = this.queryCount(countSql, cusTagTempQuery, Long.class);
      }
      paging.setCount(count);
      if (count > 0) {
        StringBuilder querySql = new StringBuilder(this.getPagingSql(TABLE_NAME, COLUMNS_PARAMETER, PRIMARY_KEY, TABLE_ALIAS));
        if (!ToolUtil.isNullEntityAllFieldValue(cusTagTempQuery)) {
          querySql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, cusTagTempQuery));
        }
        querySql.append(this.getPagingSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS, paging));
        Collection<CusTagTemp> cusTagTempSet = null;
        if (ToolUtil.isNullEntityAllFieldValue(cusTagTempQuery)) {
          cusTagTempSet = this.query(querySql, CusTagTemp.class);
        } else {
          cusTagTempSet = this.query(querySql, cusTagTempQuery, CusTagTemp.class);
        }
        if (ToolUtil.isNotEmpty(cusTagTempSet)) {
          Set<String> inCusTagTempId = new LinkedHashSet<>();
          for (CusTagTemp cusTagTemp : cusTagTempSet) {
            inCusTagTempId.add(cusTagTemp.getCusTagTempId());
          }
          CusTagTempQuery rCusTagTempQuery = new CusTagTempQuery();
          rCusTagTempQuery.setCusTagTempIdAndin(new ArrayList<>(inCusTagTempId));
          Collection<CusTagTempVO> rCusTagTempVOSet = this.queryCusTagTempVO(rCusTagTempQuery);
          if (ToolUtil.isNotEmpty(rCusTagTempVOSet)) {
            paging.setData(rCusTagTempVOSet);
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

  private void getExistsSql(CusTagTempQuery cusTagTempQuery) throws Exception {
    try {
      if (ToolUtil.isNotNullStr(cusTagTempQuery.getToolExists())) {
        if ("NEXUS".equals(cusTagTempQuery.getToolExists().toUpperCase())) {
          cusTagTempQuery.setToolExists("SELECT NEXUS_ID FROM NEXUS WHERE NEXUS_ID IS NOT NULL AND ID = " + TABLE_ALIAS + ".ID");
        } else {
          cusTagTempQuery.setToolExists(null);
        }
      }
      if (ToolUtil.isNotNullStr(cusTagTempQuery.getToolNotExists())) {
        if ("NEXUS".equals(cusTagTempQuery.getToolNotExists().toUpperCase())) {
          cusTagTempQuery.setToolNotExists("SELECT NEXUS_ID FROM NEXUS WHERE NEXUS_ID IS NOT NULL AND ID = " + TABLE_ALIAS + ".ID");
        } else {
          cusTagTempQuery.setToolNotExists(null);
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
