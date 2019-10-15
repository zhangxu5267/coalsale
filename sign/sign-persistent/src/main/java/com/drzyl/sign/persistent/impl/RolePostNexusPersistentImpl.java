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
import com.drzyl.sign.entity.RolePostNexus;
import com.drzyl.sign.persistent.IRolePostNexusPersistent;
import com.drzyl.sign.query.RolePostNexusQuery;
import com.drzyl.sign.vo.RolePostNexusVO;
import lombok.extern.log4j.Log4j2;

/**
 * 角色岗位 持久化实现
 */
@Log4j2
@Repository("com.drzyl.sign.RolePostNexusPersistent")
public class RolePostNexusPersistentImpl extends ToolPersistent implements IRolePostNexusPersistent {

  public static final String LOG = "RolePostNexusPersistent";

  public static final String TABLE_ALIAS = "rolePostNexus";

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
  public RolePostNexus saveRolePostNexus(RolePostNexus rolePostNexus) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + rolePostNexus);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(rolePostNexus)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      if (ToolUtil.isNullStr(rolePostNexus.getNexusId())) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      this.insert(INSERT_SQL, rolePostNexus);
      return rolePostNexus;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<RolePostNexus> batchSaveRolePostNexus(Collection<RolePostNexus> rolePostNexuss) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + rolePostNexuss);
    }
    try {
      if (ToolUtil.isEmpty(rolePostNexuss)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      this.insert(INSERT_SQL, rolePostNexuss);
      return rolePostNexuss;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public RolePostNexus updateRolePostNexus(RolePostNexus rolePostNexus) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + rolePostNexus);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(rolePostNexus)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      if (ToolUtil.isNullStr(rolePostNexus.getNexusId())) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      this.update(UPDATE_SQL, rolePostNexus);
      return rolePostNexus;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<RolePostNexus> batchUpdateRolePostNexus(Collection<RolePostNexus> rolePostNexuss) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + rolePostNexuss);
    }
    try {
      if (ToolUtil.isEmpty(rolePostNexuss)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      this.update(UPDATE_SQL, rolePostNexuss);
      return rolePostNexuss;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public void removeRolePostNexus(RolePostNexus rolePostNexus) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + rolePostNexus);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(rolePostNexus)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      if (ToolUtil.isNullStr(rolePostNexus.getNexusId())) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
      if (ToolUtil.isNotEmpty(PRIMARY_KEY) && PRIMARY_KEY.size() == 1) {
        for (String pk : PRIMARY_KEY) {
          mapSqlParameterSource.addValue(pk, rolePostNexus.getNexusId());
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
  public void batchRemoveRolePostNexus(Collection<RolePostNexus> rolePostNexuss) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + rolePostNexuss);
    }
    try {
      if (ToolUtil.isEmpty(rolePostNexuss)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      this.del(DEL_SQL_BY_PK, rolePostNexuss);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Long getCountRolePostNexus(RolePostNexusQuery rolePostNexusQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + rolePostNexusQuery);
    }
    try {
      StringBuilder countSql = new StringBuilder(COUNT_SQL);
      if (!ToolUtil.isNullEntityAllFieldValue(rolePostNexusQuery)) {
        this.getExistsSql(rolePostNexusQuery);
        countSql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, rolePostNexusQuery));
      }
      if (ToolUtil.isNullEntityAllFieldValue(rolePostNexusQuery)) {
        return this.queryCount(countSql, Long.class);
      } else {
        return this.queryCount(countSql, rolePostNexusQuery, Long.class);
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public RolePostNexus getRolePostNexusByPk(String nexusId) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + nexusId);
    }
    try {
      if (ToolUtil.isNullStr(nexusId)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      StringBuilder querySql = new StringBuilder(SELECT_SQL);
      querySql.append(this.getByPkSql(COLUMNS_PARAMETER, PRIMARY_KEY, TABLE_ALIAS));
      MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
      if (ToolUtil.isNotEmpty(PRIMARY_KEY) && PRIMARY_KEY.size() == 1) {
        for (String pk : PRIMARY_KEY) {
          mapSqlParameterSource.addValue(pk, nexusId);
        }
      }
      Collection<RolePostNexus> rolePostNexusSet = this.query(querySql, mapSqlParameterSource, RolePostNexus.class);
      return ToolUtil.isNotEmpty(rolePostNexusSet) ? rolePostNexusSet.iterator().next() : null;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<RolePostNexus> getAllRolePostNexus() throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
    }
    try {
      StringBuilder querySql = new StringBuilder(SELECT_SQL);
      querySql.append(this.getSortSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS));
      return this.query(querySql, RolePostNexus.class);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<RolePostNexus> queryRolePostNexus(RolePostNexusQuery rolePostNexusQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + rolePostNexusQuery);
    }
    try {
      StringBuilder querySql = new StringBuilder(SELECT_SQL);
      if (!ToolUtil.isNullEntityAllFieldValue(rolePostNexusQuery)) {
        this.getExistsSql(rolePostNexusQuery);
        querySql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, rolePostNexusQuery));
      }
      querySql.append(this.getSortSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS));
      if (ToolUtil.isNullEntityAllFieldValue(rolePostNexusQuery)) {
        return this.query(querySql, RolePostNexus.class);
      } else {
        return this.query(querySql, rolePostNexusQuery, RolePostNexus.class);
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Paging<RolePostNexus> pagingQueryRolePostNexus(Param param, RolePostNexusQuery rolePostNexusQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + rolePostNexusQuery);
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
      Paging<RolePostNexus> paging = new Paging<>(param);
      StringBuilder countSql = new StringBuilder(COUNT_SQL);
      if (!ToolUtil.isNullEntityAllFieldValue(rolePostNexusQuery)) {
        this.getExistsSql(rolePostNexusQuery);
        countSql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, rolePostNexusQuery));
      }
      Long count = null;
      if (ToolUtil.isNullEntityAllFieldValue(rolePostNexusQuery)) {
        count = this.queryCount(countSql, Long.class);
      } else {
        count = this.queryCount(countSql, rolePostNexusQuery, Long.class);
      }
      paging.setCount(count);
      if (count > 0) {
        StringBuilder querySql = new StringBuilder(this.getPagingSql(TABLE_NAME, COLUMNS_PARAMETER, PRIMARY_KEY, TABLE_ALIAS));
        if (!ToolUtil.isNullEntityAllFieldValue(rolePostNexusQuery)) {
          querySql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, rolePostNexusQuery));
        }
        querySql.append(this.getPagingSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS, paging));
        Collection<RolePostNexus> rolePostNexusSet = null;
        if (ToolUtil.isNullEntityAllFieldValue(rolePostNexusQuery)) {
          rolePostNexusSet = this.query(querySql, RolePostNexus.class);
        } else {
          rolePostNexusSet = this.query(querySql, rolePostNexusQuery, RolePostNexus.class);
        }
        if (ToolUtil.isNotEmpty(rolePostNexusSet)) {
          Set<String> inNexusId = new LinkedHashSet<>();
          for (RolePostNexus rolePostNexus : rolePostNexusSet) {
            inNexusId.add(rolePostNexus.getNexusId());
          }
          RolePostNexusQuery rRolePostNexusQuery = new RolePostNexusQuery();
          rRolePostNexusQuery.setNexusIdAndin(new ArrayList<>(inNexusId));
          Collection<RolePostNexus> rRolePostNexusSet = this.queryRolePostNexus(rRolePostNexusQuery);
          if (ToolUtil.isNotEmpty(rRolePostNexusSet)) {
            paging.setData(rRolePostNexusSet);
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
  public RolePostNexusVO getRolePostNexusVOByPk(String nexusId) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + nexusId);
    }
    try {
      if (ToolUtil.isNullStr(nexusId)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      StringBuilder querySql = new StringBuilder(SELECT_VO_SQL);
      querySql.append(this.getByPkSql(COLUMNS_PARAMETER, PRIMARY_KEY, TABLE_ALIAS));
      MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
      if (ToolUtil.isNotEmpty(PRIMARY_KEY) && PRIMARY_KEY.size() == 1) {
        for (String pk : PRIMARY_KEY) {
          mapSqlParameterSource.addValue(pk, nexusId);
        }
      }
      Collection<RolePostNexusVO> rolePostNexusVOSet = this.query(querySql, mapSqlParameterSource, RolePostNexusVO.class);
      return ToolUtil.isNotEmpty(rolePostNexusVOSet) ? rolePostNexusVOSet.iterator().next() : null;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<RolePostNexusVO> getAllRolePostNexusVO() throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
    }
    try {
      StringBuilder querySql = new StringBuilder(SELECT_VO_SQL);
      querySql.append(this.getSortSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS));
      return this.query(querySql, RolePostNexusVO.class);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<RolePostNexusVO> queryRolePostNexusVO(RolePostNexusQuery rolePostNexusQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + rolePostNexusQuery);
    }
    try {
      StringBuilder querySql = new StringBuilder(SELECT_VO_SQL);
      if (!ToolUtil.isNullEntityAllFieldValue(rolePostNexusQuery)) {
        this.getExistsSql(rolePostNexusQuery);
        querySql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, rolePostNexusQuery));
      }
      querySql.append(this.getSortSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS));
      if (ToolUtil.isNullEntityAllFieldValue(rolePostNexusQuery)) {
        return this.query(querySql, RolePostNexusVO.class);
      } else {
        return this.query(querySql, rolePostNexusQuery, RolePostNexusVO.class);
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Paging<RolePostNexusVO> pagingQueryRolePostNexusVO(Param param, RolePostNexusQuery rolePostNexusQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + rolePostNexusQuery);
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
      Paging<RolePostNexusVO> paging = new Paging<>(param);
      StringBuilder countSql = new StringBuilder(COUNT_SQL);
      if (!ToolUtil.isNullEntityAllFieldValue(rolePostNexusQuery)) {
        this.getExistsSql(rolePostNexusQuery);
        countSql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, rolePostNexusQuery));
      }
      Long count = null;
      if (ToolUtil.isNullEntityAllFieldValue(rolePostNexusQuery)) {
        count = this.queryCount(countSql, Long.class);
      } else {
        count = this.queryCount(countSql, rolePostNexusQuery, Long.class);
      }
      paging.setCount(count);
      if (count > 0) {
        StringBuilder querySql = new StringBuilder(this.getPagingSql(TABLE_NAME, COLUMNS_PARAMETER, PRIMARY_KEY, TABLE_ALIAS));
        if (!ToolUtil.isNullEntityAllFieldValue(rolePostNexusQuery)) {
          querySql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, rolePostNexusQuery));
        }
        querySql.append(this.getPagingSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS, paging));
        Collection<RolePostNexus> rolePostNexusSet = null;
        if (ToolUtil.isNullEntityAllFieldValue(rolePostNexusQuery)) {
          rolePostNexusSet = this.query(querySql, RolePostNexus.class);
        } else {
          rolePostNexusSet = this.query(querySql, rolePostNexusQuery, RolePostNexus.class);
        }
        if (ToolUtil.isNotEmpty(rolePostNexusSet)) {
          Set<String> inNexusId = new LinkedHashSet<>();
          for (RolePostNexus rolePostNexus : rolePostNexusSet) {
            inNexusId.add(rolePostNexus.getNexusId());
          }
          RolePostNexusQuery rRolePostNexusQuery = new RolePostNexusQuery();
          rRolePostNexusQuery.setNexusIdAndin(new ArrayList<>(inNexusId));
          Collection<RolePostNexusVO> rRolePostNexusVOSet = this.queryRolePostNexusVO(rRolePostNexusQuery);
          if (ToolUtil.isNotEmpty(rRolePostNexusVOSet)) {
            paging.setData(rRolePostNexusVOSet);
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

  private void getExistsSql(RolePostNexusQuery rolePostNexusQuery) throws Exception {
    try {
      if (ToolUtil.isNotNullStr(rolePostNexusQuery.getToolExists())) {
        if ("NEXUS".equals(rolePostNexusQuery.getToolExists().toUpperCase())) {
          rolePostNexusQuery.setToolExists("SELECT NEXUS_ID FROM NEXUS WHERE NEXUS_ID IS NOT NULL AND ID = " + TABLE_ALIAS + ".ID");
        } else {
          rolePostNexusQuery.setToolExists(null);
        }
      }
      if (ToolUtil.isNotNullStr(rolePostNexusQuery.getToolNotExists())) {
        if ("NEXUS".equals(rolePostNexusQuery.getToolNotExists().toUpperCase())) {
          rolePostNexusQuery.setToolNotExists("SELECT NEXUS_ID FROM NEXUS WHERE NEXUS_ID IS NOT NULL AND ID = " + TABLE_ALIAS + ".ID");
        } else {
          rolePostNexusQuery.setToolNotExists(null);
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
