package com.drzyl.zone.persistent.impl;

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
import com.drzyl.zone.entity.ZoneRegion;
import com.drzyl.zone.persistent.IZoneRegionPersistent;
import com.drzyl.zone.query.ZoneRegionQuery;
import com.drzyl.zone.vo.ZoneRegionVO;
import lombok.extern.log4j.Log4j2;

/**
 * 省市区 持久化实现
 */
@Log4j2
@Repository("com.drzyl.zone.ZoneRegionPersistent")
public class ZoneRegionPersistentImpl extends ToolPersistent implements IZoneRegionPersistent {

  public static final String LOG = "ZoneRegionPersistent";

  public static final String TABLE_ALIAS = "zoneRegion";

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
  public ZoneRegion saveZoneRegion(ZoneRegion zoneRegion) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + zoneRegion);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(zoneRegion)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      if (ToolUtil.isNullStr(zoneRegion.getRegionId())) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      this.insert(INSERT_SQL, zoneRegion);
      return zoneRegion;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<ZoneRegion> batchSaveZoneRegion(Collection<ZoneRegion> zoneRegions) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + zoneRegions);
    }
    try {
      if (ToolUtil.isEmpty(zoneRegions)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      this.insert(INSERT_SQL, zoneRegions);
      return zoneRegions;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public ZoneRegion updateZoneRegion(ZoneRegion zoneRegion) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + zoneRegion);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(zoneRegion)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      if (ToolUtil.isNullStr(zoneRegion.getRegionId())) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      this.update(UPDATE_SQL, zoneRegion);
      return zoneRegion;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<ZoneRegion> batchUpdateZoneRegion(Collection<ZoneRegion> zoneRegions) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + zoneRegions);
    }
    try {
      if (ToolUtil.isEmpty(zoneRegions)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      this.update(UPDATE_SQL, zoneRegions);
      return zoneRegions;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public void removeZoneRegion(ZoneRegion zoneRegion) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + zoneRegion);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(zoneRegion)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      if (ToolUtil.isNullStr(zoneRegion.getRegionId())) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
      if (ToolUtil.isNotEmpty(PRIMARY_KEY) && PRIMARY_KEY.size() == 1) {
        for (String pk : PRIMARY_KEY) {
          mapSqlParameterSource.addValue(pk, zoneRegion.getRegionId());
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
  public void batchRemoveZoneRegion(Collection<ZoneRegion> zoneRegions) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + zoneRegions);
    }
    try {
      if (ToolUtil.isEmpty(zoneRegions)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      this.del(DEL_SQL_BY_PK, zoneRegions);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Long getCountZoneRegion(ZoneRegionQuery zoneRegionQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + zoneRegionQuery);
    }
    try {
      StringBuilder countSql = new StringBuilder(COUNT_SQL);
      if (!ToolUtil.isNullEntityAllFieldValue(zoneRegionQuery)) {
        this.getExistsSql(zoneRegionQuery);
        countSql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, zoneRegionQuery));
      }
      if (ToolUtil.isNullEntityAllFieldValue(zoneRegionQuery)) {
        return this.queryCount(countSql, Long.class);
      } else {
        return this.queryCount(countSql, zoneRegionQuery, Long.class);
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public ZoneRegion getZoneRegionByPk(String regionId) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + regionId);
    }
    try {
      if (ToolUtil.isNullStr(regionId)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      StringBuilder querySql = new StringBuilder(SELECT_SQL);
      querySql.append(this.getByPkSql(COLUMNS_PARAMETER, PRIMARY_KEY, TABLE_ALIAS));
      MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
      if (ToolUtil.isNotEmpty(PRIMARY_KEY) && PRIMARY_KEY.size() == 1) {
        for (String pk : PRIMARY_KEY) {
          mapSqlParameterSource.addValue(pk, regionId);
        }
      }
      Collection<ZoneRegion> zoneRegionSet = this.query(querySql, mapSqlParameterSource, ZoneRegion.class);
      return ToolUtil.isNotEmpty(zoneRegionSet) ? zoneRegionSet.iterator().next() : null;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<ZoneRegion> getAllZoneRegion() throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
    }
    try {
      StringBuilder querySql = new StringBuilder(SELECT_SQL);
      querySql.append(this.getSortSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS));
      return this.query(querySql, ZoneRegion.class);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<ZoneRegion> queryZoneRegion(ZoneRegionQuery zoneRegionQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + zoneRegionQuery);
    }
    try {
      StringBuilder querySql = new StringBuilder(SELECT_SQL);
      if (!ToolUtil.isNullEntityAllFieldValue(zoneRegionQuery)) {
        this.getExistsSql(zoneRegionQuery);
        querySql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, zoneRegionQuery));
      }
      querySql.append(this.getSortSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS));
      if (ToolUtil.isNullEntityAllFieldValue(zoneRegionQuery)) {
        return this.query(querySql, ZoneRegion.class);
      } else {
        return this.query(querySql, zoneRegionQuery, ZoneRegion.class);
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Paging<ZoneRegion> pagingQueryZoneRegion(Param param, ZoneRegionQuery zoneRegionQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + zoneRegionQuery);
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
      Paging<ZoneRegion> paging = new Paging<>(param);
      StringBuilder countSql = new StringBuilder(COUNT_SQL);
      if (!ToolUtil.isNullEntityAllFieldValue(zoneRegionQuery)) {
        this.getExistsSql(zoneRegionQuery);
        countSql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, zoneRegionQuery));
      }
      Long count = null;
      if (ToolUtil.isNullEntityAllFieldValue(zoneRegionQuery)) {
        count = this.queryCount(countSql, Long.class);
      } else {
        count = this.queryCount(countSql, zoneRegionQuery, Long.class);
      }
      paging.setCount(count);
      if (count > 0) {
        StringBuilder querySql = new StringBuilder(this.getPagingSql(TABLE_NAME, COLUMNS_PARAMETER, PRIMARY_KEY, TABLE_ALIAS));
        if (!ToolUtil.isNullEntityAllFieldValue(zoneRegionQuery)) {
          querySql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, zoneRegionQuery));
        }
        querySql.append(this.getPagingSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS, paging));
        Collection<ZoneRegion> zoneRegionSet = null;
        if (ToolUtil.isNullEntityAllFieldValue(zoneRegionQuery)) {
          zoneRegionSet = this.query(querySql, ZoneRegion.class);
        } else {
          zoneRegionSet = this.query(querySql, zoneRegionQuery, ZoneRegion.class);
        }
        if (ToolUtil.isNotEmpty(zoneRegionSet)) {
          Set<String> inRegionId = new LinkedHashSet<>();
          for (ZoneRegion zoneRegion : zoneRegionSet) {
            inRegionId.add(zoneRegion.getRegionId());
          }
          ZoneRegionQuery rZoneRegionQuery = new ZoneRegionQuery();
          rZoneRegionQuery.setRegionIdAndin(new ArrayList<>(inRegionId));
          Collection<ZoneRegion> rZoneRegionSet = this.queryZoneRegion(rZoneRegionQuery);
          if (ToolUtil.isNotEmpty(rZoneRegionSet)) {
            paging.setData(rZoneRegionSet);
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
  public ZoneRegionVO getZoneRegionVOByPk(String regionId) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + regionId);
    }
    try {
      if (ToolUtil.isNullStr(regionId)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      StringBuilder querySql = new StringBuilder(SELECT_VO_SQL);
      querySql.append(this.getByPkSql(COLUMNS_PARAMETER, PRIMARY_KEY, TABLE_ALIAS));
      MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
      if (ToolUtil.isNotEmpty(PRIMARY_KEY) && PRIMARY_KEY.size() == 1) {
        for (String pk : PRIMARY_KEY) {
          mapSqlParameterSource.addValue(pk, regionId);
        }
      }
      Collection<ZoneRegionVO> zoneRegionVOSet = this.query(querySql, mapSqlParameterSource, ZoneRegionVO.class);
      return ToolUtil.isNotEmpty(zoneRegionVOSet) ? zoneRegionVOSet.iterator().next() : null;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<ZoneRegionVO> getAllZoneRegionVO() throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
    }
    try {
      StringBuilder querySql = new StringBuilder(SELECT_VO_SQL);
      querySql.append(this.getSortSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS));
      return this.query(querySql, ZoneRegionVO.class);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<ZoneRegionVO> queryZoneRegionVO(ZoneRegionQuery zoneRegionQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + zoneRegionQuery);
    }
    try {
      StringBuilder querySql = new StringBuilder(SELECT_VO_SQL);
      if (!ToolUtil.isNullEntityAllFieldValue(zoneRegionQuery)) {
        this.getExistsSql(zoneRegionQuery);
        querySql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, zoneRegionQuery));
      }
      querySql.append(this.getSortSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS));
      if (ToolUtil.isNullEntityAllFieldValue(zoneRegionQuery)) {
        return this.query(querySql, ZoneRegionVO.class);
      } else {
        return this.query(querySql, zoneRegionQuery, ZoneRegionVO.class);
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Paging<ZoneRegionVO> pagingQueryZoneRegionVO(Param param, ZoneRegionQuery zoneRegionQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + zoneRegionQuery);
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
      Paging<ZoneRegionVO> paging = new Paging<>(param);
      StringBuilder countSql = new StringBuilder(COUNT_SQL);
      if (!ToolUtil.isNullEntityAllFieldValue(zoneRegionQuery)) {
        this.getExistsSql(zoneRegionQuery);
        countSql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, zoneRegionQuery));
      }
      Long count = null;
      if (ToolUtil.isNullEntityAllFieldValue(zoneRegionQuery)) {
        count = this.queryCount(countSql, Long.class);
      } else {
        count = this.queryCount(countSql, zoneRegionQuery, Long.class);
      }
      paging.setCount(count);
      if (count > 0) {
        StringBuilder querySql = new StringBuilder(this.getPagingSql(TABLE_NAME, COLUMNS_PARAMETER, PRIMARY_KEY, TABLE_ALIAS));
        if (!ToolUtil.isNullEntityAllFieldValue(zoneRegionQuery)) {
          querySql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, zoneRegionQuery));
        }
        querySql.append(this.getPagingSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS, paging));
        Collection<ZoneRegion> zoneRegionSet = null;
        if (ToolUtil.isNullEntityAllFieldValue(zoneRegionQuery)) {
          zoneRegionSet = this.query(querySql, ZoneRegion.class);
        } else {
          zoneRegionSet = this.query(querySql, zoneRegionQuery, ZoneRegion.class);
        }
        if (ToolUtil.isNotEmpty(zoneRegionSet)) {
          Set<String> inRegionId = new LinkedHashSet<>();
          for (ZoneRegion zoneRegion : zoneRegionSet) {
            inRegionId.add(zoneRegion.getRegionId());
          }
          ZoneRegionQuery rZoneRegionQuery = new ZoneRegionQuery();
          rZoneRegionQuery.setRegionIdAndin(new ArrayList<>(inRegionId));
          Collection<ZoneRegionVO> rZoneRegionVOSet = this.queryZoneRegionVO(rZoneRegionQuery);
          if (ToolUtil.isNotEmpty(rZoneRegionVOSet)) {
            paging.setData(rZoneRegionVOSet);
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

  private void getExistsSql(ZoneRegionQuery zoneRegionQuery) throws Exception {
    try {
      if (ToolUtil.isNotNullStr(zoneRegionQuery.getToolExists())) {
        if ("NEXUS".equals(zoneRegionQuery.getToolExists().toUpperCase())) {
          zoneRegionQuery.setToolExists("SELECT NEXUS_ID FROM NEXUS WHERE NEXUS_ID IS NOT NULL AND ID = " + TABLE_ALIAS + ".ID");
        } else {
          zoneRegionQuery.setToolExists(null);
        }
      }
      if (ToolUtil.isNotNullStr(zoneRegionQuery.getToolNotExists())) {
        if ("NEXUS".equals(zoneRegionQuery.getToolNotExists().toUpperCase())) {
          zoneRegionQuery.setToolNotExists("SELECT NEXUS_ID FROM NEXUS WHERE NEXUS_ID IS NOT NULL AND ID = " + TABLE_ALIAS + ".ID");
        } else {
          zoneRegionQuery.setToolNotExists(null);
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
