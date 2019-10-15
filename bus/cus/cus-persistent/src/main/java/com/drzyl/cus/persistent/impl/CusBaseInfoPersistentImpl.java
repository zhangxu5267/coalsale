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
import com.drzyl.cus.entity.CusBaseInfo;
import com.drzyl.cus.persistent.ICusBaseInfoPersistent;
import com.drzyl.cus.query.CusBaseInfoQuery;
import com.drzyl.cus.vo.CusBaseInfoVO;
import lombok.extern.log4j.Log4j2;

/**
 * 客户详细信息 持久化实现
 */
@Log4j2
@Repository("com.drzyl.cus.CusBaseInfoPersistent")
public class CusBaseInfoPersistentImpl extends ToolPersistent implements ICusBaseInfoPersistent {

  public static final String LOG = "CusBaseInfoPersistent";

  public static final String TABLE_ALIAS = "cusBaseInfo";

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
  public CusBaseInfo saveCusBaseInfo(CusBaseInfo cusBaseInfo) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusBaseInfo);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(cusBaseInfo)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      if (ToolUtil.isNullStr(cusBaseInfo.getCusBaseInfoId())) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      this.insert(INSERT_SQL, cusBaseInfo);
      return cusBaseInfo;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<CusBaseInfo> batchSaveCusBaseInfo(Collection<CusBaseInfo> cusBaseInfos) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusBaseInfos);
    }
    try {
      if (ToolUtil.isEmpty(cusBaseInfos)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      this.insert(INSERT_SQL, cusBaseInfos);
      return cusBaseInfos;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public CusBaseInfo updateCusBaseInfo(CusBaseInfo cusBaseInfo) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusBaseInfo);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(cusBaseInfo)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      if (ToolUtil.isNullStr(cusBaseInfo.getCusBaseInfoId())) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      this.update(UPDATE_SQL, cusBaseInfo);
      return cusBaseInfo;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<CusBaseInfo> batchUpdateCusBaseInfo(Collection<CusBaseInfo> cusBaseInfos) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusBaseInfos);
    }
    try {
      if (ToolUtil.isEmpty(cusBaseInfos)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      this.update(UPDATE_SQL, cusBaseInfos);
      return cusBaseInfos;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public void removeCusBaseInfo(CusBaseInfo cusBaseInfo) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusBaseInfo);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(cusBaseInfo)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      if (ToolUtil.isNullStr(cusBaseInfo.getCusBaseInfoId())) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
      if (ToolUtil.isNotEmpty(PRIMARY_KEY) && PRIMARY_KEY.size() == 1) {
        for (String pk : PRIMARY_KEY) {
          mapSqlParameterSource.addValue(pk, cusBaseInfo.getCusBaseInfoId());
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
  public void batchRemoveCusBaseInfo(Collection<CusBaseInfo> cusBaseInfos) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusBaseInfos);
    }
    try {
      if (ToolUtil.isEmpty(cusBaseInfos)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      this.del(DEL_SQL_BY_PK, cusBaseInfos);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Long getCountCusBaseInfo(CusBaseInfoQuery cusBaseInfoQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusBaseInfoQuery);
    }
    try {
      StringBuilder countSql = new StringBuilder(COUNT_SQL);
      if (!ToolUtil.isNullEntityAllFieldValue(cusBaseInfoQuery)) {
        this.getExistsSql(cusBaseInfoQuery);
        countSql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, cusBaseInfoQuery));
      }
      if (ToolUtil.isNullEntityAllFieldValue(cusBaseInfoQuery)) {
        return this.queryCount(countSql, Long.class);
      } else {
        return this.queryCount(countSql, cusBaseInfoQuery, Long.class);
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public CusBaseInfo getCusBaseInfoByPk(String cusBaseInfoId) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusBaseInfoId);
    }
    try {
      if (ToolUtil.isNullStr(cusBaseInfoId)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      StringBuilder querySql = new StringBuilder(SELECT_SQL);
      querySql.append(this.getByPkSql(COLUMNS_PARAMETER, PRIMARY_KEY, TABLE_ALIAS));
      MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
      if (ToolUtil.isNotEmpty(PRIMARY_KEY) && PRIMARY_KEY.size() == 1) {
        for (String pk : PRIMARY_KEY) {
          mapSqlParameterSource.addValue(pk, cusBaseInfoId);
        }
      }
      Collection<CusBaseInfo> cusBaseInfoSet = this.query(querySql, mapSqlParameterSource, CusBaseInfo.class);
      return ToolUtil.isNotEmpty(cusBaseInfoSet) ? cusBaseInfoSet.iterator().next() : null;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<CusBaseInfo> getAllCusBaseInfo() throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
    }
    try {
      StringBuilder querySql = new StringBuilder(SELECT_SQL);
      querySql.append(this.getSortSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS));
      return this.query(querySql, CusBaseInfo.class);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<CusBaseInfo> queryCusBaseInfo(CusBaseInfoQuery cusBaseInfoQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusBaseInfoQuery);
    }
    try {
      StringBuilder querySql = new StringBuilder(SELECT_SQL);
      if (!ToolUtil.isNullEntityAllFieldValue(cusBaseInfoQuery)) {
        this.getExistsSql(cusBaseInfoQuery);
        querySql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, cusBaseInfoQuery));
      }
      querySql.append(this.getSortSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS));
      if (ToolUtil.isNullEntityAllFieldValue(cusBaseInfoQuery)) {
        return this.query(querySql, CusBaseInfo.class);
      } else {
        return this.query(querySql, cusBaseInfoQuery, CusBaseInfo.class);
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Paging<CusBaseInfo> pagingQueryCusBaseInfo(Param param, CusBaseInfoQuery cusBaseInfoQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + cusBaseInfoQuery);
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
      Paging<CusBaseInfo> paging = new Paging<>(param);
      StringBuilder countSql = new StringBuilder(COUNT_SQL);
      if (!ToolUtil.isNullEntityAllFieldValue(cusBaseInfoQuery)) {
        this.getExistsSql(cusBaseInfoQuery);
        countSql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, cusBaseInfoQuery));
      }
      Long count = null;
      if (ToolUtil.isNullEntityAllFieldValue(cusBaseInfoQuery)) {
        count = this.queryCount(countSql, Long.class);
      } else {
        count = this.queryCount(countSql, cusBaseInfoQuery, Long.class);
      }
      paging.setCount(count);
      if (count > 0) {
        StringBuilder querySql = new StringBuilder(this.getPagingSql(TABLE_NAME, COLUMNS_PARAMETER, PRIMARY_KEY, TABLE_ALIAS));
        if (!ToolUtil.isNullEntityAllFieldValue(cusBaseInfoQuery)) {
          querySql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, cusBaseInfoQuery));
        }
        querySql.append(this.getPagingSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS, paging));
        Collection<CusBaseInfo> cusBaseInfoSet = null;
        if (ToolUtil.isNullEntityAllFieldValue(cusBaseInfoQuery)) {
          cusBaseInfoSet = this.query(querySql, CusBaseInfo.class);
        } else {
          cusBaseInfoSet = this.query(querySql, cusBaseInfoQuery, CusBaseInfo.class);
        }
        if (ToolUtil.isNotEmpty(cusBaseInfoSet)) {
          Set<String> inCusBaseInfoId = new LinkedHashSet<>();
          for (CusBaseInfo cusBaseInfo : cusBaseInfoSet) {
            inCusBaseInfoId.add(cusBaseInfo.getCusBaseInfoId());
          }
          CusBaseInfoQuery rCusBaseInfoQuery = new CusBaseInfoQuery();
          rCusBaseInfoQuery.setCusBaseInfoIdAndin(new ArrayList<>(inCusBaseInfoId));
          Collection<CusBaseInfo> rCusBaseInfoSet = this.queryCusBaseInfo(rCusBaseInfoQuery);
          if (ToolUtil.isNotEmpty(rCusBaseInfoSet)) {
            paging.setData(rCusBaseInfoSet);
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
  public CusBaseInfoVO getCusBaseInfoVOByPk(String cusBaseInfoId) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusBaseInfoId);
    }
    try {
      if (ToolUtil.isNullStr(cusBaseInfoId)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      StringBuilder querySql = new StringBuilder(SELECT_VO_SQL);
      querySql.append(this.getByPkSql(COLUMNS_PARAMETER, PRIMARY_KEY, TABLE_ALIAS));
      MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
      if (ToolUtil.isNotEmpty(PRIMARY_KEY) && PRIMARY_KEY.size() == 1) {
        for (String pk : PRIMARY_KEY) {
          mapSqlParameterSource.addValue(pk, cusBaseInfoId);
        }
      }
      Collection<CusBaseInfoVO> cusBaseInfoVOSet = this.query(querySql, mapSqlParameterSource, CusBaseInfoVO.class);
      return ToolUtil.isNotEmpty(cusBaseInfoVOSet) ? cusBaseInfoVOSet.iterator().next() : null;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<CusBaseInfoVO> getAllCusBaseInfoVO() throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
    }
    try {
      StringBuilder querySql = new StringBuilder(SELECT_VO_SQL);
      querySql.append(this.getSortSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS));
      return this.query(querySql, CusBaseInfoVO.class);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<CusBaseInfoVO> queryCusBaseInfoVO(CusBaseInfoQuery cusBaseInfoQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + cusBaseInfoQuery);
    }
    try {
      StringBuilder querySql = new StringBuilder(SELECT_VO_SQL);
      if (!ToolUtil.isNullEntityAllFieldValue(cusBaseInfoQuery)) {
        this.getExistsSql(cusBaseInfoQuery);
        querySql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, cusBaseInfoQuery));
      }
      querySql.append(this.getSortSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS));
      if (ToolUtil.isNullEntityAllFieldValue(cusBaseInfoQuery)) {
        return this.query(querySql, CusBaseInfoVO.class);
      } else {
        return this.query(querySql, cusBaseInfoQuery, CusBaseInfoVO.class);
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Paging<CusBaseInfoVO> pagingQueryCusBaseInfoVO(Param param, CusBaseInfoQuery cusBaseInfoQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + cusBaseInfoQuery);
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
      Paging<CusBaseInfoVO> paging = new Paging<>(param);
      StringBuilder countSql = new StringBuilder(COUNT_SQL);
      if (!ToolUtil.isNullEntityAllFieldValue(cusBaseInfoQuery)) {
        this.getExistsSql(cusBaseInfoQuery);
        countSql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, cusBaseInfoQuery));
      }
      Long count = null;
      if (ToolUtil.isNullEntityAllFieldValue(cusBaseInfoQuery)) {
        count = this.queryCount(countSql, Long.class);
      } else {
        count = this.queryCount(countSql, cusBaseInfoQuery, Long.class);
      }
      paging.setCount(count);
      if (count > 0) {
        StringBuilder querySql = new StringBuilder(this.getPagingSql(TABLE_NAME, COLUMNS_PARAMETER, PRIMARY_KEY, TABLE_ALIAS));
        if (!ToolUtil.isNullEntityAllFieldValue(cusBaseInfoQuery)) {
          querySql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, cusBaseInfoQuery));
        }
        querySql.append(this.getPagingSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS, paging));
        Collection<CusBaseInfo> cusBaseInfoSet = null;
        if (ToolUtil.isNullEntityAllFieldValue(cusBaseInfoQuery)) {
          cusBaseInfoSet = this.query(querySql, CusBaseInfo.class);
        } else {
          cusBaseInfoSet = this.query(querySql, cusBaseInfoQuery, CusBaseInfo.class);
        }
        if (ToolUtil.isNotEmpty(cusBaseInfoSet)) {
          Set<String> inCusBaseInfoId = new LinkedHashSet<>();
          for (CusBaseInfo cusBaseInfo : cusBaseInfoSet) {
            inCusBaseInfoId.add(cusBaseInfo.getCusBaseInfoId());
          }
          CusBaseInfoQuery rCusBaseInfoQuery = new CusBaseInfoQuery();
          rCusBaseInfoQuery.setCusBaseInfoIdAndin(new ArrayList<>(inCusBaseInfoId));
          Collection<CusBaseInfoVO> rCusBaseInfoVOSet = this.queryCusBaseInfoVO(rCusBaseInfoQuery);
          if (ToolUtil.isNotEmpty(rCusBaseInfoVOSet)) {
            paging.setData(rCusBaseInfoVOSet);
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

  private void getExistsSql(CusBaseInfoQuery cusBaseInfoQuery) throws Exception {
    try {
      if (ToolUtil.isNotNullStr(cusBaseInfoQuery.getToolExists())) {
        if ("NEXUS".equals(cusBaseInfoQuery.getToolExists().toUpperCase())) {
          cusBaseInfoQuery.setToolExists("SELECT NEXUS_ID FROM NEXUS WHERE NEXUS_ID IS NOT NULL AND ID = " + TABLE_ALIAS + ".ID");
        } else {
          cusBaseInfoQuery.setToolExists(null);
        }
      }
      if (ToolUtil.isNotNullStr(cusBaseInfoQuery.getToolNotExists())) {
        if ("NEXUS".equals(cusBaseInfoQuery.getToolNotExists().toUpperCase())) {
          cusBaseInfoQuery.setToolNotExists("SELECT NEXUS_ID FROM NEXUS WHERE NEXUS_ID IS NOT NULL AND ID = " + TABLE_ALIAS + ".ID");
        } else {
          cusBaseInfoQuery.setToolNotExists(null);
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
