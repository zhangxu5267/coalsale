package com.drzyl.sign.service.impl;

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
import com.drzyl.sign.entity.Account;
import com.drzyl.sign.persistent.IAccountPersistent;
import com.drzyl.sign.query.AccountQuery;
import com.drzyl.sign.service.IAccountService;
import com.drzyl.sign.vo.AccountVO;
import lombok.extern.log4j.Log4j2;

/**
 * 账号 服务实现
 */
@Log4j2
@Service("com.drzyl.sign.AccountService")
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true, rollbackFor = Exception.class)
public class AccountServiceImpl implements IAccountService {

  public static final String LOG = "AccountService";

  @Resource(name = "com.drzyl.sign.AccountPersistent")
  private IAccountPersistent accountPersistent;

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public Account saveAccount(Account account) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + account);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(account)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      account.setAccountId(ToolUtil.getUUID());
      return accountPersistent.saveAccount(account);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public Collection<Account> batchSaveAccount(Collection<Account> accounts) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + accounts);
    }
    try {
      if (ToolUtil.isEmpty(accounts)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      for (Account account : accounts) {
        if (ToolUtil.isNullEntityAllFieldValue(account)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        account.setAccountId(ToolUtil.getUUID());
      }
      return accountPersistent.batchSaveAccount(accounts);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public Account updateAccount(Account account) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + account);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(account)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      if (ToolUtil.isNullStr(account.getAccountId())) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      Account oldAccount = accountPersistent.getAccountByPk(account.getAccountId());
      if (ToolUtil.isNullEntityAllFieldValue(oldAccount)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return accountPersistent.updateAccount(account);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public Collection<Account> batchUpdateAccount(Collection<Account> accounts) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + accounts);
    }
    try {
      if (ToolUtil.isEmpty(accounts)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      for (Account account : accounts) {
        if (ToolUtil.isNullEntityAllFieldValue(account)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        if (ToolUtil.isNullStr(account.getAccountId())) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        Account oldAccount = accountPersistent.getAccountByPk(account.getAccountId());
        if (ToolUtil.isNullEntityAllFieldValue(oldAccount)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
      }
      return accountPersistent.batchUpdateAccount(accounts);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public void removeAccount(Account account) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + account);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(account)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      Set<Account> accountSet = new LinkedHashSet<>();
      if (ToolUtil.isNullStr(account.getAccountId())) {
        AccountQuery accountQuery = new AccountQuery();
        BeanUtils.copyProperties(account, accountQuery);
        accountSet.addAll(accountPersistent.queryAccount(accountQuery));
      } else {
        Account oldAccount = accountPersistent.getAccountByPk(account.getAccountId());
        if (ToolUtil.isNullEntityAllFieldValue(oldAccount)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        accountSet.add(oldAccount);
      }
      if (ToolUtil.isNotEmpty(accountSet)) {
        accountPersistent.batchRemoveAccount(accountSet);
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
  public void batchRemoveAccount(Collection<Account> accounts) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + accounts);
    }
    try {
      if (ToolUtil.isEmpty(accounts)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      Set<Account> accountSet = new LinkedHashSet<>();
      for (Account account : accounts) {
        if (ToolUtil.isNullEntityAllFieldValue(account)) {
          throw new ToolException(ToolException.E_PARAM_ERR);
        }
        if (ToolUtil.isNullStr(account.getAccountId())) {
          AccountQuery accountQuery = new AccountQuery();
          BeanUtils.copyProperties(account, accountQuery);
          accountSet.addAll(accountPersistent.queryAccount(accountQuery));
        } else {
          Account oldAccount = accountPersistent.getAccountByPk(account.getAccountId());
          if (ToolUtil.isNullEntityAllFieldValue(oldAccount)) {
            throw new ToolException(ToolException.E_PARAM_ERR);
          }
          accountSet.add(oldAccount);
        }
      }
      if (ToolUtil.isNotEmpty(accountSet)) {
        accountPersistent.batchRemoveAccount(accountSet);
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Long getCountAccount(AccountQuery accountQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + accountQuery);
    }
    try {
      return accountPersistent.getCountAccount(accountQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Account getAccountByPk(String accountId) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + accountId);
    }
    try {
      if (ToolUtil.isNullStr(accountId)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return accountPersistent.getAccountByPk(accountId);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<Account> getAllAccount() throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
    }
    try {
      return accountPersistent.getAllAccount();
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<Account> queryAccount(AccountQuery accountQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + accountQuery);
    }
    try {
      return accountPersistent.queryAccount(accountQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Paging<Account> pagingQueryAccount(Param param, AccountQuery accountQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + accountQuery);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(param)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return accountPersistent.pagingQueryAccount(param, accountQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public AccountVO getAccountVOByPk(String accountId) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + accountId);
    }
    try {
      if (ToolUtil.isNullStr(accountId)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return accountPersistent.getAccountVOByPk(accountId);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<AccountVO> getAllAccountVO() throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
    }
    try {
      return accountPersistent.getAllAccountVO();
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Collection<AccountVO> queryAccountVO(AccountQuery accountQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + accountQuery);
    }
    try {
      return accountPersistent.queryAccountVO(accountQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

  @Override
  public Paging<AccountVO> pagingQueryAccountVO(Param param, AccountQuery accountQuery) throws Exception {
    if (log.isDebugEnabled()) {
      log.debug(ToolUtil.getLog(LOG));
      log.debug(ToolUtil.LOG + param);
      log.debug(ToolUtil.LOG + accountQuery);
    }
    try {
      if (ToolUtil.isNullEntityAllFieldValue(param)) {
        throw new ToolException(ToolException.E_PARAM_ERR);
      }
      return accountPersistent.pagingQueryAccountVO(param, accountQuery);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw e;
    }
  }

}
