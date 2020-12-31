package cn.ekgc.ums.controller;

import cn.ekgc.ums.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;


@Controller("indexController")
public class IndexController extends BaseController {

	@GetMapping("/index")
	public String index(ModelMap map) throws Exception{
		return "index";
	}
}
