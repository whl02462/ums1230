package cn.ekgc.ums.dao;

import cn.ekgc.ums.pojo.entity.Role;

import java.util.List;

public interface RoleDao {
	//查询所有
	List<Role> findListByQuery(Role query) throws Exception;
	//保存
	Integer save(Role entity) throws Exception;
	//修改
	Integer update(Role entity) throws Exception;
}
