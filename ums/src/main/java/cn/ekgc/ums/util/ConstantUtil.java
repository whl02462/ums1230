package cn.ekgc.ums.util;


import java.util.Properties;

//系统常量工具类
public class ConstantUtil {
	private static Properties props = new Properties();

	static {
		try {
			props.load(ConstantUtil.class.getClassLoader().getResourceAsStream("system.properties"));
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	//分页信息：当前页码
	public static final Integer PAGE_NUM = Integer.parseInt(props.getProperty("page.num"));
	//分页信息：每页显示数量
	public static final Integer PAGE_SIZE = Integer.parseInt(props.getProperty("page.size"));
	//系统状态：启用状态
	public static final Integer STATUS_ENABLE = Integer.parseInt(props.getProperty("status.enable"));
	//系统状态：关闭状态
	public static final Integer STATUS_DISABLE = Integer.parseInt(props.getProperty("status.disable"));

}



















