package com.drzyl.dict.service.impl;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.drzyl.tool.exception.ToolException;
import com.drzyl.tool.util.Paging;
import com.drzyl.tool.util.Param;
import com.drzyl.tool.util.ToolUtil;
import com.drzyl.dict.entity.Dict;
import com.drzyl.dict.persistent.IDictPersistent;
import com.drzyl.dict.query.DictQuery;
import com.drzyl.dict.service.IDictService;
import com.drzyl.dict.vo.DictVO;
import lombok.extern.log4j.Log4j2;

/**
 * 数据字典 服务实现
 */
@Log4j2
@Service("com.drzyl.dict.DictService")
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true, rollbackFor = Exception.class)
public class DictServiceImpl implements IDictService {

  public static final String LOG = "DictService";

  @Resource(name = "com.drzyl.dict.DictPersistent")
  private IDictPersistent dictPersistent;

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public Dict saveDict(Dict dict) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + dict);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(dict)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      dict.setDictId(ToolUtil.getUUID());
      return dictPersistent.saveDict(dict);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public Collection<Dict> batchSaveDict(Collection<Dict> dicts) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + dicts);
    }
    try {
      if (ToolUtil.isEmpty(dicts)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      for (Dict dict : dicts) {
        if (ToolUtil.isNullEntityAllFieldValue(dict)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        dict.setDictId(ToolUtil.getUUID());
      }
      return dictPersistent.batchSaveDict(dicts);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public Dict updateDict(Dict dict) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + dict);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(dict)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      if (ToolUtil.isNullStr(dict.getDictId())) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      Dict oldDict = dictPersistent.getDictByPk(dict.getDictId());
      if (ToolUtil.isNullEntityAllFieldValue(oldDict)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return dictPersistent.updateDict(dict);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public Collection<Dict> batchUpdateDict(Collection<Dict> dicts) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + dicts);
    }
    try {
      if (ToolUtil.isEmpty(dicts)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      for (Dict dict : dicts) {
        if (ToolUtil.isNullEntityAllFieldValue(dict)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        if (ToolUtil.isNullStr(dict.getDictId())) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        Dict oldDict = dictPersistent.getDictByPk(dict.getDictId());
        if (ToolUtil.isNullEntityAllFieldValue(oldDict)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
      }
      return dictPersistent.batchUpdateDict(dicts);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public void removeDict(Dict dict) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + dict);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(dict)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      Set<Dict> dictSet = new LinkedHashSet<>();
      if (ToolUtil.isNullStr(dict.getDictId())) {
        DictQuery dictQuery = new DictQuery();
        BeanUtils.copyProperties(dict, dictQuery);
        dictSet.addAll(dictPersistent.queryDict(dictQuery));
      } else {
        Dict oldDict = dictPersistent.getDictByPk(dict.getDictId());
        if (ToolUtil.isNullEntityAllFieldValue(oldDict)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        dictSet.add(oldDict);
      }
      if (ToolUtil.isNotEmpty(dictSet)) {
        dictPersistent.batchRemoveDict(dictSet);
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public void batchRemoveDict(Collection<Dict> dicts) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + dicts);
    }
    try {
      if (ToolUtil.isEmpty(dicts)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      Set<Dict> dictSet = new LinkedHashSet<>();
      for (Dict dict : dicts) {
        if (ToolUtil.isNullEntityAllFieldValue(dict)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        if (ToolUtil.isNullStr(dict.getDictId())) {
          DictQuery dictQuery = new DictQuery();
          BeanUtils.copyProperties(dict, dictQuery);
          dictSet.addAll(dictPersistent.queryDict(dictQuery));
        } else {
          Dict oldDict = dictPersistent.getDictByPk(dict.getDictId());
          if (ToolUtil.isNullEntityAllFieldValue(oldDict)) {
            throw new ToolException(ToolException.E_PARAM_ERR);
          }
          dictSet.add(oldDict);
        }
      }
      if (ToolUtil.isNotEmpty(dictSet)) {
        dictPersistent.batchRemoveDict(dictSet);
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Long getCountDict(DictQuery dictQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + dictQuery);
    }
    try {
      return dictPersistent.getCountDict(dictQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Dict getDictByPk(String dictId) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + dictId);
    }
    try {
      if (ToolUtil.isNullStr(dictId)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return dictPersistent.getDictByPk(dictId);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<Dict> getAllDict() throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
    }
    try {
      return dictPersistent.getAllDict();
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<Dict> queryDict(DictQuery dictQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + dictQuery);
    }
    try {
      return dictPersistent.queryDict(dictQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Paging<Dict> pagingQueryDict(Param param, DictQuery dictQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + dictQuery);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(param)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return dictPersistent.pagingQueryDict(param, dictQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public DictVO getDictVOByPk(String dictId) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + dictId);
    }
    try {
      if (ToolUtil.isNullStr(dictId)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return dictPersistent.getDictVOByPk(dictId);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<DictVO> getAllDictVO() throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
    }
    try {
      return dictPersistent.getAllDictVO();
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<DictVO> queryDictVO(DictQuery dictQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + dictQuery);
    }
    try {
      return dictPersistent.queryDictVO(dictQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Paging<DictVO> pagingQueryDictVO(Param param, DictQuery dictQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + dictQuery);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(param)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return dictPersistent.pagingQueryDictVO(param, dictQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

}
