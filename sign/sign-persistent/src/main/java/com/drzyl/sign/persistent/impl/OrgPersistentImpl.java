package com.drzyl.sign.persistent.impl;

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
import com.drzyl.sign.entity.Org;
import com.drzyl.sign.persistent.IOrgPersistent;
import com.drzyl.sign.query.OrgQuery;
import com.drzyl.sign.vo.OrgVO;
import lombok.extern.log4j.Log4j2;

/**
 * 组织机构 持久化实现
 */
@Log4j2
@Repository("com.drzyl.sign.OrgPersistent")
public class OrgPersistentImpl extends ToolPersistent implements IOrgPersistent {

  public static final String LOG = "OrgPersistent";

  public static final String TABLE_ALIAS = "org";

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
  public Org saveOrg(Org org) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + org);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(org)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      if (ToolUtil.isNullStr(org.getOrgId())) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      this.insert(INSERT_SQL, org);
      return org;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<Org> batchSaveOrg(Collection<Org> orgs) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + orgs);
    }
    try {
      if (ToolUtil.isEmpty(orgs)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      this.insert(INSERT_SQL, orgs);
      return orgs;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Org updateOrg(Org org) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + org);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(org)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      if (ToolUtil.isNullStr(org.getOrgId())) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      this.update(UPDATE_SQL, org);
      return org;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<Org> batchUpdateOrg(Collection<Org> orgs) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + orgs);
    }
    try {
      if (ToolUtil.isEmpty(orgs)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      this.update(UPDATE_SQL, orgs);
      return orgs;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public void removeOrg(Org org) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + org);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(org)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      if (ToolUtil.isNullStr(org.getOrgId())) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
      if (ToolUtil.isNotEmpty(PRIMARY_KEY) && PRIMARY_KEY.size() == 1) {
        for (String pk : PRIMARY_KEY) {
          mapSqlParameterSource.addValue(pk, org.getOrgId());
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
  public void batchRemoveOrg(Collection<Org> orgs) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + orgs);
    }
    try {
      if (ToolUtil.isEmpty(orgs)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      this.del(DEL_SQL_BY_PK, orgs);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Long getCountOrg(OrgQuery orgQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + orgQuery);
    }
    try {
      StringBuilder countSql = new StringBuilder(COUNT_SQL);
      if (!ToolUtil.isNullEntityAllFieldValue(orgQuery)) {
        this.getExistsSql(orgQuery);
        countSql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, orgQuery));
      }
      if (ToolUtil.isNullEntityAllFieldValue(orgQuery)) {
        return this.queryCount(countSql, Long.class);
      } else {
        return this.queryCount(countSql, orgQuery, Long.class);
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Org getOrgByPk(String orgId) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + orgId);
    }
    try {
      if (ToolUtil.isNullStr(orgId)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      StringBuilder querySql = new StringBuilder(SELECT_SQL);
      querySql.append(this.getByPkSql(COLUMNS_PARAMETER, PRIMARY_KEY, TABLE_ALIAS));
      MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
      if (ToolUtil.isNotEmpty(PRIMARY_KEY) && PRIMARY_KEY.size() == 1) {
        for (String pk : PRIMARY_KEY) {
          mapSqlParameterSource.addValue(pk, orgId);
        }
      }
      Collection<Org> orgSet = this.query(querySql, mapSqlParameterSource, Org.class);
      return ToolUtil.isNotEmpty(orgSet) ? orgSet.iterator().next() : null;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<Org> getAllOrg() throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
    }
    try {
      StringBuilder querySql = new StringBuilder(SELECT_SQL);
      querySql.append(this.getSortSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS));
      return this.query(querySql, Org.class);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<Org> queryOrg(OrgQuery orgQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + orgQuery);
    }
    try {
      StringBuilder querySql = new StringBuilder(SELECT_SQL);
      if (!ToolUtil.isNullEntityAllFieldValue(orgQuery)) {
        this.getExistsSql(orgQuery);
        querySql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, orgQuery));
      }
      querySql.append(this.getSortSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS));
      if (ToolUtil.isNullEntityAllFieldValue(orgQuery)) {
        return this.query(querySql, Org.class);
      } else {
        return this.query(querySql, orgQuery, Org.class);
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Paging<Org> pagingQueryOrg(Param param, OrgQuery orgQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + orgQuery);
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
      Paging<Org> paging = new Paging<>(param);
      StringBuilder countSql = new StringBuilder(COUNT_SQL);
      if (!ToolUtil.isNullEntityAllFieldValue(orgQuery)) {
        this.getExistsSql(orgQuery);
        countSql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, orgQuery));
      }
      Long count = null;
      if (ToolUtil.isNullEntityAllFieldValue(orgQuery)) {
        count = this.queryCount(countSql, Long.class);
      } else {
        count = this.queryCount(countSql, orgQuery, Long.class);
      }
      paging.setCount(count);
      if (count > 0) {
        StringBuilder querySql = new StringBuilder(this.getPagingSql(TABLE_NAME, COLUMNS_PARAMETER, PRIMARY_KEY, TABLE_ALIAS));
        if (!ToolUtil.isNullEntityAllFieldValue(orgQuery)) {
          querySql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, orgQuery));
        }
        querySql.append(this.getPagingSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS, paging));
        Collection<Org> orgSet = null;
        if (ToolUtil.isNullEntityAllFieldValue(orgQuery)) {
          orgSet = this.query(querySql, Org.class);
        } else {
          orgSet = this.query(querySql, orgQuery, Org.class);
        }
        if (ToolUtil.isNotEmpty(orgSet)) {
          Set<String> inOrgId = new LinkedHashSet<>();
          for (Org org : orgSet) {
            inOrgId.add(org.getOrgId());
          }
          OrgQuery rOrgQuery = new OrgQuery();
          rOrgQuery.setOrgIdAndin(new ArrayList<>(inOrgId));
          Collection<Org> rOrgSet = this.queryOrg(rOrgQuery);
          if (ToolUtil.isNotEmpty(rOrgSet)) {
            paging.setData(rOrgSet);
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
  public OrgVO getOrgVOByPk(String orgId) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + orgId);
    }
    try {
      if (ToolUtil.isNullStr(orgId)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      StringBuilder querySql = new StringBuilder(SELECT_VO_SQL);
      querySql.append(this.getByPkSql(COLUMNS_PARAMETER, PRIMARY_KEY, TABLE_ALIAS));
      MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
      if (ToolUtil.isNotEmpty(PRIMARY_KEY) && PRIMARY_KEY.size() == 1) {
        for (String pk : PRIMARY_KEY) {
          mapSqlParameterSource.addValue(pk, orgId);
        }
      }
      Collection<OrgVO> orgVOSet = this.query(querySql, mapSqlParameterSource, OrgVO.class);
      return ToolUtil.isNotEmpty(orgVOSet) ? orgVOSet.iterator().next() : null;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<OrgVO> getAllOrgVO() throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
    }
    try {
      StringBuilder querySql = new StringBuilder(SELECT_VO_SQL);
      querySql.append(this.getSortSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS));
      return this.query(querySql, OrgVO.class);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<OrgVO> queryOrgVO(OrgQuery orgQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + orgQuery);
    }
    try {
      StringBuilder querySql = new StringBuilder(SELECT_VO_SQL);
      if (!ToolUtil.isNullEntityAllFieldValue(orgQuery)) {
        this.getExistsSql(orgQuery);
        querySql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, orgQuery));
      }
      querySql.append(this.getSortSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS));
      if (ToolUtil.isNullEntityAllFieldValue(orgQuery)) {
        return this.query(querySql, OrgVO.class);
      } else {
        return this.query(querySql, orgQuery, OrgVO.class);
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Paging<OrgVO> pagingQueryOrgVO(Param param, OrgQuery orgQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + orgQuery);
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
      Paging<OrgVO> paging = new Paging<>(param);
      StringBuilder countSql = new StringBuilder(COUNT_SQL);
      if (!ToolUtil.isNullEntityAllFieldValue(orgQuery)) {
        this.getExistsSql(orgQuery);
        countSql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, orgQuery));
      }
      Long count = null;
      if (ToolUtil.isNullEntityAllFieldValue(orgQuery)) {
        count = this.queryCount(countSql, Long.class);
      } else {
        count = this.queryCount(countSql, orgQuery, Long.class);
      }
      paging.setCount(count);
      if (count > 0) {
        StringBuilder querySql = new StringBuilder(this.getPagingSql(TABLE_NAME, COLUMNS_PARAMETER, PRIMARY_KEY, TABLE_ALIAS));
        if (!ToolUtil.isNullEntityAllFieldValue(orgQuery)) {
          querySql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, orgQuery));
        }
        querySql.append(this.getPagingSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS, paging));
        Collection<Org> orgSet = null;
        if (ToolUtil.isNullEntityAllFieldValue(orgQuery)) {
          orgSet = this.query(querySql, Org.class);
        } else {
          orgSet = this.query(querySql, orgQuery, Org.class);
        }
        if (ToolUtil.isNotEmpty(orgSet)) {
          Set<String> inOrgId = new LinkedHashSet<>();
          for (Org org : orgSet) {
            inOrgId.add(org.getOrgId());
          }
          OrgQuery rOrgQuery = new OrgQuery();
          rOrgQuery.setOrgIdAndin(new ArrayList<>(inOrgId));
          Collection<OrgVO> rOrgVOSet = this.queryOrgVO(rOrgQuery);
          if (ToolUtil.isNotEmpty(rOrgVOSet)) {
            paging.setData(rOrgVOSet);
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

  private void getExistsSql(OrgQuery orgQuery) throws Exception {
    try {
      if (ToolUtil.isNotNullStr(orgQuery.getToolExists())) {
        if ("NEXUS".equals(orgQuery.getToolExists().toUpperCase())) {
          orgQuery.setToolExists("SELECT NEXUS_ID FROM NEXUS WHERE NEXUS_ID IS NOT NULL AND ID = " + TABLE_ALIAS + ".ID");
        } else {
          orgQuery.setToolExists(null);
        }
      }
      if (ToolUtil.isNotNullStr(orgQuery.getToolNotExists())) {
        if ("NEXUS".equals(orgQuery.getToolNotExists().toUpperCase())) {
          orgQuery.setToolNotExists("SELECT NEXUS_ID FROM NEXUS WHERE NEXUS_ID IS NOT NULL AND ID = " + TABLE_ALIAS + ".ID");
        } else {
          orgQuery.setToolNotExists(null);
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
