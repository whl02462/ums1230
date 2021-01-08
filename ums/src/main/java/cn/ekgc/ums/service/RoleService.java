package cn.ekgc.ums.service;

import cn.ekgc.ums.pojo.entity.Role;

import java.util.List;

public interface RoleService {

	List<Role> getRoleListByQuery(Role query) throws Exception;
}
