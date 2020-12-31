package cn.ekgc.ums.base.entity;

import java.io.Serializable;
import java.util.Date;

//基础实体信息
public class BaseEntity implements Serializable {
	private static final long serialVersionUID = -5738198004114255237L;
	private Integer begin;
	private Integer size;
	private Integer status;
	private Date createTime;
	private Date updateTime;

	public Integer getBegin() {
		return begin;
	}

	public void setBegin(Integer begin) {
		this.begin = begin;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}
