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
import com.drzyl.zone.entity.ZoneAreaRegionTepe;
import com.drzyl.zone.persistent.IZoneAreaRegionTepePersistent;
import com.drzyl.zone.query.ZoneAreaRegionTepeQuery;
import com.drzyl.zone.vo.ZoneAreaRegionTepeVO;
import lombok.extern.log4j.Log4j2;

/**
 * 区域-省市区中间表 持久化实现
 */
@Log4j2
@Repository("com.drzyl.zone.ZoneAreaRegionTepePersistent")
public class ZoneAreaRegionTepePersistentImpl extends ToolPersistent implements IZoneAreaRegionTepePersistent {

  public static final String LOG = "ZoneAreaRegionTepePersistent";

  public static final String TABLE_ALIAS = "zoneAreaRegionTepe";

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
  public ZoneAreaRegionTepe saveZoneAreaRegionTepe(ZoneAreaRegionTepe zoneAreaRegionTepe) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + zoneAreaRegionTepe);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(zoneAreaRegionTepe)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      if (ToolUtil.isNullStr(zoneAreaRegionTepe.getId())) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      this.insert(INSERT_SQL, zoneAreaRegionTepe);
      return zoneAreaRegionTepe;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<ZoneAreaRegionTepe> batchSaveZoneAreaRegionTepe(Collection<ZoneAreaRegionTepe> zoneAreaRegionTepes) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + zoneAreaRegionTepes);
    }
    try {
      if (ToolUtil.isEmpty(zoneAreaRegionTepes)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      this.insert(INSERT_SQL, zoneAreaRegionTepes);
      return zoneAreaRegionTepes;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public ZoneAreaRegionTepe updateZoneAreaRegionTepe(ZoneAreaRegionTepe zoneAreaRegionTepe) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + zoneAreaRegionTepe);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(zoneAreaRegionTepe)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      if (ToolUtil.isNullStr(zoneAreaRegionTepe.getId())) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      this.update(UPDATE_SQL, zoneAreaRegionTepe);
      return zoneAreaRegionTepe;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<ZoneAreaRegionTepe> batchUpdateZoneAreaRegionTepe(Collection<ZoneAreaRegionTepe> zoneAreaRegionTepes) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + zoneAreaRegionTepes);
    }
    try {
      if (ToolUtil.isEmpty(zoneAreaRegionTepes)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      this.update(UPDATE_SQL, zoneAreaRegionTepes);
      return zoneAreaRegionTepes;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public void removeZoneAreaRegionTepe(ZoneAreaRegionTepe zoneAreaRegionTepe) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + zoneAreaRegionTepe);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(zoneAreaRegionTepe)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      if (ToolUtil.isNullStr(zoneAreaRegionTepe.getId())) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
      if (ToolUtil.isNotEmpty(PRIMARY_KEY) && PRIMARY_KEY.size() == 1) {
        for (String pk : PRIMARY_KEY) {
          mapSqlParameterSource.addValue(pk, zoneAreaRegionTepe.getId());
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
  public void batchRemoveZoneAreaRegionTepe(Collection<ZoneAreaRegionTepe> zoneAreaRegionTepes) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + zoneAreaRegionTepes);
    }
    try {
      if (ToolUtil.isEmpty(zoneAreaRegionTepes)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      this.del(DEL_SQL_BY_PK, zoneAreaRegionTepes);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Long getCountZoneAreaRegionTepe(ZoneAreaRegionTepeQuery zoneAreaRegionTepeQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + zoneAreaRegionTepeQuery);
    }
    try {
      StringBuilder countSql = new StringBuilder(COUNT_SQL);
      if (!ToolUtil.isNullEntityAllFieldValue(zoneAreaRegionTepeQuery)) {
        this.getExistsSql(zoneAreaRegionTepeQuery);
        countSql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, zoneAreaRegionTepeQuery));
      }
      if (ToolUtil.isNullEntityAllFieldValue(zoneAreaRegionTepeQuery)) {
        return this.queryCount(countSql, Long.class);
      } else {
        return this.queryCount(countSql, zoneAreaRegionTepeQuery, Long.class);
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public ZoneAreaRegionTepe getZoneAreaRegionTepeByPk(String id) throws Exception {
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
      Collection<ZoneAreaRegionTepe> zoneAreaRegionTepeSet = this.query(querySql, mapSqlParameterSource, ZoneAreaRegionTepe.class);
      return ToolUtil.isNotEmpty(zoneAreaRegionTepeSet) ? zoneAreaRegionTepeSet.iterator().next() : null;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<ZoneAreaRegionTepe> getAllZoneAreaRegionTepe() throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
    }
    try {
      StringBuilder querySql = new StringBuilder(SELECT_SQL);
      querySql.append(this.getSortSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS));
      return this.query(querySql, ZoneAreaRegionTepe.class);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<ZoneAreaRegionTepe> queryZoneAreaRegionTepe(ZoneAreaRegionTepeQuery zoneAreaRegionTepeQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + zoneAreaRegionTepeQuery);
    }
    try {
      StringBuilder querySql = new StringBuilder(SELECT_SQL);
      if (!ToolUtil.isNullEntityAllFieldValue(zoneAreaRegionTepeQuery)) {
        this.getExistsSql(zoneAreaRegionTepeQuery);
        querySql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, zoneAreaRegionTepeQuery));
      }
      querySql.append(this.getSortSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS));
      if (ToolUtil.isNullEntityAllFieldValue(zoneAreaRegionTepeQuery)) {
        return this.query(querySql, ZoneAreaRegionTepe.class);
      } else {
        return this.query(querySql, zoneAreaRegionTepeQuery, ZoneAreaRegionTepe.class);
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Paging<ZoneAreaRegionTepe> pagingQueryZoneAreaRegionTepe(Param param, ZoneAreaRegionTepeQuery zoneAreaRegionTepeQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + zoneAreaRegionTepeQuery);
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
      Paging<ZoneAreaRegionTepe> paging = new Paging<>(param);
      StringBuilder countSql = new StringBuilder(COUNT_SQL);
      if (!ToolUtil.isNullEntityAllFieldValue(zoneAreaRegionTepeQuery)) {
        this.getExistsSql(zoneAreaRegionTepeQuery);
        countSql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, zoneAreaRegionTepeQuery));
      }
      Long count = null;
      if (ToolUtil.isNullEntityAllFieldValue(zoneAreaRegionTepeQuery)) {
        count = this.queryCount(countSql, Long.class);
      } else {
        count = this.queryCount(countSql, zoneAreaRegionTepeQuery, Long.class);
      }
      paging.setCount(count);
      if (count > 0) {
        StringBuilder querySql = new StringBuilder(this.getPagingSql(TABLE_NAME, COLUMNS_PARAMETER, PRIMARY_KEY, TABLE_ALIAS));
        if (!ToolUtil.isNullEntityAllFieldValue(zoneAreaRegionTepeQuery)) {
          querySql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, zoneAreaRegionTepeQuery));
        }
        querySql.append(this.getPagingSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS, paging));
        Collection<ZoneAreaRegionTepe> zoneAreaRegionTepeSet = null;
        if (ToolUtil.isNullEntityAllFieldValue(zoneAreaRegionTepeQuery)) {
          zoneAreaRegionTepeSet = this.query(querySql, ZoneAreaRegionTepe.class);
        } else {
          zoneAreaRegionTepeSet = this.query(querySql, zoneAreaRegionTepeQuery, ZoneAreaRegionTepe.class);
        }
        if (ToolUtil.isNotEmpty(zoneAreaRegionTepeSet)) {
          Set<String> inId = new LinkedHashSet<>();
          for (ZoneAreaRegionTepe zoneAreaRegionTepe : zoneAreaRegionTepeSet) {
            inId.add(zoneAreaRegionTepe.getId());
          }
          ZoneAreaRegionTepeQuery rZoneAreaRegionTepeQuery = new ZoneAreaRegionTepeQuery();
          rZoneAreaRegionTepeQuery.setIdAndin(new ArrayList<>(inId));
          Collection<ZoneAreaRegionTepe> rZoneAreaRegionTepeSet = this.queryZoneAreaRegionTepe(rZoneAreaRegionTepeQuery);
          if (ToolUtil.isNotEmpty(rZoneAreaRegionTepeSet)) {
            paging.setData(rZoneAreaRegionTepeSet);
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
  public ZoneAreaRegionTepeVO getZoneAreaRegionTepeVOByPk(String id) throws Exception {
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
      Collection<ZoneAreaRegionTepeVO> zoneAreaRegionTepeVOSet = this.query(querySql, mapSqlParameterSource, ZoneAreaRegionTepeVO.class);
      return ToolUtil.isNotEmpty(zoneAreaRegionTepeVOSet) ? zoneAreaRegionTepeVOSet.iterator().next() : null;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<ZoneAreaRegionTepeVO> getAllZoneAreaRegionTepeVO() throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
    }
    try {
      StringBuilder querySql = new StringBuilder(SELECT_VO_SQL);
      querySql.append(this.getSortSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS));
      return this.query(querySql, ZoneAreaRegionTepeVO.class);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<ZoneAreaRegionTepeVO> queryZoneAreaRegionTepeVO(ZoneAreaRegionTepeQuery zoneAreaRegionTepeQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + zoneAreaRegionTepeQuery);
    }
    try {
      StringBuilder querySql = new StringBuilder(SELECT_VO_SQL);
      if (!ToolUtil.isNullEntityAllFieldValue(zoneAreaRegionTepeQuery)) {
        this.getExistsSql(zoneAreaRegionTepeQuery);
        querySql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, zoneAreaRegionTepeQuery));
      }
      querySql.append(this.getSortSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS));
      if (ToolUtil.isNullEntityAllFieldValue(zoneAreaRegionTepeQuery)) {
        return this.query(querySql, ZoneAreaRegionTepeVO.class);
      } else {
        return this.query(querySql, zoneAreaRegionTepeQuery, ZoneAreaRegionTepeVO.class);
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Paging<ZoneAreaRegionTepeVO> pagingQueryZoneAreaRegionTepeVO(Param param, ZoneAreaRegionTepeQuery zoneAreaRegionTepeQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + zoneAreaRegionTepeQuery);
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
      Paging<ZoneAreaRegionTepeVO> paging = new Paging<>(param);
      StringBuilder countSql = new StringBuilder(COUNT_SQL);
      if (!ToolUtil.isNullEntityAllFieldValue(zoneAreaRegionTepeQuery)) {
        this.getExistsSql(zoneAreaRegionTepeQuery);
        countSql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, zoneAreaRegionTepeQuery));
      }
      Long count = null;
      if (ToolUtil.isNullEntityAllFieldValue(zoneAreaRegionTepeQuery)) {
        count = this.queryCount(countSql, Long.class);
      } else {
        count = this.queryCount(countSql, zoneAreaRegionTepeQuery, Long.class);
      }
      paging.setCount(count);
      if (count > 0) {
        StringBuilder querySql = new StringBuilder(this.getPagingSql(TABLE_NAME, COLUMNS_PARAMETER, PRIMARY_KEY, TABLE_ALIAS));
        if (!ToolUtil.isNullEntityAllFieldValue(zoneAreaRegionTepeQuery)) {
          querySql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, zoneAreaRegionTepeQuery));
        }
        querySql.append(this.getPagingSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS, paging));
        Collection<ZoneAreaRegionTepe> zoneAreaRegionTepeSet = null;
        if (ToolUtil.isNullEntityAllFieldValue(zoneAreaRegionTepeQuery)) {
          zoneAreaRegionTepeSet = this.query(querySql, ZoneAreaRegionTepe.class);
        } else {
          zoneAreaRegionTepeSet = this.query(querySql, zoneAreaRegionTepeQuery, ZoneAreaRegionTepe.class);
        }
        if (ToolUtil.isNotEmpty(zoneAreaRegionTepeSet)) {
          Set<String> inId = new LinkedHashSet<>();
          for (ZoneAreaRegionTepe zoneAreaRegionTepe : zoneAreaRegionTepeSet) {
            inId.add(zoneAreaRegionTepe.getId());
          }
          ZoneAreaRegionTepeQuery rZoneAreaRegionTepeQuery = new ZoneAreaRegionTepeQuery();
          rZoneAreaRegionTepeQuery.setIdAndin(new ArrayList<>(inId));
          Collection<ZoneAreaRegionTepeVO> rZoneAreaRegionTepeVOSet = this.queryZoneAreaRegionTepeVO(rZoneAreaRegionTepeQuery);
          if (ToolUtil.isNotEmpty(rZoneAreaRegionTepeVOSet)) {
            paging.setData(rZoneAreaRegionTepeVOSet);
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

  private void getExistsSql(ZoneAreaRegionTepeQuery zoneAreaRegionTepeQuery) throws Exception {
    try {
      if (ToolUtil.isNotNullStr(zoneAreaRegionTepeQuery.getToolExists())) {
        if ("NEXUS".equals(zoneAreaRegionTepeQuery.getToolExists().toUpperCase())) {
          zoneAreaRegionTepeQuery.setToolExists("SELECT NEXUS_ID FROM NEXUS WHERE NEXUS_ID IS NOT NULL AND ID = " + TABLE_ALIAS + ".ID");
        } else {
          zoneAreaRegionTepeQuery.setToolExists(null);
        }
      }
      if (ToolUtil.isNotNullStr(zoneAreaRegionTepeQuery.getToolNotExists())) {
        if ("NEXUS".equals(zoneAreaRegionTepeQuery.getToolNotExists().toUpperCase())) {
          zoneAreaRegionTepeQuery.setToolNotExists("SELECT NEXUS_ID FROM NEXUS WHERE NEXUS_ID IS NOT NULL AND ID = " + TABLE_ALIAS + ".ID");
        } else {
          zoneAreaRegionTepeQuery.setToolNotExists(null);
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
