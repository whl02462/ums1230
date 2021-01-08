package cn.ekgc.ums.service.impl;

import cn.ekgc.ums.dao.UserDao;
import cn.ekgc.ums.pojo.entity.User;
import cn.ekgc.ums.pojo.vo.PageVO;
import cn.ekgc.ums.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;


	@Override
	public User getUserByCellphone(String cellphone) throws Exception {
		//封装查询对象
		User query = new User();
		query.setCellphone(cellphone);
		//开始查询
		List<User> userList = userDao.findListByQuery(query);
		if (userList != null && !userList.isEmpty()){
			return userList.get(0);
		}
		return null;
	}


	@Override
	public PageVO<User> getListByQueryAndPage(User query, PageVO<User> pageVO) throws Exception {
		//计算begin和size
		query.setBegin((pageVO.getPageNum()-1)*pageVO.getPageSize());
		query.setSize(pageVO.getPageSize());
		//分页查询
		List<User> userList = userDao.findListByQuery(query);
		//不分页查询所有信息
		query.setBegin(null);
		query.setSize(null);
		Long totalCount = (long)userDao.findListByQuery(query).size();
		//计算总页数
		Integer totalPage = (int) ((totalCount % pageVO.getPageSize() == 0 )? (totalCount / pageVO.getPageSize())
				: (totalCount / pageVO.getPageSize() + 1));

		pageVO.setList(userList);
		pageVO.setTotalCount(totalCount);
		pageVO.setTotalPage(totalPage);
		return pageVO;
	}


	@Override
	public boolean saveUser(User user) throws Exception {
		Integer count = userDao.save(user);
		if (count != null && count > 0 ){
			return true;
		}
		return false;
	}
}
