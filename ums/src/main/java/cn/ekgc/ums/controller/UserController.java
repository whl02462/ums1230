package cn.ekgc.ums.controller;

import cn.ekgc.ums.base.controller.BaseController;
import cn.ekgc.ums.pojo.entity.User;
import cn.ekgc.ums.pojo.vo.PageVO;
import cn.ekgc.ums.service.UserService;
import cn.ekgc.ums.util.ConstantUtil;
import cn.ekgc.ums.util.MD5Util;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;


@Controller("userController")
@RequestMapping("/user")
public class UserController extends BaseController {
	@Resource(name = "userService")
	private UserService userService;

	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public String forwardLoginPage() throws Exception {
		return "user/user_login";
	}

	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public String loginUser(String cellphone,String password)throws Exception{
		//判断用户提交的cellphone和password是否有效
		if (cellphone != null && !"".equals(cellphone.trim())
		&& password != null && !"".equals(password.trim())){
			//有效
			//通过cellphone查询用户信息
			User user = userService.getUserByCellphone(cellphone);
			if (user != null && user.getStatus().equals(ConstantUtil.STATUS_ENABLE)){
				//密码加密
				password = MD5Util.encrypt(password);
				if (user.getPassword().equals(password)){
					//登录成功
					session.setAttribute("user",user);
					//重定向到首页面
					return "redirect:/index";
				}
			}
}
		return "redirect:login";
	}

	//分页加载用户列表
	@RequestMapping(value = "/index",method = RequestMethod.GET)
	public String index(Integer pageNum, Integer pageSize, User query, ModelMap map)throws Exception{
		PageVO<User> pageVO = new PageVO<User>(pageNum,pageSize);
		//进行分页查询
		pageVO = userService.getListByQueryAndPage(query,pageVO);
		//绑定到ModelMap中，进行转发
		map.put("pageVO",pageVO);
		return "user/user_index";
	}

}
