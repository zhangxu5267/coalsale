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
import com.drzyl.sign.entity.PostStaffNexus;
import com.drzyl.sign.persistent.IPostStaffNexusPersistent;
import com.drzyl.sign.query.PostStaffNexusQuery;
import com.drzyl.sign.vo.PostStaffNexusVO;
import lombok.extern.log4j.Log4j2;

/**
 * 岗位员工 持久化实现
 */
@Log4j2
@Repository("com.drzyl.sign.PostStaffNexusPersistent")
public class PostStaffNexusPersistentImpl extends ToolPersistent implements IPostStaffNexusPersistent {

  public static final String LOG = "PostStaffNexusPersistent";

  public static final String TABLE_ALIAS = "postStaffNexus";

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
  public PostStaffNexus savePostStaffNexus(PostStaffNexus postStaffNexus) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + postStaffNexus);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(postStaffNexus)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      if (ToolUtil.isNullStr(postStaffNexus.getNexusId())) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      this.insert(INSERT_SQL, postStaffNexus);
      return postStaffNexus;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<PostStaffNexus> batchSavePostStaffNexus(Collection<PostStaffNexus> postStaffNexuss) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + postStaffNexuss);
    }
    try {
      if (ToolUtil.isEmpty(postStaffNexuss)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      this.insert(INSERT_SQL, postStaffNexuss);
      return postStaffNexuss;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public PostStaffNexus updatePostStaffNexus(PostStaffNexus postStaffNexus) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + postStaffNexus);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(postStaffNexus)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      if (ToolUtil.isNullStr(postStaffNexus.getNexusId())) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      this.update(UPDATE_SQL, postStaffNexus);
      return postStaffNexus;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<PostStaffNexus> batchUpdatePostStaffNexus(Collection<PostStaffNexus> postStaffNexuss) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + postStaffNexuss);
    }
    try {
      if (ToolUtil.isEmpty(postStaffNexuss)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      this.update(UPDATE_SQL, postStaffNexuss);
      return postStaffNexuss;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public void removePostStaffNexus(PostStaffNexus postStaffNexus) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + postStaffNexus);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(postStaffNexus)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      if (ToolUtil.isNullStr(postStaffNexus.getNexusId())) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
      if (ToolUtil.isNotEmpty(PRIMARY_KEY) && PRIMARY_KEY.size() == 1) {
        for (String pk : PRIMARY_KEY) {
          mapSqlParameterSource.addValue(pk, postStaffNexus.getNexusId());
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
  public void batchRemovePostStaffNexus(Collection<PostStaffNexus> postStaffNexuss) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + postStaffNexuss);
    }
    try {
      if (ToolUtil.isEmpty(postStaffNexuss)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      this.del(DEL_SQL_BY_PK, postStaffNexuss);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Long getCountPostStaffNexus(PostStaffNexusQuery postStaffNexusQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + postStaffNexusQuery);
    }
    try {
      StringBuilder countSql = new StringBuilder(COUNT_SQL);
      if (!ToolUtil.isNullEntityAllFieldValue(postStaffNexusQuery)) {
        this.getExistsSql(postStaffNexusQuery);
        countSql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, postStaffNexusQuery));
      }
      if (ToolUtil.isNullEntityAllFieldValue(postStaffNexusQuery)) {
        return this.queryCount(countSql, Long.class);
      } else {
        return this.queryCount(countSql, postStaffNexusQuery, Long.class);
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public PostStaffNexus getPostStaffNexusByPk(String nexusId) throws Exception {
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
      Collection<PostStaffNexus> postStaffNexusSet = this.query(querySql, mapSqlParameterSource, PostStaffNexus.class);
      return ToolUtil.isNotEmpty(postStaffNexusSet) ? postStaffNexusSet.iterator().next() : null;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<PostStaffNexus> getAllPostStaffNexus() throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
    }
    try {
      StringBuilder querySql = new StringBuilder(SELECT_SQL);
      querySql.append(this.getSortSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS));
      return this.query(querySql, PostStaffNexus.class);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<PostStaffNexus> queryPostStaffNexus(PostStaffNexusQuery postStaffNexusQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + postStaffNexusQuery);
    }
    try {
      StringBuilder querySql = new StringBuilder(SELECT_SQL);
      if (!ToolUtil.isNullEntityAllFieldValue(postStaffNexusQuery)) {
        this.getExistsSql(postStaffNexusQuery);
        querySql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, postStaffNexusQuery));
      }
      querySql.append(this.getSortSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS));
      if (ToolUtil.isNullEntityAllFieldValue(postStaffNexusQuery)) {
        return this.query(querySql, PostStaffNexus.class);
      } else {
        return this.query(querySql, postStaffNexusQuery, PostStaffNexus.class);
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Paging<PostStaffNexus> pagingQueryPostStaffNexus(Param param, PostStaffNexusQuery postStaffNexusQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + postStaffNexusQuery);
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
      Paging<PostStaffNexus> paging = new Paging<>(param);
      StringBuilder countSql = new StringBuilder(COUNT_SQL);
      if (!ToolUtil.isNullEntityAllFieldValue(postStaffNexusQuery)) {
        this.getExistsSql(postStaffNexusQuery);
        countSql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, postStaffNexusQuery));
      }
      Long count = null;
      if (ToolUtil.isNullEntityAllFieldValue(postStaffNexusQuery)) {
        count = this.queryCount(countSql, Long.class);
      } else {
        count = this.queryCount(countSql, postStaffNexusQuery, Long.class);
      }
      paging.setCount(count);
      if (count > 0) {
        StringBuilder querySql = new StringBuilder(this.getPagingSql(TABLE_NAME, COLUMNS_PARAMETER, PRIMARY_KEY, TABLE_ALIAS));
        if (!ToolUtil.isNullEntityAllFieldValue(postStaffNexusQuery)) {
          querySql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, postStaffNexusQuery));
        }
        querySql.append(this.getPagingSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS, paging));
        Collection<PostStaffNexus> postStaffNexusSet = null;
        if (ToolUtil.isNullEntityAllFieldValue(postStaffNexusQuery)) {
          postStaffNexusSet = this.query(querySql, PostStaffNexus.class);
        } else {
          postStaffNexusSet = this.query(querySql, postStaffNexusQuery, PostStaffNexus.class);
        }
        if (ToolUtil.isNotEmpty(postStaffNexusSet)) {
          Set<String> inNexusId = new LinkedHashSet<>();
          for (PostStaffNexus postStaffNexus : postStaffNexusSet) {
            inNexusId.add(postStaffNexus.getNexusId());
          }
          PostStaffNexusQuery rPostStaffNexusQuery = new PostStaffNexusQuery();
          rPostStaffNexusQuery.setNexusIdAndin(new ArrayList<>(inNexusId));
          Collection<PostStaffNexus> rPostStaffNexusSet = this.queryPostStaffNexus(rPostStaffNexusQuery);
          if (ToolUtil.isNotEmpty(rPostStaffNexusSet)) {
            paging.setData(rPostStaffNexusSet);
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
  public PostStaffNexusVO getPostStaffNexusVOByPk(String nexusId) throws Exception {
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
      Collection<PostStaffNexusVO> postStaffNexusVOSet = this.query(querySql, mapSqlParameterSource, PostStaffNexusVO.class);
      return ToolUtil.isNotEmpty(postStaffNexusVOSet) ? postStaffNexusVOSet.iterator().next() : null;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<PostStaffNexusVO> getAllPostStaffNexusVO() throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
    }
    try {
      StringBuilder querySql = new StringBuilder(SELECT_VO_SQL);
      querySql.append(this.getSortSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS));
      return this.query(querySql, PostStaffNexusVO.class);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<PostStaffNexusVO> queryPostStaffNexusVO(PostStaffNexusQuery postStaffNexusQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + postStaffNexusQuery);
    }
    try {
      StringBuilder querySql = new StringBuilder(SELECT_VO_SQL);
      if (!ToolUtil.isNullEntityAllFieldValue(postStaffNexusQuery)) {
        this.getExistsSql(postStaffNexusQuery);
        querySql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, postStaffNexusQuery));
      }
      querySql.append(this.getSortSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS));
      if (ToolUtil.isNullEntityAllFieldValue(postStaffNexusQuery)) {
        return this.query(querySql, PostStaffNexusVO.class);
      } else {
        return this.query(querySql, postStaffNexusQuery, PostStaffNexusVO.class);
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Paging<PostStaffNexusVO> pagingQueryPostStaffNexusVO(Param param, PostStaffNexusQuery postStaffNexusQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + postStaffNexusQuery);
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
      Paging<PostStaffNexusVO> paging = new Paging<>(param);
      StringBuilder countSql = new StringBuilder(COUNT_SQL);
      if (!ToolUtil.isNullEntityAllFieldValue(postStaffNexusQuery)) {
        this.getExistsSql(postStaffNexusQuery);
        countSql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, postStaffNexusQuery));
      }
      Long count = null;
      if (ToolUtil.isNullEntityAllFieldValue(postStaffNexusQuery)) {
        count = this.queryCount(countSql, Long.class);
      } else {
        count = this.queryCount(countSql, postStaffNexusQuery, Long.class);
      }
      paging.setCount(count);
      if (count > 0) {
        StringBuilder querySql = new StringBuilder(this.getPagingSql(TABLE_NAME, COLUMNS_PARAMETER, PRIMARY_KEY, TABLE_ALIAS));
        if (!ToolUtil.isNullEntityAllFieldValue(postStaffNexusQuery)) {
          querySql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, postStaffNexusQuery));
        }
        querySql.append(this.getPagingSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS, paging));
        Collection<PostStaffNexus> postStaffNexusSet = null;
        if (ToolUtil.isNullEntityAllFieldValue(postStaffNexusQuery)) {
          postStaffNexusSet = this.query(querySql, PostStaffNexus.class);
        } else {
          postStaffNexusSet = this.query(querySql, postStaffNexusQuery, PostStaffNexus.class);
        }
        if (ToolUtil.isNotEmpty(postStaffNexusSet)) {
          Set<String> inNexusId = new LinkedHashSet<>();
          for (PostStaffNexus postStaffNexus : postStaffNexusSet) {
            inNexusId.add(postStaffNexus.getNexusId());
          }
          PostStaffNexusQuery rPostStaffNexusQuery = new PostStaffNexusQuery();
          rPostStaffNexusQuery.setNexusIdAndin(new ArrayList<>(inNexusId));
          Collection<PostStaffNexusVO> rPostStaffNexusVOSet = this.queryPostStaffNexusVO(rPostStaffNexusQuery);
          if (ToolUtil.isNotEmpty(rPostStaffNexusVOSet)) {
            paging.setData(rPostStaffNexusVOSet);
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

  private void getExistsSql(PostStaffNexusQuery postStaffNexusQuery) throws Exception {
    try {
      if (ToolUtil.isNotNullStr(postStaffNexusQuery.getToolExists())) {
        if ("NEXUS".equals(postStaffNexusQuery.getToolExists().toUpperCase())) {
          postStaffNexusQuery.setToolExists("SELECT NEXUS_ID FROM NEXUS WHERE NEXUS_ID IS NOT NULL AND ID = " + TABLE_ALIAS + ".ID");
        } else {
          postStaffNexusQuery.setToolExists(null);
        }
      }
      if (ToolUtil.isNotNullStr(postStaffNexusQuery.getToolNotExists())) {
        if ("NEXUS".equals(postStaffNexusQuery.getToolNotExists().toUpperCase())) {
          postStaffNexusQuery.setToolNotExists("SELECT NEXUS_ID FROM NEXUS WHERE NEXUS_ID IS NOT NULL AND ID = " + TABLE_ALIAS + ".ID");
        } else {
          postStaffNexusQuery.setToolNotExists(null);
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
