package cn.ekgc.ums.service.impl;

import cn.ekgc.ums.dao.RoleDao;
import cn.ekgc.ums.pojo.entity.Role;
import cn.ekgc.ums.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleDao roleDao;

	@Override
	public List<Role> getRoleListByQuery(Role query) throws Exception {
		return roleDao.findListByQuery(query);
	}
}
