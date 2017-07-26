package cn.itcast.ssm.controller.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;



/**
 *
 * <p>Title: HandlerInterceptor1</p>
 * <p>Description: 测试拦截器1</p>
 * <p>Company: www.itcast.com</p>
 * @author	传智.燕青
 * @date	2015-3-22下午4:11:44
 * @version 1.0
 */
public class HandlerInterceptor1 implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}
	/*@Resource
	private UserService userService;
	//在执行handler之前来执行的
	//用于用户认证校验、用户权限校验
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		if ("GET".equalsIgnoreCase(request.getMethod())) {
    		RequestUtil.saveRequest();
        }

        //log.info("==============执行拦截: preHandle================");
		String requestUri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String url = requestUri.substring(contextPath.length());

		//这里对拉入黑名单的ip进行处理【扩展】
	//	log.info("来自 >>>>>>"+RequestUtil.getIpAddr(request)+" 请求访问。");
        User user =  (User)request.getSession().getAttribute(Const.SESSION_USER);
        // 判断用户是否登录，一般是都没登录的
        if(user == null){
        	// 取cookie值，这里还有其他网站的,  // 下面是找到本项目的cookie
        	Cookie[] cookies = request.getCookies();
        	if(cookies!=null && cookies.length>0){
	  			  String cookieValue = null;
	  			  for (int i = 0; i < cookies.length; i++) {
	  				  if(Const.COOKIEDOMAINNAME.equals(cookies[i].getName())){
	  					  cookieValue = cookies[i].getValue();
	  					  break;
	  				  }
	  			  }
	    // 如果cookieValue为空说明用户上次没有选择“记住下次登录”执行其他
	  			  if(cookieValue==null){
	  				  if (url.contains("login")){
	  					  return true;
	  				  }
	  				  request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
		  	          return false;
	  			  }else{
	  				  // 先得到的CookieValue进行Base64解码
	  				  //String cookieValueAfterDecode = new String(base64.decode(cookieValue),"UTF-8");
	  				  String cookieValueAfterDecode = new String(Base64.decodeBase64(cookieValue),"UTF-8");
	  				  // 对解码后的值进行分拆,得到一个数组,如果数组长度不为3,就是非法登陆
	  				  String cookieValues[] = cookieValueAfterDecode.split(":");
	  				  if(cookieValues.length!=3){
	  					  request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
	  		        	  return false;
	  				  }
	  				  // 判断是否在有效期内,过期就删除Cookie
	  				  long validTimeInCookie = new Long(cookieValues[1]);
	  				  if (validTimeInCookie < System.currentTimeMillis()) {
	  					  // 删除Cookie
	  					  UserCookieUtil.clearCookie(response);
	  					  request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
	  		        	  return false;
	  				  }
	  				  // 取出cookie中的用户名,并到数据库中检查这个用户名,
	  				  String userName = cookieValues[0];
	  				 User user1 = userService.findUserByName(userName);
	  				  // 如果user返回不为空,就取出密码,使用用户名(userName)+密码+有效时间+ webSiteKey进行MD5加密。与前面设置的进行比较，看是否是同一个用户
	  				  if(user1!=null){
	  					  String md5ValueInCookie = cookieValues[2];
	  					  String md5ValueFromUser = MD5.md5crypt(user1.getUserName() + ":" + user1.getUserPsd() + ":" + validTimeInCookie + ":" + Const.COOKIEDOMAINNAME);
	  					  // 将结果与Cookie中的MD5码相比较,如果相同,写入Session,自动登陆成功,并继续用户请求
	  					  if (md5ValueFromUser.equals(md5ValueInCookie)) {
	  						  request.getSession().setAttribute(Const.SESSION_USER, user1);
	  						  request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);
	  			        	  return false;
	  					  }
	  				  }
  			      }
  		     }else{
  		    	if (url.contains("login")){
				    return true;
			    }
  		    	request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
  	            return false;
  		    }
        }
        return true;
    }
	//在执行handler返回modelAndView之前来执行
	//如果需要向页面提供一些公用 的数据或配置一些视图信息，使用此方法实现 从modelAndView入手
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("HandlerInterceptor1...postHandle");
	}
	//执行handler之后执行此方法
	//作系统 统一异常处理，进行方法执行性能监控，在preHandle中设置一个时间点，在afterCompletion设置一个时间，两个时间点的差就是执行时长
	//实现 系统 统一日志记录
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("HandlerInterceptor1...afterCompletion");
	}
*/
}
