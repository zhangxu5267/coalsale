package com.drzyl.table.css.service;

import java.util.Collection;

import com.drzyl.tool.util.Paging;
import com.drzyl.tool.util.Param;
import com.drzyl.table.css.entity.TableCss;
import com.drzyl.table.css.query.TableCssQuery;
import com.drzyl.table.css.vo.TableCssVO;

/**
 * 页面表格样式 服务接口
 */
public interface ITableCssService {

  /**
   * 保存 页面表格样式 信息
   */
  public TableCss saveTableCss(TableCss tableCss) throws Exception;

  /**
   * 批量保存 页面表格样式 信息
   */
  public Collection<TableCss> batchSaveTableCss(Collection<TableCss> tableCsss) throws Exception;

  /**
   * 修改 页面表格样式 信息
   */
  public TableCss updateTableCss(TableCss tableCss) throws Exception;

  /**
   * 批量修改 页面表格样式 信息
   */
  public Collection<TableCss> batchUpdateTableCss(Collection<TableCss> tableCsss) throws Exception;

  /**
   * 删除 页面表格样式 信息
   */
  public void removeTableCss(TableCss tableCss) throws Exception;

  /**
   * 批量删除 页面表格样式 信息
   */
  public void batchRemoveTableCss(Collection<TableCss> tableCsss) throws Exception;

  /**
   * 获取 页面表格样式 数据量
   */
  public Long getCountTableCss(TableCssQuery tableCssQuery) throws Exception;

  /**
   * 通过主键获取 页面表格样式 数据
   */
  public TableCss getTableCssByPk(String id) throws Exception;

  /**
   * 获取 页面表格样式 所有数据
   */
  public Collection<TableCss> getAllTableCss() throws Exception;

  /**
   * 查询 页面表格样式 数据
   */
  public Collection<TableCss> queryTableCss(TableCssQuery tableCssQuery) throws Exception;

  /**
   * 分页查询 页面表格样式 数据
   */
  public Paging<TableCss> pagingQueryTableCss(Param param, TableCssQuery tableCssQuery) throws Exception;

  /**
   * 通过主键获取 页面表格样式 展示数据
   */
  public TableCssVO getTableCssVOByPk(String id) throws Exception;

  /**
   * 获取 页面表格样式 所有展示数据
   */
  public Collection<TableCssVO> getAllTableCssVO() throws Exception;

  /**
   * 查询 页面表格样式 展示数据
   */
  public Collection<TableCssVO> queryTableCssVO(TableCssQuery tableCssQuery) throws Exception;

  /**
   * 分页查询 页面表格样式 展示数据
   */
  public Paging<TableCssVO> pagingQueryTableCssVO(Param param, TableCssQuery tableCssQuery) throws Exception;

}
