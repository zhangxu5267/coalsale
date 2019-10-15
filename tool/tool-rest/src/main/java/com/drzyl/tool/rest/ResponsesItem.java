package com.drzyl.tool.rest;

import com.drzyl.tool.context.ToolContextData;
import com.drzyl.tool.util.Paging;
import com.drzyl.tool.util.Param;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * 返回请求数据
 */
@Data
public class ResponsesItem<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	private boolean success;

	private String msg;

	private Collection<T> data;

	public ResponsesItem() {
		super();
		this.success = true;
		this.msg = "";
		this.data = Collections.emptyList();
	}

	public ResponsesItem(Param param) {
		super();
		this.success = true;
		this.msg = "";
		this.data = Collections.emptyList();
	}

	public void setData(Collection<T> data) {
		this.data = data;
	}

	public void setData(T data) {
		this.data = new ArrayList<T>();
		this.data.add(data);
	}

	public void setData(Paging<T> paging) {
		if (paging.getData() == null) {
			this.data = Collections.emptyList();
		} else {
			this.data = paging.getData();
		}
	}

	public final void setException(String errMsg) {
		success = false;
		this.msg = errMsg;
	}

	/**
	 * 操作失败
	 *
	 * @param msg 说明信息
	 * @return
	 */
	public ResponsesItem isDefeated(String msg) {
		this.success = false;
		this.msg = msg;
		return this;
	}

	/**
	 * 操作成功
	 *
	 * @param msg 说明信息
	 * @return
	 */
	public ResponsesItem isSuccess(String msg) {
		this.success = true;
		this.msg = msg;
		return this;
	}

}
