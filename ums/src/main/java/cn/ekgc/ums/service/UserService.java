package cn.ekgc.ums.service;

import cn.ekgc.ums.pojo.entity.User;
import cn.ekgc.ums.pojo.vo.PageVO;

public interface UserService {
	//根据手机号码查询用户信息
	User getUserByCellphone(String cellphone) throws Exception;
	//分页查询列表
	PageVO<User> getListByQueryAndPage(User query, PageVO<User> pageVO) throws Exception;
}
