package com.drzyl.cus.vo;

import com.drzyl.cus.entity.*;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * 前台传送数据模型
 */
@Data
public class CusVO {
	@NotNull(message = "基础信息不能为空")
	@Valid
	private CusBase cusBase;// 基础信息
	private CusBaseInfo cusBaseInfo ;// 详细信息
	private LinkedList<CusAgent> cusAgents;// 委托人信息
	private LinkedList<CusAddrDis> cusAddrDis;// 收货单位
	private LinkedList<CusAddress> cusAddress;// 收货地址
	private LinkedList<CusTagTemp> CusTagTemps;// 客户与客户标签多对多关系
	private LinkedList<CusTag> CusTags;// 该客户的客户标签

}
