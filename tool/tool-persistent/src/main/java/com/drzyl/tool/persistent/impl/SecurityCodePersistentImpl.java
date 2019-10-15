package com.drzyl.tool.persistent.impl;


import com.drzyl.tool.entity.SecurityCode;
import com.drzyl.tool.exception.ToolException;
import com.drzyl.tool.persistent.ISecurityCodePersistent;
import com.drzyl.tool.query.SecurityCodeQuery;
import com.drzyl.tool.util.Paging;
import com.drzyl.tool.util.Param;
import com.drzyl.tool.util.ToolUtil;
import com.drzyl.tool.vo.SecurityCodeVO;
import lombok.extern.log4j.Log4j2;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;

/**
 * 短信验证码 持久化实现
 */
@Log4j2
@Repository("com.drzyl.sms.SecurityCodePersistent")
public class SecurityCodePersistentImpl extends ToolPersistent implements ISecurityCodePersistent {

  public static final String LOG = "SecurityCodePersistent";

  public static final String TABLE_ALIAS = "securityCode";

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
  public SecurityCode saveSecurityCode(SecurityCode securityCode) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + securityCode);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(securityCode)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      if (ToolUtil.isNullStr(securityCode.getId())) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      this.insert(INSERT_SQL, securityCode);
      return securityCode;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<SecurityCode> batchSaveSecurityCode(Collection<SecurityCode> securityCodes) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + securityCodes);
    }
    try {
      if (ToolUtil.isEmpty(securityCodes)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      this.insert(INSERT_SQL, securityCodes);
      return securityCodes;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public SecurityCode updateSecurityCode(SecurityCode securityCode) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + securityCode);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(securityCode)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      if (ToolUtil.isNullStr(securityCode.getId())) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      this.update(UPDATE_SQL, securityCode);
      return securityCode;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<SecurityCode> batchUpdateSecurityCode(Collection<SecurityCode> securityCodes) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + securityCodes);
    }
    try {
      if (ToolUtil.isEmpty(securityCodes)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      this.update(UPDATE_SQL, securityCodes);
      return securityCodes;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public void removeSecurityCode(SecurityCode securityCode) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + securityCode);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(securityCode)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      if (ToolUtil.isNullStr(securityCode.getId())) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
      if (ToolUtil.isNotEmpty(PRIMARY_KEY) && PRIMARY_KEY.size() == 1) {
        for (String pk : PRIMARY_KEY) {
          mapSqlParameterSource.addValue(pk, securityCode.getId());
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
  public void batchRemoveSecurityCode(Collection<SecurityCode> securityCodes) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + securityCodes);
    }
    try {
      if (ToolUtil.isEmpty(securityCodes)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      this.del(DEL_SQL_BY_PK, securityCodes);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Long getCountSecurityCode(SecurityCodeQuery securityCodeQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + securityCodeQuery);
    }
    try {
      StringBuilder countSql = new StringBuilder(COUNT_SQL);
      if (!ToolUtil.isNullEntityAllFieldValue(securityCodeQuery)) {
        this.getExistsSql(securityCodeQuery);
        countSql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, securityCodeQuery));
      }
      if (ToolUtil.isNullEntityAllFieldValue(securityCodeQuery)) {
        return this.queryCount(countSql, Long.class);
      } else {
        return this.queryCount(countSql, securityCodeQuery, Long.class);
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public SecurityCode getSecurityCodeByPk(String id) throws Exception {
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
      Collection<SecurityCode> securityCodeSet = this.query(querySql, mapSqlParameterSource, SecurityCode.class);
      return ToolUtil.isNotEmpty(securityCodeSet) ? securityCodeSet.iterator().next() : null;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<SecurityCode> getAllSecurityCode() throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
    }
    try {
      StringBuilder querySql = new StringBuilder(SELECT_SQL);
      querySql.append(this.getSortSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS));
      return this.query(querySql, SecurityCode.class);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<SecurityCode> querySecurityCode(SecurityCodeQuery securityCodeQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + securityCodeQuery);
    }
    try {
      StringBuilder querySql = new StringBuilder(SELECT_SQL);
      if (!ToolUtil.isNullEntityAllFieldValue(securityCodeQuery)) {
        this.getExistsSql(securityCodeQuery);
        querySql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, securityCodeQuery));
      }
      querySql.append(this.getSortSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS));
      if (ToolUtil.isNullEntityAllFieldValue(securityCodeQuery)) {
        return this.query(querySql, SecurityCode.class);
      } else {
        return this.query(querySql, securityCodeQuery, SecurityCode.class);
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Paging<SecurityCode> pagingQuerySecurityCode(Param param, SecurityCodeQuery securityCodeQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + securityCodeQuery);
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
      Paging<SecurityCode> paging = new Paging<>(param);
      StringBuilder countSql = new StringBuilder(COUNT_SQL);
      if (!ToolUtil.isNullEntityAllFieldValue(securityCodeQuery)) {
        this.getExistsSql(securityCodeQuery);
        countSql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, securityCodeQuery));
      }
      Long count = null;
      if (ToolUtil.isNullEntityAllFieldValue(securityCodeQuery)) {
        count = this.queryCount(countSql, Long.class);
      } else {
        count = this.queryCount(countSql, securityCodeQuery, Long.class);
      }
      paging.setCount(count);
      if (count > 0) {
        StringBuilder querySql = new StringBuilder(this.getPagingSql(TABLE_NAME, COLUMNS_PARAMETER, PRIMARY_KEY, TABLE_ALIAS));
        if (!ToolUtil.isNullEntityAllFieldValue(securityCodeQuery)) {
          querySql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, securityCodeQuery));
        }
        querySql.append(this.getPagingSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS, paging));
        Collection<SecurityCode> securityCodeSet = null;
        if (ToolUtil.isNullEntityAllFieldValue(securityCodeQuery)) {
          securityCodeSet = this.query(querySql, SecurityCode.class);
        } else {
          securityCodeSet = this.query(querySql, securityCodeQuery, SecurityCode.class);
        }
        if (ToolUtil.isNotEmpty(securityCodeSet)) {
          Set<String> inId = new LinkedHashSet<>();
          for (SecurityCode securityCode : securityCodeSet) {
            inId.add(securityCode.getId());
          }
          SecurityCodeQuery rSecurityCodeQuery = new SecurityCodeQuery();
          rSecurityCodeQuery.setIdAndin(new ArrayList<>(inId));
          Collection<SecurityCode> rSecurityCodeSet = this.querySecurityCode(rSecurityCodeQuery);
          if (ToolUtil.isNotEmpty(rSecurityCodeSet)) {
            paging.setData(rSecurityCodeSet);
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
  public SecurityCodeVO getSecurityCodeVOByPk(String id) throws Exception {
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
      Collection<SecurityCodeVO> securityCodeVOSet = this.query(querySql, mapSqlParameterSource, SecurityCodeVO.class);
      return ToolUtil.isNotEmpty(securityCodeVOSet) ? securityCodeVOSet.iterator().next() : null;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<SecurityCodeVO> getAllSecurityCodeVO() throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
    }
    try {
      StringBuilder querySql = new StringBuilder(SELECT_VO_SQL);
      querySql.append(this.getSortSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS));
      return this.query(querySql, SecurityCodeVO.class);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<SecurityCodeVO> querySecurityCodeVO(SecurityCodeQuery securityCodeQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + securityCodeQuery);
    }
    try {
      StringBuilder querySql = new StringBuilder(SELECT_VO_SQL);
      if (!ToolUtil.isNullEntityAllFieldValue(securityCodeQuery)) {
        this.getExistsSql(securityCodeQuery);
        querySql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, securityCodeQuery));
      }
      querySql.append(this.getSortSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS));
      if (ToolUtil.isNullEntityAllFieldValue(securityCodeQuery)) {
        return this.query(querySql, SecurityCodeVO.class);
      } else {
        return this.query(querySql, securityCodeQuery, SecurityCodeVO.class);
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Paging<SecurityCodeVO> pagingQuerySecurityCodeVO(Param param, SecurityCodeQuery securityCodeQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + securityCodeQuery);
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
      Paging<SecurityCodeVO> paging = new Paging<>(param);
      StringBuilder countSql = new StringBuilder(COUNT_SQL);
      if (!ToolUtil.isNullEntityAllFieldValue(securityCodeQuery)) {
        this.getExistsSql(securityCodeQuery);
        countSql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, securityCodeQuery));
      }
      Long count = null;
      if (ToolUtil.isNullEntityAllFieldValue(securityCodeQuery)) {
        count = this.queryCount(countSql, Long.class);
      } else {
        count = this.queryCount(countSql, securityCodeQuery, Long.class);
      }
      paging.setCount(count);
      if (count > 0) {
        StringBuilder querySql = new StringBuilder(this.getPagingSql(TABLE_NAME, COLUMNS_PARAMETER, PRIMARY_KEY, TABLE_ALIAS));
        if (!ToolUtil.isNullEntityAllFieldValue(securityCodeQuery)) {
          querySql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, securityCodeQuery));
        }
        querySql.append(this.getPagingSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS, paging));
        Collection<SecurityCode> securityCodeSet = null;
        if (ToolUtil.isNullEntityAllFieldValue(securityCodeQuery)) {
          securityCodeSet = this.query(querySql, SecurityCode.class);
        } else {
          securityCodeSet = this.query(querySql, securityCodeQuery, SecurityCode.class);
        }
        if (ToolUtil.isNotEmpty(securityCodeSet)) {
          Set<String> inId = new LinkedHashSet<>();
          for (SecurityCode securityCode : securityCodeSet) {
            inId.add(securityCode.getId());
          }
          SecurityCodeQuery rSecurityCodeQuery = new SecurityCodeQuery();
          rSecurityCodeQuery.setIdAndin(new ArrayList<>(inId));
          Collection<SecurityCodeVO> rSecurityCodeVOSet = this.querySecurityCodeVO(rSecurityCodeQuery);
          if (ToolUtil.isNotEmpty(rSecurityCodeVOSet)) {
            paging.setData(rSecurityCodeVOSet);
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

  private void getExistsSql(SecurityCodeQuery securityCodeQuery) throws Exception {
    try {
      if (ToolUtil.isNotNullStr(securityCodeQuery.getToolExists())) {
        if ("NEXUS".equals(securityCodeQuery.getToolExists().toUpperCase())) {
          securityCodeQuery.setToolExists("SELECT NEXUS_ID FROM NEXUS WHERE NEXUS_ID IS NOT NULL AND ID = " + TABLE_ALIAS + ".ID");
        } else {
          securityCodeQuery.setToolExists(null);
        }
      }
      if (ToolUtil.isNotNullStr(securityCodeQuery.getToolNotExists())) {
        if ("NEXUS".equals(securityCodeQuery.getToolNotExists().toUpperCase())) {
          securityCodeQuery.setToolNotExists("SELECT NEXUS_ID FROM NEXUS WHERE NEXUS_ID IS NOT NULL AND ID = " + TABLE_ALIAS + ".ID");
        } else {
          securityCodeQuery.setToolNotExists(null);
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
