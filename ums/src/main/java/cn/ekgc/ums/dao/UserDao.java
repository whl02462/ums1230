package cn.ekgc.ums.dao;

import cn.ekgc.ums.pojo.entity.User;

import java.util.List;

public interface UserDao {
	//查询所有
	List<User> findListByQuery(User query) throws Exception;
	//保存
	Integer save(User entity) throws Exception;
	//修改
	Integer update(User entity) throws Exception;
}
