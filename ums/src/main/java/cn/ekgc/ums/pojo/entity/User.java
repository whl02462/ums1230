package cn.ekgc.ums.pojo.entity;

import cn.ekgc.ums.base.entity.BaseEntity;


import java.util.Date;
//用户信息实体类
public class User extends BaseEntity {

	private static final long serialVersionUID = -7345725414253670892L;
	private Long id;
	private String name;
	private String cellphone;
	private String password;
	private Role role;

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

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
