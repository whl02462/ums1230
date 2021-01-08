package cn.ekgc.ums.controller;

import cn.ekgc.ums.base.controller.BaseController;
import cn.ekgc.ums.pojo.entity.Role;
import cn.ekgc.ums.pojo.entity.User;
import cn.ekgc.ums.pojo.vo.PageVO;
import cn.ekgc.ums.service.RoleService;
import cn.ekgc.ums.service.UserService;
import cn.ekgc.ums.util.ConstantUtil;
import cn.ekgc.ums.util.MD5Util;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;


@Controller("userController")
@RequestMapping("/user")
public class UserController extends BaseController {

	@Resource(name = "userService")
	private UserService userService;
	@Resource(name = "roleService")
	private RoleService roleService;

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


	//加载添加页面
	@RequestMapping(value = "/save/{code}",method = RequestMethod.GET)
	public String forwardSavePage(@PathVariable("code") Integer code, ModelMap map) throws Exception {
		if (code == 1) {
			//点击的是添加按钮
			//查询所有角色信息
			Role query = new Role();
			query.setStatus(ConstantUtil.STATUS_ENABLE);
			List<Role> roleList = roleService.getRoleListByQuery(query);
			map.put("roleList", roleList);
			return "user/user_save";
		} else {
			//点击的是注册按钮
			return "user/user_register";
		}
	}


	//异步校验手机号码
	@RequestMapping(value = "/cellphone",method = RequestMethod.POST)
	@ResponseBody
	public boolean isCellphoneCanUse(String cellphone,Long id) throws Exception{
		User user = userService.getUserByCellphone(cellphone);
		if (user == null) {
			return true;
		}else{
			if (user.getId().equals(id)) {
				return true;
			}
		}
		return false;
	}


	//保存用户信息
	@RequestMapping(value = "/save",method = RequestMethod.POST)
	@ResponseBody
	public boolean saveUser(User user, Long roleId) throws Exception{
		Role role = new Role();
		role.setId(roleId);
		user.setRole(role);
		return userService.saveUser(user);
	}



}
