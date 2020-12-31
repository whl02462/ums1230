package cn.ekgc.ums.pojo.entity;

import cn.ekgc.ums.base.entity.BaseEntity;


import java.util.Date;
//角色信息实体类
public class Role extends BaseEntity {

	private static final long serialVersionUID = 7566628673467812998L;
	private Long id;
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
