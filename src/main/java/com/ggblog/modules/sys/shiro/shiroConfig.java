package com.ggblog.modules.sys.shiro;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * shiro配置类
 * 
 * @author 44359
 *
 */
@Configuration
public class shiroConfig {
	
	@Value("${spring.redis.host}")
	private String host;
	@Value("${spring.redis.port}")
	private int port;
	
	@Bean
	public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		// 拦截器.
		Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
		// 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
		shiroFilterFactoryBean.setLoginUrl("/login");
		// 登录成功后要跳转的链接
		shiroFilterFactoryBean.setSuccessUrl("/index");
		// 未授权界面;
		shiroFilterFactoryBean.setUnauthorizedUrl("/403");
		// 配置不会被拦截的链接 顺序判断
		filterChainDefinitionMap.put("/ajaxLlogin", "anon");
		filterChainDefinitionMap.put("/main/**", "anon");
		filterChainDefinitionMap.put("/lib/**", "anon");
		//文章列表放行
		filterChainDefinitionMap.put("/blog/article/list/**", "anon");
		filterChainDefinitionMap.put("/blog/article/count/**", "anon");
		filterChainDefinitionMap.put("/blog/article/toutiao/**", "anon");
		filterChainDefinitionMap.put("/blog/article/crosImg/**", "anon");
		filterChainDefinitionMap.put("/blog/article/bing/**", "anon");
		
		filterChainDefinitionMap.put("/f/**", "anon");
		filterChainDefinitionMap.put("/upload/**", "anon");
		// 配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了
		filterChainDefinitionMap.put("/logout", "logout");
		// <!-- 过滤链定义，从上向下顺序执行，一般将/**放在最为下边 -->:这是一个坑呢，一不小心代码就不好使了;
		// <!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
		filterChainDefinitionMap.put("/**", "authc");

		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		return shiroFilterFactoryBean;
	}
	
	/**
     * 凭证匹配器
     * （由于我们的密码校验交给Shiro的SimpleAuthenticationInfo进行处理了
     * ）
     *
     * @return
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5");//散列算法:这里使用MD5算法;
        hashedCredentialsMatcher.setHashIterations(1024);//散列的次数，比如散列两次，相当于 md5(md5(""));
        return hashedCredentialsMatcher;
    }

	/**
	 * 自定义realm
	 * 
	 * @return
	 */
	@Bean
	public UserRealm myShiroRealm() {
		UserRealm myShiroRealm = new UserRealm();
		myShiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
		return myShiroRealm;
	}

	/**
	 * 安全管理器
	 * 
	 * @return
	 */
	@Bean
	public SecurityManager securityManager() {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		// 设置realm.
		securityManager.setRealm(myShiroRealm());
		// 自定义缓存实现 使用redis
		securityManager.setCacheManager(cacheManager());
		// 自定义session管理 使用redis
		securityManager.setSessionManager(SessionManager());
		//设置记住我rememberMe
		securityManager.setRememberMeManager(rememberMeManager());
		return securityManager;
	}
	
	/**
	 * 配置shiro redisManager
	 * 
	 * @return
	 */
	public RedisManager redisManager() {
		RedisManager redisManager = new RedisManager();
		redisManager.setHost(host);
		redisManager.setPort(port);
		redisManager.setExpire(1800);// 配置过期时间
		// redisManager.setTimeout(timeout);
		// redisManager.setPassword(password);
		return redisManager;
	}
	/**
	 * cacheManager 缓存 redis实现
	 * 
	 * @return
	 */
	public RedisCacheManager cacheManager() {
		RedisCacheManager redisCacheManager = new RedisCacheManager();
		redisCacheManager.setRedisManager(redisManager());
		return redisCacheManager;
	}
	
	/**
	 * RedisSessionDAO shiro sessionDao层的实现 通过redis
	 */
	public RedisSessionDAO redisSessionDAO() {
		RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
		redisSessionDAO.setRedisManager(redisManager());
		return redisSessionDAO;
	}

	/**
	 * shiro session的管理
	 */
	public DefaultWebSessionManager SessionManager() {
		DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
		sessionManager.setSessionDAO(redisSessionDAO());
		return sessionManager;
	}
	
	
	/**
	 * cookie对象;
	 * @return
	 */
	public SimpleCookie rememberMeCookie(){
	   //这个参数是cookie的名称，对应前端的checkbox的name = rememberMe
	   SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
	   //<!-- 记住我cookie生效时间30天 ,单位秒;-->
	   simpleCookie.setMaxAge(2592000);
	   return simpleCookie;
	}
	
	
	
	/**
	 * cookie管理对象;记住我功能
	 * @return
	 */
	public CookieRememberMeManager rememberMeManager(){
	   CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
	   cookieRememberMeManager.setCookie(rememberMeCookie());
	   //rememberMe cookie加密的密钥 建议每个项目都不一样 默认AES算法 密钥长度(128 256 512 位)
	   cookieRememberMeManager.setCipherKey(Base64.decode("3AvVhmFLUs0KTA3Kprsdag=="));
	   return cookieRememberMeManager;
	}
	
	
	/**
	 * 开启shiro aop注解支持. 使用代理方式;所以需要开启代码支持;
	 * 
	 * @param securityManager
	 * @return
	 */
	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
		AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
		authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
		return authorizationAttributeSourceAdvisor;
	}

}
