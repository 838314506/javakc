package com.zhg.javakc.base.util;

import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.zhg.javakc.modules.system.user.entity.UserEntity;

/**
 * 項目工具類
 * @author zhou
 * @version v0.1
 */
public class CommonUtil {
	
	/**
	 * 獲取32位uuid
	 * @return
	 */
	public static String uuid()
	{
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	/**
	 * 驗證當前對象不為空
	 * 為空: 返回false
	 * 不為空: 返回true
	 * @param obj
	 * @return
	 */
	public static boolean isNotNull(Object obj)
	{
		if(null == obj || "".equals(obj))
		{
			return false;
		}
		return true;
	}
	
	/**
	 * 驗證字符串是否為空
	 * 為空: 返回false
	 * 不為空: 返回true
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str)
	{
		if(null != str && !"".equals(str))
		{
			return true;
		}
		return false;
	}
	/**
	 * 获取数据字典中的数据
	 */
	public static Map<String,Object> getDictionary(HttpServletRequest request,String codeTp)
	{
		Map<String,Object> map = (Map<String,Object>)request.getServletContext().getAttribute("tagData");
		Object o=map.get(codeTp);
		return (Map<String, Object>)o;
	}
	/**
	 * 使用shiro提供，可以从session中得到当前用户，好处可以不依赖于request环境
	 */
	public static UserEntity getUserEntity() 
	{
		Subject subject = SecurityUtils.getSubject();
		return (UserEntity)subject.getSession().getAttribute("user");
	}
	/**
	 * 处理职级方法
	 * @param value
	 * @return
	 */
	public static int getGrade(String value) 
	{
		int grade = 0;
		if("军级".equals(value)) { grade = 1; }
		
		if("副军级".equals(value)) { grade = 2; }
		
		if("处级".equals(value)) { grade = 3; }
		
		if("副处级".equals(value)) { grade = 4; }
		
		if("团级".equals(value)) { grade = 5; }
		
		if("副团级".equals(value)) { grade = 6; }
		
		return grade;
	}
}
