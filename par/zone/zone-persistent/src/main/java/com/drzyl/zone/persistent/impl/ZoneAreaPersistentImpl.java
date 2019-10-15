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
import com.drzyl.zone.entity.ZoneArea;
import com.drzyl.zone.persistent.IZoneAreaPersistent;
import com.drzyl.zone.query.ZoneAreaQuery;
import com.drzyl.zone.vo.ZoneAreaVO;
import lombok.extern.log4j.Log4j2;

/**
 * 区域 持久化实现
 */
@Log4j2
@Repository("com.drzyl.zone.ZoneAreaPersistent")
public class ZoneAreaPersistentImpl extends ToolPersistent implements IZoneAreaPersistent {

  public static final String LOG = "ZoneAreaPersistent";

  public static final String TABLE_ALIAS = "zoneArea";

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
  public ZoneArea saveZoneArea(ZoneArea zoneArea) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + zoneArea);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(zoneArea)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      if (ToolUtil.isNullStr(zoneArea.getAreaId())) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      this.insert(INSERT_SQL, zoneArea);
      return zoneArea;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<ZoneArea> batchSaveZoneArea(Collection<ZoneArea> zoneAreas) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + zoneAreas);
    }
    try {
      if (ToolUtil.isEmpty(zoneAreas)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      this.insert(INSERT_SQL, zoneAreas);
      return zoneAreas;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public ZoneArea updateZoneArea(ZoneArea zoneArea) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + zoneArea);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(zoneArea)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      if (ToolUtil.isNullStr(zoneArea.getAreaId())) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      this.update(UPDATE_SQL, zoneArea);
      return zoneArea;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<ZoneArea> batchUpdateZoneArea(Collection<ZoneArea> zoneAreas) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + zoneAreas);
    }
    try {
      if (ToolUtil.isEmpty(zoneAreas)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      this.update(UPDATE_SQL, zoneAreas);
      return zoneAreas;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public void removeZoneArea(ZoneArea zoneArea) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + zoneArea);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(zoneArea)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      if (ToolUtil.isNullStr(zoneArea.getAreaId())) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
      if (ToolUtil.isNotEmpty(PRIMARY_KEY) && PRIMARY_KEY.size() == 1) {
        for (String pk : PRIMARY_KEY) {
          mapSqlParameterSource.addValue(pk, zoneArea.getAreaId());
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
  public void batchRemoveZoneArea(Collection<ZoneArea> zoneAreas) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + zoneAreas);
    }
    try {
      if (ToolUtil.isEmpty(zoneAreas)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      this.del(DEL_SQL_BY_PK, zoneAreas);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Long getCountZoneArea(ZoneAreaQuery zoneAreaQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + zoneAreaQuery);
    }
    try {
      StringBuilder countSql = new StringBuilder(COUNT_SQL);
      if (!ToolUtil.isNullEntityAllFieldValue(zoneAreaQuery)) {
        this.getExistsSql(zoneAreaQuery);
        countSql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, zoneAreaQuery));
      }
      if (ToolUtil.isNullEntityAllFieldValue(zoneAreaQuery)) {
        return this.queryCount(countSql, Long.class);
      } else {
        return this.queryCount(countSql, zoneAreaQuery, Long.class);
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public ZoneArea getZoneAreaByPk(String areaId) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + areaId);
    }
    try {
      if (ToolUtil.isNullStr(areaId)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      StringBuilder querySql = new StringBuilder(SELECT_SQL);
      querySql.append(this.getByPkSql(COLUMNS_PARAMETER, PRIMARY_KEY, TABLE_ALIAS));
      MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
      if (ToolUtil.isNotEmpty(PRIMARY_KEY) && PRIMARY_KEY.size() == 1) {
        for (String pk : PRIMARY_KEY) {
          mapSqlParameterSource.addValue(pk, areaId);
        }
      }
      Collection<ZoneArea> zoneAreaSet = this.query(querySql, mapSqlParameterSource, ZoneArea.class);
      return ToolUtil.isNotEmpty(zoneAreaSet) ? zoneAreaSet.iterator().next() : null;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<ZoneArea> getAllZoneArea() throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
    }
    try {
      StringBuilder querySql = new StringBuilder(SELECT_SQL);
      querySql.append(this.getSortSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS));
      return this.query(querySql, ZoneArea.class);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<ZoneArea> queryZoneArea(ZoneAreaQuery zoneAreaQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + zoneAreaQuery);
    }
    try {
      StringBuilder querySql = new StringBuilder(SELECT_SQL);
      if (!ToolUtil.isNullEntityAllFieldValue(zoneAreaQuery)) {
        this.getExistsSql(zoneAreaQuery);
        querySql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, zoneAreaQuery));
      }
      querySql.append(this.getSortSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS));
      if (ToolUtil.isNullEntityAllFieldValue(zoneAreaQuery)) {
        return this.query(querySql, ZoneArea.class);
      } else {
        return this.query(querySql, zoneAreaQuery, ZoneArea.class);
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Paging<ZoneArea> pagingQueryZoneArea(Param param, ZoneAreaQuery zoneAreaQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + zoneAreaQuery);
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
      Paging<ZoneArea> paging = new Paging<>(param);
      StringBuilder countSql = new StringBuilder(COUNT_SQL);
      if (!ToolUtil.isNullEntityAllFieldValue(zoneAreaQuery)) {
        this.getExistsSql(zoneAreaQuery);
        countSql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, zoneAreaQuery));
      }
      Long count = null;
      if (ToolUtil.isNullEntityAllFieldValue(zoneAreaQuery)) {
        count = this.queryCount(countSql, Long.class);
      } else {
        count = this.queryCount(countSql, zoneAreaQuery, Long.class);
      }
      paging.setCount(count);
      if (count > 0) {
        StringBuilder querySql = new StringBuilder(this.getPagingSql(TABLE_NAME, COLUMNS_PARAMETER, PRIMARY_KEY, TABLE_ALIAS));
        if (!ToolUtil.isNullEntityAllFieldValue(zoneAreaQuery)) {
          querySql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, zoneAreaQuery));
        }
        querySql.append(this.getPagingSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS, paging));
        Collection<ZoneArea> zoneAreaSet = null;
        if (ToolUtil.isNullEntityAllFieldValue(zoneAreaQuery)) {
          zoneAreaSet = this.query(querySql, ZoneArea.class);
        } else {
          zoneAreaSet = this.query(querySql, zoneAreaQuery, ZoneArea.class);
        }
        if (ToolUtil.isNotEmpty(zoneAreaSet)) {
          Set<String> inAreaId = new LinkedHashSet<>();
          for (ZoneArea zoneArea : zoneAreaSet) {
            inAreaId.add(zoneArea.getAreaId());
          }
          ZoneAreaQuery rZoneAreaQuery = new ZoneAreaQuery();
          rZoneAreaQuery.setAreaIdAndin(new ArrayList<>(inAreaId));
          Collection<ZoneArea> rZoneAreaSet = this.queryZoneArea(rZoneAreaQuery);
          if (ToolUtil.isNotEmpty(rZoneAreaSet)) {
            paging.setData(rZoneAreaSet);
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
  public ZoneAreaVO getZoneAreaVOByPk(String areaId) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + areaId);
    }
    try {
      if (ToolUtil.isNullStr(areaId)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      StringBuilder querySql = new StringBuilder(SELECT_VO_SQL);
      querySql.append(this.getByPkSql(COLUMNS_PARAMETER, PRIMARY_KEY, TABLE_ALIAS));
      MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
      if (ToolUtil.isNotEmpty(PRIMARY_KEY) && PRIMARY_KEY.size() == 1) {
        for (String pk : PRIMARY_KEY) {
          mapSqlParameterSource.addValue(pk, areaId);
        }
      }
      Collection<ZoneAreaVO> zoneAreaVOSet = this.query(querySql, mapSqlParameterSource, ZoneAreaVO.class);
      return ToolUtil.isNotEmpty(zoneAreaVOSet) ? zoneAreaVOSet.iterator().next() : null;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<ZoneAreaVO> getAllZoneAreaVO() throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
    }
    try {
      StringBuilder querySql = new StringBuilder(SELECT_VO_SQL);
      querySql.append(this.getSortSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS));
      return this.query(querySql, ZoneAreaVO.class);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<ZoneAreaVO> queryZoneAreaVO(ZoneAreaQuery zoneAreaQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + zoneAreaQuery);
    }
    try {
      StringBuilder querySql = new StringBuilder(SELECT_VO_SQL);
      if (!ToolUtil.isNullEntityAllFieldValue(zoneAreaQuery)) {
        this.getExistsSql(zoneAreaQuery);
        querySql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, zoneAreaQuery));
      }
      querySql.append(this.getSortSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS));
      if (ToolUtil.isNullEntityAllFieldValue(zoneAreaQuery)) {
        return this.query(querySql, ZoneAreaVO.class);
      } else {
        return this.query(querySql, zoneAreaQuery, ZoneAreaVO.class);
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Paging<ZoneAreaVO> pagingQueryZoneAreaVO(Param param, ZoneAreaQuery zoneAreaQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + zoneAreaQuery);
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
      Paging<ZoneAreaVO> paging = new Paging<>(param);
      StringBuilder countSql = new StringBuilder(COUNT_SQL);
      if (!ToolUtil.isNullEntityAllFieldValue(zoneAreaQuery)) {
        this.getExistsSql(zoneAreaQuery);
        countSql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, zoneAreaQuery));
      }
      Long count = null;
      if (ToolUtil.isNullEntityAllFieldValue(zoneAreaQuery)) {
        count = this.queryCount(countSql, Long.class);
      } else {
        count = this.queryCount(countSql, zoneAreaQuery, Long.class);
      }
      paging.setCount(count);
      if (count > 0) {
        StringBuilder querySql = new StringBuilder(this.getPagingSql(TABLE_NAME, COLUMNS_PARAMETER, PRIMARY_KEY, TABLE_ALIAS));
        if (!ToolUtil.isNullEntityAllFieldValue(zoneAreaQuery)) {
          querySql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, zoneAreaQuery));
        }
        querySql.append(this.getPagingSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS, paging));
        Collection<ZoneArea> zoneAreaSet = null;
        if (ToolUtil.isNullEntityAllFieldValue(zoneAreaQuery)) {
          zoneAreaSet = this.query(querySql, ZoneArea.class);
        } else {
          zoneAreaSet = this.query(querySql, zoneAreaQuery, ZoneArea.class);
        }
        if (ToolUtil.isNotEmpty(zoneAreaSet)) {
          Set<String> inAreaId = new LinkedHashSet<>();
          for (ZoneArea zoneArea : zoneAreaSet) {
            inAreaId.add(zoneArea.getAreaId());
          }
          ZoneAreaQuery rZoneAreaQuery = new ZoneAreaQuery();
          rZoneAreaQuery.setAreaIdAndin(new ArrayList<>(inAreaId));
          Collection<ZoneAreaVO> rZoneAreaVOSet = this.queryZoneAreaVO(rZoneAreaQuery);
          if (ToolUtil.isNotEmpty(rZoneAreaVOSet)) {
            paging.setData(rZoneAreaVOSet);
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

  private void getExistsSql(ZoneAreaQuery zoneAreaQuery) throws Exception {
    try {
      if (ToolUtil.isNotNullStr(zoneAreaQuery.getToolExists())) {
        if ("NEXUS".equals(zoneAreaQuery.getToolExists().toUpperCase())) {
          zoneAreaQuery.setToolExists("SELECT NEXUS_ID FROM NEXUS WHERE NEXUS_ID IS NOT NULL AND ID = " + TABLE_ALIAS + ".ID");
        } else {
          zoneAreaQuery.setToolExists(null);
        }
      }
      if (ToolUtil.isNotNullStr(zoneAreaQuery.getToolNotExists())) {
        if ("NEXUS".equals(zoneAreaQuery.getToolNotExists().toUpperCase())) {
          zoneAreaQuery.setToolNotExists("SELECT NEXUS_ID FROM NEXUS WHERE NEXUS_ID IS NOT NULL AND ID = " + TABLE_ALIAS + ".ID");
        } else {
          zoneAreaQuery.setToolNotExists(null);
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
